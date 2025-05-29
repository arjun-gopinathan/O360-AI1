package com.Pages_TimesheetModule;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.BasePackage.Base_Class;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;
import com.Page_Repositary.PageRepositary_TimeSheetModule;


public class Timeheet_WeekView extends Base_Class
{
	PageRepositary_TimeSheetModule PageRepositary= new PageRepositary_TimeSheetModule();
	
	 public boolean clickOnYearWeekSelection(String Month, String MonthWeek) throws InterruptedException {
		 click(PageRepositary.timeSheetWeekView);
		 Thread.sleep(1000);
		 click(PageRepositary.yearSelection);
	      // Thread.sleep(3000);
	       click(By.xpath("//option[contains(text(),'"+Month+"')]"));
	       //Thread.sleep(1000);
			 click(PageRepositary.yearSelection);
	        click(PageRepositary.yearWeekSelection);
	        //Thread.sleep(1000);
		    click(By.xpath("//option[contains(text(),'"+MonthWeek+"')]"));
		   // Thread.sleep(1000);
	        click(PageRepositary.yearWeekSelection);


	        return true;
	    }
	 public void enterTimesheetForTheSelectedWeekDetailedView(String projectName, String module) throws InterruptedException
	 {
		 click(PageRepositary.projectDropDown2);
			Thread.sleep(2000);
			click(By.xpath("//option[contains(text(),'"+projectName+"')]"));
			
			click(PageRepositary.moduleDropdown2);
			//input(PageRepositary.moduleSelect, moduleName);
			click(By.xpath("//span[contains(text(),'"+module+"')]"));
			click(PageRepositary.selectDayDropDown);
			click(PageRepositary.selectAll);
		
			click(PageRepositary.addButton);
			input(PageRepositary.enterHours1, "08" + Keys.TAB);
//			input(PageRepositary.enterDescription1,"Test Automation." + Keys.TAB);
			
			
			input(PageRepositary.enterHours2, "08" + Keys.TAB);
//			input(PageRepositary.enterDescription2,"Test Automation." + Keys.TAB);
			
			input(PageRepositary.enterHours3, "08" + Keys.TAB);
//			input(PageRepositary.enterDescription3,"Test Automation." + Keys.TAB);
			
			ScrollUntilElementVisible(PageRepositary.enterHours4);
			input(PageRepositary.enterHours4, "08" + Keys.TAB);
//			input(PageRepositary.enterDescription4,"Test Automation." + Keys.TAB);
			
			Thread.sleep(100);
			ScrollUntilElementVisible(PageRepositary.enterHours5);
			input(PageRepositary.enterHours5, "08" + Keys.TAB);
//			input(PageRepositary.enterDescription5,"Test Automation." + Keys.TAB);
			
			Thread.sleep(100);
			ScrollUntilElementVisible(PageRepositary.enterHours6);
			input(PageRepositary.enterHours6, "08" + Keys.TAB);
//			input(PageRepositary.enterDescription6,"Test Automation." + Keys.TAB);
			
			
			Thread.sleep(100);
			ScrollUntilElementVisible(PageRepositary.enterHours7);
			input(PageRepositary.enterHours7, "08" + Keys.TAB);
//			input(PageRepositary.enterDescription7,"Test Automation." + Keys.TAB);
			
			
			ScrollUntilElementVisible(PageRepositary.saveAndSubmit);
			click(PageRepositary.saveAndSubmit);
			Thread.sleep(500);
			click(PageRepositary.confirmYes1);
			Thread.sleep(2000);
			WaitForLoaderToDisappear();
			click(PageRepositary.feedBackEmoji);
			Thread.sleep(100);
			click(PageRepositary.SubmitBtn);
			WaitForLoaderToDisappear();
			Log.info("Submitted Timesheet");

	 }
	public void ValidateValidTimesheetEntryAndDeleteEntry(String projectName, String moduleName, String module, String day) throws Exception
	{
		click(PageRepositary.timeSheetWeekView);
		Thread.sleep(1000);
		click(PageRepositary.weeklyViewDropDown);
		click(PageRepositary.weeklyDetailViewOption);
		click(PageRepositary.projectDropDown2);
		Thread.sleep(2000);
		click(By.xpath("//option[contains(text(),'"+projectName+"')]"));
		
		click(PageRepositary.moduleDropdown2);
		//input(PageRepositary.moduleSelect, moduleName);
		click(By.xpath("//span[contains(text(),'"+module+"')]"));
//		click(PageRepositary.selectDayDropDown);
//		
//		click(By.xpath("//div[text()='"+day+"']"));
		click(PageRepositary.addButton);
		input(PageRepositary.enterHours1, "08" + Keys.TAB);
		
		input(PageRepositary.enterDescription1,"Test Automation." + Keys.TAB);
		click(PageRepositary.saveWithoutSubmit);
		ExtentTestManager.getTest().log(Status.PASS, "Added timesheet entry for 1 day.");
		Log.info("Added timesheet entry for 1 day.");
		
		click(By.xpath("//span[@class='calendar' and contains(text(),'"+day+"')]/parent::div"));
		click(PageRepositary.timesheetRemoveButton);
		click(PageRepositary.confirmYes1);
		click(PageRepositary.saveWithoutSubmit);
		
		
	}
	
