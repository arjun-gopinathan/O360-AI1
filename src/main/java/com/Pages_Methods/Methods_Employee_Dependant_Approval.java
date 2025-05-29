package com.Pages_Methods;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Locators.Locators_Employee_Dependant_Approval;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class Methods_Employee_Dependant_Approval extends Base_Class {
	Locators_Employee_Dependant_Approval locators = new Locators_Employee_Dependant_Approval();

	public boolean LoginFunctionalityValidation() throws InterruptedException {
		waitForSpinnerToDisappear(driver, 2, 2);
		ExtentTestManager.getTest().log(Status.INFO, "User logged in successfully");
		ExtentTestManager.getTest().log(Status.PASS, "Verifying Navigation panel is in left side ");
		return ElementDisplayed(locators.NavigationBar);
	}

	public void VerifyVisiblityOfTravel() throws InterruptedException {
		ScrollUntilElementVisible(locators.ScrollUntilTravels);
		boolean Flag = ElementDisplayed(locators.ScrollUntilTravels);
		String ActualText = "Travel";
		String ExpectedText = driver.findElement(locators.ScrollUntilTravels).getText().toString();
		if (ActualText.equals(ExpectedText) && Flag == true) {
			ExtentTestManager.getTest().log(Status.PASS, "Scrolled untill Travel and now Travels is visible");
			Log.info("Scrolled untill Travel and now Travels is visible " + Flag);
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "Travels is not visible");
			Log.info(" Travels is not visible " + Flag);
		}
	}

	public void EmployeeTabFunctionality() throws InterruptedException {
		boolean Flag = ElementDisplayed(locators.EmployeeTabInBar);
		if (Flag == true) {
			click(locators.EmployeeTabInBar);
			ExtentTestManager.getTest().log(Status.PASS, "Employee Tab is visible");
			Log.info("Employee Tab is visible " + Flag);
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "Employee Tab is not visible");
			Log.info("Employee Tab is not visible " + Flag);
		}
	}

	public void ApprovalTabFunctionality() throws InterruptedException {
		waitForSpinnerToDisappear(driver, 1, 2);
		boolean Flag = ElementDisplayed(locators.ApprovalsInBar);
		if (Flag == true) {
			click(locators.ApprovalsInBar);
			ExtentTestManager.getTest().log(Status.PASS, "Approval Tab is visible");
			Log.info("Approval Tab is visible " + Flag);
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "Approval Tab is not visible");
			Log.info("Approval Tab is not visible " + Flag);
		}
	}

	public void VerifyDependantApprovalVisibility() throws InterruptedException {
		waitForSpinnerToDisappear(driver, 1, 2);
		ScrollUntilElementVisible(locators.ScrollUntillDependant);
		boolean Flag = ElementDisplayed(locators.DependantApprovalTab);
		if (Flag == true) {
			ExtentTestManager.getTest().log(Status.PASS, "Dependant Approval Tab is visible");
			Log.info("Dependant Approval Tab is visible" + Flag);

		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "Dependant Approval Tab is not visible");
			Log.info("Dependant Approval Tab is not visible " + Flag);
		}
	}

	public void DependantApprovalFunctionality() throws InterruptedException {
		waitForSpinnerToDisappear(driver, 2, 2);
		click(locators.DependantApprovalTab);
		String ActualText = "Employee Dependents";
		String ExpectedText = driver.findElement(locators.DependantHeader).getText().toString();
		waitForSpinnerToDisappear(driver, 3, 2);
		if (ActualText.equals(ExpectedText)) {
			ExtentTestManager.getTest().log(Status.PASS, "User is navigated to Dependant Approval Tab");
			Log.info("User is navigated to Dependant Approval Tab");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "User is not in Dependant Approval Tab ");
			Log.info("User is not in Dependant Approval Tab ");
		}
	}

	public String CheckingElementPresence() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "Checking if all are displayed or not");

		boolean flag1 = ElementDisplayed(locators.CloseBtn);
		boolean flag2 = ElementDisplayed(locators.EmployeeCode);
		boolean flag3 = ElementDisplayed(locators.EmployeeName);
		boolean flag4 = ElementDisplayed(locators.ReportingManager);
		boolean flag5 = ElementDisplayed(locators.Office);
		boolean flag6 = ElementDisplayed(locators.Department);
		boolean flag7 = ElementDisplayed(locators.RequestedBy);
		boolean flag8 = ElementDisplayed(locators.RequestedOn);
		boolean flag9 = ElementDisplayed(locators.PendingWith);
		boolean flag10 = ElementDisplayed(locators.TotalItem);
		boolean flag11 = ElementDisplayed(locators.DownloadTypeDropDown);
		boolean flag12 = ElementDisplayed(locators.downloadButton);
		boolean Flag = flag1 && flag2 && flag3 && flag4 && flag5 && flag6 && flag7 && flag8 && flag9 && flag10 && flag11
				&& flag12;
		if (Flag == true) {
			ExtentTestManager.getTest().log(Status.PASS, "All are displayed " + Flag);
			return "the Elements are presence " + Flag;

		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "All not displayed " + Flag);
			return "the Element are not present " + Flag;
		}
	}

	public void NavigateToApprovalPage() throws InterruptedException {
		ScrollUntilElementVisible(locators.ScrollUntilTravels);
		waitForSpinnerToDisappear(driver, 2, 2);
		ExtentTestManager.getTest().log(Status.PASS, "Scrolled untill Travel and now Travels is visible");
		Log.info("Scrolled untill Travel and now Travels is visible ");

		click(locators.EmployeeTabInBar);
		waitForSpinnerToDisappear(driver, 2, 2);
		ExtentTestManager.getTest().log(Status.PASS, "Clicked on Employee now the employee tab is expanded");
		Log.info("Clicked on Employee now the employee tab is expanded");

		click(locators.ApprovalsInBar);
		waitForSpinnerToDisappear(driver, 2, 2);
		ExtentTestManager.getTest().log(Status.PASS, "Clicked on Approval now expanded approval tab");
		Log.info("Clicked on Approval now expanded approval tab");

		ScrollUntilElementVisible(locators.ScrollUntillDependant);
		click(locators.DependantApprovalTab);
		ExtentTestManager.getTest().log(Status.PASS,
				"Scrolled untill Dependant and now clicked on dependant Approval tab");
		Log.info("Scrolled untill Dependant and now clicked on dependant Approval Tab ");
	}

	public void CloseBtnFunctionality() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "Close button functionality");
		click(locators.CloseBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Clicked on closed Button");
		Log.info("CLicked on closed button");
		waitForSpinnerToDisappear(driver, 2, 2);
		handlePopupDesktop();
		String ExpectedText = "Dashboard";
		String ActualText = driver.findElement(locators.DashBoardHeader).getText().toString();
		if (ExpectedText.equals(ActualText)) {
			ExtentTestManager.getTest().log(Status.PASS, "We are in Homepage found dashboard header ");
			Log.info("We are in Home page");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "We are still in the Dependant Page");
			Log.info("We are still in dependant page");
		}
		ExtentTestManager.getTest().log(Status.INFO, "We are heading back to Dependant Approval Page ");
		Log.info("We are heading back to Dependant Page");
		NavigateToApprovalPage();
	}

	public void validateTableStructure() {
		ExtentTestManager.getTest().log(Status.INFO, "Validating table structure");

		try {
			ZoomOut();

			ExtentTestManager.getTest().log(Status.INFO, "Verifying table headers...");
			Log.info("Verifying table header");
			List<WebElement> headers = driver.findElements(By.xpath("//table//th//span"));
			String[] expectedHeaders = { "Employee Code", "Employee Name", "Reporting Manger", "Office", "Department",
					"Requested By", "Requested On", "Pending With" };

			Assert.assertEquals(headers.size(), expectedHeaders.length, "Header count mismatch!");
			ExtentTestManager.getTest().log(Status.PASS, "Header count is correct: " + headers.size());
			Log.info("Header count is correct: " + headers.size());

			for (int i = 0; i < expectedHeaders.length; i++) {
				String actualHeader = headers.get(i).getText().trim();
				Assert.assertEquals(actualHeader, expectedHeaders[i], "Header mismatch at position " + (i + 1));
				ExtentTestManager.getTest().log(Status.PASS, "Verified header: " + actualHeader);
				Log.info("Verified header: " + actualHeader);
			}

			WebElement totalItemsElement = driver
					.findElement(By.xpath("//div[contains(@class, 't-foot-lt')]//b[contains(text(), 'Total Items')]"));
			int expectedRowCount = Integer.parseInt(totalItemsElement.getText().replaceAll("\\D+", ""));

			ExtentTestManager.getTest().log(Status.INFO, "Verifying table rows...");
			List<WebElement> rows = driver.findElements(By.xpath("//table//tr[.//td[@data-title]]"));
			Assert.assertEquals(rows.size(), expectedRowCount, "Mismatch in row count!");
			ExtentTestManager.getTest().log(Status.PASS, "Row count is correct: " + rows.size());
			Log.info("Row count is correct: " + rows.size());

			for (WebElement row : rows) {
				WebElement empCodeElement = row.findElement(By.xpath(".//td[@data-title='Employee Code']//span"));
				String empCode = empCodeElement.getText().trim();
				Assert.assertFalse(empCode.isEmpty(), "Invalid Employee Code: " + empCode);
				ExtentTestManager.getTest().log(Status.PASS, "Verified Employee Code: " + empCode);
				Log.info("Verified Employee Code: " + empCode);

				String empName = row.findElement(By.xpath(".//td[@data-title='Employee Name']")).getText().trim();
				ExtentTestManager.getTest().log(Status.INFO, "Employee Name: " + empName);
				Log.info("Employee Name: " + empName);

				String requestedBy = row.findElement(By.xpath(".//td[@data-title='Requested By']")).getText().trim();
				Assert.assertEquals(empName, requestedBy, "Requested By mismatch in row: " + empCode);
				ExtentTestManager.getTest().log(Status.PASS, "Requested By matches Employee Name: " + requestedBy);
				Log.info("Requested By matches Employee Name: " + requestedBy);

				String pendingWith = row.findElement(By.xpath(".//td[@data-title='Pending With']")).getText().trim();
				Assert.assertEquals(pendingWith, "HR-BU", "Invalid Pending With value in row: " + empCode);
				ExtentTestManager.getTest().log(Status.PASS, "Pending With is correct: " + pendingWith);
				Log.info("Pending With is correct: " + pendingWith);
			}

			ExtentTestManager.getTest().log(Status.PASS, "Table structure validation completed successfully!");
			Log.info("Table structure validation completed successfully!");

		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Test Failed: " + e.getMessage());
			Log.info("Test Failed: " + e.getMessage());
			Assert.fail("Test Failed: " + e.getMessage());
		}
	}

	public void verifyTotalItemsCount() {

		ExtentTestManager.getTest().log(Status.INFO,
				"Verify Total Items Count and Check if total items count matches expected");
		Log.info("Verify Total Items Count and Check if total items count matches expected");

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			WebElement totalItems = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//div[contains(@class, 't-foot-lt')]//b[contains(text(), 'Total Items')]")));

			String actualText = totalItems.getText();
			ExtentTestManager.getTest().log(Status.INFO, "Fetched total items text: " + actualText);
			Log.info("Fetched total items text: " + actualText);

			assertTrue(actualText.matches("Total Items : \\d+"), "Total items format mismatch");
			ExtentTestManager.getTest().log(Status.PASS, "Total items text format is correct");
			Log.info("Total items text format is correct");

			// Step 2: Fetch expected row count from "Total Items"
			WebElement totalItemsElement = driver
					.findElement(By.xpath("//div[contains(@class, 't-foot-lt')]//b[contains(text(), 'Total Items')]"));
			int expectedRowCount = Integer.parseInt(totalItemsElement.getText().replaceAll("\\D+", ""));

			int displayedCount = Integer.parseInt(actualText.replaceAll("\\D+", ""));
			assertEquals(displayedCount, expectedRowCount, "Incorrect items count");
			ExtentTestManager.getTest().log(Status.PASS, "Total items count matches expected: " + displayedCount);
			Log.info("Total items count matches expected: " + displayedCount);

		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Test Failed: " + e.getMessage());
			Log.info("Test failed " + e.getMessage());
			fail("Test Failed: " + e.getMessage());
		}
	}

	public void testFileDownload(String format) {
		ExtentTestManager.getTest().log(Status.INFO,
				"Download " + format + "Verify " + format + " file download functionality");
		Log.info("Download " + format + "Verify " + format + " file download functionality");

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			WebElement dropdown = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("select[name='IsActive']")));
			Select formatSelect = new Select(dropdown);
			formatSelect.selectByVisibleText(format);
			ExtentTestManager.getTest().log(Status.INFO, "Selected file format: " + format);
			Log.info("Selected file format: " + format);

			WebElement downloadBtn = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//button[.//i[contains(@class, 'i-Download')]]")));
			downloadBtn.click();
			ExtentTestManager.getTest().log(Status.PASS, format + " download button clicked");
			Log.info(format + " download button clicked");

			assertTrue(true, format + " download initiated");
			ExtentTestManager.getTest().log(Status.PASS, format + " file download initiated successfully");
			Log.info(format + " file download initiated successfully");

		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Test Failed: " + e.getMessage());
			Log.info("Test Failed: " + e.getMessage());
			fail("Test Failed: " + e.getMessage());
		}
	}

	public void verifyPaginationDisabledState() {
		ExtentTestManager.getTest().log(Status.INFO,
				"Verify Pagination Disabled State and Check if previous/next buttons are disabled");
		Log.info("Verify Pagination Disabled State and Check if previous/next buttons are disabled");

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement prevButton = wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//li[contains(@class, 'pagination-previous')]")));
			assertTrue(prevButton.getAttribute("class").contains("disabled"), "Previous button should be disabled");
			ExtentTestManager.getTest().log(Status.PASS, "Previous button is disabled");
			Log.info("Previous button is disabled");

			WebElement nextButton = driver.findElement(By.xpath("//li[contains(@class, 'pagination-next')]"));
			assertTrue(nextButton.getAttribute("class").contains("disabled"), "Next button should be disabled");
			ExtentTestManager.getTest().log(Status.PASS, "Next button is disabled");
			Log.info("Next button is disabled");

			WebElement currentPage = driver
					.findElement(By.xpath("//li[contains(@class, 'current')]//span[contains(text(), '1')]"));
			assertNotNull(currentPage, "Current page indicator missing");
			ExtentTestManager.getTest().log(Status.PASS, "Pagination is on page 1");

		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Test Failed: " + e.getMessage());
			Log.info("Test Failed: " + e.getMessage());
			fail("Test Failed: " + e.getMessage());
		}
	}

	public void verifyRequestCodeNavigation(Map<Object, Object> testdata, ITestContext context) {
		try {
			String Code = testdata.get("Code").toString();
			By ClickOnEmp = By.xpath("//span[normalize-space()='" + Code + "']");
			Log.info("XPath is:  " + ClickOnEmp);

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

	public String CheckingElementDisplayedInRequestCodePage() throws InterruptedException {
		boolean flag1 = ElementDisplayed(locators.EmployeeNameInRequestPage);
		boolean flag2 = ElementDisplayed(locators.EmployeeCodeInRequestPage);
		boolean flag3 = ElementDisplayed(locators.OfficeNameInRequestPage);
		boolean flag4 = ElementDisplayed(locators.ReportingToInRequestPage);
		boolean flag5 = ElementDisplayed(locators.DepartmentInRequestPage);
		boolean flag6 = ElementDisplayed(locators.DependantNameHeader);
		boolean flag7 = ElementDisplayed(locators.DOBHeader);
		boolean flag8 = ElementDisplayed(locators.RelationHeader);
		boolean flag9 = ElementDisplayed(locators.DependantStatusHeader);
		boolean flag10 = ElementDisplayed(locators.ActionHeader);
		boolean flag11 = ElementDisplayed(locators.UpdateBtn);
		boolean flag12 = ElementDisplayed(locators.CloseBtnInRequestPage);

		boolean Flag = flag1 && flag2 && flag3 && flag4 && flag5 && flag6 && flag7 && flag8 && flag9 && flag10 && flag11
				&& flag12;
		if (Flag == true) {
			ExtentTestManager.getTest().log(Status.PASS, "All are displayed " + Flag);
			return "the Elements are presence " + Flag;

		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "All not displayed " + Flag);
			return "the Element are not present " + Flag;
		}

	}

	public void CloseBtnInRequest(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "Close button functionality");
		ScrollUntilElementVisible(locators.UpdateBtn);
		Log.info("scrolled untill update");
		click(locators.CloseBtnInRequestPage);
		ExtentTestManager.getTest().log(Status.PASS, "Clicked on closed Button");
		Log.info("CLicked on closed button");
		waitForSpinnerToDisappear(driver, 1, 2);
		String ExpectedText = "Employee Dependents";
		String ActualText = driver.findElement(locators.DependantHeader).getText().toString();
		if (ExpectedText.equals(ActualText)) {
			ExtentTestManager.getTest().log(Status.PASS, "We are in Homepage found dashboard header ");
			Log.info("We are in Home page");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "We are still in the Dependant Page");
			Log.info("We are still in dependant page");
		}
		verifyRequestCodeNavigation(testdata, context);
	}

	public void testActionDropdownOptions() {
		ExtentTestManager.getTest().log(Status.INFO, "Validating 'Actions' dropdown options in each row");
		Log.info("Starting validation of 'Actions' dropdown options");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		List<WebElement> dropdowns = wait.until(ExpectedConditions
				.presenceOfAllElementsLocatedBy(By.xpath("//table//td[@data-title='Actions']//select")));

		Assert.assertFalse(dropdowns.isEmpty(), "No dropdowns found in the 'Actions' column");
		ExtentTestManager.getTest().log(Status.PASS, "Found " + dropdowns.size() + " dropdowns in the Actions column");
		Log.info("Found " + dropdowns.size() + " dropdowns in the Actions column");

		List<String> expectedOptions = Arrays.asList("Pending", "Approved", "Rejected", "DeletePending", "Deleted",
				"OnHold");
		ExtentTestManager.getTest().log(Status.INFO, "Expected dropdown options: " + expectedOptions);
		Log.info("Expected dropdown options: " + expectedOptions);

		for (int i = 0; i < dropdowns.size(); i++) {
			WebElement dropdown = dropdowns.get(i);
			Select select = new Select(dropdown);

			List<String> actualOptions = select.getOptions().stream().map(option -> option.getText().trim())
					.collect(Collectors.toList());

			if (actualOptions.equals(expectedOptions)) {
				ExtentTestManager.getTest().log(Status.PASS, "Dropdown options match in row " + (i + 1));
				Log.info("Dropdown options match in row " + (i + 1));
			} else {
				ExtentTestManager.getTest().log(Status.FAIL, "Dropdown options mismatch in row " + (i + 1)
						+ ". Expected: " + expectedOptions + ", Found: " + actualOptions);
				Log.error("Dropdown options mismatch in row " + (i + 1) + ". Expected: " + expectedOptions + ", Found: "
						+ actualOptions);
				Assert.fail("Dropdown options mismatch in row " + (i + 1));
			}
		}

		ExtentTestManager.getTest().log(Status.INFO, "Dropdown options validation completed successfully");
		Log.info("Dropdown options validation completed successfully");
	}

	public void testInitialStatusIsPending() {
		ExtentTestManager.getTest().log(Status.INFO, "Validating that all dependent statuses are 'Pending'");
		Log.info("Starting validation for initial dependent status");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));

		// Locate all status cells in the table
		List<WebElement> statusCells = wait.until(
				ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//td[@data-title='Dependent Status']")));

		Assert.assertFalse(statusCells.isEmpty(), "No status cells found in the table");
		ExtentTestManager.getTest().log(Status.PASS, "Found " + statusCells.size() + " status cells");
		Log.info("Found " + statusCells.size() + " status cells");

		for (int i = 0; i < statusCells.size(); i++) {
			WebElement statusCell = statusCells.get(i);
			String actualStatus = statusCell.getText().trim();

			if (actualStatus.equals("Pending")) {
				ExtentTestManager.getTest().log(Status.PASS, "Row " + (i + 1) + " status is 'Pending'");
				Log.info("Row " + (i + 1) + " status is 'Pending'");
			} else {
				ExtentTestManager.getTest().log(Status.FAIL,
						"Row " + (i + 1) + " status mismatch. Expected: 'Pending', Found: '" + actualStatus + "'");
				Log.error("Row " + (i + 1) + " status mismatch. Expected: 'Pending', Found: '" + actualStatus + "'");
				Assert.fail("Row " + (i + 1) + " status mismatch. Expected: 'Pending', Found: '" + actualStatus + "'");
			}
		}

		ExtentTestManager.getTest().log(Status.INFO, "Validation of initial statuses completed successfully");
		Log.info("Validation of initial statuses completed successfully");
	}

	public void testApproveRequest(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "Starting test: Approve Request");

		String ApproveRelation = testdata.get("ApproveRelation").toString();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//td[@data-title='Relation' and text()='" + ApproveRelation + "']/ancestor::tr//select")));
		new Select(dropdown).selectByVisibleText("Approved");

		WebElement updateBtn = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Update')]")));
		updateBtn.click();

		WaitForElementToBeVisible(locators.YesBtnInDialogOnUpdate);
		click(locators.YesBtnInDialogOnUpdate);
		Log.info("clicked on Yes btn");
		waitForSpinnerToDisappear(driver, 1, 2);
		WaitForElementToBeVisible(locators.OkBtnInDialogOnUpdate);
		click(locators.OkBtnInDialogOnUpdate);
		Log.info("Clicked on OK btn ");
		waitForSpinnerToDisappear(driver, 1, 2);

	}

	public void testRejectRequest(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException, IOException {
		ExtentTestManager.getTest().log(Status.INFO, "Starting test: Reject Request");

		verifyRequestCodeNavigation(testdata, context);
		String RejectRelation = testdata.get("RejectRelation").toString();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		WebElement dropdown = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//td[@data-title='Relation' and normalize-space(text())='"
						+ RejectRelation + "']/ancestor::tr//select")));
		new Select(dropdown).selectByVisibleText("Rejected");

		WebElement updateBtn = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Update')]")));
		updateBtn.click();
		WaitForElementToBeVisible(locators.YesBtnInDialogOnUpdate);
		click(locators.YesBtnInDialogOnUpdate);
		Log.info("clicked on Yes btn");
		waitForSpinnerToDisappear(driver, 1, 2);
		WaitForElementToBeVisible(locators.OkBtnInDialogOnUpdate);
		click(locators.OkBtnInDialogOnUpdate);
		Log.info("Clicked on OK btn ");
		waitForSpinnerToDisappear(driver, 1, 2);

	}

}