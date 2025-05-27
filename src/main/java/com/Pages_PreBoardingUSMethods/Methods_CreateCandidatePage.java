package com.Pages_PreBoardingUSMethods;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestContext;
import org.testng.asserts.SoftAssert;

import com.BasePackage.Base_Class;
import com.Locators_PreBoardingUS.Locators_CreateCandidatePage;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Methods_CreateCandidatePage extends Base_Class {

	SoftAssert Assert;

	//to read from json file
	JSONParser parser = new JSONParser();

	Locators_CreateCandidatePage locators = new Locators_CreateCandidatePage();

	public void clickAddNewBtn() throws InterruptedException {
		WaitForLoaderToDisappear();
		click(locators.AddNewBtn);
		
		ExtentTestManager.getTest().log(Status.PASS, "Clicked on 'Add New' Button");
		WaitForLoaderToDisappear();
	}

	public void verifyCandidateCreationForm() throws InterruptedException {
		WaitForLoaderToDisappear();
		boolean flag = ElementDisplayed(locators.CandidateCreationForm);
	
		ExtentTestManager.getTest().log(Status.PASS, "New Candidate Creation Form is displayed : " + flag);
	}

	public void clickSubmitBtn() throws InterruptedException {
		WaitForLoaderToDisappear();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});",
				driver.findElement(locators.SubmitBtn));
		click(locators.SubmitBtn);
		WaitForLoaderToDisappear();
		
		ExtentTestManager.getTest().log(Status.PASS, "Clicked 'Submit' Button");
		Log.info("Clicked 'Submit' Button");
	}
	
	public void clickConfirmButtonForMailCreationRequestedPopup() throws InterruptedException {
		WaitForLoaderToDisappear();
		WaitForElementToBeVisible(locators.MailCreationRequest_OkBtn);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});",
				driver.findElement(locators.MailCreationRequest_OkBtn));
		click(locators.MailCreationRequest_OkBtn);
		WaitForLoaderToDisappear();
		
		ExtentTestManager.getTest().log(Status.PASS, "Clicked 'OK' Button in Mail Creation Requested Popup");
		Log.info("Clicked 'OK' Button in Mail Creation Requested Popup");
	}

	public void verifyValidationMessagesInMandatoryFields() {

		try {
			Assert = new SoftAssert();
			Assert.assertTrue(
					isValidationMessageDisplayed(driver.findElement(locators.HiringClassificationValidationMsg),
							"Hiring Classification is required."));
			Assert.assertTrue(isValidationMessageDisplayed(driver.findElement(locators.FirstNameValidationMsg),
					"First name is required."));
			Assert.assertTrue(isValidationMessageDisplayed(driver.findElement(locators.LasttNameValidationMsg),
					"Last name is required."));
			Assert.assertTrue(isValidationMessageDisplayed(driver.findElement(locators.PersonalEmailValidationMsg),
					"Personal email required."));
			Assert.assertTrue(isValidationMessageDisplayed(driver.findElement(locators.ContactNumberValidationMsg),
					"Valid Contact Number is required."));
			Assert.assertTrue(isValidationMessageDisplayed(driver.findElement(locators.DateoFBirthValidationMsg),
					"Date of birth is required."));
			Assert.assertTrue(isValidationMessageDisplayed(driver.findElement(locators.Race_EthnicityValidationMsg),
					"Ethnic Origin is required."));
			Assert.assertTrue(isValidationMessageDisplayed(driver.findElement(locators.AddressLine1ValidationMsg),
					"Address is required."));
			Assert.assertTrue(isValidationMessageDisplayed(driver.findElement(locators.ZipCodeValidationMsg),
					"Zip code is required."));
			Assert.assertTrue(isValidationMessageDisplayed(driver.findElement(locators.CityValidationMsg),
					"City is required."));			
			Assert.assertTrue(isValidationMessageDisplayed(driver.findElement(locators.StateValidationMsg),
					"State is required."));
			Assert.assertTrue(isValidationMessageDisplayed(driver.findElement(locators.AttachResumeValidationMsg),
					"Upload Resume."));
			Assert.assertTrue(isValidationMessageDisplayed(driver.findElement(locators.ReportingManagerValidationMsg),
					"Reporting manager is required."));
			Assert.assertTrue(isValidationMessageDisplayed(driver.findElement(locators.DesignationValidationMsg),
					"Designation is required."));
			Assert.assertTrue(isValidationMessageDisplayed(driver.findElement(locators.BusinessUnitValidationMsg),
					"Project BU is required."));
			Assert.assertTrue(isValidationMessageDisplayed(driver.findElement(locators.DivisionValidationMsg),
					"Division is required."));
			Assert.assertTrue(isValidationMessageDisplayed(driver.findElement(locators.TechnologyValidationMsg),
					"Technology is required."));
			Assert.assertTrue(isValidationMessageDisplayed(driver.findElement(locators.DepartmentValidationMsg),
					"Department is required."));
			Assert.assertTrue(isValidationMessageDisplayed(driver.findElement(locators.VisaTypeValidationMsg),
					"Visa Type is required."));
			Assert.assertTrue(isValidationMessageDisplayed(driver.findElement(locators.DateOfJoiningValidationMsg),
					"Valid date of joining is required."));
			Assert.assertTrue(isValidationMessageDisplayed(driver.findElement(locators.EmploymentTypeValidationMsg),
					"Employment Type is required."));
			Assert.assertTrue(isValidationMessageDisplayed(driver.findElement(locators.BenefitsWaiverFormValidationMsg),
					"Upload Benefits Waiver Form."));
			Assert.assertTrue(isValidationMessageDisplayed(driver.findElement(locators.AmountValidationMsg),
					"Amount is required."));
			Assert.assertTrue(isValidationMessageDisplayed(driver.findElement(locators.SalaryTypeValidationMsg),
					"Salary type is required."));
			Assert.assertAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public boolean isValidationMessageDisplayed(WebElement fieldErrorElement, String expectedMessage) {
		boolean isMessageDisplayed = fieldErrorElement.getText().equals(expectedMessage);

		if (isMessageDisplayed) {
			ExtentTestManager.getTest().log(Status.PASS,"Validation message is displayed correctly: " + expectedMessage);
			Log.info("Validation message is displayed correctly: " + expectedMessage);
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "Validation message is not displayed as expected. Expected: "+ expectedMessage + ", Found: " + fieldErrorElement.getText());
			Log.info("Validation message is not displayed as expected. Expected: "+ expectedMessage + ", Found: " + fieldErrorElement.getText());
		}
		return isMessageDisplayed;
	}

	public void selectHiringClassification(String classification) {

		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});",
					driver.findElement(locators.HiringClassification));
			Select dropdown = new Select(driver.findElement(locators.HiringClassification));
			dropdown.selectByVisibleText(classification);
		
			ExtentTestManager.getTest().log(Status.PASS,"Option selected from Hiring Classification dropdown : " + classification);
			Log.info("Option selected from Hiring Classification dropdown : "+ classification);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL,"Expected to select " + classification + " from Hiring Classification dropdown");
			Log.info("Expected to select " + classification + " from Hiring Classification dropdown");
		}
	}

	public void validateHiringCLassificationSelection(String classification) {
		Select dropdown = new Select(driver.findElement(locators.HiringClassification));
		WebElement selectedOption = dropdown.getFirstSelectedOption();
		String actualValue = selectedOption.getText();
		if (actualValue.equals(classification)) {
			ExtentTestManager.getTest().log(Status.PASS,"Selected dropdown " + actualValue + " is shown in Hiring Classification Field");
			Log.info("Selected dropdown " + actualValue + " is shown in Hiring Classification Field");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "Expected " + classification + ", but found:" + actualValue);
			Log.info("Expected " + classification + ", but found:" + actualValue);
		}
	}

	public boolean isReHireFieldDisabled() {

		boolean isReHireFieldEnabled = driver.findElement(locators.ReHire).isEnabled();
		if (!isReHireFieldEnabled) {
			ExtentTestManager.getTest().log(Status.PASS, "Re Hire field disabled by default");
			Log.info("Re Hire field disabled by default");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "Re Hire field is enabled by default");
			Log.info("Re Hire field is enabled by default");
		}
		return isReHireFieldEnabled;
	}

	public boolean isReHireFieldEnabled() {
		boolean isReHireFieldEnabled = driver.findElement(locators.ReHire).isEnabled();

		if (isReHireFieldEnabled) {
			ExtentTestManager.getTest().log(Status.PASS,"Re Hire field is enabled when Rehire option is selected from Hiring Classification dropdown");
			Log.info("Re Hire field is enabled when Rehire option is selected from Hiring Classification dropdown");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL,"Re Hire field is disabled when Rehire option is selected from Hiring Classification dropdown");
			Log.info("Re Hire field is disabled when Rehire option is selected from Hiring Classification dropdown");
		}
		return isReHireFieldEnabled;
	}

	public void clickRehireField() throws InterruptedException {
		try {
			click(locators.ReHire);
			WaitForLoaderToDisappear();
		} catch (Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL, "Failed to click Rehire Field");
		}
	}

	public void validateRehireDialogueBox() throws InterruptedException {

		try {

			Assert = new SoftAssert();

			boolean isReHireDialogueBoxPresent = driver.findElement(locators.ReHireDialogueBox).isDisplayed();
			ExtentTestManager.getTest().log(isReHireDialogueBoxPresent ? Status.PASS : Status.FAIL,
					"Rehire Dialogue Box " + (isReHireDialogueBoxPresent ? "is Displayed" : "is not Displayed"));
			Assert.assertTrue(isReHireDialogueBoxPresent, "Rehire Dialogue Box is not Displayed");

			Assert.assertTrue(driver.findElement(locators.ReHireDialogueBox_EmployeeColumn).isDisplayed(),
					"List of Employees is not Displayed in Rehire Dialogue Box");
			ExtentTestManager.getTest().log(Status.PASS, "'List of Employees' is Displayed in Rehire Dialogue Box");

			Assert.assertTrue(driver.findElement(locators.ReHireDialogueBox_dateOfJoiningColumn).isDisplayed(),
					"Date of Joining Column is not Displayed in Rehire Dialogue Box");
			ExtentTestManager.getTest().log(Status.PASS,
					"'Date of Joining' Column is Displayed in Rehire Dialogue Box");

			Assert.assertTrue(driver.findElement(locators.ReHireDialogueBox_dateOfRelieving).isDisplayed(),
					"Date of Relieving Column is not Displayed in Rehire Dialogue Box");
			ExtentTestManager.getTest().log(Status.PASS,
					"'Date of Relieving' Column is Displayed in Rehire Dialogue Box");

			Assert.assertTrue(driver.findElement(locators.ReHireDialogueBox_oKBtn).isDisplayed(),
					"Ok Button is not Displayed in Rehire Dialogue Box");
			ExtentTestManager.getTest().log(Status.PASS, "Ok Button is Displayed in Rehire Dialogue Box");

			Assert.assertTrue(driver.findElement(locators.ReHireDialogueBox_cancelBtn).isDisplayed(),
					"Cancel Button is not Displayed in Rehire Dialogue Box");
			ExtentTestManager.getTest().log(Status.PASS, "Cancel Button is Displayed in Rehire Dialogue Box");

			Assert.assertAll();
		} catch (Error e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL, "Assertion failed: " + e.getMessage());
		} catch (Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL,
					"Failed to validate Rehire Dialogue box" + "\n" + e.getMessage());
		}
	}

	public void cancelRehireDialogueBox() throws InterruptedException {

		try {
			if (driver.findElement(locators.ReHireDialogueBox_cancelBtn).isDisplayed()) {
				click(locators.ReHireDialogueBox_cancelBtn);
				ExtentTestManager.getTest().log(Status.PASS, "Cancelled Rehire Dialogue Box");
				Log.info("Cancelled Rehire Dialogue Box");
			} else {
				System.out.println("Rehire dialogue box Cancelled");
			}
		} catch (Exception e) {
			System.out.println("Rehire dialogue box Cancelled");
		}

	}

	public void enterFirstName(String firstName) throws InterruptedException {
		try {
			clear(locators.FirstName);
			input(locators.FirstName, firstName);
			ExtentTestManager.getTest().log(Status.INFO, "Entered First Name :" + firstName);
			Log.info("Entered First Name :" + firstName);
		} catch (Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL, "Failed to enter First Name");
			Log.info("Failed to enter First Name");
		}
	}

	public String validateFirstName() {
		String firstName = "";
		try {
			firstName = driver.findElement(locators.FirstName).getAttribute("value");
			if (firstName.matches("[a-zA-Z]+")) {
				ExtentTestManager.getTest().log(Status.PASS,"First Name fields accepts only Alphabetic inputs : " + firstName);
				Log.info("First Name fields accepts only Alphabetic inputs : " + firstName);
			} else {
				ExtentTestManager.getTest().log(Status.FAIL,"First Name fields accepts non Alphabetic inputs also : " + firstName);
				Log.info("First Name fields accepts non Alphabetic inputs also : " + firstName);
			}
		} catch (Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL, "Fails to Validate First Name");
			Log.info("Fails to Validate First Name");
		}
		return firstName;
	}

	public void enterMiddleName(String middleName) throws InterruptedException {
		
		try {
			clear(locators.MiddleName);
			input(locators.MiddleName, middleName);
			ExtentTestManager.getTest().log(Status.INFO, "Entered Middle Name :" + middleName);
			Log.info("Entered Middle Name :" + middleName);
		} catch (Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL, "Failed to enter Middle Name");
			Log.info("Failed to enter Middle Name");
		}
	}

	public void validateMiddleName() {
		try {
			String middletName = driver.findElement(locators.MiddleName).getAttribute("value");
			if (middletName.matches("[a-zA-Z]+")) {
				ExtentTestManager.getTest().log(Status.PASS,"Middle Name fields accepts only Alphabetic inputs : " + middletName);
				Log.info("Middle Name fields accepts only Alphabetic inputs : " + middletName);
			} else {
				ExtentTestManager.getTest().log(Status.FAIL,"Middle Name fields accepts non Alphabetic inputs also : " + middletName);
				Log.info("Middle Name fields accepts non Alphabetic inputs also : " + middletName);
			}
		} catch (Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL, "Fails to Validate Middle Name");
			Log.info("Fails to Validate Middle Name");
		}
	}
	
	public void enterLastName() throws InterruptedException {
		String lastName = generateRandomName();
		String combinedInput = lastName + "123" + "@$%";
		clear(locators.LastName);
		input(locators.LastName, combinedInput);
		ExtentTestManager.getTest().log(Status.INFO, "Entered Last Name :" + combinedInput);
		Log.info("Entered Last Name :" + combinedInput);
	}

	public String validateLastName() {

		String lastName = "";
		try {
			lastName = driver.findElement(locators.LastName).getAttribute("value");
			if (lastName.matches("[a-zA-Z]+")) {
				ExtentTestManager.getTest().log(Status.PASS,"Last Name fields accepts only Alphabetic inputs : " + lastName);
				Log.info("Last Name fields accepts only Alphabetic inputs : " + lastName);
			} else {
				ExtentTestManager.getTest().log(Status.FAIL,"Last Name fields accepts non Alphabetic inputs also : " + lastName);
				Log.info("Last Name fields accepts non Alphabetic inputs also : " + lastName);
			}
		} catch (Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL, "Fails to Validate Last Name");
			Log.info("Fails to Validate Last Name");
		}
		return lastName;
	}

	public void validatePreferredNameAutoFilled() {
		try {
			String firstName = validateFirstName();
			String lastName = validateLastName();

			click(locators.PreferredName);
			String preferredName = driver.findElement(locators.PreferredName).getAttribute("value");
			if (preferredName.contains(firstName) && preferredName.contains(lastName)) {
//				writePreferredNameToProperties(preferredName);
				ExtentTestManager.getTest().log(Status.PASS,"Preferred Name Field is auto filled with First name and Last name : " + preferredName);
				Log.info("Preferred Name Field is auto filled with First name and Last name : " + preferredName);
			} else {
				ExtentTestManager.getTest().log(Status.FAIL,"Preferred Name Field is not auto filled with First name and Last name : " + preferredName);
				Log.info("Preferred Name Field is not auto filled with First name and Last name : " + preferredName);
			}
		} catch (Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL, "Fails to Validate Preferred Name");
			Log.info("Fails to Validate Preferred Name");
		}
	}
	
