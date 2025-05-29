package com.test.NewPreBoardingUS;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.BasePackage.Base_Class;
import com.Locators_PreBoardingUS.Locators_CreateCandidatePage;
import com.Locators_PreBoardingUS.Locators_HomePage;
import com.Pages_PreBoardingUSMethods.Methods_CreateCandidatePage;
import com.Pages_PreBoardingUSMethods.Methods_HomePage;
import com.Utility.Log;
import com.Utility.TriggerEmail;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.google.common.io.Files;

public class AllScenarios_001_CandidateCreation extends Base_Class {

	Methods_HomePage methods_HomePage;
	Methods_CreateCandidatePage methods_CreateCandidatePage;
	Locators_CreateCandidatePage locators_CreateCandidatePage;
	Log log;
	com.Utility.ScreenShot screenshot;
	com.Utility.ExcelReader ExcelReader;
	ExtentTest extenttest;
	SoftAssert Assert = new SoftAssert();

	// Setup method to initialize objects and perform setup
	
	@BeforeClass
	public void reference() throws InterruptedException {

		methods_HomePage = new Methods_HomePage();
		methods_CreateCandidatePage = new Methods_CreateCandidatePage();
		locators_CreateCandidatePage = new Locators_CreateCandidatePage();
		log = new Log();
		screenshot = new com.Utility.ScreenShot(driver);
		ExcelReader = new com.Utility.ExcelReader("CandidateCreation");		
	}
	
	@BeforeMethod
	public void setupTest(Method method) throws Exception {
		// Start a new ExtentTest for the current test method
		extenttest = ExtentTestManager.startTest(method.getName()).assignCategory("Candidate Creation");		
	}

