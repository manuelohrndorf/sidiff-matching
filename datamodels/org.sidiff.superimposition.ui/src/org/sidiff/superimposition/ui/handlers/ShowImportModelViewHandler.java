package org.sidiff.superimposition.ui.handlers;

import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.statushandlers.StatusManager;
import org.sidiff.common.emf.modelstorage.EMFStorage;
import org.sidiff.superimposition.presentation.SuperimpositionModelEditorPlugin;
import org.sidiff.superimposition.ui.views.ModelImportView;

/**
 * 
 * @author rmueller
 */
public class ShowImportModelViewHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Object selectedFiles[] = HandlerUtil.getCurrentStructuredSelection(event).toArray();
		if(selectedFiles.length == 0) {
			return null;
		}

		// Show a busy indicator while the runnable is executed
		BusyIndicator.showWhile(Display.getDefault(), () -> {
			try {
				ModelImportView view = (ModelImportView)HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().showView(ModelImportView.ID);
				for(Object obj : selectedFiles) {
					URI uri = EMFStorage.toPlatformURI((IFile)obj);
					if("sim".equals(uri.fileExtension())) {
						view.loadSuperimposedModel(uri);
					} else {
						view.loadResource(uri);
					}
				}
			} catch (PartInitException | IOException e) {
				StatusManager.getManager().handle(
						new Status(IStatus.ERROR, SuperimpositionModelEditorPlugin.ID, "Showing model import view failed", e),
						StatusManager.LOG|StatusManager.SHOW);
			}
		});
		return null;
	}

}
