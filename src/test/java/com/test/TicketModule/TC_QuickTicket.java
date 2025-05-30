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
import com.Pages.Methods.Methods_AssignedTickets;
import com.Pages.Methods.Methods_CreateTicket;
import com.Pages.Methods.Methods_HomePage;
import com.Pages.Methods.Methods_MyTicketsPage;
import com.Pages.Methods.Methods_QuickTickets;
import com.Utility.Log;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;

public class TC_QuickTicket extends Base_Class{

	Methods_QuickTickets methods_QuickTickets;
	Locators_TicketPage locators_TicketPage;
	Log log;
	com.Utility.ScreenShot screenshot;
	com.Utility.ExcelReader ExcelReader;
	Methods_HomePage methods_HomePage;
	Methods_CreateTicket methods_CreateTicket;
    Methods_AssignedTickets methods_AssignedTickets;
    Methods_MyTicketsPage methods_MyTicketsPage;
    ExtentTest extenttest;
	SoftAssert Assert = new SoftAssert();

	// Setup method to initialize objects and perform setup
	@BeforeSuite

	public void reference() throws InterruptedException {

		methods_QuickTickets = new Methods_QuickTickets();
		methods_CreateTicket=new Methods_CreateTicket();
		locators_TicketPage = new Locators_TicketPage();
		methods_HomePage = new Methods_HomePage();
		methods_AssignedTickets=new Methods_AssignedTickets();
		methods_MyTicketsPage = new Methods_MyTicketsPage();
		log = new Log();		
		screenshot = new com.Utility.ScreenShot(driver);
		ExcelReader = new com.Utility.ExcelReader("QuickTickets");		
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
				
			String subject = testdata.get("Subject").toString();
			String category = testdata.get("Category").toString();
			String ticketType = testdata.get("Ticket Type").toString();
			String priorityType = testdata.get("Priority Type").toString();
			String watcher= testdata.get("Watcher").toString();
			String ticketId = testdata.get("Dynamic Ticket Number").toString();
			String description = testdata.get("Add Description").toString();
			String dashbosardUser = testdata.get("Dashboard User").toString();
			String ticketTypeCreatedOn = testdata.get("Ticket Type Created On").toString();
			String status= testdata.get("Ticket Status").toString();
			String assignto = testdata.get("AssignTo").toString();
			String usernameAssigned = testdata.get("Assigned User").toString();
			String changeStatus = testdata.get("Change Status").toString();
			String addComments = testdata.get("Add Comments").toString();
			String changeStatus1 = testdata.get("Change Status To Resolved").toString();
			String resolveComments =testdata.get("Resolved Comments").toString();
			String user=testdata.get("User Closed tab").toString();
			String rating=testdata.get("Rating").toString();
			String taggedUser=testdata.get("Tagged User").toString();
			
				if (testdata.get("Run").toString().equalsIgnoreCase("Yes")) {
				ExtentTestManager.startTest(testdata.get("TestScenario").toString());
				Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");
				context.setAttribute("fileName", "Login");
				Base_Class.SetUp("QuickTickets");
				ExtentTestManager.getTest().log(Status.PASS, "Successfully Logged in");
				
				//Quick Tickets - New Tab
				 
				ExtentTestManager.startTest("TC-1 Handling Covid popup and Desktop notifications");
				handlePopupCovid();
				Thread.sleep(1000);
				handlePopupDesktop();
				Thread.sleep(2000);
				   
				ExtentTestManager.startTest("TC -2 Navigate to Quick tickets");
				methods_QuickTickets.navigateToTicketCreation();
											
				ExtentTestManager.startTest("TC- 3 Validate Quick tickets");
				methods_QuickTickets.valiadteQuickTickets();
				
				ExtentTestManager.startTest("TC- 4 Click on New tickets");
				methods_QuickTickets.clickNewTicket();
				
				ExtentTestManager.startTest("TC- 5 Enter the required fields for creating new ticket");
				methods_QuickTickets.enterRequiredFields(subject, category, ticketType, priorityType, watcher, description);
				Thread.sleep(1000);
				/*JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});",driver.findElement(locators_TicketPage.browse));
				WebElement uploadElement = driver.findElement(locators_TicketPage.browse);
	            Thread.sleep(1000);
		        //Click the file input to open the file dialog
		        uploadElement.click();
				Thread.sleep(1000); 
				String browseFilePath = File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "DummyPDF.pdf";
				methods_QuickTickets.uploadFileTicket(browseFilePath); */
								
				ExtentTestManager.startTest("TC- 6.submit the ticket");
				methods_QuickTickets.submitButton();
				
				ExtentTestManager.startTest("TC- 7 Validate Confirmation popup displayed");
				methods_QuickTickets.validateConfirmationPopUpDisplayed();
				
				ExtentTestManager.startTest("TC- 8 Get the ticket number from confimation message and Comfirm the message");
				methods_QuickTickets.confirmationMessageDisplayed();
				methods_QuickTickets.clickOKONConfirmationPopup();	
			
				ExtentTestManager.startTest("TC- 9 close the ticket page");
				methods_QuickTickets.quickTicketCloseButton();	
				
				ExtentTestManager.startTest("TC- 10 Click on Quick tickets");
				methods_QuickTickets.navigateToTicketCreation();
				
				ExtentTestManager.startTest("TC- 11 Navigate and click on Open tickets");
				methods_QuickTickets.navigateAndClickOnOpenTickets();
				
				ExtentTestManager.startTest("TC- 12 validate the open tickets side bar");
				methods_QuickTickets.valiadteQuickTickets();
				
				ExtentTestManager.startTest("TC- 13 Verify Default Search Field Selection");
				methods_QuickTickets.clickSearchIcon();
				methods_MyTicketsPage.isSearchDialogOpened();
				methods_MyTicketsPage.isSearchColumnSelectedByDefault();
				methods_MyTicketsPage.isSearchTypeSelectedByDefault();
				
				ExtentTestManager.startTest("TC- 14  Search By Tickets");
				methods_MyTicketsPage.searchTicket(ticketId);
				methods_MyTicketsPage.clickSearchButton();
				methods_MyTicketsPage.verifysearchedTicketNumberDisplayed(ticketId);
				
				ExtentTestManager.startTest("TC- 15 Access searched ticket page");
				methods_QuickTickets.clickOnSearchedTicket();
				
				ExtentTestManager.startTest("TC- 16 Enter the comments");
				methods_QuickTickets.enterAddComments(description);
				
				ExtentTestManager.startTest("TC- 17 close the ticket page");
				methods_QuickTickets.quickTicketCloseButton();
				methods_QuickTickets.openTicketCloseButton();
				
				ExtentTestManager.startTest("TC- 18 Signout " );
				Signout();
				
				ExtentTestManager.startTest("TC- 19 Login with Dashboard User" );
				methods_AssignedTickets.assignedUser(dashbosardUser);
				
				ExtentTestManager.startTest("TC-20 Handling Covid popup and Desktop notifications");
				handlePopupCovid();
				Thread.sleep(1000);
				handlePopupDesktop();
				Thread.sleep(2000);
				
				ExtentTestManager.startTest("TC -21 Navigate to Ticket Menu and land into Dashboard Page");
				methods_AssignedTickets.navigateTicketDashboard(); 
				
				ExtentTestManager.startTest("TC -22 Validate Dashboard page successfully landed in");
				methods_AssignedTickets.valiadteTicketDashboardPage();
														
				ExtentTestManager.startTest("TC- 23 Select the Category");
				methods_AssignedTickets.selectCategory(category);
				
				ExtentTestManager.startTest("TC- 24 Select the ticket type created on");
				methods_AssignedTickets.selectTicketCreatedOn(ticketTypeCreatedOn);
				
				ExtentTestManager.startTest("TC- 25 Search the ticket number");
				methods_AssignedTickets.searchTicketNumber(ticketId);
											
				ExtentTestManager.startTest("TC-26 Click the search icon");
				methods_AssignedTickets.clickSearchIcon();
				
				ExtentTestManager.startTest("TC- 27 Verify searched ticket number displayed");
				methods_AssignedTickets.verifysearchedTicketNumberDisplayed(ticketId);	
				
				ExtentTestManager.startTest("TC- 28 Click on searched ticket");
				methods_AssignedTickets.clickOnSearchedTicket();
					
				ExtentTestManager.startTest("TC- 29 Verify ticket details displayed");
				methods_AssignedTickets.verifyTicketdetails();	
				
				ExtentTestManager.startTest("TC- 30 Fields are non editable");
				methods_AssignedTickets.areFieldsNonEditable();
						
				ExtentTestManager.startTest("TC- 31 Select the priority type");
				methods_AssignedTickets.selectPriorityType(priorityType);
				
				ExtentTestManager.startTest("TC- 32 Select the status");
				methods_AssignedTickets.selectStatus(status);
				
				ExtentTestManager.startTest("TC- 33 Assign to concerned employee ");
				methods_AssignedTickets.selectAssignTo(assignto);
				
				ExtentTestManager.startTest("TC- 34 Submit the ticket assigned");
				methods_AssignedTickets.submitTheTicket();	
								
				ExtentTestManager.startTest("TC- 35 Click on Audit trail");
				methods_AssignedTickets.clickAuditTrail();
						
				ExtentTestManager.startTest("TC- 36 Validate Audit trail" );
				methods_AssignedTickets.valiadteAuditTrail();
				
				ExtentTestManager.startTest("TC- 37 Close on Audit trail");
				methods_AssignedTickets.close();
				
				ExtentTestManager.startTest("TC- 38 validate the ticketHistory");
				methods_AssignedTickets.ticketHistory();
				methods_AssignedTickets.validateTicketHistory();
				methods_AssignedTickets.closeDialog();
				
				ExtentTestManager.startTest("TC- 39 Validate ticket status history" );
				methods_AssignedTickets.ticketStatusHistory();
				methods_AssignedTickets.validateTicketStatusHistory();
				methods_AssignedTickets.closeDialog();
				
				ExtentTestManager.startTest("TC- 40 Close the ticket");
				methods_AssignedTickets.close();
				
				ExtentTestManager.startTest("TC- 41 Signout " );
				Signout();
				
				ExtentTestManager.startTest("TC- 42 Login with assigned User" );
				methods_AssignedTickets.assignedUser(usernameAssigned);
							
				ExtentTestManager.startTest("TC- 43 Handling Covid popup and Desktop notifications");
				handlePopupCovid();
				Thread.sleep(3000);
				handlePopupDesktop();
				Thread.sleep(3000);
				
				ExtentTestManager.startTest("TC- 44 Navigate to tickets menu and assigned tickets" );
				methods_AssignedTickets.navigateToAssignedTicketsMenu();
				
				ExtentTestManager.startTest("TC- 45 Validate assigned tickets page landed successfully" );
				methods_AssignedTickets.valiadteAssignedTicketPage(); 
				
				ExtentTestManager.startTest("TC- 46 Download all assigned tickets" );
				methods_AssignedTickets.downloadTickets();
				
				ExtentTestManager.startTest("TC- 47 Verify Default Search Field Selection");
				methods_AssignedTickets.clickSearchTicketIcon();
				methods_AssignedTickets.isSearchDialogOpened();
				methods_AssignedTickets.isSearchColumnSelectedByDefault();
				methods_AssignedTickets.isSearchTypeSelectedByDefault();
				
				ExtentTestManager.startTest("TC- 48  Search By Tickets");
				methods_AssignedTickets.searchTicket(ticketId);
				methods_AssignedTickets.clickSearchButton();
				methods_QuickTickets.verifysearchedTicketNumberDisplayed(ticketId);
				
				ExtentTestManager.startTest("TC- 49 Access searched ticket page");
				methods_AssignedTickets.clickOnSearchedTicket();
				methods_AssignedTickets.verifyTicketdetails();
				
				ExtentTestManager.startTest("TC- 50 Verify non-editable fields");
				methods_AssignedTickets.areFieldsNonEditableAssignedTickets();
				
				ExtentTestManager.startTest("TC- 51 Change the status ");
				methods_AssignedTickets.selectStatus(changeStatus);
				
				ExtentTestManager.startTest("TC- 52 Submit the ticket ");
				methods_AssignedTickets.submitTheTicket();	
				
				ExtentTestManager.startTest("TC- 53 Add comments for ticket ");
				methods_QuickTickets.enterAddComments(addComments);
				
				ExtentTestManager.startTest("TC- 54 Change the status ");
				methods_AssignedTickets.selectStatus(changeStatus1);
				
				ExtentTestManager.startTest("TC- 55 Submit the ticket ");
				methods_AssignedTickets.submitTheTicket();
				
				ExtentTestManager.startTest("TC- 56 Add resolved comments");
				methods_QuickTickets.resolvedAddComments(resolveComments);
					
				ExtentTestManager.startTest("TC- 57 Close the ticket");
				methods_AssignedTickets.close();
				
				ExtentTestManager.startTest("TC- 58 Signout " );
				Signout();                          
				
				// Quick Tickets- Closed tab
				
				ExtentTestManager.startTest("TC- 59 Logged in as user again" );
				methods_QuickTickets.userClosed(user);
						
				ExtentTestManager.startTest("TC- 60 Handling Covid popup and Desktop notifications");
				handlePopupCovid();
				Thread.sleep(1000);
				handlePopupDesktop();
				Thread.sleep(2000);
				   
				ExtentTestManager.startTest("TC - 61 Navigate to Quick tickets");
				methods_QuickTickets.navigateToTicketCreation();
											
				ExtentTestManager.startTest("TC- 62 Validate Quick tickets");
				methods_QuickTickets.valiadteQuickTickets();
				
				ExtentTestManager.startTest("TC- 63 Click on Closed tab");
				methods_QuickTickets.closedTabLink();
				
				ExtentTestManager.startTest("TC- 64 Verify Default Search Field Selection");
				methods_QuickTickets.clickSearchIcon();
				methods_MyTicketsPage.isSearchDialogOpened();
				methods_MyTicketsPage.isSearchColumnSelectedByDefault();
				methods_MyTicketsPage.isSearchTypeSelectedByDefault();
				
				ExtentTestManager.startTest("TC- 65  Search By Tickets");
				methods_MyTicketsPage.searchTicket(ticketId);
				methods_MyTicketsPage.clickSearchButton();
				methods_MyTicketsPage.verifysearchedTicketNumberDisplayed(ticketId);
				
				ExtentTestManager.startTest("TC- 66 Access searched ticket page");
				methods_QuickTickets.clickOnSearchedTicket();
				
				ExtentTestManager.startTest("TC- 66 Verify Reopen button is visible");
				methods_QuickTickets.verifyReopenButton();
				
				ExtentTestManager.startTest("TC- 67 Click on Rate and close ticket");
				methods_QuickTickets.rateAndClose(rating);
				
				ExtentTestManager.startTest("TC- 68 Click on save and close ticket");
				methods_QuickTickets.saveAndClose();
				
				ExtentTestManager.startTest("TC- 69 Close the ticket");
				methods_QuickTickets.openTicketCloseButton();
								
				ExtentTestManager.startTest("TC- 70 Signout " );
				Signout();
				
				ExtentTestManager.startTest("TC- 71 Logged in as tagged user" );
				methods_QuickTickets.taggedUser(taggedUser);
						
				ExtentTestManager.startTest("TC-72 Handling Covid popup and Desktop notifications");
				handlePopupCovid();
				Thread.sleep(1000);
				handlePopupDesktop();
				Thread.sleep(2000);
				   
				ExtentTestManager.startTest("TC -73 Navigate to Quick tickets");
				methods_QuickTickets.navigateToTicketCreation();
											
				ExtentTestManager.startTest("TC- 74 Validate quick tickets");
				methods_QuickTickets.valiadteQuickTickets();
				
				ExtentTestManager.startTest("TC- 75 Click on tagged tab");
				methods_QuickTickets.taggedTabMenu();
				
				ExtentTestManager.startTest("TC- 76 Verify Default Search Field Selection");
				methods_QuickTickets.clickSearchIcon();
				methods_MyTicketsPage.isSearchDialogOpened();
				methods_MyTicketsPage.isSearchColumnSelectedByDefault();
				methods_MyTicketsPage.isSearchTypeSelectedByDefault();
				
				ExtentTestManager.startTest("TC-77 Search By Tickets");
				methods_MyTicketsPage.searchTicket(ticketId);
				methods_MyTicketsPage.clickSearchButton();
				methods_MyTicketsPage.verifysearchedTicketNumberDisplayed(ticketId);
				
				ExtentTestManager.startTest("TC- 78 Access searched tagged ticket page");
				methods_QuickTickets.clickOnSearchedTicket();
				
				ExtentTestManager.startTest("TC- 79 Close the ticket");
				methods_QuickTickets.openTicketCloseButton();
				methods_QuickTickets.openTicketCloseButton();
				
				ExtentTestManager.startTest(" Logout the Credentials ");
				System.out.println(("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***"));
				Thread.sleep(2000);
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
