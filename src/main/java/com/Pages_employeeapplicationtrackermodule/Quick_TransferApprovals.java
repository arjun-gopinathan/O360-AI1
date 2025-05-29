package com.Pages_employeeapplicationtrackermodule;

import java.util.concurrent.TimeUnit;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_EmployeeModule;

public class Quick_TransferApprovals extends Base_Class{
	
	PageRepositary_EmployeeModule PageRepositary= new PageRepositary_EmployeeModule();
	
	public void clickonquickapprovals() throws InterruptedException 
	  {
	  click(PageRepositary.quickapprovals);
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	     
	  }
	public void clickonquicktransferapprovals() throws InterruptedException 
	  {
	  click(PageRepositary.quicktransferapprovals);
	  WaitForLoaderToDisappear();
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	     
	  }
	

}
