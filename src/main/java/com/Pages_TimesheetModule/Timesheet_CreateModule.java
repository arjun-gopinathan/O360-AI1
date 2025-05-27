package com.Pages_TimesheetModule;

import org.openqa.selenium.By;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_TimeSheetModule;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class Timesheet_CreateModule extends Base_Class
{
	PageRepositary_TimeSheetModule PageRepositary= new PageRepositary_TimeSheetModule();

	 public boolean clickOnDayWeekSelection(String DayMonth, String MonthDay) throws InterruptedException {
		 click(PageRepositary.selectDateRange);
		 Thread.sleep(1000);
		 click(PageRepositary.selectMonth);
	      // Thread.sleep(3000);
	       click(By.xpath("//option[contains(text(),'"+DayMonth+"')]"));
	       Thread.sleep(1000);
		    click(By.xpath("//span[contains(text(),'"+MonthDay+"')]"));
		   Thread.sleep(2000);
		   click(PageRepositary.ClickOnDateRange);
		   Thread.sleep(2000);
	        return true;
	    }
	 
	 public boolean selectWeek(String DayWeek) throws InterruptedException {
	        click(PageRepositary.selectDateRange);
	        click(By.xpath("//span[contains(text(),'"+DayWeek+"')]"));
	        click(PageRepositary.selectDateRange);
			return false;
	    }
	 
	 public boolean clicOnNewButton() throws InterruptedException {
	        click(PageRepositary.clickOnNewEntry);
			return false;
	    }

	    public boolean selectProject(String project) throws InterruptedException {
	    	click(PageRepositary.projectDropdown);
	    	Thread.sleep(2000);
	    	click(By.xpath("//option[contains(text(),'"+project+"')]"));
			return false;
	    }

	    public boolean selectModule(String moduleName, String module) throws InterruptedException {
	         click(PageRepositary.moduleSelect);
	         input(PageRepositary.moduleSelect, moduleName);
	        Thread.sleep(1000);
	        click(By.xpath("//span[contains(text(),'"+module+"')]"));
			return false;
	    }

	    public boolean enterWorkDescription(String workDescription) throws InterruptedException {
	    	input(PageRepositary.workDescriptionInput, workDescription);
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

	    public boolean selectDateOutsideCurrentWeek(String date1) throws InterruptedException {
	    	click(PageRepositary.clickOnDate);
	    	Thread.sleep(1000);
	    	click(By.xpath("//div[text()='" + date1 + "']"));
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

	    public boolean clickModuleSection() throws InterruptedException {
	       click(PageRepositary.moduleSelect);
		return false;
	    }

	    public boolean isMandatoryFieldErrorDisplayed() throws InterruptedException {
	    	boolean flag1 = ElementDisplayed(PageRepositary.mandatoryFieldError);
	        return  flag1;
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

	    public boolean isPDFRestrictionErrorDisplayed() throws InterruptedException {
	        boolean flag1 = ElementDisplayed(PageRepositary.pdfRestrictionError);
	        click(PageRepositary.clickOk);
	        Thread.sleep(2000);
	        return  flag1;
	    }

	    public boolean isInvalidHoursErrorDisplayed() throws InterruptedException {
	        boolean flag1 = ElementDisplayed(PageRepositary.hoursError);
	        return  flag1;
	    }

	    public boolean isInvalidModuleErrorDisplayed() throws InterruptedException {
	        boolean flag1 = ElementDisplayed(PageRepositary.moduleError);
	        return  flag1;
	    }

	    public boolean isProjectSelectionErrorDisplayed() throws InterruptedException {
	        boolean flag1 = ElementDisplayed(PageRepositary.hoursError);
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
	    
	    public boolean finalSubmission() throws InterruptedException {
	    	click(PageRepositary.clickOnSubmittButton);
	    	Thread.sleep(2000);
	    	click(PageRepositary.clickOnYesSubmitButton);
	    	Thread.sleep(3000);
			ExtentTestManager.getTest().log(Status.PASS, "Timesheet Submitted!");
			Log.info("Timesheet Submitted!");
	        return true;
	        
	    }
	    
	    public boolean selectFaceFinalSubmission() throws InterruptedException {
	    	click(PageRepositary.selectTheFace);
	    	Thread.sleep(1000);
	    	click(PageRepositary.finalSubmissionOfTimesheet);
	    	Thread.sleep(4000);
	        return true;
	        
	    }
	    
	
	    public boolean holidayCondition(String project, String moduleName, String module, String workDescription, String hours, String minutes) throws InterruptedException
		{
			String[] list1 = {"SUN", "MON", "TUE", "WED", "THU"};
			
			for (int i=0;i<list1.length;i++)
			{
				By weekDay = By.xpath("//td[contains(text(),'"+list1[i]+"')]");
				click(weekDay);
				try
				{
				boolean flag = ElementDisplayed(PageRepositary.clickOnNewEntry);
				if (flag)
				{
					Thread.sleep(4000);
					click(PageRepositary.clickOnNewEntry);
					click(PageRepositary.projectDropdown);
			    	Thread.sleep(2000);
			    	click(By.xpath("//option[contains(text(),'"+project+"')]"));
			    	click(PageRepositary.moduleSelect);
			         input(PageRepositary.moduleSelect, moduleName);
			        Thread.sleep(1000);
			        click(By.xpath("//span[contains(text(),'"+module+"')]"));
			        Thread.sleep(1000);
			        input(PageRepositary.workDescriptionInput, workDescription);
			        Thread.sleep(1000);
			        clear(PageRepositary.hoursInput);
			    	input(PageRepositary.hoursInput, hours);
			    	clear(PageRepositary.minutesInput);
			    	input(PageRepositary.minutesInput, minutes);
			    	 click(PageRepositary.saveButton);
					ExtentTestManager.getTest().log(Status.PASS, "Timesheet for " + list1[i] + " Created!");
					Log.info("Timesheet for " + list1[i] + " Created!");
					Thread.sleep(1000);
				}
				
				}
				
				catch(Exception e1)
				{
					Log.info("No timesheet Created for " + list1[i] + "!");
				}
			}
			return false;
		}
	    
	    
	    public boolean contractEmployees(String project1, String moduleName, String module, String workDescription, String hours, String minutes) throws InterruptedException
		{
			String[] list1 = {"MON", "TUE", "WED", "THU", "FRI"};
			
			for (int i=0;i<list1.length;i++)
			{
				By weekDay = By.xpath("//td[contains(text(),'"+list1[i]+"')]");
				click(weekDay);
				try
				{
				boolean flag = ElementDisplayed(PageRepositary.clickOnNewEntry);
				if (flag)
				{
					Thread.sleep(4000);
					click(PageRepositary.clickOnNewEntry);
					click(PageRepositary.projectDropdown);
			    	Thread.sleep(2000);
			    	click(By.xpath("//option[contains(text(),'"+project1+"')]"));
			    	click(PageRepositary.moduleSelect);
			         input(PageRepositary.moduleSelect, moduleName);
			        Thread.sleep(1000);
			        click(By.xpath("//span[contains(text(),'"+module+"')]"));
			        Thread.sleep(1000);
			        input(PageRepositary.workDescriptionInput, workDescription);
			        Thread.sleep(1000);
			        clear(PageRepositary.hoursInput);
			    	input(PageRepositary.hoursInput, hours);
			    	clear(PageRepositary.minutesInput);
			    	input(PageRepositary.minutesInput, minutes);
			    	 click(PageRepositary.saveButton);
			    	 click(PageRepositary.clickOnSubmittButton);
			    	 Thread.sleep(1000);
			    	 click(PageRepositary.clickOnYesSubmitButton);
			    	 Thread.sleep(3000);
//			    	 click(PageRepositary.selectTheFace);
//			    	 Thread.sleep(3000);
//			    	 click(PageRepositary.finalSubmissionOfTimesheet);
//			    	 Thread.sleep(3000);
					ExtentTestManager.getTest().log(Status.PASS, "Timesheet for " + list1[i] + " Submitted!");
					Log.info("Timesheet for " + list1[i] + " Submitted!");
					Thread.sleep(1000);
				}
				
				}
				
				catch(Exception e1)
				{
					Log.info("No timesheet Created for " + list1[i] + "!");
				}
			}
			return false;
		}
	    
	    
	    public boolean TearDown(String project, String moduleName, String module, String workDescription, String hours, String minutes) throws InterruptedException
		{
			String[] list1 = {"MON", "TUE", "WED", "THU", "FRI"};
			
			for (int i=0;i<list1.length;i++)
			{
				By weekDay = By.xpath("//td[contains(text(),'"+list1[i]+"')]");
				click(weekDay);
				try
				{
				boolean flag = ElementDisplayed(PageRepositary.clickOnNewEntry);
				if (flag)
				{
					Thread.sleep(4000);
					click(PageRepositary.clickOnNewEntry);
					click(PageRepositary.projectDropdown);
			    	Thread.sleep(2000);
			    	click(By.xpath("//option[contains(text(),'"+project+"')]"));
			    	click(PageRepositary.moduleSelect);
			         input(PageRepositary.moduleSelect, moduleName);
			        Thread.sleep(1000);
			        click(By.xpath("//span[contains(text(),'"+module+"')]"));
			        Thread.sleep(1000);
			        input(PageRepositary.workDescriptionInput, workDescription);
			        Thread.sleep(1000);
			        clear(PageRepositary.hoursInput);
			    	input(PageRepositary.hoursInput, hours);
			    	clear(PageRepositary.minutesInput);
			    	input(PageRepositary.minutesInput, minutes);
			    	 click(PageRepositary.saveButton);
					ExtentTestManager.getTest().log(Status.PASS, "Timesheet for " + list1[i] + " Created!");
					Log.info("Timesheet for " + list1[i] + " Created!");
					Thread.sleep(3000);
				}
				
				}
				
				catch(Exception e1)
				{
					Log.info("No timesheet Created for " + list1[i] + "!");
				}
			}
			return false;
		}
	    
	    
	    
	    



}
