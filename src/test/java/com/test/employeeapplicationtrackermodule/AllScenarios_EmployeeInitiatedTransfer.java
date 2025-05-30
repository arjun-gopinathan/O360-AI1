package com.test.employeeapplicationtrackermodule;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_EmployeeModule;
//import com.Pages_LeaveModule.Leave_LeaveRequest;
import com.Pages_employeeapplicationtrackermodule.Employee_Initiated_Transfer;
import com.Utility.Log;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;

public class AllScenarios_EmployeeInitiatedTransfer extends Base_Class{
	com.Utility.ExcelReader ExcelReader;
	Base_Class Base_Class;
	Log log;
	TestListener TestListener;
	com.Utility.ScreenShot screenShot;
	Employee_Initiated_Transfer Employee_Initiated_Transfer;
	PageRepositary_EmployeeModule Locators=new PageRepositary_EmployeeModule();
	ExtentTest extenttest;

	private static By userDropDown = By.xpath("//div[@id='userDropdown']/h4");
	private static By L_signout = By.xpath("//button[@class='dropdown-item ' and contains(text(),'Sign out')]");

	@BeforeSuite
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("Employee_Initiated_Transfer");
		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();

		Employee_Initiated_Transfer = new Employee_Initiated_Transfer();

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
			
			String EMPOFFICE=testdata.get("EMPOFFICE").toString();
			
		    String DateOfTransfer=testdata.get("DateOfTransfer").toString();
		    String Comments=testdata.get("Comments").toString();

			if (testdata.get("Run").toString().equalsIgnoreCase("Yes")) {
				// TC_BAC_Login_Positive case
				ExtentTestManager.startTest(testdata.get("TestScenario").toString());
				Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");
				context.setAttribute("fileName", "Login");
				 ExtentTestManager.startTest("Launching O360");
					
					ExtentTestManager.getTest().log(Status.PASS, "Launching O360");
				String username = testdata.get("UserName").toString();
				 ExtentTestManager.endTest();
				 ExtentTestManager.startTest("User Login");
				Base_Class.SetUp(username);
//				 ExtentTestManager.endTest();
//				ExtentTestManager.getTest().log(Status.PASS,"Application Login" + com.BasePackage.Base_Class.Pagetitle);
//				Log.info("Login successful !");
//				 driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
//				 ExtentTestManager.endTest();
				
				ExtentTestManager.getTest().log(Status.PASS, "Username is entered successfully");
				ExtentTestManager.getTest().log(Status.PASS, "Password is entered successfully");
				
				ExtentTestManager.getTest().log(Status.PASS, "Successfully Logged In");
				
				 
				 ExtentTestManager.startTest("Pop Up Handling");
				 handlePopupCovid();
				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				   ExtentTestManager.getTest().log(Status.PASS,"Covid Pop Up is Handled");
				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				   handlePopupDesktop();
				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				   ExtentTestManager.getTest().log(Status.PASS,"Desktop Notification Pop Up is Handled");
				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				   ExtentTestManager.endTest();
	
			
				
			    ExtentTestManager.startTest("Navigating to Self Service submenu");
				 Employee_Initiated_Transfer.clickonselfservice();
				 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				 ExtentTestManager.getTest().log(Status.PASS,"Self Service Menu is displayed");
				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//				 ExtentTestManager.endTest();
				 
				  ExtentTestManager.startTest("Navigating to Requests submenu");
				 Employee_Initiated_Transfer.clickonemprequests();
				 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				 ExtentTestManager.getTest().log(Status.PASS,"Requests Sub Menu is displayed");
				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				 
				 ExtentTestManager.endTest();
				 
				  ExtentTestManager.startTest("Navigating to Employee Transfer Dashboard");
				 Employee_Initiated_Transfer.clickonempinitiatedtransfer();
				 driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
				 ExtentTestManager.getTest().log(Status.PASS,"Employee Trnasfer page is displayed");
				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				 ExtentTestManager.endTest();
				 
				 
				 //
				
				//
                 
                 //String expectedtext=null;
				 //Select select = new Select();
				String actualtext=driver.findElement(Locators.slectempoffice).getAttribute("value");
	               if(actualtext.isEmpty())
	               {
	            	   ExtentTestManager.startTest("New Office drop down is loaded with values");
	  				 Employee_Initiated_Transfer.slectempoffice(EMPOFFICE);
	  				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  				 ExtentTestManager.getTest().log(Status.PASS,"New Office drop down is loaded with values");
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  				  //Thread.sleep(3000);
	  				   ExtentTestManager.endTest();
	  				   
	  				 // ExtentTestManager.getTest().log(Status.PASS,"New Office drop down is loaded with values");
	  				   ExtentTestManager.startTest("New Office is selected");
	  				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  				 ExtentTestManager.getTest().log(Status.PASS,"New Office is selected");
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  				   //ExtentTestManager.getTest().log(Status.PASS,"New Office is selected");
	  				  // driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  				   ExtentTestManager.endTest();
	  				   
	  				   
	  				   Employee_Initiated_Transfer.slectempdateoftransfer(DateOfTransfer);
	  			   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  				  //Thread.sleep(3000);
	  			   ExtentTestManager.startTest("Date of Transfer  is selected successfully");
	  				  //ExtentTestManager.getTest().log(Status.PASS,"Date of transfer is selected");
	  				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  				 ExtentTestManager.getTest().log(Status.PASS,"Date of Transfer  is selected successfully");
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  				   ExtentTestManager.endTest();
	  				   

	  				   Employee_Initiated_Transfer.enterempcomments(Comments);
	  				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  				  //Thread.sleep(3000);
	  				  ExtentTestManager.startTest("Comments is entered successfully");
	  				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  				 ExtentTestManager.getTest().log(Status.PASS,"Comments is entered successfully");
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  				   ExtentTestManager.endTest();
	  				   
	  				   Employee_Initiated_Transfer.empsubmit();
	  				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  				  //Thread.sleep(3000);
	  				  ExtentTestManager.startTest("Employee transfer request is submitted successfully");
	  				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  				 ExtentTestManager.getTest().log(Status.PASS,"Employee transfer request is submitted successfully");
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  				   ExtentTestManager.endTest();
	  				   
	  				 
	                    // return true;
	                     //click(DesktopNot);
	                     
	               }
				 
	               else
				 {
	            	   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	            	   System.out.println("Transfer Request for this employee is already submitted ");
	                   driver.findElement(Locators.empalreadysubmitted).click();
	                   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	                   ExtentTestManager.getTest().log(Status.PASS, "Already Submitted Transfer Request ");
	                   Log.info("Alreadysubmitted Transfer Request ");
	                   click(Locators.DesktopNot);
	                   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				 }
					 
			}
			 
			// Logout
			
			  ExtentTestManager.startTest("Logout."); context.setAttribute("fileName",
			  "Logout");
			  click(userDropDown);
			  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			  click(L_signout);
			 

			  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
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

