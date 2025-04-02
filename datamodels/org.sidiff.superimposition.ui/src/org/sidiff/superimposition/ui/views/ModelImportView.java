package org.sidiff.superimposition.ui.views;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.ui.dialogs.ResourceDialog;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.EMFEditPlugin;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.SafeRunnable;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.part.ViewPart;
import org.sidiff.common.emf.modelstorage.SiDiffResourceSet;
import org.sidiff.entities.util.EntitiesUtil;
import org.sidiff.formula.provider.FormulaItemProviderAdapterFactory;
import org.sidiff.superimposition.SuperimposedElement;
import org.sidiff.superimposition.SuperimposedModel;
import org.sidiff.superimposition.SuperimpositionModelFactory;
import org.sidiff.superimposition.importer.SuperimpositionModelImporter;
import org.sidiff.superimposition.presentation.SuperimpositionModelEditorPlugin;
import org.sidiff.superimposition.provider.SuperimpositionModelEditPlugin;
import org.sidiff.superimposition.provider.SuperimpositionModelEntitiesItemProviderAdapterFactory;
import org.sidiff.superimposition.provider.SuperimpositionModelItemProviderAdapterFactory;


/**
 * @author cpietsch
 * @author rmueller
 */
public class ModelImportView extends ViewPart implements ICheckStateListener {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "org.sidiff.superimposition.ui.views.ModelImportView";
	
	/**
	 * The root object for the Eclipse Platform user interface
	 */
	@Inject IWorkbench workbench;
	
	/**
	 * The {@link ComposedAdapterFactory} used to determine the default content and label provider for {@link #resource} and {@link #superimposedModel} 
	 */
	private ComposedAdapterFactory adapterFactory;
	
	/**
	 * The default {@link AdapterFactoryLabelProvider} for {@link #resource} and {@link #superimposedModel}
	 */
	private AdapterFactoryLabelProvider adapterFactoryLabelProvider;
	
	/**
	 * The {@link SiDiffResourceSet} containing {@link #resource} and {@link #superimposedModelResource}
	 */
	private SiDiffResourceSet resourceSet;
	
	/**
	 * A {@link Resource} containing the model to import
	 */
	private Resource resource;
	
	/**
	 * The {@link SuperimposedModel}
	 */
	private SuperimposedModel superimposedModel;

	/**
	 * The map holds all candidates in {@link #superimposedModel} for an object in {@link #resource}
	 * Objects already contained in {@link #superimposedModel} are read only in {@link #candidateViewer}
	 */
	private Map<EObject, List<SuperimposedElement>> candidates = new HashMap<>();
	
	/**
	 * The map holds all objects of {@link #resource} already contained in {@link #superimposedModel} 
	 */
	private Map<EObject, SuperimposedElement> readOnly = new HashMap<>();
	
	/**
	 * The map holds the choice for ambiguous signatures
	 */
	private Map<EObject, SuperimposedElement> imports = new HashMap<>();
	
	/**
	 * A {@link TreeViewer} to show the content of {@link #resource}
	 */
	private TreeViewer modelViewer;
	
	/**
	 * A {@link CheckboxTableViewer} to show the candidates in {@link #superimposedModel}
	 */
	private CheckboxTableViewer candidateViewer;

	/**
	 * An {@link Action} to open a {@link FileDialog} for loading a {@link UUIDResource};
	 */
	private Action loadResourceAction;
	
	/**
	 * An {@link Action} to open a {@link FileDialog} for loading a {@link SuperimposedModel}
	 */
	private Action loadSuperimposedModelAction;
	
	/**
	 * An {@link Action} to import the objects of {@link #resource} into {@link #superimposedModel}
	 */
	private Action importElementsAction;
	
//	private Action doubleClickAction;

