package com.Pages_LeaveModule;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_LeaveModule;
import com.Pages_TimesheetModule.Timeheet_ApprovalModule;
import com.Pages_TimesheetModule.Timeheet_WeekView;
import com.Pages_TimesheetModule.Timesheet_CreateModule;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class Leave_EWCLeaveRequest extends Base_Class {
	PageRepositary_LeaveModule PageRepositary = new PageRepositary_LeaveModule();
	Timeheet_ApprovalModule timeheet_ApprovalModule = new Timeheet_ApprovalModule();
	Timesheet_CreateModule timesheet_CreateModule = new Timesheet_CreateModule();
	Timeheet_WeekView timeheet_WeekView = new Timeheet_WeekView();

	public void clickOnLeaveModule() throws InterruptedException {
		WaitForLoaderToDisappear();
		click(PageRepositary.LeaveSection);
		WaitForLoaderToDisappear();
		click(PageRepositary.EWCSection);

	}

	public boolean clickOnEWCModuleApproval(String leaveType) throws InterruptedException {
		click(PageRepositary.LeaveSection);
		WaitForLoaderToDisappear();
		click(PageRepositary.ApprovalsSection);
		WaitForLoaderToDisappear();
		click(PageRepositary.EWCApprovalSection);
		WaitForLoaderToDisappear();
		click(PageRepositary.ewcSection);
		WaitForLoaderToDisappear();
		click(PageRepositary.leaveType);
		WaitForLoaderToDisappear();
		click(By.xpath("//option[normalize-space(text())='"+leaveType+"']"));
		Thread.sleep(1000);
		return true;
	}

	public boolean elementDisplayed() throws InterruptedException {
		boolean flag0 = ElementDisplayed(PageRepositary.FromDate);
		boolean flag1 = ElementDisplayed(PageRepositary.ToDate);
		boolean flag2 = ElementDisplayed(PageRepositary.selectProject);
		boolean flag3 = ElementDisplayed(PageRepositary.enterReason);
		boolean flag4 = ElementDisplayed(PageRepositary.notifyOthers);
		boolean flag5 = ElementDisplayed(PageRepositary.cancelButton);
		Thread.sleep(1000);
		boolean flag = flag0 & flag1 & flag2 & flag3 & flag4 & flag5;
		return flag;
	}

	public boolean EWCleaveRequest(String EWCType) throws InterruptedException {
		WaitForLoaderToDisappear();

		boolean isDisplayed = false;

		if (EWCType.trim().equals("Client Holiday")) {
			isDisplayed = ElementDisplayed(PageRepositary.clientHolidayDisplayed);
			click(PageRepositary.clientHolidayDisplayed);
			WaitForLoaderToDisappear();

			ExtentTestManager.getTest().log(Status.PASS, "Client Holiday Section Displayed: " + isDisplayed);
			Log.info("Client Holiday Section Displayed : " + isDisplayed);
		}

		else if (EWCType.trim().equals("Comp off Credit")) {

			isDisplayed = ElementDisplayed(PageRepositary.compOffDisplayed);
			click(PageRepositary.compOffDisplayed);
			WaitForLoaderToDisappear();

			ExtentTestManager.getTest().log(Status.PASS, "Comp off Credit Section Displayed: " + isDisplayed);
			Log.info("Comp off Credit Section Displayed : " + isDisplayed);

		} else if (EWCType.trim().equals("Work from Home")) {

			isDisplayed = ElementDisplayed(PageRepositary.wfhDisplayed);
			click(PageRepositary.wfhDisplayed);
			WaitForLoaderToDisappear();

			ExtentTestManager.getTest().log(Status.PASS, "Work from Home Section Displayed: " + isDisplayed);
			Log.info("Work from Home Section Displayed : " + isDisplayed);

		}

		return isDisplayed;
	}
	
	public boolean EWCleaveRequestForm_CompOffCredit(String fromYear, String fromMonth, String fromDate, String toYear,
			String toMonth, String toDate, String project, String Reason, String Employee, String timesheetMonth, String timeheetMonthDay, String timesheetModule) throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", driver.findElement((PageRepositary.FromDate)));
		WaitForLoaderToDisappear();
		click(PageRepositary.FromDate);
		click(PageRepositary.selectMonthandYear);
		Thread.sleep(500);
		click(By.xpath("//table[@class='mat-calendar-table']//div[contains(text(),'" + fromYear + "')]"));
		Thread.sleep(500);
		click(By.xpath("//table[@class='mat-calendar-table']//div[contains(text(),'" + fromMonth + "')]"));
		Thread.sleep(500);
		click(By.xpath("//table[@class='mat-calendar-table']//div[normalize-space()='" + fromDate + "']"));
//		 click(By.xpath("//div[contains(text(),'"+fromDate+"')]"));

		Thread.sleep(1000);
		click(PageRepositary.ToDate);
		click(PageRepositary.selectMonthandYear);
		Thread.sleep(500);
		click(By.xpath("//table[@class='mat-calendar-table']//div[contains(text(),'" + toYear + "')]"));
		Thread.sleep(500);
		click(By.xpath("//table[@class='mat-calendar-table']//div[contains(text(),'" + toMonth + "')]"));
		Thread.sleep(500);
		click(By.xpath("//table[@class='mat-calendar-table']//div[normalize-space()='" + toDate + "']"));
//		 click(By.xpath("//div[contains(text(),'"+toDate+"')]"));
		
		
		WebElement okBtn = driver.findElement(By.xpath("//button[normalize-space()='Ok']"));

		try {
			WaitForLoaderToDisappear();
			WebElement TimeSheetPopUp = driver.findElement(By.xpath("//span[contains(text(),'Please submit the timesheet including the date')]"));
			if(TimeSheetPopUp.isDisplayed())
			{
				okBtn.click();
				timeheet_ApprovalModule.NavigateToMyTimeSheet();
				timeheet_WeekView.clickOnYearWeekSelection(timesheetMonth, timeheetMonthDay);
				timeheet_WeekView.enterTimesheetForTheSelectedWeekDetailedView(project, timesheetModule);
			}else {
				System.out.println("Timesheet for the selected holiday is already submitted");
			}
		} catch (Exception e) {
			System.out.println("Timesheet for the selected holiday is already submitted");
		}
		
		
		try {
			WebElement TwoLevelApprovalPopUp = driver.findElement(By.xpath("//span[contains(text(),'This request will be send for two levels of approval')]"));
			if(TwoLevelApprovalPopUp.isDisplayed())
			{
				okBtn.click();
			}else {
				System.out.println("Two Level Approval Pop Up Not Displayed");
			}
		} catch (Exception e) {
			System.out.println("Two Level Approval Pop Up Not Displayed");
		}


		click(PageRepositary.selectProject);
		click(By.xpath("//option[contains(text(),'" + project + "')]"));

		input(PageRepositary.enterReason, Reason);


		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", driver.findElement((PageRepositary.notifyOthers)));
		click(PageRepositary.notifyOthers);
		Thread.sleep(500);
		input(PageRepositary.searchEmp, Employee);
		click(PageRepositary.selectEmp);
		// click(PageRepositary.notifyOthers);

		return true;

	}
	

	public boolean EWCleaveRequestForm(String fromYear, String fromMonth, String fromDate, String toYear,
			String toMonth, String toDate, String project, String Reason, String Employee) throws InterruptedException {

		WaitForLoaderToDisappear();
		click(PageRepositary.FromDate);
		click(PageRepositary.selectMonthandYear);
		Thread.sleep(500);
		click(By.xpath("//table[@class='mat-calendar-table']//div[contains(text(),'" + fromYear + "')]"));
		Thread.sleep(500);
		click(By.xpath("//table[@class='mat-calendar-table']//div[contains(text(),'" + fromMonth + "')]"));
		Thread.sleep(500);
		click(By.xpath("//table[@class='mat-calendar-table']//div[normalize-space()='" + fromDate + "']"));
//		 click(By.xpath("//div[contains(text(),'"+fromDate+"')]"));

		Thread.sleep(1000);
		click(PageRepositary.ToDate);
		click(PageRepositary.selectMonthandYear);
		Thread.sleep(500);
		click(By.xpath("//table[@class='mat-calendar-table']//div[contains(text(),'" + toYear + "')]"));
		Thread.sleep(500);
		click(By.xpath("//table[@class='mat-calendar-table']//div[contains(text(),'" + toMonth + "')]"));
		Thread.sleep(500);
		click(By.xpath("//table[@class='mat-calendar-table']//div[normalize-space()='" + toDate + "']"));
//		 click(By.xpath("//div[contains(text(),'"+toDate+"')]"));
		
		
		click(PageRepositary.selectProject);
		click(By.xpath("//option[contains(text(),'" + project + "')]"));

		input(PageRepositary.enterReason, Reason);

		click(PageRepositary.notifyOthers);
		input(PageRepositary.searchEmp, Employee);
		click(PageRepositary.selectEmp);
		// click(PageRepositary.notifyOthers);

		return true;

	}

	public boolean clickOnCancelButton() throws InterruptedException {
		click(PageRepositary.cancelButton);
		WaitForLoaderToDisappear();
		ExtentTestManager.getTest().log(Status.PASS, "EWC Leave Request Cancelled");
		Log.info("EWC Leave Request Cancelled!");
		return true;
	}

	public boolean clickOnSubmitButton() throws InterruptedException {

		click(PageRepositary.submitButton);
		WaitForLoaderToDisappear();
		click(PageRepositary.okButton);

		ExtentTestManager.getTest().log(Status.PASS, "EWC Leave Request Submitted!");
		Log.info("EWC Leave Request Submitted!");
		return true;
	}

	public boolean ApprovalButtonFieldsDisplayed(String LeaveRequester, String fromYear, String fromMonth,
			String fromDate) throws InterruptedException {

		String fromMonthLower = fromMonth.substring(0, 1).toUpperCase() + fromMonth.substring(1).toLowerCase();

		By rowXPath = By.xpath("//span[contains(., '" + LeaveRequester + "') and contains(., '" + fromYear
				+ "') and contains(., '" + fromMonthLower + "') and contains(., '" + fromDate + "')]");
		click(rowXPath);

//		 click(By.xpath("//span[contains(text(),'"+LeaveRequester+"')]"));
//		 click(By.xpath("//span[text()='From Date:']/following-sibling::span[contains(text(), '"+fromYear+"') and contains(text(), '"+fromMonth+"') and contains(text(), '"+fromDate+"')]"));
		Thread.sleep(2000);
		boolean flag0 = ElementDisplayed(PageRepositary.sendForReview1);
		boolean flag1 = ElementDisplayed(PageRepositary.prjectAllocation1);
		boolean flag2 = ElementDisplayed(PageRepositary.approvebutton);
		boolean flag3 = ElementDisplayed(PageRepositary.rejectbutton);
		Thread.sleep(1000);
		boolean flag = flag0 & flag1 & flag2 & flag3;
		return flag;
	}

	public boolean sendForReviewFunctionality(String LeaveRequester, String fromYear1, String fromMonth1,
			String fromDate1, String Employee1) throws InterruptedException {

		String fromMonthLower = fromMonth1.substring(0, 1).toUpperCase() + fromMonth1.substring(1).toLowerCase();
		By rowXPath = By.xpath("//span[contains(., '" + LeaveRequester + "') and contains(., '" + fromYear1
				+ "') and contains(., '" + fromMonthLower + "') and contains(., '" + fromDate1 + "')]");
		click(rowXPath);
		By sendForReviewButtonXPath = By.xpath("//span[contains(., '" + LeaveRequester + "') and contains(., '"
				+ fromYear1 + "') and contains(., '" + fromMonthLower + "') and contains(., '" + fromDate1 + "')]/parent::mat-expansion-panel-header/following-sibling::div/div//button[normalize-space()='Send for review']");

		Thread.sleep(2000);
		click(sendForReviewButtonXPath);
		WaitForLoaderToDisappear();
		click(PageRepositary.overlay);
		click(PageRepositary.approverSelection);
		WaitForLoaderToDisappear();
		select(Employee1, PageRepositary.approverSelection);
		click(PageRepositary.overlay);
		Log.info("Level 0");
//		 click(PageRepositary.sendForReview1);
//		 Log.info("Level 1");
//
//		Thread.sleep(1000);
//		 click(PageRepositary.overlay);
		Log.info("Level 2");
		Thread.sleep(1000);
		click(PageRepositary.sendForReview2);
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.PASS, "EWC Leave Request Rerouted Successfully");
		Log.info("EWC Leave Request Rerouted Successfully!");
		return true;
	}

	public boolean RejectFunctionality(String LeaveRequester, String fromYear, String fromMonth, String fromDate,
			String RejectCommnents) throws InterruptedException {

		String fromMonthLower = fromMonth.substring(0, 1).toUpperCase() + fromMonth.substring(1).toLowerCase();
//		By rowXPath = By.xpath("//span[contains(., '" + LeaveRequester + "') and contains(., '" + fromYear
//				+ "') and contains(., '" + fromMonthLower + "') and contains(., '" + fromDate + "')]");
//		click(rowXPath);
//		click(rowXPath);
//		click(By.xpath("//span[contains(text(),'" + LeaveRequester + "')]"));

		By rejectButtonXPath = By.xpath("//span[contains(., '" + LeaveRequester + "') and contains(., '" + fromYear
				+ "') and contains(., '" + fromMonthLower + "') and contains(., '" + fromDate
				+ "')]/mat-panel-title/ul/li[4]//button/i[@title='Reject']");
		click(rejectButtonXPath);
		WaitForLoaderToDisappear();
		input(PageRepositary.enterRejectComments, RejectCommnents);
		WaitForLoaderToDisappear();
		click(PageRepositary.sendButton1);
		WaitForLoaderToDisappear();
		ExtentTestManager.getTest().log(Status.PASS, "EWC Leave Request Rejected Successfully");
		Log.info("EWC Leave Request Rejected Successfully!");
		return true;
	}

	public boolean ApproveFunctionality(String LeaveRequester, String fromYear1, String fromMonth1, String fromDate1)
			throws InterruptedException {

		String fromMonthLower = fromMonth1.substring(0, 1).toUpperCase() + fromMonth1.substring(1).toLowerCase();
//		By rowXPath = By.xpath("//span[contains(., '" + LeaveRequester + "') and contains(., '" + fromYear
//				+ "') and contains(., '" + fromMonthLower + "') and contains(., '" + fromDate + "')]");
//		click(rowXPath);
//		click(rowXPath);
		Thread.sleep(200);
		By approveButtonXPath = By.xpath("//span[contains(., '" + LeaveRequester + "') and contains(., '" + fromYear1
				+ "') and contains(., '" + fromMonthLower + "') and contains(., '" + fromDate1
				+ "')]/mat-panel-title/ul/li[4]//button/i[@title='Approve']");
		Thread.sleep(200);
		click(approveButtonXPath);
		WaitForLoaderToDisappear();
		
//		input(PageRepositary.enterApproveComments, "Approved");
//		Thread.sleep(100);
//		click(PageRepositary.send);
//		
//		ExtentTestManager.getTest().log(Status.PASS, "EWC Leave Request Approved Successfully");
//		Log.info("EWC Leave Request Approved Successfully!");
		return true;
	}

}
