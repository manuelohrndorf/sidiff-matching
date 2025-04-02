package org.sidiff.superimposition.ui.handlers;

import java.util.HashSet;
import java.util.Optional;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.ui.dialogs.ResourceDialog;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.sidiff.common.emf.access.EMFGenModelAccess;
import org.sidiff.superimposition.SuperimposedModel;
import org.sidiff.superimposition.ui.jobs.ExportModelJob;

/**
 * 
 * @author rmueller
 */
public class ExportModelHandler extends AbstractSuperimpositionHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ExportModelJob job = new ExportModelJob()
				.setSaveExportedResource(true);

		SuperimposedModel superimposedModel = getSuperimposedModel(event);
		if(superimposedModel != null) {
			job.setSuperimposedModel(superimposedModel);
		} else {
			throw new IllegalArgumentException("Selection does not contain a superimposed model");
		}

		showOutputSelectionDialog(superimposedModel)
			.ifPresent(outputUri -> job.setOutputUri(outputUri).schedule());
		return null;
	}

	/**
	 * Shows a dialog to select the output uri for the exported model from the workspace or file system
	 * @param superimposedUri URI of the superimposed model
	 * @return uri of the selected file, empty optional if the dialog was cancelled
	 */
	protected static Optional<URI> showOutputSelectionDialog(SuperimposedModel superimposedModel)
	{
		String fileExt = EMFGenModelAccess.getFileExtension(new HashSet<>(superimposedModel.getDocType()));
		URI superimposedUri = superimposedModel.eResource().getURI();
		ResourceDialog resourceDialog = new ResourceDialog(Display.getDefault().getActiveShell(),
				"Select location to save exported model", SWT.SAVE, superimposedUri) {
			@Override
			protected boolean processResources() {
				if(getURIText().isEmpty()) {
					// clicking OK when the dialog is empty sets a default
					uriField.setText(superimposedUri.trimSegments(1).appendSegment("exported." + fileExt).toString());
					return false;
				}
				return true;
			}
		};
		resourceDialog.setBlockOnOpen(true);
		if(resourceDialog.open() == Window.OK) {
			URI uri = URI.createURI(resourceDialog.getURIText());
			if(uri.fileExtension() == null) {
				uri = uri.appendFileExtension(fileExt);
			}
			return Optional.of(uri);
		}
		return Optional.empty();
	}
}
