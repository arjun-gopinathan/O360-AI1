package com.ExpenseModule;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.By;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
import com.Pages_ExpenseModule.Expense_ExpenseRequest;
import com.Pages_ExpenseModule.Expense_ExpenseApproval;
import com.Utility.Log;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;
import java.lang.reflect.Method;
public class AllScenarios_ExpenseModule extends Base_Class {
	com.Utility.ExcelReader ExcelReader;
	Base_Class Base_Class;
	Log log;
	TestListener TestListener;
	com.Utility.ScreenShot screenShot;
	Expense_ExpenseRequest Expense_ExpenseRequest;
	Expense_ExpenseApproval Expense_ExpenseApproval;
	ExtentTest extenttest;
	private static By userDropDown = By.xpath("//div[@id='userDropdown']/h4");
	private static By L_signout = By.xpath("//button[@class='dropdown-item ' and contains(text(),'Sign out')]");
	private static By L_username = By.xpath("//input[@id='Username']");
	private static By L_password = By.xpath("//input[@id='Password']");
	private static String filePath = "\\src\\test\\resources\\e-sign.pdf";
	private static By L_SignIn = By.xpath("//span[contains(text(),'Sign In')]");
	
	@BeforeSuite
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("ExpenseRequest");
		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();
		
		Expense_ExpenseRequest= new Expense_ExpenseRequest();
		Expense_ExpenseApproval= new Expense_ExpenseApproval();
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
				context.setAttribute("fileName", "Login");
			//	Base_Class.SetUp();
				ExtentTestManager.getTest().log(Status.PASS,
						"Application Login" + com.BasePackage.Base_Class.Pagetitle);
				Log.info("Login successful !");
				Thread.sleep(3000);
				
				
				String ExpenseNumber = testdata.get("ExpenseNumber").toString();
				String ExpenseNumber1 = testdata.get("ExpenseNumber1").toString();
			

				
			//Expense Module Selection
			ExtentTestManager.startTest("TestScenario01 : Expense Request Form");
			Thread.sleep(3000);
			boolean flag1 = Expense_ExpenseRequest.clickExpenseSection();
			ExtentTestManager.getTest().log(Status.PASS, "Validated Expense Module : " + flag1);
			Log.info("Validated Expense Module : " + flag1);
			
			ExtentTestManager.getTest().log(Status.PASS, "Logging out and logging in as Approver 1.");
			Log.info("Logging out and logging in as Approver 1.");
			context.setAttribute("fileName", "Logout"); 
			click(userDropDown);
			click(L_signout);
			//Perform Approval as PMO
			String PMOUserName = configloader().getProperty("Approver1UserName");
			String PMOPassword = configloader().getProperty("Approver1Password");
			input(L_username, PMOUserName);
			input(L_password, PMOPassword);
			click(L_SignIn); 
			
			//Expense Module Selection
			ExtentTestManager.startTest("TestScenario02 : Expense Request Form");
			Thread.sleep(3000);
			boolean flag2 = Expense_ExpenseApproval.clickExpenseSection();
			ExtentTestManager.getTest().log(Status.PASS, "Validated Expense Module : " + flag2);
			Log.info("Validated Expense Module : " + flag2);
			
			//Expense Module Selection
			ExtentTestManager.startTest("TestScenario03 : Expense Number");
			Thread.sleep(3000);
			boolean flag3 = Expense_ExpenseApproval.clickOnExpenseNumber(ExpenseNumber);
			ExtentTestManager.getTest().log(Status.PASS, "Clicked on Expense Number : " + flag3);
			Log.info("Clicked on Expense Number : " + flag3);
			
			//Expense Module Selection
			ExtentTestManager.startTest("TestScenario04 : Click on Reject Button");
			Thread.sleep(3000);
			boolean flag4 = Expense_ExpenseApproval.RejectButton();
			ExtentTestManager.getTest().log(Status.PASS, "Clicked on Reject Button and added comments: " + flag4);
			Log.info("Clicked on Reject Button and added comments: " + flag4);
			
			//Expense Module Selection
			ExtentTestManager.startTest("TestScenario05 : Click on Reject Button");
			Thread.sleep(3000);
			boolean flag5 = Expense_ExpenseApproval.clickRejectButton();
			ExtentTestManager.getTest().log(Status.PASS, "Clicked on Reject Button : " + flag5);
			Log.info("Clicked on Reject Button : " + flag5);
			