	@Test(dataProvider = "TestData", priority=1)
	public void runAlllScenarios(Map<Object, Object> testdata, ITestContext context)
			throws IOException, InterruptedException {
		try {
			
			String userName = testdata.get("User Name").toString();
			String firstName = testdata.get("First Name").toString();
			String middleName = testdata.get("Middle Name").toString();
			String gender = testdata.get("Gender").toString();
			String maritalStatus = testdata.get("Marital Status").toString();
			String DOB_AgeBelow18Years = testdata.get("DOBMakingAgeBelow18Years(mm/dd/yyyy)").toString();
			String DOB_AgeAbove18Years = testdata.get("DOBMakingAgeAbove18Years(mm/dd/yyyy)").toString();
			String race = testdata.get("Race/Ethnicity").toString();
			String address = testdata.get("Address").toString();
			String invalidZipCode = testdata.get("Invalid Zipcode").toString();
			String validZipCode = testdata.get("Valid Zipcode").toString();
			String city = testdata.get("City").toString();
			String state = testdata.get("State").toString();
			String SSNnumber = testdata.get("SSN number").toString();
			String certificateIfAny = testdata.get("Certificate(if any)").toString();
			String reportingManager = testdata.get("Reporting Manager").toString();
			String designation = testdata.get("Designation").toString();
			String role = testdata.get("Role").toString();
			String businessUnit = testdata.get("Business Unit").toString();
			String division = testdata.get("Division").toString();
			String technology = testdata.get("Technology").toString();
			String department = testdata.get("Department").toString();
			String imigrationStatus = testdata.get("Imigration Status").toString();
			String visaType = testdata.get("Visa Type").toString();
			String employmentType = testdata.get("Employment Type").toString();
			String employmentSubType = testdata.get("Employment Sub Type").toString();
			String specialAccessNeeded = testdata.get("Special Access Needed").toString();
			String trainingRequired = testdata.get("Training Required").toString();
			String additionalTraining = testdata.get("Additional Training").toString();			
			String jobLocation = testdata.get("Job Location").toString();
			String invalidJobZipCode = testdata.get("Invalid Job ZipCode").toString();
			String validJobZipCode = testdata.get("Valid Job ZipCode").toString();
			String jobCity = testdata.get("Job City").toString();
			String jobState = testdata.get("Job State").toString();
			String amount = testdata.get("Amount").toString();
			String salary = testdata.get("Salary").toString();
			String additionalComments = testdata.get("Additional Comments").toString();
			
			if (testdata.get("Run").toString().equalsIgnoreCase("Yes")) {
				ExtentTestManager.startTest(testdata.get("TestScenario").toString());
				Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");
				context.setAttribute("fileName", "Login");
				SetUp(userName);
				ExtentTestManager.getTest().log(Status.PASS, "Successfully Logged in");

				ExtentTestManager.startTest("TC -2 Validating dashboad is displayed or not");
				verifySuccessfulLogin();
				validateDashBoard();
								
				ExtentTestManager.startTest("TC- 3 Navigate to Candidate Creation Page");
				methods_HomePage.navigateToEmployeeTab();
				methods_HomePage.clickOnBoarding();
				methods_HomePage.clickCreateCandidate();
				methods_CreateCandidatePage.verifyCandidateCreationForm();
				
				ExtentTestManager.startTest("TC- 4 Submit Candidate Creation Form without filling any Mandatory Fields");
				methods_CreateCandidatePage.clickSubmitBtn();
				methods_CreateCandidatePage.verifyValidationMessagesInMandatoryFields();	
				
				ExtentTestManager.startTest("TC- 5 Verify Hiring Classification Dropdown Selection");
				methods_CreateCandidatePage.selectHiringClassification("Intern");
				methods_CreateCandidatePage.validateHiringCLassificationSelection("Intern");
								
				ExtentTestManager.startTest("TC- 6 Verify Rehire Field Enable and Disable");
				methods_CreateCandidatePage.isReHireFieldDisabled();
				methods_CreateCandidatePage.selectHiringClassification("Rehire");
				methods_CreateCandidatePage.isReHireFieldEnabled();
								
				ExtentTestManager.startTest("TC- 7 Verify Rehire Dialogue Box");
				methods_CreateCandidatePage.clickRehireField();
				methods_CreateCandidatePage.validateRehireDialogueBox();
				methods_CreateCandidatePage.cancelRehireDialogueBox();
				methods_CreateCandidatePage.selectHiringClassification("Intern");
				
				ExtentTestManager.startTest("TC- 8 Verify First Name Field");
				methods_CreateCandidatePage.enterFirstName(firstName);
				methods_CreateCandidatePage.validateFirstName();
				
				ExtentTestManager.startTest("TC- 9 Verify Middle Name Field");
				methods_CreateCandidatePage.enterMiddleName(middleName);
				methods_CreateCandidatePage.validateMiddleName();
				
				ExtentTestManager.startTest("TC- 10 Verify Last Name Field");
				methods_CreateCandidatePage.enterLastName();
				methods_CreateCandidatePage.validateLastName();
				
				ExtentTestManager.startTest("TC- 11 Verify Preferred Name Field Auto filled");
				methods_CreateCandidatePage.validatePreferredNameAutoFilled();
				
				ExtentTestManager.startTest("TC- 12 Verify Personal Email Field");
				methods_CreateCandidatePage.enterPersonalEmail();
				methods_CreateCandidatePage.validatePersonalEmailField();
				
				ExtentTestManager.startTest("TC- 13 Verify Contact Number Field");
				methods_CreateCandidatePage.enterContactNumber();
				methods_CreateCandidatePage.validateContactNumberField();
				
				ExtentTestManager.startTest("TC- 14 Verify 'Gender' Selection");
				methods_CreateCandidatePage.selectGender(gender);
				methods_CreateCandidatePage.validateGenderSelection(gender);
				
				ExtentTestManager.startTest("TC- 15 Verify 'Marital Status' Selection");
				methods_CreateCandidatePage.selectMaritalStatus(maritalStatus);
				methods_CreateCandidatePage.validateMaritalStatusSelection(maritalStatus);
				
				ExtentTestManager.startTest("TC- 16 Verify 'Date Of Birth' Underage Validation");
				methods_CreateCandidatePage.enterDateOfBirth(DOB_AgeBelow18Years);
				methods_CreateCandidatePage.validateDobErrorMessage();
				
				ExtentTestManager.startTest("TC- 17 Verify 'Date Of Birth' by entering a date making the age above 18 years");
				methods_CreateCandidatePage.enterDateOfBirth(DOB_AgeAbove18Years);
				methods_CreateCandidatePage.validateDobNoErrorMessage();
			
				ExtentTestManager.startTest("TC- 18 Verify 'Race/Ethnicity' Selection");
				methods_CreateCandidatePage.selectRace_Ethnicity(race);
				methods_CreateCandidatePage.validateRace_EthnicitySelection(race);

				ExtentTestManager.startTest("TC- 19 Verify 'Address Line 1' Field");
				methods_CreateCandidatePage.enterAddressLine1(address);
				methods_CreateCandidatePage.validateAddressLine1Field();
				
				ExtentTestManager.startTest("TC- 20 Verify Invalid ZipCode Message");
				methods_CreateCandidatePage.enterZipCode(invalidZipCode);
				methods_CreateCandidatePage.getZipCodeValidationMessage();
				
				ExtentTestManager.startTest("TC- 21 Verify ZipCode Auto Fill Logic");
				methods_CreateCandidatePage.enterZipCode(validZipCode);
				methods_CreateCandidatePage.verifyCity(city);
				methods_CreateCandidatePage.verifyState(state);
				
				ExtentTestManager.startTest("TC- 22 Verify Attach Resume");	
				methods_CreateCandidatePage.clickAttachResume();
				String resumeFilePath = File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "Resume.pdf";
				methods_CreateCandidatePage.uploadFileUsingRobot(resumeFilePath);
				methods_CreateCandidatePage.isResumeFileUploadSuccessfull("Resume.pdf");

				ExtentTestManager.startTest("TC- 23 Verify SSN Number Field");
				methods_CreateCandidatePage.enterSSNNumber(SSNnumber);
//				methods_CreateCandidatePage.validateSSNNumberField();
				
				ExtentTestManager.startTest("TC- 24 Verify SSN Upload Field");	
				methods_CreateCandidatePage.clickSSNUpload();
				String ssnFilePath = File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "SSN.pdf";
				methods_CreateCandidatePage.uploadFileUsingRobot(ssnFilePath);
				methods_CreateCandidatePage.isSSNFileUploadSuccessfull("SSN.pdf");
				
				ExtentTestManager.startTest("TC- 25 Verify Certificare(if any) Field");
				methods_CreateCandidatePage.enterInCertificateIfAny(certificateIfAny);
				methods_CreateCandidatePage.validateCertificateIfAnyField();
				
				ExtentTestManager.startTest("TC- 26 Verify Certificate Upload Field");	
				methods_CreateCandidatePage.clickCertificateUpload();
				String certificateFilePath = File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "Certificate.pdf";
				methods_CreateCandidatePage.uploadFileUsingRobot(certificateFilePath);
				methods_CreateCandidatePage.isCertificateFileUploadSuccessfull("Certificate.pdf");
				
				ExtentTestManager.startTest("TC- 27 Verify Reporting Manager selection");
				methods_CreateCandidatePage.selectReportingManager(reportingManager);
				methods_CreateCandidatePage.validateReportingMangerSelection(reportingManager);
				
				ExtentTestManager.startTest("TC- 28 Verify Designation selection");
				methods_CreateCandidatePage.selectDesignation(designation);
				methods_CreateCandidatePage.validateDesignationSelection(designation);
				
				ExtentTestManager.startTest("TC- 29 Verify Role search and selection");
				methods_CreateCandidatePage.searchAndSelectRole(role);
				methods_CreateCandidatePage.validateRoleSelection(role);
				
				ExtentTestManager.startTest("TC- 30 Verify 'Business Unit' selection");
				methods_CreateCandidatePage.selectBusinessUnit(businessUnit);
				methods_CreateCandidatePage.validateBusinessUnitSelection(businessUnit);
				
				ExtentTestManager.startTest("TC- 31 Verify 'Division' Field selection");
				methods_CreateCandidatePage.selectDivision(division);
				methods_CreateCandidatePage.validateDivisionSelection(division);
				
				ExtentTestManager.startTest("TC- 32 Verify 'Technology' Field selection");
				methods_CreateCandidatePage.selectTechnology(technology);
				methods_CreateCandidatePage.validateTechnologySelection(technology);
				
				ExtentTestManager.startTest("TC- 33 Verify 'Department' Field selection");
				methods_CreateCandidatePage.selectDepartment(department);
				methods_CreateCandidatePage.validateDepartmentSelection(department);
				
				ExtentTestManager.startTest("TC- 34 Verify 'Imigration Status' Field selection");
				methods_CreateCandidatePage.selectImmigrationStatus(imigrationStatus);
				methods_CreateCandidatePage.validateImmigrationStatusSelection(imigrationStatus);
				
				ExtentTestManager.startTest("TC- 35 Verify 'Visa Type' Field selection");
				methods_CreateCandidatePage.selectVisaType(visaType);
				methods_CreateCandidatePage.validateVisaTypeSelection(visaType);
				
				ExtentTestManager.startTest("TC- 36 Verify Past Dates Are Disabled for Date of Joining Calender");
				methods_CreateCandidatePage.clickDateOfJoiningField();
				methods_CreateCandidatePage.isPastDateDisabled();
				
				ExtentTestManager.startTest("TC- 37 Verify Date of Joining By selecting Futute date");
				methods_CreateCandidatePage.selectFutureDate();
				
				ExtentTestManager.startTest("TC- 38 Verify 'Employment Type' Field selection");
				methods_CreateCandidatePage.selectEmploymentType(employmentType);
				methods_CreateCandidatePage.validateEmploymentTypeSelection(employmentType);
				
				ExtentTestManager.startTest("TC- 39 Verify 'Employment Sub Type' Field selection");
				methods_CreateCandidatePage.selectEmploymentSubType(employmentSubType);
				methods_CreateCandidatePage.validateEmploymentSubTypeSelection(employmentSubType);
							
				ExtentTestManager.startTest("TC- 40 Verify Special Access Needed Field");
				methods_CreateCandidatePage.enterSpecialAccessNeeded(specialAccessNeeded);
				methods_CreateCandidatePage.validateSpecialAccessNeededField();
				
				ExtentTestManager.startTest("TC- 41 Verify Training Required Field");
				methods_CreateCandidatePage.enterTrainingRequired(trainingRequired);
				methods_CreateCandidatePage.validateTrainingRequiredField();
				
				ExtentTestManager.startTest("TC- 42 Verify Additional Training Field");
				methods_CreateCandidatePage.enterAdditionalTraining(additionalTraining);
				methods_CreateCandidatePage.validateAdditionalTrainingField();
				
				ExtentTestManager.startTest("TC- 43 Verify 'Eligible For Benefits' Default Value");
				methods_CreateCandidatePage.isEligibleForBenefitsNoSelected();
								
				ExtentTestManager.startTest("TC- 44 Verify 'Laptop Required' Default Value");
				methods_CreateCandidatePage.isLaptopRequiredYesSelected();
				
				ExtentTestManager.startTest("TC- 45 Verify 'Background Check Required' Default Value");
				methods_CreateCandidatePage.isBackgroundCheckRequiredYesSelected();
				
				ExtentTestManager.startTest("TC- 46 Verify 'Add Distribution List' Default Value");
				methods_CreateCandidatePage.isAddDistributionListNoSelected();
				
				ExtentTestManager.startTest("TC- 47 Verify Benefits Waiver Form Upload");	
				methods_CreateCandidatePage.clickBenefitsFormUpload();
				String benefitsWaiverFormFilePath = File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "BenefitsWaiverForm.pdf";
				methods_CreateCandidatePage.uploadFileUsingRobot(benefitsWaiverFormFilePath);
				methods_CreateCandidatePage.isBenefitsWaiverFileUploadSuccessfull("BenefitsWaiverForm.pdf");
				
				ExtentTestManager.startTest("TC- 48 Verify 'Job Location' Selection");
				methods_CreateCandidatePage.selectJobLocation(jobLocation);
				methods_CreateCandidatePage.validateJobLocationSelection(jobLocation);
				
				ExtentTestManager.startTest("TC- 49 Verify Default Country");
				methods_CreateCandidatePage.getDefaultCountry();
				
				ExtentTestManager.startTest("TC- 50 Verify Invalid Job ZipCode Message");
				methods_CreateCandidatePage.enterJobZipCode(invalidJobZipCode);
				methods_CreateCandidatePage.getJobZipCodeValidationMessage();
				
				ExtentTestManager.startTest("TC- 51 Verify Job ZipCode Auto Fill Logic");
				methods_CreateCandidatePage.enterJobZipCode(validJobZipCode);
				methods_CreateCandidatePage.verifyJobCity(jobCity);
				methods_CreateCandidatePage.verifyJobState(jobState);
				
				ExtentTestManager.startTest("TC- 52 Verify Default Currency");
				methods_CreateCandidatePage.getDefaultCurrency();
	
				ExtentTestManager.startTest("TC- 53 Verify Amount Field");
				methods_CreateCandidatePage.enterAmount(amount);
				methods_CreateCandidatePage.verifyAmountField();
				
				ExtentTestManager.startTest("TC- 54 Verify 'Salary' Selection");
				methods_CreateCandidatePage.selectSalary(salary);
				methods_CreateCandidatePage.validateSalarySelection(salary);
				
				ExtentTestManager.startTest("TC- 55 Verify Additional Comments Field");
				methods_CreateCandidatePage.enterAdditionalComments(additionalComments);
				methods_CreateCandidatePage.validateAdditionalCommentsField();			
				methods_CreateCandidatePage.createJsonFileForEnteredValues();
				
				ExtentTestManager.startTest("TC- 58 Form Submission");
				methods_CreateCandidatePage.clickSubmitBtn();
				methods_CreateCandidatePage.clickConfirmButtonForMailCreationRequestedPopup();
				
//				ExtentTestManager.startTest("TC- 59 Verify Created Candidate");
//				methods_CreateCandidatePage.clickSearchIcon();
//				methods_CreateCandidatePage.searchCandideName();
//				methods_CreateCandidatePage.verifysearchedCandidateNameDisplayed();
				
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