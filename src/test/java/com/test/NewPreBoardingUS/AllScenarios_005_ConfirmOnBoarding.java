package com.test.NewPreBoardingUS;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
import com.Locators_PreBoardingUS.Locators_CandidateOnBoardingPage;
import com.Locators_PreBoardingUS.Locators_CreateCandidatePage;
import com.Locators_PreBoardingUS.Locators_PendingWithCandidatePage;
import com.Pages_PreBoardingUSMethods.Methods_ActiveEmployeesPage;
import com.Pages_PreBoardingUSMethods.Methods_CandidateOnBoardingPage;
import com.Pages_PreBoardingUSMethods.Methods_CreateCandidatePage;
import com.Pages_PreBoardingUSMethods.Methods_HomePage;
import com.Pages_PreBoardingUSMethods.Methods_PendingWithCandidatePage;
import com.Pages_PreBoardingUSMethods.Methods_PendingWithHRPage;
import com.Utility.Log;
import com.Utility.TriggerEmail;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;

public class AllScenarios_005_ConfirmOnBoarding extends Base_Class {
	
	Methods_HomePage methods_HomePage;
	
	Methods_ActiveEmployeesPage methods_ActiveEmployeesPage;
	
	Methods_CandidateOnBoardingPage methods_CandidateOnBoardingPage;
	Locators_CandidateOnBoardingPage locators_CandidateOnBoardingPage;
	
	Locators_PendingWithCandidatePage locators_PendingWithCandidatePage;
	Methods_PendingWithCandidatePage methods_PendingWithCandidatePage;
	
	Methods_CreateCandidatePage methods_CreateCandidatePage;
	Locators_CreateCandidatePage locators_CreateCandidatePage;
	ExtentTest extenttest;
	
	Log log;
	com.Utility.ScreenShot screenshot;
	com.Utility.ExcelReader ExcelReader;
	com.Utility.ExcelReader ExcelReader1;
	
