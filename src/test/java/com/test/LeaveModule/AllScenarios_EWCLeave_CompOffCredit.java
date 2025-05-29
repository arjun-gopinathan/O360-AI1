package com.test.LeaveModule;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import org.openqa.selenium.By;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
import com.Pages_LeaveModule.Leave_EWCLeaveRequest;
import com.Utility.Log;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;

public class AllScenarios_EWCLeave_CompOffCredit extends Base_Class {
	
	com.Utility.ExcelReader ExcelReader;
	Base_Class Base_Class;
	Log log;
	TestListener TestListener;
	com.Utility.ScreenShot screenShot;
	Leave_EWCLeaveRequest Leave_EWCLeaveRequest;
	ExtentTest extenttest;
	private static By userDropDown = By.xpath("//div[@id='userDropdown']/h4");
	private static By L_signout = By.xpath("//button[@class='dropdown-item ' and contains(text(),'Sign out')]");
	private static By L_username = By.xpath("//input[@id='Username']");
	private static By L_password = By.xpath("//input[@id='Password']");
	private static By L_SignIn = By.xpath("//span[contains(text(),'Sign In')]");
	
	@BeforeSuite
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("EWCLeaveRequest_CompOffCredit");
		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();
		
		Leave_EWCLeaveRequest= new Leave_EWCLeaveRequest();

	}
