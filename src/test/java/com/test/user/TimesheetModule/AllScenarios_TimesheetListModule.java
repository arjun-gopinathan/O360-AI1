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
import com.Utility.Log;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;

public class AllScenarios_TimesheetListModule extends Base_Class {
	com.Utility.ExcelReader ExcelReader;
	Base_Class Base_Class;
	Log log;
	TestListener TestListener;
	com.Utility.ScreenShot screenShot;
	TimeSheet_ListModule TimeSheet_ListModule;
	ExtentTest extenttest;
	private static By userDropDown = By.xpath("//div[@id='userDropdown']/h4");
	private static By L_signout = By.xpath("//button[@class='dropdown-item ' and contains(text(),'Sign out')]");
	
	@BeforeSuite
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("TimeSheetModule");
		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();
		TimeSheet_ListModule= new TimeSheet_ListModule();

	}
	@BeforeMethod
	public void setupTest(Method method) throws Exception {
		// Start a new ExtentTest for the current test method
		extenttest = ExtentTestManager.startTest(method.getName()).assignCategory("Timesheet List Module");		
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
				
				
				
			// Pick up the First Step
			ExtentTestManager.startTest("TestScenario01 : Validate Dashboard Section Display");
			boolean flag1 = TimeSheet_ListModule.isTimesheetSectionDisplayed();
			ExtentTestManager.getTest().log(Status.PASS, "Dashboard Section is Displayed : " + flag1);
			Log.info("Dashboard Section is Displayed : " + flag1);	
	
			// Validate the Timesheet Scetion Displayed or Not
			ExtentTestManager.startTest("TestScenario02 : Validate Timesheet Section Display");
			boolean flag2 = TimeSheet_ListModule.clickTimesheetSection();
			ExtentTestManager.getTest().log(Status.PASS, "Timesheet Section is Displayed : " + flag2);		
			Log.info("Timesheet Section is Displayed : " + flag2);
			
			// Test Timesheet Content Verification
			ExtentTestManager.startTest("TestScenario03 : Test Timesheet Content Verification");
			boolean flag3 = TimeSheet_ListModule.areViewOptionsDisplayed();
			ExtentTestManager.getTest().log(Status.PASS, "All views (Day, Week, Month) should be listed : " + flag3);		
			Log.info("Test Timesheet Content Verification : " + flag3);
			
			// Test Timesheet Content Verification
			ExtentTestManager.startTest("TestScenario04 : Create New Entry button should be visible");
			boolean flag4 = TimeSheet_ListModule.isCreateNewEntryButtonDisplayed();
			ExtentTestManager.getTest().log(Status.PASS, "Create New Entry button should be visible : " + flag4);		
			Log.info("Create New Entry button should be visible: " + flag4);
			
			// Bulk Upload button should be visible
			ExtentTestManager.startTest("TestScenario05 : Bulk Upload button should be visible");
			boolean flag5 = TimeSheet_ListModule.isBulkUploadButtonDisplayed();
			ExtentTestManager.getTest().log(Status.PASS, "Bulk Upload button should be visible : " + flag5);		
			Log.info("Bulk Upload button should be visible " + flag5);
			
			// Download Timesheet button should be visible
			ExtentTestManager.startTest("TestScenario06 : Download Timesheet button should be visible");
			boolean flag6 = TimeSheet_ListModule.isDownloadTimesheetButtonDisplayed();
			ExtentTestManager.getTest().log(Status.PASS, "Download Timesheet button should be visible : " + flag6);		
			Log.info("Download Timesheet button should be visible " + flag6);
			
			// Download Timesheet button should be visible
			ExtentTestManager.startTest("TestScenario07 : Apply Leave button should be visible");
			boolean flag7 = TimeSheet_ListModule.isApplyLeaveButtonDisplayed();
			ExtentTestManager.getTest().log(Status.PASS, "Download Timesheet button should be visible : " + flag7);		
			Log.info("Download Timesheet button should be visible " + flag7);
			
			// Download Timesheet button should be visible
			ExtentTestManager.startTest("TestScenario08 : Verify weekly view content if applicable");
			boolean flag8 = TimeSheet_ListModule.clickWeekViewOption();
			ExtentTestManager.getTest().log(Status.PASS, "Verify weekly view content if applicable : " + flag8);		
			Log.info("Verify weekly view content if applicable " + flag8);
			
			// Download Timesheet button should be visible
			ExtentTestManager.startTest("TestScenario09 : verify monthly view content if applicable");
			TimeSheet_ListModule.isTimesheetSectionDisplayed();
			Thread.sleep(4000);
			boolean flag9 = TimeSheet_ListModule.clickMonthViewOption();
			ExtentTestManager.getTest().log(Status.PASS, "verify monthly view content if applicable : " + flag9);		
			Log.info("verify monthly view content if applicable " + flag9);
			
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

