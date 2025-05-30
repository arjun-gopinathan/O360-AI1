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
import com.Pages_Methods.Methods_Approver_EmpProfile;
import com.Utility.Log;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;

public class AllScenarios_Approve_EmployeeProfile extends Base_Class {
	Locators_Approve_Process locators;
	Methods_Approver_EmpProfile methods;
	Log log;
	com.Utility.ScreenShot screenshot;
	com.Utility.ExcelReader ExcelReader;
	ExtentTest extenttest;
	// Setup method to initialize objects and perform setup
	@BeforeSuite

	public void reference() throws InterruptedException {
		locators = new Locators_Approve_Process();
		methods = new Methods_Approver_EmpProfile();
		log = new Log();
		screenshot = new com.Utility.ScreenShot(driver);
		ExcelReader = new com.Utility.ExcelReader("EmpProfileReqApproval");
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
				String SearchName = testdata.get("EmpName").toString();
				String SearchName1 = testdata.get("EmpName1").toString();
				String Comment = testdata.get("Comment").toString();
				String Username = testdata.get("LoginName").toString();

				Log.info("tc1 ");
				ExtentTestManager.startTest("TC- 1-- Login to O360 ");
				SetUp(Username);
				ExtentTestManager.getTest().log(Status.PASS, "Application setup successfull");
				ExtentTestManager.endTest();

				Log.info("tc2 ");
				ExtentTestManager.startTest("TC- 2-- Handle Popups  ");
				handlePopupCovid();
				handlePopupDesktop();
				ExtentTestManager.endTest();

				Log.info("tc3 ");
				ExtentTestManager.startTest("TC- 3--  Validating dashboad is displayed or not");
				verifySuccessfulLogin();
				validateDashBoard();
				ExtentTestManager.endTest();

				Log.info("tc4 ");
				ExtentTestManager.startTest("TC - 4-- Verifying Dashboard Accessibility");
				validateDashBoard();
				ExtentTestManager.getTest().log(Status.PASS, "Validated dashboard element ");
				ExtentTestManager.endTest();

				Log.info("tc5 ");
				ExtentTestManager.startTest(
						"TC - 5-- Verify  Quick Approval  " + "and Profile Approval isvisible in list or not ");
				methods.isQuickApprovalDisplayed();
				methods.ValidateQuickApprove();
				ExtentTestManager.endTest();

				Log.info("tc6 ");
				ExtentTestManager.startTest("TC - 6-- Validating if Profile is visible");
				ExtentTestManager.getTest().log(Status.PASS, "Validated Quick Approvals Functionality ");
				methods.isProfileApprovalVisible();
				ExtentTestManager.endTest();

				Log.info("tc7 ");
				ExtentTestManager.startTest("TC - 7-- Verify Navigation to profile approval ");
				methods.validateToProfileApproval();
				ExtentTestManager.endTest();

				Log.info("tc8 ");
				ExtentTestManager.startTest("TC - 8 -- Verify All UI elements are present or not ");
				methods.testPresenceOfUiElements();
				ExtentTestManager.endTest();

				Log.info("tc9 ");
				ExtentTestManager.startTest("TC - 9 -- Search Button Functionality ");
				methods.SearchBtnFunctionality(SearchName);
				ExtentTestManager.endTest();

				Log.info("tc10 ");
				ExtentTestManager.startTest("TC - 10 -- Close button functionality ");
				methods.closeBtnFunctionality();
				ExtentTestManager.endTest();

				Log.info("tc11 ");
				ExtentTestManager.startTest("TC - 11 -- Employee Name Link Navigation  ");
				methods.isEmployeeDetailPageLoaded(SearchName);
				ExtentTestManager.endTest();

				Log.info("tc12 ");
				ExtentTestManager.startTest("TC - 12 -- Employee Approval page Ui Validation ");
				methods.presenceUIApproval();
				ExtentTestManager.endTest();

				Log.info("tc13 ");
				ExtentTestManager.startTest("TC - 13 -- Approval is being approved ");
				methods.ApproveRequest();
				ExtentTestManager.endTest();

				Log.info("tc14 ");
				ExtentTestManager.startTest("TC - 14 -- Request is being Rejected  ");
				methods.RejectRequest(SearchName1, Comment);
				ExtentTestManager.endTest();

				Log.info("tc15 ");
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
			ExtentManager.createInstance().flush();
			Log.info("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***");
		} catch (AssertionError e) {
			System.out.println("*** Test execution " + testdata.get("TestScenario").toString() + " failed...");
			Log.error("*** Test execution " + testdata.get("TestScenario").toString() + " failed...");
			Log.error("Test Execution failed " + e.getMessage());
			ExtentTestManager.getTest().log(Status.FAIL, "Test Failed: ");
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