package com.saikrishna.rcp.sample2.handler;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.EPartService;

public class SortHandler {
	
	@CanExecute
	public boolean canExecute(EPartService partService) {
		if (partService != null) {
			return true;
		}
		return false;
	}
	
	@Execute
	public void execute(EPartService partService) {
		MPart elementsPart = partService.findPart("com.saikrishna.rcp.sample2.part.elements");
		//elementsPart.
		
	}
	
}
