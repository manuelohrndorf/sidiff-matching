package org.sidiff.superimposition.ui.handlers;

import java.util.Collection;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.sidiff.common.collections.CollectionUtil;
import org.sidiff.common.emf.modelstorage.EMFStorage;
import org.sidiff.common.emf.modelstorage.SiDiffResourceSet;
import org.sidiff.superimposition.SuperimposedModel;
import org.sidiff.superimposition.presentation.SuperimpositionModelEditor;

/**
 * 
 * @author rmueller
 */
public abstract class AbstractSuperimpositionHandler extends AbstractHandler {

	public AbstractSuperimpositionHandler() {
		super();
	}

	protected SuperimposedModel getSuperimposedModel(ExecutionEvent event) {
		Object selection = HandlerUtil.getCurrentStructuredSelection(event).getFirstElement();
		if(selection instanceof EObject) {
			EObject root = EcoreUtil.getRootContainer((EObject)selection);
			for(EObject eObject : CollectionUtil.asIterable(root.eAllContents())) {	
				if(eObject instanceof SuperimposedModel) {
					return (SuperimposedModel)eObject;
				}
			}
		}

		IEditorPart activeEditor = HandlerUtil.getActiveEditor(event);
		if(activeEditor instanceof SuperimpositionModelEditor) {
			return ((SuperimpositionModelEditor)activeEditor)
				.getEditingDomain().getResourceSet().getResources().stream()
				.map(Resource::getContents)
				.flatMap(Collection::stream)
				.filter(SuperimposedModel.class::isInstance)
				.map(SuperimposedModel.class::cast)
				.findAny().orElseThrow(AssertionError::new);
		}
		
		URI uri = getSuperimposedUri(event);
		if(uri != null) {
			return SiDiffResourceSet.create().loadEObject(uri, SuperimposedModel.class);
		}

		return null;
	}

	protected URI getSuperimposedUri(ExecutionEvent event) {
		Object selection = HandlerUtil.getCurrentStructuredSelection(event).getFirstElement();
		if(selection instanceof IFile) {
			IFile file = (IFile)selection;
			if("sim".equals(file.getFileExtension())) {
				return EMFStorage.toPlatformURI(file);				
			}
		} else if(selection instanceof EObject) {
			EObject root = EcoreUtil.getRootContainer((EObject)selection);
			if(root instanceof SuperimposedModel) {
				return EcoreUtil.getURI(root).trimFragment();
			}
		}

		IEditorPart activeEditor = HandlerUtil.getActiveEditor(event);
		if(activeEditor instanceof SuperimpositionModelEditor) {
			return ((SuperimpositionModelEditor)activeEditor).getEditingDomain().getResourceSet().getResources().stream()
				.map(Resource::getURI).filter(uri -> "sim".equals(uri.fileExtension())).findAny().orElseThrow(AssertionError::new);
		}

		return null;
	}
}