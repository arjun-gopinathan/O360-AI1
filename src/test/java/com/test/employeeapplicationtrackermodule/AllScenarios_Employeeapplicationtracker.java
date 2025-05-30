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
//import com.Pages_LeaveModule.Leave_LeaveRequest;
import com.Pages_employeeapplicationtrackermodule.Employee_AppclicationTracker;
import com.Utility.Log;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;

public class AllScenarios_Employeeapplicationtracker extends Base_Class {

	com.Utility.ExcelReader ExcelReader;
	Base_Class Base_Class;
	Log log;
	TestListener TestListener;
	com.Utility.ScreenShot screenShot;
	Employee_AppclicationTracker Employee_ApplicationTrcaker;
	ExtentTest extenttest;
	private static By userDropDown = By.xpath("//div[@id='userDropdown']/h4");
	private static By L_signout = By.xpath("//button[@class='dropdown-item ' and contains(text(),'Sign out')]");

	@BeforeSuite
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("Employee_ApplicationTrcaker");
		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();

		Employee_ApplicationTrcaker = new Employee_AppclicationTracker();

	}

//	public static void ScrollUntilElementVisible(By locator)
//	{ 
	// WebElement element = driver.findElement(locator);
	// JavascriptExecutor js = (JavascriptExecutor) driver;
	// js.executeScript("arguments[0].scrollIntoView();", element);
	// }
//	@BeforeMethod
//	public void setupTest(Method method) throws Exception {
//		// Start a new ExtentTest for the current test method
//		extenttest = ExtentTestManager.startTest(method.getName()).assignCategory("Employee Application Tracker");		
//	}
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
				   ExtentTestManager.endTest();
				   ExtentTestManager.startTest("Pop Up Handling");
				   handlePopupCovid();
				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				   handlePopupDesktop();
				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				   ExtentTestManager.endTest();
