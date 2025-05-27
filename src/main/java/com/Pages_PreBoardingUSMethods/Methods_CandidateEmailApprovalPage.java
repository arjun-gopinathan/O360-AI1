package com.Pages_PreBoardingUSMethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.BasePackage.Base_Class;
import com.Locators_PreBoardingUS.Locators_CandidateEmailApprovalPage;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class Methods_CandidateEmailApprovalPage extends Base_Class {
	
	SoftAssert Assert;
	
	//to read from json file
	JSONParser parser = new JSONParser();
	
	
	Locators_CandidateEmailApprovalPage locators = new Locators_CandidateEmailApprovalPage();
	Methods_CreateCandidatePage methods_CreateCandidatePage = new Methods_CreateCandidatePage();
	
	public void verifyCandidateEmailApprovalPage() throws InterruptedException
	{
		WaitForLoaderToDisappear();
		String pageHeader = driver.findElement(locators.candidateEmailApprovalPageHeader).getText();
		if(pageHeader.equals("Candidate Email Approval"))
		{
			ExtentTestManager.getTest().log(Status.PASS, "Successfully landed on Candidate Email Approval Page");
			Log.info("Successfully landed on Candidate Email Approval Page");
		}else {
			ExtentTestManager.getTest().log(Status.PASS, "Failed to land on Candidate Email Approval Page");
			Log.info("Failed to land on Candidate Email Approval Page");
		}		
	}
	
    public void clickSearchIcon() throws InterruptedException {
        try {
			click(locators.searchIcon);
			ExtentTestManager.getTest().log(Status.PASS, "Clicked search Icon");
			Log.info("Clicked search Icon");
		} catch (Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL, "Failed to clicked search Icon");
			Log.info("Failed to clicked search Icon");
		}
    }

    public void isSearchDialogOpened() {
    	
       if(driver.findElement(locators.searchDialogueBox).isDisplayed())
       {
    	   ExtentTestManager.getTest().log(Status.PASS, "Search Dialogue Box is Opened");
    	   Log.info("Search Dialogue Box is Opened");
       }else {
    	   ExtentTestManager.getTest().log(Status.FAIL, "Failed to open Search Dialogue Box");
    	   Log.info("Failed to open Search Dialogue Box");
       }
    }

    public void isSearchColumnSelectedByDefault() {
    	
    	Select searchColumn = new Select(driver.findElement(locators.searchColumnInSearchDialogueBox));
		WebElement selectedOption = searchColumn.getFirstSelectedOption();
		String actualValue = selectedOption.getText();
		if(actualValue.contains("Name"))
		{
			ExtentTestManager.getTest().log(Status.PASS, "'Name' is selected by default in Search Column");
	    	Log.info("'Name' is selected by default in Search Column");
		}else {
			ExtentTestManager.getTest().log(Status.PASS, "'Name' is not selected by default in Search Column");
	    	Log.info("'Name' is not selected by default in Search Column");
		}
    }

    public void isSearchTypeSelectedByDefault() {
    	
    	Select searchType = new Select(driver.findElement(locators.searchTypeInSearchDialogueBox));
		WebElement selectedOption = searchType.getFirstSelectedOption();
		String actualValue = selectedOption.getText();
		if(actualValue.contains("Starts with"))
		{
			ExtentTestManager.getTest().log(Status.PASS, "'Starts with' is selected by default in Search Type");
	    	Log.info("'Starts with' is selected by default in Search Type");
		}else {
			ExtentTestManager.getTest().log(Status.PASS, "'Starts with' is selected by default in Search Type");
	    	Log.info("'Starts with' is selected by default in Search Type");
		}
    }
    