//	@BeforeMethod
//	public void setupTest(Method method) throws Exception {
//		// Start a new ExtentTest for the current test method
//		extenttest = ExtentTestManager.startTest(method.getName()).assignCategory("EWC Leave CompOffCredit");		
//	}
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
	public void RUNALL(Map<Object, Object> testdata, ITestContext context) throws IOException, InterruptedException {

		try {

			if (testdata.get("Run").toString().equalsIgnoreCase("Yes")) {
				// TC_BAC_Login_Positive case
				ExtentTestManager.startTest(testdata.get("TestScenario").toString());
				Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");
				context.setAttribute("fileName", "Login");
				Base_Class.SetUp1();
				ExtentTestManager.getTest().log(Status.PASS,
						"Application Login" + com.BasePackage.Base_Class.Pagetitle);
				Log.info("Login successful !");
				Thread.sleep(3000);
				
				String EWCType = testdata.get("EWCType").toString();
				String fromYear = testdata.get("fromYear").toString();
				String fromMonth = testdata.get("fromMonth").toString();
				String fromDate = testdata.get("fromDate").toString();
				String toYear = testdata.get("toYear").toString();
				String toMonth = testdata.get("toMonth").toString();
				String toDate = testdata.get("toDate").toString();
				String project = testdata.get("Project").toString();
				String Reason = testdata.get("Reason").toString();
				String Employee = testdata.get("Employee").toString();
				String LeaveRequester = testdata.get("LeaveRequester").toString();
				String RejectCommnents = testdata.get("RejectCommnents").toString();
				String Employee1 = testdata.get("Employee1").toString();
				String leaveType = testdata.get("leaveType").toString();
			
				String fromYear1 = testdata.get("fromYear1").toString();
				String fromMonth1 = testdata.get("fromMonth1").toString();
				String fromDate1 = testdata.get("fromDate1").toString();
				String toYear1 = testdata.get("toYear1").toString();
				String toMonth1 = testdata.get("toMonth1").toString();
				String toDate1 = testdata.get("toDate1").toString();
				
				//timesheet
				String Month= testdata.get("Month").toString();
				String MonthWeek = testdata.get("MonthWeek").toString();
				String module = testdata.get("Module").toString();
				String Month1= testdata.get("Month1").toString();
				String MonthWeek1 = testdata.get("MonthWeek1").toString();


			//EWC Leave Selection
			ExtentTestManager.startTest("TestScenario 01 : Leave Request Form");
			Leave_EWCLeaveRequest.clickOnLeaveModule();
			boolean flag1 = Leave_EWCLeaveRequest.EWCleaveRequest(EWCType);
			ExtentTestManager.getTest().log(Status.PASS, "Validated Leave Request Form : " + flag1);
			Log.info("Validated Leave Request Form : " + flag1);
			
			ExtentTestManager.startTest("TestScenario 02 : Leave Request Form Field Display");
			boolean flag2 = Leave_EWCLeaveRequest.elementDisplayed();
			ExtentTestManager.getTest().log(Status.PASS, "Leave Request Form Field Displayed : " + flag2);
			Log.info("Leave Request Form Field Displayed : " + flag2);
			
			//Fill the EWC Form
			ExtentTestManager.startTest("TestScenario 03 : Add Leave Request Details");
			boolean flag3 = Leave_EWCLeaveRequest.EWCleaveRequestForm_CompOffCredit(fromYear, fromMonth, fromDate, toYear, toMonth, toDate, project, Reason, Employee, Month,MonthWeek, module);
			ExtentTestManager.getTest().log(Status.PASS, "Leave Request Details Added : " + flag3);
			Log.info("Leave Request Details Added  : " + flag3);
			
			//Click On Cancel Button
			ExtentTestManager.startTest("TestScenario 04 : Cancel Leave Request Form");
			boolean flag4 = Leave_EWCLeaveRequest.clickOnCancelButton();
			ExtentTestManager.getTest().log(Status.PASS, "Leave Request Form Cancelled : " + flag4);
			Log.info("Leave Request Form Cancelled : " + flag4);
			
			//Again Fill the EWC Form
			ExtentTestManager.startTest("TestScenario 05 : Add Leave Request Details");
			boolean flag5 = Leave_EWCLeaveRequest.EWCleaveRequestForm_CompOffCredit(fromYear, fromMonth, fromDate, toYear, toMonth, toDate, project, Reason, Employee, Month,MonthWeek, module);
			ExtentTestManager.getTest().log(Status.PASS, "Leave Request Details Added  : " + flag5);
			Log.info("Leave Request Details Added  : " + flag5);
			
			//Click On Submit Button
			ExtentTestManager.startTest("TestScenario 06 : Leave Request Form Submitted");
			boolean flag6 = Leave_EWCLeaveRequest.clickOnSubmitButton();
			ExtentTestManager.getTest().log(Status.PASS, "Leave Request Form Submitted : " + flag6);
			Log.info("Leave Request Form Submitted : " + flag6);
			
			ExtentTestManager.getTest().log(Status.PASS, "Logging out and logging in as Approver.");
			Log.info("Logging out and logging in as Approver.");
			context.setAttribute("fileName", "Logout"); 
			click(userDropDown);
			click(L_signout);
			String UserName = configloader().getProperty("ApproverUsername");
			String Password = configloader().getProperty("ApproverPassword");
			input(L_username, UserName);
			input(L_password, Password);
			click(L_SignIn);
//			Thread.sleep(4000);
			WaitForElementToBeVisible(home);
			handlePopupCovid();
			click(DesktopNot);
			Thread.sleep(1000);

			
			//Verify Approval Fields Functionality Button
			ExtentTestManager.startTest("TestScenario 07 : Validating Submitted Leave Request from Approver Side");
			Leave_EWCLeaveRequest.clickOnEWCModuleApproval(leaveType);
			boolean flag7 = Leave_EWCLeaveRequest.ApprovalButtonFieldsDisplayed(LeaveRequester, fromYear, fromMonth, fromDate);
			ExtentTestManager.getTest().log(Status.PASS, "Field Functionality Buttons Displayed in Submitted Leave Request : " + flag7);
			Log.info("Field Functionality Buttons Displayed in Submitted Leave Request : " + flag7);
			
			//Verify Rejected Functionality Button
			ExtentTestManager.startTest("TestScenario 08 : Leave Request Rejection");
			//Leave_EWCLeaveRequest.clickOnEWCModuleApproval();
			boolean flag8 = Leave_EWCLeaveRequest.RejectFunctionality(LeaveRequester, fromYear, fromMonth, fromDate, RejectCommnents);
			ExtentTestManager.getTest().log(Status.PASS, "Leave Request Rejected: " + flag8);
			Log.info("Leave Request Rejected : " + flag8);
			
			ExtentTestManager.getTest().log(Status.PASS, "Logging out and logging in as Requester.");
			Log.info("Logging out and logging in as Requester.");
			context.setAttribute("fileName", "Logout"); 
			click(userDropDown);
			click(L_signout);
			String UserName1 = configloader().getProperty("UserName");
			String Password1 = configloader().getProperty("Password");
			input(L_username, UserName1);
			input(L_password, Password1);
			click(L_SignIn);
//			Thread.sleep(4000);
			WaitForElementToBeVisible(home);
			click(DesktopNot);
			Thread.sleep(1000);
			
			//Fill the EWC Form
			ExtentTestManager.startTest("TestScenario 09 : Add Leave Request Details");
			Thread.sleep(3000);
			Leave_EWCLeaveRequest.clickOnLeaveModule();
			Leave_EWCLeaveRequest.EWCleaveRequest(EWCType);
			boolean flag9 = Leave_EWCLeaveRequest.EWCleaveRequestForm_CompOffCredit(fromYear, fromMonth, fromDate, toYear, toMonth, toDate, project, Reason, Employee, Month,MonthWeek, module);
			ExtentTestManager.getTest().log(Status.PASS, "Leave Request Details Added : " + flag9);
			Log.info("Leave Request Details Added : " + flag9);
			
			//Click On Submit Button
			ExtentTestManager.startTest("TestScenario 10 : Leave Request Form Submitted");
			boolean flag10 = Leave_EWCLeaveRequest.clickOnSubmitButton();
			ExtentTestManager.getTest().log(Status.PASS, "Leave Request Form Submitted : " + flag10);
			Log.info("Leave Request Form Submitted : " + flag10);
			
			ExtentTestManager.getTest().log(Status.PASS, "Logging out and logging in as Approver.");
			Log.info("Logging out and logging in as Approver.");
			context.setAttribute("fileName", "Logout"); 
			click(userDropDown);
			click(L_signout);
			String UserName2 = configloader().getProperty("ApproverUsername");
			String Password2 = configloader().getProperty("ApproverPassword");
			input(L_username, UserName2);
			input(L_password, Password2);
			click(L_SignIn);
//			Thread.sleep(4000);
			WaitForElementToBeVisible(home);
			click(DesktopNot);
			Thread.sleep(1000);
			
			
			//Verify Approval Fields Functionality Button
			ExtentTestManager.startTest("TestScenario 11 : Validating Submitted Leave Request from Approver Side");
			Leave_EWCLeaveRequest.clickOnEWCModuleApproval(leaveType);
			boolean flag11 = Leave_EWCLeaveRequest.ApproveFunctionality(LeaveRequester, fromYear, fromMonth, fromDate);
			ExtentTestManager.getTest().log(Status.PASS, "Leave Request Form Approved : " + flag11);
			Log.info("Leave Request Form Approved : " + flag11);
			
			ExtentTestManager.getTest().log(Status.PASS, "Logging out and logging in as Requester.");
			Log.info("Logging out and logging in as Requester.");
			context.setAttribute("fileName", "Logout"); 
			click(userDropDown);
			click(L_signout);
			String UserName3 = configloader().getProperty("UserName");
			String Password3 = configloader().getProperty("Password");
			input(L_username, UserName3);
			input(L_password, Password3);
			click(L_SignIn);
//			Thread.sleep(4000);
			WaitForElementToBeVisible(home);
			click(DesktopNot);
			Thread.sleep(1000);
			
			
			//Fill the EWC Form
			ExtentTestManager.startTest("TestScenario 12 : Add Leave Request Details");
			Thread.sleep(3000);
			Leave_EWCLeaveRequest.clickOnLeaveModule();
			Leave_EWCLeaveRequest.EWCleaveRequest(EWCType);
			boolean flag12 = Leave_EWCLeaveRequest.EWCleaveRequestForm_CompOffCredit(fromYear1, fromMonth1, fromDate1, toYear1, toMonth1, toDate1, project, Reason, Employee, Month1,MonthWeek1, module);
			ExtentTestManager.getTest().log(Status.PASS, "Leave Request Details Added : " + flag12);
			Log.info("Leave Request Details Added : " + flag12);
			
			//Click On Submit Button
			ExtentTestManager.startTest("TestScenario 13 : Leave Request Form Submitted");
			Thread.sleep(3000);
			boolean flag13 = Leave_EWCLeaveRequest.clickOnSubmitButton();
			ExtentTestManager.getTest().log(Status.PASS, "Leave Request Form Submitted : " + flag13);
			Log.info("Leave Request Form Submitted : " + flag13);
			
			ExtentTestManager.getTest().log(Status.PASS, "Logging out and logging in as Approver.");
			Log.info("Logging out and logging in as Approver.");
			context.setAttribute("fileName", "Logout"); 
			click(userDropDown);
			click(L_signout);
			String UserName4 = configloader().getProperty("ApproverUsername");
			String Password4 = configloader().getProperty("ApproverPassword");
			input(L_username, UserName4);
			input(L_password, Password4);
			click(L_SignIn);
//			Thread.sleep(4000);
			WaitForElementToBeVisible(home);
			click(DesktopNot);
			Thread.sleep(1000);
			
			
			//Verify Approval Fields Functionality Button
			ExtentTestManager.startTest("TestScenario 14 : Leave Request Send for Review");
			Thread.sleep(3000);
			Leave_EWCLeaveRequest.clickOnEWCModuleApproval(leaveType);
			boolean flag14 = Leave_EWCLeaveRequest.sendForReviewFunctionality(LeaveRequester, fromYear1, fromMonth1, fromDate1, Employee1);
			ExtentTestManager.getTest().log(Status.PASS, "Leave Request Rerouted Successfully for Review : " + flag14);
			Log.info("Leave Request Rerouted Successfully for Review  : " + flag14);
			
			ExtentTestManager.getTest().log(Status.PASS, "Logging out and logging in as Reviewer.");
			Log.info("Logging out and logging in as Reviewer.");
			context.setAttribute("fileName", "Logout"); 
			click(userDropDown);
			click(L_signout);
			String UserName5 = configloader().getProperty("ReviewerUsername");
			String Password5 = configloader().getProperty("ReviewerPassword");
			input(L_username, UserName5);
			input(L_password, Password5);
			click(L_SignIn);
//			Thread.sleep(4000);
			WaitForElementToBeVisible(home);
			handlePopupCovid();
			click(DesktopNot);
			Thread.sleep(1000);
			

			
			//Verify Approval Fields Functionality Button
			ExtentTestManager.startTest("TestScenario15 : Leave Request Approved");
			Thread.sleep(3000);
			Leave_EWCLeaveRequest.clickOnEWCModuleApproval(leaveType);
			boolean flag15 = Leave_EWCLeaveRequest.ApproveFunctionality(LeaveRequester, fromYear1, fromMonth1, fromDate1);
			ExtentTestManager.getTest().log(Status.PASS, "Leave Request Form Approved : " + flag15);
			Log.info("Leave Request Form Approved : " + flag15);
			

			Thread.sleep(5000);
			// Logout
			ExtentTestManager.startTest("Application Logout Initiated.");
			context.setAttribute("fileName", "Logout");
			click(userDropDown);
			click(L_signout);
			Thread.sleep(2000);
			driver.quit();
			ExtentTestManager.getTest().log(Status.PASS, "Application Logout");
			Log.info("Logout is done!");

			// EndTest
			System.out.println(("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***"));
			ExtentTestManager.endTest();
			ExtentManager.getInstance().flush();
			Log.info("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***");

			}

			}
			catch (Exception e) {
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
