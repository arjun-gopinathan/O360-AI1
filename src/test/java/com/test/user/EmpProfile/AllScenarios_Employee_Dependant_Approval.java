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
import com.Page_Locators.Locators_Employee_Dependant_Approval;
import com.Pages_Methods.Methods_Employee_Dependant_Approval;
import com.Utility.Log;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;

public class AllScenarios_Employee_Dependant_Approval extends Base_Class {
	Locators_Employee_Dependant_Approval locators;
	Methods_Employee_Dependant_Approval methods;
	Log log;
	com.Utility.ScreenShot screenshot;
	com.Utility.ExcelReader ExcelReader;
	ExtentTest extenttest;
	@BeforeSuite

	public void reference() {
		log = new Log();
		screenshot = new com.Utility.ScreenShot(driver);
		ExcelReader = new com.Utility.ExcelReader("EmployeeDependantApproval");
		methods = new Methods_Employee_Dependant_Approval();
		locators = new Locators_Employee_Dependant_Approval();
	}
	@BeforeMethod
	public void setupTest(Method method) throws Exception {
		// Start a new ExtentTest for the current test method
		extenttest = ExtentTestManager.startTest(method.getName()).assignCategory("Employee Dependant Approval");		
	}
	@Test(dataProvider = "TestData")
	public void runAlllScenarios(Map<Object, Object> testdata, ITestContext context)
			throws IOException, InterruptedException {
		try {
			if (testdata.get("Run").toString().equalsIgnoreCase("Yes")) {
				ExtentTestManager.startTest(testdata.get("TestScenario").toString());
				Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");
				context.setAttribute("fileName", "Login");
				String LoginName = testdata.get("LoginName").toString();

				Log.info("TEST CASE 01 Started");
				ExtentTestManager.startTest("TC- 01 Application Logged in successfull");
				SetUp(LoginName);
				ExtentTestManager.getTest().log(Status.PASS, "Application setup successfull");
				ExtentTestManager.endTest();

				Log.info("TEST CASE 02 Started");
				ExtentTestManager.startTest("TC- 02  Handling Covid Popup");
				handlePopupCovid();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 03 Started");
				ExtentTestManager.startTest("TC- 03 Handling Desktop Popup");
				handlePopupDesktop();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 04 Started");
				ExtentTestManager.startTest("TC- 04 Valid Login");
				verifySuccessfulLogin();
				validateDashBoard();
				methods.LoginFunctionalityValidation();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 05 Started");
				ExtentTestManager.startTest("TC- 05 Verify visibility of travels ");
				methods.VerifyVisiblityOfTravel();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 06 Started");
				ExtentTestManager.startTest("TC- 06 Verify Employee Functionality ");
				methods.EmployeeTabFunctionality();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 07 Started");
				ExtentTestManager.startTest("TC- 07 Verify Approval Functionality ");
				methods.ApprovalTabFunctionality();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 08 Started");
				ExtentTestManager.startTest("TC- 08 Verify Dependant Approval Visibility ");
				methods.VerifyDependantApprovalVisibility();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 09 Started");
				ExtentTestManager.startTest("TC- 09 Dependant Approval Functionality ");
				methods.DependantApprovalFunctionality();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 10 Started");
				ExtentTestManager.startTest("TC- 10 Verfiying All elements are visible in page or not ");
				Log.info("Result : " + methods.CheckingElementPresence());
				ExtentTestManager.endTest();

				Log.info("TEST CASE 11 Started");
				ExtentTestManager.startTest("TC- 11 Verifying Close Button Functionality");
				methods.CloseBtnFunctionality();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 12 Started");
				ExtentTestManager.startTest(
						"Tc- 12 Verifying Total Items Count and Check if total items count matches expected");
				methods.verifyTotalItemsCount();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 13 Started");
				ExtentTestManager.startTest("Tc- 13 Download Excel Verify and Excel file download functionality");
				methods.testFileDownload("Excel");
				ExtentTestManager.endTest();

				Log.info("TEST CASE 14 Started");
				ExtentTestManager.startTest("Tc- 14 Download CSV Verify and CSV file download functionality");
				methods.testFileDownload("CSV");
				ExtentTestManager.endTest();

				Log.info("TEST CASE 15 Started");
				ExtentTestManager.startTest(
						"Tc- 15 Verify Pagination Disabled State Check if previous/next buttons are disabled");
				methods.verifyPaginationDisabledState();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 16 Started");
				ExtentTestManager.startTest("Tc- 16 Verifying whether got into RequestCOde Page");
				methods.verifyRequestCodeNavigation(testdata, context);
				ExtentTestManager.endTest();

				Log.info("TEST CASE 17 Started");
				ExtentTestManager.startTest("Tc- 17 Checking if All Element are displayed");
				Log.info("Result : " + methods.CheckingElementDisplayedInRequestCodePage());
				ExtentTestManager.endTest();

				Log.info("TEST CASE 18 Started");
				ExtentTestManager.startTest("Tc- 18 Checking if all elements are disabled and is having value");
				methods.CloseBtnInRequest(testdata, context);
				ExtentTestManager.endTest();

				Log.info("TEST CASE 19 Started");
				ExtentTestManager.startTest("Tc- 19 Action Dropdown Options ");
				methods.testActionDropdownOptions();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 20 Started");
				ExtentTestManager.startTest("Tc- 20 Check the intial status pending or not ");
				methods.testInitialStatusIsPending();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 21 Started");
				ExtentTestManager.startTest("Tc- 21 Approve Request ");
				methods.testApproveRequest(testdata, context);
				ExtentTestManager.endTest();

				Log.info("TEST CASE 22 Started");
				ExtentTestManager.startTest("Tc- 22 Reject Request ");
				methods.testRejectRequest(testdata, context);
				ExtentTestManager.endTest();

				ExtentTestManager.startTest("Logout");
				Signout();
				ExtentTestManager.getTest().log(Status.PASS, " Logout the Credentials ");
				System.out.println(("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***"));
				Log.info("Logout Successfully after test script is being passed");
				ExtentTestManager.endTest();

				ExtentManager.createInstance().flush();
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
				System.out.println("File not found " + e1.getMessage());
			}
			ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");

			// Logout
			context.setAttribute("fileName", "Logout");
			// driver.quit();
			ExtentTestManager.getTest().log(Status.FAIL, "Application Logout");
			Log.info("Logout is done");

			// EndTest
			System.out.println(("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***"));
			ExtentTestManager.endTest();
			ExtentManager.createInstance().flush();
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
				System.out.println("File not found " + e1.getMessage());
			}
			ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");

			// Logout
			context.setAttribute("fileName", "Logout");
			// driver.quit();
			ExtentTestManager.getTest().log(Status.FAIL, "Application Logout");
			Log.info("Logout is done as testscript is failed");

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