	@Override
	public void createPartControl(Composite parent) {
		
		// Create an adapter factory that yields item providers.
		//
		this.adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		this.adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		this.adapterFactory.addAdapterFactory(new SuperimpositionModelItemProviderAdapterFactory());
		this.adapterFactory.addAdapterFactory(new SuperimpositionModelEntitiesItemProviderAdapterFactory());
		this.adapterFactory.addAdapterFactory(new FormulaItemProviderAdapterFactory());
		this.adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
		this.adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(this.adapterFactory);
		
		// Create the modelViewer
		//
		modelViewer = new TreeViewer(parent, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		modelViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
		modelViewer.setLabelProvider(adapterFactoryLabelProvider);
		modelViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				if(!event.getSelection().isEmpty() && event.getSelection() instanceof IStructuredSelection && superimposedModel != null) {
					IStructuredSelection selection = (IStructuredSelection)event.getSelection();
					if(selection.getFirstElement() instanceof EObject) {
						EObject eObject = (EObject) selection.getFirstElement();
						candidateViewer.setInput(candidates.get(eObject));
						if(imports.get(eObject) != null) {
							candidateViewer.setChecked(imports.get(eObject), true);
						}
					}else {
						candidateViewer.setInput(Collections.EMPTY_LIST);
					}
				}else {
					candidateViewer.setInput(Collections.EMPTY_LIST);
				}
				candidateViewer.refresh();
			}
		});
		
		// Create the candidateViewer
		//
		candidateViewer = new CheckboxTableViewer(new Table(parent, SWT.CHECK | SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL));
		candidateViewer.getTable().setHeaderVisible(true);
		candidateViewer.getTable().setLinesVisible(true);
		candidateViewer.setContentProvider(new ArrayContentProvider());
		candidateViewer.addCheckStateListener(this);
		
		TableViewerColumn column_signature = new TableViewerColumn(candidateViewer, SWT.BORDER);
		column_signature.getColumn().setText("Signature");
		column_signature.getColumn().setWidth(200);
		column_signature.getColumn().setResizable(true);
		column_signature.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public Image getImage(Object element) {
				return adapterFactoryLabelProvider.getImage(element);
			}

			@Override
			public String getText(Object element) {
				return ((SuperimposedElement)element).getSignature();
			}
		});
		
		TableViewerColumn column_uuid = new TableViewerColumn(candidateViewer, SWT.NONE);
		column_uuid.getColumn().setText("UUID");
		column_uuid.getColumn().setWidth(200);
		column_uuid.getColumn().setResizable(true);
		column_uuid.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public String getText(Object element) {
				return ((SuperimposedElement)element).getUuid();
			}
		});
		
		TableViewerColumn column_type = new TableViewerColumn(candidateViewer, SWT.NONE);
		column_type.getColumn().setText("Type");
		column_type.getColumn().setWidth(200);
		column_uuid.getColumn().setResizable(true);
		column_type.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public Image getImage(Object element) {
				return adapterFactoryLabelProvider.getImage(((SuperimposedElement)element).getType());
			}

			@Override
			public String getText(Object element) {
				return adapterFactoryLabelProvider.getText(((SuperimposedElement)element).getType());
			}
		});
		
		
