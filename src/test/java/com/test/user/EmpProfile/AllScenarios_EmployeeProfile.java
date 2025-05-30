package com.test.user.EmpProfile;

import java.awt.AWTException;
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
import com.Page_Locators.Locators_Emp_Profile;
import com.Pages_Methods.Methods_Approver_EmpProfile;
import com.Pages_Methods.Methods_EmpProfile;
import com.Utility.Log;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;

public class AllScenarios_EmployeeProfile extends Base_Class {

	Locators_Emp_Profile locators;
	Locators_Approve_Process ApproveLoc;
	Methods_EmpProfile methods;
	Methods_Approver_EmpProfile ApproveMethods;
	Log log;
	com.Utility.ScreenShot screenshot;
	com.Utility.ExcelReader ExcelReader;
	ExtentTest extenttest;
	// Setup method to initialize objects and perform setup
	@BeforeSuite

	public void reference() {
		locators = new Locators_Emp_Profile();
		ApproveLoc = new Locators_Approve_Process();
		methods = new Methods_EmpProfile();
		ApproveMethods = new Methods_Approver_EmpProfile();
		log = new Log();
		screenshot = new com.Utility.ScreenShot(driver);
		ExcelReader = new com.Utility.ExcelReader("EmpProfileTabEditing");
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
			throws IOException, InterruptedException, AWTException {
		try {

			if (testdata.get("Run").toString().equalsIgnoreCase("Yes")) {
				ExtentTestManager.startTest(testdata.get("TestScenario").toString());
				Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");
				context.setAttribute("fileName", "Login");
				String UserName1 = testdata.get("UserName").toString();
				String EmpNm1 = testdata.get("EmpName").toString();

				String Un = testdata.get("LoginName").toString();
				SetUp(Un);
				ExtentTestManager.getTest().log(Status.PASS, "Application setup successfull");

				ExtentTestManager.startTest("TC- 1 Handling Popup's ");
				handlePopupCovid();
				handlePopupDesktop();
				ExtentTestManager.endTest();

				ExtentTestManager.startTest("TC- 2 Validating dashboad is displayed or not");
				verifySuccessfulLogin();
				ExtentTestManager.getTest().log(Status.PASS, "Verified Login is successful ");
				Log.info("Verified Login in successful ");
				ExtentTestManager.endTest();

				ExtentTestManager.startTest("TC - 03 -- Verifying Dashboard Accessibility ");
				ExtentTestManager.getTest().log(Status.INFO, "Verifying Dashboard Accessibility ");
				validateDashBoard();
				ExtentTestManager.endTest();

				ExtentTestManager.startTest("TC - 04 -- Testing whether emp is available or not");
				String Username = null;
				String EmpName = null;

				Username = UserName1;
				EmpName = EmpNm1;
				Log.info("User Name to login " + UserName1);
				Log.info("Emp Name to search " + EmpNm1);

				methods.CheckIfEmpPresentOrNot(Username, EmpName);
				ExtentTestManager.endTest();

				ExtentTestManager.startTest("TC - 05 -- Navigating to Profile");
				methods.navigateToProfile();
				ExtentTestManager.endTest();

				ExtentTestManager.startTest("TC - 06 -- Verifying Navigating to Dependant");
				methods.navigateToDependant();
				ExtentTestManager.endTest();

				ExtentTestManager.startTest("TC - 07 -- Verifying Navigating to Social Media");
				methods.navigateToSocialTab();
				ExtentTestManager.endTest();

				ExtentTestManager.startTest("TC - 08 -- Verifying Profile tab is defualt or not");
				methods.checkDefaultTab();
				ZoomOut();
				ExtentTestManager.endTest();

				ExtentTestManager.startTest("TC - 09 -- Verifying Profile tab is defualt or not");
				methods.checkVisiblityInProfilePg();
				ExtentTestManager.endTest();

				ExtentTestManager.startTest("TC - 10 -- Verifying Permanent ADDRESS is visible or not");
				methods.permaAddClickBtn();
				methods.PermantCheckIfDisplayedOrNot();
				ExtentTestManager.endTest();

				ExtentTestManager.startTest("TC - 11 -- Verifying Permanent ADDRESS is editable");
				methods.enterPremaAdd(testdata, context);
				ExtentTestManager.endTest();

				ExtentTestManager.startTest("TC - 12 -- Verifying Present ADDRESS is visble ");
				methods.prestAddClickBtn();
				ExtentTestManager.endTest();

				ExtentTestManager.startTest("TC - 13 -- Verifying Present ADDRESS is editable");
				methods.enterPrestAdd();
				ExtentTestManager.endTest();

				ExtentTestManager.startTest("TC - 14 -- Verifying Contact Details isvisible or not");
				methods.ContactNoClickBtn();
				methods.ContactCheckIfDisplayedOrNot();
				ExtentTestManager.endTest();
				ExtentTestManager.startTest("TC - 15 -- Verifying Contact Details is editable or not");
				methods.enterContactNo();
				ExtentTestManager.endTest();

				ExtentTestManager.startTest("TC - 16 -- Verifying Other Information is and visible or not");
				methods.OtherInfoClickBtn();
				methods.OtherInfoIfDisplayedOrNot();
				ExtentTestManager.endTest();

				ExtentTestManager.startTest("TC - 17 -- Verifying Other Information is editable");
				methods.enterOtherInfo();
				ExtentTestManager.endTest();

				ExtentTestManager.startTest("TC - 18 -- Verifying Personal Details is editable and visible or not");
				methods.PersonalClickBtn();
				methods.PersonalIfDisplayedOrNot();
				ExtentTestManager.endTest();

				ExtentTestManager.startTest("TC - 19 -- Verifying Personal Details is editable and visible or not");
				methods.enterPersonal(testdata, context);
				ExtentTestManager.endTest();

				ExtentTestManager.startTest("TC - 20 -- Verifying Bank Details is visible or not");
				methods.BankClickBtn();
				methods.BankIfDisplayedOrNot();
				ExtentTestManager.endTest();

				ExtentTestManager.startTest("TC - 21 --Verifying Bank Details is editable or not");
				methods.enterBankDetails();
				ExtentTestManager.endTest();

				ExtentTestManager.startTest("TC - 22 -- Verifying Passport Details is visible or not");
				methods.PassportClickBtn();
				methods.PassportIfDisplayedOrNot();
				ExtentTestManager.endTest();

				ExtentTestManager.startTest("TC - 23 -- Verifying Passport Details is editable or not");
				methods.enterPassportDetails();
				ExtentTestManager.endTest();

				ExtentTestManager.startTest("TC - 24 -- Verifying Emergency Contact Details is editable or not");
				methods.EmergencyClickBtn();
				methods.EmergencyIfDisplayedOrNot();
				ExtentTestManager.endTest();

				ExtentTestManager.startTest("TC - 25 --  Verifying Emergency Contact Details is editable ");
				methods.enterEmergencyDetails(testdata, context);
				ExtentTestManager.endTest();

				ExtentTestManager.startTest("TC - 26  -- Verifying HR Notification is editable and visible or not");
				methods.HRNtfctonClickBtn();
				methods.HRNtfctonIfDisplayedOrNot();
				ExtentTestManager.endTest();

				ExtentTestManager
						.startTest("TC - 27 -- Verifying Submit Button is visible or not and functional as expected");
				methods.ClickSubmitBtn();
				Thread.sleep(5000);
				Thread.sleep(5000);
				ExtentTestManager.endTest();

				System.out.println(("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***"));
				ExtentTestManager.endTest();
				ExtentManager.getInstance().flush();
				Log.info("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***");

			}
		} catch (

		AssertionError e) {
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
			// driver.quit();
			Signout();
			ExtentTestManager.getTest().log(Status.PASS, "Application Logout as execution failed");
			Log.info("Logout is done");

			// EndTest
			System.out.println(("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***"));
			ExtentTestManager.endTest();
			ExtentManager.getInstance().flush();
			Log.info("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***");
			driver.quit();
		}
	}

	@DataProvider(name = "TestData")
	public Object[][] getTestData() throws IOException {
		java.util.List<Map<String, String>> completedata = com.Utility.ExcelReader.getdata();
		Object[][] objectArray = new Object[completedata.size()][1];

		for (int i = 0; i < completedata.size(); i++) {
			objectArray[i][0] = completedata.get(i);
		}
		return objectArray;
	}
}