	@BeforeClass
	public void reference() throws InterruptedException {

		methods_HomePage = new Methods_HomePage();
	
		methods_ActiveEmployeesPage = new Methods_ActiveEmployeesPage();
		
		methods_CandidateOnBoardingPage = new Methods_CandidateOnBoardingPage();
		locators_CandidateOnBoardingPage = new Locators_CandidateOnBoardingPage();
		
		methods_CreateCandidatePage = new Methods_CreateCandidatePage();
		locators_CreateCandidatePage = new Locators_CreateCandidatePage();
		
		
		log = new Log();
		screenshot = new com.Utility.ScreenShot(driver);
		ExcelReader = new com.Utility.ExcelReader("ConfirmOnBoarding");				
	}
	@BeforeMethod
	public void setupTest(Method method) throws Exception {
		// Start a new ExtentTest for the current test method
		extenttest = ExtentTestManager.startTest(method.getName()).assignCategory("Confirm On Boarding");		
	}
	@Test(dataProvider = "TestData", priority=6)
	public void runAlllScenarios(Map<Object, Object> testdata, ITestContext context)
			throws IOException, InterruptedException {
		try {
			
			String userName = testdata.get("User Name").toString();
		
			if (testdata.get("Run").toString().equalsIgnoreCase("Yes")) {
				ExtentTestManager.startTest(testdata.get("TestScenario").toString());
				Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");
				context.setAttribute("fileName", "Login");
				SetUp(userName);
				ExtentTestManager.getTest().log(Status.PASS, "Successfully Logged in");

				ExtentTestManager.startTest("TC -2 Validating dashboad is displayed or not");
				verifySuccessfulLogin();
				validateDashBoard();
								
				ExtentTestManager.startTest("TC- 3 Navigate to 'Candidate OnBoarding' Page");
				methods_HomePage.navigateToEmployeeTab();
				methods_HomePage.clickApprovals();
				methods_HomePage.clickCandidateOnBoarding();
				methods_CandidateOnBoardingPage.verifyCandidateOnBoardingpage();

				ExtentTestManager.startTest("TC- 4 Verify Default Search Field Selection");
				methods_CandidateOnBoardingPage.clickSearchIcon();
				methods_CandidateOnBoardingPage.isSearchDialogOpened();
				methods_CandidateOnBoardingPage.isSearchColumnSelectedByDefault();
				methods_CandidateOnBoardingPage.isSearchTypeSelectedByDefault();
				
				ExtentTestManager.startTest("TC- 5 Search Candidate By Name");
				methods_CandidateOnBoardingPage.enterCandidateName();
				methods_CandidateOnBoardingPage.clickSearchButton();
				methods_CandidateOnBoardingPage.verifysearchedCandidateNameDisplayed();
				
				ExtentTestManager.startTest("TC- 6 Access Candidate OnBoarding Form");
				methods_CandidateOnBoardingPage.clickonSearchedCandidateName();
				methods_CandidateOnBoardingPage.verifyCandidateOnBoardingForm();
				
				ExtentTestManager.startTest("TC- 7 Verify Auto Populated field values");
				JSONParser parser = new JSONParser();
				JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("testData.json"));
				
//				methods_CandidateOnBoardingPage.verifyAutoPopulatedDropdownField((String) jsonObject.get("Hiring Classification"), locators_CandidateOnBoardingPage.hiringClassification);
				methods_CandidateOnBoardingPage.verifyAutoPopulatedField((String) jsonObject.get("First Name"), locators_CandidateOnBoardingPage.firstName);
				methods_CandidateOnBoardingPage.verifyAutoPopulatedField((String) jsonObject.get("Middle Name"), locators_CandidateOnBoardingPage.middleName);
				methods_CandidateOnBoardingPage.verifyAutoPopulatedField((String) jsonObject.get("Last Name"), locators_CandidateOnBoardingPage.lastName);
				methods_CandidateOnBoardingPage.verifyAutoPopulatedField((String) jsonObject.get("Preferred Name"), locators_CandidateOnBoardingPage.preferredName);
				methods_CandidateOnBoardingPage.verifyAutoPopulatedField((String) jsonObject.get("Personal Email"), locators_CandidateOnBoardingPage.email);
				methods_CandidateOnBoardingPage.verifyAutoPopulatedField((String) jsonObject.get("Contact Number"), locators_CandidateOnBoardingPage.ContactNumber);
				methods_CandidateOnBoardingPage.verifyAutoPopulatedDropdownField((String) jsonObject.get("Gender"), locators_CandidateOnBoardingPage.Gender);
				methods_CandidateOnBoardingPage.verifyAutoPopulatedDropdownField((String) jsonObject.get("Marital Status"), locators_CandidateOnBoardingPage.MaritalStatus);
				methods_CandidateOnBoardingPage.verifyAutoPopulatedField((String) jsonObject.get("Date of Birth"), locators_CandidateOnBoardingPage.DateOfBirth);
				methods_CandidateOnBoardingPage.verifyAutoPopulatedDropdownField((String) jsonObject.get("Race Ethnicity"), locators_CandidateOnBoardingPage.Race_Ethnicity);
				methods_CandidateOnBoardingPage.verifyAutoPopulatedField((String) jsonObject.get("Address Line 1"), locators_CandidateOnBoardingPage.AddressLine1);	
				methods_CandidateOnBoardingPage.verifyAutoPopulatedField((String) jsonObject.get("Zip Code"), locators_CandidateOnBoardingPage.ZipCode);
				methods_CandidateOnBoardingPage.verifyAutoPopulatedField((String) jsonObject.get("City"), locators_CandidateOnBoardingPage.City);
				methods_CandidateOnBoardingPage.verifyAutoPopulatedDropdownField((String) jsonObject.get("State"), locators_CandidateOnBoardingPage.State);
				methods_CandidateOnBoardingPage.verifyAutoPopulatedFieldText((String) jsonObject.get("Attach Resume"), locators_CandidateOnBoardingPage.AttachedResumeName);
				methods_CandidateOnBoardingPage.verifyAutoPopulatedFieldText((String) jsonObject.get("SSN Uploaded"), locators_CandidateOnBoardingPage.SSNUploadName);
				methods_CandidateOnBoardingPage.verifyAutoPopulatedField((String) jsonObject.get("Certificate"), locators_CandidateOnBoardingPage.Certificate);
				methods_CandidateOnBoardingPage.verifyAutoPopulatedFieldText((String) jsonObject.get("Certificate Uploaded"), locators_CandidateOnBoardingPage.CertificateUploadName);
				methods_CandidateOnBoardingPage.verifyAutoPopulatedField((String) jsonObject.get("Reporting Manager"), locators_CandidateOnBoardingPage.ReportingTo);
				methods_CandidateOnBoardingPage.verifyAutoPopulatedField((String) jsonObject.get("Designation"), locators_CandidateOnBoardingPage.Designation);
				methods_CandidateOnBoardingPage.verifyAutoPopulatedField((String) jsonObject.get("Role Name"), locators_CandidateOnBoardingPage.RoleName);
				methods_CandidateOnBoardingPage.verifyAutoPopulatedField((String) jsonObject.get("Business Unit"), locators_CandidateOnBoardingPage.BusinessUnit);
				methods_CandidateOnBoardingPage.verifyAutoPopulatedField((String) jsonObject.get("Division"), locators_CandidateOnBoardingPage.Division);
				methods_CandidateOnBoardingPage.verifyAutoPopulatedField((String) jsonObject.get("Technology"), locators_CandidateOnBoardingPage.Technology);
				methods_CandidateOnBoardingPage.verifyAutoPopulatedField((String) jsonObject.get("Department"), locators_CandidateOnBoardingPage.Department);
				methods_CandidateOnBoardingPage.verifyAutoPopulatedDropdownField((String) jsonObject.get("Immigration Status"), locators_CandidateOnBoardingPage.ImmigrationStatus);
				methods_CandidateOnBoardingPage.verifyAutoPopulatedDropdownField((String) jsonObject.get("Visa Type"), locators_CandidateOnBoardingPage.VisaType);
				methods_CandidateOnBoardingPage.verifyAutoPopulatedField((String) jsonObject.get("Date of Joining"), locators_CandidateOnBoardingPage.DateOfJoining);
				methods_CandidateOnBoardingPage.verifyAutoPopulatedDropdownField((String) jsonObject.get("Employment Type"), locators_CandidateOnBoardingPage.EmploymentType);
				methods_CandidateOnBoardingPage.verifyAutoPopulatedDropdownField((String) jsonObject.get("Employment Sub Type"), locators_CandidateOnBoardingPage.EmploymentSubType);
				methods_CandidateOnBoardingPage.verifyAutoPopulatedField((String) jsonObject.get("Special Access Needed"), locators_CandidateOnBoardingPage.SpecialAccessNeeded);
				methods_CandidateOnBoardingPage.verifyAutoPopulatedField((String) jsonObject.get("Training Required"), locators_CandidateOnBoardingPage.TrainingRequired);
				methods_CandidateOnBoardingPage.verifyAutoPopulatedField((String) jsonObject.get("Additional Training"), locators_CandidateOnBoardingPage.AdditionalTraining);
				methods_CandidateOnBoardingPage.verifyAutoPopulatedFieldText((String) jsonObject.get("Benefits Waiver Form Uploaded"), locators_CandidateOnBoardingPage.BenefitsWaiverForm_UploadName);
				methods_CandidateOnBoardingPage.verifyAutoPopulatedDropdownField((String) jsonObject.get("Job Location"), locators_CandidateOnBoardingPage.JobLocation);
				methods_CandidateOnBoardingPage.verifyAutoPopulatedDropdownField((String) jsonObject.get("Job Country"), locators_CandidateOnBoardingPage.JobCountry);
				methods_CandidateOnBoardingPage.verifyAutoPopulatedField((String) jsonObject.get("Job ZipCode"), locators_CandidateOnBoardingPage.JobZipCode);
				methods_CandidateOnBoardingPage.verifyAutoPopulatedField((String) jsonObject.get("Job City"), locators_CandidateOnBoardingPage.jobCityText);
				methods_CandidateOnBoardingPage.verifyAutoPopulatedField((String) jsonObject.get("Job State"), locators_CandidateOnBoardingPage.JobStateText);
				methods_CandidateOnBoardingPage.verifyAutoPopulatedDropdownField((String) jsonObject.get("Currency"), locators_CandidateOnBoardingPage.Currency);
				methods_CandidateOnBoardingPage.verifyAutoPopulatedField((String) jsonObject.get("Amount"), locators_CandidateOnBoardingPage.Amount);
				methods_CandidateOnBoardingPage.verifyAutoPopulatedDropdownField((String) jsonObject.get("Salary Type"), locators_CandidateOnBoardingPage.SalaryType);
				methods_CandidateOnBoardingPage.verifyAutoPopulatedField((String) jsonObject.get("Additional Comments"), locators_CandidateOnBoardingPage.AdditionalComments);
				methods_CandidateOnBoardingPage.verifyAutoPopulatedField((String) jsonObject.get("Suggested Company Email"), locators_CandidateOnBoardingPage.SuggestedCompanyEmail);
				methods_CandidateOnBoardingPage.verifyAutoPopulatedField((String) jsonObject.get("Suggested UserName"), locators_CandidateOnBoardingPage.SuggestedUserName);
				methods_CandidateOnBoardingPage.verifyAutoPopulatedField((String) jsonObject.get("Approved Company Email"), locators_CandidateOnBoardingPage.approvedCompanyEmail);
				methods_CandidateOnBoardingPage.verifyAutoPopulatedField((String) jsonObject.get("Approved UserName"), locators_CandidateOnBoardingPage.approvedUserName);
				
				ExtentTestManager.startTest("TC- 8 Verify 'BackedOut' Button Initiates Confirmation Popup");
				methods_CandidateOnBoardingPage.clickBackedOutButton();
				methods_CandidateOnBoardingPage.isConfirmationPopupDisplayed();
				
				ExtentTestManager.startTest("TC- 9 Verify Cancel Button Closes BackedOut Confirmation Popup");
				methods_CandidateOnBoardingPage.clickCancelButtonInPopup();
				methods_CandidateOnBoardingPage.isConfirmationPopupDisplayed();
				
				ExtentTestManager.startTest("TC- 10 Verify 'ConfirmOnBoarding' Button Initiates Confirmation Popup");
				methods_CandidateOnBoardingPage.clickConfirmOnBoardingButton();
				methods_CandidateOnBoardingPage.isConfirmationPopupDisplayed();
				
				ExtentTestManager.startTest("TC- 11 Confirm OnBoarding");
				methods_CandidateOnBoardingPage.enterConfirmationMessage();
				methods_CandidateOnBoardingPage.clickOkButtonInPopup();
				methods_CandidateOnBoardingPage.clickOkButtonInOnBoardingCompletedPopup();
				methods_CandidateOnBoardingPage.verifyCandidateOnBoardingFormClosed();
				
				ExtentTestManager.startTest("TC- 12 Navigate to 'Active Employees' Page");
				methods_HomePage.navigateToEmployeeTab();
				methods_HomePage.clickEmployeeSubMenu();
				methods_HomePage.clickActiveEmployees();
				methods_ActiveEmployeesPage.verifyActiveEmployeespage();
				
				ExtentTestManager.startTest("TC- 13 Verify Default Search Field Selection");
				methods_ActiveEmployeesPage.clickSearchIcon();
				methods_ActiveEmployeesPage.isSearchDialogOpened();
				methods_ActiveEmployeesPage.isSearchColumnSelectedByDefault();
				methods_ActiveEmployeesPage.isSearchTypeSelectedByDefault();
				
				ExtentTestManager.startTest("TC- 14 Search OnBoarding Completed Employee by Name");
				methods_ActiveEmployeesPage.enterCandidateName();
				methods_ActiveEmployeesPage.clickSearchButton();
				methods_ActiveEmployeesPage.verifysearchedCandidateNameDisplayed();
				
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

