package com.Pages_PreBoardingUSMethods;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.BasePackage.Base_Class;
import com.Locators_PreBoardingUS.Locators_HrOnboardingPendingPage;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class Methods_HrOnboardingPendingPage extends Base_Class {
	
	SoftAssert Assert;
	
	JSONParser parser = new JSONParser();
	
	Locators_HrOnboardingPendingPage locators = new Locators_HrOnboardingPendingPage();
	
	public void verifyHrOnboardingPendingPage() throws InterruptedException
	{
		WaitForLoaderToDisappear();
		String pageHeader = driver.findElement(locators.hrOnboardingPendingPageHeader).getText();
		if(pageHeader.equals("HR Onboarding Pending"))
		{
			ExtentTestManager.getTest().log(Status.PASS, "Successfully landed on HR Onboarding Pending Page");
			Log.info("Successfully landed on HR Onboarding Pending Page");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "Failed to land on HR Onboarding Pending Page");
			Log.info("Failed to land on HR Onboarding Pending Page");
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
	 
//	 public static String readPreferredNameFromProperties() {
//	        Properties properties = new Properties();
//	        String preferredName = null;
//	        try {
//	            FileInputStream inputStream = new FileInputStream(".\\src\\test\\resources\\config.properties");
//	            properties.load(inputStream);
//
//	            preferredName = properties.getProperty("preferredName");
//	            inputStream.close();
//	        } catch (IOException e) {
//	            System.out.println("Error reading from properties file: " + e.getMessage());
//	        }
//	        return preferredName;
//	    }

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
	    
	    public void verifyHrOnboardingPendingForm() throws InterruptedException {
			try {
				WaitForLoaderToDisappear();
				boolean flag = ElementDisplayed(locators.hrOnboardingPendingForm);

				ExtentTestManager.getTest().log(Status.PASS, "'HR Onboarding Pending' Form is opened : " + flag);
				Log.info("'HR Onboarding Pending' Form is opened : " + flag);
			} catch (Exception e) {
				System.out.println(e);
				ExtentTestManager.getTest().log(Status.FAIL, "Failed to open 'HR Onboarding Pending' Form");
				Log.info("Failed to open 'HR Onboarding Pending' Form");
			}
		}
	    

	    public boolean areFieldsNonEditable() {	    	 	
	        return isFieldNonEditable(locators.hiringClassification)
	            && isFieldNonEditable(locators.rehire)
	            && isFieldNonEditable(locators.salutation)
	            && isFieldNonEditable(locators.firstName)
	            && isFieldNonEditable(locators.middleName)
	            && isFieldNonEditable(locators.lastName)
	            && isFieldNonEditable(locators.preferredName)
	        	&& isFieldNonEditable(locators.email)
	        	&& isFieldNonEditable(locators.ContactNumber)
	        	&& isFieldNonEditable(locators.Gender)
	        	&& isFieldNonEditable(locators.MaritalStatus)
	        	&& isFieldNonEditable(locators.DateOfBirth)
	        	&& isFieldNonEditable(locators.Race_Ethnicity)
	        	&& isFieldNonEditable(locators.AddressLine1)
	        	&& isFieldNonEditable(locators.AddressLine2)
	        	&& isFieldNonEditable(locators.ZipCode)
	        	&& isFieldNonEditable(locators.City)
	        	&& isFieldNonEditable(locators.State)
	        	&& isOtherFieldEditable(locators.AttachResume)
	        	&& isFieldNonEditable(locators.SSN_Number)
	        	&& isFieldNonEditable(locators.Certificate)
	        	&& isFieldNonEditable(locators.ReportingTo)
	        	&& isFieldNonEditable(locators.Designation)
	        	&& isFieldNonEditable(locators.RoleName)    	
	        	&& isOtherFieldsEditable(locators.BusinessUnit)
	        	&& isOtherFieldsEditable(locators.Division)
	        	&& isOtherFieldsEditable(locators.Technology)
	        	&& isOtherFieldsEditable(locators.Department)
	        	&& isFieldNonEditable(locators.ImmigrationStatus)
	        	&& isFieldNonEditable(locators.VisaType)
	        	&& isFieldNonEditable(locators.EmploymentType)
	        	&& isFieldNonEditable(locators.EmploymentSubType)
	        	&& isFieldNonEditable(locators.SpecialAccessNeeded)
	        	&& isFieldNonEditable(locators.TrainingRequired)
	        	&& isFieldNonEditable(locators.AdditionalTraining)  	
	        	&& isOtherFieldEditable(locators.BenefitsWaiverForm)   
	        	&& isRadioButtonEditable(locators.EligibleForBenefits_No)
	        	&& isRadioButtonEditable(locators.LaptopRequired_Yes)
	        	&& isRadioButtonEditable(locators.BackgroundCheckRequired_Yes)
	        	&& isOtherFieldEditable(locators.AddDistributionList_Yes)
	        	&& isFieldNonEditable(locators.JobLocation)
	        	&& isFieldNonEditable(locators.JobCountry)
	        	&& isFieldNonEditable(locators.JobZipCode)
	        	&& isFieldNonEditable(locators.jobCityText)
	        	&& isFieldNonEditable(locators.JobStateText)
	        	&& isFieldNonEditable(locators.Currency)
	        	&& isFieldNonEditable(locators.Amount)
	        	&& isFieldNonEditable(locators.SalaryType)
	        	&& isFieldNonEditable(locators.AdditionalComments)
	        	&& isFieldNonEditable(locators.SuggestedCompanyEmail)
	        	&& isFieldNonEditable(locators.SuggestedUserName);
//	        	&& isFieldNonEditable(locators.approvedCompanyEmail)
//	        	&& isFieldNonEditable(locators.approvedUserName);      
	    }
	   

	    public boolean isFieldNonEditable(By field) {	    	
	    	   String fieldName = ""; 
	    	   String fieldXPath = field.toString().replace("By.xpath: ", "").trim();
	    	   
	    	   try {
	    	        fieldName = driver.findElement(By.xpath(
	    	            "(" + fieldXPath + "/preceding-sibling::label | " +
	    	            fieldXPath + "/parent::*/label | " +
	    	            fieldXPath + "/parent::*/parent::*/label)[1]"
	    	        )).getText();
	    	    } catch (NoSuchElementException e) {
	    	        fieldName = "Unknown Field"; // Fallback if no label is found
	    	    }

	    	if(!driver.findElement(field).isEnabled())
	    	{	    		
	    		ExtentTestManager.getTest().log(Status.PASS, fieldName + " : is not editable");
				Log.info(fieldName + " :  is not editable");
				return true;
	    	}else {
	    		ExtentTestManager.getTest().log(Status.FAIL, fieldName + " :  is editable");
				Log.info(fieldName + " :  is editable");
				return false;
	    	}
	    }

	    public boolean isRadioButtonEditable(By radioButton) {
	
	    	String fieldName = ""; 
	    	String fieldXPath = radioButton.toString().replace("By.xpath: ", "").trim();
	    	   
	    	   try {
	    	        fieldName = driver.findElement(By.xpath("(" +fieldXPath + "/parent::*/parent::*/parent::*/label)[1]")).getText();
	    	    } catch (NoSuchElementException e) {
	    	        fieldName = "Unknown Field"; 
	    	    }
	    	
	        try {
	            WebElement element = driver.findElement(radioButton);
	            boolean isNonEditable = !element.isEnabled();
	            if (isNonEditable) {
	                ExtentTestManager.getTest().log(Status.PASS, fieldName + " :  is not editable");
	                Log.info(fieldName + " : is not editable");
	                return true;
	            } else { 
	                ExtentTestManager.getTest().log(Status.FAIL, fieldName + " : is editable");
	                Log.info(fieldName + " : is editable");
	                return false; 
	            }
	        } catch (Exception e) {
	            ExtentTestManager.getTest().log(Status.FAIL, "Error validating radio button: " + radioButton + " - " + e.getMessage());
	            Log.info("Error validating radio button: " + radioButton + " - " + e.getMessage());
	            return false; 
	        }
	    }
	    
	    public boolean isOtherFieldEditable(By field)
	    {
	    	 String fieldName = ""; 
	    	 String fieldXPath = field.toString().replace("By.xpath: ", "").trim();
	    	   
	    	 try {
	    		    fieldName = driver.findElement(By.xpath(
	    		        "(" + fieldXPath + "/parent::*/parent::*/parent::*/label | " +
	    		        fieldXPath + "/parent::*/parent::*/label)[1]"
	    		    )).getText();

	    	    } catch (NoSuchElementException e) {
	    	        fieldName = "Unknown Field"; // Fallback if no label is found
	    	    }

	    	boolean isDisabled = driver.findElement(field).getAttribute("disabled") != null;
	    	if(isDisabled)
	    	{	    		
	    		ExtentTestManager.getTest().log(Status.PASS, fieldName + " : is not editable");
				Log.info(fieldName + " : is not editable");
				return true;
	    	}else {
	    		ExtentTestManager.getTest().log(Status.FAIL, fieldName + "  : is editable");
				Log.info(fieldName + " : is editable");
				return false;
	    	}
	    }
	    
	    public boolean isOtherFieldsEditable(By field)
	    {
	    	boolean isDisabled = driver.findElement(field).getAttribute("disabled") != null;
	    	if(isDisabled)
	    	{	    		
	    		ExtentTestManager.getTest().log(Status.PASS, driver.findElement(field).getAttribute("placeholder") + " : is not editable");
				Log.info(driver.findElement(field).getAttribute("placeholder") + " : is not editable");
				return true;
	    	}else {
	    		ExtentTestManager.getTest().log(Status.FAIL, driver.findElement(field).getAttribute("placeholder") + " : is editable");
				Log.info(driver.findElement(field).getAttribute("placeholder") + " : is editable");
				return false;
	    	}
	    }
	    
	    
	    public boolean areFieldsEditable() {	    	 	
	        return isFieldsEditable(locators.SSN_Upload)
	            && isFieldsEditable(locators.Certificate_Upload1)
	            && isFieldsEditable(locators.ParentOffice)
	            && isFieldsEditable(locators.DateOfJoining);       
	    }

	    
	    public boolean isFieldsEditable(By field) {	    	
	    	   String fieldName = ""; 
	    	   String fieldXPath = field.toString().replace("By.xpath: ", "").trim();
	    	   
	    	   try {
	    		   fieldName = driver.findElement(By.xpath(
	    				    "(" + fieldXPath + "/parent::*/parent::*/parent::*/label | " +
	    				    fieldXPath + "/parent::*/parent::*/label | " +
	    				    fieldXPath + "/parent::*/label)"
	    				)).getText();
	    	    } catch (NoSuchElementException e) {
	    	        fieldName = "Unknown Field"; // Fallback if no label is found
	    	    }

	    	boolean isEnabled = driver.findElement(field).isEnabled();
	    	if(isEnabled)
	    	{	    		
	    		ExtentTestManager.getTest().log(Status.PASS, fieldName + " : is editable");
				Log.info(fieldName + " :  is editable");
				return true;
	    	}else {
	    		ExtentTestManager.getTest().log(Status.FAIL, fieldName + " :  is not editable");
				Log.info(fieldName + " :  is not editable");
				return false;
	    	}
	    }


	    
	    public void clickSSNUpload() throws InterruptedException {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});",driver.findElement(locators.SSN_Upload));
			Actions actions = new Actions(driver);
			WebElement element = driver.findElement(locators.SSN_Upload);
			actions.moveToElement(element).click().perform();
//	        click(locators.SSN_Upload);
	        ExtentTestManager.getTest().log(Status.INFO, "Clicked SSN Upload Field");
	        Log.info("Clicked SSN Upload Field");
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
	    
	    public void isSSNFileUploadSuccessfull(String fileName) throws InterruptedException {
	    	try {
	    		Thread.sleep(1500);
	    		JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});",driver.findElement(locators.SSNUploadName));
				WaitForElementToBeVisible(locators.SSNUploadName);
				String successText = driver.findElement(locators.SSNUploadName).getText().trim();
				System.out.println(successText);
				if (successText.equalsIgnoreCase(fileName)) {
					ExtentTestManager.getTest().log(Status.PASS, "Successfully Verified uploaded SSN PDF : " + successText );
					Log.info("Successfully Verified uploaded SSN PDF : " + successText);
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
	    
	    public void clickCertificateUpload() throws InterruptedException {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});",driver.findElement(locators.Certificate_Upload));
			Actions actions = new Actions(driver);
			WebElement element = driver.findElement(locators.Certificate_Upload);
			actions.moveToElement(element).click().perform();
//	        click(locators.Certificate_Upload);
	        ExtentTestManager.getTest().log(Status.INFO, "Clicked Certificate Upload Field");
	        Log.info("Clicked Certificate Upload Field");
	    }
	    
	    public void isCertificateFileUploadSuccessfull(String fileName) throws InterruptedException {
	    	try {
	    		Thread.sleep(1500);
	    		JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});",driver.findElement(locators.CertificateUploadName));
				WaitForElementToBeVisible(locators.CertificateUploadName);
				List<WebElement> uploadedFiles = driver.findElements(locators.CertificateUploadName);

		        boolean isUploaded = false; // Flag to track successful upload
		        for (WebElement fileElement : uploadedFiles) {
		            String successText = fileElement.getText().trim();
		            System.out.println(successText);
		            if (successText.equalsIgnoreCase(fileName)) {
		                isUploaded = true;
		                ExtentTestManager.getTest().log(Status.PASS, "Successfully verified uploaded Certificate: " + successText);
		                Log.info("Successfully verified uploaded Certificate: " + successText);
		                break; // Stop checking further once found
		            }
		        }

		        if (!isUploaded) {
		            ExtentTestManager.getTest().log(Status.FAIL, "Failed to upload Certificate: " + fileName);
		            Log.info("Failed to upload Certificate: " + fileName);
		        }
		    } catch (Exception e) {
		        System.out.println(e);
		        ExtentTestManager.getTest().log(Status.FAIL, "Exception occurred while checking Certificate upload");
		        Log.info("Exception occurred while checking Certificate upload");
		    }
	    }
	    
	    public void isValidationPopupDisplayed() {
	    	
	    	try {
				if(driver.findElement(locators.CertificateUploadPopup).isDisplayed())
				{
				String popupMessage = driver.findElement(locators.CertificateUploadPopup).getText();
				ExtentTestManager.getTest().log(Status.PASS, "Validation Popup displayed with message : " + popupMessage);
				Log.info("Validation Popup displayed with message : " + popupMessage);
				}else
				{
					ExtentTestManager.getTest().log(Status.FAIL, "Validation Popup not displayed when more than 3 PDFs attached for Cerficate Upload field");
				    Log.info("Validation Popup not displayed when more than 3 PDFs attached for Cerficate Upload field");
				}
			} catch (Exception e) {
				ExtentTestManager.getTest().log(Status.FAIL, "Validation Popup not displayed when more than 3 PDFs attached for Cerficate Upload field");
			    Log.info("Validation Popup not displayed when more than 3 PDFs attached for Cerficate Upload field");
			}
	    }

	    public void dismissPopup() throws InterruptedException {
	        try {
				click(locators.CertificateUploadPopupOkBtn);
			} catch (Exception e) {
				ExtentTestManager.getTest().log(Status.FAIL, "Validation Popup not displayed when more than 3 PDFs attached for Cerficate Upload field");
			    Log.info("Validation Popup not displayed when more than 3 PDFs attached for Cerficate Upload field");
			}
	    }
	    
	    public void clickDateOfJoiningField() throws InterruptedException {
	    	JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});",driver.findElement(locators.DateOfJoiningCalender));
