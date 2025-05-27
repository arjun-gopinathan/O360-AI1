package com.Pages_PreBoardingUSMethods;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.BasePackage.Base_Class;
import com.Locators_PreBoardingUS.Locators_PendingWithCandidatePage;
import com.Locators_PreBoardingUS.Locators_PendingWithHRPage;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class Methods_PendingWithHRPage extends Base_Class {
	

	JSONParser parser = new JSONParser();
	
	Locators_PendingWithHRPage locators = new Locators_PendingWithHRPage();
	
	public void verifyPendingWithHRpage() throws InterruptedException
	{
		WaitForLoaderToDisappear();
		String pageHeader = driver.findElement(locators.pendingWithHRPageHeader).getText();
		if(pageHeader.equals("Pending with HR"))
		{
			ExtentTestManager.getTest().log(Status.PASS, "Successfully landed on Pending With HR Page");
			Log.info("Successfully landed on Pending With HR Page");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "Failed to land on Pending With HR Page");
			Log.info("Failed to land on Pending With HR Page");
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
	    
	    public void verifysearchedCandidateNameNotDisplayed() throws InterruptedException, FileNotFoundException, IOException, org.json.simple.parser.ParseException
		{
			WaitForLoaderToDisappear();
			
			if(driver.findElements(locators.searchedCandidateRow).isEmpty())
			{
				ExtentTestManager.getTest().log(Status.PASS,"Searched Candidate Not Found in Pending With HR Page");
				Log.info("Searched Candidate Not Found in Pending With HR Page");	
			}else {
				ExtentTestManager.getTest().log(Status.FAIL,"Searched Candidate Found in Pending With HR Page");
				Log.info("Searched Candidate Not Found in Pending With HR Page");		
			}
		}

	    public void clickonSearchedCandidateName() throws InterruptedException {
	    	
	        click(locators.searchedCandidateName);
	        ExtentTestManager.getTest().log(Status.PASS,"Clicked on searched candidate");
			Log.info("Clicked on searched candidate");	
	    }
	    
	    public void verifyPendingWithHRForm() throws InterruptedException {
			try {
				WaitForLoaderToDisappear();
				boolean flag = ElementDisplayed(locators.pendingWithHRForm);

				ExtentTestManager.getTest().log(Status.PASS, "'Pending with HR' Form is opened : " + flag);
				Log.info("'Pending with HR' Form is opened : " + flag);
			} catch (Exception e) {
				System.out.println(e);
				ExtentTestManager.getTest().log(Status.FAIL, "Failed to open 'Pending with HR' Form");
				Log.info("Failed to open 'Pending with HR' Form");
			}
		}
	    
	    public void clickRejectButton() throws InterruptedException {
	    	
	    	try {
				scrollIntoView(locators.rejectBtn);
				click(locators.rejectBtn);
				
				ExtentTestManager.getTest().log(Status.PASS, "Clicked Reject Button");
				Log.info("Clicked Reject Button");
			} catch (Exception e) {
				ExtentTestManager.getTest().log(Status.FAIL, "Failed to click Reject Button");
				Log.info("Failed to click Reject Button");
			}
	    }


	    public void clickApproveButton() {
	
	    	try {	
	    	scrollIntoView(locators.approveBtn);
			click(locators.approveBtn);
			ExtentTestManager.getTest().log(Status.PASS, "Clicked Approve Button");
			Log.info("Clicked Approve Button");
	    	} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Failed to click Approve Button");
			Log.info("Failed to click Approve Button");
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

	    // Method to click the 'OK' button in the confirmation popup
	    public void clickOkButtonInPopup() {
	    	try {
				click(locators.OkBtn_ConfirmationPopup);
				
				ExtentTestManager.getTest().log(Status.PASS, "Clicked OK Button in Confirmation Popup");
				Log.info("Clicked OK Button in Confirmation Popup");
			} catch (Exception e) {
				ExtentTestManager.getTest().log(Status.FAIL, "Failed to click OK Button in Confirmation Popup");
				Log.info("Failed to click OK Button in Confirmation Popup");
			}
	    }
	    
	    public void clickOkButtonInApprovedPopup() {
	    	try {
				click(locators.OkBtn_ConfirmationPopup);
				
				ExtentTestManager.getTest().log(Status.PASS, "Clicked OK Button in Approved Popup");
				Log.info("Clicked OK Button in Approved Popup");
			} catch (Exception e) {
				ExtentTestManager.getTest().log(Status.FAIL, "Failed to click OK Button in Approved Popup");
				Log.info("Failed to click OK Button in Approved Popup");
			}
	    }
	    
	    
	    public void clickOkButtonInRejectPopup() {
	    	try {
				click(locators.OkBtn_ConfirmationPopup);
				
				ExtentTestManager.getTest().log(Status.PASS, "Clicked OK Button in Reject Popup");
				Log.info("Clicked OK Button in Reject Popup");
			} catch (Exception e) {
				ExtentTestManager.getTest().log(Status.FAIL, "Failed to click OK Button in Reject Popup");
				Log.info("Failed to click OK Button in Reject Popup");
			}
	    }
	    public void enterRejectMessageInConfirmationPopup() throws InterruptedException
	    {
	    try {
	    		
	    	input(locators.comment_ConfirmationPopup,"Rejected");
	    	ExtentTestManager.getTest().log(Status.PASS, "Entered Reject Comment in Confirmation Popup");
			Log.info("Entered Reject Comment in Confirmation Popup");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Failed to enter Comment in Confirmation Popup");
			Log.info("Failed to enter Reject Comment in Confirmation Popup");
		}
	    }

	
	    public void enterConfirmationMessage() throws InterruptedException
	    {
	    try {
	    		
	    	input(locators.comment_ConfirmationPopup,"Approved");
	    	ExtentTestManager.getTest().log(Status.PASS, "Entered Comment in Confirmation Popup");
			Log.info("Entered Comment in Confirmation Popup");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Failed to enter Comment in Confirmation Popup");
			Log.info("Failed to enter Comment in Confirmation Popup");
		}
	    }
	    
	    public void verifyPendingWithHRFormClosed() throws InterruptedException
		{
			WaitForLoaderToDisappear();
			if(driver.findElement(locators.searchIcon).isDisplayed()) {
				ExtentTestManager.getTest().log(Status.PASS,"Pending With HR Form is Closed");
				Log.info("Pending With HR Form is Closed");
			}else {
				ExtentTestManager.getTest().log(Status.FAIL, "Pending With HR Form is not Closed");
				Log.info("Pending With HR Form is not Closed");
			}
		}
	    

}
