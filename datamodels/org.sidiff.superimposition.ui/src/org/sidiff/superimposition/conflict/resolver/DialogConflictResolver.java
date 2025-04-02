package org.sidiff.superimposition.conflict.resolver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.sidiff.entities.Attribute;
import org.sidiff.entities.Element;
import org.sidiff.entities.EntitiesFactory;
import org.sidiff.superimposition.Conflict;
import org.sidiff.superimposition.ConflictingEntities;
import org.sidiff.superimposition.SuperimposedElement;
import org.sidiff.superimposition.util.SuperimpositionModelModifyHelper;

/**
 * Conflict resolver that opens dialogs for
 * the user to resolve conflicts (when possible).
 * @author rmueller
 */
public class DialogConflictResolver extends AbstractConflictResolver {

	@Override
	public Diagnostic resolveConflict(Conflict conflict, IProgressMonitor monitor) {
		switch(conflict.getId()) {
			case "Ecore.EAttribute.LowerBound.Violated":
			case "Ecore.EReference.LowerBound.Violated":
				// TODO: let user choose from possible values
				//return Diagnostic.OK_INSTANCE;

			case "Ecore.EAttribute.UpperBound.Violated":
			case "Ecore.EReference.UpperBound.Violated":
				// TODO: let user choose some to throw away
				//return Diagnostic.OK_INSTANCE;

			case "Ecore.ENamedElement.Name.Duplicated":
				return showNameSelectionDialog(conflict, monitor);
		}
		throw new IllegalArgumentException("Unsupported conflict: " + conflict);
	}

	private static Diagnostic showNameSelectionDialog(Conflict conflict, IProgressMonitor monitor) {
		AtomicReference<Diagnostic> result = new AtomicReference<Diagnostic>();
		for(ConflictingEntities conflicting : conflict.getConflicting()) {
			Display.getDefault().syncExec(() -> {
				Dialog dialog = new NameSelectionDialog(Display.getDefault().getActiveShell(), conflicting);
				if(dialog.open() == Window.OK) {
					result.set(Diagnostic.OK_INSTANCE);
				} else {
					result.set(Diagnostic.CANCEL_INSTANCE);
				}
			});	
			if(result.get().getSeverity() == Diagnostic.CANCEL) {
				break;
			}
		}
		return result.get();
	}

	private static class NameSelectionDialog extends TitleAreaDialog {

		private final ConflictingEntities conflicting;
		private final Map<SuperimposedElement,String> names = new HashMap<>();
		
		protected NameSelectionDialog(Shell parentShell, ConflictingEntities conflicting) {
			super(parentShell);
			this.conflicting = conflicting;
			setBlockOnOpen(true);
			setHelpAvailable(false);
			initNames();
		}
		
		@Override
		public void create() {
			super.create();
			setTitle("Resolve duplicate element names");
			setMessage("Enter new element names in the right column.");
		}

		private void initNames() {
			for(Element element : conflicting.getElements()) {
				element.getAttributes().stream()
					.filter(attr -> "name".equalsIgnoreCase(attr.getType().getName()))
					.flatMap(attr -> attr.getValue().stream())
					.findFirst().ifPresent(value -> names.put((SuperimposedElement)element, value));
			}
		}

		@Override
		protected Control createDialogArea(Composite parent) {
			Composite body = (Composite)super.createDialogArea(parent);
			TableViewer viewer = new TableViewer(body, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL | SWT.FULL_SELECTION);

			TableViewerColumn colEntity = new TableViewerColumn(viewer, SWT.NONE);
			colEntity.getColumn().setText("Element");
			colEntity.getColumn().setWidth(400);
			colEntity.setLabelProvider(new ColumnLabelProvider() {
				@Override
				public String getText(Object element) {
					return ((Element)element).getSignature() + " / " + ((Element)element).getUuid();
				}
			});

			TableViewerColumn colName = new TableViewerColumn(viewer, SWT.NONE);
			colName.getColumn().setText("Name");
			colName.getColumn().setWidth(200);
			colName.setLabelProvider(new ColumnLabelProvider() {
				@Override
				public String getText(Object element) {
					return names.get(element);
				}
			});
			colName.setEditingSupport(new EditingSupport(colName.getViewer()) {
				@Override
				protected void setValue(Object element, Object value) {
					names.put((SuperimposedElement)element, (String)value);
					getViewer().update(element, null);
					validate();
				}
				@Override
				protected Object getValue(Object element) {
					return names.get(element);
				}
				@Override
				protected CellEditor getCellEditor(Object element) {
					return new TextCellEditor(viewer.getTable());
				}
				@Override
				protected boolean canEdit(Object element) {
					return true;
				}
			});

			viewer.getTable().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			viewer.setContentProvider(ArrayContentProvider.getInstance());
			viewer.setInput(conflicting.getElements().toArray());
			return body;
		}

		private void validate() {
			if(names.values().stream().distinct().count() == names.values().size()) {
				setErrorMessage(null);
			} else {
				setErrorMessage("Names are not unique.");
			}
		}

		@Override
		public int open() {
			int result = super.open();
			if(result == Window.OK) {
				applyNames();
			}
			return result;
		}

		private void applyNames() {
			SuperimpositionModelModifyHelper helper = new SuperimpositionModelModifyHelper(conflicting.getConflictSet().getContext());
			// go through all name attributes for all elements, remove all that don't have the new name
			for(Map.Entry<SuperimposedElement, String> entry : names.entrySet()) {
				SuperimposedElement element = entry.getKey();
				String chosenName = entry.getValue();
				Attribute pivotNameAttribute = null;
				Collection<Attribute> removedAttributes = new ArrayList<>();
				for(Attribute attr : element.getAttributes()) {
					if("name".equalsIgnoreCase(attr.getType().getName())) {
						if(pivotNameAttribute == null && attr.getValue().size() == 1 && chosenName.equals(attr.getValue().get(0))) {
							pivotNameAttribute = attr;
						} else {
							removedAttributes.add(attr);
						}
					}
				}
				// if no appropriate name attribute is found, create a new one
				if(pivotNameAttribute == null) {
					// use one of the removed ones as a template
					Attribute someAttribute = removedAttributes.stream().findFirst().orElseThrow(IllegalStateException::new);
					pivotNameAttribute = EntitiesFactory.eINSTANCE.createAttribute();
					pivotNameAttribute.setType(someAttribute.getType());
					pivotNameAttribute.setSignature(someAttribute.getSignature());
					pivotNameAttribute.getValue().add(chosenName);
					element.getAttributes().add(pivotNameAttribute);
					element.getOwnedAttributes().add(pivotNameAttribute);
				}
				EcoreUtil.deleteAll(removedAttributes, false);
				helper.collectModifiedSignatures(element);
			}
			helper.updateModifiedSignatures();
		}
	}
}
