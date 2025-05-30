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
import com.Pages_TimesheetModule.TimeSheet_ListModule;
import com.Pages_TimesheetModule.Timesheet_CreateModule;
import com.Pages_TimesheetModule.Timesheet_EditDeleteModule;
import com.Utility.Log;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;

public class AllScenarios_TimesheetEditDeleteModule extends Base_Class {
	com.Utility.ExcelReader ExcelReader;
	Base_Class Base_Class;
	Log log;
	TestListener TestListener;
	com.Utility.ScreenShot screenShot;
	TimeSheet_ListModule TimeSheet_ListModule;
	Timesheet_CreateModule Timesheet_CreateModule;
	Timesheet_EditDeleteModule Timesheet_EditDeleteModule;
	ExtentTest extenttest;
	private static By userDropDown = By.xpath("//div[@id='userDropdown']/h4");
	private static By L_signout = By.xpath("//button[@class='dropdown-item ' and contains(text(),'Sign out')]");
	
	@BeforeSuite
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("TimeSheeEditDelete");
		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();
		
		TimeSheet_ListModule= new TimeSheet_ListModule();
		Timesheet_CreateModule= new Timesheet_CreateModule();
		Timesheet_EditDeleteModule= new Timesheet_EditDeleteModule();
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
				
				String project = testdata.get("project").toString();
				String moduleName = testdata.get("moduleName").toString();
				String module = testdata.get("module").toString();
				String workDescription = testdata.get("workDescription").toString();
				String hours = testdata.get("hours").toString();
				String minutes = testdata.get("minutes").toString();
				String date = testdata.get("date").toString();
				String date1 = testdata.get("date1").toString();
				
				// Validate Edit Button Display
				ExtentTestManager.startTest("TestScenario01 : Validate Edit Button Display");
				TimeSheet_ListModule.clickTimesheetSection();
				boolean flag1 = Timesheet_EditDeleteModule.isEditButtonDisplayed();
				ExtentTestManager.getTest().log(Status.PASS, "Validate Edit Button Display : " + flag1);
				Log.info("Validate Edit Button Display : " + flag1);	
		
				// Validate Delete Button Display
				ExtentTestManager.startTest("TestScenario02 : Validate Timesheet Section Display");
				boolean flag2 = Timesheet_EditDeleteModule.isDeleteButtonDisplayed();
				ExtentTestManager.getTest().log(Status.PASS, "Timesheet Section is Displayed : " + flag2);		
				Log.info("Timesheet Section is Displayed : " + flag2);
				
				// Click on Save button In the Edit Page
				ExtentTestManager.startTest("TestScenario03 : Click on Save button In the Edit Page");
				Timesheet_EditDeleteModule.clickEditButton();
				boolean flag3 = Timesheet_EditDeleteModule.clickSave();
				ExtentTestManager.getTest().log(Status.PASS, "Click on Save button In the Edit Page : " + flag3);		
				Log.info("Click on Save button In the Edit Page : " + flag3);
				
				// Edit with Close Functionality
				ExtentTestManager.startTest("TestScenario04 : Edit Functionality");
				Timesheet_EditDeleteModule.enterWorkDescription(workDescription);
				Timesheet_EditDeleteModule.enterHours(hours);
				Timesheet_EditDeleteModule.enterMinutes(minutes);
				boolean flag4 = Timesheet_EditDeleteModule.clickClose();
				ExtentTestManager.getTest().log(Status.PASS, "Edit Functionality : " + flag4);		
				Log.info("Edit Functionality : " + flag4);
				
				// Edit Mandatory Fields Functionality
				ExtentTestManager.startTest("TestScenario05 : Edit Functionality");
				Timesheet_EditDeleteModule.enterWorkDescription(workDescription);
				Timesheet_EditDeleteModule.enterHours1();
				boolean flag5 =	Timesheet_EditDeleteModule.clickSave();
				ExtentTestManager.getTest().log(Status.PASS, "Edit Functionality : " + flag5);		
				Log.info("Edit Functionality : " + flag5);
				
				//Delete and Create Functionality
				ExtentTestManager.startTest("TestScenario06 : Delete and Create Functionality");
				Timesheet_EditDeleteModule.DeleteButtonYes();
				Thread.sleep(2000);
				Timesheet_CreateModule.clicOnNewButton();
				Thread.sleep(1000);
				Timesheet_CreateModule.selectProject(project);
				Thread.sleep(1000);
				Timesheet_CreateModule.selectModule(moduleName,module);
				Thread.sleep(1000);
				Timesheet_CreateModule.enterWorkDescription(workDescription);
				Thread.sleep(1000);
				Timesheet_CreateModule.enterHours(hours);
				Thread.sleep(1000);
				Timesheet_CreateModule.enterMinutes(minutes);
				Thread.sleep(1000);
				Timesheet_CreateModule.uploadFile("\\src\\test\\resources\\e-sign.pdf");
				Thread.sleep(1000);
//				Timesheet_CreateModule.selectDateWithinCurrentWeek(date);
//				Thread.sleep(1000);
				boolean flag6 =Timesheet_CreateModule.clickSave();
				Thread.sleep(2000);
				ExtentTestManager.getTest().log(Status.PASS, "Edit Functionality : " + flag6);		
				Log.info("Edit Functionality : " + flag6);
				
				//Again Delete Functionality for the No button.
				ExtentTestManager.startTest("TestScenario06 : Delete and Create Functionality");
				boolean flag7 =Timesheet_EditDeleteModule.DeleteButtonNo();
				ExtentTestManager.getTest().log(Status.PASS, "Deleted Functionality for No : " + flag7);		
				Log.info("Deleted Functionality for No : " + flag7);
				Thread.sleep(2000);
			
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