//	public String getPreferredName() {
//        return preferredName;
//    }
	
//	public static void writePreferredNameToProperties(String preferredName) {
//        Properties properties = new Properties();
//        try {
//        	FileInputStream inputStream = new FileInputStream(".\\src\\test\\resources\\config.properties");
//            properties.load(inputStream);
//            inputStream.close();
//
//            properties.setProperty("preferredName", preferredName);
//            
//            FileOutputStream outputStream = new FileOutputStream(".\\src\\test\\resources\\config.properties");
//            properties.store(outputStream, null);
//            outputStream.close();
//        } catch (IOException e) {
//            System.out.println("Error writing to properties file: " + e.getMessage());
//        }
//    }
	
	public static String generateRandomEmail() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String domain = "@example.com"; // You can change the domain if needed

        Random random = new Random();
        StringBuilder email = new StringBuilder();

 
        int usernameLength = 4 + random.nextInt(5);
        for (int i = 0; i < usernameLength; i++) {
            email.append(alphabet.charAt(random.nextInt(alphabet.length())));
        }

        int numberCount = 2 + random.nextInt(3);
        for (int i = 0; i < numberCount; i++) {
            email.append(numbers.charAt(random.nextInt(numbers.length())));
        }

        // Append the domain
        email.append(domain);

        return email.toString();
    }
	
	public void enterPersonalEmail() throws InterruptedException {
		String email =generateRandomEmail();
		clear(locators.PersonalEmail);
		input(locators.PersonalEmail, email);
		ExtentTestManager.getTest().log(Status.INFO, "Entered Personal email :" + email);
		Log.info("Entered Personal email :" + email);
	}

	public void validatePersonalEmailField() {
		try {
			String enteredEmail = driver.findElement(locators.PersonalEmail).getAttribute("value").trim();
			if ( driver.findElements(locators.PersonalEmailValidationMsg).isEmpty()) {
			    ExtentTestManager.getTest().log(Status.PASS, "Entered email is valid : "+enteredEmail+" and no validation message is shown.");
			    Log.info("Entered email is valid : "+enteredEmail+" and no validation message is shown.");
			} else {
			    ExtentTestManager.getTest().log(Status.FAIL, "Either the email is incorrect or a validation message is displayed.");
			    Log.info("Either the email is incorrect or a validation message is displayed.");
			}
		} catch (Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL, "Fails to Validate Personal Email Field");
			Log.info("Fails to Validate Personal Email Field");
		}
	}

	public static String generateRandomContactNumber() {
        Random random = new Random();
        
        int firstDigit = random.nextInt(9) + 1; 
        StringBuilder contactNumber = new StringBuilder();
        contactNumber.append(firstDigit);
        
        for (int i = 0; i < 9; i++) {
            contactNumber.append(random.nextInt(10)); 
        }
        return contactNumber.toString();
    }
	
	public void enterContactNumber() throws InterruptedException {
		String number= generateRandomContactNumber();
		String combinedInput = "12$#"+number;
		clear(locators.ContactNumber);
		input(locators.ContactNumber, combinedInput);
		ExtentTestManager.getTest().log(Status.INFO, "Entered Contact Number :" + combinedInput);
		Log.info("Entered Contact Number :" + combinedInput);
	}

	public void validateContactNumberField() {

		try {
			String contactNumber = driver.findElement(locators.ContactNumber).getAttribute("value").replaceAll("[()\\- ]", "");			
			if (contactNumber.matches("\\d+")) {
				ExtentTestManager.getTest().log(Status.PASS,"Contact Number fields accepts only Numeric inputs : " + contactNumber);
				Log.info("Contact Number fields accepts only Numeric inputs : " + contactNumber);
			} else {
				ExtentTestManager.getTest().log(Status.FAIL,"Contact Number fields accepts non Numeric inputs also : " + contactNumber);
				Log.info("Contact Number fields accepts non Numeric inputs also : " + contactNumber);
			}
		} catch (Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL, "Fails to Validate Contact Number Field");
			Log.info("Fails to Validate Contact Number Field");
		}
	}
	
	public void enterSSNNumber(String SSNnumber) throws InterruptedException {
		try {
			clear(locators.SSN_Number);
			Thread.sleep(1000);
			driver.findElement(locators.SSN_Number).sendKeys(String.valueOf(SSNnumber));
			ExtentTestManager.getTest().log(Status.PASS, "Entered SSN Number :" + SSNnumber);
			Log.info("Entered SSN Number :" + SSNnumber);
		} catch (Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL, "Fails to enter SSN Number");
			Log.info("Fails to enter SSN Number");
		}
	}

	public void validateSSNNumberField() {

		try {
			String SSNnumber = driver.findElement(locators.ContactNumber).getText();
			System.out.println("SSN Number : "+SSNnumber);
			if (SSNnumber.matches("\\(\\d{3}\\) \\d{2}-\\d{4}")) {
				ExtentTestManager.getTest().log(Status.PASS,"SSN Number fields accepts only Numeric inputs : " + SSNnumber);
				Log.info("SSN Number fields accepts only Numeric inputs : " + SSNnumber);
			} else {
				ExtentTestManager.getTest().log(Status.FAIL,"SSN Number fields accepts non Numeric inputs also : " + SSNnumber);
				Log.info("SSN Number fields accepts non Numeric inputs also : " + SSNnumber);
			}
		} catch (Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL, "Fails to Validate SSN Number Field");
			Log.info("Fails to Validate SSN Number Field");
		}
	}

	public void selectGender(String gender) {
		
		try {			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", driver.findElement(locators.Gender));
			Select dropdown = new Select(driver.findElement(locators.Gender));
			dropdown.selectByVisibleText(gender);
			ExtentTestManager.getTest().log(Status.PASS, "Option selected from Gender dropdown : " + gender);
			Log.info("Option selected from Gender dropdown : " + gender);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Expected to select " + gender + " from Gender dropdown");
			Log.info("Expected to select " + gender + " from Gender dropdown");
		}
	}

	public void validateGenderSelection(String gender) {

		Select dropdown = new Select(driver.findElement(locators.Gender));
		WebElement selectedOption = dropdown.getFirstSelectedOption();
		String actualValue = selectedOption.getText();
		if (actualValue.equals(gender)) {
			ExtentTestManager.getTest().log(Status.PASS,"Selected dropdown '" + actualValue + "' is shown in Gender Field");
			Log.info("Selected dropdown '" + actualValue + "' is shown in Gender Field");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "Expected " + gender + ", but found:" + actualValue);
			Log.info("Expected " + gender + ", but found:" + actualValue);
		}
	}

	public void selectMaritalStatus(String maritalStatus) {

		
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});",driver.findElement(locators.MaritalStatus));
			Select dropdown = new Select(driver.findElement(locators.MaritalStatus));
			dropdown.selectByVisibleText(maritalStatus);
			ExtentTestManager.getTest().log(Status.PASS,"Option selected from Marital Status dropdown : " + maritalStatus);
			Log.info("Option selected from Marital Status dropdown : " + maritalStatus);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL,"Expected to select " + maritalStatus + " from Marital Status dropdown");
			Log.info("Expected to select " + maritalStatus + " from Marital Status dropdown");
		}
	}

	public void validateMaritalStatusSelection(String maritalStatus) {
		
		Select dropdown = new Select(driver.findElement(locators.MaritalStatus));
		WebElement selectedOption = dropdown.getFirstSelectedOption();
		String actualValue = selectedOption.getText();
		if (actualValue.equals(maritalStatus)) {
			ExtentTestManager.getTest().log(Status.PASS,"Selected dropdown '" + actualValue + "' is shown in Marital Status Field");
			Log.info("Selected dropdown '" + actualValue + "' is shown in Marital Status Field");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "Expected " + maritalStatus + ", but found:" + actualValue);
			Log.info("Expected " + maritalStatus + ", but found:" + actualValue);
		}
	}
	
	public void enterDateOfBirth(String DOB) throws InterruptedException {	
		
		try {
			Thread.sleep(1000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].value = '';", driver.findElement(locators.DateOfBirth));
			input(locators.DateOfBirth,DOB);
			ExtentTestManager.getTest().log(Status.PASS,"Entered Date of Birth : " +DOB);
			Log.info("Entered Date of Birth : " +DOB);
		} catch (Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL, "Fails to enter DOB");
			Log.info("Fails to enter DOB");
		}
	}


    public void validateDobErrorMessage() {
    	try {
			String dobValidationMsg = driver.findElement(locators.DateoFBirthValidationMsg).getText();
			if (dobValidationMsg.equals("Employee must be minimum 18yrs.")) {
				ExtentTestManager.getTest().log(Status.PASS,"Error Message displayed when age is less than 18 yrs : " + dobValidationMsg);
				Log.info("Error Message displayed when age is less than 18 yrs : " + dobValidationMsg);
			} else {
				ExtentTestManager.getTest().log(Status.FAIL,"Error Message not displayed when age is above 18 yrs : " + dobValidationMsg);
				Log.info("Error Message not displayed when age is above 18 yrs : " + dobValidationMsg);
			}
		} catch (Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL, "Fails to Validate 'Date of Birth' field");
			Log.info("Fails to Validate 'Date of Birth' field");
		}
    }
    
    public void validateDobNoErrorMessage() {
    	try {
    		if (driver.findElements(locators.DateoFBirthValidationMsg).isEmpty()) {
    	        ExtentTestManager.getTest().log(Status.PASS, "No Error Message displayed when age is above 18 yrs.");
    	        Log.info("No Error Message displayed when age is above 18 yrs.");
    		} else {
				 String dobValidationMsg = driver.findElement(locators.DateoFBirthValidationMsg).getText();
			     ExtentTestManager.getTest().log(Status.FAIL, "Error Message displayed when age is above 18 yrs: " + dobValidationMsg);
			     Log.info("Error Message displayed when age is above 18 yrs: " + dobValidationMsg);
    		}
		} catch (Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL, "Fails to Validate 'Date of Birth' field");
			Log.info("Fails to Validate 'Date of Birth' field");
		}
    }

	public void selectRace_Ethnicity(String race) {		
		
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});",driver.findElement(locators.Race_Ethnicity));
			Select dropdown = new Select(driver.findElement(locators.Race_Ethnicity));
			dropdown.selectByVisibleText(race);
			ExtentTestManager.getTest().log(Status.PASS, "Option selected from Race_Ethnicity dropdown : " + race);
			Log.info("Option selected from Race_Ethnicity dropdown : " + race);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL,"Expected to select " + race + " from Race_Ethnicity dropdown");
			Log.info("Expected to select " + race + " from Race_Ethnicity dropdown");
		}
	}

	public void validateRace_EthnicitySelection(String race) {

		
		Select dropdown = new Select(driver.findElement(locators.Race_Ethnicity));
		WebElement selectedOption = dropdown.getFirstSelectedOption();
		String actualValue = selectedOption.getText();
		if (actualValue.equals(race)) {
			ExtentTestManager.getTest().log(Status.PASS,"Selected dropdown '" + actualValue + "' is shown in Race_Ethnicity Field");
			Log.info("Selected dropdown '" + actualValue + "' is shown in Race_Ethnicity Field");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "Expected " + race + ", but found:" + actualValue);
			Log.info("Expected " + race + ", but found:" + actualValue);
		}
	}
	
	public void enterAddressLine1(String address) throws InterruptedException {

		try {
			clear(locators.AddressLine1);
			input(locators.AddressLine1, address);
			ExtentTestManager.getTest().log(Status.PASS, "Entered in 'Address Line 1' Field :" + address);
			Log.info("Entered in 'Address Line 1' Field :" + address);
		} catch (Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL, "Fails to enter Address Line 1");
			Log.info("Fails to enter Address Line 1");
		}
	}

	public void validateAddressLine1Field() {
		try {
			String address = driver.findElement(locators.AddressLine1).getAttribute("value");
			String regex = "^(?=.*[a-zA-Z])[a-zA-Z0-9!@#$%^&*()_+\\-\\[\\]{};':\"\\\\|,.<>/? ]+$";
			if (address.matches(regex)) {
				ExtentTestManager.getTest().log(Status.PASS,"'Address Line 1' field accepts Alphabetic, numeric and special character inputs : " + address);
				Log.info("'Address Line 1' field accepts Alphabetic, numeric and special character inputs : " + address);
			} else {
				ExtentTestManager.getTest().log(Status.FAIL,"'Address Line 1' field does not accept alphabetic, numeric, or special character inputs correctly: " + address);
				Log.info("'Address Line 1' field does not accept alphabetic, numeric, or special character inputs correctly: " + address);
			}
		} catch (Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL, "Fails to Validate 'Address Line 1' field");
			Log.info("Fails to Validate 'Address Line 1' field");
		}
	}
	
	public void enterAddressLine2(String address) throws InterruptedException {

		try {
			clear(locators.AddressLine2);
			input(locators.AddressLine2, address);
			ExtentTestManager.getTest().log(Status.PASS, "Entered in 'Address Line 2' Field :" + address);
			Log.info("Entered in 'Address Line 2' Field :" + address);
		} catch (Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL, "Fails to enter Address Line 2");
			Log.info("Fails to enter Address Line 2");
		}
	}
	
	public void enterInCertificateIfAny(String certificate) throws InterruptedException {
		clear(locators.Certificate);
		input(locators.Certificate, certificate);
		ExtentTestManager.getTest().log(Status.PASS, "Entered in 'Certificate(if any)' Field :" + certificate);
		Log.info("Entered in 'Certificate(if any)' Field :" + certificate);
	}

	public void validateCertificateIfAnyField() {
		try {
			String certificate = driver.findElement(locators.Certificate).getAttribute("value");
//			String regex = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-\\[\\]{};':\"\\\\|,.<>/?])(?=.*\\s).+$";
			String regex = "^(?=.*[a-zA-Z])[a-zA-Z0-9!@#$%^&*()_+\\-\\[\\]{};':\"\\\\|,.<>/? ]+$";
			if (certificate.matches(regex)) {
				ExtentTestManager.getTest().log(Status.PASS,"'Certificate(if any)' field accepts Alphabetic, numeric and special character inputs : " + certificate);
				Log.info("'Certificate(if any)' field accepts Alphabetic, numeric and special character inputs : " + certificate);
			} else {
				ExtentTestManager.getTest().log(Status.FAIL,"'Certificate(if any)' field does not accept alphabetic, numeric, or special character inputs correctly: " + certificate);
				Log.info("'Certificate(if any)' field does not accept alphabetic, numeric, or special character inputs correctly: " + certificate);
			}
		} catch (Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL, "Fails to Validate 'Certificate(if any)' field");
			Log.info("Fails to Validate 'Certificate(if any)' field");
		}
	}

	public void enterSpecialAccessNeeded(String specialAccessNeeded) throws InterruptedException {
		try {
			clear(locators.SpecialAccessNeeded);
			input(locators.SpecialAccessNeeded, specialAccessNeeded);
			ExtentTestManager.getTest().log(Status.PASS, "Entered in Special Access Needed Field :" + specialAccessNeeded);
			Log.info("Entered in Special Access Needed Field :" + specialAccessNeeded);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL,"Failed to enter Special Access Needed"+e.getMessage());
			System.out.println(e.getMessage());
		}
	}

	public void validateSpecialAccessNeededField() {
		try {
			String specialAccessNeeded = driver.findElement(locators.SpecialAccessNeeded).getAttribute("value");
			if (specialAccessNeeded.matches("[a-zA-Z ]+")) {
				ExtentTestManager.getTest().log(Status.PASS,"'Special Access Needed' field accepts only Alphabetic inputs : " + specialAccessNeeded);
				Log.info("'Special Access Needed' field accepts only Alphabetic inputs : " + specialAccessNeeded);
			} else {
				ExtentTestManager.getTest().log(Status.FAIL,"'Special Access Needed' field accepts non Alphabetic inputs also : " + specialAccessNeeded);
				Log.info("'Special Access Needed' field accepts non Alphabetic inputs also : " + specialAccessNeeded);
			}
		} catch (Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL, "Fails to Validate 'Special Access Needed' field");
			Log.info("Fails to Validate 'Special Access Needed' field");
		}
	}

	public void enterTrainingRequired(String trainingRequired) throws InterruptedException {
		try {
			clear(locators.TrainingRequired);
			input(locators.TrainingRequired, trainingRequired);
			ExtentTestManager.getTest().log(Status.PASS, "Entered in 'Training Required' Field :" + trainingRequired);
			Log.info("Entered in 'Training Required' Field :" + trainingRequired);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL,"Failed to enter Training Required"+e.getMessage());
			System.out.println(e.getMessage());
		}
	}

	public void validateTrainingRequiredField() {
		try {
			String trainingRequired = driver.findElement(locators.TrainingRequired).getAttribute("value");
			if (trainingRequired.matches("[a-zA-Z ]+")) {
				ExtentTestManager.getTest().log(Status.PASS,"'Training Required' field accepts only Alphabetic inputs : " + trainingRequired);
				Log.info("'Training Required' field accepts only Alphabetic inputs : " + trainingRequired);
			} else {
				ExtentTestManager.getTest().log(Status.FAIL,"'Training Required' field accepts non Alphabetic inputs also : " + trainingRequired);
				Log.info("'Training Required' field accepts non Alphabetic inputs also : " + trainingRequired);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			ExtentTestManager.getTest().log(Status.FAIL, "Fails to Validate 'Training Required' field");
			Log.info("Fails to Validate 'Training Required' field");
		}
	}

	public void enterAdditionalTraining(String additionalTraining) throws InterruptedException {
		try {
			clear(locators.AdditionalTraining);
			input(locators.AdditionalTraining, additionalTraining);
			ExtentTestManager.getTest().log(Status.PASS, "Entered in 'Additional Training' Field :" + additionalTraining);
			Log.info("Entered in 'Additional Training' Field :" + additionalTraining);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			ExtentTestManager.getTest().log(Status.FAIL,"Failed to enter Additional Training"+e.getMessage());
		}
	}

	public void validateAdditionalTrainingField() {
		try {
			String additionalTraining = driver.findElement(locators.AdditionalTraining).getAttribute("value");
			if (additionalTraining.matches("[a-zA-Z ]+")) {
				ExtentTestManager.getTest().log(Status.PASS,"'Additional Training' field accepts only Alphabetic inputs : " + additionalTraining);
				Log.info("'Additional Training' field accepts only Alphabetic inputs : " + additionalTraining);
			} else {
				ExtentTestManager.getTest().log(Status.FAIL,"'Additional Training' field accepts non Alphabetic inputs also : " + additionalTraining);
				Log.info("'Additional Training' field accepts non Alphabetic inputs also : " + additionalTraining);
			}
		} catch (Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL, "Fails to Validate 'Additional Training' field");
			Log.info("Fails to Validate 'Additional Training' field");
		}
	}

	public void selectReportingManager(String reportingManager) throws InterruptedException {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});",driver.findElement(locators.ReportingTo));
			click(locators.ReportingTo);
			WaitForLoaderToDisappear();

			List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table mb-0']/tbody/tr/td[1]"));
			for (WebElement row : rows) {
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", row);
				if (row.getAttribute("innerHTML").trim().equalsIgnoreCase(reportingManager)) {
					row.click();
					ExtentTestManager.getTest().log(Status.PASS,"Reporting Manager selected from dialogue box: " + row.getText().trim());
					Log.info("Reporting Manager selected from dialogue box: " + row.getText().trim());
					break;
				}
			}
			click(locators.oKBtnInDialogueBox);
			WaitForLoaderToDisappear();
		} catch (InterruptedException e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL, "Failed to Select Reporting Manager ");
			Log.info("Failed to Select Reporting Manager ");
		}
	}

	public void validateReportingMangerSelection(String Name) {
		String selection = driver.findElement(locators.ReportingTo).getAttribute("value");
		if (selection.equals(Name)) {
			ExtentTestManager.getTest().log(Status.PASS,"Selected Reporting Manager '" + selection + "' is shown in the Field");
			Log.info("Selected Reporting Manager '" + selection + "' is shown in the Field");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "Expected " + Name + ", but found:" + selection);
			Log.info("Expected " + Name + ", but found:" + selection);
		}
	}

	public void selectDesignation(String designation) throws InterruptedException {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});",driver.findElement(locators.Designation));
			click(locators.Designation);
			WaitForLoaderToDisappear();

			List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table mb-0']/tbody/tr/td[1]"));
			for (WebElement row : rows) {
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", row);
				if (row.getAttribute("innerHTML").trim().equalsIgnoreCase(designation)) {
					row.click();
					ExtentTestManager.getTest().log(Status.PASS,"Designation selected from dialogue box: " + row.getText().trim());
					Log.info("Designation selected from dialogue box: " + row.getText().trim());
					break;
				}
			}
			click(locators.oKBtnInDialogueBox);
			WaitForLoaderToDisappear();
		} catch (InterruptedException e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL, "Failed to Select Designation ");
			Log.info("Failed to Select Designation ");
		}
	}

	public void validateDesignationSelection(String Name) {
		String selection = driver.findElement(locators.Designation).getAttribute("value");
		if (selection.equals(Name)) {
			ExtentTestManager.getTest().log(Status.PASS,"Selected Designation '" + selection + "' is shown in the Field");
			Log.info("Selected Designation '" + selection + "' is shown in the Field");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "Expected " + Name + ", but found:" + selection);
			Log.info("Expected " + Name + ", but found:" + selection);
		}
	}

	public void searchAndSelectRole(String role) throws InterruptedException {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", driver.findElement(locators.RoleName));
			click(locators.RoleName);
			WaitForLoaderToDisappear();
			click(locators.searchInDialogueBox);
			input(locators.searchInDialogueBox, role);

			WebElement searchedRow = driver.findElement(By.xpath("//h4[normalize-space()='Roles']/../../../../child::div[2]//table/tbody/tr[1]"));
			searchedRow.click();
			ExtentTestManager.getTest().log(Status.PASS,"Role selected from dialogue box: " + searchedRow.getAttribute("innerHTML").replaceAll("\\s+", " ").trim());
			Log.info("Role selected from dialogue box: " + searchedRow.getText().replaceAll("\\s+", " ").trim());
			click(locators.oKBtnInDialogueBox);
			WaitForLoaderToDisappear();
		} catch (Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL, "Failed to Select Role ");
			Log.info("Failed to Select Role ");
		}
	}

	public void validateRoleSelection(String Name) {
		try {
			String selection = driver.findElement(locators.RoleName).getAttribute("value");
			if (selection.equals(Name)) {
				ExtentTestManager.getTest().log(Status.PASS, "Selected Role '" + selection + "' is shown in the Field");
				Log.info("Selected Role '" + selection + "' is shown in the Field");
			} else {
				ExtentTestManager.getTest().log(Status.FAIL, "Expected " + Name + ", but found:" + selection);
				Log.info("Expected " + Name + ", but found:" + selection);
			}
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL,"Failed to validate Role Selection"+e.getMessage());
			System.out.println(e.getMessage());
		}
	}

	public void selectBusinessUnit(String businessUnit) {

		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});",driver.findElement(locators.BusinessUnit));
			click(locators.BusinessUnit);
			WaitForLoaderToDisappear();
			
			List<WebElement> dropdownValues = driver.findElements(By.xpath("//div[contains(@id,'mat-autocomplete')]//mat-option//span"));
			for (WebElement dropdown : dropdownValues) {
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", dropdown);
				if (dropdown.getText().trim().equals(businessUnit)) {
					dropdown.click();
					ExtentTestManager.getTest().log(Status.PASS,"Option selected from Business Unit dropdown : " + businessUnit);
					Log.info("Option selected from Business Unit dropdown : " + businessUnit);
					break;
				}
			}

		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL,"Expected to select " + businessUnit + " from Business Unit dropdown");
			Log.info("Expected to select " + businessUnit + " from Business Unit dropdown");
		}
	}

	public void validateBusinessUnitSelection(String businessUnit) {
		String selection = driver.findElement(locators.BusinessUnit).getAttribute("value");
		if (selection.equals(businessUnit)) {
			ExtentTestManager.getTest().log(Status.PASS,"Selected Business Unit '" + businessUnit + "' is shown in the Field");
			Log.info("Selected Business Unit '" + businessUnit + "' is shown in the Field");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "Expected " + businessUnit + ", but found:" + selection);
			Log.info("Expected " + businessUnit + ", but found:" + selection);
		}
	}

	public void selectDivision(String division) {

		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", driver.findElement(locators.Division));
			WaitForLoaderToDisappear();
			click(locators.Division);		
			List<WebElement> dropdownValues = driver.findElements(By.xpath("//div[contains(@id,'mat-autocomplete')]//mat-option//span"));
			for (WebElement dropdown : dropdownValues) {
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", dropdown);
				if (dropdown.getText().trim().equals(division)) {
					dropdown.click();
					ExtentTestManager.getTest().log(Status.PASS,"Option selected from Division dropdown : " + division);
					Log.info("Option selected from Division dropdown : " + division);
					break;
				}
			}

		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Expected to select " + division + " from Division dropdown"+e.getMessage());
			Log.info("Expected to select " + division + " from Division dropdown");
		}
	}	

	public void validateDivisionSelection(String division) {
		String selection = driver.findElement(locators.Division).getAttribute("value");
		if (selection.equals(division)) {
			ExtentTestManager.getTest().log(Status.PASS, "Selected Division '" + division + "' is shown in the Field");
			Log.info("Selected Division '" + division + "' is shown in the Field");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "Expected " + division + ", but found:" + selection);
			Log.info("Expected " + division + ", but found:" + selection);
		}
	}

	public void selectTechnology(String technology) {

		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});",driver.findElement(locators.Technology));
			WaitForLoaderToDisappear();
			click(locators.Technology);
			List<WebElement> dropdownValues = driver.findElements(By.xpath("//div[contains(@id,'mat-autocomplete')]//mat-option//span"));
			for (WebElement dropdown : dropdownValues) {
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", dropdown);
				if (dropdown.getText().trim().equals(technology)) {
					dropdown.click();
					ExtentTestManager.getTest().log(Status.PASS,"Option selected from Technology dropdown : " + technology);
					Log.info("Option selected from Technology dropdown : " + technology);
					break;
				}
			}

		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL,"Expected to select " + technology + " from Technology dropdown"+e.getMessage());
			Log.info("Expected to select " + technology + " from Technology dropdown");
		}
	}

	public void validateTechnologySelection(String technology) {
		try {
			String selection = driver.findElement(locators.Technology).getAttribute("value");
			if (selection.equals(technology)) {
				ExtentTestManager.getTest().log(Status.PASS,"Selected Technology '" + technology + "' is shown in the Field");
				Log.info("Selected Technology '" + technology + "' is shown in the Field");
			} else {
				ExtentTestManager.getTest().log(Status.FAIL, "Expected " + technology + ", but found:" + selection);
				Log.info("Expected " + technology + ", but found:" + selection);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			ExtentTestManager.getTest().log(Status.FAIL,"Failed to validate Technology Selection"+e.getMessage());
		}
	}

	public void selectDepartment(String department) {

		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});",driver.findElement(locators.Department));
			WaitForLoaderToDisappear();
			click(locators.Department);
			List<WebElement> dropdownValues = driver.findElements(By.xpath("//div[contains(@id,'mat-autocomplete')]//mat-option//span"));
			for (WebElement dropdown : dropdownValues) {
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", dropdown);
				if (dropdown.getText().trim().equals(department)) {
					dropdown.click();
					WaitForLoaderToDisappear();
					ExtentTestManager.getTest().log(Status.PASS,"Option selected from Department dropdown : " + department);
					Log.info("Option selected from Department dropdown : " + department);
					break;
				}
			}

		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL,"Expected to select " + department + " from Department dropdown"+e.getMessage());
			Log.info("Expected to select " + department + " from Department dropdown");
		}
	}

	public void validateDepartmentSelection(String department) {
		String selection = driver.findElement(locators.Department).getAttribute("value");
		if (selection.equals(department)) {
			ExtentTestManager.getTest().log(Status.PASS,"Selected Department '" + department + "' is shown in the Field");
			Log.info("Selected Department '" + department + "' is shown in the Field");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "Expected " + department + ", but found:" + selection);
			Log.info("Expected " + department + ", but found:" + selection);
		}
	}

	public void selectImmigrationStatus(String status) {

		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});",driver.findElement(locators.ImmigrationStatus));
			Select dropdown = new Select(driver.findElement(locators.ImmigrationStatus));
			dropdown.selectByVisibleText(status);
			WaitForLoaderToDisappear();
			ExtentTestManager.getTest().log(Status.PASS,"Option selected from Immigration Status dropdown : " + status);
			Log.info("Option selected from Immigration Status dropdown : " + status);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL,"Expected to select " + status + " from Immigration Status dropdown");
			Log.info("Expected to select " + status + " from Immigration Status dropdown");
		}
	}

	public void validateImmigrationStatusSelection(String status) {
		Select dropdown = new Select(driver.findElement(locators.ImmigrationStatus));
		WebElement selectedOption = dropdown.getFirstSelectedOption();
		String actualValue = selectedOption.getText();
		if (actualValue.equals(status)) {
			ExtentTestManager.getTest().log(Status.PASS,"Selected dropdown '" + actualValue + "' is shown in Immigration Status Field");
			Log.info("Selected dropdown '" + actualValue + "' is shown in Immigration Status Field");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "Expected " + status + ", but found:" + actualValue);
			Log.info("Expected " + status + ", but found:" + actualValue);
		}
	}

	public void selectVisaType(String visaType) {

		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", driver.findElement(locators.VisaType));
			Select dropdown = new Select(driver.findElement(locators.VisaType));
			dropdown.selectByVisibleText(visaType);
			WaitForLoaderToDisappear();
			ExtentTestManager.getTest().log(Status.PASS, "Option selected from Visa Type dropdown : " + visaType);
			Log.info("Option selected from Visa Type dropdown : " + visaType);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Expected to select " + visaType + " from Visa Type dropdown");
			Log.info("Expected to select " + visaType + " from Visa Type dropdown");
		}
	}
	
	public void clickDateOfJoiningField() throws InterruptedException {
		click(locators.DateOfJoiningCalender);
    }

	public static String getPreviousDayDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        SimpleDateFormat formatter = new SimpleDateFormat("MMMM d, yyyy");
        return formatter.format(calendar.getTime());
    }
	
	public static String getTodaysDate() {
	    Calendar calendar = Calendar.getInstance();
	    SimpleDateFormat formatter = new SimpleDateFormat("MMMM d, yyyy");
	    return formatter.format(calendar.getTime());
	}
	
    public void isPastDateDisabled() {
    	String pastDate = getPreviousDayDate();
    	WebElement date = driver.findElement(By.xpath("//td[@aria-label='" + pastDate + "']"));
       
       if (date.getAttribute("class").contains("disabled")) {
			ExtentTestManager.getTest().log(Status.PASS,"Past Date till '"+ pastDate + "' are disabled in Date of Joining Calender");
			Log.info("Past Date till '"+ pastDate + "' are disabled in Date of Joining Calender");
       } else {
			ExtentTestManager.getTest().log(Status.FAIL, "Past Dates are not disabled in Date of Joining Calender");
			Log.info("Past Dates are not disabled in Date of Joining Calender");
       }     
    }

    public void selectFutureDate() {
    	String todaysDate = getTodaysDate();
        WebElement Date = driver.findElement(By.xpath("//td[@aria-label='" + todaysDate + "']"));
        if (Date.isEnabled()) {
        	Date.click();
			ExtentTestManager.getTest().log(Status.PASS,"Date From '"+ todaysDate + "' is enabled in Date of Joining Calender");
			Log.info("Date From '"+ todaysDate + "' is enabled in Date of Joining Calender");
			ExtentTestManager.getTest().log(Status.PASS,"Selected date '"+ todaysDate + "' from Date of Joining Calender");
			Log.info("Selected date '"+ todaysDate + "' from Date of Joining Calender");
        } else {
			ExtentTestManager.getTest().log(Status.FAIL, "Todya's Date is not enabled in Date of Joining Calender");
			Log.info("Todya's Date is not enabled in Date of Joining Calender");
        }    
    }

	public void validateVisaTypeSelection(String visaType) {
		Select dropdown = new Select(driver.findElement(locators.VisaType));
		WebElement selectedOption = dropdown.getFirstSelectedOption();
		String actualValue = selectedOption.getText();
		if (actualValue.equals(visaType)) {
			ExtentTestManager.getTest().log(Status.PASS,"Selected dropdown '" + actualValue + "' is shown in Visa Type Field");
			Log.info("Selected dropdown '" + actualValue + "' is shown in Visa Type Field");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "Expected " + visaType + ", but found:" + actualValue);
			Log.info("Expected " + visaType + ", but found:" + actualValue);
		}
	}

	public void selectEmploymentType(String employmentType) {

		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});",driver.findElement(locators.EmploymentType));
		
			Select dropdown = new Select(driver.findElement(locators.EmploymentType));
			dropdown.selectByVisibleText(employmentType);
			ExtentTestManager.getTest().log(Status.PASS,"Option selected from Employment Type dropdown : " + employmentType);
			Log.info("Option selected from Employment Type dropdown : " + employmentType);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL,"Expected to select " + employmentType + " from Employment Type dropdown");
			Log.info("Expected to select " + employmentType + " from Employment Type dropdown");
		}
	}

	public void validateEmploymentTypeSelection(String employmentType) {
		Select dropdown = new Select(driver.findElement(locators.EmploymentType));
		WebElement selectedOption = dropdown.getFirstSelectedOption();
		String actualValue = selectedOption.getText();
		if (actualValue.equals(employmentType)) {
			ExtentTestManager.getTest().log(Status.PASS,"Selected dropdown '" + actualValue + "' is shown in Employment Type Field");
			Log.info("Selected dropdown '" + actualValue + "' is shown in Employment Type Field");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "Expected " + employmentType + ", but found:" + actualValue);
			Log.info("Expected " + employmentType + ", but found:" + actualValue);
		}
	}
	
	public void selectEmploymentSubType(String employmentSubType) {

		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});",driver.findElement(locators.EmploymentSubType));
			
			Select dropdown = new Select(driver.findElement(locators.EmploymentSubType));
			dropdown.selectByVisibleText(employmentSubType);
			ExtentTestManager.getTest().log(Status.PASS,"Option selected from Employment Sub Type dropdown : " + employmentSubType);
			Log.info("Option selected from Employment Sub Type dropdown : " + employmentSubType);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL,"Expected to select " + employmentSubType + " from Employment Sub Type dropdown");
			Log.info("Expected to select " + employmentSubType + " from Employment Sub Type dropdown");
		}
	}

	public void validateEmploymentSubTypeSelection(String employmentSubType) {
		Select dropdown = new Select(driver.findElement(locators.EmploymentSubType));
		WebElement selectedOption = dropdown.getFirstSelectedOption();
		String actualValue = selectedOption.getText();
		if (actualValue.equals(employmentSubType)) {
			ExtentTestManager.getTest().log(Status.PASS,"Selected dropdown '" + actualValue + "' is shown in Employment Sub Type Field");
			Log.info("Selected dropdown '" + actualValue + "' is shown in Employment Sub Type Field");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "Expected " + employmentSubType + ", but found:" + actualValue);
			Log.info("Expected " + employmentSubType + ", but found:" + actualValue);
		}
	}

	public void isEligibleForBenefitsNoSelected() {

		try {
			boolean isEligibleForBenefitsNoSelected = driver.findElement(locators.EligibleForBenefits_No).isSelected();
			if (isEligibleForBenefitsNoSelected) {
				ExtentTestManager.getTest().log(Status.PASS,"By Default 'Eligible for Benefits' should be 'No' : " + isEligibleForBenefitsNoSelected);
				Log.info("By Default 'Eligible for Benefits' should be 'No' : " + isEligibleForBenefitsNoSelected);
			} else {
				ExtentTestManager.getTest().log(Status.FAIL,"By Default 'Eligible for Benefits' should be 'No' : " + isEligibleForBenefitsNoSelected);
				Log.info("By Default 'Eligible for Benefits' should be 'No' : " + isEligibleForBenefitsNoSelected);
			}
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL,"Failed to Validate Selection"+e.getMessage());
		}
	}

	public void isLaptopRequiredYesSelected() {

		try {
			boolean isLaptopRequiredYesSelected = driver.findElement(locators.LaptopRequired_Yes).isSelected();
			if (isLaptopRequiredYesSelected) {
				ExtentTestManager.getTest().log(Status.PASS,"By Default 'Laptop Required' should be 'Yes' : " + isLaptopRequiredYesSelected);
				Log.info("By Default 'Laptop Required' should be 'Yes' : " + isLaptopRequiredYesSelected);
			} else {
				ExtentTestManager.getTest().log(Status.FAIL,"By Default 'Laptop Required' should be 'Yes' : " + isLaptopRequiredYesSelected);
				Log.info("By Default 'Laptop Required' should be 'Yes' : " + isLaptopRequiredYesSelected);
			}
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL,"Failed to Validate Selection"+e.getMessage());
		}
	}

	public void isBackgroundCheckRequiredYesSelected() {

		try {
			boolean isBackgroundCheckRequiredYesSelected = driver.findElement(locators.BackgroundCheckRequired_Yes)
					.isSelected();
			if (isBackgroundCheckRequiredYesSelected) {
				ExtentTestManager.getTest().log(Status.PASS,"By Default 'Background Check Required' should be 'Yes' : " + isBackgroundCheckRequiredYesSelected);
				Log.info("By Default 'Background Check Required' should be 'Yes' : " + isBackgroundCheckRequiredYesSelected);
			} else {
				ExtentTestManager.getTest().log(Status.FAIL,"By Default 'Background Check Required' should be 'Yes' : " + isBackgroundCheckRequiredYesSelected);
				Log.info("By Default 'Background Check Required' should be 'Yes' : " + isBackgroundCheckRequiredYesSelected);
			}
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL,"Failed to Validate Selection"+e.getMessage());
		}
	}

	public void isAddDistributionListNoSelected() {

		try {
			boolean isAddDistributionListNoSelected = driver.findElement(locators.AddDistributionList_No).isSelected();
			if (isAddDistributionListNoSelected) {
				ExtentTestManager.getTest().log(Status.PASS,"By Default 'Add Distribution List' should be 'No' : " + isAddDistributionListNoSelected);
				Log.info("By Default 'Add Distribution List' should be 'No' : " + isAddDistributionListNoSelected);
			} else {
				ExtentTestManager.getTest().log(Status.FAIL,"By Default 'Add Distribution List' should be 'No' : " + isAddDistributionListNoSelected);
				Log.info("By Default 'Add Distribution List' should be 'No' : " + isAddDistributionListNoSelected);
			}
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL,"Failed to Validate Selection"+e.getMessage());
		}
	}

	public void selectJobLocation(String jobLocation) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});",driver.findElement(locators.JobLocation));
			Select dropdown = new Select(driver.findElement(locators.JobLocation));
			dropdown.selectByVisibleText(jobLocation);
			ExtentTestManager.getTest().log(Status.PASS, "Option selected from Job Location dropdown : " + jobLocation);
			Log.info("Option selected from Job Location dropdown : " + jobLocation);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL,"Expected to select " + jobLocation + " from Job Location dropdown");
			Log.info("Expected to select " + jobLocation + " from Job Location dropdown");
		}
	}

	public void validateJobLocationSelection(String jobLocation) {
		try {
			Select dropdown = new Select(driver.findElement(locators.JobLocation));
			WebElement selectedOption = dropdown.getFirstSelectedOption();
			String actualValue = selectedOption.getText();
			if (actualValue.equals(jobLocation)) {
				ExtentTestManager.getTest().log(Status.PASS,"Selected dropdown '" + actualValue + "' is shown in Job Location Field");
				Log.info("Selected dropdown '" + actualValue + "' is shown in Job Location Field");
			} else {
				ExtentTestManager.getTest().log(Status.FAIL, "Expected " + jobLocation + ", but found:" + actualValue);
				Log.info("Expected " + jobLocation + ", but found:" + actualValue);
			}
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL,"Failed to Validate Selection"+e.getMessage());
		}
	}

	public void getDefaultCountry() {

		try {
			String defaultCountry = new Select(driver.findElement(locators.JobCountry)).getFirstSelectedOption().getText();
			if (defaultCountry.equals("United States of America")) {
				ExtentTestManager.getTest().log(Status.PASS, "By default Job Country should be : " + defaultCountry);
				Log.info("By default Job Country should be : " + defaultCountry);
			} else {
				ExtentTestManager.getTest().log(Status.FAIL,"By default Job Country Expected: United States of America . But found :" + defaultCountry);
				Log.info("By default Job Country Expected: United States of America . But found :" + defaultCountry);
			}
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL,"Failed to Validate Default Country"+e.getMessage());
		}
	}
	
	public void enterZipCode(String zipCode) throws InterruptedException {
		
		try {
			clear(locators.ZipCode);
			input(locators.ZipCode, zipCode);
			click(locators.City);
			ExtentTestManager.getTest().log(Status.INFO, "Zip Code entered : '" + zipCode);
			Log.info("Zip Code entered : '" + zipCode);
		} catch (Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL, "Fails to enter Zip Code ");
			Log.info("Fails to enter Zip Code ");
		}
	}

	public void getZipCodeValidationMessage() {
		try {
			String validationMsg = driver.findElement(locators.ZipCodeValidationMsg).getText();
			if (validationMsg.equalsIgnoreCase("Zip code not found in application.")) {
				ExtentTestManager.getTest().log(Status.PASS, "Validation message : '" + validationMsg + "'is displayed ");
				Log.info("Validation message : '" + validationMsg + "'is displayed ");
			} else {
				ExtentTestManager.getTest().log(Status.FAIL,"Expected Validation Message : 'Zip code not found in application.' . But found :" + validationMsg);
				Log.info("Expected Validation Message : 'Zip code not found in application.' . But found :" + validationMsg);
			}
		} catch (Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL, "Fails to Validate Message ");
			Log.info("Fails to Validate Message ");
		}
	}

	public void verifyCity(String city) {

		try {
			String cityAutofilled = driver.findElement(locators.City).getAttribute("value");
			if (cityAutofilled.equals(city)) {
				ExtentTestManager.getTest().log(Status.PASS,"For the entered Zip code, City is auto filled : " + cityAutofilled);
				Log.info("For the entered Zip code, City is auto filled : " + cityAutofilled);
			} else {
				ExtentTestManager.getTest().log(Status.FAIL, "Expected '" + city + "'But found :" + cityAutofilled);
				Log.info("Expected '" + city + "'But found :" + cityAutofilled);
			}
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL,"Failed to Validate City"+e.getMessage());
		}
	}

	public void verifyState(String state) {

		try {
			Select dropdown = new Select(driver.findElement(locators.State));
			WebElement selectedOption = dropdown.getFirstSelectedOption();
			String actualValue = selectedOption.getText();
			if (actualValue.equals(state)) {
				ExtentTestManager.getTest().log(Status.PASS,"For the entered Zip code, State is auto filled : " + actualValue);
				Log.info("For the entered Zip code, State is auto filled : " + actualValue);
			} else {
				ExtentTestManager.getTest().log(Status.FAIL, "Expected '" + state + "'But found :" + actualValue);
				Log.info("Expected '" + state + "'But found :" + actualValue);
			}
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL,"Failed to Validate State"+e.getMessage());
		}
	}
	
	public void clickAttachResume() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});",
				driver.findElement(locators.AttachResume));
        click(locators.AttachResume);
        ExtentTestManager.getTest().log(Status.INFO, "Clicked Attach Resume Field");
        Log.info("Clicked Attach Resume Field");
    }
	
	public void clickSSNUpload() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});",driver.findElement(locators.SSN_Upload));
        click(locators.SSN_Upload);
        ExtentTestManager.getTest().log(Status.INFO, "Clicked SSN Upload Field");
        Log.info("Clicked SSN Upload Field");
    }
	
	public void removeAlreadyExistingCerificates()
	{
		try {
			List<WebElement> close = driver.findElements(By.xpath("//label[normalize-space()='Certificate Upload (PDF Max size: 4MB )']/../child::div/a[contains(@title,'Delete')]"));
			for(WebElement delete : close)
				{
				  if(delete.isDisplayed()) {
					  delete.click();			
					  Thread.sleep(1000);
					  By confirmYes = By.xpath("//button[normalize-space()='Yes']");
					  WaitForElementToBeVisible(confirmYes);
					  driver.findElement(confirmYes).click();
				  }else {
					  System.out.println("No Certificates to remove");
				  }
				}
		} catch (Exception e) {
			System.out.println("No Certificates to remove");
		}
		}
	
	public void clickCertificateUpload() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});",driver.findElement(locators.Certificate_Upload));
        click(locators.Certificate_Upload);
        ExtentTestManager.getTest().log(Status.INFO, "Clicked Certificate Upload Field");
        Log.info("Clicked Certificate Upload Field");
    }
	
	public void clickBenefitsFormUpload() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});",driver.findElement(locators.BenefitsWaiverForm));
        click(locators.BenefitsWaiverForm);
        ExtentTestManager.getTest().log(Status.INFO, "Clicked Benefits Waiver Form Upload Field");
        Log.info("Clicked Benefits Waiver Form Upload Field");
    }

    public void uploadFile(String filePath) {
        driver.findElement(locators.AttachResume).sendKeys(filePath);
    }
    
    public void uploadFileUsingRobot(String relativeFilePath) throws AWTException, InterruptedException {
        String filePath = System.getProperty("user.dir") + relativeFilePath;
        StringSelection selection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

        Robot robot = new Robot();

		// Simulate CTRL+V (Paste)
		robot.delay(1000); // Wait for the file dialog to appear
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		// Simulate ENTER key
		robot.delay(500); // Small delay
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		ExtentTestManager.getTest().log(Status.INFO, "Selected Valid PDF file");
		WaitForLoaderToDisappear();
    }
    
    public void isResumeFileUploadSuccessfull(String fileName) throws InterruptedException {
    	
    	try {
    		Thread.sleep(1500);
			WaitForElementToBeVisible(locators.AttachedResumeName);
			String successText = driver.findElement(locators.AttachedResumeName).getText().trim();
			System.out.println(successText);
			if (successText.equalsIgnoreCase(fileName)) {
				ExtentTestManager.getTest().log(Status.PASS, "Successfuly uploaded Resume : " + successText );
				Log.info("Successfuly uploaded Resume : " + successText );
			} else {
				ExtentTestManager.getTest().log(Status.FAIL,"Failed to upload resume :" + successText);
				Log.info("Failed to upload resume :" + successText);
			}
		} catch (Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL,"Failed to upload resume ");
			Log.info("Failed to upload resume ");
		}
    }
    
    public void isSSNFileUploadSuccessfull(String fileName) throws InterruptedException {
    	try {
    		Thread.sleep(1500);
			WaitForElementToBeVisible(locators.SSNUploadName);
			String successText = driver.findElement(locators.SSNUploadName).getText().trim();
			System.out.println(successText);
			if (successText.equalsIgnoreCase(fileName)) {
				ExtentTestManager.getTest().log(Status.PASS, "Successfuly uploaded SSN : " + successText );
				Log.info("Successfuly uploaded SSN : " + successText);
			} else {
				ExtentTestManager.getTest().log(Status.FAIL,"Failed to upload SSN :" + successText);
				Log.info("Failed to upload SSN :" + successText);
			}
		} catch (Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL,"Failed to upload SSN Certificate");
			Log.info("Failed to upload SSN Certificate");
		}
    }
    
    public void isCertificateFileUploadSuccessfull(String fileName) throws InterruptedException {
    	try {
    		Thread.sleep(1500);
			WaitForElementToBeVisible(locators.CertificateUploadName);
			String successText = driver.findElement(locators.CertificateUploadName).getText().trim();
			System.out.println(successText);
			if (successText.equalsIgnoreCase(fileName)) {
				ExtentTestManager.getTest().log(Status.PASS, "Successfuly uploaded Certificate : " + successText );
				Log.info("Successfuly uploaded Certificate : " + successText);
			} else {
				ExtentTestManager.getTest().log(Status.FAIL,"Failed to upload Certificate :" + successText);
				Log.info("Failed to upload Certificate :" + successText);
			}
		} catch (Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL,"Failed to upload Certificate ");
			Log.info("Failed to upload Certificate ");
		}
    }
    
    public void isBenefitsWaiverFileUploadSuccessfull(String fileName) throws InterruptedException {
    	try {
    		Thread.sleep(1500);
			WaitForElementToBeVisible(locators.BenefitsWaiverForm_UploadName);
			String successText = driver.findElement(locators.BenefitsWaiverForm_UploadName).getText().trim();
			System.out.println(successText);
			if (successText.equalsIgnoreCase(fileName)) {
				ExtentTestManager.getTest().log(Status.PASS, "Successfuly uploaded Benefits Waiver Form : " + successText );
				Log.info("Successfuly uploaded Benefits Waiver Form : " + successText);
			} else {
				ExtentTestManager.getTest().log(Status.FAIL,"Failed to upload Benefits Waiver Form :" + successText);
				Log.info("Failed to upload Benefits Waiver Form :" + successText);
			}
		} catch (Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL,"Failed to upload Benefits Waiver Form");
			Log.info("Failed to upload Benefits Waiver Form");
		}
    }

	public void enterJobZipCode(String zipCode) throws InterruptedException {
		try {
			clear(locators.JobZipCode);
			input(locators.JobZipCode, zipCode);
			click(locators.jobCityText);
			ExtentTestManager.getTest().log(Status.INFO, "Job Zip Code entered : '" + zipCode);
			Log.info("Job Zip Code entered : '" + zipCode);
		} catch (Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL, "Fails to enter Job Zip Code");
			Log.info("Fails to enter Job Zip Code");
			
		}
	}

	public void getJobZipCodeValidationMessage() {
		String validationMsg = driver.findElement(locators.JobZipCodeValidationMsg).getText();
		if (validationMsg.equalsIgnoreCase("Zip code not found in application.")) {
			ExtentTestManager.getTest().log(Status.PASS, "Validation message : '" + validationMsg + "'is displayed ");
			Log.info("Validation message : '" + validationMsg + "'is displayed ");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL,"Expected Validation Message : 'Zip code not found in application.' . But found :" + validationMsg);
			Log.info("Expected Validation Message : 'Zip code not found in application.' . But found :" + validationMsg);
		}
	}

	public void verifyJobCity(String city) {

		String cityAutofilled = driver.findElement(locators.jobCityText).getAttribute("value");
		if (cityAutofilled.equals(city)) {
			ExtentTestManager.getTest().log(Status.PASS,"For the entered Zip code, City is auto filled : " + cityAutofilled);
			Log.info("For the entered Zip code, City is auto filled : " + cityAutofilled);
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "Expected '" + city + "'But found :" + cityAutofilled);
			Log.info("Expected '" + city + "'But found :" + cityAutofilled);
		}
	}

	public void verifyJobState(String state) {

		String stateAutofilled = driver.findElement(locators.JobStateText).getAttribute("value");
		if (stateAutofilled.equals(state)) {
			ExtentTestManager.getTest().log(Status.PASS,"For the entered Zip code, State is auto filled : " + stateAutofilled);
			Log.info("For the entered Zip code, State is auto filled : " + stateAutofilled);
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "Expected '" + state + "'But found :" + stateAutofilled);
			Log.info("Expected '" + state + "'But found :" + stateAutofilled);
		}
	}

	public void getDefaultCurrency() {

		String defaultCurrency = new Select(driver.findElement(locators.Currency)).getFirstSelectedOption().getText();
		if (defaultCurrency.equals("USD")) {
			ExtentTestManager.getTest().log(Status.PASS, "By default Currency should be : " + defaultCurrency);
			Log.info("By default Currency should be : " + defaultCurrency);
		} else {
			ExtentTestManager.getTest().log(Status.FAIL,"By default Job Country Expected: 'USD' . But found :" + defaultCurrency);
			Log.info("By default Job Country Expected: 'USD' . But found :" + defaultCurrency);
		}
	}

	public void enterAmount(String amount) throws InterruptedException {
		try {
			clear(locators.Amount);
			input(locators.Amount, amount);
			ExtentTestManager.getTest().log(Status.INFO, "Amount entered : '" + amount);
			Log.info("Amount entered : '" + amount);
		} catch (Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL, "Fails to enter Amount");
			Log.info("Fails to enter Amount");
		}
	}
	
	public void verifyAmountField() {
		try {
			String amount = driver.findElement(locators.Amount).getAttribute("value");
			if (amount.matches("\\d+")) {
				ExtentTestManager.getTest().log(Status.PASS,"Amount fields accepts only Numeric inputs : " + amount);
				Log.info("Amount fields accepts only Numeric inputs : " + amount);
			} else {
				ExtentTestManager.getTest().log(Status.FAIL,"Amount fields accepts non Numeric inputs also : " + amount);
				Log.info("Amount fields accepts non Numeric inputs also : " + amount);
			}
		} catch (Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL, "Fails to Validate Middle Name");
			Log.info("Fails to Validate Middle Name");
		}
	}

	
	public void selectSalary(String salary) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});",driver.findElement(locators.SalaryType));
			Select dropdown = new Select(driver.findElement(locators.SalaryType));
			dropdown.selectByVisibleText(salary);
			ExtentTestManager.getTest().log(Status.PASS, "Option selected from 'Salary' dropdown : " + salary);
			Log.info("Option selected from 'Salary' dropdown : " + salary);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL,"Expected to select " + salary + " from 'Salary' dropdown");
			Log.info("Expected to select " + salary + " from 'Salary' dropdown");
		}
	}

	public void validateSalarySelection(String salary) {
		Select dropdown = new Select(driver.findElement(locators.SalaryType));
		WebElement selectedOption = dropdown.getFirstSelectedOption();
		String actualValue = selectedOption.getText();
		if (actualValue.equals(salary)) {
			ExtentTestManager.getTest().log(Status.PASS,"Selected dropdown '" + actualValue + "' is shown in Salary Field");
			Log.info("Selected dropdown '" + actualValue + "' is shown in Salary Field");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "Expected " + salary + ", but found:" + actualValue);
			Log.info("Expected " + salary + ", but found:" + actualValue);
		}
	}
	
	public void enterAdditionalComments(String additionalComments) throws InterruptedException {
		try {
			clear(locators.AdditionalComments);
			input(locators.AdditionalComments, additionalComments);
			ExtentTestManager.getTest().log(Status.PASS, "Entered in Additional Comments Field :" + additionalComments);
			Log.info("Entered in Additional Comments Field :" + additionalComments);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Failed to enter Additional Comments" + e.getMessage());
		}
	}

	public void validateAdditionalCommentsField() {
		try {
			String additionalComments = driver.findElement(locators.AdditionalComments).getAttribute("value");
//			String regex = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-\\[\\]{};':\"\\\\|,.<>/?])(?=.*\\s).+$";
			String regex = "^(?=.*[a-zA-Z])[a-zA-Z0-9!@#$%^&*()_+\\-\\[\\]{};':\"\\\\|,.<>/? ]+$";
			if (additionalComments.matches(regex)) {
				ExtentTestManager.getTest().log(Status.PASS,"'Additional Comments' field accepts Alphabetic, numeric and special character inputs : " + additionalComments);
				Log.info("'Additional Comments' field accepts Alphabetic, numeric and special character inputs : " + additionalComments);
			} else {
				ExtentTestManager.getTest().log(Status.FAIL,"'Additional Comments' field does not accept alphabetic, numeric, or special character inputs correctly: " + additionalComments);
				Log.info("'Additional Comments' field does not accept alphabetic, numeric, or special character inputs correctly: " + additionalComments);
			}
		} catch (Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL, "Fails to Validate 'Additional Comments' field");
			Log.info("Fails to Validate 'Additional Comments' field");
		}
	}
	
	public void verifySuggestedCompanyEmailAutofilled()
	{
		String suggestedEmail = driver.findElement(locators.SuggestedCompanyEmail).getAttribute("value");
		if(!suggestedEmail.isEmpty())
		{
			ExtentTestManager.getTest().log(Status.PASS,"'Suggested Company Email' is auto generated : " + suggestedEmail);	
			Log.info("'Suggested Company Email' is auto generated : " + suggestedEmail);
		}else {
			ExtentTestManager.getTest().log(Status.FAIL,"'Suggested Company Email' is not auto generated");
			Log.info("'Suggested Company Email' is not auto generated");
		}
	}
	
	public void verifySuggestedCompanyUsernameAutofilled()
	{
		String suggestedUsername = driver.findElement(locators.SuggestedUserName).getAttribute("value");
		if(!suggestedUsername.isEmpty())
		{
			ExtentTestManager.getTest().log(Status.PASS,"'Suggested Company UserName' is auto generated : " + suggestedUsername);
			Log.info("'Suggested Company UserName' is auto generated : " + suggestedUsername);
		}else {
			ExtentTestManager.getTest().log(Status.FAIL,"'Suggested Company UserName' is not auto generated");
			Log.info("'Suggested Company UserName' is not auto generated");
		}
	}
	
	public void clickSearchIcon() throws InterruptedException
	{
		try {
			WaitForLoaderToDisappear();
			click(locators.searchIcon);
			ExtentTestManager.getTest().log(Status.PASS,"Clicked Search Icon");
			Log.info("Clicked Search Icon");
		} catch (Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL,"Failed to click Search Icon");
			Log.info("Failed to click Search Icon");
		}
	}
	
	public void searchCandideName() throws InterruptedException, FileNotFoundException, IOException, ParseException
	{
		JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("testData.json"));
		String preferredName = (String) jsonObject.get("Preferred Name");
		try {
	
			WaitForElementToBeVisible(locators.searchText);
			input(locators.searchText,preferredName);
			click(locators.searchBtn);
			ExtentTestManager.getTest().log(Status.PASS,"Searched for Candidate : "+preferredName);
			Log.info("Searched for Candidate : "+preferredName);
		} catch (InterruptedException e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL,"Failed to Search for Candidate : "+preferredName);
			Log.info("Failed to Search for Candidate : "+preferredName);
		}
	}

	public void verifysearchedCandidateNameDisplayed() throws InterruptedException, FileNotFoundException, IOException, ParseException
	{
		JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("testData.json"));
		String preferredName = (String) jsonObject.get("Preferred Name");
		
		WaitForLoaderToDisappear();
		if(driver.findElement(locators.NameColumn).getText().equals(preferredName))
		{
			ExtentTestManager.getTest().log(Status.PASS,"Created Candidate verified successfully : "+preferredName);
			Log.info("Created Candidate verified successfully : "+preferredName);	
		}else {
			ExtentTestManager.getTest().log(Status.PASS,"Failed to verify Created Candidate ");
			Log.info("Failed to verify Created Candidate ");		
		}
	}
	
	public void createJsonFileForEnteredValues() {
		
		
		JSONObject jsonObject;
		try {
			jsonObject = new JSONObject();
			jsonObject.put("Hiring Classification", getDropdownValue(locators.HiringClassification));
			
			jsonObject.put("First Name", getFieldValue(locators.FirstName));
			jsonObject.put("Middle Name", getFieldValue(locators.MiddleName));
			jsonObject.put("Last Name", getFieldValue(locators.LastName));
			jsonObject.put("Preferred Name", getFieldValue(locators.PreferredName));
			
			jsonObject.put("Personal Email", getFieldValue(locators.PersonalEmail));
			jsonObject.put("Contact Number", getFieldValue(locators.ContactNumber));
			jsonObject.put("Gender", getDropdownValue(locators.Gender));
			jsonObject.put("Marital Status", getDropdownValue(locators.MaritalStatus));
			
			jsonObject.put("Date of Birth", getFieldValue(locators.DateOfBirth));
			jsonObject.put("Race Ethnicity", getDropdownValue(locators.Race_Ethnicity));
			jsonObject.put("Address Line 1", getFieldValue(locators.AddressLine1));
			jsonObject.put("Address Line 2", getFieldValue(locators.AddressLine2));
			
			jsonObject.put("Zip Code", getFieldValue(locators.ZipCode));
			jsonObject.put("City", getFieldValue(locators.City));
			jsonObject.put("State", getDropdownValue(locators.State));
			jsonObject.put("Attach Resume", getFieldTextValue(locators.AttachedResumeName));
			
			jsonObject.put("SSN Number", getFieldValue(locators.SSN_Number));
			jsonObject.put("SSN Uploaded", getFieldTextValue(locators.SSNUploadName));
			jsonObject.put("Certificate", getFieldValue(locators.Certificate));
			jsonObject.put("Certificate Uploaded", getFieldTextValue(locators.CertificateUploadName));

			jsonObject.put("Reporting Manager", getFieldValue(locators.ReportingTo));
			jsonObject.put("Designation", getFieldValue(locators.Designation));
			jsonObject.put("Role Name", getFieldValue(locators.RoleName));
			jsonObject.put("Business Unit", getFieldValue(locators.BusinessUnit));

			jsonObject.put("Division", getFieldValue(locators.Division));
			jsonObject.put("Technology", getFieldValue(locators.Technology));
			jsonObject.put("Department", getFieldValue(locators.Department));
			jsonObject.put("Immigration Status", getDropdownValue(locators.ImmigrationStatus));
			
			jsonObject.put("Visa Type", getDropdownValue(locators.VisaType));
			jsonObject.put("Date of Joining", getFieldValue(locators.DateOfJoining));
			jsonObject.put("Employment Type", getDropdownValue(locators.EmploymentType));
			jsonObject.put("Employment Sub Type", getDropdownValue(locators.EmploymentSubType));
			
			jsonObject.put("Special Access Needed", getFieldValue(locators.SpecialAccessNeeded));
			jsonObject.put("Training Required", getFieldValue(locators.TrainingRequired));
			jsonObject.put("Additional Training", getFieldValue(locators.AdditionalTraining));
			jsonObject.put("Benefits Waiver Form Uploaded", getFieldTextValue(locators.BenefitsWaiverForm_UploadName));
			
			jsonObject.put("Job Location", getDropdownValue(locators.JobLocation));
			jsonObject.put("Job Country", getDropdownValue(locators.JobCountry));
			jsonObject.put("Job ZipCode", getFieldValue(locators.JobZipCode));
			jsonObject.put("Job City", getFieldValue(locators.jobCityText));
			jsonObject.put("Job State", getFieldValue(locators.JobStateText));
			
			jsonObject.put("Currency", getDropdownValue(locators.Currency));
			jsonObject.put("Amount", getFieldValue(locators.Amount));
			jsonObject.put("Salary Type", getDropdownValue(locators.SalaryType));
			jsonObject.put("Additional Comments", getFieldValue(locators.AdditionalComments));
			
			
			 try (FileWriter file = new FileWriter("testData.json")) {
		            file.write(jsonObject.toJSONString());
		            System.out.println("JSON file created successfully!");
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
			
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Failed to Update Json File" + e.getMessage());
		}
		
		
		
		
       
    }

	 public String getDropdownValue(By field) {
		 Select dropdown = new Select(driver.findElement(field));
			WebElement selectedOption = dropdown.getFirstSelectedOption();
			String value = selectedOption.getText();
	    	return value;
	    }
	

    public String getFieldValue(By field) {
    	String value = driver.findElement(field).getAttribute("value");
    	return value;
    }
    
    public String getFieldTextValue(By field) {
    	String value = driver.findElement(field).getText();
    	return value;
    }
	
}
