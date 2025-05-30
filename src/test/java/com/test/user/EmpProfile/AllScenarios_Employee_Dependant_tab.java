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
import com.Page_Locators.Locators_Employee_Dependant_tab;
import com.Pages_Methods.Methods_Employee_Dependant_tab;
import com.Utility.Log;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;

public class AllScenarios_Employee_Dependant_tab extends Base_Class {
	Locators_Employee_Dependant_tab locators;
	Methods_Employee_Dependant_tab methods;
	Log log;
	com.Utility.ScreenShot screenshot;
	com.Utility.ExcelReader ExcelReader;
	ExtentTest extenttest;
	@BeforeSuite

	public void reference() {
		log = new Log();
		screenshot = new com.Utility.ScreenShot(driver);
		ExcelReader = new com.Utility.ExcelReader("EmployeeDependantTab");
		methods = new Methods_Employee_Dependant_tab();
		locators = new Locators_Employee_Dependant_tab();
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
				String LoginName = testdata.get("LoginName").toString();
				String EmpNm = testdata.get("EmployeeName").toString();
				

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
				ExtentTestManager.startTest("TC - 05 -- Validating to Dependant Page and Navigating ");
				Log.info("The validation is " + methods.NavigateToDependantśPage());
				ExtentTestManager.endTest();

				Log.info("TEST CASE 06 Started");
				ExtentTestManager.startTest("TC - 06 -- Validating  dependant page");
				Log.info("Result : " + methods.CheckingElementPresence());
				ExtentTestManager.endTest();

				Log.info("TEST CASE 07 Started");
				ExtentTestManager.startTest("TC - 07 -- Validating  Close Button functioanlity");
				methods.CloseBtnFunctionality();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 08 Started");
				ExtentTestManager.startTest("TC - 08 -- Validating Valid Input Submission ");
				methods.AddDependantFather();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 09 Started");
				ExtentTestManager.startTest("TC - 09 -- Try Entering Input with blank field .");
				methods.BlankFieldValidation();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 10 Started");
				ExtentTestManager.startTest("TC - 10 -- Validating Invalid date staring with Year .");
				methods.InvalidDateStartsWithYear();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 11 Started");
				ExtentTestManager.startTest("TC - 11 -- Validating Invalid date staring with day .");
				methods.InvalidDateStartWithDays();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 12 Started");
				ExtentTestManager.startTest("TC - 12 -- Validating If DOB can be future date .");
				methods.EnterFutureDatewithDatePicker();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 13 Started");
				ExtentTestManager.startTest("TC - 13 -- Validating if DOB can be in leap year");
				methods.EnterDOBInLeapYear();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 14 Started");
				ExtentTestManager.startTest("TC- 14 -- Validating DOB can be very old date or not");
				methods.enterDOBWithOldDate();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 15 Started");
				ExtentTestManager.startTest("TC- 15 -- Validating if name can have special Chars or not ");
				methods.SpecialCaseInName();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 16 Started");
				ExtentTestManager.startTest("TC- 16 -- Validating  if keyboard input is allowed or not");
				methods.ValidateKeyBoardInputInDOBField();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 17 Started");
				ExtentTestManager.startTest("TC- 17 -- Validating  if DOB can be present date or not");
				methods.EnterPresentDatewithDatePicker();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 18 Started");
				ExtentTestManager.startTest("TC- 18 -- Validating  if we can add duplicate father");
				methods.DuplicateFather();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 19  Started");
				ExtentTestManager.startTest("TC- 19 -- Validating  if we can add duplicate mother");
				methods.DuplicateMotherEntry();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 20 Started");
				ExtentTestManager.startTest("TC- 20 -- Validating  if we can add duplicate Spouse");
				methods.DuplicateSpouseEntry();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 21 Started");
				ExtentTestManager
						.startTest("TC- 21 -- Validating  if we can add Same name daughter with same DOB or Diff");
				methods.DuplicateNameDaughter();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 22 Started");
				ExtentTestManager.startTest("TC- 22 -- Validating  if we can add Same name son with same DOB or diff");
				methods.DuplicateNameSon();
				ExtentTestManager.endTest();

				Log.info("TEST CASE 23 Started");
				ExtentTestManager.startTest("TC- 23 -- Validating  Delete Action Button");
				methods.DeleteButtonInAction();
				ExtentTestManager.endTest();

				Signout();
				ExtentTestManager.getTest().log(Status.PASS, " Logout the Credentials ");
				System.out.println(("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***"));
				ExtentTestManager.endTest();

				ExtentManager.createInstance().flush();
				Log.info("*** Test Suite completed successfully ***");
				ExtentTestManager.getTest().log(Status.PASS, "Browser closed as test excution passed ");
				Log.info("Browser closed as test excution passed ");
//				driver.quit();
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
