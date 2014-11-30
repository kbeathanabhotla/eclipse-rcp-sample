package com.saikrishna.rcp.sample2.parts;

import java.util.Random;

import javax.annotation.PostConstruct;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.workbench.UIEvents.HandledItem;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TableItem;

public class ListPart {

	private TableViewer tableViewer;

	@PostConstruct
	public void createComposite(Composite parent) {
		parent.setLayout(new GridLayout(1, false));

		/*txtInput = new Text(parent, SWT.BORDER);
		txtInput.setMessage("Enter text to mark part as dirty");
		txtInput.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				dirty.setDirty(true);
			}
		});
		txtInput.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));*/

		tableViewer = new TableViewer(parent);
		
		Random random = new Random();
		for(int i=0;i<5;i++) {
			tableViewer.add(random.nextInt(100));
		}
		
		tableViewer.getTable().setLayoutData(new GridData(GridData.FILL_BOTH));
		
		tableViewer.getTable().addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//ISelection selection = tableViewer.getSelection();
				//ISelection sel = .getCurrentSelection(e);
				TableItem []selection = tableViewer.getTable().getSelection();
				for(TableItem item : selection) {
					System.out.println(item.getData());
				}
				//super.widgetSelected(e);
			}
		});
	}

	@Focus
	public void setFocus() {
		tableViewer.getTable().setFocus();
	}

}
