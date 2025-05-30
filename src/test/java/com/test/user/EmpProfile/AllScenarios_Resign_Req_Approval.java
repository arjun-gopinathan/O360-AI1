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
import com.Page_Locators.Locators_Resign_Req_Approval;
import com.Pages_Methods.Methods_Resign_Req_Approval;
import com.Utility.Log;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;

public class AllScenarios_Resign_Req_Approval extends Base_Class {

	Locators_Resign_Req_Approval locators;
	Methods_Resign_Req_Approval methods;
	Log log;
	com.Utility.ScreenShot screenshot;
	com.Utility.ExcelReader ExcelReader;
	ExtentTest extenttest;
	// Setup method to initialize objects and perform setup
	@BeforeSuite

	public void reference() {
		log = new Log();
		screenshot = new com.Utility.ScreenShot(driver);
		ExcelReader = new com.Utility.ExcelReader("ResignRequestApproval");
		methods = new Methods_Resign_Req_Approval();
	}
	@BeforeMethod
	public void setupTest(Method method) {
	    // Get the test class name
	    String className = method.getDeclaringClass().getSimpleName();
	    
	    // Get the full package name of the test class
	    String packageName = method.getDeclaringClass().getPackage().getName();

	    // Extract module name from package (e.g., com.test.LeaveModule -> LeaveModule)
	    String[] packageParts = packageName.split("\\.");
	    String moduleName = packageParts[packageParts.length - 1]; // Last part of package is module

	    // Start the test and assign category dynamically
	    extenttest = ExtentTestManager.startTest(method.getName())
	                 .assignCategory(moduleName); // Example: "LeaveModule"
	}
	@Test(dataProvider = "TestData")
	public void runAlllScenarios(Map<Object, Object> testdata, ITestContext context)
			throws IOException, InterruptedException {
		try {
			if (testdata.get("Run").toString().equalsIgnoreCase("Yes")) {
				ExtentTestManager.startTest(testdata.get("TestScenario").toString());
				Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");
				context.setAttribute("fileName", "Login");
				String Username = testdata.get("LoginName").toString();

				Log.info("TEST CASE 1 Started");
				ExtentTestManager.startTest("TC- 1 Application Logged in successfull");
				SetUp(Username);
				ExtentTestManager.getTest().log(Status.PASS, "Application setup successfull");
				ExtentTestManager.endTest();

				Log.info("TEST CASE 2 Started");
				ExtentTestManager.startTest("TC- 2  Handling Covid Popup");
				handlePopupCovid();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 3 Started");
				ExtentTestManager.startTest("TC- 3 Handling Desktop Popup");
				handlePopupDesktop();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 4 Started");
				ExtentTestManager.startTest("TC- 4 Valid Login");
				verifySuccessfulLogin();
				validateDashBoard();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 5 Started");
				ExtentTestManager.startTest("TC - 05 - Fetching Approval details for emp " + Username);
				methods.superUser(testdata, context);
				ExtentTestManager.endTest();

				Log.info("TEST CASE 6 Started");
				ExtentTestManager
						.startTest("TC - 06 - Validating Employee Tab  and Navigating to Employee Resign page ");
				methods.isEmpTab();
				methods.ValidateEmpTabisExpanded();
				methods.isEmployeeSepVisibleInApprovals();
				methods.validateToEmpSeparation();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 7 Started");
				ExtentTestManager.startTest("TC - 07 -- Page Element Verification ");
				methods.testUIElementPresence();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 8 Started");
				ExtentTestManager.startTest("TC - 08 -- Search Option Functionality");
				methods.SearchBtnFunctionality(testdata, context);
				ExtentTestManager.endTest();

				Log.info("TEST CASE 9 Started");
				ExtentTestManager.startTest("TC - 09 -- Approve button functionality ");
				methods.ApprovalBtnFUnctionality();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 10 Started");
				ExtentTestManager.startTest("TC -10 -- OverRide button functionality ");
				methods.OverRideBtnFunctionality();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 11 Started");
				ExtentTestManager.startTest("TC - 11 -- Close button functionality ");
				methods.closeBtnFunctionality();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 12 Started");
				ExtentTestManager.startTest("TC - 12 -- Navigate to Request Page via Code No ");
				methods.NavigateToEmpReqUsingCode(testdata, context);
				ExtentTestManager.endTest();

				Log.info("TEST CASE 13 Started");
				ExtentTestManager.startTest("TC - 13 -- Checking if page all elements or not ");
				Log.info("The result of this is " + methods.UiPresenceOfElementInCodePage());
				ExtentTestManager.endTest();

				Log.info("TEST CASE 14 Started");
				ExtentTestManager.startTest("TC - 14 -- Rejecting request from manager's level  ");
				methods.RequestReject();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 15 Started");
				ExtentTestManager.startTest("TC - 15 -- Create a new request ");
				methods.CreateRequest(testdata, context);
				ExtentTestManager.endTest();

				Log.info("TEST CASE 16 Started");
				ExtentTestManager.startTest("TC - 16 -- Withdraw request from manager's level ");
				methods.SignInManager();
				methods.RequestWithdraw(testdata, context);
				ExtentTestManager.endTest();

				Log.info("TEST CASE 17 Started");
				ExtentTestManager.startTest("TC - 17 -- Create a new request ");
				methods.CreateRequest(testdata, context);
				ExtentTestManager.endTest();

				Log.info("TEST CASE 18 Started");
				ExtentTestManager.startTest("TC - 18 -- Approve request from manager's level ");
				methods.SignInManager();
				methods.RequestApprove(testdata, context);
				ExtentTestManager.endTest();

				Log.info("TEST CASE 19 Started");
				ExtentTestManager.startTest("TC - 19 -- Reject request from HR's 1  level ");
				methods.SignInHR1();
				methods.NaviageteToResignPage(testdata, context);
				methods.RequestReject();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 20 Started");
				ExtentTestManager.startTest("TC - 20 --   Create a new request ");
				methods.CreateRequest(testdata, context);
				ExtentTestManager.endTest();

				Log.info("TEST CASE 21 Started");
				ExtentTestManager.startTest("TC - 21-- Approve request from  HR's 1  level ");
				methods.SignInManager();
				methods.RequestApprove(testdata, context);
				ExtentTestManager.endTest();

				Log.info("TEST CASE 22 Started");
				ExtentTestManager.startTest("TC - 22 -- Withdraw request from HR's 1 level ");
				methods.SignInHR1();
				methods.RequestWithdraw(testdata, context);
				ExtentTestManager.endTest();

				Log.info("TEST CASE 23 Started");
				ExtentTestManager.startTest("TC - 23 --  Create a new request  ");
				methods.CreateRequest(testdata, context);
				ExtentTestManager.endTest();

				Log.info("TEST CASE 24 Started");
				ExtentTestManager.startTest("TC - 24 -- Request Approve from manager level ");
				methods.SignInManager();
				methods.RequestApprove(testdata, context);
				ExtentTestManager.endTest();

				Log.info("TEST CASE 25 Started");
				ExtentTestManager.startTest("TC - 25 -- Reuest Approve from HR's 1 level ");
				methods.SignInHR1();
				methods.RequestApprove(testdata, context);
				ExtentTestManager.endTest();

				Log.info("TEST CASE 26 Started");
				ExtentTestManager.startTest("TC - 26 -- Reject request from HR's 2 level ");
				methods.SignInHR2();
				methods.NaviageteToResignPage(testdata, context);
				methods.RequestReject();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 27 Started");
				ExtentTestManager.startTest("TC - 27 --  Create a new request");
				methods.CreateRequest(testdata, context);
				ExtentTestManager.endTest();

				Log.info("TEST CASE 28 Started");
				ExtentTestManager.startTest("TC - 28 --Request Approve from Manager level ");
				methods.SignInManager();
				methods.RequestApprove(testdata, context);
				ExtentTestManager.endTest();

				Log.info("TEST CASE 29 Started");
				ExtentTestManager.startTest("TC - 29 -- Request Approve from HR's 1 level ");
				methods.SignInHR1();
				methods.RequestApprove(testdata, context);
				ExtentTestManager.endTest();

				Log.info("TEST CASE 30 Started");
				ExtentTestManager.startTest("TC - 30 -- Withdraw request from HR's 2 level ");
				methods.SignInHR2();
				methods.RequestWithdraw(testdata, context);
				ExtentTestManager.endTest();

				Log.info("TEST CASE 31 Started");
				ExtentTestManager.startTest("TC - 31 --  Create a new request ");
				methods.CreateRequest(testdata, context);
				ExtentTestManager.endTest();

				Log.info("TEST CASE 32 Started");
				ExtentTestManager.startTest("TC - 32 -- Request Approve from Manager level ");
				methods.SignInManager();
				methods.RequestApprove(testdata, context);
				ExtentTestManager.endTest();

				Log.info("TEST CASE 33 Started");
				ExtentTestManager.startTest("TC - 33 --Request Approve from HR's 1  level ");
				methods.SignInHR1();
				methods.RequestApprove(testdata, context);
				ExtentTestManager.endTest();

				Log.info("TEST CASE 34 Started");
				ExtentTestManager.startTest("TC - 34 -- Request Approve from HR's 2 level ");
				methods.SignInHR2();
				methods.RequestApprove(testdata, context);
				ExtentTestManager.endTest();

				Log.info("Test Case 35 started");
				ExtentTestManager.startTest(" Logout the Credentials ");
				// Signout();
				ExtentTestManager.getTest().log(Status.PASS, " Logout the Credentials ");
				System.out.println(("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***"));
				ExtentTestManager.endTest();

				ExtentManager.createInstance().flush();
				Log.info("*** Test Suite completed successfully ***");
				ExtentTestManager.getTest().log(Status.PASS, "Browser closed as test excution passed ");
				Log.info("Browser closed as test excution passed ");
				// driver.quit();
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
			// driver.quit();
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