//PERSONAINFO
				String HiringClassification = testdata.get("HiringClassification").toString();
				String Salutation = testdata.get("Salutation").toString();
				String FirstName = testdata.get("FirstName").toString();
			    String MiddleName = testdata.get("MiddleName").toString();
				String LastName = testdata.get("LastName").toString();
			String PersonalEmail = testdata.get("PersonalEmail").toString();
				// String AttachResume = testdata.get("AttachResume").toString();
				String ContactNumber = testdata.get("ContactNumber").toString();

				// EMPINFO
				String ReportingTo = testdata.get("ReportingTo").toString();
				String Designation = testdata.get("Designation").toString();
				String RoleName = testdata.get("RoleName").toString();
				String BusinessUnit = testdata.get("BusinessUnit").toString();

				String Division = testdata.get("Division").toString();
				String Technology = testdata.get("Technology").toString();
				String Department = testdata.get("Department").toString();
				String ImmigrationStatus = testdata.get("ImmigrationStatus").toString();
				String VisaType = testdata.get("VisaType").toString();
				String DateofJoining = testdata.get("DateofJoining").toString();
				//String EmploymentType = testdata.get("EmploymentType").toString();
				String SpecialAccessNeeded = testdata.get("SpecialAccessNeeded").toString();
				String TrainingRequired = testdata.get("TrainingRequired").toString();
				String AdditionalTraining = testdata.get("AdditionalTraining").toString();
				// String EligibleforBenefits = testdata.get("Eligible for
				// Benefits").toString();
				// String BenefitsWaiverForm = testdata.get("Benefits Waiver Form(Max size:
				// 4MB)").toString();

				// String LaptopRequired = testdata.get("Laptop Required ").toString();
				// String BackgroundCheckRequired = testdata.get("Background Check
				// Required").toString();
				String JobLocation = testdata.get("JobLocation").toString();
				String Country = testdata.get("Country").toString();
				String ZipCode = testdata.get("ZipCode").toString();
				String City = testdata.get("City").toString();
				String State = testdata.get("State").toString();
				String Currency = testdata.get("Currency").toString();
				String Amount = testdata.get("Amount").toString();
				String SalaryType = testdata.get("SalaryType").toString();
				String AdditionalComments = testdata.get("AdditionalComments").toString();
				// String BenefitsWaiverForm = testdata.get("Benefits Waiver Form(Max size:
				// 4MB)").toString();


	              ExtentTestManager.startTest("Navigating to Employee submenu");

				 Employee_ApplicationTrcaker.clickOnEmployeeModule();
				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				// Thread.sleep(3000);
		         ExtentTestManager.getTest().log(Status.PASS,"Employee module is displayed");
		         driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		         //Thread.sleep(3000);
	              ExtentTestManager.endTest();
	              
	              ExtentTestManager.startTest("Navigating to Employee Application Tracker Dashboard");
				 Employee_ApplicationTrcaker.clickOnapplicationtracker();
				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				 //Thread.sleep(3000);
				 ExtentTestManager.getTest().log(Status.PASS,"Employee Application Tracker Dashboard is displayed");
				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				// Thread.sleep(3000);
				   ExtentTestManager.endTest();
				   
				   ExtentTestManager.startTest("Navigating to Employee Application Tracker page");
		         Employee_ApplicationTrcaker.clickOnaddnew();
		         driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		         //Thread.sleep(3000);
		         ExtentTestManager.getTest().log(Status.PASS,"Employee Application Tracker page is displayed");
		         driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		         //Thread.sleep(3000);
		         ExtentTestManager.endTest();
		         
		         
				  Employee_ApplicationTrcaker.selecthiringclassification(HiringClassification);
				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				 // Thread.sleep(3000);
				  
				  ExtentTestManager.startTest("Hiring Classification drop down is loaded with values");
				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				  //Thread.sleep(3000);
				   ExtentTestManager.endTest();
			      ExtentTestManager.startTest("Hiring Classification is selected");
			      driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			      //Thread.sleep(3000);
			      ExtentTestManager.endTest();
				//PERSONAINFO

				  Employee_ApplicationTrcaker.selectsalutation(Salutation); 
				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				  //Thread.sleep(3000);
				  ExtentTestManager.startTest("Salutation drop down is loaded with values");
				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				  //Thread.sleep(3000);
				   ExtentTestManager.endTest();
			         
			         
			      ExtentTestManager.startTest("Salutation is selected");
			      driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			     // Thread.sleep(3000);
			      ExtentTestManager.endTest();
			         
				  
				  Employee_ApplicationTrcaker.selectfirstname(FirstName); 
				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				 // Thread.sleep(3000);
				  ExtentTestManager.startTest("First Name is entered successfully");
				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				 // Thread.sleep(3000);
				   ExtentTestManager.endTest();
				  
				  Employee_ApplicationTrcaker.selectmiddlename(MiddleName); 
				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				 // Thread.sleep(3000);
				  ExtentTestManager.startTest("Middle Name is entered successfully");
				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				  //Thread.sleep(3000); 
				   ExtentTestManager.endTest();
					  
				  
				  
				  Employee_ApplicationTrcaker.selectlastname(LastName); 
				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				  //Thread.sleep(3000);
				  ExtentTestManager.startTest("Last Name is entered successfully");
			      
				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				   //Thread.sleep(3000);
				   ExtentTestManager.endTest();
					
				  
				  Employee_ApplicationTrcaker.enterpersonalemail();
				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				  //Thread.sleep(3000);
				  ExtentTestManager.startTest("Personal Email is entered successfully");
				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				  //Thread.sleep(3000);
				   ExtentTestManager.endTest();
				  
				  
				  Employee_ApplicationTrcaker.uploadFile("\\src\\test\\resources\\sample.pdf");
				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				 // Thread.sleep(3000);
				  ExtentTestManager.startTest("Resume upload is successful");
				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				 // Thread.sleep(3000);
				   ExtentTestManager.endTest();
				  
				  
				  Employee_ApplicationTrcaker.entercontactnumber();
				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				  //Thread.sleep(3000);
				  
				  ExtentTestManager.startTest("Contact Number is entered successfully");
				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				  //Thread.sleep(3000);
				  
				   ExtentTestManager.endTest();
					  
				  
				  //EMPINFO
				  
				  Employee_ApplicationTrcaker.selectreportingto(ReportingTo);
				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				  //Thread.sleep(3000);
				  ExtentTestManager.startTest("Reporting To drop down is loaded with values");
				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				   ExtentTestManager.endTest();
				  //Thread.sleep(3000);
			      ExtentTestManager.startTest("Reporting To is selected successfully");
			      driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			      //Thread.sleep(3000);
			      ExtentTestManager.endTest();
				  
				  
				  Employee_ApplicationTrcaker.selectdesignation(Designation);
				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				//  Thread.sleep(3000); 
				  ExtentTestManager.startTest("Designation drop down is loaded with values");
				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				  //Thread.sleep(3000);
				   ExtentTestManager.endTest();
					 
			      ExtentTestManager.startTest("Designation is selected successfully");
			      driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			     // Thread.sleep(3000);
			      ExtentTestManager.endTest();
					 
			      
			      
				  Employee_ApplicationTrcaker.selectrolename(RoleName);
				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				  //Thread.sleep(3000);
				  ExtentTestManager.startTest("Role Name drop down is loaded with values");
				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				  //Thread.sleep(3000);
				   ExtentTestManager.endTest();
					 
			      ExtentTestManager.startTest("Role Name is selected successfully");
			      driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			      //Thread.sleep(3000);
			      ExtentTestManager.endTest();
					 
				  
				  Employee_ApplicationTrcaker.selectbusinessunit(BusinessUnit);
				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				  //Thread.sleep(3000);
				  ExtentTestManager.startTest("Business Unit drop down is loaded with values");
				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				  //Thread.sleep(3000);
				   ExtentTestManager.endTest();
			      ExtentTestManager.startTest("Business Unit is selected successfully");
			      driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			     // Thread.sleep(3000);
			      ExtentTestManager.endTest();
				  
				 Employee_ApplicationTrcaker.selectdivisionname(Division);
				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				 //Thread.sleep(3000);
				 ExtentTestManager.startTest("Division drop down is loaded with values");
				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				// Thread.sleep(3000);
				   ExtentTestManager.endTest();
			      ExtentTestManager.startTest("Division is selected successfully");
			      driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			      //Thread.sleep(3000);
			      ExtentTestManager.endTest();
				 
				 Employee_ApplicationTrcaker.selecttechnologyname(Technology);
				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				 //Thread.sleep(3000);
				  ExtentTestManager.startTest("Technology drop down is loaded with values");
				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				  //Thread.sleep(3000);
				   ExtentTestManager.endTest();
			      ExtentTestManager.startTest("Technology is selected successfully");
			      driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			      //Thread.sleep(3000);
			      ExtentTestManager.endTest();
			      
				  
				  Employee_ApplicationTrcaker.selectdepartment(Department); 
				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				  //Thread.sleep(3000);
				  ExtentTestManager.startTest("Department drop down is loaded with values");
				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				 // Thread.sleep(3000);
				   ExtentTestManager.endTest();
				      
			      ExtentTestManager.startTest("Department is selected successfully");
			      driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			   //   Thread.sleep(3000);
			      ExtentTestManager.endTest();
			      
				  
				  Employee_ApplicationTrcaker.selectimmigrationstatus(ImmigrationStatus);
				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				  //Thread.sleep(3000);
				  ExtentTestManager.startTest("Immigration Status drop down is loaded with values");
				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				 // Thread.sleep(3000);
				   ExtentTestManager.endTest();
				      
			      ExtentTestManager.startTest("Immigration Status is selected successfully");
			      driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			      //Thread.sleep(3000);
			      ExtentTestManager.endTest();
			      
			      
			      
				  Employee_ApplicationTrcaker.selectvisatype(VisaType);
				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				  //Thread.sleep(3000);
				  ExtentTestManager.startTest("Visa Type drop down is loaded with values");
				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				  //Thread.sleep(3000);
				   ExtentTestManager.endTest();
				    
			      ExtentTestManager.startTest("Visa Type is selected successfully");
			      driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			    //  Thread.sleep(3000);
			      ExtentTestManager.endTest();
				    
			      
			      
				  Employee_ApplicationTrcaker.selectdateofjoining(DateofJoining);
				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				 // Thread.sleep(3000);
				 
				  ExtentTestManager.startTest("Date of Joining  is selected successfully");
				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				 // Thread.sleep(3000);
				   ExtentTestManager.endTest();
				
				   
				   //EMPTYPE
					 Employee_ApplicationTrcaker.selectemptypeemp();
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					// Thread.sleep(3000);
					 ExtentTestManager.startTest("Employment Type drop down is loaded with values");
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					 //Thread.sleep(3000);
					   ExtentTestManager.endTest();
				      ExtentTestManager.startTest("Employment Type is selected successfully");
				      driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				     // Thread.sleep(3000);
				      ExtentTestManager.endTest();

					 //Employee_ApplicationTrcaker.selectemptypecontractor();
					  //Thread.sleep(3000);
					  
					  Employee_ApplicationTrcaker.selectpseaccessneeded(SpecialAccessNeeded);
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					 // Thread.sleep(3000);
					  ExtentTestManager.startTest("Special Access Needed is entered successfully");
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					  //Thread.sleep(3000);
					   ExtentTestManager.endTest();
					  
					  
					  Employee_ApplicationTrcaker.selecttrainingrequired(TrainingRequired);
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					  //Thread.sleep(3000);
					  ExtentTestManager.startTest("Training Required is entered successfully");
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					  //Thread.sleep(3000);
					   ExtentTestManager.endTest();
						  
					  
					  Employee_ApplicationTrcaker.additionaltraining(AdditionalTraining);
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					 // Thread.sleep(3000);
					  ExtentTestManager.startTest("Additional Training is entered successfully");
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					 // Thread.sleep(3000);
					   ExtentTestManager.endTest();
					  
					  
					  Employee_ApplicationTrcaker.uploadFile1("\\src\\test\\resources\\e-sign.pdf");
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					  //Thread.sleep(3000);
					   ExtentTestManager.startTest("Benefits Waiver Form is uploaded successfully");
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					   //Thread.sleep(3000);
					   ExtentTestManager.endTest();
						  
					  
					  Employee_ApplicationTrcaker.selectjoblocation(JobLocation);
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					 // Thread.sleep(3000);
					  ExtentTestManager.startTest("Job Location drop down is loaded with values");
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					  //Thread.sleep(3000);
					   ExtentTestManager.endTest();
				      ExtentTestManager.startTest("Job Location is selected successfully");
				      driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				     // Thread.sleep(3000);
				      ExtentTestManager.endTest();
				      
					  Employee_ApplicationTrcaker.selectcountry(Country); 
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					  //Thread.sleep(3000);
					  ExtentTestManager.startTest("Country drop down is loaded with values");
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					  //Thread.sleep(3000);
					   ExtentTestManager.endTest();
				      ExtentTestManager.startTest("Country is selected successfully");
				      driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				     // Thread.sleep(3000);
				      ExtentTestManager.endTest();
					  
					  Employee_ApplicationTrcaker.enterzipcode(ZipCode); 
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					  //Thread.sleep(3000);
					  ExtentTestManager.startTest("Zip Code is entered successfully");
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					 // Thread.sleep(3000);
					   ExtentTestManager.endTest();
					  
					  Employee_ApplicationTrcaker.entercity(City); 
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					  //Thread.sleep(3000);
					  ExtentTestManager.startTest("City is entered successfully");
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					 // Thread.sleep(3000);
					   ExtentTestManager.endTest();
						  
					  
					  Employee_ApplicationTrcaker.enterstate(State); 
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					  //Thread.sleep(3000);
					  
					  ExtentTestManager.startTest("State is entered successfully");
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					 // Thread.sleep(3000);
					   ExtentTestManager.endTest();
				      
					  Employee_ApplicationTrcaker.Selectcurrency(Currency);
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					 // Thread.sleep(3000);
					  ExtentTestManager.startTest("Currency drop down is loaded with values");
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					 // Thread.sleep(3000);
					   ExtentTestManager.endTest();
				      ExtentTestManager.startTest("Currency is selected successfully");
				      driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				      //Thread.sleep(3000);
				      ExtentTestManager.endTest();
				      
					  Employee_ApplicationTrcaker.enteramount(Amount);
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					  //Thread.sleep(3000);
					  ExtentTestManager.startTest("Amount is entered successfully");
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					  //Thread.sleep(3000);
					   ExtentTestManager.endTest();
					  Employee_ApplicationTrcaker.Selectsalarytype(SalaryType);
					  
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					   //Thread.sleep(3000);
					  ExtentTestManager.startTest("Salary Type drop down is loaded with values");
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					 // Thread.sleep(3000);
					   ExtentTestManager.endTest();
				      ExtentTestManager.startTest("Salary Type is selected successfully");
				      driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				      ExtentTestManager.endTest();
				     // Thread.sleep(3000);
				      
					  
					  
					  Employee_ApplicationTrcaker.enteradditionalcomments(AdditionalComments);
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					  //Thread.sleep(3000); 
					  ExtentTestManager.startTest("Additional Comments is entered successfully");
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					  //Thread.sleep(3000);
					   ExtentTestManager.endTest();
					  Employee_ApplicationTrcaker.submitbutton();
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					 //Thread.sleep(3000);
					  ExtentTestManager.startTest("Application Tracker is submitted successfully");
					   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					  //Thread.sleep(3000);
					   ExtentTestManager.endTest();
				      ExtentTestManager.startTest("Candidate Details mail is sent successfully");
				      driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				      //Thread.sleep(3000);
					   ExtentTestManager.endTest();
				}
					 
				// Logout
				
				  ExtentTestManager.startTest("Logout."); context.setAttribute("fileName",
				  "Logout"); click(userDropDown); click(L_signout);
				 
				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				 //  Thread.sleep(2000);
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
