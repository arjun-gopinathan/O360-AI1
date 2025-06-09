package com.Pages_TimesheetModule;

import java.time.Duration;
import java.util.List;

import javax.naming.ldap.PagedResultsResponseControl;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v128.page.Page;

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
	        //click(By.xpath("//option[normalize-space(text()) = '"+MonthWeek+"']"));
	        select(MonthWeek, PageRepositary.yearWeekSelection);
		    //click(By.xpath("//option[contains(text(),'"+MonthWeek+"')]"));
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
	
		//click(PageRepositary.saveWithoutSubmit);
		JavascriptClick(PageRepositary.saveWithoutSubmit, driver);
		
		// week view ends
		
		//day views starts
		Thread.sleep(3000);
		click(PageRepositary.timeSheetDayView);
		click(PageRepositary.selectDateRange);
		
		 Thread.sleep(1000);
		 click(PageRepositary.selectMonth);
	      // Thread.sleep(3000);
		 select(DayMonth, PageRepositary.selectMonth);
	       //click(By.xpath("//option[contains(text(),'"+DayMonth+"')]"));
	       Thread.sleep(1000);
		    click(By.xpath("//span[normalize-space(text())='"+MonthDay+"']"));
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
		input(PageRepositary.enterHours1, "45"+Keys.TAB);
		Boolean flag = ElementDisplayed(PageRepositary.invalidHoursErrorMessage1);
		
		click(PageRepositary.okayButton);
		
		input(PageRepositary.enterHours1, "08" + Keys.TAB);
		
		input(PageRepositary.enterDescription1,"Test Automation." + Keys.TAB);
		//click(PageRepositary.saveWithoutSubmit);
		JavascriptClick(PageRepositary.saveWithoutSubmit, driver);
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
		select(module, PageRepositary.weekNormViewModuleSelDropdown);
		click(PageRepositary.moduleDD);
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
		TearDown("", "");
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
	
	public void TearDown(String m, String d) throws InterruptedException
	{
		
		click(PageRepositary.timeSheetDayView);
		click(PageRepositary.dateRange);
		
		String month = m;
		if (m.length() > 3) {
            month = m.substring(0, 4);
        }
		
		select(month, PageRepositary.monthSelect);
		JavascriptClick(PageRepositary.weekRange(d), driver);
		
		List<String> days = List.of("MON", "TUE", "WED", "THU", "FRI");

	    for (String day : days) {
	        try {
	            List<WebElement> leaveElements = driver.findElements(PageRepositary.Leave(day));
	            List<WebElement> holidayElements = driver.findElements(PageRepositary.Holiday(day));

	            boolean isLeaveVisible = !leaveElements.isEmpty() && leaveElements.get(0).isDisplayed();
	            boolean isHolidayVisible = !holidayElements.isEmpty() && holidayElements.get(0).isDisplayed();
	            if (!isLeaveVisible && !isHolidayVisible) {
	            	JavascriptClick(PageRepositary.cell(day), driver);
	            	JavascriptClick(PageRepositary.dayViewDeleteLog, driver);
	            	click(PageRepositary.dayViewOK);
	            }

	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }
	    
	    Thread.sleep(Duration.ofSeconds(5));
		
		
	}
	
	public boolean validate1(String year, String month, String weekViewRange, String project, String moduleName) throws InterruptedException {
		click(PageRepositary.weekViewOption);
		click(PageRepositary.weekScreenView);
		select("Weekly Detail View", PageRepositary.weekScreenView);
		select(year, PageRepositary.year);
		select(month, PageRepositary.month);
		select(weekViewRange, PageRepositary.weekrange);
		
		select(project, PageRepositary.projectName);
		
		input(PageRepositary.moduleName, moduleName);
		Thread.sleep(Duration.ofSeconds(3));
		click(PageRepositary.moduleNameOpt(moduleName));
		
		click(PageRepositary.selectDays);
		String[] days = {"Monday", "Tuesday", "Wednesday"};
		for(String day : days) {
			click(PageRepositary.selectDaysOpt(day));
		}
		
		click(PageRepositary.add);
		
		/**List<WebElement> hours = driver.findElements(PageRepositary.dayHourLog());
		for(int i=0; i<hours.size(); i++) {
			hours.get(i).sendKeys("08");
			Thread.sleep(Duration.ofSeconds(3));
		}*/
		
		for(String day : days) {
			input(PageRepositary.dayHoursLog(day), "8");
			input(PageRepositary.dayDescription(day), day);
		}
		
		//input(PageRepositary.dayDescription, "data");
		
		Thread.sleep(Duration.ofSeconds(3));
		JavascriptClick(PageRepositary.saveWithOutSubmit, driver);
		
		boolean flag = ElementDisplayed(PageRepositary.exp_saveMsg);
		return flag;
		
	}
	
	public boolean validate2(String year, String month, String weekViewRange, String project, String moduleName) throws InterruptedException {
		click(PageRepositary.dayViewOption);
		click(PageRepositary.weekViewOption);
		click(PageRepositary.weekScreenView);
		select("Weekly Detail View", PageRepositary.weekScreenView);
		select(year, PageRepositary.year);
		select(month, PageRepositary.month);
		select(weekViewRange, PageRepositary.weekrange);
		
		/*select(" Projectone ", PageRepositary.projectName);
		
		input(PageRepositary.moduleName, "Prod");
		Thread.sleep(Duration.ofSeconds(3));
		click(PageRepositary.moduleNameOpt("Prod"));*/
		
		String[] days = {"Thursday", "Friday"};
		for(String day : days) {
			click(PageRepositary.addIconInDay(day));
			select(project, PageRepositary.moduleProjectname);
			
			input(PageRepositary.moduleModuleName, moduleName);
			Thread.sleep(Duration.ofSeconds(3));
			click(PageRepositary.moduleNameOpt(moduleName));
			
			click(PageRepositary.moduleAdd);
			
			Thread.sleep(Duration.ofSeconds(2));
		}
		
		for(String day : days) {
			input(PageRepositary.dayHoursLog(day), "8");
			input(PageRepositary.dayDescription(day), day);
		}
		
		
		
		Thread.sleep(Duration.ofSeconds(3));
		JavascriptClick(PageRepositary.saveWithOutSubmit, driver);
		
		boolean flag = ElementDisplayed(PageRepositary.exp_saveMsg);
		
		return flag;
		
	}
	
	public boolean validation3(String m, String d) throws InterruptedException {
		
		JavascriptClick(PageRepositary.weekViewOption, driver);
		JavascriptClick(PageRepositary.dayViewOption, driver);
		click(PageRepositary.dateRange);
		
		String month= m;
		if (m.length() > 3) {
            month = m.substring(0, 4);
        }
		select(month, PageRepositary.monthSelect);
		JavascriptClick(PageRepositary.weekRange(d), driver);
		
	    List<String> days = List.of("MON", "TUE", "WED", "THU", "FRI");

	    for (String day : days) {
	        try {
	            List<WebElement> leaveElements = driver.findElements(PageRepositary.Leave(day));
	            List<WebElement> holidayElements = driver.findElements(PageRepositary.Holiday(day));

	            boolean isLeaveVisible = !leaveElements.isEmpty() && leaveElements.get(0).isDisplayed();
	            boolean isHolidayVisible = !holidayElements.isEmpty() && holidayElements.get(0).isDisplayed();
	            if (!isLeaveVisible && !isHolidayVisible) {
	               JavascriptClick(PageRepositary.cell(day), driver);
	               JavascriptClick(PageRepositary.dayViewnewAdd, driver);
	               select("Projectone", PageRepositary.dayViewprojectName);
	               input(PageRepositary.dayViewmodulename, "Prod");
	               click(PageRepositary.moduleNameOpt("Prod"));
	               input(PageRepositary.dayViewHourLog, "08");
	               input(PageRepositary.dayViewMinLog, "00");
	               click(PageRepositary.dayViewSave);
	            }

	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }
	    
	    
	    JavascriptClick(PageRepositary.dayViewSubmit, driver);
	    Thread.sleep(Duration.ofSeconds(3));
	    click(PageRepositary.dayViewOK);
	    
	    boolean flag = ElementDisplayed(PageRepositary.dayViewCancelRequest);
	    Thread.sleep(Duration.ofSeconds(3));
	    
	    
		return flag;
	   
	}
	
	public boolean validation4() throws InterruptedException {
	    JavascriptClick(PageRepositary.dayViewCancelRequest, driver);
	    input(PageRepositary.dayViewCancelRequestReason, "data");
	    click(PageRepositary.dayViewModuleCancelRequest);
	    boolean flag = ElementDisplayed(PageRepositary.exp_dayViewCancelRequest);
		return flag;
	   
	}
	
	public boolean validation5(String pmo, String pwd, String empName) throws InterruptedException {
		
		input(PageRepositary.username, pmo);
		input(PageRepositary.password, pwd);
		click(PageRepositary.signin);
		
		click(PageRepositary.timesheet);
		click(PageRepositary.cancelRequest);
		click(PageRepositary.searchBtn);
		input(PageRepositary.searchValue, empName);
		click(PageRepositary.moduleSearchBtn);
		
		WebElement scrollableTable = driver.findElement(By.className("responsive-table"));

        // Scroll 200px to the right
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollLeft += 700;", scrollableTable);
		
		click(PageRepositary.approve(empName));
		click(PageRepositary.dayViewOK);
	    
	    boolean flag = ElementDisplayed(PageRepositary.exp_approvedMessage);
	    
		return flag;
	   
	}
	
	public boolean validation6(String un, String pwd, String m, String day) throws InterruptedException {
		
		input(PageRepositary.username, un);
		input(PageRepositary.password, pwd);
		click(PageRepositary.signin);
		
		click(PageRepositary.selfService);
		click(PageRepositary.myTimesheet);
		click(PageRepositary.dayViewOption);
		click(PageRepositary.dateRange);
		
		String month= m;
		if (m.length() > 3) {
            month = m.substring(0, 4);
        }
		
		select(month, PageRepositary.monthSelect);
		JavascriptClick(PageRepositary.weekRange(day), driver);
		
		boolean flag = false;
		
		try {
			flag = !ElementDisplayed(PageRepositary.dayViewCancelRequest);
		} catch (Exception e) {
			flag = true;
		}
		
		JavascriptClick(PageRepositary.dayViewSubmit, driver);
	    Thread.sleep(Duration.ofSeconds(3));
	    click(PageRepositary.dayViewOK);
	    JavascriptClick(PageRepositary.dayViewCancelRequest, driver);
	    input(PageRepositary.dayViewCancelRequestReason, "data");
	    click(PageRepositary.dayViewModuleCancelRequest);
	    
		
		return flag;
	   
	}
	
	public boolean validation7(String pmo, String pwd, String empName) throws InterruptedException {
		input(PageRepositary.username, pmo);
		input(PageRepositary.password, pwd);
		click(PageRepositary.signin);
		
		click(PageRepositary.timesheet);
		click(PageRepositary.cancelRequest);
		click(PageRepositary.searchBtn);
		input(PageRepositary.searchValue, empName);
		click(PageRepositary.moduleSearchBtn);
		
		WebElement scrollableTable = driver.findElement(By.className("responsive-table"));

        // Scroll 200px to the right
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollLeft += 700;", scrollableTable);
		
		click(PageRepositary.reject(empName));
		input(PageRepositary.comment, "data");
		click(PageRepositary.moduleReject);
	    
	    boolean flag = ElementDisplayed(PageRepositary.exp_rejectMessage);
	    
		return flag;
	}

}
