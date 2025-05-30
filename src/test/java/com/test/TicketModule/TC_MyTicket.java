package com.test.TicketModule;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.BasePackage.Base_Class;
import com.Page_Repositary.Locators_TicketPage;
import com.Pages.Methods.Methods_CreateTicket;
import com.Pages.Methods.Methods_HomePage;
import com.Pages.Methods.Methods_MyTicketsPage;
import com.Utility.Log;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;

public class TC_MyTicket extends Base_Class {
	
	Methods_MyTicketsPage methods_MyTicketsPage;
	Locators_TicketPage locators_TicketPage;
	Log log;
	com.Utility.ScreenShot screenshot;
	com.Utility.ExcelReader ExcelReader;
	Methods_HomePage methods_HomePage;
	Methods_CreateTicket methods_CreateTicket;
	ExtentTest extenttest;
	SoftAssert Assert = new SoftAssert();

	// Setup method to initialize objects and perform setup
	@BeforeSuite

	public void reference() throws InterruptedException {

		methods_MyTicketsPage = new Methods_MyTicketsPage();
		locators_TicketPage = new Locators_TicketPage();
		methods_HomePage = new Methods_HomePage();
		log = new Log();		
		screenshot = new com.Utility.ScreenShot(driver);
		ExcelReader = new com.Utility.ExcelReader("MyTickets");	
		 methods_CreateTicket = new Methods_CreateTicket();
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
				
		//	String subject = testdata.get("Subject").toString();
		//	String category = testdata.get("Category").toString();
		//	String ticketType = testdata.get("Ticket Type").toString();
		//	String priorityType = testdata.get("Priority Type").toString();
		//	String description = testdata.get("Add Description").toString();
			String ticketStatus = testdata.get("Ticket Status").toString();
			String ticket = testdata.get("Tickets").toString();
			String ticketId =testdata.get("Ticket ID").toString();
			//String ticketNumber =testdata.get("Ticket Number").toString();
			
			if (testdata.get("Run").toString().equalsIgnoreCase("Yes")) {
				ExtentTestManager.startTest(testdata.get("TestScenario").toString());
				Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");
				context.setAttribute("fileName", "Login");
				Base_Class.SetUp("MyTickets");
				ExtentTestManager.getTest().log(Status.PASS, "Successfully Logged in");
				 
				ExtentTestManager.startTest("Handling Covid popup and Desktop notifications");
				handlePopupCovid();
				Thread.sleep(1000);
				handlePopupDesktop();
				Thread.sleep(2000);
				   
				ExtentTestManager.startTest("TC -1 Navigate to Ticket Menu and My Tickets page");
				methods_MyTicketsPage.navigateMyTickets();
				
				ExtentTestManager.startTest("TC -2 Validating my tickets page is displayed or not");
				methods_MyTicketsPage.verifyMyTicketsPage();
								
				ExtentTestManager.startTest("TC- 3 Validate ticket status and ticket open");
				methods_MyTicketsPage.valiadteTicketStatusandTickets(ticketStatus, ticket);
				
				ExtentTestManager.startTest("TC- 4 Validate downlaod Tickets");
				methods_MyTicketsPage.downloadTickets();
				
				ExtentTestManager.startTest("TC- 5 Verify Default Search Field Selection");
				methods_MyTicketsPage.clickSearchIcon();
				methods_MyTicketsPage.isSearchDialogOpened();
				methods_MyTicketsPage.isSearchColumnSelectedByDefault();
				methods_MyTicketsPage.isSearchTypeSelectedByDefault();
				
				ExtentTestManager.startTest("TC- 6  Search By Tickets");
				
				methods_CreateTicket.searchTicket(ticketId);
				methods_MyTicketsPage.clickSearchButton();
				methods_MyTicketsPage.verifysearchedTicketNumberDisplayed(ticketId);
				
				ExtentTestManager.startTest("TC- 7 Access searched ticket page");
				methods_MyTicketsPage.clickOnSearchedTicket();
				methods_MyTicketsPage.verifyTicketdetails();
				
				ExtentTestManager.startTest("TC- 8 Verify non-editable fields");
				methods_MyTicketsPage.areFieldsNonEditable();
								
				
				ExtentTestManager.startTest(" Logout the Credentials ");
				System.out.println(("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***"));
				Signout();
				ExtentTestManager.endTest();
				ExtentManager.createInstance().flush();
				Log.info("*** Test Suite completed successfully ***");
				ExtentTestManager.getTest().log(Status.PASS, "Browser closed as test excution passed ");
				Log.info("Browser closed as test excution passed ");
				driver.quit();
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