//		drillDownAdapter = new DrillDownAdapter(modelViewer);
		
		
		// Create the help context id for the viewer's control
		//
		workbench.getHelpSystem().setHelp(modelViewer.getControl(), "org.sidiff.superimposition.ui.viewer");
		getSite().setSelectionProvider(modelViewer);
		makeActions();
		hookContextMenu();
		hookDoubleClickAction();
		contributeToActionBars();
	}
	
	public void loadResource(URI uri) throws IOException {
		clear();
		initResourceSet();
		resource = resourceSet.getResource(uri, true);
		URI simUri = resource.getURI().trimSegments(1).appendSegment("superimposed.sim");
		if(resourceSet.getURIConverter().exists(simUri, resourceSet.getLoadOptions())) {
			loadSuperimposedModel(simUri);
		} else {
			superimposedModel = SuperimpositionModelFactory.eINSTANCE.createSuperimposedModel();
			Resource superimposedResource = resourceSet.createResource(simUri);
			superimposedResource.getContents().add(superimposedModel);
		}

		importElementsAction.setEnabled(true);
		modelViewer.setInput(resourceSet);
		modelViewer.refresh();
	}
	
	public void loadSuperimposedModel(URI uri) throws IOException {
		clear();
		initResourceSet();
		superimposedModel = resourceSet.loadEObject(uri, SuperimposedModel.class);

		if(resource != null) {
			resource.getAllContents().forEachRemaining(eObject -> {
				for (SuperimposedElement element : superimposedModel.getElements()) {
					if(element.getObjects().contains(eObject)) {
						readOnly.put(eObject, element);	
					}
				}
			});
			resource.getAllContents().forEachRemaining(eObject -> {
				String signature = superimposedModel.calculateSignature(eObject);
				for (SuperimposedElement element : superimposedModel.getElements()) {
					if(element.getSignature().equals(signature) && !readOnly.containsKey(eObject)) {
						candidates.computeIfAbsent(eObject, (unused) -> new ArrayList<>()).add(element);
					}
				}
			});
		}
		
		this.modelViewer.setInput(resourceSet);
		this.modelViewer.refresh();
	}

	private void initResourceSet() {
		if(resourceSet == null) {
			resourceSet = SiDiffResourceSet.create("*");
		}
	}

	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			@Override
			public void menuAboutToShow(IMenuManager manager) {
				ModelImportView.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(modelViewer.getControl());
		modelViewer.getControl().setMenu(menu);
//		getSite().registerContextMenu(menuMgr, modelViewer);
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(loadSuperimposedModelAction);
		manager.add(new Separator());
		manager.add(importElementsAction);
	}

	private void fillContextMenu(IMenuManager manager) {
		manager.add(loadResourceAction);
		manager.add(loadSuperimposedModelAction);
//		manager.add(importElementsAction);
		manager.add(new Separator());
//		drillDownAdapter.addNavigationActions(manager);
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}
	
	private void fillLocalToolBar(IToolBarManager manager) {
//		manager.add(loadSuperimposedModelAction);
//		manager.add(importElementsAction);
//		manager.add(new Separator());
//		drillDownAdapter.addNavigationActions(manager);
	}

	private void makeActions() {
		makeLoadResourceAction();
		makeLoadSuperimposedModelAction();
		makeImportElementsAction();
	}

	private void makeLoadResourceAction() {
		this.loadResourceAction = new Action() {
			@Override
			public void run() {
				ResourceDialog resourceDialog = new ResourceDialog(workbench.getActiveWorkbenchWindow().getShell(),
						"Select a resource to load", SWT.OPEN, resource == null ? null : resource.getURI()) {
					@Override
					protected boolean processResources() {
						return !getURIText().isEmpty();
					}
				};
				resourceDialog.setBlockOnOpen(true);
				if(resourceDialog.open() == Window.OK) {
					URI uri = URI.createURI(resourceDialog.getURIText());
					if("sim".equalsIgnoreCase(uri.fileExtension())) {
						SafeRunnable.run(() -> loadSuperimposedModel(uri));
					} else {
						SafeRunnable.run(() -> loadResource(uri));
					}
				}
			}
		};
		this.loadResourceAction.setText("Load model resource");
		this.loadResourceAction.setToolTipText("Load model resource");
		this.loadResourceAction.setImageDescriptor(ImageDescriptor.createFromURL((URL) EMFEditPlugin.INSTANCE.getImage("full/obj16/ModelFile")));
	}
	
	private void makeLoadSuperimposedModelAction() {
		this.loadSuperimposedModelAction = new Action() {
			@Override
			public void run() {
				ResourceDialog resourceDialog = new ResourceDialog(workbench.getActiveWorkbenchWindow().getShell(),
						"Select a superimposed model to load", SWT.OPEN, superimposedModel == null ? null : superimposedModel.eResource().getURI()) {
					@Override
					protected boolean processResources() {
						return !getURIText().isEmpty() && getURIText().endsWith(".sim");
					}
				};
				resourceDialog.setBlockOnOpen(true);
				if(resourceDialog.open() == Window.OK) {
					SafeRunnable.run(() -> loadSuperimposedModel(URI.createURI(resourceDialog.getURIText())));
				}
			}
		};
		this.loadSuperimposedModelAction.setText("Load superimposed model");
		this.loadSuperimposedModelAction.setToolTipText("Load superimposed model");
		this.loadSuperimposedModelAction.setImageDescriptor(ImageDescriptor.createFromURL((URL) SuperimpositionModelEditPlugin.INSTANCE.getImage("full/obj16/SuperimposedModel")));
	}
	
	private void makeImportElementsAction() {
		this.importElementsAction = new Action() {
			@Override
			public void run() {
				new Job("Importing elements") {
					@Override
					protected IStatus run(IProgressMonitor monitor) {
						try {
							SuperimpositionModelImporter importer = new SuperimpositionModelImporter();
							importer.init(superimposedModel);
							// TODO: the importer should use the progress monitor
							monitor.subTask("Importing resource");
							importer.updateObjectIndex(imports);
							importer.importResource(resource, EntitiesUtil.createModelAnnotation(resource.getURI()));
							monitor.subTask("Saving superimposed model");
							superimposedModel.eResource().save(null);
							return Status.OK_STATUS;
						} catch(Exception e) {
							return new Status(IStatus.ERROR, SuperimpositionModelEditorPlugin.ID, "Importing elements failed", e);
						}
					}
				}.schedule();
			}
		};
		this.importElementsAction.setText("Import elements");
		this.importElementsAction.setToolTipText("Import elements");
		this.importElementsAction.setImageDescriptor(workbench.getSharedImages().
				getImageDescriptor(ISharedImages.IMG_ETOOL_SAVE_EDIT));
		this.importElementsAction.setEnabled(false);
	}

	private void hookDoubleClickAction() {
		this.modelViewer.addDoubleClickListener(new IDoubleClickListener() {
			@Override
			public void doubleClick(DoubleClickEvent event) {
//				doubleClickAction.run();
			}
		});
	}
	
	@Override
	public void setFocus() {
		this.modelViewer.getControl().setFocus();
	}

	@Override
	public void checkStateChanged(CheckStateChangedEvent event) {
		if(this.modelViewer.getStructuredSelection() != null) {
			
			EObject eObject = (EObject) modelViewer.getStructuredSelection().getFirstElement();
			if(event.getChecked()){
				this.candidateViewer.setCheckedElements(new Object[] {event.getElement()});
				this.imports.put(eObject, (SuperimposedElement) event.getElement());
			}else {
				this.imports.remove(eObject);
			}
		}
		
	}
	
	private void clear() {
		this.superimposedModel = null;
		this.imports.clear();
		this.readOnly.clear();
		this.candidates.clear();
	}
}
