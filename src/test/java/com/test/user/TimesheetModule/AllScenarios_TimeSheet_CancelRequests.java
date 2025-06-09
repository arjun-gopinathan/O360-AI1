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
import com.Pages_TimesheetModule.Timesheet_CancelRequestModule;
import com.Utility.Log;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;


public class AllScenarios_TimeSheet_CancelRequests extends Base_Class  {
	
	com.Utility.ExcelReader ExcelReader;
	Base_Class Base_Class;
	Timesheet_CancelRequestModule TimeSheet_CancelRequests;
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
		ExcelReader = new com.Utility.ExcelReader("Timesheet_CancelRequests");		
		log=new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);	
		Base_Class = new Base_Class();
		TimeSheet_CancelRequests = new Timesheet_CancelRequestModule();

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
								
		//Timesheet38 - Validate if PMO is able to approve canceled timesheet submitted by employee
				ExtentTestManager.startTest("Validating if PMO is able to Cancel timesheet"); 
				//Perform as Employee
				boolean flag1 = TimeSheet_CancelRequests.NavigateToMyTimeSheet();
				
				//TimeSheet_MyTimeSheet.ValidatePreviousWeekTimeSheetWeeklyNormalView(" Invoice_Test_T&M "," Module 1 ",null);
				//TimeSheet_CancelRequests.ValidatePreviousWeekTimeSheetWeeklyNormalView(projectName,moduleName,null);
				context.setAttribute("fileName", "Logout"); 
				click(userDropDown);
				click(L_signout);
				String UserName = configloader().getProperty("PMOUserName");
				String Password = configloader().getProperty("PMOPassword");
				input(L_username, UserName);
				input(L_password, Password);
				click(L_SignIn);
				boolean flag2 = TimeSheet_CancelRequests.NavigateToCancelRequest();
				ExtentTestManager.getTest().log(Status.PASS, "Cancel Request page loaded : " + flag2);
				Log.info("Cancel Request page loaded : " + flag2);
				//TimeSheet_MyTimeSheet.ApproveReject("Drishya Devan","Approve");
				TimeSheet_CancelRequests.ApproveReject(EmployeeName,"Approve");
				ExtentTestManager.getTest().log(Status.PASS, "Cancel Request Approved !!! ");
				Log.info("Cancel Request Approved !!! ");
				
				click(userDropDown);
				click(L_signout);
				

	

		//Timesheet39 - Validate if PMO is able to Reject Canceled timesheet submitted by employee
				String EmpUserName = configloader().getProperty("UserName");
				String EmpPassword = configloader().getProperty("Password");
				input(L_username, EmpUserName);
				input(L_password, EmpPassword);
				click(L_SignIn);
				ExtentTestManager.startTest("Validating if PMO is able to Approve timesheet"); 
				//Perform as Employee
				boolean flag3 = TimeSheet_CancelRequests.NavigateToMyTimeSheet();
				TimeSheet_CancelRequests.ValidatePreviousWeekTimeSheetWeeklyNormalView(projectName,moduleName,null);
				context.setAttribute("fileName", "Logout"); 
				click(userDropDown);
				click(L_signout);
				//Perform Approval as PMO
				String PMOUserName = configloader().getProperty("PMOUserName");
				String PMOPassword = configloader().getProperty("PMOPassword");
				input(L_username, PMOUserName);
				input(L_password, PMOPassword);
				click(L_SignIn);
				boolean flag4 = TimeSheet_CancelRequests.NavigateToCancelRequest();
				ExtentTestManager.getTest().log(Status.PASS, "Cancel Request page loaded : " + flag4);
				Log.info("Cancel Request page loaded : " + flag4);
				TimeSheet_CancelRequests.CancelRequestReject(EmployeeName,"Reject");
				ExtentTestManager.getTest().log(Status.PASS, "Cancel Request Rejected !!! ");
				Log.info("Cancel Request Rejected !!! ");
			
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
