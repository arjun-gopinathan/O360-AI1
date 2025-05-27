package com.Pages_PreBoardingUSMethods;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.BasePackage.Base_Class;
import com.Locators_PreBoardingUS.Locators_PendingWithCandidatePage;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class Methods_PendingWithCandidatePage extends Base_Class {
	
	SoftAssert Assert;
	
	JSONParser parser = new JSONParser();
	
	Locators_PendingWithCandidatePage locators = new Locators_PendingWithCandidatePage();
	
	public void verifyPendingWithCandidateage() throws InterruptedException
	{
		WaitForLoaderToDisappear();
		String pageHeader = driver.findElement(locators.pendingWithCandidatePageHeader).getText();
		if(pageHeader.equals("Pending with Candidate"))
		{
			ExtentTestManager.getTest().log(Status.PASS, "Successfully landed on Pending With Candidate Page");
			Log.info("Successfully landed on Pending With Candidate Page");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "Failed to land on Pending With Candidate Page");
			Log.info("Failed to land on Pending With Candidate Page");
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
	
	 public void enterCandidateName() throws InterruptedException, FileNotFoundException, IOException, org.json.simple.parser.ParseException {
	    	
//			String name = readPreferredNameFromProperties();
	    	
			JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("testData.json"));
			String name = (String) jsonObject.get("Preferred Name");
			
	    	clear(locators.searchValueInSearchDialogueBox);
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
	    
	    public void verifysearchedCandidateNameDisplayed() throws InterruptedException, FileNotFoundException, IOException, org.json.simple.parser.ParseException
		{
			WaitForLoaderToDisappear();
//			String name = readPreferredNameFromProperties();
			JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("testData.json"));
			String name = (String) jsonObject.get("Preferred Name");
			
			if(driver.findElement(locators.searchedCandidateName).getText().equals(name))
			{
				ExtentTestManager.getTest().log(Status.PASS,"Searched Candidate Found : "+name );
				Log.info("Searched Candidate Found: "+name);	
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
	    
	    public void verifyPendingWithCandidateForm() throws InterruptedException {
			try {
				WaitForLoaderToDisappear();
				boolean flag = ElementDisplayed(locators.pendingWithCandidateForm);

				ExtentTestManager.getTest().log(Status.PASS, "'Pending with Candidate' Form is opened : " + flag);
				Log.info("'Pending with Candidate' Form is opened : " + flag);
			} catch (Exception e) {
				System.out.println(e);
				ExtentTestManager.getTest().log(Status.FAIL, "Failed to open 'Pending with Candidate' Form");
				Log.info("Failed to open 'Pending with Candidate' Form");
			}
		}
	    
	   
	    public boolean isFieldsEditable(By field) {	    
	    	 	
	    	String fieldXPath = field.toString().replace("By.xpath: ", "").trim();    	
	    	String requiredxpath = fieldXPath + "/../../../label | " + fieldXPath + "/../../label |" + fieldXPath + "/../label |" + fieldXPath + "/../../../../../../label";
	    	
	    	boolean isEnabled = driver.findElement(field).isEnabled();
	    	if(isEnabled)
	    	{	    		
	    		ExtentTestManager.getTest().log(Status.PASS, driver.findElement(By.xpath(requiredxpath)).getText() + " : is editable");
				Log.info(driver.findElement(By.xpath(requiredxpath)).getText() + " :  is editable");
				return true;
	    	}else {
	    		ExtentTestManager.getTest().log(Status.FAIL, driver.findElement(By.xpath(requiredxpath)).getText() + " :  is not editable");
				Log.info(driver.findElement(By.xpath(requiredxpath)).getText() + " :  is not editable");
				return false;
	    	}        	
	    }
	    
	    public boolean isFieldsNonEditable(By field) {	    
    	 	
	    	String fieldXPath = field.toString().replace("By.xpath: ", "").trim();    	
	    	String requiredxpath = fieldXPath + "/../../../label | " + fieldXPath + "/../../label |" + fieldXPath + "/../label |" + fieldXPath + "/../../../../../../label";
	    	
	    	boolean isEnabled = driver.findElement(field).isEnabled();
	    	if(isEnabled)
	    	{	    		
	    		ExtentTestManager.getTest().log(Status.FAIL, driver.findElement(By.xpath(requiredxpath)).getText() + " : is editable");
				Log.info(driver.findElement(By.xpath(requiredxpath)).getText() + " :  is editable");
				return true;
	    	}else {
	    		ExtentTestManager.getTest().log(Status.PASS, driver.findElement(By.xpath(requiredxpath)).getText() + " :  is not editable");
				Log.info(driver.findElement(By.xpath(requiredxpath)).getText() + " :  is not editable");
				return false;
	    	}        	
	    }
	    
	    public void selectHiringClassification(String classification) {

			try {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});",
						driver.findElement(locators.hiringClassification));
				Select dropdown = new Select(driver.findElement(locators.hiringClassification));
				dropdown.selectByVisibleText(classification);
			
				ExtentTestManager.getTest().log(Status.PASS,"Option selected from Hiring Classification dropdown : " + classification);
				Log.info("Option selected from Hiring Classification dropdown : "+ classification);
			} catch (Exception e) {
				ExtentTestManager.getTest().log(Status.FAIL,"Expected to select " + classification + " from Hiring Classification dropdown");
				Log.info("Expected to select " + classification + " from Hiring Classification dropdown");
			}
		}
	    
	    public void selectYesForEligibleForBenefitsField() throws InterruptedException {

	    	try {
				click(locators.EligibleForBenefits_Yes);
				ExtentTestManager.getTest().log(Status.PASS,"Checked 'Yes' for 'EligibleForBenefits'");
				Log.info("Checked 'Yes' for 'EligibleForBenefits'");
			} catch (Exception e) {
				ExtentTestManager.getTest().log(Status.PASS,"Failed to Check 'Yes' for 'EligibleForBenefits'");
				Log.info("Failed to Check 'Yes' for 'EligibleForBenefits'");
			}
		}

		public void selectNoForLaptopRequiredField() {
			
			try {
				click(locators.LaptopRequired_No);
				ExtentTestManager.getTest().log(Status.PASS,"Checked 'No' for 'Laptop Required'");
				Log.info("Checked 'No' for 'Laptop Required'");
			} catch (Exception e) {
				ExtentTestManager.getTest().log(Status.PASS,"Failed to Check 'No' for 'Laptop Required'");
				Log.info("Failed to Check 'No' for 'Laptop Required'");
			}
		}

		public void selectNoForBackgroundCheckRequiredField() {

			try {
				click(locators.BackgroundCheckRequired_No);
				ExtentTestManager.getTest().log(Status.PASS,"Checked 'No' for 'Background Check Required'");
				Log.info("Checked 'No' for 'Background Check Required'");
			} catch (Exception e) {
				ExtentTestManager.getTest().log(Status.PASS,"Failed to Check 'No' for 'Background Check Required'");
				Log.info("Failed to Check 'No' for 'Background Check Required'");
			}
		}

		public void selectYesForAddDistributionList() {
			
	
			try {
				click(locators.AddDistributionList_Yes);
				ExtentTestManager.getTest().log(Status.PASS,"Checked 'Yes' for 'Add Distribution List'");
				Log.info("Checked 'Yes' for 'Add Distribution List'");
			} catch (Exception e) {
				ExtentTestManager.getTest().log(Status.PASS,"Failed to Check 'Yes' for 'Add Distribution List'");
				Log.info("Failed to Check 'Yes' for 'Add Distribution List'");
			}
		}
		
		public void isFormVisible(By formElement) {

			try
			{
				driver.findElement(formElement).isDisplayed();
				ExtentTestManager.getTest().log(Status.PASS, driver.findElement(formElement).getText() + " : form is Displayed");
				Log.info(driver.findElement(formElement).getText() + "form is Displayed");	
			}catch (Exception e) {
				ExtentTestManager.getTest().log(Status.FAIL, driver.findElement(formElement).getText() + "  : form is not Displayed");
				Log.info(driver.findElement(formElement).getText() + "form is not Displayed");
			}

	    }
		
		public void clickUpdateButton() throws InterruptedException {
			try {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", driver.findElement(locators.updateBtn));
				click(locators.updateBtn);
				ExtentTestManager.getTest().log(Status.PASS,"Clicked Update Button");
				Log.info("Clicked Update Button");
			} catch (InterruptedException e) {
				ExtentTestManager.getTest().log(Status.FAIL, "Failed to click Update Button");
				Log.info("Failed to click Update Button");
			}
		}
		
		public void clickSubmitOnBehalfButton() throws InterruptedException {
			try {
				
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", driver.findElement(locators.submitOnBehalfBtn));
				click(locators.submitOnBehalfBtn);
				ExtentTestManager.getTest().log(Status.PASS,"Clicked Submit On Behalf Button");
				Log.info("Clicked Update Button");
			} catch (InterruptedException e) {
				ExtentTestManager.getTest().log(Status.FAIL, "Failed to click Submit On Behalf Button");
				Log.info("Failed to click Submit On Behalf Button");
			}
		}
		
		public void sendReminderForPendingForms() throws InterruptedException 
		{

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", driver.findElement(locators.personalInformationForm));
			
	        List<WebElement> status = driver.findElements(By.xpath("//tbody/tr/td[3]"));
	        for(WebElement pendingForms :status )
	        	if(pendingForms.getText().equals("Pending"))
	        	{
	        		ExtentTestManager.getTest().log(Status.INFO,"There is form with status : Pending");
					Log.info("There is form with status : Pending");
					js.executeScript("arguments[0].scrollIntoView({block: 'center'});", driver.findElement(locators.sendReminderBtn));
	        		click(locators.sendReminderBtn);
	        		ExtentTestManager.getTest().log(Status.PASS,"Clicked 'Send Reminder' Button");
					Log.info("Clicked 'Send Reminder' Button");
					break;
	        	}else{
	        		ExtentTestManager.getTest().log(Status.FAIL,"All the forms are submitted");
					Log.info("All the forms are submitted");
	        	}
	        }
		
		public void confirmReminderMailSentPopup() throws InterruptedException
		{
			try {
				WaitForLoaderToDisappear();
				click(locators.okBtn);
				ExtentTestManager.getTest().log(Status.PASS,"Confirmed Reminder Mail Sent Popup");
				Log.info("Confirmed Reminder Mail Sent Popup");
			} catch (Exception e) {
				
				ExtentTestManager.getTest().log(Status.FAIL,"Failed to confirmed Reminder Mail Sent Popup");
				Log.info("Failed to confirmed Reminder Mail Sent Popup"+e);
			}
		}
		
		public void addCommentsInConfirmationPopupAndConfirm() throws InterruptedException {
			try {
				WaitForElementToBeVisible(locators.confirmationComment);
				input(locators.confirmationComment,"Confirmed");
				click(locators.okBtn);
				ExtentTestManager.getTest().log(Status.PASS,"Added comment and clicked OK button in Confirmation Popup");
				Log.info("Added comment and clicked OK button in Confirmation Popup");
			} catch (Exception e) {
				ExtentTestManager.getTest().log(Status.FAIL, "Failed to adde comment and click OK button in Confirmation Popup");
				Log.info("Failed to adde comment and click OK button in Confirmation Popup"+e);
			}
		}
		
		public void verifyPendingWithCandidateFormClosed() throws InterruptedException
		{
			WaitForLoaderToDisappear();
			if(driver.findElement(locators.searchIcon).isDisplayed()) {
				ExtentTestManager.getTest().log(Status.PASS,"Pending With Candidate Form is Closed");
				Log.info("Pending With Candidate Form is Closed");
			}else {
				ExtentTestManager.getTest().log(Status.FAIL, "Pending With Candidate Form is not Closed");
				Log.info("Pending With Candidate Form is not Closed");
			}
		}
	        
		   public void updateJsonFileWithNewValues() throws org.json.simple.parser.ParseException {
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
			        jsonObject.put("Hiring Classification", getDropdownValue(locators.hiringClassification));
					
					jsonObject.put("First Name", getFieldValue(locators.firstName));
					jsonObject.put("Middle Name", getFieldValue(locators.middleName));
					jsonObject.put("Last Name", getFieldValue(locators.lastName));
					jsonObject.put("Preferred Name", getFieldValue(locators.preferredName));
					
					jsonObject.put("Personal Email", getFieldValue(locators.email));
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
					jsonObject.put("Parent Office", getFieldValue(locators.ParentOffice));
					jsonObject.put("Business Unit", getFieldValue(locators.BusinessUnit));

					jsonObject.put("Division", getFieldValue(locators.Division));
					jsonObject.put("Technology", getFieldValue(locators.Technology));
					jsonObject.put("Department", getFieldValue(locators.Department));
					jsonObject.put("Immigration Status", getDropdownValue(locators.ImmigrationStatus));
					
					jsonObject.put("Visa Type", getDropdownValue(locators.VisaType));
					jsonObject.put("Date of Joining", getFieldValue(locators.DateOfJoining));
					jsonObject.put("Employment Type", getDropdownValue(locators.EmploymentType));
					
					jsonObject.put("Special Access Needed", getFieldValue(locators.SpecialAccessNeeded));
					jsonObject.put("Training Required", getFieldValue(locators.TrainingRequired));
					jsonObject.put("Additional Training", getFieldValue(locators.AdditionalTraining));
					
					jsonObject.put("Job Location", getDropdownValue(locators.JobLocation));
					jsonObject.put("Job Country", getDropdownValue(locators.JobCountry));
					jsonObject.put("Job ZipCode", getFieldValue(locators.JobZipCode));
					jsonObject.put("Job City", getFieldValue(locators.jobCityText));
					jsonObject.put("Job State", getFieldValue(locators.JobStateText));
					
					jsonObject.put("Currency", getDropdownValue(locators.Currency));
					jsonObject.put("Amount", getFieldValue(locators.Amount));
					jsonObject.put("Salary Type", getDropdownValue(locators.SalaryType));
					jsonObject.put("Additional Comments", getFieldValue(locators.AdditionalComments));
					
					jsonObject.put("Suggested Company Email", getFieldValue(locators.SuggestedCompanyEmail));
					jsonObject.put("Suggested UserName", getFieldValue(locators.SuggestedUserName));
					
					jsonObject.put("Approved Company Email", getFieldValue(locators.approvedCompanyEmail));
					jsonObject.put("Approved UserName", getFieldValue(locators.approvedUserName));

			        // Write updated JSON back to file
			        try (FileWriter fileWriter = new FileWriter(filePath)) {
			            fileWriter.write(jsonObject.toJSONString());
			            System.out.println("JSON file updated successfully!");
			        }
			    } catch (IOException e) {
			        e.printStackTrace();
			    }
			}
		   
		   public String getFieldValue(By field) {
		    	String value = driver.findElement(field).getAttribute("value");
		    	return value;
		    }
		    
		    public String getFieldTextValue(By field) {
		    	String value = driver.findElement(field).getText();
		    	return value;
		    }
		    
			 public String getDropdownValue(By field) {
				 Select dropdown = new Select(driver.findElement(field));
					WebElement selectedOption = dropdown.getFirstSelectedOption();
					String value = selectedOption.getText();
			    	return value;
			    }


			 public void clickConfirmButtonForSubmittedOnBehalfPopup() throws InterruptedException {
					WaitForLoaderToDisappear();
					WaitForElementToBeVisible(locators.okBtn);
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].scrollIntoView({block: 'center'});",
							driver.findElement(locators.okBtn));
					click(locators.okBtn);
					WaitForLoaderToDisappear();
					
					ExtentTestManager.getTest().log(Status.PASS, "Clicked 'OK' Button in Submitted On Behalf Popup");
					Log.info("Clicked 'OK' Button in Submitted On Behalf Popup");
				}
			 
	   
}
