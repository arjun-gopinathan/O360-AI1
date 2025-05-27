package com.Pages_PreBoardingUSMethods;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.BasePackage.Base_Class;
import com.Locators_PreBoardingUS.Locators_CandidateOnBoardingPage;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class Methods_CandidateOnBoardingPage extends Base_Class{
	
JSONParser parser = new JSONParser();
	
Locators_CandidateOnBoardingPage locators = new Locators_CandidateOnBoardingPage();
	
	public void verifyCandidateOnBoardingpage() throws InterruptedException
	{
		WaitForLoaderToDisappear();
		String pageHeader = driver.findElement(locators.CandidateOnBoardingPageHeader).getText();
		if(pageHeader.equals("Candidate On Boarding"))
		{
			ExtentTestManager.getTest().log(Status.PASS, "Successfully landed on Candidate OnBoarding Page");
			Log.info("Successfully landed on Candidate OnBoarding Page");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "Failed to land on Candidate OnBoarding Page");
			Log.info("Failed to land on Candidate OnBoarding Page");
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
	    
	    public void verifyCandidateOnBoardingForm() throws InterruptedException {
			try {
				WaitForLoaderToDisappear();
				boolean flag = ElementDisplayed(locators.CandidateOnBoardingForm);

				ExtentTestManager.getTest().log(Status.PASS, "'Candidate OnBoarding' Form is opened : " + flag);
				Log.info("'Candidate OnBoarding' Form is opened : " + flag);
			} catch (Exception e) {
				System.out.println(e);
				ExtentTestManager.getTest().log(Status.FAIL, "Failed to open 'Candidate OnBoarding' Form");
				Log.info("Failed to open 'Candidate OnBoarding' Form");
			}
		}
	    
	    public void clickBackedOutButton() throws InterruptedException {
	    	
	    	try {
				scrollIntoView(locators.backedOutBtn);
				click(locators.backedOutBtn);
				
				ExtentTestManager.getTest().log(Status.PASS, "Clicked BackedOut Button");
				Log.info("Clicked BackedOut Button");
			} catch (Exception e) {
				ExtentTestManager.getTest().log(Status.FAIL, "Failed to click BackedOut Button");
				Log.info("Failed to click BackedOut Button");
			}
	    }


	    public void clickConfirmOnBoardingButton() {
	
	    	try {	
	    	scrollIntoView(locators.confirmOnBoardingBtn);
			click(locators.confirmOnBoardingBtn);
			ExtentTestManager.getTest().log(Status.PASS, "Clicked 'Confirm OnBoarding' Button");
			Log.info("Clicked 'Confirm OnBoarding' Button");
	    	} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Failed to click 'Confirm OnBoarding' Button");
			Log.info("Failed to click 'Confirm OnBoarding' Button");
	    	}
	    }
	   


	    public void isConfirmationPopupDisplayed() throws InterruptedException {
	    	
	    	WaitForLoaderToDisappear();
	    	try {
	    	if(driver.findElement(locators.confirmationPopup).isDisplayed())
	    	{
	    		ExtentTestManager.getTest().log(Status.PASS, "Confirmation Popup Opens");
				Log.info("Confirmation Popup Opens");
	    	}
	    	}catch (Exception e) {
	    		ExtentTestManager.getTest().log(Status.PASS, "Confirmation Popup is closed");
				Log.info("Confirmation Popup is closed");
			}
	    }
	    	

	    public void clickCancelButtonInPopup() {
	    	try {
				click(locators.CancelBtn_ConfirmationPopup);
				
				ExtentTestManager.getTest().log(Status.PASS, "Clicked Cancel Button in Confirmation Popup");
				Log.info("Clicked Cancel Button in Confirmation Popup");
			} catch (Exception e) {
				ExtentTestManager.getTest().log(Status.FAIL, "Failed to click Cancel Button in Confirmation Popup");
				Log.info("Failed to click Cancel Button in Confirmation Popup");
			}
	    }


	    public void clickOkButtonInPopup() throws InterruptedException {
	    	WaitForLoaderToDisappear();
	    	try {
				click(locators.OkBtn_ConfirmationPopup);
				
				ExtentTestManager.getTest().log(Status.PASS, "Clicked OK Button in Confirmation Popup");
				Log.info("Clicked OK Button in Confirmation Popup");
			} catch (Exception e) {
				ExtentTestManager.getTest().log(Status.FAIL, "Failed to click OK Button in Confirmation Popup");
				Log.info("Failed to click OK Button in Confirmation Popup");
			}
	    }
	    
	    public void clickOkButtonInOnBoardingCompletedPopup() throws InterruptedException {
	    	WaitForLoaderToDisappear();
	    	try {
				click(locators.OkBtn_ConfirmationPopup);
				
				ExtentTestManager.getTest().log(Status.PASS, "Clicked OK Button in OnBoarding Completed Popup");
				Log.info("Clicked OK Button in OnBoarding Completed Popup");
			} catch (Exception e) {
				ExtentTestManager.getTest().log(Status.FAIL, "Failed to click OK Button in OnBoarding Completed Popup");
				Log.info("Failed to click OK Button in OnBoarding Completed Popup");
			}
	    }
	    
	    public void enterConfirmationMessage() throws InterruptedException
	    {
	    	WaitForLoaderToDisappear();
	    	try {
	    		
	    	input(locators.comment_ConfirmationPopup,"Confirmed");
	    	ExtentTestManager.getTest().log(Status.PASS, "Entered Comment in Confirmation Popup");
			Log.info("Entered Comment in Confirmation Popup");
	    	} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Failed to enter Comment in Confirmation Popup");
			Log.info("Failed to enter Comment in Confirmation Popup");
	    	}
	    }
	    
	    public void verifyCandidateOnBoardingFormClosed() throws InterruptedException
	  		{
	  			WaitForLoaderToDisappear();
	  			if(driver.findElement(locators.searchIcon).isDisplayed()) {
	  				ExtentTestManager.getTest().log(Status.PASS,"Candidate OnBoarding Form is Closed");
	  				Log.info("Candidate OnBoarding Form is Closed");
	  			}else {
	  				ExtentTestManager.getTest().log(Status.FAIL, "Candidate OnBoarding Form is not Closed");
	  				Log.info("Candidate OnBoarding Form is not Closed");
	  			}
	  		}

	    public void verifyAutoPopulatedDropdownField(String expectedValue, By field) {
			 
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
		    }
	    
 public void verifyAutoPopulatedField(String expectedValue, By field) {
	    	
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
		
}
