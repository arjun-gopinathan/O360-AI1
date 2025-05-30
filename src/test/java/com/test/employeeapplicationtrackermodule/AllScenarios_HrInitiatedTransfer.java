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
import com.Pages_employeeapplicationtrackermodule.Employee_Initiated_Transfer;
//import com.Pages_LeaveModule.Leave_LeaveRequest;
import com.Pages_employeeapplicationtrackermodule.Hr_Initiated_Transfer;
import com.Utility.Log;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;
public class AllScenarios_HrInitiatedTransfer extends Base_Class{
	PageRepositary_EmployeeModule PageRepositary=new PageRepositary_EmployeeModule();

	com.Utility.ExcelReader ExcelReader;
	Base_Class Base_Class;
	Log log;
	TestListener TestListener;
	com.Utility.ScreenShot screenShot;
	Hr_Initiated_Transfer Hr_Initiated_Transfer;
	ExtentTest extenttest;
	private static By userDropDown = By.xpath("//div[@id='userDropdown']/h4");
	private static By L_signout = By.xpath("//button[@class='dropdown-item ' and contains(text(),'Sign out')]");

	@BeforeSuite
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("HR_Initiated_Transfer");
		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();

		Hr_Initiated_Transfer = new Hr_Initiated_Transfer();
		

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
			
			String Employee=testdata.get("Employee").toString();
			String NewBusinessUnit=testdata.get("NewBusinessUnit").toString();
			String NewOffice=testdata.get("NewOffice").toString();
		    String DateOfTransfer=testdata.get("DateOfTransfer").toString();
			String NewReportingTo=testdata.get("NewReportingTo").toString();
		    String TransferType=testdata.get("TransferType").toString();
		    String Comments=testdata.get("Comments").toString();
			
			
			

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
					//Log.info("Login successful !");
					// driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					// ExtentTestManager.endTest();
					ExtentTestManager.getTest().log(Status.PASS, "Username is entered successfully");
					ExtentTestManager.getTest().log(Status.PASS, "Password is entered successfully");
					
					ExtentTestManager.getTest().log(Status.PASS, "Successfully Logged In");
					
					 ExtentTestManager.startTest("TC-3-Pop Up Handling");
					 handlePopupCovid();
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					   ExtentTestManager.getTest().log(Status.PASS,"Covid Pop Up is Handled");
					   handlePopupDesktop();
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					   ExtentTestManager.getTest().log(Status.PASS,"Desktop Notification Pop Up is Handled");
					   ExtentTestManager.endTest();
		
		
				
		
				Hr_Initiated_Transfer.clickOnemp();
				 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				 ExtentTestManager.startTest("TC-4-Employee module is displayed");
		         driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		         ExtentTestManager.getTest().log(Status.PASS,"Employee module is displayed");
		         ExtentTestManager.endTest();
		         ExtentTestManager.startTest("TC-5-Requests  submodule is displayed");
		         ExtentTestManager.getTest().log(Status.PASS,"Requests  submodule is displayed");
		         driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		         ExtentTestManager.endTest();
				
		         
		         Hr_Initiated_Transfer.clickonhrrequests();
				 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				 ExtentTestManager.startTest("TC-6-HR Initiated Transfer submodule is displayed");
				  ExtentTestManager.getTest().log(Status.PASS,"HR Initiated Transfer submodule is displayedd");
		         driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		         ExtentTestManager.endTest();
					
				
				 
				 Hr_Initiated_Transfer.clickonhrinitiatedtransfer();
				 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				 ExtentTestManager.startTest("TC-7-Employee Transfer Requests page is displayed");
				 ExtentTestManager.getTest().log(Status.PASS,"Employee Transfer Requests page is displayed");
		         driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		         ExtentTestManager.endTest();
		         
		         
		         Hr_Initiated_Transfer.checkiftransferrequestsubmitted(Employee);
		         driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				 ExtentTestManager.startTest("TC-8-Search if Employee Transfer Requests is already present in the list");
				 ExtentTestManager.getTest().log(Status.PASS,"Search result is displayed");
		         driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		         ExtentTestManager.endTest();
		         
					//boolean result=Hr_Initiated_Transfer.checkiftransferrequestsubmitted(Employee);
		         try {
		    	
		        	 WebElement popupElement = driver.findElement(PageRepositary.searchedempname);
		    	// WebElement popupElement = driver.findElement(PageRepositary.searchedempcode);
		         WaitForElementToBeVisible(PageRepositary.searchedempname);
		         if (popupElement.isDisplayed()) 
		         { 
		        	 Log.info("Transfer Request for this Employee is already submitted");
		        	 ExtentTestManager.getTest().log(Status.PASS, "Transfer Request for this Employee is already submitted");
		        	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		         }
		        	 
		         }
		     
