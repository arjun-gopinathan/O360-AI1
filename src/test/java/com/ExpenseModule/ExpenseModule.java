package com.ExpenseModule;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
import com.Pages_ExpenseModule.Expense_ExpenseApproval;
import com.Pages_ExpenseModule.Expense_ExpenseRequest;
import com.Pages_TimesheetModule.TimeSheet_ListModule;
import com.Pages_TimesheetModule.Timeheet_WeekView;

import com.Pages_TimesheetModule.Timesheet_CreateModule;
import com.Utility.Log;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;

public class ExpenseModule extends Base_Class {
	com.Utility.ExcelReader ExcelReader;
	Base_Class Base_Class;
	Log log;
	TestListener TestListener;
	com.Utility.ScreenShot screenShot;
	Expense_ExpenseRequest Expense_ExpenseRequest;
	Expense_ExpenseApproval Expense_ExpenseApproval;
	ExtentTest extenttest;
	private static By userDropDown = By.xpath("//div[@id='userDropdown']/h4");
	private static By L_signout = By.xpath("//button[@class='dropdown-item ' and contains(text(),'Sign out')]");
	private static String filePath = "\\src\\test\\resources\\e-sign.pdf"; 
	public static By username = By.xpath("//input[@name='Username']");
	public static By password = By.xpath("//input[@name='Password']");
	public static By signin = By.xpath("//button[normalize-space(.)='Sign In']");
	
	@BeforeSuite
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("Expenses");
		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();
		
