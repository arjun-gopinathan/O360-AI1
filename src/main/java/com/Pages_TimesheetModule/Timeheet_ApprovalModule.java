package com.Pages_TimesheetModule;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.BasePackage.Base_Class;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class Timeheet_ApprovalModule extends Base_Class {
	
	private static By timeSheetIcon = By.xpath("//span[text()='Self Service']");
	private static By Approvals =By.xpath("//*[contains(text(),'Approvals') and @class='item-name lvl1']");
	private static By myTimesheet = By.xpath("//span[contains(text(),'My Timesheet')]");
	private static By pageLoad = By.xpath("//li[contains(text(),'Day View')]");
	private static By ApprovalpageLoad = By.xpath("//li[contains(text(),'Approval View')]");
	private static By ApprovalDetailViewpageLoad = By.xpath("//*[contains(text(),'Approval View - Detailed View')]");
	private static By timeSheetProjectName = By.xpath("//span[contains(text(),'Test')]");
	private static By timeSheetStatus = By.xpath("//span[contains(text(),'LOGGED')]");
	private static By timeSheetHours = By.xpath("//span[contains(text(),'LOGGED')]/b");
	private static By timeSheetDayView = By.xpath("//span[contains(text(),'Day View')]");
	private static By timeSheetWeekView = By.xpath("//span[contains(text(),'Week View')]");
	private static By timeSheetMonthView = By.xpath("//span[contains(text(),'Month View')]");
	private static By newEntry= By.xpath("//button[contains(text(),'New Entry')]");
	private static By projectDropDown1 = By.xpath("//select[@id='Project']");
	//private static By projectName1 = By.xpath("//option[contains(text(),'Test')]");
	private static By modalClose1 = By.xpath("(//button[text()='Close'])[1]");
	private static By weeklyViewDropDown = By.xpath("//select[@class='yr-select ng-untouched ng-pristine ng-valid']");
	private static By weeklyDetailViewOption = By.xpath("//option[text()='Weekly Detail View']");
	private static By weeklyNormalViewOption = By.xpath("//option[text()='Weekly Normal View']");
	private static By projectDropDown2 = By.xpath("//select[@class='prjct-select']");
	private static By projectDropDown3 = By.xpath("//option[@value='5261']");
	private static By firstWeekday = By.xpath("(//li[@class='ng-star-inserted']/div)[1]");
	private static By modalClose2 = By.xpath("//button[@class='close']");
	private static By moduleDropdown = By.xpath("//select[@id='Phase']");
	private static By workDescriptionTextbox = By.xpath("//textarea[@name='Comments']");
	private static By chooseFileElement = By.xpath("//div[@class='custom-file']/label");
	private static By chooseFile = By.xpath("//input[@id='chooseFile']");
	private static By hoursField = By.xpath("//input[@id='TimespentHours']");
	private static By minuteField = By.xpath("//input[@id='TimespentMinutes']");
	private static By moduleOptions1 = By.xpath("//select[@id='Phase']/option");
	private static By moduleDropdown2 = By.xpath("(//select[@class='mdl-select'])[1]");
	//(//select[@class='mdl-select'])[1]
	private static By moduleOptions2 = By.xpath("(//select[@class='mdl-select'])[1]/option");
	//private static By moduleSelectOption = By.xpath("//option[text()=' Design/Development ']");
	private static By selectDayDropDown = By.xpath("//span[@class='dropdown-down']");
	private static By selectDay = By.xpath("//div[text()='Monday']");
	
	private static By addButton = By.xpath("//button[@type='button' and text()=' ADD ']");
	private static By enterHours1 = By.xpath("(//input[@name='hours'])[1]");
	private static By enterDescription1 = By.xpath("(//textarea[@class='ng-untouched ng-pristine ng-valid ng-star-inserted'])[1]");
	//private static By enterDescription2 = By.xpath("(//textarea[@class='ng-untouched ng-pristine ng-valid ng-star-inserted'])[2]");
	private static By invalidHoursErrorMessage1 = By.xpath("(//div[@class='modal-body']/div/span)[6]");
	private static By okayButton = By.xpath("//button[text()='Ok']");
	private static By saveWithoutSubmit = By.xpath("//button[text()='Save Without Submit']");
	private static By saveandSubmit = By.xpath("//button[text()=' Save and Submit']");
	
	private static By hideContentButton = By.xpath("//span[@class='calendar' and contains(text(),'Monday')]/parent::div");
	private static By timesheetRemoveButton = By.xpath("//span[@title='Remove']");
	private static By confirmYes = By.xpath("//button[text()='Yes']");
	private static By modalElement = By.xpath("(//div[@class='modal-content'])[1]");
	private static By uploadedFile = By.xpath("//div[@class='custom-file']//following-sibling::span[contains(@class,'badge')]");
	private static By saveEntryButton = By.xpath("//button[text()='Save']");
	private static By daysOfWeek = By.xpath("//div[@class='header ng-star-inserted']//span[contains(text(),'day')]");
	private static By weekDateSelect = By.xpath("(//select[@class='yr-select'])[2]");
	private static By weekDateOptions = By.xpath("(//select[@class='yr-select'])[2]/option");
	private static By weekdayList = By.xpath("//ul[@class='item2']/li[@class='multiselect-item-checkbox ng-star-inserted']");
	private static By invalidHoursErrorMessage2 = By.xpath("//div[@class='eform-validation ng-star-inserted']");
	private static By copyToDropdown = By.xpath("(//select[@class='mdl-select'])[3]");
	private static By timesheetDeleteButtonDayView = By.xpath("//a[@title='Delete']");
	private static By confirmDeleteTimesheetButton = By.xpath("//button[@type='button' and text()='Yes']");
	private static By botttomSlidingPopupIcon = By.xpath("//span[@class='mat-button-wrapper']/mat-icon");
	private static By bspProjectDetails = By.xpath("//div[@class='t_row']/div[text()='Project details']");
	private static By bspAllocationPercentage = By.xpath("//div[@class='t_row']/div[text()='Allocation %']");
	private static By bspStartDate = By.xpath("//div[@class='t_row']/div[text()='Start Date']");
	private static By bspEndDate = By.xpath("//div[@class='t_row']/div[text()='End Date']");
	private static By currentWeek = By.xpath("//div[@class='t_head']/span[text()='Current Week']");
	private static By currentWeekPlanned = By.xpath("//div[@class='t_head']/span[text()='Current Week']/following-sibling::div/div[text()=' Planned']");
	private static By currentWeekActual = By.xpath("//div[@class='t_head']/span[text()='Current Week']/following-sibling::div/div[text()='Actual ']");
	private static By currentMonth = By.xpath("//div[@class='t_head']/span[text()='Current Month']");
	private static By currentMonthPlanned = By.xpath("//div[@class='t_head']/span[text()='Current Month']/following-sibling::div/div[text()='Planned']");
	private static By currentMonthActual = By.xpath("//div[@class='t_head']/span[text()='Current Month']/following-sibling::div/div[text()='Actual ']");
	private static By project = By.xpath("//div[@class='t_head']/span[text()='Project ']");
	private static By projectPlanned = By.xpath("//div[@class='t_head']/span[text()='Project ']/following-sibling::div/div[text()=' Planned']");
	private static By projectActual = By.xpath("//div[@class='t_head']/span[text()='Project ']/following-sibling::div/div[text()='Actual ']");
	private static By weeklyNormViewId = By.xpath("//table[@id='wk-view']");
	private static By DetailedView = By.xpath("//*[text()='Detailed View']");
	private static By NormalView = By.xpath("//*[text()='Normal View']");
	private static By ApproveButton = By.xpath("(//*[@title='Approve'])[1]");
	private static By RejectButton = By.xpath("(//*[@title='Reject'])[1]");
	private static By HoursElements =By.xpath("//input[@name='hours']");
	private static By weekNormViewProjectSelDropDown = By.xpath("//select[contains(@class,'prjct-select')]");
	private static By weekNormViewModuleSelDropdown = By.xpath("//select[contains(@class,'mdl-select')]");
	private static By previousWeekButton = By.xpath("//*[@class='fas fa-chevron-left']");
	private static By RequestCancled = By.xpath("//*[text()='Request Cancel Submission']");
	private static By ReasonForCancelText = By.xpath("//*[@style='overflow: hidden;height: 48px!important;']");
	private static By ReasonForCancelRequestButton = By.xpath("//*[text()='Request']");
	private static By CancelRequest = By.xpath("(//*[contains(text(),'Cancel Request')])[2]");
	private static By CancelRequestLoad = By.xpath("//*[text()='Cancel Requests']");
	private static By RejectRequestComment = By.xpath("//*[@style='overflow: hidden;height: 48px!important;']");
	private static By RejectButtonForRequest = By.xpath("//button[text()='Reject']");
	private static By userDropDown = By.xpath("//div[@id='userDropdown']/h4");
	private static By L_signout = By.xpath("//button[@class='dropdown-item ' and contains(text(),'Sign out')]");
	private static By AllEmployeesDropDown = By.xpath("//*[text()='All Employees']");
	private static By SelectEmployees = By.xpath("//*[@name='selectedEmployees']");
	private static By Search = By.xpath("//*[text()=' Search ']");
	private static By Approve = By.xpath("//*[@class='far fa-check-circle']");
	private static By ReminderPopup = By.xpath("//*[contains(text(),'Are you sure you want to send')]");
	private static By L_username = By.xpath("//input[@id='Username']");
	private static By L_password = By.xpath("//input[@id='Password']");
	private static By L_SignIn = By.xpath("//span[contains(text(),'Sign In')]");
	
	
	//*[@name='selectedEmployees']//*/div[text()='Drishya Devan']
	
	
	public boolean NavigateToMyTimeSheet() throws InterruptedException 
	{
		click(timeSheetIcon);
		click(myTimesheet);
		Thread.sleep(1000);
		Boolean flag = ElementDisplayed(pageLoad);
		return flag;
	}
	
	public boolean NavigateToApproval() throws InterruptedException 
	{
		click(timeSheetIcon);
		click(Approvals);
		Boolean flag = ElementDisplayed(ApprovalpageLoad);
		
		return flag;
	}
	
	public void SelectEmployeeForApproval(String EmployeeName) {
		try {
			click(AllEmployeesDropDown);
			Thread.sleep(100);
			click(By.xpath("//*[@name='selectedEmployees']//*/div[text()='"+EmployeeName+"']"));
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		
	}
	
	
	public boolean NavigateToDetailedView() throws InterruptedException 
	{
		click(DetailedView);
		Thread.sleep(1000);
		Boolean flag = ElementDisplayed(ApprovalDetailViewpageLoad);
		return flag;
	}
	
	public boolean ValidateApproval() throws InterruptedException 
	{
		click(ApproveButton);
		Thread.sleep(1000);
		Boolean flag = ElementDisplayed(ApproveButton);
		Log.info("System or PMO successfully approve the timesheet");
		return flag;
	}
	
	public boolean ValidateReject() throws InterruptedException 
	{
		click(RejectButton);
		Thread.sleep(1000);
		Boolean flag = ElementDisplayed(RejectButton);
		Log.info("System or PMO successfully rejected the timesheet.");
		return flag;
	}
	
	
	

	public boolean NavigateToCancelRequest() throws InterruptedException 
	{   
		click(timeSheetIcon);
		click(CancelRequest);
		Thread.sleep(1000);
		Boolean flag = ElementDisplayed(CancelRequestLoad);
		Log.info("System or PMO successfully navigate to Cancel request page");
		return flag;
	}

	
	public void ValidateValidTimesheetEntry(String projectName, String moduleName, String day) throws Exception
	{
		click(timeSheetWeekView);
		Thread.sleep(1000);
		click(weeklyViewDropDown);
		click(weeklyDetailViewOption);
		click(weeklyNormalViewOption);
		click(projectDropDown2);
		Thread.sleep(2000);
		click(By.xpath("//option[contains(text(),'"+projectName+"')]"));
		
		click(moduleDropdown2);
		click(By.xpath("//option[contains(text(),'"+moduleName+"')]"));
		click(selectDayDropDown);
//		click(selectDay);
		click(By.xpath("//div[text()='"+day+"']"));
		click(addButton);
		input(enterHours1, "08" + Keys.TAB);
//		FillValidHour();
		input(enterDescription1,"Test Automation." + Keys.TAB);
		//click(saveandSubmit);
		click(saveWithoutSubmit);
		ExtentTestManager.getTest().log(Status.PASS, "Added timesheet entry for 1 day.");
		Log.info("Added timesheet entry for 1 day.");
		
		click(hideContentButton);
		click(timesheetRemoveButton);
		click(confirmYes);
		click(saveWithoutSubmit);
		
		
	}
	
	
	public void ValidateTimesheetEntry(String projectName, String moduleName, String day) throws Exception
	{
		click(timeSheetWeekView);
		Thread.sleep(1000);
		click(weeklyViewDropDown);
		click(weeklyDetailViewOption);
		
		click(projectDropDown2);
		Thread.sleep(2000);
		click(By.xpath("//option[contains(text(),'"+projectName+"')]"));
		click(moduleDropdown2);
		click(By.xpath("//option[contains(text(),'"+moduleName+"')]"));
		click(selectDayDropDown);
		click(By.xpath("//div[text()='"+day+"']"));
		click(addButton);
		String[] list1 = {"MON", "TUE", "WED", "THU", "FRI"};

		for (int i=0;i<list1.length;i++)
		{
		String val = String.valueOf(i+1);
		input(By.xpath("(//li[contains(text(),'"+list1[i]+"')]/ancestor::tr/following-sibling::tr//td[@class='data ng-star-inserted'])["+val+"]//input"), "08" + Keys.TAB);

		}
	    click(saveandSubmit);
	    click(confirmYes);
		Thread.sleep(2000);
		
	}
	
	
	public void NavigateToPreviousWeekTimeSheetWeeklyNormalView() throws InterruptedException
	{
		
		click(timeSheetWeekView);
		click(weeklyViewDropDown);
		click(weeklyNormalViewOption);
//		select(projectName, weekNormViewProjectSelDropDown);
//		Thread.sleep(100);
//		select(moduleName, weekNormViewModuleSelDropdown);
		Thread.sleep(500);
		click(previousWeekButton);

		

	}
	
	
	public void SubmitPreviousWeekTimeSheetOnDifferentCondition(String projectName,String moduleName) {
		Boolean SaveAndSubmit = ElementEnableOrDisable(saveandSubmit); 
		Boolean SaveWithoutSubmit = ElementEnableOrDisable(saveWithoutSubmit);
		Boolean RequestAndCancel = ElementEnableOrDisable(RequestCancled);
		Boolean SaveAndSubmitDisable = CheckElementDisable(saveandSubmit); 
		Boolean SaveWithoutSubmitDisable = CheckElementDisable(saveWithoutSubmit);
		Boolean RequestAndCancelDisable = CheckElementDisable(RequestCancled);	
		Boolean Condition1=RequestAndCancel;
		Boolean Condition2=(SaveAndSubmitDisable && SaveWithoutSubmitDisable && RequestAndCancelDisable);	

        if(SaveAndSubmit) {
        	try {
        		String[] list1 = {"MON", "TUE", "WED", "THU", "FRI"};
        		for (int i=0;i<list1.length;i++)
        		{
        		String val = String.valueOf(i+1);
        		input(By.xpath("(//li[contains(text(),'"+list1[i]+"')]/ancestor::tr/following-sibling::tr//td[@class='data ng-star-inserted'])["+val+"]//input"), "08" + Keys.TAB);
        		}
				click(saveandSubmit);
				Thread.sleep(1500);
				click(confirmYes);
				Thread.sleep(1000);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
   
          }else if (RequestAndCancel) { 
        	  for(int i=0;i<2;i++) {
	        	  try {
	  				click(RequestCancled);
	  				Log.info("Successfully clicked on Request cancel button");
	  				clear(ReasonForCancelText);
	  				input(ReasonForCancelText,"This is test message for Cancel TimeSheet");
	  				click(ReasonForCancelRequestButton);
	  				Thread.sleep(1000);											
	  				try {
	  					if(ElementDisplayed(ReminderPopup)) {				
	  						click(confirmYes);
	  						Thread.sleep(1000);
	  					 }
		  				} catch (org.openqa.selenium.NoSuchElementException e) {
		
		  					Log.info("No reminder!!!");
		  				}
			  								
		  			} catch (InterruptedException e) {
		  				
		  				Log.info("Error found :"+e);
		  			}
	        	    
	        	  }
				try {
					click(userDropDown);
					click(L_signout);
					String PMOUserName = configloader().getProperty("PMOUserName");
					String PMOPassword = configloader().getProperty("PMOPassword");
					String UserName = configloader().getProperty("UserName");
					String Password = configloader().getProperty("Password");
					input(L_username, PMOUserName);
					input(L_password, PMOPassword);
					click(L_SignIn);
					Log.info("Successfully login as PMO since time sheet need to approve for cancel first");
					NavigateToCancelRequest();
					
					try {
						ApproveReject("Clement Joseph","Approve");
						Log.info("PMO successfully approve the request cancel time sheet");
						click(userDropDown);
						click(L_signout);
						input(L_username, UserName);
						input(L_password, Password);
						click(L_SignIn);
						Log.info("Employee successfully Login");
						NavigateToMyTimeSheet();
						click(timeSheetWeekView);
						click(weeklyViewDropDown);
						click(weeklyNormalViewOption);
						Thread.sleep(500);
						click(previousWeekButton);
						click(saveandSubmit);
  						click(confirmYes);
  						Thread.sleep(1000);
						

					} catch (Exception e) {
						e.printStackTrace();
					}
					
					
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
        	  

          }
  
	}
			
	
	public void ValidatePreviousWeekTimeSheetWeeklyNormalView(String projectName, String moduleName, String path) throws InterruptedException
	{
	click(timeSheetWeekView);
	click(weeklyViewDropDown);
	click(weeklyNormalViewOption);
	click(previousWeekButton);
	ValidateRequestCancel(projectName,moduleName);
	
	}
	
	
	
	
	public void ValidateRequestCancel(String projectName, String moduleName) {
		if (ElementEnableOrDisable(RequestCancled)) {
			Log.info("Timesheet found already filled");
			for(int i=0;i<2;i++) {	
			 try {
				click(RequestCancled);
				Log.info("Successfully clicked on Request cancel button");
				clear(ReasonForCancelText);
				input(ReasonForCancelText,"This is test message for Cancel TimeSheet");
				click(ReasonForCancelRequestButton);
				Thread.sleep(1000);											
				  try {
					if(ElementDisplayed(ReminderPopup)) {				
						click(confirmYes);
						Thread.sleep(500);
					   }
					  } catch (org.openqa.selenium.NoSuchElementException e) {
						  Log.info("No reminder!!!");
					   }				
				   } catch (InterruptedException e) {
					   Log.info("Error found :"+e);
				     }
			}
		}else
		    try {
			    click(saveandSubmit);
			    click(confirmYes);
				Thread.sleep(2000);
				click(RequestCancled);
				clear(ReasonForCancelText);
				Thread.sleep(500);
				input(ReasonForCancelText,"This is test message for Cancel TimeSheet");
				click(ReasonForCancelRequestButton);
									
			} catch (InterruptedException e) {
				e.printStackTrace();
			}  
		
	}

	
	public void ApproveReject(String EmployeeName,String Action) {
		String LeftXpath="//tr[@class='ng-star-inserted']/td[@data-title='EmployeeName']/span[text()='"+EmployeeName+"']";
		String RightXpath="//parent::td//parent::tr//*[@title='"+Action+"']";
		String FinalXpath=LeftXpath+RightXpath;
		try {
			ScrollUntilElementVisible(By.xpath(FinalXpath));
			click(By.xpath(FinalXpath));
			click(confirmYes);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public void Approve(String EmployeeName,String Action) {
		String LeftXpath="//tr[@class='ng-star-inserted']/td[@data-title='EmployeeName']/span[text()='"+EmployeeName+"']";
		String RightXpath="//parent::td//parent::tr//*[@title='"+Action+"']";
		String FinalXpath=LeftXpath+RightXpath;
		try {
			ScrollUntilElementVisible(By.xpath(FinalXpath));
			click(By.xpath(FinalXpath));
			click(confirmYes);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void ApproveButton() {
	try {
		click(Approve);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	
		
	}

	
	public void CancelRequestReject(String EmployeeName,String Action) {
		String LeftXpath="//tr[@class='ng-star-inserted']/td[@data-title='EmployeeName']/span[text()='"+EmployeeName+"']";
		String RightXpath="//parent::td//parent::tr//*[@title='"+Action+"']";
		String FinalXpath=LeftXpath+RightXpath;
		try {
			ScrollUntilElementVisible(By.xpath(FinalXpath));
			click(By.xpath(FinalXpath));
			input(RejectRequestComment,"This is test message for Cancel TimeSheet");
			click(RejectButtonForRequest);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public boolean ValidateTimeSheetDisplayedAndWeekViewEntryAndSaveWithoutSubmit(String projectName, String moduleName, String day) throws Exception
	{
		click(timeSheetWeekView);
		Thread.sleep(1000);
		click(weeklyViewDropDown);
		click(weeklyDetailViewOption);
		click(projectDropDown2);
		Thread.sleep(2000);
		click(By.xpath("//option[contains(text(),'"+projectName+"')]"));
		
		click(moduleDropdown2);
		click(By.xpath("//option[contains(text(),'"+moduleName+"')]"));
		click(selectDayDropDown);
		
		click(By.xpath("//div[text()='"+day+"']"));
		click(addButton);
		input(enterHours1, "08" + Keys.TAB);
		
		input(enterDescription1,"Test Automation." + Keys.TAB);
		
		click(saveWithoutSubmit);
		
		click(timeSheetDayView);
		
		Boolean flag1 = ElementDisplayed(timeSheetProjectName);
		Boolean flag2 = ElementDisplayed(timeSheetStatus);
		Boolean flag3 = ElementDisplayed(timeSheetHours);
		Boolean flag = flag1 & flag2 & flag3;
		
		
		return flag;
	}
	
	public boolean ValidateTimeSheetView() throws InterruptedException 
	{
		Boolean flag1 = ElementDisplayed(timeSheetDayView);
		Boolean flag2 = ElementDisplayed(timeSheetWeekView);
		Boolean flag3 = ElementDisplayed(timeSheetMonthView);
		Boolean flag = flag1 & flag2 & flag3;
		return flag;
	}
	
	
	public boolean ValidateProjectAndModuleNamesDisplayed(String projectName, String moduleName) throws InterruptedException 
	{
		click(newEntry);
		Thread.sleep(1000);
		click(projectDropDown1);
		Boolean flag00 = ElementDisplayed(By.xpath("//option[contains(text(),'"+projectName+"')]")); 
		click(By.xpath("//option[contains(text(),'"+projectName+"')]"));
		Thread.sleep(1000);
		click(moduleDropdown);
		Boolean flag01 = flag00 & ElementDisplayed(moduleOptions1);
		
		if (flag01)
		{
			ExtentTestManager.getTest().log(Status.PASS, "Project list and module lists loaded in the respective drop downs.");
			Log.info("Project list and module lists loaded in the respective drop downs.");
		}
		
		click(By.xpath("//option[contains(text(),'"+moduleName+"')]"));
		Thread.sleep(2000);
		click(modalClose1);
		
		if (ElementDisplayed(modalElement))
		{ 	
			ExtentTestManager.getTest().log(Status.FAIL, "Modal closed : " + false);
			Log.info("Modal closed : " + false);
			
		}
		
		else
		{
			ExtentTestManager.getTest().log(Status.PASS, "Modal closed : " + true);
			Log.info("Modal closed : " + true);
			
		}
		
		Thread.sleep(1000);
		click(timeSheetWeekView);
		Thread.sleep(1000);
		click(weeklyViewDropDown);
		click(weeklyDetailViewOption);
		click(projectDropDown2);
		Boolean flag10 = ElementDisplayed(By.xpath("//option[contains(text(),'"+projectName+"')]")); 
		click(By.xpath("//option[contains(text(),'"+projectName+"')]"));
		Thread.sleep(1000);
		click(moduleDropdown2);
		
		Boolean flag11 = flag10 & ElementDisplayed(moduleOptions2);
		
		Thread.sleep(2000);
		 
		click(weeklyViewDropDown);
		click(weeklyNormalViewOption);
		
		//Validating Weekly Normal View Load
		Thread.sleep(1000);
		if (ElementDisplayed(weeklyNormViewId))
		{
			ExtentTestManager.getTest().log(Status.PASS, "Weekly Normal View Loaded : " + true);
			Log.info("Weekly Normal View Loaded : " + true);
		}
		
		click(projectDropDown3);
		Boolean flag20 = ElementDisplayed(By.xpath("//option[contains(text(),'"+projectName+"')]"));
		click(By.xpath("//option[contains(text(),'"+projectName+"')]"));
		Thread.sleep(1000);
		click(moduleDropdown2);
		Boolean flag21 = flag20 & ElementDisplayed(moduleOptions2);
		Thread.sleep(2000);
		
		click(timeSheetMonthView); 
		Thread.sleep(12000);
		click(firstWeekday);
		Thread.sleep(1000);
		click(projectDropDown1);
		Boolean flag30 = ElementDisplayed(By.xpath("//option[contains(text(),'"+projectName+"')]")); 
		click(By.xpath("//option[contains(text(),'"+projectName+"')]"));
		Thread.sleep(1000);
		
		click(moduleDropdown);  
		Boolean flag31 = flag30 & ElementDisplayed(moduleOptions1); 
		
		click(modalClose2);
		
		
		Boolean flag = flag01 & flag11 & flag21 & flag31;
		return flag; 
	}
	 
	public boolean ValidateDayToDayTimeSheetDisplayedInDayView() throws InterruptedException 
	{
		click(timeSheetDayView);
		String[] list1 = {"MON"};
		Boolean flag = true;
		
		for (int i=0;i<list1.length;i++)
		{
			By weekDay = By.xpath("//td[contains(text(),'"+list1[i]+"')]");
			click(weekDay);
			flag = flag & ElementDisplayed(timeSheetProjectName) & ElementDisplayed(timeSheetStatus) & ElementDisplayed(timeSheetHours);
			Thread.sleep(500);
			ExtentTestManager.getTest().log(Status.PASS, list1[i] + " : " + flag);
			Log.info(list1[i] + " : " + flag);
			
			click(timesheetDeleteButtonDayView);
			click(confirmDeleteTimesheetButton);
			ExtentTestManager.getTest().log(Status.PASS, "Timesheet for " + list1[i] + " deleted!");
			Log.info("Timesheet for " + list1[i] + " deleted!");
			
		}
		
		
		return flag;
	}
	
	public boolean ValidateNewTimesheetEntryForm() throws InterruptedException 
	{
		click(timeSheetDayView);
		click(newEntry);
		ExtentTestManager.getTest().log(Status.PASS, "New Entry Button Icon to Add Timesheet displayed.");
		Log.info("New Entry Button Icon to Add Timesheet displayed.");
		
		Thread.sleep(1000);
		Boolean flag00 = ElementDisplayed(moduleDropdown);
		Boolean flag01 = ElementDisplayed(workDescriptionTextbox);
		Boolean flag02 = ElementDisplayed(chooseFileElement);
		Boolean flag03 = ElementDisplayed(hoursField);
		Boolean flag04 = ElementDisplayed(minuteField);
		Boolean flag05 = ElementDisplayed(projectDropDown1);
		
		click(modalClose1);
		
		Boolean flag = flag00 & flag01 & flag02 & flag03 & flag04 & flag05;
		return flag;
		
	}
	 
	public boolean ValidateErrorMessageOnInvalidTimesheetEntryWeekView(String projectName, String moduleName, String day) throws InterruptedException
	{
		click(timeSheetWeekView);
		Thread.sleep(1000);
		click(projectDropDown2);
		click(By.xpath("//option[contains(text(),'"+projectName+"')]"));
		Thread.sleep(1000);

		click(moduleDropdown2);
		click(By.xpath("//option[contains(text(),'"+moduleName+"')]"));
		click(selectDayDropDown);
		
		click(By.xpath("//div[text()='"+day+"']"));
		click(addButton);
		input(enterHours1, "45" + Keys.TAB);
		Boolean flag = ElementDisplayed(invalidHoursErrorMessage1);
		
		click(okayButton);
		
		input(enterHours1, "08" + Keys.TAB);
		
		input(enterDescription1,"Test Automation." + Keys.TAB);
		click(saveWithoutSubmit);
		
		click(By.xpath("//div[@class='header ng-star-inserted']//span[contains(text(),'"+day+"')]/parent::div"));
		click(timesheetRemoveButton);
		click(confirmYes);
		
		return flag;
	}
	
	public boolean ValidateUploadFileDayView(String projectName, String moduleName, String day, String path) throws InterruptedException
	{
		click(timeSheetDayView);
		By weekDay = By.xpath("//td[contains(text(),'"+day+"')]");
		click(weekDay);
		click(newEntry);
		Thread.sleep(1000);
		
		click(projectDropDown1);
		click(By.xpath("//option[contains(text(),'"+projectName+"')]"));
		Thread.sleep(1000);
		
		click(moduleDropdown);
		click(By.xpath("//option[contains(text(),'"+moduleName+"')]"));
		Thread.sleep(1000);
		
		input(hoursField, "07" + Keys.TAB);
		input(minuteField, "20");
		
		UploadFile(chooseFile, path);
		Thread.sleep(3000);
		boolean flag = ElementDisplayed(uploadedFile);
		
		click(saveEntryButton);
		
		click(timesheetDeleteButtonDayView);
		click(confirmDeleteTimesheetButton);
		ExtentTestManager.getTest().log(Status.PASS, "Timesheet for " + day + " deleted!");
		Log.info("Timesheet for " + day + " deleted!");
		
		return flag;
		
	}
	
	public boolean ValidateWeekDetailedView(String projectName, String moduleName) throws InterruptedException
	{
		click(timeSheetWeekView);
		Thread.sleep(1000);
		click(weeklyViewDropDown);
		click(weeklyDetailViewOption);
		
		boolean flag1 = ElementDisplayed(daysOfWeek);
		
		boolean flag2 = ElementDisplayed(weekDateSelect);
		
		click(weekDateSelect);
		
		boolean flag3 = ElementDisplayed(weekDateOptions);
		
		Thread.sleep(1000);
		click(projectDropDown2);
		click(By.xpath("//option[contains(text(),'"+projectName+"')]"));
		Thread.sleep(1000);

		click(moduleDropdown2);
		click(By.xpath("//option[contains(text(),'"+moduleName+"')]"));
		click(selectDayDropDown);
		
		boolean flag4 = ElementDisplayed(weekdayList);
		
		boolean flag = flag1 & flag2 & flag3 & flag4;
		
		return flag;
		
	}
	
	public boolean ValidateInvalidTimesheetEntryDayView(String projectName, String moduleName, String day) throws InterruptedException
	{
		click(timeSheetDayView);
		By weekDay = By.xpath("//td[contains(text(),'"+day+"')]");
		click(weekDay);
		click(newEntry);
		Thread.sleep(1000);
		
		click(projectDropDown1);
		click(By.xpath("//option[contains(text(),'"+projectName+"')]"));
		Thread.sleep(1000);
		
		click(moduleDropdown);
		click(By.xpath("//option[contains(text(),'"+moduleName+"')]"));
		Thread.sleep(1000);
		
		input(hoursField, "40" + Keys.TAB);
		boolean flag = ElementDisplayed(invalidHoursErrorMessage2);
		
		clear(hoursField);
		
		input(hoursField, "08" + Keys.TAB);
		
		click(saveEntryButton);
		
		click(timesheetDeleteButtonDayView);
		click(confirmDeleteTimesheetButton);
		ExtentTestManager.getTest().log(Status.PASS, "Timesheet for " + day + " deleted!");
		Log.info("Timesheet for " + day + " deleted!");
		
		return flag;
		
	}
	
	public boolean ValidateBottomSlidingPopup() throws InterruptedException
	{
		click(timeSheetDayView);
		click(botttomSlidingPopupIcon);
		
		boolean flag1 = ElementDisplayed(bspProjectDetails);
		boolean flag2 = ElementDisplayed(bspAllocationPercentage);
		boolean flag3 = ElementDisplayed(bspStartDate);
		boolean flag4 = ElementDisplayed(bspEndDate);
		boolean flag5 = ElementDisplayed(currentWeek);
		boolean flag6 = ElementDisplayed(currentWeekPlanned);
		boolean flag7 = ElementDisplayed(currentWeekActual);
		boolean flag8 = ElementDisplayed(currentMonth);
		boolean flag9 = ElementDisplayed(currentMonthPlanned);
		boolean flag10 = ElementDisplayed(currentMonthActual);
		boolean flag11 = ElementDisplayed(project);
		boolean flag12 = ElementDisplayed(projectPlanned);
		boolean flag13 = ElementDisplayed(projectActual);
		
		boolean flag = flag1 & flag2 & flag3 & flag4 & flag5 & flag6 & flag7 & flag8 & flag9 & flag10 & flag11 & flag12 & flag13;
		
		click(botttomSlidingPopupIcon);
		return flag;
		
	}
	
	public void ValidateCopyTo(String projectName, String moduleName, String day, String newDay) throws InterruptedException
	{
		click(timeSheetWeekView);
		Thread.sleep(1000);
		click(projectDropDown2);
		click(By.xpath("//option[contains(text(),'"+projectName+"')]"));
		Thread.sleep(1000);

		click(moduleDropdown2);
		click(By.xpath("//option[contains(text(),'"+moduleName+"')]"));
		click(selectDayDropDown);
		
		click(By.xpath("//div[text()='"+day+"']"));
		click(addButton);
		
		input(enterHours1, "08" + Keys.TAB);
		input(enterDescription1,"Test Automation." + Keys.TAB);
		click(saveWithoutSubmit);
		
		click(copyToDropdown);
		click(By.xpath("//option[contains(text(),'Copy to')]//following-sibling::option[contains(text(), '"+newDay+"')]"));
		
	}
	

	public void TearDown() throws InterruptedException
	{
		click(timeSheetDayView);
		String[] list1 = {"MON", "TUE", "WED", "THU", "FRI"};
		
		for (int i=0;i<list1.length;i++)
		{
			By weekDay = By.xpath("//td[contains(text(),'"+list1[i]+"')]");
			click(weekDay);
			try
			{
			boolean flag = ElementDisplayed(timesheetDeleteButtonDayView);
			if (flag)
			{
				click(timesheetDeleteButtonDayView);
				click(confirmDeleteTimesheetButton);
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

	public void ApproveTimesheet(String employeeName, String action) {
		// TODO Auto-generated method stub
		
	}
	

}
