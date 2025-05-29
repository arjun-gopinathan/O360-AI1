package com.test.NewPreBoardingUS;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

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
import com.Locators_PreBoardingUS.Locators_CandidateEmailApprovalPage;
import com.Locators_PreBoardingUS.Locators_CreateCandidatePage;
import com.Locators_PreBoardingUS.Locators_HrOnboardingPendingPage;
import com.Pages_PreBoardingUSMethods.Methods_CandidateEmailApprovalPage;
import com.Pages_PreBoardingUSMethods.Methods_CreateCandidatePage;
import com.Pages_PreBoardingUSMethods.Methods_HomePage;
import com.Pages_PreBoardingUSMethods.Methods_HrOnboardingPendingPage;
import com.Utility.Log;
import com.Utility.TriggerEmail;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;

public class AllScenarios_004_ConfirmPreboarding extends Base_Class {
	
	Methods_HomePage methods_HomePage;
	Methods_HrOnboardingPendingPage methods_HrOnboardingPendingPage;
	Locators_HrOnboardingPendingPage locators_HrOnboardingPendingPage;
	
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
		methods_HrOnboardingPendingPage = new Methods_HrOnboardingPendingPage();
		locators_HrOnboardingPendingPage = new Locators_HrOnboardingPendingPage();
		methods_CreateCandidatePage = new Methods_CreateCandidatePage();
		locators_CreateCandidatePage = new Locators_CreateCandidatePage();
		