		Expense_ExpenseRequest= new Expense_ExpenseRequest();
		Expense_ExpenseApproval= new Expense_ExpenseApproval();
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
	public void RUNALL(Map<Object, Object> testdata, ITestContext context) throws IOException, InterruptedException {

		try {

			if (testdata.get("Run").toString().equalsIgnoreCase("Yes")) {
				// TC_BAC_Login_Positive case
				ExtentTestManager.startTest(testdata.get("TestScenario").toString());
				Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");
				context.setAttribute("fileName", "Login");
				ExtentTestManager.startTest("Launching O360");
				String username = testdata.get("UserName").toString();
				ExtentTestManager.endTest();
				ExtentTestManager.startTest("User Login");
				Base_Class.SetUp(username);
				ExtentTestManager.endTest();
					
				ExtentTestManager.getTest().log(Status.PASS, "Application Login" + com.BasePackage.Base_Class.Pagetitle);
				Log.info("Login successful !");
					
			    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			    ExtentTestManager.startTest("Pop Up Handling");
				handlePopupCovid();
				driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				handlePopupDesktop();
				driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				
				String project = testdata.get("project").toString();
				String currency = testdata.get("currency").toString();
				String year = testdata.get("year").toString();
				String month = testdata.get("month").toString();
				String day = testdata.get("day").toString();
				String expenseType = testdata.get("expenseType").toString();
				String amount = testdata.get("amount").toString();
				String status = testdata.get("status").toString();
				String pwd = testdata.get("Password").toString();
				String firstLevel = testdata.get("firstLevel").toString();
				String secondLevel = testdata.get("SecondLevel").toString();
				String thirdLevel = testdata.get("thirdLevel").toString();
				String billVerificationUserName= testdata.get("billVerificationUserName").toString();
				String billVerificationStatus=testdata.get("billVerificationStatus").toString();
				String accountVerificationUserName = testdata.get("accountVerificationUserName").toString();
				String accVerificationPaymentStatus = testdata.get("accVerificationPaymentStatus").toString();
				String accVerificationPaymentOn = testdata.get("accVerificationPaymentOn").toString();
				String paymentStatus = testdata.get("paymentStatus").toString();
				
				ExtentTestManager.startTest("TestScenario01 : Verify able to Add Expenses");
				boolean flag1 = Expense_ExpenseRequest.validate1(year, month, day, project, currency, expenseType, amount, status,  filePath);
				ExtentTestManager.getTest().log(Status.PASS, "Verify able to Add Expenses : " + flag1);
				Log.info("Expenses Added : " + flag1);
				
				ExtentTestManager.startTest("TestScenario02 : Verify able to Save Expenses");
				Map<String, Object> result = Expense_ExpenseRequest.validate2();
				ExtentTestManager.getTest().log(Status.PASS, "Verify able to Save Expenses : " + result.get("flag"));
				Log.info("Expenses Added : " + result.get("flag"));
				String expNumber = result.get("expNumber").toString();
				Log.info(expNumber);
				
				ExtentTestManager.startTest("TestScenario03 : Verify able to Submit Expenses");
				boolean flag3 = Expense_ExpenseRequest.validate3(expNumber);
				ExtentTestManager.getTest().log(Status.PASS, "Verify able to Submit Expenses : " + flag3);
				Log.info("Expenses Added : " + flag3);
				
				ExtentTestManager.startTest("TestScenario04 : Verify Submited Expenses listed in Submitted Section");
				boolean flag4 = Expense_ExpenseRequest.validate4(expNumber);
				ExtentTestManager.getTest().log(Status.PASS, "Verify Submited Expenses listed in Submitted Section : " + flag4);
				Log.info("Expenses Added : " + flag4);
				click(userDropDown);
				click(L_signout);
				
				ExtentTestManager.startTest("TestScenario05 : Verify First Level user approve the Expenses");
				boolean flag5 = Expense_ExpenseRequest.validate5(firstLevel, pwd, expNumber);
				ExtentTestManager.getTest().log(Status.PASS, "Verify First Level user approve the Expenses : " + flag5);
				Log.info("Expenses Added : " + flag5);
				click(userDropDown);
				click(L_signout);
				
				ExtentTestManager.startTest("TestScenario01 : Verify Second Level user approve the Expenses");
				boolean flag6 = Expense_ExpenseRequest.validate6(secondLevel, pwd, expNumber);
				ExtentTestManager.getTest().log(Status.PASS, "Verify Second Level user approve the Expenses : " + flag6);
				Log.info("Expenses Added : " + flag6);
				Log.info("Expenses Added : " + flag5);
				click(userDropDown);
				click(L_signout);
				
				ExtentTestManager.startTest("TestScenario01 : Verify Third Level user approve the Expenses");
				boolean flag7 = Expense_ExpenseRequest.validate7(thirdLevel, pwd, expNumber);
				ExtentTestManager.getTest().log(Status.PASS, "Verify Third Level user approve the Expenses : " + flag7);
				Log.info("Expenses Added : " + flag7);
				click(userDropDown);
				click(L_signout);
				
				ExtentTestManager.startTest("TestScenario01 : Verify Expenses is moved to Approval Section after 3 levels of approval");
				boolean flag8 = Expense_ExpenseRequest.validate8(username, pwd, expNumber);
				ExtentTestManager.getTest().log(Status.PASS, "Verify Expenses is moved to Approval Section after 3 levels of approval : " + flag8);
				Log.info("Expenses Added : " + flag8);
				click(userDropDown);
				click(L_signout);
				
				ExtentTestManager.startTest("TestScenario01 : Verify Expenses Bill Verification");
				boolean flag9 = Expense_ExpenseRequest.validate9(billVerificationUserName, pwd, billVerificationStatus, expNumber);
				ExtentTestManager.getTest().log(Status.PASS, "Verify Expenses Bill Verification : " + flag9);
				Log.info("Expenses Added : " + flag9);
				click(userDropDown);
				click(L_signout);
				
				ExtentTestManager.startTest("TestScenario01 : Verify Expenses Account Verification ");
				boolean flag10 = Expense_ExpenseRequest.validate10(accountVerificationUserName, pwd, accVerificationPaymentStatus, accVerificationPaymentOn, expNumber);
				ExtentTestManager.getTest().log(Status.PASS, "Verify Expenses Account Verification : " + flag10);
				Log.info("Expenses Added : " + flag10);
				
				
				ExtentTestManager.startTest("TestScenario01 : Verify Payment Release");
				boolean flag11 = Expense_ExpenseRequest.validate11(paymentStatus, expNumber);
				ExtentTestManager.getTest().log(Status.PASS, "Verify Payment Release : " + flag11);
				Log.info("Expenses Added : " + flag11);
				click(userDropDown);
				click(L_signout);
				
				ExtentTestManager.startTest("TestScenario01 : Verify After payment is Done expenses status is changed");
				boolean flag12 = Expense_ExpenseRequest.validate12(username, pwd, expNumber);
				ExtentTestManager.getTest().log(Status.PASS, "Verify After payment is Done expenses status is changed : " + flag12);
				Log.info("Expenses Added : " + flag12);
				click(userDropDown);
				click(L_signout);
				
				ExtentTestManager.startTest("TestScenario01 : Verify able to Reject Expenses");
				input(ExpenseModule.username, username);
		  		input(ExpenseModule.password, pwd);
		  		click(ExpenseModule.signin);
				boolean flag01 = Expense_ExpenseRequest.validate1(year, month, day, project, currency, expenseType, amount, status, filePath);
				Map<String, Object> rejectResult = Expense_ExpenseRequest.validate2();
				String expNumberRej = rejectResult.get("expNumber").toString();
				boolean flag03 = Expense_ExpenseRequest.validate3(expNumberRej);
				click(userDropDown);
				click(L_signout);
				boolean flag13 = Expense_ExpenseRequest.validate13(firstLevel, pwd, expNumberRej);
				ExtentTestManager.getTest().log(Status.PASS, "Verify able to Reject Expenses : " + flag13);
				Log.info("Expenses Added : " + flag13);
				click(userDropDown);
				click(L_signout);
				
				ExtentTestManager.startTest("TestScenario01 : Verify Rejected Expenses is listed in Rejected Section");
				boolean flag14 = Expense_ExpenseRequest.validate14(username, pwd, expNumberRej);
				ExtentTestManager.getTest().log(Status.PASS, "Verify Rejected Expenses is listed in Rejected Section : " + flag14);
				Log.info("Expenses Added : " + flag14);
				
				
				
				
				
				
				
				
				/*//TestScenario02 : Validate Timesheet View, Project and Module Names
				ExtentTestManager.startTest("TestScenario02 : Validate Timesheet View, Project and Module Names");
				//boolean flag2 = Timeheet_WeekView.ValidateTimeSheetView();
				ExtentTestManager.getTest().log(Status.PASS, "Timesheet view displayed : " + flag2);
				Log.info("Timesheet view displayed : " + flag2);
				
				
				ExtentTestManager.startTest("TestScenario03 : Verify Bulk Update Timesheet in Week view");
				boolean flag4 = Timeheet_WeekView.validate1(year, month, weekViewRange, project, moduleName);
				ExtentTestManager.getTest().log(Status.PASS, "Timesheet Bulk Update : " + flag4);
				Log.info("Timesheet Bulk Update : " + flag4);
				
				
				ExtentTestManager.startTest("TestScenario04 : Verify Signle Day Update Timesheet in Week view");
				boolean flag5 = Timeheet_WeekView.validate2(year, month, weekViewRange, project, moduleName);
				Timeheet_WeekView.TearDown(month, day);
				ExtentTestManager.getTest().log(Status.PASS, "Timesheet - Week View - Single Day Log : " + flag5);
				Log.info("Timesheet - Week View - Single Day Log : " + flag5);
				
				ExtentTestManager.startTest("TestScenario05 : Verify Able to Log Timesheet in Day view");
				boolean flag6 = Timeheet_WeekView.validation3(month, day);
				ExtentTestManager.getTest().log(Status.PASS, "Timesheet - day view - Days Log : " + flag6);
				Log.info("Timesheet - day view - Days Log : " + flag6);
				
				ExtentTestManager.startTest("TestScenario06 : Verify Able to do Cancel Request");
				boolean flag7 = Timeheet_WeekView.validation4();
				click(userDropDown);
				click(L_signout);
				ExtentTestManager.getTest().log(Status.PASS, "Timesheet - day view - Cancel Request : " + flag7);
				Log.info("Timesheet - day view - Cancel Request : " + flag7);
				
				
				
				ExtentTestManager.startTest("TestScenario07 : Verify Approve Timesheet Cancel Request");
				boolean flag8 = Timeheet_WeekView.validation5(pmo, pwd, empName);
				click(userDropDown);
				click(L_signout);
				ExtentTestManager.getTest().log(Status.PASS, "Timesheet - Approve Timesheet Request " + flag8);
				Log.info("Timesheet - Approve Timesheet Request : " + flag8);
				
				ExtentTestManager.startTest("TestScenario08 : Verify after approval Able to Update the Timesheet");
				boolean flag9 = Timeheet_WeekView.validation6(username, pwd, month, day);
				ExtentTestManager.getTest().log(Status.PASS, "Timesheet - Week View - After Approval of Cancel request : " + flag9);
				Log.info("Timesheet - Week View - After Approval of Cancel request : " + flag9);
				
				ExtentTestManager.startTest("TestScenario09 : Verify Reject Timesheet Cancel Request");
				click(userDropDown);
				click(L_signout);
				boolean flag10 = Timeheet_WeekView.validation7(pmo, pwd, empName);
				ExtentTestManager.getTest().log(Status.PASS, "Timesheet - Reject Timesheet cancel Request : " + flag10);
				Log.info("Timesheet - Reject Timesheet cancel Request : " + flag10); */
				
				
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

