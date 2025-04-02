package org.sidiff.superimposition.conflict.selector;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.edit.ui.provider.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.sidiff.superimposition.Conflict;
import org.sidiff.superimposition.ConflictSet;
import org.sidiff.superimposition.presentation.SuperimpositionModelEditorPlugin;
import org.sidiff.superimposition.provider.SuperimpositionModelEntitiesItemProviderAdapterFactory;
import org.sidiff.superimposition.provider.SuperimpositionModelItemProviderAdapterFactory;

/**
 * A conflict selector that displays a dialog for the user to
 * select the conflicts to resolve.
 * @author rmueller
 */
public class InteractiveConflictSelector implements IConflictSelector {

	@Override
	public List<Conflict> selectConflicts(ConflictSet conflictSet) {
		Set<Conflict> selectedConflicts = new LinkedHashSet<>();
		Display.getDefault().syncExec(() -> {
			ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
			adapterFactory.addAdapterFactory(new SuperimpositionModelItemProviderAdapterFactory());
			adapterFactory.addAdapterFactory(new SuperimpositionModelEntitiesItemProviderAdapterFactory());
			ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(Display.getDefault().getActiveShell(),
					new DelegatingStyledCellLabelProvider.ColorProvider(new ConflictSelectorLabelProvider(adapterFactory)),
					new ConflictSelectorContentProvider(adapterFactory));
			dialog.setTitle(conflictSet.getConflicts().size() + " Conflicts detected");
			dialog.setMessage("Select the conflicts to resolve and press OK, or cancel to stop resolving.");
			dialog.setComparator(new ViewerComparator());
			dialog.setInput(conflictSet);
			dialog.setAllowMultiple(true);
			dialog.setValidator(new ConflictSelectorSelectionValidator());
			dialog.setSize(150, 40);
			dialog.setHelpAvailable(false);
			if(dialog.open() == Window.OK) {
				for(Object obj : dialog.getResult()) {
					if(obj instanceof ConflictGroup) {
						Stream.of(((ConflictGroup)obj).conflicts).forEach(selectedConflicts::add);
					} else if(obj instanceof Conflict) {
						selectedConflicts.add((Conflict) obj);
					}
				}
			}
			adapterFactory.dispose();
		});
		return new ArrayList<>(selectedConflicts);
	}
	
	private static class ConflictSelectorContentProvider extends AdapterFactoryContentProvider {

		private Object[] conflictGroups;

		public ConflictSelectorContentProvider(AdapterFactory adapterFactory) {
			super(adapterFactory);
		}

		@Override
		public Object[] getElements(Object object) {
			if(conflictGroups == null) {
				conflictGroups = ((ConflictSet)object).getConflicts().stream()
					.collect(Collectors.groupingBy(Conflict::getId))
					.entrySet().stream()
					.map(entry -> new ConflictGroup(entry.getKey(), entry.getValue().toArray(new Conflict[0])))
					.collect(Collectors.toCollection(ArrayList::new)).toArray();
			}
			return conflictGroups;
		}

		@Override
		public Object[] getChildren(Object object) {
			if(object instanceof ConflictGroup) {
				return ((ConflictGroup)object).conflicts;
			}
			return super.getChildren(object);
		}

		@Override
		public boolean hasChildren(Object object) {
			if(object instanceof ConflictGroup) {
				return true; // conflict group always contains at least one conflict
			}
			return super.hasChildren(object);
		}
	}

	private static class ConflictSelectorLabelProvider extends AdapterFactoryLabelProvider.StyledLabelProvider {

		public ConflictSelectorLabelProvider(AdapterFactory adapterFactory) {
			super(adapterFactory,
				Display.getDefault().getSystemFont(),
				Display.getDefault().getSystemColor(SWT.COLOR_BLACK),
				Display.getDefault().getSystemColor(SWT.COLOR_TRANSPARENT));
		}

		@Override
		public String getText(Object object) {
			if(object instanceof ConflictGroup) {
				return String.format("Conflicts %s", ((ConflictGroup)object).id);
			}
			return super.getText(object);
		}

		@Override
		public Image getImage(Object object) {
			if(object instanceof ConflictGroup) {
				return super.getImage(((ConflictGroup)object).conflicts[0]);
			}
			return super.getImage(object);
		}
	}

	private static class ConflictGroup {
		final String id;
		final Conflict conflicts[];

		public ConflictGroup(String id, Conflict[] conflicts) {
			this.id = id;
			this.conflicts = conflicts;
		}
	}

	private static class ConflictSelectorSelectionValidator implements ISelectionStatusValidator {

		@Override
		public IStatus validate(Object[] selection) {
			if(Stream.of(selection).anyMatch(obj -> !(obj instanceof ConflictGroup || obj instanceof Conflict))) {
				return new Status(IStatus.WARNING, SuperimpositionModelEditorPlugin.ID,
						"Only conflicts and conflict groups can be selected");
			}
			return Status.OK_STATUS;
		}
	}
}