		log = new Log();
		screenshot = new com.Utility.ScreenShot(driver);
		ExcelReader = new com.Utility.ExcelReader("ConfirmPreboarding");				
	}
	@BeforeMethod
	public void setupTest(Method method) throws Exception {
		// Start a new ExtentTest for the current test method
		extenttest = ExtentTestManager.startTest(method.getName()).assignCategory("Confirm Preboarding");		
	}
	@Test(dataProvider = "TestData", priority=3)
	public void runAlllScenarios(Map<Object, Object> testdata, ITestContext context)
			throws IOException, InterruptedException {
		try {

			String userName = testdata.get("User Name").toString();
			String parentOffice = testdata.get("Parent Office").toString();
		
			if (testdata.get("Run").toString().equalsIgnoreCase("Yes")) {
				ExtentTestManager.startTest(testdata.get("TestScenario").toString());
				Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");
				context.setAttribute("fileName", "Login");
				SetUp(userName);
				ExtentTestManager.getTest().log(Status.PASS, "Successfully Logged in");

				ExtentTestManager.startTest("TC -2 Validating dashboad is displayed or not");
				verifySuccessfulLogin();
				validateDashBoard();
								
				ExtentTestManager.startTest("TC- 3 Navigate to HR OnBoarding Pending Page");
				methods_HomePage.navigateToEmployeeTab();
				methods_HomePage.clickOnBoarding();
				methods_HomePage.clickHROnBoardingPending();
				methods_HrOnboardingPendingPage.verifyHrOnboardingPendingPage();

				ExtentTestManager.startTest("TC- 4 Verify Default Search Field Selection");
				methods_HrOnboardingPendingPage.clickSearchIcon();
				methods_HrOnboardingPendingPage.isSearchDialogOpened();
				methods_HrOnboardingPendingPage.isSearchColumnSelectedByDefault();
				methods_HrOnboardingPendingPage.isSearchTypeSelectedByDefault();
				
				ExtentTestManager.startTest("TC- 5 Search Candidate By Name");
				methods_HrOnboardingPendingPage.enterCandidateName();
				methods_HrOnboardingPendingPage.clickSearchButton();
				methods_HrOnboardingPendingPage.verifysearchedCandidateNameDisplayed();
				
				ExtentTestManager.startTest("TC- 6 Access Saved Candidate Form");
				methods_HrOnboardingPendingPage.clickonSearchedCandidateName();
				methods_HrOnboardingPendingPage.verifyHrOnboardingPendingForm();
				
				ExtentTestManager.startTest("TC- 7 Verify non-editable fields");
				methods_HrOnboardingPendingPage.areFieldsNonEditable();
				
				ExtentTestManager.startTest("TC- 8 Verify Auto Populated fields");
				JSONParser parser = new JSONParser();
				JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("testData.json"));
				
				methods_HrOnboardingPendingPage.verifyAutoPopulatedDropdownField((String) jsonObject.get("Hiring Classification"), locators_HrOnboardingPendingPage.hiringClassification);
				methods_HrOnboardingPendingPage.verifyAutoPopulatedField((String) jsonObject.get("First Name"), locators_HrOnboardingPendingPage.firstName);
				methods_HrOnboardingPendingPage.verifyAutoPopulatedField((String) jsonObject.get("Middle Name"), locators_HrOnboardingPendingPage.middleName);
				methods_HrOnboardingPendingPage.verifyAutoPopulatedField((String) jsonObject.get("Last Name"), locators_HrOnboardingPendingPage.lastName);
				methods_HrOnboardingPendingPage.verifyAutoPopulatedField((String) jsonObject.get("Preferred Name"), locators_HrOnboardingPendingPage.preferredName);
				methods_HrOnboardingPendingPage.verifyAutoPopulatedField((String) jsonObject.get("Personal Email"), locators_HrOnboardingPendingPage.email);
				methods_HrOnboardingPendingPage.verifyAutoPopulatedField((String) jsonObject.get("Contact Number"), locators_HrOnboardingPendingPage.ContactNumber);
				methods_HrOnboardingPendingPage.verifyAutoPopulatedDropdownField((String) jsonObject.get("Gender"), locators_HrOnboardingPendingPage.Gender);
				methods_HrOnboardingPendingPage.verifyAutoPopulatedDropdownField((String) jsonObject.get("Marital Status"), locators_HrOnboardingPendingPage.MaritalStatus);
				methods_HrOnboardingPendingPage.verifyAutoPopulatedField((String) jsonObject.get("Date of Birth"), locators_HrOnboardingPendingPage.DateOfBirth);
				methods_HrOnboardingPendingPage.verifyAutoPopulatedDropdownField((String) jsonObject.get("Race Ethnicity"), locators_HrOnboardingPendingPage.Race_Ethnicity);
				methods_HrOnboardingPendingPage.verifyAutoPopulatedField((String) jsonObject.get("Address Line 1"), locators_HrOnboardingPendingPage.AddressLine1);	
				methods_HrOnboardingPendingPage.verifyAutoPopulatedField((String) jsonObject.get("Zip Code"), locators_HrOnboardingPendingPage.ZipCode);
				methods_HrOnboardingPendingPage.verifyAutoPopulatedField((String) jsonObject.get("City"), locators_HrOnboardingPendingPage.City);
				methods_HrOnboardingPendingPage.verifyAutoPopulatedDropdownField((String) jsonObject.get("State"), locators_HrOnboardingPendingPage.State);
				methods_HrOnboardingPendingPage.verifyAutoPopulatedFieldText((String) jsonObject.get("Attach Resume"), locators_HrOnboardingPendingPage.AttachedResumeName);
				methods_HrOnboardingPendingPage.verifyAutoPopulatedFieldText((String) jsonObject.get("SSN Uploaded"), locators_HrOnboardingPendingPage.SSNUploadName);
				methods_HrOnboardingPendingPage.verifyAutoPopulatedField((String) jsonObject.get("Certificate"), locators_HrOnboardingPendingPage.Certificate);
				methods_HrOnboardingPendingPage.verifyAutoPopulatedFieldText((String) jsonObject.get("Certificate Uploaded"), locators_HrOnboardingPendingPage.CertificateUploadName);
				methods_HrOnboardingPendingPage.verifyAutoPopulatedField((String) jsonObject.get("Reporting Manager"), locators_HrOnboardingPendingPage.ReportingTo);
				methods_HrOnboardingPendingPage.verifyAutoPopulatedField((String) jsonObject.get("Designation"), locators_HrOnboardingPendingPage.Designation);
				methods_HrOnboardingPendingPage.verifyAutoPopulatedField((String) jsonObject.get("Role Name"), locators_HrOnboardingPendingPage.RoleName);
				methods_HrOnboardingPendingPage.verifyAutoPopulatedField((String) jsonObject.get("Business Unit"), locators_HrOnboardingPendingPage.BusinessUnit);
				methods_HrOnboardingPendingPage.verifyAutoPopulatedField((String) jsonObject.get("Division"), locators_HrOnboardingPendingPage.Division);
				methods_HrOnboardingPendingPage.verifyAutoPopulatedField((String) jsonObject.get("Technology"), locators_HrOnboardingPendingPage.Technology);
				methods_HrOnboardingPendingPage.verifyAutoPopulatedField((String) jsonObject.get("Department"), locators_HrOnboardingPendingPage.Department);
				methods_HrOnboardingPendingPage.verifyAutoPopulatedDropdownField((String) jsonObject.get("Immigration Status"), locators_HrOnboardingPendingPage.ImmigrationStatus);
				methods_HrOnboardingPendingPage.verifyAutoPopulatedDropdownField((String) jsonObject.get("Visa Type"), locators_HrOnboardingPendingPage.VisaType);
				methods_HrOnboardingPendingPage.verifyAutoPopulatedField((String) jsonObject.get("Date of Joining"), locators_HrOnboardingPendingPage.DateOfJoining);
				methods_HrOnboardingPendingPage.verifyAutoPopulatedDropdownField((String) jsonObject.get("Employment Type"), locators_HrOnboardingPendingPage.EmploymentType);
				methods_HrOnboardingPendingPage.verifyAutoPopulatedDropdownField((String) jsonObject.get("Employment Sub Type"), locators_HrOnboardingPendingPage.EmploymentSubType);
				methods_HrOnboardingPendingPage.verifyAutoPopulatedField((String) jsonObject.get("Special Access Needed"), locators_HrOnboardingPendingPage.SpecialAccessNeeded);
				methods_HrOnboardingPendingPage.verifyAutoPopulatedField((String) jsonObject.get("Training Required"), locators_HrOnboardingPendingPage.TrainingRequired);
				methods_HrOnboardingPendingPage.verifyAutoPopulatedField((String) jsonObject.get("Additional Training"), locators_HrOnboardingPendingPage.AdditionalTraining);
				methods_HrOnboardingPendingPage.verifyAutoPopulatedFieldText((String) jsonObject.get("Benefits Waiver Form Uploaded"), locators_HrOnboardingPendingPage.BenefitsWaiverForm_UploadName);
				methods_HrOnboardingPendingPage.verifyAutoPopulatedDropdownField((String) jsonObject.get("Job Location"), locators_HrOnboardingPendingPage.JobLocation);
				methods_HrOnboardingPendingPage.verifyAutoPopulatedDropdownField((String) jsonObject.get("Job Country"), locators_HrOnboardingPendingPage.JobCountry);
				methods_HrOnboardingPendingPage.verifyAutoPopulatedField((String) jsonObject.get("Job ZipCode"), locators_HrOnboardingPendingPage.JobZipCode);
				methods_HrOnboardingPendingPage.verifyAutoPopulatedField((String) jsonObject.get("Job City"), locators_HrOnboardingPendingPage.jobCityText);
				methods_HrOnboardingPendingPage.verifyAutoPopulatedField((String) jsonObject.get("Job State"), locators_HrOnboardingPendingPage.JobStateText);
				methods_HrOnboardingPendingPage.verifyAutoPopulatedDropdownField((String) jsonObject.get("Currency"), locators_HrOnboardingPendingPage.Currency);
				methods_HrOnboardingPendingPage.verifyAutoPopulatedField((String) jsonObject.get("Amount"), locators_HrOnboardingPendingPage.Amount);
				methods_HrOnboardingPendingPage.verifyAutoPopulatedDropdownField((String) jsonObject.get("Salary Type"), locators_HrOnboardingPendingPage.SalaryType);
				methods_HrOnboardingPendingPage.verifyAutoPopulatedField((String) jsonObject.get("Additional Comments"), locators_HrOnboardingPendingPage.AdditionalComments);
				methods_HrOnboardingPendingPage.verifyAutoPopulatedField((String) jsonObject.get("Suggested Company Email"), locators_HrOnboardingPendingPage.SuggestedCompanyEmail);
				methods_HrOnboardingPendingPage.verifyAutoPopulatedField((String) jsonObject.get("Suggested UserName"), locators_HrOnboardingPendingPage.SuggestedUserName);
				methods_HrOnboardingPendingPage.verifyAutoPopulatedField((String) jsonObject.get("Approved Company Email"), locators_HrOnboardingPendingPage.approvedCompanyEmail);
				methods_HrOnboardingPendingPage.verifyAutoPopulatedField((String) jsonObject.get("Approved UserName"), locators_HrOnboardingPendingPage.approvedUserName);

				
				ExtentTestManager.startTest("TC- 9 Verify editable Fields");
				methods_HrOnboardingPendingPage.areFieldsEditable();
				
				ExtentTestManager.startTest("TC- 10 Update SSN Upload Field by uploading a new PDF");	
				methods_HrOnboardingPendingPage.clickSSNUpload();
				String ssnFilePath = File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "NewSSN.pdf";	
				methods_HrOnboardingPendingPage.uploadFileUsingRobot(ssnFilePath);
				methods_HrOnboardingPendingPage.isSSNFileUploadSuccessfull("NewSSN.pdf");
//				
//				ExtentTestManager.startTest("TC- 11 Update Certificate Upload Field by uploading new PDFs");	
//				methods_HrOnboardingPendingPage.clickCertificateUpload();
//				String certificateFilePath2 = File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "Certificate2.pdf";
//				methods_HrOnboardingPendingPage.uploadFileUsingRobot(certificateFilePath2);
//				methods_HrOnboardingPendingPage.isCertificateFileUploadSuccessfull("Certificate2.pdf");
//				
//				methods_HrOnboardingPendingPage.clickCertificateUpload();
//				String certificateFilePath3 = File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "Certificate3.pdf";
//				methods_HrOnboardingPendingPage.uploadFileUsingRobot(certificateFilePath3);
//				methods_HrOnboardingPendingPage.isCertificateFileUploadSuccessfull("Certificate3.pdf");
//				
//				methods_HrOnboardingPendingPage.clickCertificateUpload();
//				String certificateFilePath4 = File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "Certificate.pdf";
//				methods_HrOnboardingPendingPage.uploadFileUsingRobot(certificateFilePath4);
//				methods_HrOnboardingPendingPage.isValidationPopupDisplayed();
//				methods_HrOnboardingPendingPage.dismissPopup();
				
				ExtentTestManager.startTest("TC- 11 Update 'Date of Joining' By selecting Another date");
				methods_HrOnboardingPendingPage.clickDateOfJoiningField();
				methods_HrOnboardingPendingPage.selectAnotherDate();
				
//				ExtentTestManager.startTest("TC- 13 Verify 'Parent Office' field is Empty");	
//				methods_HrOnboardingPendingPage.verifyParentOfficeFieldIsEmpty();
				
				ExtentTestManager.startTest("TC- 12 Verify 'Parent Office' field Selection");	
				methods_HrOnboardingPendingPage.selectParentOffice(parentOffice);
				methods_HrOnboardingPendingPage.validateParentOfficeSelection(parentOffice);
				
				ExtentTestManager.startTest("TC- 13 Click Update Button And Navigate To Table");	
				methods_HrOnboardingPendingPage.clickUpdateButton();
//				methods_HrOnboardingPendingPage.clickConfirmButtonForJoinMailSentPopup();
//				methods_HrOnboardingPendingPage.verifySavedCandidateFormClosed();
				
				ExtentTestManager.startTest("TC- 14 Search the employee and Verify Updated Fields");
				methods_HrOnboardingPendingPage.clickSearchIcon();
				methods_HrOnboardingPendingPage.isSearchDialogOpened();
				methods_HrOnboardingPendingPage.enterCandidateName();
				methods_HrOnboardingPendingPage.clickSearchButton();
				methods_HrOnboardingPendingPage.verifysearchedCandidateNameDisplayed();
				methods_HrOnboardingPendingPage.clickonSearchedCandidateName();
				methods_HrOnboardingPendingPage.verifyHrOnboardingPendingPage();
				
				methods_HrOnboardingPendingPage.isSSNFileUploadSuccessfull("NewSSN.pdf");
//				methods_HrOnboardingPendingPage.isCertificateFileUploadSuccessfull("Certificate.pdf");
//				methods_HrOnboardingPendingPage.isCertificateFileUploadSuccessfull("Certificate2.pdf");
//				methods_HrOnboardingPendingPage.isCertificateFileUploadSuccessfull("Certificate3.pdf");
				methods_HrOnboardingPendingPage.validateParentOfficeSelection(parentOffice);
				methods_HrOnboardingPendingPage.verifyDateOfJoiningField();
				
				ExtentTestManager.startTest("TC- 15 Verify Suggested Company Email Autofill");
				methods_CreateCandidatePage.verifySuggestedCompanyEmailAutofilled();
				
				ExtentTestManager.startTest("TC- 16 Verify Suggested Company UserName Autofill");
				methods_CreateCandidatePage.verifySuggestedCompanyUsernameAutofilled();				
				
				methods_HrOnboardingPendingPage.updateJsonFileWithNewValues();
				
				ExtentTestManager.startTest("TC- 17 Click Confirm Preboarding");
				methods_HrOnboardingPendingPage.clickConfirmPreboardingBtn();
				methods_HrOnboardingPendingPage.clickOkBtnForApprovedPopUp();
				

				
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
