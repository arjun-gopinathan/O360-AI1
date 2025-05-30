package com.test.user.TimesheetModule;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
import com.Pages_TimesheetModule.Timeheet_ApprovalModule;
import com.Utility.Log;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;

public class AllScenarios_TimeSheet_Approvals extends Base_Class  {
	
	com.Utility.ExcelReader ExcelReader;
	Base_Class Base_Class;
	Timeheet_ApprovalModule TimeSheet_Approvals;
	ExtentTest extenttest;
	Log log;
	TestListener TestListener;
	com.Utility.ScreenShot screenShot;
	
	private static By userDropDown = By.xpath("//div[@id='userDropdown']/h4");
	private static By L_signout = By.xpath("//button[@class='dropdown-item ' and contains(text(),'Sign out')]");
	private static String filePath = "C:\\Users\\drishya.devan\\git\\O360\\O360\\src\\test\\resources\\e-sign.pdf"; 
	
	private static By L_username = By.xpath("//input[@id='Username']");
	private static By L_password = By.xpath("//input[@id='Password']");
	private static By L_SignIn = By.xpath("//span[contains(text(),'Sign In')]");
	
	
	@BeforeSuite
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("Timesheet_Approvals");		
		log=new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);	
		Base_Class = new Base_Class();
		TimeSheet_Approvals = new Timeheet_ApprovalModule();

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
	public  void RUNALL(Map <Object,Object> testdata, ITestContext context) throws IOException, InterruptedException {

		try {
			if (testdata.get("Run").toString().equalsIgnoreCase("Yes")) {

				ExtentTestManager.startTest(testdata.get("TestScenario").toString());
				Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");	
				context.setAttribute("fileName", "Login");
				  ExtentTestManager.startTest("Launching O360");
					 String username = testdata.get("UserName").toString();
					 ExtentTestManager.endTest();
					 ExtentTestManager.startTest("User Login");
						Base_Class.SetUp(username);
						 ExtentTestManager.endTest();
					//Base_Class.SetUp();
					ExtentTestManager.getTest().log(Status.PASS,
							"Application Login" + com.BasePackage.Base_Class.Pagetitle);
					Log.info("Login successful !");
					
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					//Thread.sleep(3000);
					   //ExtentTestManager.endTest();
					   ExtentTestManager.startTest("Pop Up Handling");
					   handlePopupCovid();
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					   handlePopupDesktop();
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				
				String projectName = testdata.get("Project Name").toString();
				String moduleName = testdata.get("Module Name").toString();
				//String day1 = testdata.get("Valid Day").toString();
				//String day2 = testdata.get("VALID DAY IN CAPS").toString();
				String EmployeeName = testdata.get("Employee Name").toString();
								

				//Timesheet40 - Validate if PMO is able to approve timesheet submitted by employee
				ExtentTestManager.startTest("Validating if PMO is able to Approve timesheet"); 
				//Perform as Employee
				boolean flag1 = TimeSheet_Approvals.NavigateToMyTimeSheet();
				ExtentTestManager.getTest().log(Status.PASS, "Navigated to My Timesheet : " + flag1);
				Log.info("Navigated to My Timesheet : " + flag1);
				
				//TimeSheet_MyTimeSheet.FillFullWeekTimeSheet(" Invoice_Test_T&M "," Module 1 ", "Select All");
				TimeSheet_Approvals.NavigateToPreviousWeekTimeSheetWeeklyNormalView();
				ExtentTestManager.getTest().log(Status.PASS, "Navigated to My Timesheet - Prev Week - Weekly Normal View." );
				Log.info("Navigated to My Timesheet - Prev Week - Weekly Normal View.");
				
				
				TimeSheet_Approvals.SubmitPreviousWeekTimeSheetOnDifferentCondition(projectName,moduleName);
				ExtentTestManager.getTest().log(Status.PASS, "Submitted Previous Week TimeSheet.");
				Log.info("Submitted Previous Week TimeSheet.");
				
				
				ExtentTestManager.getTest().log(Status.PASS, "Logging out and logging in as Approver.");
				Log.info("Logging out and logging in as Approver.");
				context.setAttribute("fileName", "Logout"); 
				click(userDropDown);
				click(L_signout);
				String UserName = configloader().getProperty("PMOUserName");
				String Password = configloader().getProperty("PMOPassword");
				input(L_username, UserName);
				input(L_password, Password);
				click(L_SignIn);
				
				boolean flag2 = TimeSheet_Approvals.NavigateToApproval();
				TimeSheet_Approvals.SelectEmployeeForApproval(EmployeeName);
				ExtentTestManager.getTest().log(Status.PASS, "Approval page loaded : " + flag2);
				Log.info("Approval page loaded : " + flag2);
				TimeSheet_Approvals.ApproveButton();
				click(userDropDown);
				click(L_signout);
				
				
				ExtentTestManager.getTest().log(Status.PASS, "Logging out and logging in as Employee.");
				Log.info("Logging out and logging in as Employee.");
				//Timesheet41 - Validate if PMO is able to reject timesheet submitted by employee
				String EmpUserName = configloader().getProperty("UserName");
				String EmpPassword = configloader().getProperty("Password");
				input(L_username, EmpUserName);
				input(L_password, EmpPassword);
				click(L_SignIn);
				
				ExtentTestManager.startTest("Validating if PMO is able to Reject timesheet"); 
				//Perform as Employee
				boolean flag3 = TimeSheet_Approvals.NavigateToMyTimeSheet();
				ExtentTestManager.getTest().log(Status.PASS, "Navigated to My Timesheet : " + flag3);
				Log.info("Navigated to My Timesheet : " + flag3);
				
				
				//TimeSheet_MyTimeSheet.FillFullWeekTimeSheet(" Invoice_Test_T&M "," Module 1 ", "Select All");
				TimeSheet_Approvals.NavigateToPreviousWeekTimeSheetWeeklyNormalView();
				ExtentTestManager.getTest().log(Status.PASS, "Navigated to My Timesheet - Previous Week - Weekly Normal View." );
				Log.info("Navigated to My Timesheet - Previous Week - Weekly Normal View.");
				
				
			
				TimeSheet_Approvals.SubmitPreviousWeekTimeSheetOnDifferentCondition(projectName,moduleName);
				ExtentTestManager.getTest().log(Status.PASS, "Submitted Previous Week TimeSheet.");
				Log.info("Submitted Previous Week TimeSheet.");
				
				
				ExtentTestManager.getTest().log(Status.PASS, "Logging out and logging in as Approver.");
				Log.info("Logging out and logging in as Approver.");
				context.setAttribute("fileName", "Logout"); 
				click(userDropDown);
				click(L_signout);
				//Perform Approval as PMO
				String PMOUserName = configloader().getProperty("PMOUserName");
				String PMOPassword = configloader().getProperty("PMOPassword");
				input(L_username, PMOUserName);
				input(L_password, PMOPassword);
				click(L_SignIn); 
				
				boolean flag4 = TimeSheet_Approvals.NavigateToApproval();
				ExtentTestManager.getTest().log(Status.PASS, "Navigated to Approval Screen : " + flag4);
				Log.info("Navigated to Approval Screen : " + flag4);
				
				
				TimeSheet_Approvals.SelectEmployeeForApproval(EmployeeName);
				ExtentTestManager.getTest().log(Status.PASS, "Selected employee.");
				Log.info("Selected employee.");
				
				
				TimeSheet_Approvals.ValidateReject();	
				ExtentTestManager.getTest().log(Status.PASS, "Successfully Rejected Timesheet cancel request by employee.");
				Log.info("Rejected employee.");
				
				
				// Logout
				ExtentTestManager.startTest("Logout."); 
				context.setAttribute("fileName", "Logout"); 
				click(userDropDown);
				click(L_signout);
				
				Thread.sleep(2000);
				driver.quit();
				ExtentTestManager.getTest().log(Status.PASS, "Application Logout");
				Log.info("Logout is done");



				// EndTest
				System.out.println(("*** Test Suite " +  testdata.get("TestScenario").toString()+ " ending ***"));
				ExtentTestManager.endTest();
				ExtentManager.getInstance().flush();
				Log.info("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***");

			}

		}
		catch (Exception e) {
			System.out.println("*** Test execution " +  testdata.get("TestScenario").toString() + " failed...");
			Log.error("*** Test execution " +  testdata.get("TestScenario").toString() + " failed...");
			Log.error("" + e.getMessage());
			String fileName = (String) context.getAttribute("fileName");

			try {
				File file = new com.Utility.ScreenShot(driver).takeScreenShot(fileName, testdata.get("TestScenario").toString());
				ExtentTestManager.getTest().fail(e.getMessage(),
						MediaEntityBuilder.createScreenCaptureFromPath(file.toString()).build());
			} catch (Exception e1) {
				System.out.println("File not found " + e1);
			}
			ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");

			// Logout
			context.setAttribute("fileName", "Logout");
			//driver.quit();
			ExtentTestManager.getTest().log(Status.PASS, "Application Logout");
			Log.info("Logout is done");

			// EndTest
			System.out.println(("*** Test Suite " +  testdata.get("TestScenario").toString() + " ending ***"));
			ExtentTestManager.endTest();
			ExtentManager.getInstance().flush();
			Log.info("*** Test Suite " +  testdata.get("TestScenario").toString() + " ending ***");
		}
		catch (AssertionError e) {
			System.out.println("*** Test execution " +  testdata.get("TestScenario").toString() + " failed...");
			Log.error("*** Test execution " +  testdata.get("TestScenario").toString() + " failed...");
			Log.error("" + e.getMessage());
			String fileName = (String) context.getAttribute("fileName");

			try {
				File file = new com.Utility.ScreenShot(driver).takeScreenShot(fileName, testdata.get("TestScenario").toString());
				ExtentTestManager.getTest().fail(e.getMessage(),
						MediaEntityBuilder.createScreenCaptureFromPath(file.toString()).build());
			} catch (Exception e1) {
				System.out.println("File not found " + e1);
			}
			ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");

			// Logout
			context.setAttribute("fileName", "Logout");
			//driver.quit();
			ExtentTestManager.getTest().log(Status.PASS, "Application Logout");
			Log.info("Logout is done");

			// EndTest
			System.out.println(("*** Test Suite " +  testdata.get("TestScenario").toString() + " ending ***"));
			ExtentTestManager.endTest();
			ExtentManager.getInstance().flush();
			Log.info("*** Test Suite " +  testdata.get("TestScenario").toString() + " ending ***");
		}

	}

	@DataProvider(name = "TestData")
	public static Object[][] gettestdate() throws IOException{

		Object[][] objectarry=null;
		java.util.List<Map<String,String>> completedata=com.Utility.ExcelReader.getdata();

		objectarry=new Object[completedata.size()][1];

		for(int i=0;i<completedata.size();i++) {
			objectarry[i] [0]= completedata.get(i);
		}
		return objectarry;

	}



	
	
	
	
	
	
	
	
	
	
	
	
	

}