	public boolean ValidateTimeSheetView() throws InterruptedException 
	{
		Boolean flag1 = ElementDisplayed(PageRepositary.timeSheetDayView);
		Boolean flag2 = ElementDisplayed(PageRepositary.timeSheetWeekView);
		Boolean flag3 = ElementDisplayed(PageRepositary.timeSheetMonthView);
		Boolean flag = flag1 & flag2 & flag3;
		return flag;
	}
	
	public boolean ValidateTimeSheetDisplayedAndWeekViewEntryAndSaveWithoutSubmit(String project, String moduleName, String module, String day, String projectName, String DayMonth,String MonthDay) throws Exception
	{
		Thread.sleep(1000);
		click(PageRepositary.weeklyViewDropDown);
		click(PageRepositary.weeklyDetailViewOption);
		click(PageRepositary.projectDropDown2);
		Thread.sleep(2000);
		click(By.xpath("//option[contains(text(),'"+project+"')]"));
		
		click(PageRepositary.moduleDropdown2);
		input(PageRepositary.moduleDropdown2, moduleName);
		click(By.xpath("//span[contains(text(),'"+module+"')]"));
		click(PageRepositary.selectDayDropDown);
		
		click(By.xpath("//div[text()='"+day+"']"));
		click(PageRepositary.addButton);
		input(PageRepositary.enterHours1, "08" + Keys.TAB);
		
		input(PageRepositary.enterDescription1,"Test Automation." + Keys.TAB);
	
		click(PageRepositary.saveWithoutSubmit);
		Thread.sleep(3000);
		click(PageRepositary.timeSheetDayView);
		click(PageRepositary.selectDateRange);
		 Thread.sleep(1000);
		 click(PageRepositary.selectMonth);
	      // Thread.sleep(3000);
	       click(By.xpath("//option[contains(text(),'"+DayMonth+"')]"));
	       Thread.sleep(1000);
		    click(By.xpath("//span[contains(text(),'"+MonthDay+"')]"));
		   Thread.sleep(1000);
		   click(PageRepositary.ClickOnDateRange);
		   Thread.sleep(2000);
		   
		Boolean flag1 = ElementDisplayed(By.xpath("//span[contains(text(),'"+projectName+"')]"));
		Boolean flag2 = ElementDisplayed(PageRepositary.timeSheetStatus);
		Boolean flag3 = ElementDisplayed(PageRepositary.timeSheetHours);
		Boolean flag = flag1 & flag2 & flag3;
		
		
		return flag;
	}
	
