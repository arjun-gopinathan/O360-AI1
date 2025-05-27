package com.Pages_TimesheetModule;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.BasePackage.Base_Class;
import com.Utility.Log;

public class Timesheet_TimesheetOnBehalf extends Base_Class
{
	
	private static By timeSheetIcon = By.xpath("//span[contains(text(),'Timesheet')]/parent::div");
	private static By timesheetOnBehalf = By.xpath("//span[contains(text(),'Timesheet On Behalf ')]");
	private static By pageLoad = By.xpath("//li[contains(text(),'Timesheet OnBehalf')]");
	private static By employeeSearchField = By.xpath("//input[@id='Employee']");
	private static By empSearchFieldPopup = By.xpath("//input[@name='search']");
	private static By empSearchResult = By.xpath("//table[@class='table']/tbody/tr/td");
	private static By okayButton = By.xpath("//button[text()='OK']");
	private static By tsOnBehalfProjectSelDropDown = By.xpath("//select[contains(@class,'prjct-select')]");
	private static By tsOnBehalfModuleSelDropDown = By.xpath("//select[contains(@class,'mdl-select')]");
	private static By addButton = By.xpath("//button[contains(text(),'ADD')]");
	private static By saveAndSubmitButton = By.xpath("//button[text()=' Save and Submit']");
	private static By tsOnBehalfPrevWeekSelector = By.xpath("(//button[@class='btn-outline-primary next-prev'])[1]");
	public static By cancelSubmittedTS = By.xpath("//button[contains(text(),'Cancel')]");
	public static By requestButton = By.xpath("//button[text()='Request']");
	public static By confirmationModal = By.xpath("//span[contains(text(),'Are you sure you want to send a remainder')]/ancestor::div[@class='modal-body']");
	public static By confirmYes = By.xpath("//button[text()='Yes']");
	private static By confirmOkay = By.xpath("//button[text()='Ok']");
	private static By projectOfTimesheetSubmitted = By.xpath("//div[contains(text(),'Vermont Staffing')]");
	private static By thisWeekButton = By.xpath("//button[text()='THIS WEEK']");
		
	
	
	
	public boolean NavigateToTimeSheetOnBehalf() throws InterruptedException 
	{
		click(timeSheetIcon);
		click(timesheetOnBehalf);
		Thread.sleep(1000);
		Boolean flag = ElementDisplayed(pageLoad);
		return flag;
		
	}
	
	public boolean ValidateSearchEmployeeForAddingTimesheetOnBehalf(String empName) throws InterruptedException
	{
		click(employeeSearchField);
		Thread.sleep(1000);
		
		input(empSearchFieldPopup, empName);
		
		click(empSearchResult);
		click(okayButton);
		Thread.sleep(1000);
		
		boolean flag = false;
		String name = driver.findElement(employeeSearchField).getAttribute("value");
		Thread.sleep(2000);
		
		if (name.equals(empName))
		{
			flag = true;
		}
		else
		{
			flag = false;
		}
			
		return flag;
	}
	
	public boolean ValidateWhetherPreviousWeekTimesheetSubmitted() throws InterruptedException
	{
		click(tsOnBehalfPrevWeekSelector);
		
		boolean flag1 = ElementEnabled(cancelSubmittedTS);
		
		return flag1;
		
	}
	
	public boolean ValidateAddTimesheetOnBehalfOfSearchedEmployee(String projectName, String moduleName, String empName) throws InterruptedException
	{
		if (ElementDisplayed(pageLoad)==false)
		{
			click(timeSheetIcon);
			click(timesheetOnBehalf);
			Thread.sleep(1000);
			
		}
		
		click(employeeSearchField);
		Thread.sleep(1000);
		
		input(empSearchFieldPopup, empName);
		
		click(empSearchResult);
		click(okayButton);
		Thread.sleep(1000);
		
		click(tsOnBehalfPrevWeekSelector);
		
		String correctProjectName = projectName.trim();
		click(tsOnBehalfProjectSelDropDown);
		select(correctProjectName, tsOnBehalfProjectSelDropDown);
		//click(tsOnBehalfProjectSelDropDown);
		//click(By.xpath("//option[text()='"+projectName+"']"));
		
		//select(moduleName, tsOnBehalfModuleSelDropDown);
		String correctModuleName = moduleName.trim();
		click(tsOnBehalfModuleSelDropDown);
		select(correctModuleName, tsOnBehalfModuleSelDropDown);
		//click(By.xpath("//option[text()='"+moduleName+"']"));
		
		click(addButton);
		
		String[] list1 = {"MON", "TUE", "WED", "THU", "FRI"};
		
		for (int i=0;i<list1.length;i++)
		{
			String val = String.valueOf(i+1);
			input(By.xpath("(//li[contains(text(),'"+list1[i]+"')]/ancestor::tr/following-sibling::tr//td[@class='data ng-star-inserted'])["+val+"]//input"), "08" + Keys.TAB);
			
		}
		
		try
		{
			click(confirmOkay);
		}
		
		catch (Exception e)
		{
			Log.info("No Okay button displayed!");
		}
		
		click(saveAndSubmitButton);
		
		click(confirmYes);
		
		return true;
	}
	
	public static boolean ValidateProjectNameOfSubmittedTimesheet(String projectName) throws InterruptedException
	{
		if (ElementEnabled(thisWeekButton))
		{
			click(thisWeekButton);
			click(tsOnBehalfPrevWeekSelector);
			
		}
		
		
        boolean flag1 = ElementDisplayed(projectOfTimesheetSubmitted);
		
		return flag1;
		
	}

}
