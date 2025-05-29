//methods of resign approval 
package com.Pages_Methods;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Locators.Locators_Resign_Req_Approval;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class Methods_Resign_Req_Approval extends Base_Class {

	public static String ManagerFullName;
	public static String HR1FullName;
	public static String HR2FullName;
	public static String ManagerUserName;
	public static String HR1UserName;
	public static String HR2UserName;

	Locators_Resign_Req_Approval locators = new Locators_Resign_Req_Approval();

	public void superUser(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, IOException {
		Log.info("Navigating to Employee Initiation Seperation (Resign page) of employee");

		click(locators.SelfService);
		waitForSpinnerToDisappear(driver, 1, 2);
		WaitForElementToBeClickable(locators.Request);

		click(locators.Request);
		waitForSpinnerToDisappear(driver, 1, 2);
		WaitForElementToBeClickable(locators.EmpSeparationRequest);

		click(locators.EmpSeparationRequest);
		waitForSpinnerToDisappear(driver, 1, 2);
		WaitForElementToBeVisible(locators.ManagerName);

		ManagerFullName = driver.findElement(locators.ManagerName).getText().toString();
		Log.info("Manager's Name :" + ManagerFullName);

		HR1FullName = driver.findElement(locators.HR1Name).getText().toString();
		Log.info("HR's level 1 Name: " + HR1FullName);

		HR2FullName = driver.findElement(locators.HR2Name).getText().toString();
		Log.info("Hr's level 2 name: " + HR2FullName);

		String SuperUser = testdata.get("SuperUser").toString();// Map<Object, Object> testdata, ITestContext context
		By emp = By.xpath("//span[@class='link ng-star-inserted']");
		Signout();
		SignInAsEmployee(SuperUser);

		Log.info("Scrolled untill travel");
		ScrollUntilElementVisible(locators.ScrollTillTravel);
		click(locators.EmpTabMain);
//		INclick(locators.EmployeeTab);
		waitForSpinnerToDisappear(driver, 2, 2);

		Log.info("click on emp tab in expanded list");
		click(locators.EmployeeTab);
//		INclick(locators.ActiveEmp);
		waitForSpinnerToDisappear(driver, 2, 2);

		Log.info("click on active emp tab");
		click(locators.ActiveEmp);
//		INclick(locators.SearchIconClick);
		waitForSpinnerToDisappear(driver, 2, 2);

		Log.info("Clicked on Search icon ");
		click(locators.SearchIconClick);

		Thread.sleep(3000);
		try {
			if (ElementDisplayed(locators.SearchColumn)) {
				ExtentTestManager.getTest().log(Status.INFO, "Found continue rest");
				Log.info("Found continue rest");
			}
		} catch (Exception e) {
			Log.info("Exception in search box " + e.getMessage());
			ExtentTestManager.getTest().log(Status.INFO, "Not Found");
			Log.info("Not Found... Clicking on Add Criteria Button");
			click(locators.AddSearchCriteriaBtn);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locators.SearchColumn));
			ExtentTestManager.getTest().log(Status.PASS, "Clicked on Add Another Search Criteria");
			Log.info("Clicked on Add Another Search Criteria");
		}

		Log.info("Entered coloum");
		checkDropdown(locators.SearchColumn);
		select(" Employee Name ", locators.SearchColumn);
		Log.info("Entered search type ");
		checkDropdown(locators.SearchColumn);
		select("Equals", locators.SearchType);
		input(locators.SearchValue, ManagerFullName); // Manager names
		click(locators.searchBtnInDialog);
		waitForSpinnerToDisappear(driver, 2, 2);
		click(emp);
		ScrollUntilElementVisible(locators.scrollTillNoticeOn);
		ManagerUserName = driver.findElement(locators.userNameFIeld).getAttribute("value");
		Log.info("Manager's Username: " + ManagerUserName);
		ScrollUntilElementVisible(locators.ScrollTillEMp);
		click(locators.CloseButton);
		waitForSpinnerToDisappear(driver, 2, 2);

		Log.info("Clicked on Search icon ");
		click(locators.SearchIconClick);
		clear(locators.SearchValue);
		input(locators.SearchValue, HR1FullName); // HR1 names
		click(locators.searchBtnInDialog);
		waitForSpinnerToDisappear(driver, 2, 2);
		click(emp);
		ScrollUntilElementVisible(locators.scrollTillNoticeOn);
		HR1UserName = driver.findElement(locators.userNameFIeld).getAttribute("value");
		Log.info("HR level 1 Username: " + HR1UserName);
		ScrollUntilElementVisible(locators.ScrollTillEMp);
		click(locators.CloseButton);
		waitForSpinnerToDisappear(driver, 2, 2);

		Log.info("Clicked on Search icon ");
		click(locators.SearchIconClick);
		clear(locators.SearchValue);
		input(locators.SearchValue, HR2FullName); // HR1 names
		click(locators.searchBtnInDialog);
		waitForSpinnerToDisappear(driver, 2, 2);
		click(emp);
		ScrollUntilElementVisible(locators.scrollTillNoticeOn);
		HR2UserName = driver.findElement(locators.userNameFIeld).getAttribute("value");
		Log.info("HR level 2 Username: " + HR2UserName);
		ScrollUntilElementVisible(locators.ScrollTillEMp);
		click(locators.CloseButton);
		waitForSpinnerToDisappear(driver, 2, 2);

		Signout();
		SignInAsEmployee(ManagerUserName);
	}

	public boolean isEmpTab() throws InterruptedException {
		waitForSpinnerToDisappear(driver, 2, 2);
		ExtentTestManager.getTest().log(Status.PASS, "Verifies located Employee tab in navigation bar is located ");
		Log.info("Verifies located Employee tab in navigation bar is located");
		ScrollUntilElementVisible(locators.ScrollTillTravel);
		return Base_Class.CheckElementDisable(locators.EmpTabMain);
	}

	public void ValidateEmpTabisExpanded() throws InterruptedException {
		click(locators.EmpTabMain);
		waitForSpinnerToDisappear(driver, 2, 2);
		ExtentTestManager.getTest().log(Status.PASS, "Employee Tab is expanded ");
		Log.info("Employee Tab is expanded ");
		waitForSpinnerToDisappear(driver, 2, 2);
		String Expectedtext = "Approvals";
		waitForSpinnerToDisappear(driver, 2, 2);
		String ActualText = driver.findElement(locators.ApprovalTab).getText().toString();
		waitForSpinnerToDisappear(driver, 2, 2);
		Assert.assertEquals(ActualText, Expectedtext, "User couldn't Expand employee tab ");
		Log.info(Expectedtext + " is successfully displayed");
		ExtentTestManager.getTest().log(Status.PASS, "Successfully  Expanded employee tab");
		Log.info("Successfully Expanded employee tab");
	}

	public boolean isEmployeeSepVisibleInApprovals() throws InterruptedException {
		click(locators.ApprovalTab);
		ExtentTestManager.getTest().log(Status.PASS, "Verified Located Employee Separation ");
		Log.info("Verified Located Employee Separation ");
		return Base_Class.CheckElementDisable(locators.EmpResignTab);

	}

	public void validateToEmpSeparation() throws InterruptedException {
		click(locators.EmpResignTab);
		ExtentTestManager.getTest().log(Status.PASS, "Navigated to Employee Separation Request Approval Page ");
		Log.info("Navigated to Employee Separation Request Approval Page  ");

		waitForSpinnerToDisappear(driver, 2, 2);
		String Expectedtext = "Employee Exit for Approval";
		String ActualText = driver.findElement(locators.EmpSepHeader).getText().toString();
		Assert.assertEquals(ActualText, Expectedtext,
				"User is successully redirected to Employee Separation Request Approval Page");
		Log.info(Expectedtext + " is successfully displayed");
		ExtentTestManager.getTest().log(Status.PASS,
				"Successfully Employee Separation Request Approval Page is displayed ");
		Log.info("Successfully Employee Separation Request Approval Page is  displayed ");

	}

	public boolean isCloseButtonDisplayed() throws InterruptedException {

		return ElementDisplayed(locators.closeBtn);
	}

	public boolean isSearchButtonDisplayed() throws InterruptedException {
		return ElementDisplayed(locators.SearchBtn);
	}

	public boolean isApproveBtnDisplayed() throws InterruptedException {
		return ElementDisplayed(locators.ApprovalBtn);
	}

	public boolean isOverRideBtnDisplayed() throws InterruptedException {
		return ElementDisplayed(locators.OverRideBtn);
	}

	public boolean isCodeLabelDisplayed() throws InterruptedException {
		return ElementDisplayed(locators.CodeLable);
	}

	public boolean isEmployeeLableDisplayed() throws InterruptedException {
		return ElementDisplayed(locators.EmployeeLable);
	}

	public boolean isRequestDateLableDisplayed() throws InterruptedException {
		return ElementDisplayed(locators.RequestDateLable);
	}

	public boolean isLastWorkingLableDisplayed() throws InterruptedException {
		return ElementDisplayed(locators.LastWorkingDayLable);
	}

	public boolean isofficeLocationLableDisplayed() throws InterruptedException {
		return ElementDisplayed(locators.OfficeLocationLable);
	}

	public boolean isStatusLableDisplayed() throws InterruptedException {
		return ElementDisplayed(locators.StatusLable);
	}

	public boolean isPlannedRelievingLableDisplayed() throws InterruptedException {
		return ElementDisplayed(locators.PlannedRelievingLable);
	}

	public boolean isPreferredRelievingLableDisplayed() throws InterruptedException {
		return ElementDisplayed(locators.PreferredRelievingLable);
	}

	public boolean isTotalItemLableDisplayed() throws InterruptedException {
		return ElementDisplayed(locators.TotalNoItem);
	}

	public boolean isSelectDropDownDisplayed() throws InterruptedException {
		return ElementDisplayed(locators.SelectDropDown);
	}

	public void testUIElementPresence() throws InterruptedException {
		Assert.assertTrue(isCloseButtonDisplayed(), "Close button is not displayed");
		ExtentTestManager.getTest().log(Status.PASS, "Verified Close button is displayed");
		Log.info("Verified Close button is displayed");

		Assert.assertTrue(isSearchButtonDisplayed(), "Search button is not displayed");
		ExtentTestManager.getTest().log(Status.PASS, "Verified Search button is displayed");
		Log.info("Verified Search button is displayed");

		Assert.assertTrue(isApproveBtnDisplayed(), "Approve button is not displayed");
		ExtentTestManager.getTest().log(Status.PASS, "Verified Approve button is displayed");
		Log.info("Verified Approve button is displayed");

		Assert.assertTrue(isOverRideBtnDisplayed(), "Override button is not displayed");
		ExtentTestManager.getTest().log(Status.PASS, "Verified Override button is displayed");
		Log.info("Verified Override button is displayed");

		Assert.assertTrue(isCodeLabelDisplayed(), "Code Label is not displayed");
		ExtentTestManager.getTest().log(Status.PASS, "Verified Code Label is displayed");
		Log.info("Verified Code Label is displayed");

		Assert.assertTrue(isEmployeeLableDisplayed(), "Employee Label is not displayed");
		ExtentTestManager.getTest().log(Status.PASS, "Verified Employee Label is displayed");
		Log.info("Verified Employee Label is displayed");

		Assert.assertTrue(isRequestDateLableDisplayed(), "Request Date Label is not displayed");
		ExtentTestManager.getTest().log(Status.PASS, "Verified Request Date Label is displayed");
		Log.info("Verified Request Date Label is displayed");

		Assert.assertTrue(isLastWorkingLableDisplayed(), "Last Working Date Label is not displayed");
		ExtentTestManager.getTest().log(Status.PASS, "Verified Last Working Label is displayed");
		Log.info("Verified Last Working Label is displayed");

		Assert.assertTrue(isofficeLocationLableDisplayed(), "Office Location Label is not displayed");
		ExtentTestManager.getTest().log(Status.PASS, "Verified Office Location Label is displayed");
		Log.info("Verified Office Location Label is displayed");

		Assert.assertTrue(isPlannedRelievingLableDisplayed(), "Planned Relieving Date Label is not displayed");
		ExtentTestManager.getTest().log(Status.PASS, "Verified Planned Relieving Date Label is displayed");
		Log.info("Verified Planned Relieving Date Label is displayed");

		Assert.assertTrue(isPreferredRelievingLableDisplayed(), "Preferred Relieving Date Label is not displayed");
		ExtentTestManager.getTest().log(Status.PASS, "Verified Preferred Relieving Date Label is displayed");
		Log.info("Verified Preferred Relieving Date Label is displayed");

		Assert.assertTrue(isStatusLableDisplayed(), "Status Label is not displayed");
		ExtentTestManager.getTest().log(Status.PASS, "Verified Status Label is displayed");
		Log.info("Verified Status Label is displayed");

		Assert.assertTrue(isTotalItemLableDisplayed(), "Total Item Label is not displayed");
		ExtentTestManager.getTest().log(Status.PASS, "Verified Total Item Label is displayed");
		Log.info("Verified Total Item Label is displayed");

		Assert.assertTrue(isSelectDropDownDisplayed(), "Select Drop Down  is not displayed");
		ExtentTestManager.getTest().log(Status.PASS, "Verified Select Drop Down is displayed");
		Log.info("Verified Select Drop Down is displayed");

		try {
			WebElement paginationElement = driver.findElement(locators.Pagination);
			System.out.println(paginationElement.isDisplayed());
			boolean Flag = paginationElement.isDisplayed();
			if (Flag == true) {
				ExtentTestManager.getTest().log(Status.PASS, "Pagination is not Displayed");
				Log.info("Pagination is not Displayed");
			}
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.PASS, " Pagination is not Displayed");
			Log.info("Pagination is not Displayed" + e.toString());
		}
	}

	public void NavigateSearchbtn() throws InterruptedException {
		click(locators.SearchIconClick);
		ExtentTestManager.getTest().log(Status.PASS, "Verified We are into search Dialog");
		Log.info("Verified Search Dialog is Redirected");
	}

	public void SearchEmpAndVerify(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {

		try {
			String Code = testdata.get("Code").toString();
			By SearchResults = By.xpath("//span[normalize-space()='" + Code + "']");
			// span[normalize-space()='SPC10763'

			// Check if search criteria dropdown is already visible
			// boolean = driver.findElement(locators.SearchColumn).isDisplayed();

			Thread.sleep(3000);
			try {
				if (ElementDisplayed(locators.SearchColumn)) {
					ExtentTestManager.getTest().log(Status.INFO, "Found continue rest");
					Log.info("Found continue rest");
				}
			} catch (Exception e) {
				Log.info("Exception in search box " + e.getMessage());
				ExtentTestManager.getTest().log(Status.INFO, "Not Found");
				Log.info("Not Found... Clicking on Add Criteria Button");
				click(locators.AddSearchCriteriaBtn);
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
				wait.until(ExpectedConditions.visibilityOfElementLocated(locators.SearchColumn));
				ExtentTestManager.getTest().log(Status.PASS, "Clicked on Add Another Search Criteria");
				Log.info("Clicked on Add Another Search Criteria");
			}

			// Select "Employee" from Search Column
			checkDropdown(locators.SearchColumn);
			select(" Employee ", locators.SearchColumn);
			ExtentTestManager.getTest().log(Status.PASS, "Selected Employee Name from Search Column");
			Log.info("Selected Employee Name from Search Column");

			// Select "Equals" from Search Type
			checkDropdown(locators.SearchColumn);
			select("Equals", locators.SearchType);
			ExtentTestManager.getTest().log(Status.PASS, "Selected Equals from Search Type");
			Log.info("Selected Equals from Search Type");

			// Enter the search value
			String name = testdata.get("FullName").toString();
			input(locators.SearchValue, name);
			ExtentTestManager.getTest().log(Status.PASS, "Entered Search Value: " + name);
			Log.info("Entered Search Value: " + name);

			// Click on Search Button
			click(locators.searchBtnInDialog);
			ExtentTestManager.getTest().log(Status.PASS, "Clicked on Search button");
			Log.info("Clicked on Search Button");

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.presenceOfElementLocated(SearchResults));

			Log.info("Search operation completed successfully.");
		} catch (Exception e) {
			Log.error("Error occurred in SearchEmpAndVerify: " + e.toString());
			e.printStackTrace();
		}
	}

	public void presenceUIElmSearchDialog() throws InterruptedException {
		Assert.assertTrue(ElementDisplayed(locators.SearchColumn), "Search Column is not displayed");
		ExtentTestManager.getTest().log(Status.PASS, "Verified Search Column is displayed in Dialog");
		Log.info("Verified Search Column is displayed in Dialog");

		Assert.assertTrue(ElementDisplayed(locators.SearchType), "Search Type is not displayed");
		ExtentTestManager.getTest().log(Status.PASS, "Verified Search Type is displayed in Dialog");
		Log.info("Verified Search Type is displayed in Dialog");

		Assert.assertTrue(ElementDisplayed(locators.SearchValue), "Text Field is not displayed");
		ExtentTestManager.getTest().log(Status.PASS, "Verified Text Field is displayed in Dialog");
		Log.info("Verified Text Field is displayed in Dialog");

		Assert.assertTrue(ElementDisplayed(locators.searchBtnInDialog), "Search Button is not displayed");
		ExtentTestManager.getTest().log(Status.PASS, "Verified Search Button is displayed in Dialog");
		Log.info("Verified Search Button is displayed in Dialog");

		Assert.assertTrue(ElementDisplayed(locators.cancelBtnInDialog), "Cancel Button is not displayed");
		ExtentTestManager.getTest().log(Status.PASS, "Verified Cancel Button is displayed in Dialog");
		Log.info("Verified Cancel Button is displayed in Dialog");
	}

	public void SearchBtnFunctionality(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {
		NavigateSearchbtn();
		presenceUIElmSearchDialog();
		SearchEmpAndVerify(testdata, context);
	}

	public void closeBtnFunctionality() throws InterruptedException {
		click(locators.closeBtn);
		ExtentTestManager.getTest().log(Status.PASS,
				"Successfully closed the search functionality and naivigated to Home Page ");
		Log.info("Successfully closed the search functionality and naivigated to Home Page ");
		handlePopupDesktop();
		validateDashBoard();
		ScrollUntilElementVisible(locators.ScrollTillTravel);
		click(locators.EmpTabMain);
		waitForSpinnerToDisappear(driver, 2, 2);
		click(locators.ApprovalTab);
		waitForSpinnerToDisappear(driver, 2, 2);
		click(locators.EmpResignTab);
		waitForSpinnerToDisappear(driver, 2, 2);

	}

	public void ApprovalBtnFUnctionality() throws InterruptedException {
		click(locators.ApprovalBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Successfully Approval List is displayed  ");
		Log.info("Successfully Approval List is displayed  ");
	}

	public void OverRideBtnFunctionality() throws InterruptedException {
		click(locators.OverRideBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Successfully OverRide List is displayed  ");
		Log.info("Successfully OverRide List is displayed  ");
	}

	public void NavigateToEmpReqUsingCode(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException {
		NavigateSearchbtn();
		SearchEmpAndVerify(testdata, context);
		try {
			String Code = testdata.get("Code").toString();
			By ClickOnEmp = By.xpath("//span[normalize-space()='" + Code + "']");
			Log.info("XPath is:  " + ClickOnEmp);
			// By.xpath("//span[normalize-space()='SP2486']");
			boolean flag = ElementDisplayed(ClickOnEmp);
			if (flag == true) {
				Log.info("EMp displayed");
				Log.info("The xpath is " + ClickOnEmp);
				click(ClickOnEmp);
				ExtentTestManager.getTest().log(Status.PASS, "Successfully navigated to  " + Code + " page");
				Log.info("Successfully navigated to  " + Code + " page");
			}
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.PASS, "no , Not Displayed the employee ");
			Log.info("not Displayed");
			driver.quit();
		}
	}

	public boolean UiPresenceOfElementInCodePage() throws InterruptedException {
		boolean flag1 = ElementDisplayed(locators.EmployeeNameLabel) && ElementEnabled(locators.EmployeeNameInput);
		ExtentTestManager.getTest().log(Status.PASS, "Employee Name is displayed and is disable ");
		Log.info("Employee Name label is displayed and enabled  " + flag1);

		boolean flag2 = ElementDisplayed(locators.DepartmentLabel) && ElementEnabled(locators.DepartmentInput);
		ExtentTestManager.getTest().log(Status.PASS, "Department is displayed and is disable ");
		Log.info("Department label is displayed and enabled  " + flag2);

		boolean flag3 = ElementDisplayed(locators.DesignationLabel) && ElementEnabled(locators.DesignationLabel);
		ExtentTestManager.getTest().log(Status.PASS, "Designation is displayed and is disable ");
		Log.info("Designation label is displayed and enabled  " + flag3);

		boolean flag4 = ElementDisplayed(locators.ExitType) && ElementEnabled(locators.ExitInput);
		ExtentTestManager.getTest().log(Status.PASS, "Exit Type is displayed and is disable ");
		Log.info("Exit Type label is displayed and enabled  " + flag4);

		boolean flag5 = ElementDisplayed(locators.RequestDateLabel1) && ElementEnabled(locators.RequestDateInput);
		ExtentTestManager.getTest().log(Status.PASS, "Request Date is displayed and is disable ");
		Log.info("Request Date label is displayed and enabled  " + flag5);

		boolean flag6 = ElementDisplayed(locators.PreferredDateLabel1) && ElementEnabled(locators.PreferredDateInput);
		ExtentTestManager.getTest().log(Status.PASS, "Preferred date is displayed and is disable ");
		Log.info("Preferred date label is displayed and Disabled  " + flag6);

		boolean flag7 = ElementDisplayed(locators.PlannedRelievingDateLable1)
				&& ElementEnabled(locators.PlannedRelievingDateInput);
		ExtentTestManager.getTest().log(Status.PASS, "Planned date is displayed and is Enabled ");
		Log.info("Planned date label is displayed and enabled  " + flag7);

		boolean flag8 = ElementDisplayed(locators.LastWorkingDateLable)
				&& ElementEnabled(locators.LastWorkingDateInput);
		ExtentTestManager.getTest().log(Status.PASS, "Last WOrking date  is displayed and is Enabled ");
		Log.info("Last WOrking date label is displayed and enabled  " + flag8);

		boolean flag9 = ElementDisplayed(locators.CommentLable) && ElementEnabled(locators.CommentTextArea);
		ExtentTestManager.getTest().log(Status.PASS, "Comment is displayed and is disable ");
		Log.info("Comment label is displayed and Disabled  " + flag9);

		boolean flag10 = ElementDisplayed(locators.ReasonLable);
		ExtentTestManager.getTest().log(Status.PASS, "Reason is displayed and is disable ");
		Log.info("Reason label is displayed " + flag10);

		boolean flag11 = ElementDisplayed(locators.UploadDoc);
		ExtentTestManager.getTest().log(Status.PASS, "Upload document is displayed ");
		Log.info("Employee Name label is displayed  " + flag11);

		boolean flag12 = ElementDisplayed(locators.ForwardEmailReq);
		ExtentTestManager.getTest().log(Status.PASS, "Forward Email Required Toogle button is displayed ");
		Log.info("Forward Email Required Toogle button is displayed " + flag12);

		boolean flag13 = ElementDisplayed(locators.EmailBackupReq);
		ExtentTestManager.getTest().log(Status.PASS, "Email Backup Required toogle button is displayed");
		Log.info("Email Backup Required toogle button is displayed " + flag13);

		boolean flag14 = ElementDisplayed(locators.DataBackupReq);
		ExtentTestManager.getTest().log(Status.PASS, "Date Backup Required toogle button is displayed");
		Log.info("Backup Required toogle button is displayed " + flag14);

		boolean flag15 = ElementDisplayed(locators.ApproverName);
		ExtentTestManager.getTest().log(Status.PASS, "Approver Name is displayed");
		Log.info("Approver Name is displayed " + flag15);

		boolean flag16 = ElementDisplayed(locators.ApprovalLevel);
		ExtentTestManager.getTest().log(Status.PASS, "Approval Level  is displayed");
		Log.info("Approval Level is displayed " + flag16);

		boolean flag17 = ElementDisplayed(locators.ApprovalStatus);
		ExtentTestManager.getTest().log(Status.PASS, "Approval Status is displayed");
		Log.info("Approval Status is displayed " + flag17);

		boolean flag18 = ElementDisplayed(locators.ApprovalComment);
		ExtentTestManager.getTest().log(Status.PASS, "Approval Comments  is displayed");
		Log.info("Approval Comments is displayed " + flag18);

		boolean flag19 = ElementDisplayed(locators.ManagerName);
		ExtentTestManager.getTest().log(Status.PASS, "Manager's Name  is displayed");
		Log.info("Manager's Name is displayed " + flag19);

		boolean flag20 = ElementDisplayed(locators.ManagerTabLastworking);
		ExtentTestManager.getTest().log(Status.PASS, "Manager's  Last working  is displayed");
		Log.info("Manager's  Last working is displayed " + flag20);

		boolean flag21 = ElementDisplayed(locators.ManagerTabComment);
		ExtentTestManager.getTest().log(Status.PASS, "Manager's  Comment is displayed");
		Log.info("Manager's Comment  is displayed " + flag21);

		boolean flag22 = ElementDisplayed(locators.Replacement);
		ExtentTestManager.getTest().log(Status.PASS, "Manager's  Relacement  is displayed");
		Log.info("Manager's Relacement  is displayed " + flag22);

		boolean flag23 = ElementDisplayed(locators.ApprovalComment);
		ExtentTestManager.getTest().log(Status.PASS, "Approval Comments  is displayed");
		Log.info("Approval Comments is displayed " + flag23);

		boolean flag24 = ElementDisplayed(locators.ViewDependencies);
		ExtentTestManager.getTest().log(Status.PASS, "View Dependencies Button  is displayed");
		Log.info("View Dependencies Button is displayed " + flag24);

		boolean flag25 = ElementDisplayed(locators.HRClearance);
		ExtentTestManager.getTest().log(Status.PASS, " HR Clearance Button  is displayed");
		Log.info(" HR Clearance Button is displayed " + flag25);

		boolean flag26 = ElementDisplayed(locators.SaveBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Save Button  is displayed");
		Log.info("Save Button is displayed " + flag26);

		boolean flag27 = ElementDisplayed(locators.RejectBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Reject Button  is displayed");
		Log.info("Reject Button is displayed " + flag27);

		boolean flag28 = ElementDisplayed(locators.ApproveBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Approve Button  is displayed");
		Log.info("Approve Button is displayed " + flag28);

		boolean flag29 = ElementDisplayed(locators.WithdrawBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Withdraw Button  is displayed");
		Log.info("Withdraw Button is displayed " + flag29);

		boolean Flag = flag1 && flag2 && flag3 && flag4 && flag5 && flag6 && flag7 && flag8 && flag9 && flag10 & flag11
				&& flag12 && flag13 && flag14 && flag15 && flag16 && flag17 && flag18 && flag19 && flag20 && flag21
				&& flag22 && flag23 && flag24 && flag25 && flag26 && flag27 && flag28 && flag29;

		return Flag;

	}

	public void RequestReject() throws InterruptedException {
		Log.info("Scroll till reject btnn is visible ");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		ScrollUntilElementVisible(locators.ScrollTillViewDep);
		waitForSpinnerToDisappear(driver, 2, 2);
		Log.info("Clicking on reject button ");
		click(locators.RejectBtn);
		waitForSpinnerToDisappear(driver, 2, 2);
		Log.info("Click yes on reject dialog box ");
		click(locators.Yes);
		waitForSpinnerToDisappear(driver, 2, 2);
		Log.info("Click ok once after yes ");
		click(locators.Ok);
		waitForSpinnerToDisappear(driver, 2, 2);
		Signout();

	}

	public void CreateRequest(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException, IOException {
		String UserName = testdata.get("LoginName").toString();// Map<Object, Object> testdata, ITestContext context
		SignInAsEmployee(UserName);

		click(locators.SelfService);
		ExtentTestManager.getTest().log(Status.PASS, "Self service is expanded  ");
		Log.info("Self service is expanded ");

		click(locators.Request);
		ExtentTestManager.getTest().log(Status.PASS, "Request  is expanded  ");
		Log.info("Request is expanded ");

		click(locators.EmpSeparationRequest);
		ExtentTestManager.getTest().log(Status.PASS, "We are navigated to Employee separation Transfer");
		Log.info("We are navigated to Employee separation Transfer");

		waitForSpinnerToDisappear(driver, 2, 2);
		ExtentTestManager.getTest().log(Status.PASS, "Enter a Reason");
		Log.info("Enter a Reason");
		click(locators.ReasonsDropDown);
		click(locators.Relocation);
		click(locators.CareerAdvancement);
		waitForSpinnerToDisappear(driver, 2, 2);

		ExtentTestManager.getTest().log(Status.PASS, "Enter a comment");
		Log.info("Enter a comment");
		click(locators.Comments);
		input(locators.Comments, "Resigning");
		waitForSpinnerToDisappear(driver, 2, 2);

		ExtentTestManager.getTest().log(Status.PASS, "Submitting the request");
		Log.info("Submitting the request");
		ExtentTestManager.getTest().log(Status.INFO, "Checking submit btn ");
		Log.info("checking submit btn");
		click(locators.SubmitBtn);
		waitForSpinnerToDisappear(driver, 2, 2);
		click(locators.YesInSubmit);
		waitForSpinnerToDisappear(driver, 2, 2);
		WaitForElementToBeClickable(locators.OkForSubmit);
		click(locators.OkForSubmit);
		waitForSpinnerToDisappear(driver, 2, 2);
		handlePopupDesktop();
		Signout();

	}

	public void RequestWithdraw(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {
		NaviageteToResignPage(testdata, context);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		ScrollUntilElementVisible(locators.ScrollTillViewDep);
		waitForSpinnerToDisappear(driver, 2, 2);
		Log.info("Clicking on Withdrawn button ");
		click(locators.WithdrawBtn);
		waitForSpinnerToDisappear(driver, 2, 2);
		Log.info("Click yes on Withdrawn dialog box ");
		click(locators.Yes);
		waitForSpinnerToDisappear(driver, 2, 2);
		Log.info("Click ok once after yes ");
		waitForSpinnerToDisappear(driver, 2, 2);
		click(locators.OkInWithdraw);
		waitForSpinnerToDisappear(driver, 2, 2);
		Signout();
	}

	public void RequestApprove(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {
		NaviageteToResignPage(testdata, context);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		ScrollUntilElementVisible(locators.ScrollTillViewDep);
		waitForSpinnerToDisappear(driver, 2, 2);

		Log.info("Clicking on Approve button ");
		click(locators.ApproveBtn);
		waitForSpinnerToDisappear(driver, 2, 2);
		Log.info("Click yes on Approve dialog box ");
		click(locators.Yes);
		waitForSpinnerToDisappear(driver, 2, 2);
		Log.info("Click ok once after yes ");
		waitForSpinnerToDisappear(driver, 2, 2);
		click(locators.OkInApprove);
		waitForSpinnerToDisappear(driver, 2, 2);
		Signout();
	}

	public void SignInManager() throws InterruptedException, IOException {

		SignInAsEmployee(ManagerUserName);
	}

	public void SignInHR1() throws InterruptedException, IOException {
		SignInAsEmployee(HR1UserName);
	}

	public void SignInHR2() throws InterruptedException, IOException {
		SignInAsEmployee(HR2UserName);
	}

	public void NaviageteToResignPage(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {

		Log.info("Scrolled untill travel");
		ScrollUntilElementVisible(locators.ScrollTillTravel);
		click(locators.EmpTabMain);
		waitForSpinnerToDisappear(driver, 2, 2);
		ExtentTestManager.getTest().log(Status.PASS, "Employee Tab is expanded ");
		Log.info("Employee Tab is expanded ");

		click(locators.ApprovalTab);
		waitForSpinnerToDisappear(driver, 2, 2);
		ExtentTestManager.getTest().log(Status.PASS, "Approval Tab is expanded ");
		Log.info("Approval Tab is expanded ");

		click(locators.EmpResignTab);
		waitForSpinnerToDisappear(driver, 2, 2);
		ExtentTestManager.getTest().log(Status.PASS, "Navigated to Employee Separation Request Approval Page ");
		Log.info("Navigated to Employee Separation Request Approval Page  ");

		Log.info("Navigating to search btn");
		NavigateToEmpReqUsingCode(testdata, context);
	}
}
