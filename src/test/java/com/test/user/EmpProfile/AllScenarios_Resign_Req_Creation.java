package com.test.user.EmpProfile;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
import com.Page_Locators.Locators_Approve_Process;
import com.Page_Locators.Locators_Resign_Req_Creation;
import com.Pages_Methods.Methods_Approver_EmpProfile;
import com.Pages_Methods.Methods_EmpProfile;
import com.Pages_Methods.Methods_Resign_Req_Creation;
import com.Utility.Log;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;

public class AllScenarios_Resign_Req_Creation extends Base_Class {
	Locators_Approve_Process loc1;
	Methods_Approver_EmpProfile m1;
	Locators_Resign_Req_Creation locators;
	Methods_Resign_Req_Creation methods = new Methods_Resign_Req_Creation();
	Log log;
	com.Utility.ScreenShot screenshot;
	Methods_EmpProfile m2;
	com.Utility.ExcelReader ExcelReader;
	ExtentTest extenttest;
	// Setup method to initialize objects and perform setup
	@BeforeSuite

	public void reference() {
		loc1 = new Locators_Approve_Process();
		m1 = new Methods_Approver_EmpProfile();
		log = new Log();
		screenshot = new com.Utility.ScreenShot(driver);
		ExcelReader = new com.Utility.ExcelReader("EmpResignPage");
	}
	@BeforeMethod
	public void setupTest(Method method) throws Exception {
		// Start a new ExtentTest for the current test method
		extenttest = ExtentTestManager.startTest(method.getName()).assignCategory("Resign Req Creation");		
	}
	@Test(dataProvider = "TestData")
	public void runAlllScenarios(Map<Object, Object> testdata, ITestContext context)
			throws IOException, InterruptedException {
		try {
			if (testdata.get("Run").toString().equalsIgnoreCase("Yes")) {
				ExtentTestManager.startTest(testdata.get("TestScenario").toString());
				Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");
				context.setAttribute("fileName", "Login");
				String Username = testdata.get("LoginName").toString(); // Emp Name
				SetUp(Username);
				ExtentTestManager.getTest().log(Status.PASS, "Application setup successfull");
				handlePopupCovid();
				handlePopupDesktop();

				Log.info("TEST CASE 1 Started");
				ExtentTestManager.startTest("TC- 1 Validating dashboad is displayed or not");
				verifySuccessfulLogin();
				validateDashBoard();
				methods.LoginFunctionalityValidation();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 2 Started");
				ExtentTestManager.startTest("TC- 2 Verifying Self Service Functionality Access");
				methods.validatingSelfService();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 3 Started");
				ExtentTestManager.startTest("TC- 3 Verifying Self Service Menu Expansion");
				methods.ValidatedElementOfSelfService();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 4 Started");
				ExtentTestManager.startTest("TC- 4 Navigate to Request from Self Service");
				methods.ValidatingRequest();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 5 Started");
				ExtentTestManager.startTest("TC- 5 Check if Employee submitted resignation");
				methods.checkIfEmpResigned(Username, testdata, context);
				ExtentTestManager.endTest();

				Log.info("TEST CASE 6 Started");
				ExtentTestManager
						.startTest("TC- 6 Verify Redirection to Separation Page and all UI are displayed or not");
				methods.ValidateEmpSeparationPage();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 7 Started");
				ExtentTestManager.startTest("TC- 7 Verify Close Button Functionality");
				methods.validateCloseBtn();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 8 Started");
				ExtentTestManager
						.startTest("TC- 8 Verify Edit Type is Autofill and Editing Restrictions for Exit Type");
				methods.validateExitTypeSelectBox();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 9 Started");
				ExtentTestManager.startTest(
						"TC- 9 Verify Request Date is Autofill and " + "Editing Restrictions for Request Date");
				methods.validateRequestDateInputBox();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 10 Started");
				ExtentTestManager.startTest(
						"TC- 10 Verify Preferred Relieving Date is Autofill " + "and Editable for Preferred Date");
				methods.validatePreferredDateInputBox();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 11 Started");
				ExtentTestManager.startTest("TC- 11 Verify Date Picker Visibility");
				methods.validateDatePicker();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 12 Started");
				ExtentTestManager.startTest("TC- 12 Verify Date Input via Keyboard");
				methods.validateKeyboardAction(testdata, context);
				ExtentTestManager.endTest();

				Log.info("TEST CASE 13 Started");
				ExtentTestManager.startTest("TC- 13 Select Past Date via Date Picker");
				methods.EnterPastDatewithDatePicker();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 14 Started");
				ExtentTestManager.startTest("TC- 14 Select Present Date via Date Picker");
				methods.EnterPresentDatewithDatePicker();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 15 Started");
				ExtentTestManager.startTest("TC- 15 Verify Incorrect Date Input Format (DD/MM/YYYY) ");
				methods.InvalidFormatDatewithDay(testdata, context);
				ExtentTestManager.endTest();

				Log.info("TEST CASE 16 Started");
				ExtentTestManager.startTest("TC- 16 Verify Incorrect Date Input Format (YYYY/MM/DD) ");
				methods.InvalidFormatDateWithYear(testdata, context);
				ExtentTestManager.endTest();

				Log.info("TEST CASE 17 Started");
				ExtentTestManager.startTest("TC- 17 Select Future Date via Date Picker");
				methods.EnterFutureDatewithDatePicker();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 18 Started");
				ExtentTestManager.startTest("TC- 18 Verify Notice Period Relieving date is Autofill and "
						+ "Editing Restrictions for Notice Period Relieving Date");
				methods.validateNoticePeriodDateInputBox();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 19 Started");
				ExtentTestManager.startTest("TC- 19 Verify Multiselection and Requirement for Reason Dropdown ");
				methods.validateReasonAsMultiselect();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 20 Started");
				ExtentTestManager.startTest("TC- 20 Search with Keyword Present in List ");
				methods.searchWithKeywordPresent(testdata, context);
				ExtentTestManager.endTest();

				Log.info("TEST CASE 21 Started");
				ExtentTestManager.startTest("TC- 21 Search with Keyword not Present in List ");
				methods.searchWithKeywordNotPresent(testdata, context);
				ExtentTestManager.endTest();

				Log.info("TEST CASE 22 Started");//
				ExtentTestManager.startTest("TC- 22 Case Sensitivity Check ");
				methods.searchWithLowerUpperCase(testdata, context);
				ExtentTestManager.endTest();

				Log.info("TEST CASE 23 Started");
				ExtentTestManager.startTest("TC- 23 Text Area Scroll Bar Functionality ");
				methods.validateScrollBarInComment();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 24 Started"); //
				ExtentTestManager.startTest("TC- 24 Text Area Undo/Redo Functionality ");
				methods.testUndoRedoFunctionality();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 25 Started"); //
				ExtentTestManager.startTest("TC- 25 Text Area Cut, Copy, Paste Operations ");
				methods.testCopyAndPaste();
				methods.testCutAndPaste();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 26 Started"); //
				ExtentTestManager.startTest("TC- 26 Entering valid text in comment box");
				methods.EnterComment();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 27 Started"); //
				ExtentTestManager.startTest("TC- 27 Verify Save Button Functionality ");
				methods.validatingSaveBtnFunctionality();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 28 Started"); //
				ExtentTestManager.startTest("TC- 28 Verify Submit Button Functionality ");
				methods.validatingSubmitBtn();
				ExtentTestManager.endTest();

				handlePopupCovid();
				handlePopupDesktop();

				ExtentTestManager.startTest(" Logout the Credentials ");
				System.out.println(("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***"));
				Signout();
				ExtentTestManager.endTest();

				ExtentManager.getInstance().flush();
				Log.info("*** Test Suite completed successfully ***");
				ExtentTestManager.getTest().log(Status.PASS, "Browser closed as test excution passed ");
				Log.info("Browser closed as test excution passed ");
				driver.quit();
			}
		} catch (Exception e) {
			System.out.println("*** Test execution " + testdata.get("TestScenario").toString() + " failed...");
			Log.error("*** Test execution " + testdata.get("TestScenario").toString() + " failed...");
			Log.error("" + e.getMessage());
			String fileName = (String) context.getAttribute("fileName");

			try {
				File file = new com.Utility.ScreenShot(driver).takeScreenShot(fileName,
						testdata.get("TestScenario").toString());
				ExtentTestManager.getTest().fail(e.getMessage(),
						MediaEntityBuilder.createScreenCaptureFromPath(file.toString()).build());
			} catch (Exception e1) {
				System.out.println("File not found " + e1);
			}
			ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");

			// Logout
			context.setAttribute("fileName", "Logout");
			driver.quit();
			ExtentTestManager.getTest().log(Status.PASS, "Application Logout");
			Log.info("Logout is done");

			// EndTest
			System.out.println(("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***"));
			ExtentTestManager.endTest();
			ExtentManager.getInstance().flush();
			Log.info("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***");
		} catch (AssertionError e) {
			System.out.println("*** Test execution " + testdata.get("TestScenario").toString() + " failed...");
			Log.error("*** Test execution " + testdata.get("TestScenario").toString() + " failed...");
			Log.error("" + e.getMessage());
			String fileName = (String) context.getAttribute("fileName");

			try {
				File file = new com.Utility.ScreenShot(driver).takeScreenShot(fileName,
						testdata.get("TestScenario").toString());
				ExtentTestManager.getTest().fail(e.getMessage(),
						MediaEntityBuilder.createScreenCaptureFromPath(file.toString()).build());
			} catch (Exception e1) {
				System.out.println("File not found " + e1);
			}
			ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");

			// Logout
			context.setAttribute("fileName", "Logout");
			driver.quit();
			ExtentTestManager.getTest().log(Status.PASS, "Application Logout");
			Log.info("Logout is done");

			// EndTest
			System.out.println(("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***"));
			ExtentTestManager.endTest();
			ExtentManager.getInstance().flush();
			Log.info("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***");
		}
	}

	@DataProvider(name = "TestData")
	public static Object[][] gettestdate() throws IOException {

		Object[][] objectarry = null;
		java.util.List<Map<String, String>> completedata = com.Utility.ExcelReader.getdata();

		objectarry = new Object[completedata.size()][1];

		for (int i = 0; i < completedata.size(); i++) {
			objectarry[i][0] = completedata.get(i);
		}
		return objectarry;
	}
}