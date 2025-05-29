package com.Pages_Methods;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
import com.Page_Locators.Locators_Approve_Process;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class Methods_Approver_EmpProfile extends Base_Class {

	Locators_Approve_Process locators = new Locators_Approve_Process();

	@Test
	public boolean isQuickApprovalDisplayed() throws InterruptedException {
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.PASS, "Verifies located Quick Approval ");
		Log.info("Verifies located Quick Approval ");
		return Base_Class.CheckElementDisable(locators.QuickApprove);
	}

	@Test
	public void ValidateQuickApprove() throws InterruptedException {
		click(locators.QuickApprove);
		ExtentTestManager.getTest().log(Status.PASS, "Navigating to Quick Approval ");
		Log.info("Navigating to Quick Approval ");

		Thread.sleep(2000);
		String Expectedtext = "Approvals Pending";
		Thread.sleep(2000);
		String ActualText = driver.findElement(locators.QuickApHead).getText().toString();
		Thread.sleep(2000);
		Assert.assertEquals(ActualText, Expectedtext, "User couldn't locate Quick Approval checkbox");
		Log.info(Expectedtext + " is successfully displayed");
		ExtentTestManager.getTest().log(Status.PASS, "Successfully  Quick Approvals is displayed");
		Log.info("Successfully  Quick Approvals is displayed");
	}

	@Test
	public boolean isProfileApprovalVisible() throws InterruptedException {
		Thread.sleep(20000);
		ExtentTestManager.getTest().log(Status.PASS, "Verified Located Profile Approval ");
		Log.info("Verified Located Profile Approval ");
		return Base_Class.CheckElementDisable(locators.profileApproval);
	}

	@Test
	public void validateToProfileApproval() throws InterruptedException {
		click(locators.profileApproval);
		ExtentTestManager.getTest().log(Status.PASS, "Navigated to Profile Approvals ");
		Log.info("Navigated to Profile Approvals ");
		Thread.sleep(2000);
		String Expectedtext = "Profile Edit Approvals";
		String ActualText = driver.findElement(locators.ProfileApHead).getText().toString();
		Assert.assertEquals(ActualText, Expectedtext, "User is successully redirected to profile approval page");
		Log.info(Expectedtext + " is successfully displayed");
		ExtentTestManager.getTest().log(Status.PASS, "Successfully  Profile Approvals is displayed ");
		Log.info("Successfully  Profile Approvals is displayed ");

	}

	public boolean isCloseButtonDisplayed() throws InterruptedException {

		return ElementDisplayed(locators.closeBtn);
	}

	public boolean isSearchButtonDisplayed() throws InterruptedException {
		return ElementDisplayed(locators.SearchBtn);
	}

	public boolean isEmployeeNameLabelDisplayed() throws InterruptedException {
		return ElementDisplayed(locators.EmpNameLabel);
	}

	public boolean isReportingToLabelDisplayed() throws InterruptedException {
		return ElementDisplayed(locators.ReportingToLabel);
	}

	public boolean isOfficeLabelDisplayed() throws InterruptedException {
		return ElementDisplayed(locators.OfficeLabel);
	}

	public boolean isDepartmentLabelDisplayed() throws InterruptedException {
		return ElementDisplayed(locators.DepartmentLabel);
	}

	public boolean isDesignationLabelDisplayed() throws InterruptedException {
		return ElementDisplayed(locators.DesignationLabel);
	}

	public boolean isRequestedDateLabelDisplayed() throws InterruptedException {
		return ElementDisplayed(locators.RequestedDate);
	}

	public boolean isRequestedByLabelDisplayed() throws InterruptedException {
		return ElementDisplayed(locators.RequestedBy);
	}

	@Test
	public void testPresenceOfUiElements() throws InterruptedException {
		Assert.assertTrue(isCloseButtonDisplayed(), "Close button is not displayed");
		ExtentTestManager.getTest().log(Status.PASS, "Verified Close button is displayed");
		Log.info("Verified Close button is displayed");

		Assert.assertTrue(isSearchButtonDisplayed(), "Search button is not displayed");
		ExtentTestManager.getTest().log(Status.PASS, "Verified Search button is displayed");
		Log.info("Verified Search button is displayed");

		Assert.assertTrue(isEmployeeNameLabelDisplayed(), "Employee Name label is not displayed");
		ExtentTestManager.getTest().log(Status.PASS, "Verified Employee Label is displayed");
		Log.info("Verified Employee Label is displayed");

		Assert.assertTrue(isReportingToLabelDisplayed(), "Reporting To label is not displayed");
		ExtentTestManager.getTest().log(Status.PASS, "Verified Reporting To Label is displayed");
		Log.info("Verified Reporting To Label is displayed");

		Assert.assertTrue(isOfficeLabelDisplayed(), "Office label is not displayed");
		ExtentTestManager.getTest().log(Status.PASS, "Verified Office Label is displayed");
		Log.info("Verified Office Label is displayed");

		Assert.assertTrue(isDepartmentLabelDisplayed(), "Department label is not displayed");
		ExtentTestManager.getTest().log(Status.PASS, "Verified Department Label is displayed");
		Log.info("Verified Department Label is displayed");

		Assert.assertTrue(isDesignationLabelDisplayed(), "Designation label is not displayed");
		ExtentTestManager.getTest().log(Status.PASS, "Verified Designation Label is displayed");
		Log.info("Verified Designation Label is displayed");

		Assert.assertTrue(isRequestedDateLabelDisplayed(), "Requested Date label is not displayed");
		ExtentTestManager.getTest().log(Status.PASS, "Verified Reqested Date Label is displayed");
		Log.info("Verified Requested Date Label is displayed");

		Assert.assertTrue(isRequestedByLabelDisplayed(), "Requested By label is not displayed");
		ExtentTestManager.getTest().log(Status.PASS, "Verified Requested By Label is displayed");
		Log.info("Verified Requested By Label is displayed");

		WebElement totalNoItemElement = driver.findElement(locators.TotalNoItem);
		Log.info(totalNoItemElement.getText());

		WebElement paginationElement = driver.findElement(locators.Pagination);
		System.out.println(paginationElement.isEnabled());
		ExtentTestManager.getTest().log(Status.PASS, "Verified Pagination is Enabled");
		Log.info("Verified Pagination is Enabled");
	}

	@Test
	public void NavigateSearchbtn() throws InterruptedException {
		click(locators.SearchBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Verified We are into search Dialog");
		Log.info("Verified Search Dialog is Redirected");
	}

	@Test
	public void presenceUIElmSearchDialog() throws InterruptedException {
		Assert.assertTrue(ElementDisplayed(locators.SearchColumnDropDown), "Search Column is not displayed");
		ExtentTestManager.getTest().log(Status.PASS, "Verified Search Column is displayed in Dialog");
		Log.info("Verified Search Column is displayed in Dialog");

		Assert.assertTrue(ElementDisplayed(locators.SearchTypeDropDown), "Search Type is not displayed");
		ExtentTestManager.getTest().log(Status.PASS, "Verified Search Type is displayed in Dialog");
		Log.info("Verified Search Type is displayed in Dialog");

		Assert.assertTrue(ElementDisplayed(locators.SearchValueTextField), "Text Field is not displayed");
		ExtentTestManager.getTest().log(Status.PASS, "Verified Text Field is displayed in Dialog");
		Log.info("Verified Text Field is displayed in Dialog");

		Assert.assertTrue(ElementDisplayed(locators.SearchBtnInDialog), "Search Button is not displayed");
		ExtentTestManager.getTest().log(Status.PASS, "Verified Search Button is displayed in Dialog");
		Log.info("Verified Search Button is displayed in Dialog");

		Assert.assertTrue(ElementDisplayed(locators.CancelBtnInDialog), "Cancel Button is not displayed");
		ExtentTestManager.getTest().log(Status.PASS, "Verified Cancel Button is displayed in Dialog");
		Log.info("Verified Cancel Button is displayed in Dialog");
	}

	@Test
	public void SearchEmpAndVerify(String SearchName) throws InterruptedException {
		click(locators.SelectSearchCol);
		ExtentTestManager.getTest().log(Status.PASS, "Selected Employee Name from Search Column");
		Log.info("Selected Employee Name from Search Column");

		click(locators.SelectSearchType);
		ExtentTestManager.getTest().log(Status.PASS, "Selected Equals from Search Type");
		Log.info("Selected Equals from Search Type");

		String name = SearchName;
		input(locators.TypeSearchValue, name);
		ExtentTestManager.getTest().log(Status.PASS, "Enter Search Value  " + name);
		Log.info("Enter Search Value  " + name);

		click(locators.SearchBtnInDialog);
		ExtentTestManager.getTest().log(Status.PASS, "Clicked on Search button ");
		Log.info("Clicked on Search Button");
		Thread.sleep(2000);

		try {
			boolean Flag = ElementDisplayed(locators.ResultEmpName);
			if (Flag == true) {
				Log.info("Displayed... Please continue");
				String GetTextvalue = driver.findElement(locators.ResultEmpName).getText().toString();
				Assert.assertEquals(name, GetTextvalue, "Invalid");
				ExtentTestManager.getTest().log(Status.PASS, "Verified if Entered and listed is matching or not ");
				Log.info("Verified if Entered and listed is matching or not ");
			}
		} catch (Exception e) {
			Log.info("Not Displayed... Please continue");
		}
	}

	@Test
	public void SearchBtnFunctionality(String SearchName) throws InterruptedException {
		NavigateSearchbtn();
		presenceUIElmSearchDialog();
		SearchEmpAndVerify(SearchName);
	}

	@Test
	public void closeBtnFunctionality() throws InterruptedException {
		click(locators.closeBtn);
		ExtentTestManager.getTest().log(Status.PASS,
				"Successfully closed the search functionality and naivigated to Home Page ");
		Log.info("Successfully closed the search functionality and naivigated to Home Page ");
		handlePopupDesktop();
		validateDashBoard();
	}

	@Test
	public void clickEmployeeName(String EmpName) throws Exception {
		try {
			By EmpNameLink = By.xpath("//span[@class='link ng-star-inserted'][normalize-space()='" + EmpName + "']");
			boolean flag = ElementDisplayed(EmpNameLink);
			if (flag == true) {
				ExtentTestManager.getTest().log(Status.PASS, "Displayed the employee " + flag);
				Log.info("Displayed");
				click(EmpNameLink);
				ExtentTestManager.getTest().log(Status.PASS, "Successfully navigated to  " + EmpName + " page");
				Log.info("Successfully navigated to  " + EmpName + " page");
			}
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.PASS, "no , Not Displayed the employee ");
			Log.info("not Displayed");
			Log.info("Ending execution");
			Signout();
			driver.quit();
			driver = null;
			throw new Exception("Test aborted: NoSuchElementException", e);
		}
	}

	@Test
	public void isEmployeeDetailPageLoaded(String SearchName) throws Exception {
		click(locators.QuickApprove);
		click(locators.profileApproval);
		clickEmployeeName(SearchName);
		String actualText = "Approval";
		String expectedText = driver.findElement(locators.EmpNamePage).getText().toString();
		Assert.assertEquals(actualText, expectedText, "User is in wrong page");
		ExtentTestManager.getTest().log(Status.PASS, "SUccessfully redirected to Reshma Murali's Page ");
		Log.info("Successfully navigated to Reshma Murali's Page  ");
	}

	@Test
	public void presenceUIApproval() throws InterruptedException {
		Assert.assertTrue(ElementDisplayed(locators.EmployeeDetails), "Employee Name is not Displayed");
		ExtentTestManager.getTest().log(Status.PASS,
				"Verified Employee Name Lable is displayed in Approval Reqest Page ");
		Log.info("Verified Employee Name Lable is displayed in Approval Request Page ");

		Assert.assertTrue(ElementDisplayed(locators.closeBtnEmp), "Close Button is not Displayed");
		ExtentTestManager.getTest().log(Status.PASS, "Verified Close Button is displayed ");
		Log.info("Verified Close Button is displayed ");

		Assert.assertTrue(ElementDisplayed(locators.ApproveBtn), "Approve Button is not Displayed");
		ExtentTestManager.getTest().log(Status.PASS, "Verified Approve Button is displayed ");
		Log.info("Verified Approve Button is displayed ");

		Assert.assertTrue(ElementDisplayed(locators.RejectBtn), "Reject Button is not Displayed");
		ExtentTestManager.getTest().log(Status.PASS, "Verified Reject Button is displayed ");
		Log.info("Verified Employee Name Lable is displayed ");
	}

	@Test
	public void ApproveRequest() throws InterruptedException {
		// ScrollUntilElementVisible(locators.FooterCard);
		// ScrollUntilElementVisible(locators.ApproveBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Scrolled Until Approve Button  is present ");
		Log.info("Scrolled Until Approve Button  is present ");
		Thread.sleep(3000);
		ScrollUntilElementVisible(locators.VisibleElement);

		Thread.sleep(5000);
		// Wait for some time to observe the scroll (optional)
		click(locators.ApproveBtn);
		ExtentTestManager.getTest().log(Status.PASS, "We are into approve dialog ");
		Log.info("We are into approve dialog ");

		Thread.sleep(2000);
		click(locators.ApproveBtnInDialog);
		ExtentTestManager.getTest().log(Status.PASS, "Request is Approved ");
		Log.info("Request is Approved ");
	}

	@Test
	public void RejectRequest(String SearchEmp, String Comment) throws InterruptedException {
		By RejectEmp = By.xpath("//span[@class='link ng-star-inserted'][normalize-space()='" + SearchEmp + "']");
		try {
			WebElement Element = driver.findElement(RejectEmp);
			if (Element.isDisplayed()) {
				ExtentTestManager.getTest().log(Status.PASS, "Displayed the employee ");
				Log.info("Displayed");
				click(RejectEmp);
				Thread.sleep(2000);
				ScrollUntilElementVisible(locators.RejectBtn);
				ExtentTestManager.getTest().log(Status.PASS, "Scrolled Until Reject Button  is present ");
				Log.info("Scrolled Until Reject Button  is present ");

				Thread.sleep(2000);
				click(locators.RejectBtn);
				ExtentTestManager.getTest().log(Status.PASS, "We are into Reject Dialog Box ");
				Log.info("We are into Reject Dialog Box ");

				Thread.sleep(1000);
				click(locators.CommentCLick);
				ExtentTestManager.getTest().log(Status.PASS, "Comment Text Area got active ");
				Log.info("Comment Text Area got active ");

				Thread.sleep(5000);
//				JavascriptExecutor js = (JavascriptExecutor) driver;
//				js.executeScript("arguments[0].value=Comment;", driver.findElement(locators.RejectCommentBox));
				input(locators.RejectCommentBox, Comment);
				ExtentTestManager.getTest().log(Status.PASS, "Entered Comment ");
				Log.info("Entered Comment ");

				click(locators.RejectBtnInDialog);
				ExtentTestManager.getTest().log(Status.PASS, "Request is Rejected ");
				Log.info("Request is Rejected ");

				Thread.sleep(3000);
			}
		} catch (Exception e) {
			System.out.println(e);
			Log.info("Not Displayed");
			ExtentTestManager.getTest().log(Status.PASS, "Not Displayed the employee ");
		}
	}
}
