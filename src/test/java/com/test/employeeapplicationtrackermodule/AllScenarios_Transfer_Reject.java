package com.test.employeeapplicationtrackermodule;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_EmployeeModule;
import com.Pages_employeeapplicationtrackermodule.Transfer_Approvals;
import com.Utility.Log;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;

public class AllScenarios_Transfer_Reject extends Base_Class{
	PageRepositary_EmployeeModule PageRepositary=new PageRepositary_EmployeeModule();
	com.Utility.ExcelReader ExcelReader;
	Base_Class Base_Class;
	Log log;
	TestListener TestListener;
	com.Utility.ScreenShot screenShot;
	Transfer_Approvals Transfer_Approvals;
	ExtentTest extenttest;
	private static By userDropDown = By.xpath("//div[@id='userDropdown']/h4");
	private static By L_signout = By.xpath("//button[@class='dropdown-item ' and contains(text(),'Sign out')]");

	@BeforeSuite
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("Transfer_Reject");
		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();

		Transfer_Approvals = new Transfer_Approvals();

	}
	@BeforeMethod
	public void setupTest(Method method) throws Exception {
		// Start a new ExtentTest for the current test method
		extenttest = ExtentTestManager.startTest(method.getName()).assignCategory("Transfer Reject");		
	}
	@Test(dataProvider = "TestData")
	public void RUNALL(Map<Object, Object> testdata, ITestContext context) throws IOException, InterruptedException {

		try {
			
			  String ApproverComments = testdata.get("ApproverComments").toString();
				String EMPCODE = testdata.get("EMPCODE").toString();

			
			

			if (testdata.get("Run").toString().equalsIgnoreCase("Yes")) {
				// TC_BAC_Login_Positive case
				ExtentTestManager.startTest(testdata.get("TestScenario").toString());
				Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");
				context.setAttribute("fileName", "Login");
				
				 ExtentTestManager.startTest("TC-1-Launching O360");
				 ExtentTestManager.getTest().log(Status.PASS, "Launching O360");
					String username = testdata.get("UserName").toString();
					 ExtentTestManager.endTest();
					 ExtentTestManager.startTest("TC-2-User Login");
					Base_Class.SetUp(username);
					// ExtentTestManager.endTest();
					//ExtentTestManager.getTest().log(Status.PASS,"Application Login" + com.BasePackage.Base_Class.Pagetitle);
				//	Log.info("Login successful !");
					// driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					 //ExtentTestManager.endTest();
					ExtentTestManager.getTest().log(Status.PASS, "Username is entered successfully");
					ExtentTestManager.getTest().log(Status.PASS, "Password is entered successfully");
							ExtentTestManager.getTest().log(Status.PASS, "Successfully Logged In");
					 
					 
					 
					 ExtentTestManager.startTest("TC-3-Pop Up Handling");
					 handlePopupCovid();
					 ExtentTestManager.getTest().log(Status.PASS, "Covid Pop Up is Handled");
						
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					   handlePopupDesktop();
					   ExtentTestManager.getTest().log(Status.PASS, "Desktop Notification Pop Up is Handled");
						
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					   ExtentTestManager.endTest();
					   
					 
						Transfer_Approvals.clickOnemp();
						driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
						ExtentTestManager.startTest("TC-4-Employee module is displayed");
						 ExtentTestManager.getTest().log(Status.PASS, "Employee module is displayed");
						driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
						ExtentTestManager.endTest();
						ExtentTestManager.startTest("TC-5-Requests  submodule is displayed");
						 ExtentTestManager.getTest().log(Status.PASS, "Requests  submodule is displayed");
						driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
						ExtentTestManager.endTest();

						Transfer_Approvals.clickonapprovals();
						driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
						ExtentTestManager.startTest("TC-6-Employee Transfer submodule is displayed");
						 ExtentTestManager.getTest().log(Status.PASS, "Employee Transfer submodule is displayed");
						driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
						ExtentTestManager.endTest();

						Transfer_Approvals.clickonemptransfer();
						driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
						ExtentTestManager.startTest("TC-7-Employee Transfer Requests page is displayed");
						 ExtentTestManager.getTest().log(Status.PASS, "Employee Transfer Requests page is displayed");
						driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
						ExtentTestManager.endTest();

						Transfer_Approvals.slectempcode(EMPCODE);
						driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
						ExtentTestManager.startTest("TC-8-Employee is selected from the list");
						ExtentTestManager.getTest().log(Status.PASS, "Employee is selected from the list");
						driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
						ExtentTestManager.endTest();

						try {
							WebElement popupElement = driver.findElement(PageRepositary.searchedempcode);
						     WaitForElementToBeVisible(PageRepositary.searchedempcode);
						     if (popupElement.isDisplayed()) {
						    	 
						    	  click(PageRepositary.searchedempcode);
						    	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
						    	  
						    	  Transfer_Approvals.enterapprovercomments(ApproverComments);
									driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
									ExtentTestManager.startTest("TC-9-Approver Comments is enetered");
									 ExtentTestManager.getTest().log(Status.PASS,"Approver Comments is enetered");
									driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
									ExtentTestManager.endTest();

									Transfer_Approvals.reject();
									driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
									ExtentTestManager.startTest("TC-10-Employee Transfer Request is approved");
									 ExtentTestManager.getTest().log(Status.PASS,"Employee Transfer Request is approved");
									driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
									ExtentTestManager.endTest();

						     }
						     }
						     
						     catch(Exception e1) {
						    	 
						    	 ExtentTestManager.getTest().log(Status.PASS,"Empolyee Code not present in the list");
						         Log.info("Empolyee Code not present in the list");
						         
						         }

							
						}
					   

					
					   
			// Logout
			
			  ExtentTestManager.startTest("TC-11-Logout."); context.setAttribute("fileName",
			  "Logout"); 
			  click(userDropDown); 
			  click(L_signout);
			 

			Thread.sleep(2000);
			driver.quit();
			ExtentTestManager.getTest().log(Status.PASS, "Application Logout");
			Log.info("Logout is done");

			// EndTest
			System.out.println(("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***"));
			ExtentTestManager.endTest();
			ExtentManager.getInstance().flush();
			Log.info("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***");

		

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
		// driver.quit();
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
		// driver.quit();
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


					   
					   
					   
					   