				catch(Exception e1)
		         {
				 Hr_Initiated_Transfer.clickonhraddnew();
				 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				 ExtentTestManager.startTest("TC-9-HR Initiated  Transfer page is displayed");
				 ExtentTestManager.getTest().log(Status.PASS,"HR Initiated  Transfer page is displayed");
		         driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		         ExtentTestManager.endTest();
				
				 
				 Hr_Initiated_Transfer.slectempname(Employee);
				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				  //Thread.sleep(3000);
				  ExtentTestManager.startTest("TC-10-Employee drop down is loaded with values");
				  ExtentTestManager.getTest().log(Status.PASS,"Employee drop down is loaded with values");
				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				   ExtentTestManager.endTest();
				   ExtentTestManager.startTest("TC-11-Employee is selected");
				   ExtentTestManager.getTest().log(Status.PASS,"Employee is selected");
				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				   ExtentTestManager.endTest();
				   
				   
					 Hr_Initiated_Transfer.slectbusinessunit(NewBusinessUnit);
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					  //Thread.sleep(3000);
					  ExtentTestManager.startTest("TC-12-New Business Unit drop down is loaded with values");
					  ExtentTestManager.getTest().log(Status.PASS,"New Business Unit drop down is loaded with values");
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					   ExtentTestManager.endTest();
					   ExtentTestManager.startTest("TC-13-New Business Unit is selected");
					   ExtentTestManager.getTest().log(Status.PASS,"New Business Unit is selected");
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					   ExtentTestManager.endTest();
					   
				   
					   Hr_Initiated_Transfer.slectoffice(NewOffice);
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					  //Thread.sleep(3000);
					  ExtentTestManager.startTest("TC-14-New Office drop down is loaded with values");
					  ExtentTestManager.getTest().log(Status.PASS,"New Office drop down is loaded with values");
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					   ExtentTestManager.endTest();
					   ExtentTestManager.startTest("TC-15-New Office is selected");
					   ExtentTestManager.getTest().log(Status.PASS,"New Office is selected");
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					   ExtentTestManager.endTest();
				   
					   
					   Hr_Initiated_Transfer.slectdateoftransfer(DateOfTransfer);
				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					  //Thread.sleep(3000);
					  ExtentTestManager.startTest("TC-16-Date of transfer is entered successfully");
					  ExtentTestManager.getTest().log(Status.PASS,"Date of transfer is entered successfully");
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					   ExtentTestManager.endTest();
					   

					   ifemptbelongstootherbu();
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					   
					   Hr_Initiated_Transfer.slectnewreportingto(NewReportingTo);
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					  //Thread.sleep(3000);
					  ExtentTestManager.startTest("TC-17-New Reporting To drop down is loaded with values");
					  ExtentTestManager.getTest().log(Status.PASS,"New Reporting To drop down is loaded with values");
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					   ExtentTestManager.endTest();
					   ExtentTestManager.startTest("TC-18-New Reporting To is selected");
					   ExtentTestManager.getTest().log(Status.PASS,"New Reporting To is selected");
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					   ExtentTestManager.endTest();
					   ifemptbelongstootherbu();
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					   
					   
					   Hr_Initiated_Transfer.slecttransfertype(TransferType);
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					  //Thread.sleep(3000);
					  ExtentTestManager.startTest("TC-19-Transfer Type drop down is loaded with values");
					  ExtentTestManager.getTest().log(Status.PASS,"Transfer Type drop down is loaded with values");
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					   ExtentTestManager.endTest();
					   
					   ExtentTestManager.startTest("TC-20-Transfer Type is selected");
					   ExtentTestManager.getTest().log(Status.PASS,"Transfer Type is selected");
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					   ExtentTestManager.endTest();
					   
					   
					   Hr_Initiated_Transfer.entercomments(Comments);
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					  //Thread.sleep(3000);
					  ExtentTestManager.startTest("TC-21-Comments is entered successfully");
					  ExtentTestManager.getTest().log(Status.PASS,"Comments is entered successfully");
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					   ExtentTestManager.endTest();
					   
					   
					   Hr_Initiated_Transfer.submit();
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					  //Thread.sleep(3000);
					  ExtentTestManager.startTest("TC-22-Employee transfer submitted successfully");
					  ExtentTestManager.getTest().log(Status.PASS,"Employee transfer submitted successfully");
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					   ExtentTestManager.endTest();
					   
					 //  ExtentTestManager.startTest("Popup Handled for already submitted transfer request");
					   
					   //ifhrtransferalreadysubmittedsubmitted();
					   //ExtentTestManager.endTest();
					   
		//	}
		      // else {
		       //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        	   //System.out.println("Transfer Request for this employee is already submitted ");
        	   
               // driver.findElement(PageRepositary.empalreadysubmitted).click();
             //   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
               // ExtentTestManager.getTest().log(Status.PASS, "Already Submitted Transfer Request ");
               // Log.info("Alreadysubmitted Transfer Request ");
               // click(PageRepositary.DesktopNot);
               // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		         }
			//}
		       }
			 
			// Logout
			
			  ExtentTestManager.startTest("TC-23-Logout."); context.setAttribute("fileName","Logout"); 
			  click(userDropDown); 
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

