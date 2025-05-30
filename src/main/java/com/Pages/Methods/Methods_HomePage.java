package com.Pages.Methods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.Page_Repositary.Locators_HomePage;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class Methods_HomePage {
Locators_HomePage Locators = new Locators_HomePage();
WebDriver driver;
	
public void verifySuccessfulLogin() throws InterruptedException {
	Thread.sleep(2000);
	Log.info("Validating successful login");
	String title = driver.getTitle().toString();
	if (title.equals("Organization 360")) {
		System.out.println(title);
		ExtentTestManager.getTest().log(Status.PASS, "Successful login");
	} else {
		System.out.println("error in login");
		ExtentTestManager.getTest().log(Status.FAIL, "Failed to Login");
	}
}

public void validateDashBoard() throws InterruptedException {
	Thread.sleep(2000);
	String exptectedTxt = "Dashboard";
	Thread.sleep(2000);
	String actualTxt = driver.findElement(Locators.dashBoard).getText().toString();
	Assert.assertEquals(exptectedTxt, actualTxt, " User is still into Login Page");
	ExtentTestManager.getTest().log(Status.PASS, "Verifying dashboard is displayed successfully");
}

}
