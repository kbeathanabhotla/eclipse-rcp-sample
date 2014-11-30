package com.saikrishna.rcp.sample2.handler;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.workbench.IWorkbench;
import org.eclipse.e4.ui.workbench.modeling.EPartService;

public class SaveHandler {

	@Execute
	public void execute(IWorkbench workbench, EPartService partService) {
		System.out.println("Saving functionality doing");
		partService.saveAll(true);
	}
	
}
