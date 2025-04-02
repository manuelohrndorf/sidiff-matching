package org.sidiff.superimposition.ui.handlers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.ui.dialogs.ResourceDialog;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.statushandlers.StatusManager;
import org.sidiff.common.emf.modelstorage.EMFStorage;
import org.sidiff.superimposition.presentation.SuperimpositionModelEditorPlugin;
import org.sidiff.superimposition.ui.jobs.ImportModelsJob;

/**
 * 
 * @author rmueller
 */
public class ImportModelsHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		URI superimposedUri = null;
		List<URI> modelUris = new ArrayList<>();
		for(Object obj : HandlerUtil.getCurrentStructuredSelection(event).toArray()) {
			URI uri = EMFStorage.toPlatformURI((IFile)obj);
			if("sim".equals(uri.fileExtension())) {
				if(superimposedUri != null) {
					StatusManager.getManager().handle(new Status(IStatus.ERROR, SuperimpositionModelEditorPlugin.ID,
							"Only one superimposed model may be selected for importing."), StatusManager.SHOW);
					return null;
				}
				superimposedUri = uri;
			} else {
				modelUris.add(uri);
			}
		}
		if(modelUris.isEmpty()) {
			StatusManager.getManager().handle(new Status(IStatus.ERROR, SuperimpositionModelEditorPlugin.ID,
					"At least one model to import must be selected."), StatusManager.SHOW);
			return null;
		}
		if(superimposedUri == null) {
			superimposedUri = showSuperimposedSelectionDialog(modelUris.get(0).trimSegments(1).appendSegment("superimposed.sim"));
		}
		if(superimposedUri != null) {
			new ImportModelsJob(superimposedUri, modelUris).schedule();
		}
		return null;
	}

	protected static URI showSuperimposedSelectionDialog(URI defaultSelection)
	{
		ResourceDialog resourceDialog = new ResourceDialog(Display.getDefault().getActiveShell(),
				"Select location of superimposed model", SWT.SAVE, defaultSelection) {
			@Override
			protected boolean processResources() {
				if(getURIText().isEmpty()) {
					// clicking OK when the dialog is empty sets a default
					uriField.setText(defaultSelection.toString());
					return false;
				}
				return true;
			}
		};
		resourceDialog.setBlockOnOpen(true);
		if(resourceDialog.open() == Window.OK) {
			return URI.createURI(resourceDialog.getURIText());
		}
		return null;
	}
}