//    public static String readPreferredNameFromProperties() {
//        Properties properties = new Properties();
//        String preferredName = null;
//        try {
//            FileInputStream inputStream = new FileInputStream(".\\src\\test\\resources\\config.properties");
//            properties.load(inputStream);
//
//            preferredName = properties.getProperty("preferredName");
//            inputStream.close();
//        } catch (IOException e) {
//            System.out.println("Error reading from properties file: " + e.getMessage());
//        }
//        return preferredName;
//    }

    public void enterCandidateName() throws InterruptedException, FileNotFoundException, IOException, ParseException {
    	
//    	String name = readPreferredNameFromProperties();
    	JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("testData.json"));
		String name = (String) jsonObject.get("Preferred Name");
    	
    	input(locators.searchValueInSearchDialogueBox,name);
    	ExtentTestManager.getTest().log(Status.PASS, "Entered Name '"+name +"'in Search Value Field");
    	Log.info("Entered Name '"+name +"'in Search Value Field");
    }

    public void clickSearchButton() throws InterruptedException {
       
    	try {
			click(locators.searchBtn);
			ExtentTestManager.getTest().log(Status.PASS, "Clicked search Button");
			Log.info("Clicked search button");
		} catch (Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL, "Failed to clicked search Button");
			Log.info("Failed to clicked search button");
		}
	}
    
    public void verifysearchedCandidateNameDisplayed() throws InterruptedException, FileNotFoundException, IOException, ParseException
	{
		WaitForLoaderToDisappear();
		
//		String name = readPreferredNameFromProperties();
		
		JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("testData.json"));
		String name = (String) jsonObject.get("Preferred Name");
		if(driver.findElement(locators.searchedCandidateName).getText().equals(name))
		{
			ExtentTestManager.getTest().log(Status.PASS,"Searched Candidate Found : "+name );
			Log.info("Searched Candidate Found:  : ");	
		}else {
			ExtentTestManager.getTest().log(Status.FAIL,"Unable to find the searched candidate : "+name);
			Log.info("Unable to find the searched candidate : "+name);		
		}
	}

    public void clickonSearchedCandidateName() throws InterruptedException {
    	
        click(locators.searchedCandidateName);
        ExtentTestManager.getTest().log(Status.PASS,"Clicked on searched candidate");
		Log.info("Clicked on searched candidate");	
    }
    
    
    public void verifyEmailApprovalForm() throws InterruptedException {
		try {
			WaitForLoaderToDisappear();
			boolean flag = ElementDisplayed(locators.emailApprovalForm);

			ExtentTestManager.getTest().log(Status.PASS, "Email Approval Form is opened : " + flag);
			Log.info("Email Approval Form is opened : " + flag);
		} catch (Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL, "Failed to open Email Approval Form");
			Log.info("Failed to open Email Approval Form");
		}
	}

    public boolean isFieldAutoPopulatedAndNonEditable(By field) {
    	
    	if( driver.findElement(field).getAttribute("value")!= null && !driver.findElement(field).isEnabled())
    	{
    		ExtentTestManager.getTest().log(Status.PASS, driver.findElement(field).getAttribute("name") + " is autopopulated and is not editable");
			Log.info(driver.findElement(field).getAttribute("name") + " is autopopulated and is not editable");
			return true;
    	}else {
    		ExtentTestManager.getTest().log(Status.FAIL, driver.findElement(field).getAttribute("name") + " is either not autopopulated or is not editable");
			Log.info(driver.findElement(field).getAttribute("name") + " is either not autopopulated or is not editable");
			return false;
    	}
    }
    
    public boolean isRadioButtonCheckedAndNonEditable(By radioButton) {
        try {
            WebElement element = driver.findElement(radioButton);

            boolean isChecked = element.isSelected(); // Check if the radio button is selected
            boolean isNonEditable = !element.isEnabled(); // Check if the radio button is not editable

            if (isChecked && isNonEditable) {
                ExtentTestManager.getTest().log(Status.PASS, element.getAttribute("name") + " is checked and is not editable");
                Log.info(element.getAttribute("name") + " is checked and is not editable");
                return true;
            } else {
                ExtentTestManager.getTest().log(Status.FAIL, element.getAttribute("name") + " is either not checked or is editable");
                Log.info(element.getAttribute("name") + " is either not checked or is editable");
                return false; 
            }
        } catch (Exception e) {
            ExtentTestManager.getTest().log(Status.FAIL, "Error validating radio button: " + radioButton + " - " + e.getMessage());
            Log.info("Error validating radio button: " + radioButton + " - " + e.getMessage());
            return false; // Exception occurred
        }
    }
    
    public boolean verifyAllFields() {
        return isFieldAutoPopulatedAndNonEditable(locators.firstName) &&
               isFieldAutoPopulatedAndNonEditable(locators.middleName) &&
               isFieldAutoPopulatedAndNonEditable(locators.lastName) &&
               isFieldAutoPopulatedAndNonEditable(locators.preferredName) &&
               isFieldAutoPopulatedAndNonEditable(locators.email) &&
               isFieldAutoPopulatedAndNonEditable(locators.reportingManager) &&
               isFieldAutoPopulatedAndNonEditable(locators.designation) &&
               isFieldAutoPopulatedAndNonEditable(locators.businessUnit) &&
               isFieldAutoPopulatedAndNonEditable(locators.division) &&
               isFieldAutoPopulatedAndNonEditable(locators.technology) &&
               isFieldAutoPopulatedAndNonEditable(locators.department) &&
               isFieldAutoPopulatedAndNonEditable(locators.dateOfJoining) &&
               isFieldAutoPopulatedAndNonEditable(locators.specialAccessNeeded) &&
               isFieldAutoPopulatedAndNonEditable(locators.trainingRequired) &&
               isFieldAutoPopulatedAndNonEditable(locators.additionalTraining) &&
               isRadioButtonCheckedAndNonEditable(locators.LaptopRequired_Yes) &&
               isRadioButtonCheckedAndNonEditable(locators.BackgroundCheckRequired_Yes) &&
               isFieldAutoPopulatedAndNonEditable(locators.jobCountry) &&
               isFieldAutoPopulatedAndNonEditable(locators.jobZipCode) &&
               isFieldAutoPopulatedAndNonEditable(locators.jobCityText) &&
               isFieldAutoPopulatedAndNonEditable(locators.jobStateText)&&
        	   isFieldAutoPopulatedAndNonEditable(locators.suggestedCompanyEmail)&&
        	   isFieldAutoPopulatedAndNonEditable(locators.suggestedCompanyUserName);
    }
    
    public void clickConfirmEmailBtn() throws InterruptedException {
		WaitForLoaderToDisappear();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});",driver.findElement(locators.confirmEmailBtn));
		click(locators.confirmEmailBtn);
		WaitForLoaderToDisappear();
		
		ExtentTestManager.getTest().log(Status.PASS, "Clicked 'Confirm Email' Button");
		Log.info("Clicked 'Confirm Email' Button");
	}
    
    public boolean isValidationMessageDisplayed(WebElement fieldErrorElement, String expectedMessage) {
		boolean isMessageDisplayed = false;
		try {
			isMessageDisplayed = fieldErrorElement.getText().equals(expectedMessage);

			if (isMessageDisplayed) {
				ExtentTestManager.getTest().log(Status.PASS,"Validation message is displayed correctly: " + expectedMessage);
				Log.info("Validation message is displayed correctly: " + expectedMessage);
			} else {
				ExtentTestManager.getTest().log(Status.FAIL, "Validation message is not displayed as expected. Expected: "+ expectedMessage + ", Found: " + fieldErrorElement.getText());
				Log.info("Validation message is not displayed as expected. Expected: "+ expectedMessage + ", Found: " + fieldErrorElement.getText());
			}
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Validation message is not displayed as expected. Expected: "+ expectedMessage + ", Found: " + fieldErrorElement.getText());
			Log.info("Validation message is not displayed as expected. Expected: "+ expectedMessage + ", Found: " + fieldErrorElement.getText());
		}
		return isMessageDisplayed;
	}

    public void verifyAllValidationMessages() {
    	Assert = new SoftAssert();
//		Assert.assertTrue(isValidationMessageDisplayed(driver.findElement(locators.approvedCompanyEmailValidationMsg),
//						"Confirm Company email is required."));
//		Assert.assertTrue(isValidationMessageDisplayed(driver.findElement(locators.approvedUserNameValidationMsg),
//				"Confirm User name is required."));
		Assert.assertTrue(isValidationMessageDisplayed(driver.findElement(locators.temporaryPasswordValidationMsg),
				"Temporary password required."));
		Assert.assertTrue(isValidationMessageDisplayed(driver.findElement(locators.webmailUrlValidationMsg),
				"Webmail Url required."));
    }
    
    public void enterApprovedCompanyEmail(String email) throws InterruptedException {
        
    	clear(locators.approvedCompanyEmail);
    	input(locators.approvedCompanyEmail,email);
    	click(locators.webmailUrl);
    	ExtentTestManager.getTest().log(Status.PASS, "Entered Approved Company Email :" + email);
		Log.info("Entered Approved Company Email :" + email);
    }

    public void invalidApprovedCompanyEmailValidation() {
		try {
			String enteredEmail = driver.findElement(locators.approvedCompanyEmail).getAttribute("value").trim();
			if ( driver.findElement(locators.approvedCompanyEmailValidationMsg).getText().equalsIgnoreCase("Invalid email."))
			{
			    ExtentTestManager.getTest().log(Status.PASS, "Entered email is invalid : "+enteredEmail+" and validation message is shown : "+driver.findElement(locators.approvedCompanyEmailValidationMsg).getText());
			    Log.info("Entered email is invalid : "+enteredEmail+" and validation message is shown : "+driver.findElement(locators.approvedCompanyEmailValidationMsg).getText());
			} else {
			    ExtentTestManager.getTest().log(Status.FAIL, "Invalid email validation not shown");
			    Log.info("Invalid email validation not shown");
			}
		} catch (Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL, "Fails to Validate Approved Company Email Field");
			Log.info("Fails to Validate Approved Company Email Field");
		}
	}
    
    public void validApprovedCompanyEmailValidation() {
		try {
			String enteredEmail = driver.findElement(locators.approvedCompanyEmail).getAttribute("value").trim();
			if ( driver.findElements(locators.approvedCompanyEmailValidationMsg).isEmpty())
			{
				 ExtentTestManager.getTest().log(Status.PASS, "Entered email is valid : "+enteredEmail+" and no validation message is shown.");
				    Log.info("Entered email is valid : "+enteredEmail+" and no validation message is shown.");
				} else {
				    ExtentTestManager.getTest().log(Status.FAIL, "Either the email is incorrect or a validation message is displayed.");
				    Log.info("Either the email is incorrect or a validation message is displayed.");
				}
		} catch (Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL, "Fails to Validate Approved Company Email Field");
			Log.info("Fails to Validate Approved Company Email Field");
		}
	}
    
    public void enterApprovedUserName(String approvedUserName) throws InterruptedException {
		
		try {
			clear(locators.approvedUserName);
			input(locators.approvedUserName, approvedUserName);
			ExtentTestManager.getTest().log(Status.PASS, "Entered Approved UserName :" + approvedUserName);
			Log.info("Entered Approved UserName :" + approvedUserName);
		} catch (Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL, "Failed to enter 'Approved UserName' field");
			Log.info("Failed to enter 'Approved UserName' field");
		}
	}

	public void validateApprovedUserName() {
		try {
			String approvedUserName = driver.findElement(locators.approvedUserName).getAttribute("value");
			String regex = "^(?=.*[a-zA-Z])[a-zA-Z0-9!@#$%^&*()_+\\-\\[\\]{};':\"\\\\|,.<>/? ]+$";
			if (approvedUserName.matches(regex)) {
				ExtentTestManager.getTest().log(Status.PASS,"Approved UserName fields field accepts Alphabetic, numeric and special character inputs : " + approvedUserName);
				Log.info("Approved UserName fields field accepts Alphabetic, numeric and special character inputs : " + approvedUserName);
			} else {
				ExtentTestManager.getTest().log(Status.FAIL,"Approved UserName field does not accept alphabetic, numeric, or special character inputs correctly: " + approvedUserName);
				Log.info("Approved UserName field does not accept alphabetic, numeric, or special character inputs correctly: " + approvedUserName);
			}
		} catch (Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL, "Fails to Validate Approved UserName Field");
			Log.info("Fails to Validate Approved UserName Field");
		}
	}
	
	public void enterTemporaryPassword(String temporaryPassword) throws InterruptedException {
			
			try {
				clear(locators.temporaryPassword);
				input(locators.temporaryPassword, temporaryPassword);
				ExtentTestManager.getTest().log(Status.PASS, "Entered Temporary Password :" + temporaryPassword);
				Log.info("Entered Temporary Password :" + temporaryPassword);
			} catch (Exception e) {
				System.out.println(e);
				ExtentTestManager.getTest().log(Status.FAIL, "Failed to enter 'Temporary Password' field");
				Log.info("Failed to enter 'Temporary Password' field");
			}
		}

	public void validateTemporaryPasswordField() {
		try {
			String temporaryPassword = driver.findElement(locators.temporaryPassword).getAttribute("value");
			String regex = "^(?=.*[a-zA-Z])[a-zA-Z0-9!@#$%^&*()_+\\-\\[\\]{};':\"\\\\|,.<>/? ]+$";
			if (temporaryPassword.matches(regex)) {
				ExtentTestManager.getTest().log(Status.PASS,"'Temporary Password' fields field accepts Alphabetic, numeric and special character inputs : " + temporaryPassword);
				Log.info("'Temporary Password' fields field accepts Alphabetic, numeric and special character inputs : " + temporaryPassword);
			} else {
				ExtentTestManager.getTest().log(Status.FAIL,"'Temporary Password' field does not accept alphabetic, numeric, or special character inputs correctly: " + temporaryPassword);
				Log.info("'Temporary Password' field does not accept alphabetic, numeric, or special character inputs correctly: " + temporaryPassword);
			}
		} catch (Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL, "Fails to Validate 'Temporary Password' Field");
			Log.info("Fails to Validate 'Temporary Password' Field");
		}
	}

	public void enterWebMailURL(String webMailURL) throws InterruptedException {
		
		try {
			clear(locators.webmailUrl);
			input(locators.webmailUrl, webMailURL);
			ExtentTestManager.getTest().log(Status.PASS, "Entered WebMail URL :" + webMailURL);
			Log.info("Entered WebMail URL :" + webMailURL);
		} catch (Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL, "Failed to enter 'WebMail URL' field");
			Log.info("Failed to enter 'WebMail URL' field");
		}
	}

	public void validateWebMailURLField() {
	try {
		String webMailURL = driver.findElement(locators.webmailUrl).getAttribute("value");
		String regex = "^(?=.*[a-zA-Z])[a-zA-Z0-9!@#$%^&*()_+\\-\\[\\]{};':\"\\\\|,.<>/? ]+$";
		if (webMailURL.matches(regex)) {
			ExtentTestManager.getTest().log(Status.PASS,"'WebMail URL' fields field accepts Alphabetic, numeric and special character inputs : " + webMailURL);
			Log.info("'WebMail URL' fields field accepts Alphabetic, numeric and special character inputs : " + webMailURL);
		} else {
			ExtentTestManager.getTest().log(Status.FAIL,"'WebMail URL' field does not accept alphabetic, numeric, or special character inputs correctly: " + webMailURL);
			Log.info("'WebMail URL' field does not accept alphabetic, numeric, or special character inputs correctly: " + webMailURL);
		}
	} catch (Exception e) {
		System.out.println(e);
		ExtentTestManager.getTest().log(Status.FAIL, "Fails to Validate 'WebMail URL' Field");
		Log.info("Fails to Validate 'WebMail URL' Field");
	}
}
	
	public void clickConfirmButtonForMailDetailsConfirmedPopup() throws InterruptedException {
		WaitForLoaderToDisappear();
		WaitForElementToBeVisible(locators.MailDetailsConfirmed_OkBtn);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});",
				driver.findElement(locators.MailDetailsConfirmed_OkBtn));
		click(locators.MailDetailsConfirmed_OkBtn);
		WaitForLoaderToDisappear();
		
		ExtentTestManager.getTest().log(Status.PASS, "Clicked 'OK' Button in Mail Details Confirmed Popup");
		Log.info("Clicked 'OK' Button in Mail Details Confirmed Popup");
	}
	
	public void updateJsonFileWithNewValues() {
	    String filePath = "testData.json";
	    JSONObject jsonObject;

	    try {
	        File file = new File(filePath);
	        if (file.exists()) {
	            // Read existing JSON file
	            JSONParser jsonParser = new JSONParser();
	            FileReader reader = new FileReader(file);
	            jsonObject = (JSONObject) jsonParser.parse(reader);
	            reader.close();
	        } else {
	            // If file doesn't exist, create a new JSON object
	            jsonObject = new JSONObject();
	        }

	        // Add new data to JSON
	        jsonObject.put("Approved Company Email", getFieldValue(locators.approvedCompanyEmail));
			jsonObject.put("Approved UserName", getFieldValue(locators.approvedUserName));

	        // Write updated JSON back to file
	        try (FileWriter fileWriter = new FileWriter(filePath)) {
	            fileWriter.write(jsonObject.toJSONString());
	            System.out.println("JSON file updated successfully!");
	        }
	    } catch (IOException | ParseException e) {
	        e.printStackTrace();
	    }
	}
	
	 public String getFieldValue(By field) {
	    	String value = driver.findElement(field).getAttribute("value");
	    	return value;
	    }
}
