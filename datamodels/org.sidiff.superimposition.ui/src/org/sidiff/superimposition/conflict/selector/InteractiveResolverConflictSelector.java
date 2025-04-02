package org.sidiff.superimposition.conflict.selector;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.sidiff.superimposition.Conflict;
import org.sidiff.superimposition.conflict.resolver.IConflictResolver;

/**
 * A conflict resolver selector that displays a dialog for the user to
 * select the resolvers to use if multiple are available.
 * @author rmueller
 */
public class InteractiveResolverConflictSelector implements IConflictResolverSelector {

	private Map<String,List<String>> rememberedConflictResolvers = new HashMap<>();

	@Override
	public List<IConflictResolver> selectResolvers(Conflict conflict, Collection<IConflictResolver> resolvers) {
		Assert.isLegal(!resolvers.isEmpty());
		if(resolvers.size() == 1) {
			return Collections.singletonList(resolvers.iterator().next());
		}
		List<String> remembered = rememberedConflictResolvers.get(conflict.getId());
		if(remembered != null) {
			return remembered.stream()
					.map(key -> resolvers.stream().filter(r -> r.getKey() == key).findFirst())
					.filter(Optional::isPresent)
					.map(Optional::get)
					.collect(Collectors.toList());
		}

		List<IConflictResolver> selectedResolvers = new ArrayList<>();
		Display.getDefault().syncExec(() -> {
			ElementListSelectionDialog dialog = new ElementListSelectionDialog(
				Display.getDefault().getActiveShell(),
				new ColumnLabelProvider() {
					@Override
					public String getText(Object element) {
						return ((IConflictResolver)element).getName();
					}
				}) {

				@Override
				protected void createButtonsForButtonBar(Composite parent) {
					createButton(parent, IDialogConstants.YES_TO_ALL_ID, "Ok, Remember for this Conflict ID", false);
					createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
					createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
				}
				
				@Override
				protected void buttonPressed(int buttonId) {
					if(buttonId == IDialogConstants.YES_TO_ALL_ID || buttonId == IDialogConstants.OK_ID) {
						computeResult();
						Stream.of(getResult()).map(IConflictResolver.class::cast).forEach(selectedResolvers::add);				

						if(buttonId == IDialogConstants.YES_TO_ALL_ID) {
							rememberedConflictResolvers.put(conflict.getId(),
									selectedResolvers.stream().map(IConflictResolver::getKey).collect(Collectors.toList()));							
						}
						setReturnCode(Window.OK);
						close();
					} else {
						cancelPressed();				
					}
				}
			};
			dialog.setTitle("Select Conflict Resolvers");
			dialog.setMessage("Select the Conflict Resolvers to resolve the Conflict:\n"
					+ conflict.getId() + " : " + conflict.getMessage());
			dialog.setBlockOnOpen(true);
			dialog.setElements(resolvers.toArray());
			dialog.setMultipleSelection(true);
			dialog.setHelpAvailable(false);
			dialog.open();
		});
		return selectedResolvers;
	}
}