//			click(locators.DateOfJoiningCalender);
			Actions actions = new Actions(driver);
			WebElement element = driver.findElement(locators.DateOfJoiningCalender);
			actions.moveToElement(element).click().perform();
	    }
	    
//	    public void selectAnotherDate() {
//	    	try {
//				String tomorrowssDate = getTomorrowsDate();
//				System.out.println(tomorrowssDate);
//				WebElement Date = driver.findElement(By.xpath("//td[@aria-label='" + tomorrowssDate + "']"));
//				Thread.sleep(1000);
//				Date.click();
//				ExtentTestManager.getTest().log(Status.PASS,"Selected date '"+ tomorrowssDate + "' from Date of Joining Calender");
//				Log.info("Selected date '"+ tomorrowssDate + "' from Date of Joining Calender");
//			} catch (Exception e) {
//				
//				ExtentTestManager.getTest().log(Status.FAIL, "Failed to selecet date for Date of Joining Field");
//				Log.info("Failed to selecet date for Date of Joining Field");	
//	        }    
//	    }
	    
	    
	    public void selectAnotherDate() {
	        try {
	            String Date = getTodaysDate();
	            System.out.println("Trying to select: " + Date);
	            
	            // Find the date element
	            WebElement dateElement = null;

	            try {
	                dateElement = driver.findElement(By.xpath("//td[@aria-label='" + Date + "']"));
	            } catch (Exception e) {
	                System.out.println("Date not found. Trying next month...");
	            }

	            // If date is not found, click the next month arrow and try again
	            if (dateElement == null) {
	                try {
	                    WebElement nextMonthArrow = driver.findElement(By.xpath("//button[@aria-label='Next month']"));
	                    nextMonthArrow.click();
	                    Thread.sleep(2000); // Wait for the next month to load
	                    
	                    // Try finding the date again after clicking next
	                    dateElement = driver.findElement(By.xpath("//td[@aria-label='" + Date + "']"));
	                } catch (NoSuchElementException ex) {
	                    ExtentTestManager.getTest().log(Status.FAIL, "Date not found even after moving to the next month.");
	                    Log.info("Date not found even after moving to the next month.");
	                    return; // Exit method
	                }
	            }

	            // Click the date if found
	            if (dateElement != null) {
	                Thread.sleep(1000);
	                dateElement.click();
	                ExtentTestManager.getTest().log(Status.PASS, "Selected date '" + Date + "' from Date of Joining Calendar");
	                Log.info("Selected date '" + Date + "' from Date of Joining Calendar");
	            }

	        } catch (Exception e) {
	            ExtentTestManager.getTest().log(Status.FAIL, "Failed to select date for Date of Joining Field");
	            Log.info("Failed to select date for Date of Joining Field");
	        }
	    }

	    public static String getTodaysDate() {
	        Calendar calendar = Calendar.getInstance(); // Today's date
	        SimpleDateFormat formatter = new SimpleDateFormat("MMMM d, yyyy");
	        return formatter.format(calendar.getTime());
	    }

	    public static String getTomorrowsDate() {
	        Calendar calendar = Calendar.getInstance();
	        calendar.add(Calendar.DAY_OF_MONTH, 1); // Add 1 day to today
	        SimpleDateFormat formatter = new SimpleDateFormat("MMMM d, yyyy");
	        return formatter.format(calendar.getTime());
	    }
	    
	    public static String getDayAfterTomorrowsDate() {
	        Calendar calendar = Calendar.getInstance();
	        calendar.add(Calendar.DAY_OF_MONTH, 2); // Add 2 days to today
	        SimpleDateFormat formatter = new SimpleDateFormat("MMMM d, yyyy");
	        return formatter.format(calendar.getTime());
	    }
	    
	    
	    public void verifyParentOfficeFieldIsEmpty() {
	    	JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});",driver.findElement(locators.ParentOffice));
	    	String text = driver.findElement(locators.ParentOffice).getAttribute("value");
	    	if(text.isEmpty())
	    	{
	    		ExtentTestManager.getTest().log(Status.PASS,"Parent Office Field is Empty");
				Log.info("Parent Office Field is Empty");	
	    	}else {
	    		ExtentTestManager.getTest().log(Status.FAIL,"Parent Office Field is not Empty");
				Log.info("Parent Office Field is not Empty");	
	    	}
	    }
	    
	    public void selectParentOffice(String reportingManager) throws InterruptedException {
			try {
				Actions actions = new Actions(driver);
				WebElement element = driver.findElement(locators.ParentOffice);
				actions.moveToElement(element).click().perform();
				
//				click(locators.ParentOffice);
				WaitForLoaderToDisappear();

				List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table mb-0']/tbody/tr/td[1]"));
				for (WebElement row : rows) {
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].scrollIntoView({block: 'center'});", row);
					if (row.getAttribute("innerHTML").trim().equalsIgnoreCase(reportingManager)) {
						row.click();
						ExtentTestManager.getTest().log(Status.PASS,"Parent Office selected from dialogue box: " + row.getText().trim());
						Log.info("Parent Office selected from dialogue box: " + row.getText().trim());
						break;
					}
				}
				click(locators.oKBtnInDialogueBox);
				WaitForLoaderToDisappear();
			} catch (InterruptedException e) {
				System.out.println(e);
				ExtentTestManager.getTest().log(Status.FAIL, "Failed to Select Parent Office ");
				Log.info("Failed to Select Parent Office ");
			}
		}

		public void validateParentOfficeSelection(String parentOffice) {
			String selection = driver.findElement(locators.ParentOffice).getAttribute("value");
			if (selection.equals(parentOffice)) {
				ExtentTestManager.getTest().log(Status.PASS,"Selected Parent Office '" + selection + "' is shown in the Field");
				Log.info("Selected Parent Office '" + selection + "' is shown in the Field");
			} else {
				ExtentTestManager.getTest().log(Status.FAIL, "Expected " + parentOffice + ", but found:" + selection);
				Log.info("Expected " + parentOffice + ", but found:" + selection);
			}
		}
		
		public void verifyDateOfJoiningField() {
			
			String selectedDate = getDayAfterTomorrowsDate();
	        String Date = driver.findElement(locators.DateOfJoining).getAttribute("value");
	        
	        DateTimeFormatter expectedFormatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
	        LocalDate SelectedDate = LocalDate.parse(selectedDate, expectedFormatter);

	        // Convert actual date (MM/dd/yyyy format) to LocalDate
	        DateTimeFormatter actualFormatter = DateTimeFormatter.ofPattern("M/d/yyyy", Locale.ENGLISH);
	        LocalDate date = LocalDate.parse(Date, actualFormatter);
			
			 if (date.equals(SelectedDate)) {
					ExtentTestManager.getTest().log(Status.PASS,"Selected Date of Joining '"+ date + "' is shown in the field");
					Log.info("Selected Date of Joining '"+ date + "' is shown in the field");
		        } else {
					ExtentTestManager.getTest().log(Status.FAIL, "Expected 'Date of Joining'" + SelectedDate + ", but found:" + date);
					Log.info("Expected 'Date of Joining'" + SelectedDate + ", but found:" + date);
		        }    
		}
		
		public void clickRequestEmailCreationButton() throws InterruptedException {
			try {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", driver.findElement(locators.requestEmailCreationBtn));
				click(locators.requestEmailCreationBtn);
				ExtentTestManager.getTest().log(Status.PASS,"Clicked Request Email Creation Button");
				Log.info("Clicked Request Email Creation Button");
			} catch (InterruptedException e) {
				ExtentTestManager.getTest().log(Status.FAIL, "Failed to click Request Email Creation Button");
				Log.info("Failed to click Request Email Creation Button");
			}
	        
	    }
		
		public void clickUpdateButton() throws InterruptedException {
			WaitForLoaderToDisappear();
			WaitForElementToBeVisible(locators.updateBtn);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});",
					driver.findElement(locators.updateBtn));
			click(locators.updateBtn);
			WaitForLoaderToDisappear();
			
			ExtentTestManager.getTest().log(Status.PASS, "Clicked 'Update' Button");
			Log.info("Clicked 'Update' Button");
		}
		
		public void clickConfirmPreboarding() throws InterruptedException {
			WaitForLoaderToDisappear();
			WaitForElementToBeVisible(locators.confirmPreboardingBtn);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});",
					driver.findElement(locators.confirmPreboardingBtn));
			click(locators.confirmPreboardingBtn);
			WaitForLoaderToDisappear();
			
			ExtentTestManager.getTest().log(Status.PASS, "Clicked 'Confirm Preboarding' Button");
			Log.info("Clicked 'Confirm Preboarding' Button");
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
		
		public void verifySavedCandidateFormClosed() throws InterruptedException
		{
			WaitForLoaderToDisappear();
			if(driver.findElement(locators.searchIcon).isDisplayed()) {
				ExtentTestManager.getTest().log(Status.PASS,"Saved Candidate Form is Closed");
				Log.info("Saved Candidate Form is Closed");
			}else {
				ExtentTestManager.getTest().log(Status.FAIL, "Saved Candidate Form is not Closed");
				Log.info("Saved Candidate Form is not Closed");
			}
		}
		
		 public void verifyAutoPopulatedDropdownField(String expectedValue, By field) {
			 
			try {
				String fieldXPath = field.toString().replace("By.xpath: ", "").trim();
				String precedingSiblingXPath = fieldXPath + "/../../child::label";
				 
				 Select dropdown = new Select(driver.findElement(field));
					WebElement selectedOption = dropdown.getFirstSelectedOption();
					String actualValue = selectedOption.getText();
					System.out.println(actualValue);
					System.out.println(expectedValue);
				    if((expectedValue.trim()).equals(actualValue))
				    {
				    	ExtentTestManager.getTest().log(Status.PASS,driver.findElement(By.xpath(precedingSiblingXPath)).getText() +" is Auto Populated with Value : "+ actualValue);
						Log.info(driver.findElement(By.xpath(precedingSiblingXPath)).getText() +" is Auto Populated with Value : "+ actualValue);
				    }else {
				    	ExtentTestManager.getTest().log(Status.FAIL, driver.findElement(By.xpath(precedingSiblingXPath)).getText() +" is not Auto Populated with Expected Value");
						Log.info(driver.findElement(By.xpath(precedingSiblingXPath)).getText() +" is not Auto Populated with Expected Value");
				    }
			} catch (Exception e) {
				ExtentTestManager.getTest().log(Status.FAIL, "Failed to verify Auto Populated values in fields "+e.getMessage());
			}
		    }
		

	    public void verifyAutoPopulatedField(String expectedValue, By field) {
	    	
	    	try {
				String fieldXPath = field.toString().replace("By.xpath: ", "").trim();
				String precedingSiblingXPath = fieldXPath + "/preceding-sibling::label |" + fieldXPath + "/ancestor::mat-form-field/../../child::label |" + fieldXPath + "/../../child::label";
				
				
				String actualValue = driver.findElement(field).getAttribute("value");
				System.out.println(expectedValue);
				System.out.println(actualValue);	
				if((expectedValue.trim()).equals(actualValue))
				{

					ExtentTestManager.getTest().log(Status.PASS,driver.findElement(By.xpath(precedingSiblingXPath)).getText() +" is Auto Populated with Value : "+ actualValue);
					Log.info(driver.findElement(By.xpath(precedingSiblingXPath)).getText() +" is Auto Populated with Value : "+ actualValue);
				}else {
					ExtentTestManager.getTest().log(Status.FAIL, driver.findElement(By.xpath(precedingSiblingXPath)).getText() +" is not Auto Populated with Expected Value");
					Log.info(driver.findElement(By.xpath(precedingSiblingXPath)).getText() +" is not Auto Populated with Expected Value");
				}
			} catch (Exception e) {
				ExtentTestManager.getTest().log(Status.FAIL, "Failed to verify Auto Populated values in fields "+e.getMessage());
			}
	    }
	    
	    public void verifyAutoPopulatedFieldText(String expectedValue, By field) {
	    	
	    	try {
				String fieldXPath = field.toString().replace("By.xpath: ", "").trim();    	
				String requiredxpath = fieldXPath + "/../../../label | " + fieldXPath + "/../../label";
					
				String actualValue = driver.findElement(field).getText();
				System.out.println(expectedValue);
				System.out.println(actualValue);	
				if((expectedValue.trim()).equals(actualValue))
				{
					ExtentTestManager.getTest().log(Status.PASS,driver.findElement(By.xpath(requiredxpath)).getText() +" is Auto Populated with Value : "+ actualValue);
					Log.info(driver.findElement(By.xpath(requiredxpath)).getText() +" is Auto Populated with Value : "+ actualValue);
				}else {
					ExtentTestManager.getTest().log(Status.FAIL, driver.findElement(By.xpath(requiredxpath)).getText() +" is not Auto Populated with Expected Value :"+expectedValue);
					Log.info(driver.findElement(By.xpath(requiredxpath)).getText() +" is not Auto Populated with Expected Value :"+expectedValue);
				}
			} catch (Exception e) {
				ExtentTestManager.getTest().log(Status.FAIL, "Field is not Auto Populated with Expected Value :"+expectedValue);
				Log.info("Field is not Auto Populated with Expected Value :"+expectedValue);
			}
	    }
	    
	    public void clickConfirmPreboardingBtn() throws InterruptedException {
			WaitForLoaderToDisappear();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});",driver.findElement(locators.confirmPreboardingBtn));
			click(locators.confirmPreboardingBtn);
			WaitForLoaderToDisappear();
			
			ExtentTestManager.getTest().log(Status.PASS, "Clicked 'Confirm Preboarding' Button");
			Log.info("Clicked 'Confirm Preboarding' Button");
		}
	    
	    public void clickOkBtnForApprovedPopUp() throws InterruptedException {
			WaitForLoaderToDisappear();
			WaitForElementToBeVisible(locators.JoinMailSentPopup_OkBtn);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});",
					driver.findElement(locators.JoinMailSentPopup_OkBtn));
			click(locators.JoinMailSentPopup_OkBtn);
			WaitForLoaderToDisappear();
			
			ExtentTestManager.getTest().log(Status.PASS, "Clicked 'OK' Button in Approved Popup");
			Log.info("Clicked 'OK' Button in Approved Popup");
		}
	    
	    public void clickConfirmButtonForJoinMailSentPopup() throws InterruptedException {
			WaitForLoaderToDisappear();
			WaitForElementToBeVisible(locators.JoinMailSentPopup_OkBtn);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});",
					driver.findElement(locators.JoinMailSentPopup_OkBtn));
			click(locators.JoinMailSentPopup_OkBtn);
			WaitForLoaderToDisappear();
			
			ExtentTestManager.getTest().log(Status.PASS, "Clicked 'OK' Button in Join Mail Sent Popup");
			Log.info("Clicked 'OK' Button in Join Mail Sent Popup");
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
		        jsonObject.put("SSN Uploaded", getFieldTextValue(locators.SSNUploadName));
				jsonObject.put("Parent Office", getFieldValue(locators.ParentOffice));
				jsonObject.put("Date of Joining", getFieldValue(locators.DateOfJoining));
				
				jsonObject.put("Suggested Company Email", getFieldValue(locators.SuggestedCompanyEmail));
				jsonObject.put("Suggested UserName", getFieldValue(locators.SuggestedUserName));

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

		
}
