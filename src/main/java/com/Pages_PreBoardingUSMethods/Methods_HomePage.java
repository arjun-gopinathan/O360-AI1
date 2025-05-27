package com.Pages_PreBoardingUSMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.BasePackage.Base_Class;
import com.Locators_PreBoardingUS.Locators_HomePage;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;


public class Methods_HomePage extends Base_Class {


	Locators_HomePage Locators = new Locators_HomePage();
	
	public void navigateToEmployeeTab() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", driver.findElement(Locators.Employee));
		click(Locators.Employee);
		
		ExtentTestManager.getTest().log(Status.PASS, "Clicked on 'Employee' Tab in side Panel");
	}

	public void clickPreBoardingUS() throws InterruptedException {
		click(Locators.PreBoardingUS);
	
		ExtentTestManager.getTest().log(Status.PASS, "Clicked on 'Pre Boarding US' Submenu");
	}
	
	public void clickOnBoarding() throws InterruptedException {
		click(Locators.OnBoarding);
	
		ExtentTestManager.getTest().log(Status.PASS, "Clicked on 'On Boarding' Submenu");
	}
	
	public void clickEmployeeSubMenu() throws InterruptedException {
		click(Locators.EmployeeSubMenu);
	
		ExtentTestManager.getTest().log(Status.PASS, "Clicked on 'Employee' Submenu");
	}
	
	public void clickActiveEmployees() throws InterruptedException {
		click(Locators.ActiveEmployee);
	
		ExtentTestManager.getTest().log(Status.PASS, "Clicked on 'Active Employees' Submenu");
	}

	public void clickCreateCandidate() throws InterruptedException {
		click(Locators.CreateCandidate);
		
		ExtentTestManager.getTest().log(Status.PASS, "Clicked on 'Create Candidate' Submenu");
		WaitForLoaderToDisappear();

	}
	
	public void clickApprovals() throws InterruptedException {
		click(Locators.Approvals);
		
		ExtentTestManager.getTest().log(Status.PASS, "Clicked on 'Approvals' Submenu");

	} 
	public void clickUsEmailApprovals() throws InterruptedException {
		click(Locators.UsEmailApprovals);
		
		ExtentTestManager.getTest().log(Status.PASS, "Clicked on 'US Email Approvals' Submenu");
		WaitForLoaderToDisappear();
	}
	
	public void clickSavedCandidate() throws InterruptedException {
		WaitForLoaderToDisappear();
		
		click(Locators.SavedCandidate);
		
		ExtentTestManager.getTest().log(Status.PASS, "Clicked on 'Saved Candidate' Submenu");
		WaitForLoaderToDisappear();
	}
	
	public void clickHROnBoardingPending() throws InterruptedException {
		WaitForLoaderToDisappear();
		click(Locators.HrOnboardingPending);
		
		ExtentTestManager.getTest().log(Status.PASS, "Clicked on 'Hr OnBoarding Pending' Submenu");
		WaitForLoaderToDisappear();
	}
	
	public void clickPendingvWithCandidate() throws InterruptedException {
		WaitForLoaderToDisappear();
		click(Locators.PendingWithCandidate);
		
		ExtentTestManager.getTest().log(Status.PASS, "Clicked on 'Pending with Candidate' Submenu");
		WaitForLoaderToDisappear();
	}
	
	public void clickPendingvWithHR() throws InterruptedException {
		WaitForLoaderToDisappear();
		click(Locators.PendingWithHR);
		
		ExtentTestManager.getTest().log(Status.PASS, "Clicked on 'Pending with HR' Submenu");
		WaitForLoaderToDisappear();
	}
	
	public void clickHROnBoardingQueue() throws InterruptedException {
		WaitForLoaderToDisappear();
		click(Locators.HROnBoardingQueue);
		
		ExtentTestManager.getTest().log(Status.PASS, "Clicked on 'HR OnBoarding Queue' Submenu");
		WaitForLoaderToDisappear();
	}
	
	public void clickCandidateOnBoarding() throws InterruptedException {
		WaitForLoaderToDisappear();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});",
				driver.findElement(Locators.CandidateOnBoarding));
		click(Locators.CandidateOnBoarding);
		
		ExtentTestManager.getTest().log(Status.PASS, "Clicked on 'Candidate OnBoarding' Submenu");
		WaitForLoaderToDisappear();
	}

}
