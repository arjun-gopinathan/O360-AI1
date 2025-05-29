package com.test.NewPreBoardingUS;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
import com.Locators_PreBoardingUS.Locators_CandidateEmailApprovalPage;
import com.Locators_PreBoardingUS.Locators_CreateCandidatePage;
import com.Pages_PreBoardingUSMethods.Methods_CandidateEmailApprovalPage;
import com.Pages_PreBoardingUSMethods.Methods_CreateCandidatePage;
import com.Pages_PreBoardingUSMethods.Methods_HomePage;
import com.Utility.Log;
import com.Utility.TriggerEmail;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;

public class AllScenarios_003_USEmailApproval extends Base_Class {
	
	Methods_HomePage methods_HomePage;
	Locators_CandidateEmailApprovalPage locators_CandidateEmailApprovalPage;
	Methods_CandidateEmailApprovalPage methods_CandidateEmailApprovalPage;
	Log log;
	com.Utility.ScreenShot screenshot;
	com.Utility.ExcelReader ExcelReader;
	ExtentTest extenttest;
	
	@BeforeClass
	public void reference() throws InterruptedException {

		methods_HomePage = new Methods_HomePage();
		methods_CandidateEmailApprovalPage = new Methods_CandidateEmailApprovalPage();
		locators_CandidateEmailApprovalPage = new Locators_CandidateEmailApprovalPage();
		log = new Log();
		screenshot = new com.Utility.ScreenShot(driver);
		ExcelReader = new com.Utility.ExcelReader("USEmailApproval");		
	}
	@BeforeMethod
	public void setupTest(Method method) throws Exception {
		// Start a new ExtentTest for the current test method
		extenttest = ExtentTestManager.startTest(method.getName()).assignCategory("US Email Approval");		
	}
	@Test(dataProvider = "TestData",priority=2)
	public void runAlllScenarios(Map<Object, Object> testdata, ITestContext context)
			throws IOException, InterruptedException {
		try {

			String userName = testdata.get("User Name").toString();
			String temporaryPassword = testdata.get("Temporary Password").toString();
			String webMailURL = testdata.get("WebMail URL").toString();
			
			if (testdata.get("Run").toString().equalsIgnoreCase("Yes")) {
				ExtentTestManager.startTest(testdata.get("TestScenario").toString());
				Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");
				context.setAttribute("fileName", "Login");
				SetUp(userName);
				ExtentTestManager.getTest().log(Status.PASS, "Successfully Logged in");

				ExtentTestManager.startTest("TC -2 Validating dashboad is displayed or not");
				verifySuccessfulLogin();
				validateDashBoard();
								
				ExtentTestManager.startTest("TC- 3 Navigate to Candidate Email Approval Page");
				methods_HomePage.navigateToEmployeeTab();
				methods_HomePage.clickApprovals();
				methods_HomePage.clickUsEmailApprovals();
				methods_CandidateEmailApprovalPage.verifyCandidateEmailApprovalPage();

				ExtentTestManager.startTest("TC- 4 Verify Default Search Field Selection");
				methods_CandidateEmailApprovalPage.clickSearchIcon();
				methods_CandidateEmailApprovalPage.isSearchDialogOpened();
				methods_CandidateEmailApprovalPage.isSearchColumnSelectedByDefault();
				methods_CandidateEmailApprovalPage.isSearchTypeSelectedByDefault();
				
				ExtentTestManager.startTest("TC- 5 Search Candidate By Name");
				methods_CandidateEmailApprovalPage.enterCandidateName();
				methods_CandidateEmailApprovalPage.clickSearchButton();
				methods_CandidateEmailApprovalPage.verifysearchedCandidateNameDisplayed();
				
				ExtentTestManager.startTest("TC- 6 Access Email Approval Form");
				methods_CandidateEmailApprovalPage.clickonSearchedCandidateName();
				methods_CandidateEmailApprovalPage.verifyEmailApprovalForm();
				
				ExtentTestManager.startTest("TC- 7 Verify fields are auto-populated and non-editable");
				methods_CandidateEmailApprovalPage.verifyAllFields();
				
				ExtentTestManager.startTest("TC- 8 Verify Submit Without Mandatory Fields");
				methods_CandidateEmailApprovalPage.clickConfirmEmailBtn();
				methods_CandidateEmailApprovalPage.verifyAllValidationMessages();
				
				ExtentTestManager.startTest("TC- 9 Verify Invalid 'Approved Company Email' Entry");
				methods_CandidateEmailApprovalPage.enterApprovedCompanyEmail("abc");
				methods_CandidateEmailApprovalPage.invalidApprovedCompanyEmailValidation();
				
				ExtentTestManager.startTest("TC- 10 Verify Valid 'Approved Company Email' Entry");
				methods_CandidateEmailApprovalPage.enterApprovedCompanyEmail(driver.findElement(locators_CandidateEmailApprovalPage.suggestedCompanyEmail).getAttribute("value"));
				methods_CandidateEmailApprovalPage.validApprovedCompanyEmailValidation();
			    
				ExtentTestManager.startTest("TC- 11 Verify 'Approved User Name' Field");
				methods_CandidateEmailApprovalPage.enterApprovedUserName(driver.findElement(locators_CandidateEmailApprovalPage.suggestedCompanyUserName).getAttribute("value"));
				methods_CandidateEmailApprovalPage.validateApprovedUserName();		
				methods_CandidateEmailApprovalPage.updateJsonFileWithNewValues();
				
				ExtentTestManager.startTest("TC- 12 Verify 'Temporary Password' Field");
				methods_CandidateEmailApprovalPage.enterTemporaryPassword(temporaryPassword);
				methods_CandidateEmailApprovalPage.validateTemporaryPasswordField();
				
				ExtentTestManager.startTest("TC- 13 Verify 'Web URL' Field");
				methods_CandidateEmailApprovalPage.enterWebMailURL(webMailURL);
				methods_CandidateEmailApprovalPage.validateWebMailURLField();
				
				ExtentTestManager.startTest("TC- 14 Email Approval Page Submission");
				methods_CandidateEmailApprovalPage.clickConfirmEmailBtn();
				methods_CandidateEmailApprovalPage.clickConfirmButtonForMailDetailsConfirmedPopup();
				
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
	
//	@AfterSuite
//	public void sharingReport() throws IOException {
//		try {
//				TriggerEmail.sendTestReportEmail();
//			} catch (Exception e) {
//				System.out.println("Email is not send"+e.getMessage());
//			}
//
//		}
}