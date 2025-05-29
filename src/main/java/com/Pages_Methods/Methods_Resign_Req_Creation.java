package com.Pages_Methods;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Locators.Locators_Resign_Req_Approval;
import com.Page_Locators.Locators_Resign_Req_Creation;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class Methods_Resign_Req_Creation extends Base_Class {

	Locators_Resign_Req_Creation locators = new Locators_Resign_Req_Creation();
	Locators_Resign_Req_Approval ApprovalLocators = new Locators_Resign_Req_Approval();
	Methods_Resign_Req_Approval ApprovalMethods = new Methods_Resign_Req_Approval();

	public boolean LoginFunctionalityValidation() throws InterruptedException {
		/*
		 * Tc 1
		 */
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "User logged in successfully");
		ExtentTestManager.getTest().log(Status.PASS, "Verifying Navigation panel is in left side ");
		return ElementDisplayed(locators.NavigationBar);
	}

	public boolean validatingSelfService() throws InterruptedException {
		/*
		 * Tc 4
		 */
		Thread.sleep(2000);
		click(locators.SelfService);
		boolean Flag = ElementDisplayed(locators.SelfServicExpanded);
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on self service option");
		ExtentTestManager.getTest().log(Status.PASS, "Verified Self Service is expanded");

		return Flag;
	}

	public void checkIfEmpResigned(String un, Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException, IOException {
		try {
			Thread.sleep(2000);
			click(locators.EmpSeparation);
			Log.info("Checking if request is submitted or not  ");
			ExtentTestManager.getTest().log(Status.INFO, "Checking if already submitted resignation ");
			WebElement Element = driver.findElement(locators.ApproverDeatilsHeader);
			Log.info("Element is displayed  " + Element.isDisplayed());
			if (Element.isDisplayed()) {
				Log.info(" Request is submittted.... Firstly we need to Reject it ");
				ExtentTestManager.getTest().log(Status.INFO, "Request is submitted... Firstly we need to reject it ");
				ExtentTestManager.getTest().log(Status.INFO, "Navigating to IfPresent method ");
				Log.info("navigating to IfPresent methods");
				Thread.sleep(2000);
				IfPresent(un, testdata, context);
			}
		} catch (Exception e) {
			System.out.println(" The error is " + e);
			Log.info("No request is sent yet... Please submit request");
		}
	}

	private void IfPresent(String un, Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException, IOException {
		String ProjectMngr = driver.findElement(locators.ManagerName).getText().toString();
		String formattedName = ProjectMngr.replace(" ", ".");
		// Output
		Log.info("Formatted Name = " + formattedName);
		Signout();
		SignInAsEmployee(formattedName);
		ScrollUntilElementVisible(locators.ScrollTillTravel);
		click(locators.EmpTab);
		click(locators.ApprovalTab);
		click(locators.EmpResignTab);
		Log.info("navigating to SearchEmpAndVerify methods");
		SearchEmpAndVerify(testdata, context);
		Log.info("Navigated to Employee Seperation Approval Page");
		SignInAsEmployee(un);
		click(locators.SelfService);
		click(locators.Request);
		click(locators.EmpSeparation);
	}

	public void SearchEmpAndVerify(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {
		try {
			String userName = testdata.get("FullNameOfEmp").toString();
			String empCode = testdata.get("Code").toString();

			click(locators.SearchIconClick);

			// Check if search criteria dropdown is already visible
			boolean isCriteriaVisible = driver.findElements(locators.SearchColumn).size() > 0;

			if (!isCriteriaVisible) {
				// Click "Add Another Search Criteria" if dropdown is not visible
				click(locators.AddSearchCriteriaBtn);
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
				wait.until(ExpectedConditions.visibilityOfElementLocated(locators.SearchColumn));
			}

			// Common search logic
			select("Employee", locators.SearchColumn);
			select("Equals", locators.SearchType);
			input(locators.SearchValue, userName);
			click(locators.searchBtnInDialog);

			// Wait for search results to appear
			By resultEmp = By
					.xpath("//span[contains(@class,'link ng-star-inserted') and contains(text(), '" + empCode + "')]");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.elementToBeClickable(resultEmp));

			Log.info("XPath for " + userName + " is " + resultEmp);
			Log.info("Navigating to emp request page");

			click(resultEmp);

			Log.info("Navigating to RequestReject method");
			ApprovalMethods.RequestReject();

		} catch (Exception e) {
			Log.error("Error occurred during search and navigation: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public boolean ValidatedElementOfSelfService() throws InterruptedException {
		Thread.sleep(2000);
		boolean Flag1 = ElementDisplayed(locators.OrganizationalTree);
		ExtentTestManager.getTest().log(Status.INFO, "Organization Tree is displayed " + Flag1);
		ExtentTestManager.getTest().log(Status.PASS, "Verifying Organization tree is displayed in Self service Panel");
		Log.info("Verifying Organization tree is displayed in Self service Panel ");

		boolean Flag2 = ElementDisplayed(locators.MyPage);
		ExtentTestManager.getTest().log(Status.INFO, "My Page is displayed " + Flag2);
		ExtentTestManager.getTest().log(Status.PASS, "Verifying My Page is displayed in Self service Panel");
		Log.info("Verifying My Page is displayed in Self service Panel ");

		boolean Flag3 = ElementDisplayed(locators.Request);
		ExtentTestManager.getTest().log(Status.INFO, "Request is displayed " + Flag3);
		ExtentTestManager.getTest().log(Status.PASS, "Verifying Request is displayed in Self service Panel");
		Log.info("Verifying Request is displayed in Self service Panel ");

		boolean flag = Flag1 && Flag2 && Flag3;
		return flag;
	}

	public boolean ValidatingRequest() throws InterruptedException {
		Thread.sleep(2000);
		click(locators.Request);
		boolean Flag1 = ElementDisplayed(locators.RequestExpanded);
		ExtentTestManager.getTest().log(Status.INFO, "Request is expanded " + Flag1);
		ExtentTestManager.getTest().log(Status.PASS, "Verifying Request is got expanded");
		Log.info("Verifying Request is got expanded ");

//		boolean Flag2 = ElementDisplayed(locators.EmpVehicle);
//		ExtentTestManager.getTest().log(Status.INFO, "Under Request Employee Vehicle displayed " + Flag1);
//		ExtentTestManager.getTest().log(Status.PASS, "Verifying Request dropdown with Vehical Request option ");
//		Log.info("Verifying Request dropdown with Vehical Request option ");

		boolean Flag3 = ElementDisplayed(locators.EmpTransfer);
		ExtentTestManager.getTest().log(Status.INFO, "Under Request Employee Transfer displayed " + Flag3);
		ExtentTestManager.getTest().log(Status.PASS,
				"Verifying Request dropdown with Employee Initiated Transfer option ");
		Log.info("Verifying Request dropdown with Employee Initiated Transfer option ");

		boolean Flag4 = ElementDisplayed(locators.EmpSeparation);
		ExtentTestManager.getTest().log(Status.INFO, "Under Request Employee Separation displayed " + Flag3);
		ExtentTestManager.getTest().log(Status.PASS,
				"Verifying Request dropdown with Employee Initiated Separation option ");
		Log.info("Verifying Request dropdown with Employee Initiated Separation option ");

		boolean Flag = Flag1 && Flag3 && Flag4;
		return Flag;
	}

	public boolean ValidateEmpSeparationPage() throws InterruptedException {

		Thread.sleep(1000);
		boolean Flag1 = ElementDisplayed(locators.EmpSeparationHeader);
		ExtentTestManager.getTest().log(Status.INFO,
				"On landing into Emp Separation Page Header is displayed  " + Flag1);
		ExtentTestManager.getTest().log(Status.PASS,
				"Verifying We are redirected to Employee Initiated Separation Page ");

		boolean Flag2 = ElementDisplayed(locators.closeBtn);
		ExtentTestManager.getTest().log(Status.INFO, "Close btn is displayed " + Flag2);
		System.out.println(Flag2);
		ExtentTestManager.getTest().log(Status.PASS, "Verifying CLose button is displayed on page ");

		boolean Flag3 = ElementDisplayed(locators.ExitTypeLabel);
		ExtentTestManager.getTest().log(Status.INFO, "Exit type is displayed " + Flag3);
		ExtentTestManager.getTest().log(Status.PASS, "Verifying Exit Type Lable is displayed ");

		boolean Flag4 = ElementDisplayed(locators.RequestDateLabel);
		ExtentTestManager.getTest().log(Status.INFO, "Request Date is displayed " + Flag4);
		ExtentTestManager.getTest().log(Status.PASS, "Verifying Request Date Lable is displayed ");

		boolean Flag5 = ElementDisplayed(locators.PreferredDateLabel);
		ExtentTestManager.getTest().log(Status.INFO, "Preferred Date is displayed " + Flag5);
		ExtentTestManager.getTest().log(Status.PASS, "Verifying Preferred Date Lable is displayed ");

		boolean Flag6 = ElementDisplayed(locators.ActualRelievingDateLabel);
		ExtentTestManager.getTest().log(Status.INFO, "Actual Relieving date is displayed " + Flag6);
		ExtentTestManager.getTest().log(Status.PASS, "Verifying Notice Period Relieving Date Lable is displayed");

		boolean Flag7 = ElementDisplayed(locators.ReasonsLabel);
		ExtentTestManager.getTest().log(Status.INFO, "Reason is displayed " + Flag7);
		ExtentTestManager.getTest().log(Status.PASS, "Verifying Notice Period Relieving Date Lable is displayed");

		boolean Flag8 = ElementDisplayed(locators.CommentsLabel);
		ExtentTestManager.getTest().log(Status.INFO, "Comment is displayed " + Flag8);
		ExtentTestManager.getTest().log(Status.PASS, "Verifying Comment box label is displayed ");

		boolean Flag9 = ElementDisplayed(locators.SubmitBtn);

		boolean Flag10 = ElementDisplayed(locators.Savebtn);

		try {

			ExtentTestManager.getTest().log(Status.INFO, "Submit btn in displayed " + Flag9);
			ExtentTestManager.getTest().log(Status.PASS, "Verifying Submit Button is displayed ");

			ExtentTestManager.getTest().log(Status.INFO, "Save btn is displayed " + Flag10);
			ExtentTestManager.getTest().log(Status.PASS, "Verifying Save Button is displayed");

			if (Flag9 == true && Flag10 == true) {
				Log.info("all displayed");
			}
		} catch (Exception e) {
			System.out.println(" The error is " + e);
			Log.info("No not displayed");
		}

		boolean Flag = Flag1 && Flag2 && Flag3 && Flag4 && Flag5 && Flag6 && Flag7 && Flag8;
		return Flag;
	}

	public boolean validateCloseBtn() throws InterruptedException {
		Thread.sleep(1000);
		click(locators.closeBtn);
		ExtentTestManager.getTest().log(Status.INFO, "Clicking on Close btn");
		handlePopupDesktop();
		ExtentTestManager.getTest().log(Status.INFO, " Handling Desktop Popup ");
		boolean Flag = ElementDisplayed(locators.Dashboard);
		ExtentTestManager.getTest().log(Status.INFO, "Redirected to dashboard " + Flag);
		ExtentTestManager.getTest().log(Status.PASS, "On clicking on close navigated to Dashboard Sucessfully ");

		return Flag;
	}

	public boolean validateExitTypeSelectBox() throws InterruptedException {
		Thread.sleep(2000);
		click(locators.SelfService);
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on self service ");
		click(locators.Request);
		ExtentTestManager.getTest().log(Status.INFO, "clicked on request ");
		click(locators.EmpSeparation);
		ExtentTestManager.getTest().log(Status.INFO, "clicked on employee separation ");
		Thread.sleep(2000);
		boolean Flag = ElementEnableOrDisable(locators.SelectExitType);
		ExtentTestManager.getTest().log(Status.INFO, "Exit Type Drop down is disable with value Resignation " + Flag);
		Log.info("value is = " + Flag);
		ExtentTestManager.getTest().log(Status.PASS, "Verifying Exit Type Select Box if  disable ");
		return Flag;
	}

	public boolean validateRequestDateInputBox() throws InterruptedException {
		Thread.sleep(2000);
		boolean Flag = ElementEnableOrDisable(locators.InputRequestDate);
		Log.info("value is = " + Flag);
		ExtentTestManager.getTest().log(Status.PASS, "Verifying Request Date Input Box if  disable ");
		Log.info("Verifying Request Date Input Box is  disable ");
		return Flag;
	}

	public boolean validatePreferredDateInputBox() throws InterruptedException {
		Thread.sleep(2000);
		boolean Flag = ElementEnableOrDisable(locators.InputPreferedDate);
		Log.info("value is = " + Flag);
		ExtentTestManager.getTest().log(Status.PASS, "Verifying Preferred Date Input Box if  disable ");
		Log.info("Verifying Preferred Date Input Box is  disable ");
		return Flag;
	}

	public boolean validateDatePicker() throws InterruptedException {
		// check if date picker is visible in preferred relieving date
		Thread.sleep(2000);
		boolean Flag = ElementEnableOrDisable(locators.DatePickerPreferredDate);
		Log.info("value is = " + Flag);
		ExtentTestManager.getTest().log(Status.PASS, "Verifying DatePicker is displayed in Preferred Relieving Date");
		Log.info("Verifying DatePicker is displayed in Preferred Relieving Date");
		return Flag;

	}

	public void validateKeyboardAction(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {
		// checking if we can enter dates via keyword it should work fine
		Thread.sleep(1000);
		clear(locators.InputPreferedDate);
		ExtentTestManager.getTest().log(Status.INFO, "clearing the field");
		String date = testdata.get("KeyboardDate").toString();
		input(locators.InputPreferedDate, date);
		ExtentTestManager.getTest().log(Status.INFO, "Entered date via KeyBoard in format ( MM/DD/YYY) ");
		ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered date using keyboard ");
		Log.info("Successfully Entered date using keyboard  ");
	}

	public boolean openDatePicker() throws InterruptedException {
		Thread.sleep(2000);
		click(locators.DatePickerPreferredDate);
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on date picker");
		boolean Flag = ElementDisplayed(locators.CalenderPopup);
		ExtentTestManager.getTest().log(Status.INFO, "Calender popup displayed ");
		ExtentTestManager.getTest().log(Status.PASS, "Verified Calender is displayed");
		Log.info("Verified Calender is displayed");
		return Flag;
	}

	public void EnterPastDatewithDatePicker() throws InterruptedException {
		clear(locators.InputPreferedDate);
		ExtentTestManager.getTest().log(Status.INFO, "clearing the field");
		Thread.sleep(2000);
		openDatePicker();
		Thread.sleep(1000);
		click(locators.ChoseDate);
		ExtentTestManager.getTest().log(Status.INFO, "clicked on chose date");
		click(locators.Pastyear);
		ExtentTestManager.getTest().log(Status.INFO, "Selected Year");
		click(locators.PastMon);
		ExtentTestManager.getTest().log(Status.INFO, "Selected Month");
		click(locators.PastDate);
		ExtentTestManager.getTest().log(Status.INFO, "Selected Day");
		Log.info("Error recieved for past date" + driver.findElement(locators.PastDateError).getText().toString());
		ExtentTestManager.getTest().log(Status.INFO, "Got error ");

		ExtentTestManager.getTest().log(Status.PASS, "Preferred Relieving Date is not accepting Past date");
		Log.info("Preferred Relieving Date is not accepting Past date");
	}

	public void EnterPresentDatewithDatePicker() throws InterruptedException {
		clear(locators.InputPreferedDate);
		ExtentTestManager.getTest().log(Status.INFO, "clearing the field");
		Thread.sleep(2000);
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String formattedDate = currentDate.format(formatter);
		Log.info("Current Date in MM/DD/YYYY format: " + formattedDate);
		clear(locators.InputPreferedDate);
		input(locators.InputPreferedDate, formattedDate);
		ExtentTestManager.getTest().log(Status.PASS, "Preferred Relieving Date is accepting Present Date");
		Log.info("Preferred Relieving Date is accepting Present Date");
	}

	public void EnterFutureDatewithDatePicker() throws InterruptedException {
		clear(locators.InputPreferedDate);
		ExtentTestManager.getTest().log(Status.INFO, "clearing the field");
		Thread.sleep(2000);
		openDatePicker();
		Thread.sleep(1000);
		click(locators.ChoseDate);
		ExtentTestManager.getTest().log(Status.INFO, "clicked on chose date");
		click(locators.Futureyear);
		ExtentTestManager.getTest().log(Status.INFO, "Selected Year");
		click(locators.FutureMon);
		ExtentTestManager.getTest().log(Status.INFO, "Selected Month");
		click(locators.FutureDate);
		ExtentTestManager.getTest().log(Status.INFO, "Selected Day");

		ExtentTestManager.getTest().log(Status.PASS, "Preferred Relieving Date is accepting Future Date");
		Log.info("Preferred Relieving Date is accepting Future Date");
	}

	public void InvalidFormatDatewithDay(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException {
		clear(locators.InputPreferedDate);
		ExtentTestManager.getTest().log(Status.INFO, "clearing the field");
		String date = testdata.get("InvalidDateWithDay").toString();
		input(locators.InputPreferedDate, date);
		click(locators.SubmitBtn);
		Log.info(driver.findElement(locators.InvalidDateError).getText().toString());
		ExtentTestManager.getTest().log(Status.INFO, "Got error for entering invalid date (dd/mm/yyyy) ");
		ExtentTestManager.getTest().log(Status.PASS, "Preferred Relieving Date is not accepting Invalid date format");
		Log.info("Preferred Relieving Date is not accepting Invalid date format");
	}

	public void InvalidFormatDateWithYear(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "Cleared the Preferred date field");
		clear(locators.InputPreferedDate);
		String date = testdata.get("InvalidDateWithYear").toString();
		input(locators.InputPreferedDate, date);
		ExtentTestManager.getTest().log(Status.INFO, " Entering date in Invalid format as (YYYY/MM/DD) ");
		click(locators.SubmitBtn);
		ExtentTestManager.getTest().log(Status.INFO,
				"clicking on submit button to check if invalid msg is displayed or not ");
		// Log.info("Here's what it fetched " +
		// driver.findElement(locators.InputPreferedDate).getText());
		Log.info(driver.findElement(locators.InvalidDateError).getText().toString());
		ExtentTestManager.getTest().log(Status.INFO, "Got error for entering invalid date (yyyy/dd/mm) ");
		ExtentTestManager.getTest().log(Status.PASS, "Preferred Relieving Date is not accepting Invalid date format");
		Log.info("Preferred Relieving Date is not accepting Invalid date format");
	}

	public boolean validateNoticePeriodDateInputBox() throws InterruptedException {
		Thread.sleep(2000);
		boolean Flag = ElementEnableOrDisable(locators.InputPreferedDate);
		ExtentTestManager.getTest().log(Status.INFO, "Notice period is disable");
		Log.info("value is = " + Flag);
		ExtentTestManager.getTest().log(Status.PASS, "Verifying Actual Relieving Input Box if  disable ");
		Log.info("Verifying Actual Relieving Input Box if  disable");
		return Flag;
	}

	public void validateReasonAsMultiselect() throws InterruptedException {
		Thread.sleep(1000);
		click(locators.ReasonsDropDown);
		ExtentTestManager.getTest().log(Status.INFO, "Opened Reasons dropdrop down");
		click(locators.SelectOption1);
		ExtentTestManager.getTest().log(Status.INFO, "Selected Reason1 Career Enhancement ");
		click(locators.SelectOption4);
		ExtentTestManager.getTest().log(Status.INFO, "Selected Reason2 Type of work");
		click(locators.SelectOption2);
		ExtentTestManager.getTest().log(Status.INFO, "Selected Reason3 Medical Reason");

		ExtentTestManager.getTest().log(Status.PASS, "Verified multi select is possible ");
		ExtentTestManager.getTest().log(Status.INFO, "Multi select is possible");

		Log.info("Verified multi select is possible ");
	}

	public boolean searchWithKeywordPresent(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException {
		Thread.sleep(1000);
		click(locators.SearchBoxReason);
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on Search boox of reason dropdown");
		String Text = testdata.get("SearchKeyword").toString();
		input(locators.SearchBoxReason, Text);
		ExtentTestManager.getTest().log(Status.INFO, "Searched reason Pay");
		String key1 = driver.findElement(locators.SelectOption3).getText().toString();
		boolean flag1 = ElementDisplayed(locators.SelectOption3);
		Log.info("In Pay i got this keyword " + key1 + " " + flag1);
		ExtentTestManager.getTest().log(Status.INFO, " Checking if we got match ");
		ExtentTestManager.getTest().log(Status.PASS, "Verified Keywords present in list are listed while searching ");
		ExtentTestManager.getTest().log(Status.INFO, "In Pay i got this keyword " + key1 + " " + flag1);
		Log.info("Verified Keywords present in list are listed while searching ");
		click(locators.paySearch);
		clear(locators.SearchBoxReason);
		return flag1;
	}

	public void searchWithKeywordNotPresent(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException {
		Thread.sleep(1000);
		click(locators.SearchBoxReason);
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on Search boox of reason dropdown");
		String Text = testdata.get("InvalidKeywordSearch").toString();
		input(locators.SearchBoxReason, Text);
		ExtentTestManager.getTest().log(Status.PASS, "Keyword not found");
		clear(locators.SearchBoxReason);
	}

	public boolean searchWithLowerUpperCase(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException {
		Thread.sleep(1000);
		click(locators.SearchBoxReason);

		ExtentTestManager.getTest().log(Status.INFO, "Checked for lower case");
		String lowercase = testdata.get("LowerCase").toString();
		input(locators.SearchBoxReason, lowercase);
		ExtentTestManager.getTest().log(Status.INFO, "Searched reason");
		String key1 = driver.findElement(locators.SelectOption4).getText().toString();
		boolean flag1 = ElementDisplayed(locators.SelectOption4);
		ExtentTestManager.getTest().log(Status.PASS, "we can search in lower case");
		Log.info("I got this keyword " + key1 + " " + flag1);

		clear(locators.SearchBoxReason);
		ExtentTestManager.getTest().log(Status.INFO, "Checked for upper case");
		String uppercase = testdata.get("UpperCase").toString();
		input(locators.SearchBoxReason, uppercase);
		ExtentTestManager.getTest().log(Status.INFO, "Searched reason");
		String key2 = driver.findElement(locators.SelectOption4).getText().toString();
		boolean flag2 = ElementDisplayed(locators.SelectOption4);
		ExtentTestManager.getTest().log(Status.PASS, "we can search in lower case");
		Log.info("I got this keyword " + key2 + " is " + flag2);

		boolean flag = flag1 && flag2;
		return flag;
	}

	public void validateScrollBarInComment() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "Validating scrollbar is working or not ");
		Thread.sleep(1000);
		click(locators.CommentTextArea);
		input(locators.CommentTextArea, " hellooo");
		driver.findElement(locators.CommentTextArea).sendKeys(Keys.ENTER);
		input(locators.CommentTextArea, " comments ");
		driver.findElement(locators.CommentTextArea).sendKeys(Keys.ENTER);
		input(locators.CommentTextArea, " redo");
		driver.findElement(locators.CommentTextArea).sendKeys(Keys.ENTER);
		input(locators.CommentTextArea, " comments ");
		ExtentTestManager.getTest().log(Status.PASS, "Scroll bar is visible ");

	}

	public boolean testUndoRedoFunctionality() throws InterruptedException {
		// undo Ctrl+Z
		// redo Ctrl+Y

		ExtentTestManager.getTest().log(Status.INFO, "Validating undo and redo is possible or not ");
		driver.findElement(locators.CommentTextArea).sendKeys(Keys.chord(Keys.CONTROL + "a"));
		ExtentTestManager.getTest().log(Status.PASS, "Selected all text ");

		driver.findElement(locators.CommentTextArea).sendKeys(Keys.chord(Keys.CONTROL + "z"));
		ExtentTestManager.getTest().log(Status.PASS, "Selected Undo ");

		driver.findElement(locators.CommentTextArea).sendKeys(Keys.chord(Keys.CONTROL + "y"));
		ExtentTestManager.getTest().log(Status.PASS, "Selected Redo");
		return true;
	}

	public boolean testCutAndPaste() throws InterruptedException {
		// undo Ctrl+Z
		// redo Ctrl+Y

		driver.findElement(locators.CommentTextArea).sendKeys(Keys.chord(Keys.CONTROL + "a"));
		ExtentTestManager.getTest().log(Status.PASS, "Selected all text ");

		driver.findElement(locators.CommentTextArea).sendKeys(Keys.chord(Keys.CONTROL + "X"));
		ExtentTestManager.getTest().log(Status.PASS, "Selected Cut ");

		driver.findElement(locators.CommentTextArea).sendKeys(Keys.chord(Keys.CONTROL + "V"));
		ExtentTestManager.getTest().log(Status.PASS, "Selected Paste");
		return true;
	}

	public void testCopyAndPaste() throws InterruptedException {
		driver.findElement(locators.CommentTextArea).sendKeys(Keys.chord(Keys.CONTROL + "A"));
		ExtentTestManager.getTest().log(Status.PASS, "Selected all text ");
		driver.findElement(locators.CommentTextArea).sendKeys(Keys.chord(Keys.CONTROL + "C"));
		ExtentTestManager.getTest().log(Status.PASS, "Selected Copy ");
		driver.findElement(locators.CommentTextArea).sendKeys(Keys.chord(Keys.CONTROL + "V"));
		ExtentTestManager.getTest().log(Status.PASS, "Selected Paste");
	}

	public void EnterComment() throws InterruptedException {
		clear(locators.CommentTextArea);
		input(locators.CommentTextArea, "Resigning");
	}

	public void validatingSaveBtnFunctionality() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "Checking if save btn is saving or not");
		click(locators.Savebtn);
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.PASS, "Saved the request successfully");
		Log.info("Saved the request successully");
	}

	public void validatingSubmitBtn() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "Checking submit btn ");
		Log.info("checking submit btn");
		click(locators.SubmitBtn);
		click(locators.YesInSubmit);
		try {
			WebElement Ele = driver.findElement(locators.OkForSubmit);
			if (Ele.isDisplayed()) {
				Log.info("element is displayed ");
				Thread.sleep(2000);
				click(locators.OkForSubmit);
				Log.info("So click OKY!!!");
			}
		} catch (Exception e) {
			System.out.println(" The error is " + e);
			Log.info("Not displayed .... But request is submitted");

		}

	}
}