	public boolean ValidateErrorMessageOnInvalidTimesheetEntryWeekView(String project, String moduleName, String module, String day) throws InterruptedException
	{
		click(PageRepositary.timeSheetWeekView);
		
		click(PageRepositary.projectDropDown2);
		Thread.sleep(2000);
		click(By.xpath("//option[contains(text(),'"+project+"')]"));
		Thread.sleep(1000);

		click(PageRepositary.moduleDropdown2);
		input(PageRepositary.moduleDropdown2, moduleName);
		click(By.xpath("//span[contains(text(),'"+module+"')]"));
		click(PageRepositary.selectDayDropDown);
		
		click(By.xpath("//div[text()='"+day+"']"));
		click(PageRepositary.addButton);
		input(PageRepositary.enterHours1, "45" + Keys.TAB);
		Boolean flag = ElementDisplayed(PageRepositary.invalidHoursErrorMessage1);
		
		click(PageRepositary.okayButton);
		
		input(PageRepositary.enterHours1, "08" + Keys.TAB);
		
		input(PageRepositary.enterDescription1,"Test Automation." + Keys.TAB);
		click(PageRepositary.saveWithoutSubmit);
		Thread.sleep(3000);
		click(By.xpath("//div[@class='header ng-star-inserted']//span[contains(text(),'"+day+"')]/parent::div"));
		click(PageRepositary.timesheetRemoveButton);
		click(PageRepositary.confirmYes);
		
		return flag;
	}
	
	
	public boolean ValidateNavigationToWeeklyNormalView(String ProjectName2, String moduleName, String module) throws InterruptedException
	{
		click(PageRepositary.timeSheetWeekView);
		click(PageRepositary.weeklyViewDropDown);
		click(PageRepositary.weeklyNormalViewOption);
		
		boolean flag1 = ElementDisplayed(PageRepositary.weeklyNormalViewElement);
		
		click(PageRepositary.weekNormViewWeekDaySel);
		Thread.sleep(500);
		click(PageRepositary.weekNormViewPrevWeekSelector);
		Thread.sleep(500);
		click(PageRepositary.weekNormViewNextWeekSelector);
		Thread.sleep(500);
		click(PageRepositary.weekNormViewPrevWeekSelector);
		Thread.sleep(500);
		click(PageRepositary.weekNormViewThisWeekSelector);
		Thread.sleep(500);
		
		select(ProjectName2, PageRepositary.weekNormViewProjectSelDropDown);
	

		click(PageRepositary.moduleDD);
		input(PageRepositary.moduleDropdown2, moduleName);
		click(By.xpath("//span[contains(text(),'"+module+"')]"));
		
		click(PageRepositary.addButton);
		
		click(PageRepositary.addButton);
		
		boolean flag2 = ElementDisplayed(By.xpath("//tr[@class='ng-star-inserted']//div[contains(text(),'"+ProjectName2+"')]"));
		boolean flag3 = ElementDisplayed(By.xpath("//tr[@class='ng-star-inserted']//span[contains(text(),'"+module+"')]"));
		
		boolean flag = flag1;
		
		return flag;
		
		
		
	}
	
	public boolean ValidateErrorMessageOnGivingInvalidTimeWeeklyNormalView(String ProjectName2, String moduleName, String module, String day) throws InterruptedException
	{
		click(PageRepositary.timeSheetWeekView);
		click(PageRepositary.weeklyViewDropDown);
		click(PageRepositary.weeklyNormalViewOption);
		
		select(ProjectName2, PageRepositary.weekNormViewProjectSelDropDown);
		select(module, PageRepositary.weekNormViewModuleSelDropdown);click(PageRepositary.moduleDD);
		input(PageRepositary.moduleDropdown2, moduleName);
		click(By.xpath("//span[contains(text(),'"+module+"')]"));
		
		click(PageRepositary.addButton);
		
		input(By.xpath("//li[contains(text(),'"+day+"')]/ancestor::tr/following-sibling::tr//td[@class='data ng-star-inserted']//input"), "50" + Keys.TAB);
		
		boolean flag = ElementDisplayed(PageRepositary.invalidHoursErrorMessage3);
		
		click(PageRepositary.okayButton);
		
		return flag;
		
	}
	
	public boolean ValidateWeekDetailedView(String project, String moduleName, String module) throws InterruptedException
	{
		click(PageRepositary.timeSheetWeekView);
		Thread.sleep(1000);
		click(PageRepositary.weeklyViewDropDown);
		click(PageRepositary.weeklyDetailViewOption);
		
		boolean flag1 = ElementDisplayed(PageRepositary.daysOfWeek);
		
		boolean flag2 = ElementDisplayed(PageRepositary.weekDateSelect);
		
		click(PageRepositary.weekDateSelect);
		
		boolean flag3 = ElementDisplayed(PageRepositary.weekDateOptions);
		
		Thread.sleep(1000);
		click(PageRepositary.projectDropDown2);
		click(By.xpath("//option[contains(text(),'"+project+"')]"));
		Thread.sleep(1000);
		
		click(PageRepositary.moduleDropdown2);
		input(PageRepositary.moduleDropdown2, moduleName);
		click(By.xpath("//span[contains(text(),'"+module+"')]"));
		click(PageRepositary.selectDayDropDown);

		
		boolean flag4 = ElementDisplayed(PageRepositary.weekdayList);
		
		boolean flag = flag1 & flag2 & flag3 & flag4;
		
		return flag;
		
	}
	
