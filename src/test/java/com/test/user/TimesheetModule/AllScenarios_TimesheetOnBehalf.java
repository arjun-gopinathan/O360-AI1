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
import com.Pages_TimesheetModule.Timesheet_TimesheetOnBehalf;
import com.BasePackage.Base_Class;

import com.Utility.Log;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;


public class AllScenarios_TimesheetOnBehalf extends Base_Class 

{

	com.Utility.ExcelReader ExcelReader;
	Log log;
	TestListener TestListener;
	com.Utility.ScreenShot screenShot;	
	Base_Class Base_Class;
	Timesheet_TimesheetOnBehalf Timesheet_TimesheetOnBehalf;
	ExtentTest extenttest;
	private static By userDropDown = By.xpath("//div[@id='userDropdown']/h4");
	private static By L_signout = By.xpath("//button[@class='dropdown-item ' and contains(text(),'Sign out')]");
	private static By L_username = By.xpath("//input[@id='Username']");
	private static By L_password = By.xpath("//input[@id='Password']");
	private static By L_SignIn = By.xpath("//span[contains(text(),'Sign In')]");
	private static By reasonTextbox = By.xpath("//label[text()='Reason']/parent::div//textarea");
	
	//important private static By l_jobpopup = By.xpath("//ul[@role='listbox']//li[contains(text(),'HCA')]");	


	@BeforeSuite
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("TimesheetOnBehalf");		
		log=new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);	
		Base_Class = new Base_Class();
		Timesheet_TimesheetOnBehalf = new Timesheet_TimesheetOnBehalf();


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
				
				String empName = testdata.get("Employee Name").toString();
				String projectName = testdata.get("Project Name").toString();
				String moduleName = testdata.get("Module Name").toString();
				String approverName = testdata.get("Approver").toString();
				
				click(userDropDown);
				click(L_signout);
				ExtentTestManager.getTest().log(Status.PASS, "Signed out as Employee.");
				Log.info("Signed out as Employee.");
				
				String UserName1 = configloader().getProperty("ApproverUsername");
				String Password1 = configloader().getProperty("ApproverPassword");
				input(L_username, UserName1);
				input(L_password, Password1);
				click(L_SignIn);
				ExtentTestManager.getTest().log(Status.PASS, "Signed in as Approver.");
				Log.info("Signed in as Approver.");

				//Navigate To TimeSheet On Behalf
				ExtentTestManager.startTest("Scenario01 : Navigate To Timesheet On Behalf");
				boolean flag1 = Timesheet_TimesheetOnBehalf.NavigateToTimeSheetOnBehalf();
				ExtentTestManager.getTest().log(Status.PASS, "Timesheet On Behalf page loaded : " + flag1);
				Log.info("Timesheet On Behalf page loaded : " + flag1);
				
				
				//Validate Search Employee And Add Timesheet On Behalf
				ExtentTestManager.startTest("Scenario02 : Searching Employee And Adding Timesheet On Behalf");
				boolean flag2 = Timesheet_TimesheetOnBehalf.ValidateSearchEmployeeForAddingTimesheetOnBehalf(empName);
				ExtentTestManager.getTest().log(Status.PASS, "Searched employee for submitting Timesheet on Behalf  : " + flag2);
				Log.info("Searched employee for submitting Timesheet on Behalf : " + flag2);
				
				
				boolean flag3 = Timesheet_TimesheetOnBehalf.ValidateAddTimesheetOnBehalfOfSearchedEmployee(projectName, moduleName, empName);
				ExtentTestManager.getTest().log(Status.PASS, "Searched employee for submitting Timesheet on Behalf  : " + flag3);
				Log.info("Searched employee for submitting Timesheet on Behalf : " + flag3);
				


				// Logout

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
