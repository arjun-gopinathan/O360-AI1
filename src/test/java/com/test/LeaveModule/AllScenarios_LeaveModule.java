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
import com.Pages_LeaveModule.Leave_LeaveRequest;
import com.Utility.Log;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;

public class AllScenarios_LeaveModule extends Base_Class {
	com.Utility.ExcelReader ExcelReader;
	Base_Class Base_Class;
	Log log;
	TestListener TestListener;
	com.Utility.ScreenShot screenShot;
	Leave_LeaveRequest Leave_LeaveRequest;
	ExtentTest extenttest;
	private static By userDropDown = By.xpath("//div[@id='userDropdown']/h4");
	private static By L_signout = By.xpath("//button[@class='dropdown-item ' and contains(text(),'Sign out')]");
	private static By L_username = By.xpath("//input[@id='Username']");
	private static By L_password = By.xpath("//input[@id='Password']");
	private static By L_SignIn = By.xpath("//span[contains(text(),'Sign In')]");
	
	@BeforeSuite
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("LeaveRequest");
		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();
		
		Leave_LeaveRequest= new Leave_LeaveRequest();

	}
	@BeforeMethod
	public void setupTest(Method method) throws Exception {
		// Start a new ExtentTest for the current test method
		extenttest = ExtentTestManager.startTest(method.getName()).assignCategory("Leave Module");		
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
				
				String leaveType = testdata.get("leaveType").toString();
				String fromYear = testdata.get("fromYear").toString();
				String fromMonth = testdata.get("fromMonth").toString();
				String fromDate1 = testdata.get("fromDate1").toString();
				String toYear = testdata.get("toYear").toString();
				String toMonth = testdata.get("toMonth").toString();
				String toDate = testdata.get("toDate").toString();
				String duration = testdata.get("duration").toString();
				String Reason = testdata.get("Reason").toString();
				String Employee = testdata.get("Employee").toString();
				String CancelComments = testdata.get("CancelComments").toString();
				String EmployeeName = testdata.get("EmployeeName").toString();

				
				
			//Dashboard Display
			ExtentTestManager.startTest("TestScenario01 : Leave Dashboard");
			boolean flag1 = Leave_LeaveRequest.clickOnDashboard();		
			ExtentTestManager.getTest().log(Status.PASS, "Leave Dashboard Displayed : " + flag1);
			Log.info("Leave Dashboard Displayed : " + flag1);

			//Leave Request Module
			ExtentTestManager.startTest("TestScenario02 : Select Leave Module");
			boolean flag2 = Leave_LeaveRequest.clickOnLeaveModule();
			ExtentTestManager.getTest().log(Status.PASS, "Selected Leave Module : " + flag2);
			Log.info("Selected Leave Module : " + flag2);
			
			//My Statement Module
			ExtentTestManager.startTest("TestScenario03 : Validate My Statement Module");
			boolean flag3 = Leave_LeaveRequest.ValidateStatementModal();
			ExtentTestManager.getTest().log(Status.PASS, "Validated My Statement : " + flag3);
			Log.info("Validated My Statement : " + flag3);
			
			//Validate Leave Type
			ExtentTestManager.startTest("TestScenario04 : Validate Leave Type");
			boolean flag4 = Leave_LeaveRequest.ValidateLeaveModule(leaveType);
			ExtentTestManager.getTest().log(Status.PASS, "Validated Leave Type : " + flag4);
			Log.info("Validated Leave Type : " + flag4);
			
			//Validate Form Mandatory Fields
			ExtentTestManager.startTest("TestScenario05 : Validate Mandatory Fields");
			Leave_LeaveRequest.selectLeaveType(leaveType);
			boolean flag5 = Leave_LeaveRequest.ValidateLeaveModuleForm(leaveType);
			ExtentTestManager.getTest().log(Status.PASS, "Validated Leave Request Form Mandatory Field : " + flag5);
			Log.info("Validated Leave Request Form Mandatory Field : " + flag5);
			
//			//Validated Leave Request Clear Button Functionality
//			ExtentTestManager.startTest("TestScenario06 : Leave Request Form Clear Button Functionality");
//			Thread.sleep(3000);
//			Leave_LeaveRequest.leaveRequestForm(leaveType, fromYear, fromMonth, fromDate1,toYear, toMonth, toDate, duration,Reason,Employee );
//			boolean flag6 = Leave_LeaveRequest.clearButton(leaveType);
//			Thread.sleep(5000);
//			ExtentTestManager.getTest().log(Status.PASS, "Validated Leave Request Clear Button Functionality : " + flag6);
//			Log.info("Validated Leave Request Clear Button Functionality : " + flag6);
			
			//Validated Leave Request Submit Button Functionality
			ExtentTestManager.startTest("TestScenario07 : Leave Request Form Submit Button Functionality");
			Leave_LeaveRequest.leaveRequestForm(leaveType, fromYear, fromMonth, fromDate1 ,toYear, toMonth, toDate, duration,Reason,Employee );
			boolean flag7 = Leave_LeaveRequest.submitButton();
			ExtentTestManager.getTest().log(Status.PASS, "Validated Leave Request Submit Button Functionality : " + flag7);
			Log.info("Validated Leave Request Submit Button Functionality : " + flag7);
			
			//Validated Cancel Leave Request Functionality
			ExtentTestManager.startTest("TestScenario07 : Cancel Leave Request Functionality");
			boolean flag8 = Leave_LeaveRequest.CancelLeaveRequest(CancelComments);
			ExtentTestManager.getTest().log(Status.PASS, "Validated Cancel Leave Request Functionality : " + flag8);
			Log.info("Validated Cancel Leave Request Functionality : " + flag8);
			
//			ExtentTestManager.getTest().log(Status.PASS, "Logging out and logging in as Approver.");
//			Log.info("Logging out and logging in as Approver.");
//			context.setAttribute("fileName", "Logout"); 
//			click(userDropDown);
//			click(L_signout);
//			Thread.sleep(2000);
//			//Perform Approval as PMO
//			String PMOUserName = configloader().getProperty("Approver2Username");
//			String PMOPassword = configloader().getProperty("Approver2Password");
//			input(L_username, PMOUserName);
//			input(L_password, PMOPassword);
//			click(L_SignIn); 
//			WaitForElementToBeVisible(home);
//			handlePopupCovid();
//			click(DesktopNot);
//			Thread.sleep(1000);
//			
//			//Validated Cancel Leave Request Functionality
//			ExtentTestManager.startTest("TestScenario09 : Cancel Leave Request Functionality");
//			Leave_LeaveRequest.clickOnEWCModuleApproval();
//			boolean flag9 = Leave_LeaveRequest.RejectFunctionality(EmployeeName);
//			ExtentTestManager.getTest().log(Status.PASS, "Validated Cancel Leave Request Functionality : " + flag9);
//			Log.info("Validated Cancel Leave Request Functionality : " + flag9);
//			
//			ExtentTestManager.getTest().log(Status.PASS, "Logging out and logging in as Requester.");
//			Log.info("Logging out and logging in as Requester.");
//			context.setAttribute("fileName", "Logout"); 
//			click(userDropDown);
//			click(L_signout);
//			Thread.sleep(2000);
//			//Perform Approval as PMO
//			String PMOUserName1 = configloader().getProperty("UserName");
//			String PMOPassword1 = configloader().getProperty("Password");
//			input(L_username, PMOUserName1);
//			input(L_password, PMOPassword1);
//			click(L_SignIn); 
//			WaitForElementToBeVisible(home);
//			click(DesktopNot);
//			Thread.sleep(1000);
//			
//			//Leave Request Module
//			ExtentTestManager.startTest("TestScenario10 : Select Leave Module");
//			boolean flag10 = Leave_LeaveRequest.clickOnLeaveModule();
//			ExtentTestManager.getTest().log(Status.PASS, "Selected Leave Module : " + flag10);
//			Log.info("Selected Leave Module : " + flag10);
//			
			//Validate Form Mandatory Fields
			ExtentTestManager.startTest("TestScenario11 : Validate Mandatory Fields");
			boolean flag11 = Leave_LeaveRequest.selectLeaveType(leaveType);
			ExtentTestManager.getTest().log(Status.PASS, "Validated Leave Request Form Mandatory Field : " + flag11);
			Log.info("Validated Leave Request Form Mandatory Field : " + flag11);
			
			//Validated Leave Request Submit Button Functionality
			ExtentTestManager.startTest("TestScenario12 : Leave Request Form Submit Button Functionality");
			Leave_LeaveRequest.leaveRequestForm(leaveType, fromYear, fromMonth, fromDate1 ,toYear, toMonth, toDate, duration,Reason,Employee );
			boolean flag12 = Leave_LeaveRequest.submitButton();
			ExtentTestManager.getTest().log(Status.PASS, "Validated Leave Request Submit Button Functionality : " + flag12);
			Log.info("Validated Leave Request Submit Button Functionality : " + flag12);
			
			ExtentTestManager.getTest().log(Status.PASS, "Logging out and logging in as Approver.");
			Log.info("Logging out and logging in as Approver.");
			context.setAttribute("fileName", "Logout"); 
			click(userDropDown);
			click(L_signout);
			Thread.sleep(2000);
			//Perform Approval as PMO
			String PMOUserName2 = configloader().getProperty("ApproverUsername");
			String PMOPassword2 = configloader().getProperty("ApproverPassword");
			input(L_username, PMOUserName2);
			input(L_password, PMOPassword2);
			click(L_SignIn); 
			WaitForElementToBeVisible(home);
			click(DesktopNot);
			Thread.sleep(1000);
			
			
			
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