	public boolean ValidateValidTimeAndUploadFileWeeklyNormalView(String ProjectName2,String moduleName, String module, String path) throws InterruptedException
	{
		click(PageRepositary.timeSheetWeekView);
		click(PageRepositary.weeklyViewDropDown);
		click(PageRepositary.weeklyNormalViewOption);
		
		select(ProjectName2, PageRepositary.weekNormViewProjectSelDropDown);
		select(module, PageRepositary.weekNormViewModuleSelDropdown);click(PageRepositary.moduleDD);
		input(PageRepositary.moduleDropdown2, moduleName);
		click(By.xpath("//span[contains(text(),'"+module+"')]"));
		
		click(PageRepositary.addButton);
		
		String[] list1 = {"MON", "TUE", "WED", "THU", "FRI"};
		
		for (int i=0;i<list1.length;i++)
		{
			String val = String.valueOf(i+1);
			input(By.xpath("(//li[contains(text(),'"+list1[i]+"')]/ancestor::tr/following-sibling::tr//td[@class='data ng-star-inserted'])["+val+"]//input"), "08" + Keys.TAB);
			
		}
		
		click(PageRepositary.saveWithoutSubmit);
		
		Thread.sleep(5000);
		
		UploadFile(PageRepositary.chooseFile, path);
		Thread.sleep(3000);
		boolean flag = ElementDisplayed(PageRepositary.uploadedFile);
		
		click(PageRepositary.saveWithoutSubmit);
		
		click(PageRepositary.uploadedFileRemove);
		
		click(PageRepositary.saveWithoutSubmit);
		
		return flag;
		
	}
	
	public boolean ValidateTimesheetEntryMonthView(String projectName, String module, String path) throws InterruptedException
	{
		TearDown();
		click(PageRepositary.timeSheetMonthView);
		Thread.sleep(1000);
		click(PageRepositary.pendingDayMonthView);
		
		Thread.sleep(1000);
		click(PageRepositary.projectDropDown1);
		Boolean flag1 = ElementDisplayed(By.xpath("//option[contains(text(),'"+projectName+"')]")); 
		click(By.xpath("//option[contains(text(),'"+projectName+"')]"));
		Thread.sleep(1000);
		
		click(PageRepositary.moduleDropdown);  
		Boolean flag2 = flag1 & ElementDisplayed(PageRepositary.moduleOptions1);
		click(By.xpath("//option[contains(text(),'"+module+"')]"));
		
		input(PageRepositary.timesheetDescriptionMonthlyView, "Test Automation." + Keys.TAB);
		
		input(PageRepositary.hoursField, "08" + Keys.TAB);
		input(PageRepositary.minuteField, "10" + Keys.TAB);
		
		
		UploadFile(PageRepositary.chooseFile, path);
		Thread.sleep(2000);
		
		boolean flag3 = ElementDisplayed(PageRepositary.uploadedFile);
		
		click(PageRepositary.saveButton);
		
		boolean  flag4 = ElementDisplayed(PageRepositary.savedRowMonthlyView);
		
		boolean flag = flag2 & flag3 & flag4;
		
		return flag;
		
		
	}
	
	public void TearDown() throws InterruptedException
	{
		Thread.sleep(2000);
		click(PageRepositary.timeSheetDayView);
		String[] list1 = {"MON", "TUE", "WED", "THU", "FRI"};
		
		for (int i=0;i<list1.length;i++)
		{
			By weekDay = By.xpath("//td[contains(text(),'"+list1[i]+"')]");
			click(weekDay);
			try
			{
			boolean flag = ElementDisplayed(PageRepositary.timesheetDeleteButtonDayView);
			if (flag)
			{
				click(PageRepositary.timesheetDeleteButtonDayView);
				click(PageRepositary.confirmDeleteTimesheetButton);
				ExtentTestManager.getTest().log(Status.PASS, "Timesheet for " + list1[i] + " deleted!");
				Log.info("Timesheet for " + list1[i] + " deleted!");
				Thread.sleep(1000);
			}
			
			}
			
			catch(Exception e1)
			{
				Log.info("No timesheet saved for " + list1[i] + "!");
			}
		}
		
	}

}
