package com.saikrishna.rcp.sample2.parts;

import javax.annotation.PostConstruct;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

public class FunctionsPart {

	private Text txtInput;

	@PostConstruct
	public void createButtons(Composite parent) {

		parent.setLayout(new GridLayout(2, true));

		txtInput = new Text(parent, SWT.BORDER);
		txtInput.setMessage("Enter a number here");
		txtInput.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL, GridData.VERTICAL_ALIGN_CENTER, false, false));

		createButton(parent, SWT.BUTTON1, "Add number", new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println(txtInput.getText());
			}
		}, new GridData(GridData.END, GridData.CENTER, false, false));
		
		
		Button ascendingButton = createButton(parent, SWT.RADIO, "Ascending", new SelectionAdapter() {}, new GridData(GridData.BEGINNING, GridData.CENTER, false, false));
		ascendingButton.setSelection(true);
		
		Button sortButton = createButton(parent, SWT.BUTTON1, "Sort Numbers", new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("Sorting functionality");
			}
		}, new GridData(GridData.BEGINNING, GridData.CENTER, false, false));
		
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.HORIZONTAL_ALIGN_CENTER;
		gridData.verticalSpan = 2;
		gridData.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
		gridData.horizontalSpan = 1;
		gridData.grabExcessVerticalSpace = false;	
		gridData.grabExcessHorizontalSpace = false;
		sortButton.setLayoutData(gridData);
		
		createButton(parent, SWT.RADIO, "Descending", new SelectionAdapter() {}, new GridData(GridData.BEGINNING, GridData.VERTICAL_ALIGN_END, false, false));
		
		createButton(parent, SWT.BUTTON1, "Remove Number", new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("remove number");
			}
		}, new GridData(GridData.BEGINNING, GridData.CENTER, false, false));
		
		/*Button button = new Button(parent, SWT.BOLD);
		button.setText("Add number");

		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println(txtInput.getText());
			}
		});*/
		
		

	}
	
	private Button createButton(Composite container, int buttonStyle, String name, SelectionAdapter listener, GridData gridData) {
		Button button = new Button(container, buttonStyle);
		button.setText(name);
		button.addSelectionListener(listener);
		button.setLayoutData(gridData);
		return button;
	}
	
	@Focus
	public void focusTextInput() {
		txtInput.setFocus();
	}
}
