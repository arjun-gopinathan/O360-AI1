package com.Pages_PreBoardingUSMethods;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.BasePackage.Base_Class;
import com.Locators_PreBoardingUS.Locators_ActiveEmployeesPage;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class Methods_ActiveEmployeesPage extends Base_Class{
	
	JSONParser parser = new JSONParser();
	
	Locators_ActiveEmployeesPage locators = new Locators_ActiveEmployeesPage();
	
	public void verifyActiveEmployeespage() throws InterruptedException
	{
		WaitForLoaderToDisappear();
		String pageHeader = driver.findElement(locators.activeEmployeesPageHeader).getText();
		if(pageHeader.equals("Active Employees"))
		{
			ExtentTestManager.getTest().log(Status.PASS, "Successfully landed on Active Employees Page");
			Log.info("Successfully landed on Active Employees Page");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "Failed to land on Active Employees Page");
			Log.info("Failed to land on Active Employees Page");
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
			if(actualValue.contains("Employee Name"))
			{
				ExtentTestManager.getTest().log(Status.PASS, "'Employee Name' is selected by default in Search Column");
		    	Log.info("'Employee Name' is selected by default in Search Column");
			}else {
				ExtentTestManager.getTest().log(Status.PASS, "'Employee Name' is not selected by default in Search Column");
		    	Log.info("'Employee Name' is not selected by default in Search Column");
			}
	    }

	    public void isSearchTypeSelectedByDefault() {
	    	
	    	Select searchType = new Select(driver.findElement(locators.searchTypeInSearchDialogueBox));
			WebElement selectedOption = searchType.getFirstSelectedOption();
			String actualValue = selectedOption.getText();
			if(actualValue.contains("Contains"))
			{
				ExtentTestManager.getTest().log(Status.PASS, "'Contains' is selected by default in Search Type");
		    	Log.info("'Contains' is selected by default in Search Type");
			}else {
				ExtentTestManager.getTest().log(Status.PASS, "'Contains' is selected by default in Search Type");
		    	Log.info("'Contains' is selected by default in Search Type");
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

}
