package com.Pages_TimesheetModule;

import org.openqa.selenium.By;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_TimeSheetModule;

public class Timesheet_EditDeleteModule extends Base_Class
{
	PageRepositary_TimeSheetModule PageRepositary= new PageRepositary_TimeSheetModule();

	 public boolean isEditButtonDisplayed() throws InterruptedException {
		boolean flag1 = ElementDisplayed(PageRepositary.editButton);
	     return  flag1;
	 }
     
     public boolean clickEditButton() throws InterruptedException {
	        click(PageRepositary.editButton);
			return false;
	 }
	 
     
	 public boolean clickDeleteButton() throws InterruptedException {
	        click(PageRepositary.deleteButton);
			return false;
	 }
	 
	 public boolean isDeleteButtonDisplayed() throws InterruptedException {
		 boolean flag1 = ElementDisplayed(PageRepositary.deleteButton);
	     return  flag1;
	 }
	 public boolean enterWorkDescription(String workDescription) throws InterruptedException {
		 	click(PageRepositary.editButton);
		 	Thread.sleep(1000);
		 	clear(PageRepositary.workDescriptionInput);
	    	input(PageRepositary.workDescriptionInput, workDescription);
			return false;
	    }
	 public boolean enterHours1() throws InterruptedException {
	    	clear(PageRepositary.hoursInput);
			return false;
	    }
	 
	 public boolean enterHours(String hours) throws InterruptedException {
	    	clear(PageRepositary.hoursInput);
	    	input(PageRepositary.hoursInput, hours);
			return false;
	    }

	    public boolean enterMinutes(String minutes) throws InterruptedException {
	    	clear(PageRepositary.minutesInput);
	    	input(PageRepositary.minutesInput, minutes);
			return false;
	    }
	 
	 public boolean DeleteButtonYes() throws InterruptedException {
	        click(PageRepositary.deleteButton);
	        Thread.sleep(2000);
	        click(PageRepositary.confirmYes);
	        Thread.sleep(2000);
			return false;
	 }
	 
	 public boolean DeleteButtonNo() throws InterruptedException {
	        click(PageRepositary.deleteButton);
	        Thread.sleep(2000);
	        click(PageRepositary.confirmNo);
	        Thread.sleep(2000);
			return false;
	 }

	 
	 public boolean isMandatoryFieldErrorDisplayed() throws InterruptedException {
	    	boolean flag1 = ElementDisplayed(PageRepositary.mandatoryFieldError);
	        return  flag1;
	    }
	 
	 public boolean selectModule(String moduleName1, String module1) throws InterruptedException {
		 click(PageRepositary.editButton);
		 Thread.sleep(1000);
         click(PageRepositary.moduleSelect);
         clear(PageRepositary.moduleSelect);
         Thread.sleep(1000);
         input(PageRepositary.moduleSelect, moduleName1);
        Thread.sleep(1000);
        click(By.xpath("//span[contains(text(),'"+module1+"')]"));
		return false;
    }
	    
	    public boolean uploadFile(String filePath) {
	        UploadFile(PageRepositary.fileUpload, filePath);
			return false;	    
	        }

	    public boolean selectDateWithinCurrentWeek(String date) throws InterruptedException {
	    	click(PageRepositary.clickOnDate);
	    	Thread.sleep(1000);
	    	click(By.xpath("//div[text()='" + date + "']"));
			return false;
	    }
	    
	    public boolean clickSave() throws InterruptedException {
		       click(PageRepositary.saveButton);
			return false;
		    }

		    public boolean clickClose() throws InterruptedException {
		    	click(PageRepositary.closeButton);
				return false;
		    }
		    
		    
		    public boolean isModuleListDisplayed() throws InterruptedException {
		        boolean flag1 = ElementDisplayed(PageRepositary.moduleSelect);
		        return  flag1;
		    }

		    public boolean isModuleSelected(String module) {
		        return driver.findElement(PageRepositary.moduleSelect).getAttribute("value").equals(module);

		    }

		    public boolean isInvalidDateErrorDisplayed() throws InterruptedException {
		        boolean flag1 = ElementDisplayed(PageRepositary.invalidDateError);
		        return  flag1;
		    }
		    
		    public boolean isEntryInMyTimesheet() throws InterruptedException {
		        boolean flag1 = ElementDisplayed(PageRepositary.myTimesheetEntry);
		        return  flag1;
		    }

		    public boolean isTimesheetEntryDisplayed() throws InterruptedException {
		        boolean flag1 = ElementDisplayed(PageRepositary.myTimesheetEntry);
		        return  flag1;
		    }



}