			//Expense Module Selection
			ExtentTestManager.startTest("TestScenario06 : Expense Number");
			Thread.sleep(3000);
			boolean flag6 = Expense_ExpenseApproval.clickOnExpenseNumber1(ExpenseNumber1);
			ExtentTestManager.getTest().log(Status.PASS, "Clicked on Expense Number : " + flag6);
			Log.info("Clicked on Expense Number : " + flag6);
			
			//Expense Module Selection
			ExtentTestManager.startTest("TestScenario07 : Click on Approve Button");
			Thread.sleep(3000);
			boolean flag7 = Expense_ExpenseApproval.clickOnAproveButton();
			ExtentTestManager.getTest().log(Status.PASS, "Clicked on Approve Button : " + flag7);
			Log.info("Clicked on Approve Button : " + flag7);
			
			ExtentTestManager.getTest().log(Status.PASS, "Logging out and logging in as Approver 2.");
			Log.info("Logging out and logging in as Approver 2.");
			context.setAttribute("fileName", "Logout"); 
			click(userDropDown);
			click(L_signout);
			//Perform Approval as PMO
			String PMOUserName1 = configloader().getProperty("Approver2UserName");
			String PMOPassword1 = configloader().getProperty("Approver2Password");
			input(L_username, PMOUserName1);
			input(L_password, PMOPassword1);
			click(L_SignIn);
			
			//Expense Module Selection
			ExtentTestManager.startTest("TestScenario09 :  Click on Approve Button");
			Thread.sleep(3000);
			boolean flag8 = Expense_ExpenseApproval.clickExpenseSection();
			ExtentTestManager.getTest().log(Status.PASS, "Clicked on Approve Button : " + flag8);
			Log.info("Clicked on Approve Button : " + flag8);
			
			//Expense Module Selection
			ExtentTestManager.startTest("TestScenario10 : Expense Number");
			Thread.sleep(3000);
			boolean flag10 = Expense_ExpenseApproval.clickOnExpenseNumber1(ExpenseNumber1);
			ExtentTestManager.getTest().log(Status.PASS, "Clicked on Expense Number : " + flag10);
			Log.info("Clicked on Expense Number : " + flag10);
			
			//Expense Module Selection
			ExtentTestManager.startTest("TestScenario011 : Click on Approve Button");
			Thread.sleep(3000);
			boolean flag11 = Expense_ExpenseApproval.clickOnAproveButton();
			ExtentTestManager.getTest().log(Status.PASS, "Clicked on Approve Button : " + flag11);
			Log.info("Clicked on Approve Button : " + flag11);
			
			ExtentTestManager.getTest().log(Status.PASS, "Logging out and logging in as Approver 3.");
			Log.info("Logging out and logging in as Approver 3.");
			context.setAttribute("fileName", "Logout"); 
			click(userDropDown);
			click(L_signout);
			//Perform Approval as PMO
			String PMOUserName2 = configloader().getProperty("Approver2UserName");
			String PMOPassword2 = configloader().getProperty("Approver2Password");
			input(L_username, PMOUserName2);
			input(L_password, PMOPassword2);
			click(L_SignIn);
			
//			//Expense Module Selection
//			ExtentTestManager.startTest("TestScenario09 :  Click on Approve Button");
//			Thread.sleep(3000);
//			boolean flag8 = Expense_ExpenseApproval.clickExpenseSection();
//			ExtentTestManager.getTest().log(Status.PASS, "Clicked on Approve Button : " + flag8);
//			Log.info("Clicked on Approve Button : " + flag8);
//			
//			//Expense Module Selection
//			ExtentTestManager.startTest("TestScenario10 : Expense Number");
//			Thread.sleep(3000);
//			boolean flag10 = Expense_ExpenseApproval.clickOnExpenseNumber1(ExpenseNumber1);
//			ExtentTestManager.getTest().log(Status.PASS, "Clicked on Expense Number : " + flag10);
//			Log.info("Clicked on Expense Number : " + flag10);
//			
//			//Expense Module Selection
//			ExtentTestManager.startTest("TestScenario011 : Click on Approve Button");
//			Thread.sleep(3000);
//			boolean flag11 = Expense_ExpenseApproval.clickOnAproveButton();
//			ExtentTestManager.getTest().log(Status.PASS, "Clicked on Approve Button : " + flag11);
//			Log.info("Clicked on Approve Button : " + flag11);
			
			Thread.sleep(5000);
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

