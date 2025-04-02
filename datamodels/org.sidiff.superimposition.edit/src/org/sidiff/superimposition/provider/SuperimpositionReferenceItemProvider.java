package org.sidiff.superimposition.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.command.CopyCommand.Helper;
import org.eclipse.emf.edit.command.CreateCopyCommand;
import org.eclipse.emf.edit.command.InitializeCopyCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.StyledString;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.sidiff.common.emf.EMFUtil;
import org.sidiff.entities.Element;
import org.sidiff.entities.EntitiesPackage;
import org.sidiff.entities.Reference;
import org.sidiff.entities.provider.EntityItemProvider;
import org.sidiff.entities.provider.ReferenceItemProvider;
import org.sidiff.superimposition.SuperimposedElement;

public class SuperimpositionReferenceItemProvider extends ReferenceItemProvider {

	public SuperimpositionReferenceItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public void notifyChanged(Notification notification) {
		// update label and tree structure if reference target changed
		switch(notification.getFeatureID(Reference.class)) {
			case EntitiesPackage.REFERENCE__TARGET:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, true));
				return;
		}

		super.notifyChanged(notification);
	}

	@Override
	public Collection<?> getChildren(Object object) {
		if(((Reference)object).isContainment()) {
			return Collections.singleton(((Reference)object).getTarget());
		}
		return Collections.emptyList();
	}
	
	@Override
	public boolean hasChildren(Object object) {
		return ((Reference)object).isContainment();
	}

	@Override
	public Object getStyledText(Object object) {
		Reference ref = (Reference) object;
    	StyledString styledLabel = new StyledString();
    	styledLabel.append(getFormattedNumberOfConfigurations(ref.getAnnotations()));
    	styledLabel.append(" ");
    	styledLabel.append(ref.getType().getName() , StyledString.Style.QUALIFIER_STYLER);
		styledLabel.append(" --> ");
		if(ref.getTarget() == null) {
			styledLabel.append("<no target>");
		} else {
			Set<String> objectSignatures = new HashSet<>();
			if (ref.getTarget() instanceof SuperimposedElement) {
				SuperimposedElement refSim = (SuperimposedElement) ref.getTarget();
				for(EObject refO : refSim.getObjects()) {
					objectSignatures.add(EMFUtil.getEObjectSignatureName(refO));
				}
			} else {
				objectSignatures.add(EMFUtil.getEObjectSignatureName((ref.getTarget().getObject())));
			}
			if(objectSignatures.isEmpty()) {
				objectSignatures.add(ref.getTarget().getSignature());
			}
			styledLabel.append(String.join(", ", objectSignatures));
		}		
    	styledLabel.append(" ");
		styledLabel.append(EntityItemProvider.getFormattedAnnotationsString(ref.getAnnotations()));
		return styledLabel;
	}

	@Override
	protected Command createCreateCopyCommand(EditingDomain domain, EObject owner, Helper helper) {
		return new CreateCopyCommand(domain, owner, helper) {
			@Override
			public Collection<?> doGetChildrenToCopy() {
				Set<Object> result = new HashSet<>(super.doGetChildrenToCopy());
				Reference reference = (Reference)owner;
				if(reference.isContainment()) {
					// also create a copy of the target superimposed element if it's contained via this reference
					result.add(reference.getTarget());
				}
				return result;
			}
		};
	}

	@Override
	protected Command createInitializeCopyCommand(EditingDomain domain, EObject owner, Helper helper) {
		return new InitializeCopyCommand(domain, owner, helper) {
			@Override
			protected Collection<? extends EReference> getReferencesToCopy() {
				List<EReference> references = new ArrayList<>(super.getReferencesToCopy());
				references.remove(EntitiesPackage.Literals.REFERENCE__TARGET); // copy manually
				return references;
			}

			@Override
			protected void copyReferences() {
				super.copyReferences();
				initReferenceTarget();
			}

			private void initReferenceTarget() {
				Reference reference = (Reference)owner;
				Reference copiedReference = (Reference)helper.getCopy(reference);
				// use copied target if available, else use original target
				copiedReference.setTarget((Element)helper.getCopyTarget(reference.getTarget(), false));
			}

			@Override
			public void doUndo() {
				super.doUndo();
				((Reference)helper.getCopy(owner)).setTarget(null);
			}

			@Override
			public void doRedo() {
				super.doRedo();
				initReferenceTarget();
			}
		};
	}
}
