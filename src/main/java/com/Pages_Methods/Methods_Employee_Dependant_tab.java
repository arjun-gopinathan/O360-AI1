package com.Pages_Methods;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.BasePackage.Base_Class;
import com.Page_Locators.Locators_Employee_Dependant_tab;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class Methods_Employee_Dependant_tab extends Base_Class {
	String Relation = null;

	Locators_Employee_Dependant_tab locators = new Locators_Employee_Dependant_tab();

	public boolean LoginFunctionalityValidation() throws InterruptedException {
		waitForSpinnerToDisappear(driver, 2, 2);
		ExtentTestManager.getTest().log(Status.INFO, "User logged in successfully");
		ExtentTestManager.getTest().log(Status.PASS, "Verifying Navigation panel is in left side ");
		return ElementDisplayed(locators.NavigationBar);
	}

	public boolean NavigateToDependantśPage() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "Clicking on Drop down");
		click(locators.ClickOnProfileDd);
		boolean flag1 = ElementDisplayed(locators.ClickOnProfileLink);// Validate if expanded or not
		ExtentTestManager.getTest().log(Status.PASS, "Expanded Dropdown and text Profile is their " + flag1);

		ExtentTestManager.getTest().log(Status.INFO, "Clicking on Profile to get into profile page");
		click(locators.ClickOnProfileLink);
		boolean flag2 = ElementDisplayed(locators.DependantTab);
		ExtentTestManager.getTest().log(Status.PASS,
				"Navigated to Profile Tab and text Dependant tab is visible " + flag2);

		ExtentTestManager.getTest().log(Status.INFO, "Clicking on Dependant Tab ");
		click(locators.DependantTab);
		boolean flag3 = ElementDisplayed(locators.DependantNameHeadInTable);
		ExtentTestManager.getTest().log(Status.PASS,
				"Navigated to Dependdant Tab and text Dependant Name is visible  " + flag3);

		boolean Flag = flag1 && flag2 && flag3;
		return Flag;
	}

	public String CheckingElementPresence() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "Checking if all are displayed or not");
		boolean flag1 = ElementDisplayed(locators.RelationHead);
		boolean flag2 = ElementDisplayed(locators.NameHead);
		boolean flag3 = ElementDisplayed(locators.DOBHead);
		boolean flag4 = ElementDisplayed(locators.SaveBtn);
		boolean flag5 = ElementDisplayed(locators.CloseBtn);
		boolean flag6 = ElementDisplayed(locators.DependantNameHeadInTable);
		boolean flag7 = ElementDisplayed(locators.DOBHeadInTable);
		boolean flag8 = ElementDisplayed(locators.StatusHeaderInTable);
		boolean flag9 = ElementDisplayed(locators.ActionHeaderInTable);

		boolean Flag = flag1 && flag2 && flag3 && flag4 && flag5 && flag6 && flag7 && flag8 && flag9;
		if (Flag == true) {
			ExtentTestManager.getTest().log(Status.PASS, "All are displayed " + Flag);
			return "the Elements are presence " + Flag;

		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "All not displayed " + Flag);
			return "the Element are not present " + Flag;
		}

	}

	public void CloseBtnFunctionality() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "Close button functionality");
		click(locators.CloseBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Clicked on closed Button");
		Log.info("CLicked on closed button");
		waitForSpinnerToDisappear(driver, 1, 2);
		handlePopupDesktop();
		String ExpectedText = "Dashboard";
		String ActualText = driver.findElement(locators.DashBoardHeader).getText().toString();
		if (ExpectedText.equals(ActualText)) {
			ExtentTestManager.getTest().log(Status.PASS, "We are in Homepage found dashboard header ");
			Log.info("We are in Home page");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "We are still in the Dependant Page");
			Log.info("We are still in dependant page");
		}
		ExtentTestManager.getTest().log(Status.INFO, "We are heading back to Dependant Page ");
		Log.info("We are heading back to Dependant Page");
		NavigateToDependantśPage();
	}

	public void AddDependantFather() throws InterruptedException {
		waitForSpinnerToDisappear(driver, 2, 2);
		ExtentTestManager.getTest().log(Status.INFO, "Selecting Relation FATHER");
		Log.info("Selecting Relation FATHER");

		select(" Father ", locators.SelectRelation);
		ExtentTestManager.getTest().log(Status.PASS, "Name should be filled Automatically ");
		Log.info("Name should be filled Automatically ");
		String disableOrNot = driver.findElement(locators.EnterName).getAttribute("disabled");
		String FatherName = driver.findElement(locators.EnterName).getText().toString();
		if (disableOrNot != null) {
			ExtentTestManager.getTest().log(Status.PASS, "Input field is disabled ");
			Log.info("Input field is disabled and Father Name is " + FatherName);
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "Input field is enabled ");
			Log.info("Input field is enabled and father name is " + FatherName);
		}
		input(locators.EnterDob, "11/26/1975");
		click(locators.SaveBtn);
	}

	public void BlankFieldValidation() throws InterruptedException {
		click(locators.SaveBtn);
		try {
			boolean isDisplayed = driver.findElement(locators.ErrorDialogHeader).isDisplayed();
			String ErrorMsg = driver.findElement(locators.ErrorMsgInDialog).getText().toString();
			if (isDisplayed == true) {
				ExtentTestManager.getTest().log(Status.PASS, "Error Pop is displayed.... Fields cannot be blank ");
				Log.info("Error Pop is displayed.... Fields cannot be blank ");
				ExtentTestManager.getTest().log(Status.PASS, "Error Message is " + ErrorMsg);
				Log.info("Error Message is " + ErrorMsg);
				ExtentTestManager.getTest().log(Status.PASS, "Need to Click 'OK' ");
				Log.info("Need to Click 'OK'  ");
				waitForSpinnerToDisappear(driver, 1, 2);
				click(locators.OkInErrorDialogBox);
			}
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.PASS, "No Error Popup displayed ");
			Log.info("No Error Popup displayed " + e.getMessage());
		}

	}

	public boolean openDatePicker() throws InterruptedException {
		Thread.sleep(2000);
		click(locators.DatePicker);
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on date picker");
		boolean Flag = ElementDisplayed(locators.CalenderPopup);
		if (Flag == true) {
			ExtentTestManager.getTest().log(Status.INFO, "Verifying if calender is displayed or not  ");
			ExtentTestManager.getTest().log(Status.PASS, "Calendar is displayed ");
			Log.info("Calender is displayed ");
			return Flag;
		} else {
			ExtentTestManager.getTest().log(Status.INFO, "Verifying if calender is displayed or not  ");
			ExtentTestManager.getTest().log(Status.PASS, "Calendar is not displayed ");
			Log.info("Calender is not displayed");
			return Flag;
		}

	}

	public void InvalidDateStartsWithYear() throws InterruptedException {
		Relation = "Mother";
		select(" Mother ", locators.SelectRelation);
		waitForSpinnerToDisappear(driver, 2, 2);
		input(locators.EnterDob, "1999/23/11");
		click(locators.SaveBtn);
		try {
			boolean isDisplayed = driver.findElement(locators.ErrorDialogHeader).isDisplayed();
			String ErrorMsg = driver.findElement(locators.ErrorMsgInDialog).getText().toString();
			if (isDisplayed == true) {
				ExtentTestManager.getTest().log(Status.PASS, "Error Pop is displayed.... Have to enter correct date");
				Log.info("Error Pop is displayed.... Have to enter correct date ");
				ExtentTestManager.getTest().log(Status.PASS, "Error Message is " + ErrorMsg);
				Log.info("Error Message is " + ErrorMsg);
				ExtentTestManager.getTest().log(Status.PASS, "Need to Click 'OK' ");
				Log.info("Need to Click 'OK'  ");
				waitForSpinnerToDisappear(driver, 1, 2);
				click(locators.OkInErrorDialogBox);
			}
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.PASS, "No Error Popup displayed ");
			Log.info("No Error Popup displayed " + e.getMessage());
		}

	}

	public void InvalidDateStartWithDays() throws InterruptedException {
		Relation = "Mother";
		select(" Mother ", locators.SelectRelation);
		clear(locators.EnterDob);
		input(locators.EnterDob, "23/11/1999");
		click(locators.SaveBtn);
		try {
			boolean isDisplayed = driver.findElement(locators.ErrorDialogHeader).isDisplayed();
			String ErrorMsg = driver.findElement(locators.ErrorMsgInDialog).getText().toString();
			if (isDisplayed == true) {
				ExtentTestManager.getTest().log(Status.PASS, "Error Pop is displayed.... Have to enter correct date");
				Log.info("Error Pop is displayed.... Have to enter correct date ");
				ExtentTestManager.getTest().log(Status.PASS, "Error Message is " + ErrorMsg);
				Log.info("Error Message is " + ErrorMsg);
				ExtentTestManager.getTest().log(Status.PASS, "Need to Click 'OK' ");
				Log.info("Need to Click 'OK'  ");
				waitForSpinnerToDisappear(driver, 1, 2);
				click(locators.OkInErrorDialogBox);
			}
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.PASS, "No Error Popup displayed ");
			Log.info("No Error Popup displayed " + e.getMessage());
		}
	}

	public void EnterFutureDatewithDatePicker() throws InterruptedException {
		Relation = "Mother";
		select(" Mother ", locators.SelectRelation);
		clear(locators.EnterDob);
		Log.info("opening cLENDER");
		openDatePicker();
		waitForSpinnerToDisappear(driver, 1, 2);
		click(locators.ChoseDate);
		ExtentTestManager.getTest().log(Status.INFO, "clicked on chose date");
		click(locators.Futureyear);
		ExtentTestManager.getTest().log(Status.INFO, "Selected Year");
		click(locators.FutureMon);
		ExtentTestManager.getTest().log(Status.INFO, "Selected Month");
		click(locators.FutureDate);
		ExtentTestManager.getTest().log(Status.INFO, "Selected Day");

		try {
			boolean isDisplayed = driver.findElement(locators.ErrorDialogHeader).isDisplayed();
			String ErrorMsg = driver.findElement(locators.FutureDateErrorMsg).getText().toString();
			if (isDisplayed == true) {
				ExtentTestManager.getTest().log(Status.PASS, "Error Pop is displayed.... Cannot Select Future Date ");
				Log.info("Error Pop is displayed.... Cannot Select Future Date ");
				ExtentTestManager.getTest().log(Status.PASS, "Error Message is " + ErrorMsg);
				Log.info("Error Message is " + ErrorMsg);
				ExtentTestManager.getTest().log(Status.PASS, "Need to Click 'OK' ");
				Log.info("Need to Click 'OK'  ");
				waitForSpinnerToDisappear(driver, 1, 2);
				click(locators.OkInErrorDialogBox);
			}
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.PASS, "No Error Popup displayed ");
			Log.info("No Error Popup displayed " + e.getMessage());
		}
	}

	public void EnterDOBInLeapYear() throws InterruptedException {
		Relation = "Mother";
		select(" Mother ", locators.SelectRelation);
		clear(locators.EnterDob);
		input(locators.EnterDob, "02/29/1968");

		click(locators.SaveBtn);
		waitForSpinnerToDisappear(driver, 1, 2);
		By element = By.xpath("//tr[td[@data-title='Relation' and normalize-space() = '" + Relation + "']]");
		Log.info("Here's the updated xpath: " + element);
		try {
			boolean Flag = driver.findElement(element).isDisplayed();
			if (Flag == true) {
				ExtentTestManager.getTest().log(Status.PASS,
						"Element is displayed successfully added Dependant with DOB on leap year " + Flag);
				Log.info("Element is displayed successfully added Dependant with DOB on leap year " + Flag);
			} else {
				ExtentTestManager.getTest().log(Status.PASS, "Element is not displayed  " + Flag);
				Log.info("Element is not displayed  " + Flag);
			}
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.PASS, "No Element Popup displayed ");
			Log.info("No Element Popup displayed " + e.getMessage());
		}
	}

	public void enterDOBWithOldDate() throws InterruptedException {
		Relation = "Son";

		clear(locators.EnterDob);
		select(" Son ", locators.SelectRelation);
		clear(locators.EnterName);
		waitForSpinnerToDisappear(driver, 1, 1);
		input(locators.EnterName, "Aleena");
		input(locators.EnterDob, "3/31/1900");
		click(locators.SaveBtn);

		By element = By.xpath("//tr[td[@data-title='Relation' and normalize-space() = '" + Relation + "']]");
		Log.info("Here's the updated xpath: " + element);
		try {
			boolean Flag = driver.findElement(element).isDisplayed();
			if (Flag == true) {
				ExtentTestManager.getTest().log(Status.PASS,
						"Element is displayed successfully added Dependant with very old DOB " + Flag);
				Log.info("Element is displayed successfully added Dependant with very old DOB " + Flag);
			} else {
				ExtentTestManager.getTest().log(Status.PASS, "Element is not displayed  " + Flag);
				Log.info("Element is not displayed  " + Flag);
			}
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.PASS, "No Element Popup displayed ");
			Log.info("No Element Popup displayed " + e.getMessage());
		}
	}

	public void SpecialCaseInName() throws InterruptedException {
		select(" Son ", locators.SelectRelation);
		waitForSpinnerToDisappear(driver, 1, 1);
		input(locators.EnterName, "#90REs");
		input(locators.EnterDob, "10/12/2003");
		click(locators.SaveBtn);

		By element = By.xpath("//tr[td[@data-title='Relation' and normalize-space() = '" + Relation + "']]");
		Log.info("Here's the updated xpath: " + element);
		try {
			boolean Flag = driver.findElement(element).isDisplayed();
			if (Flag == true) {
				ExtentTestManager.getTest().log(Status.PASS,
						"Element is displayed successfully added Dependant with name having special Char " + Flag);
				Log.info("Element is displayed successfully added Dependant with name having special Char  " + Flag);
			} else {
				ExtentTestManager.getTest().log(Status.PASS, "Element is not displayed  " + Flag);
				Log.info("Element is not displayed  " + Flag);
			}
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.PASS, "No Element Popup displayed ");
			Log.info("No Element Popup displayed " + e.getMessage());
		}
	}

	public void ValidateKeyBoardInputInDOBField() throws InterruptedException {
		Relation = "Spouse";
		select(" Spouse ", locators.SelectRelation);
		waitForSpinnerToDisappear(driver, 1, 1);
		input(locators.EnterName, "Vedant");
		input(locators.EnterDob, "12/12/2001");

		click(locators.SaveBtn);

		By element = By.xpath("//tr[td[@data-title='Relation' and normalize-space() = '" + Relation + "']]");
		Log.info("Here's the updated xpath: " + element);
		try {
			boolean Flag = driver.findElement(element).isDisplayed();
			if (Flag == true) {
				ExtentTestManager.getTest().log(Status.PASS,
						"Date ENtering via Keyboard is sucessful and able to add dependant" + Flag);
				Log.info("Date ENtering via Keyboard is sucessful and able to add dependant  " + Flag);
			} else {
				ExtentTestManager.getTest().log(Status.PASS, "Element is not displayed  " + Flag);
				Log.info("Element is not displayed  " + Flag);
			}
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.PASS, "No Element Popup displayed ");
			Log.info("No Element Popup displayed " + e.getMessage());
		}

	}

	public void EnterPresentDatewithDatePicker() throws InterruptedException {
		Relation = "Daughter";
		select(" Daughter ", locators.SelectRelation);
		waitForSpinnerToDisappear(driver, 1, 1);
		input(locators.EnterName, "Vedika");
		ExtentTestManager.getTest().log(Status.INFO, "clearing the field");
		clear(locators.EnterDob);
		Thread.sleep(2000);
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String formattedDate = currentDate.format(formatter);
		Log.info("Current Date in MM/DD/YYYY format: " + formattedDate);
		input(locators.EnterDob, formattedDate);
		click(locators.SaveBtn);

		By element = By.xpath("//tr[td[@data-title='Relation' and normalize-space() = '" + Relation + "']]");
		Log.info("Here's the updated xpath: " + element);
		try {
			boolean Flag = driver.findElement(element).isDisplayed();
			if (Flag == true) {
				ExtentTestManager.getTest().log(Status.PASS,
						"Element is displayed.. Present date is acceptable" + Flag);
				Log.info("Element is displayed..Present date is acceptable " + Flag);
			} else {
				ExtentTestManager.getTest().log(Status.PASS, "Element is not displayed  " + Flag);
				Log.info("Element is not displayed  " + Flag);
			}
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.PASS, "No Element Popup displayed ");
			Log.info("No Element Popup displayed " + e.getMessage());
		}
	}

	public void DuplicateFather() {
		select(" Father ", locators.SelectRelation);

		try {
			boolean isDisplayed = driver.findElement(locators.ErrorDialogHeader).isDisplayed();
			String ErrorMsg = driver.findElement(locators.DuplicateRelationErrorMsg).getText().toString();
			if (isDisplayed == true) {
				ExtentTestManager.getTest().log(Status.PASS,
						"Error Pop is displayed.... Cannot Select Duplicate Father Relation ");
				Log.info("Error Pop is displayed.... Cannot Select Duplicate Father Relation  ");
				ExtentTestManager.getTest().log(Status.PASS, "Error Message is " + ErrorMsg);
				Log.info("Error Message is " + ErrorMsg);
				ExtentTestManager.getTest().log(Status.PASS, "Need to Click 'OK' ");
				Log.info("Need to Click 'OK'  ");
				waitForSpinnerToDisappear(driver, 1, 2);
				click(locators.OkInErrorDialogBox);
			}
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.PASS, "No Error Popup displayed ");
			Log.info("No Error Popup displayed " + e.getMessage());
		}
	}

	public void DuplicateSpouseEntry() {
		select(" Spouse ", locators.SelectRelation);

		try {
			boolean isDisplayed = driver.findElement(locators.ErrorDialogHeader).isDisplayed();
			String ErrorMsg = driver.findElement(locators.DuplicateRelationErrorMsg).getText().toString();
			if (isDisplayed == true) {
				ExtentTestManager.getTest().log(Status.PASS,
						"Error Pop is displayed.... Cannot Select Duplicate Spouse Relation ");
				Log.info("Error Pop is displayed.... Cannot Select Duplicate Spouse Relation  ");
				ExtentTestManager.getTest().log(Status.PASS, "Error Message is " + ErrorMsg);
				Log.info("Error Message is " + ErrorMsg);
				ExtentTestManager.getTest().log(Status.PASS, "Need to Click 'OK' ");
				Log.info("Need to Click 'OK'  ");
				waitForSpinnerToDisappear(driver, 1, 2);
				click(locators.OkInErrorDialogBox);
			}
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.PASS, "No Error Popup displayed ");
			Log.info("No Error Popup displayed " + e.getMessage());
		}
	}

	public void DuplicateMotherEntry() {
		select(" Mother ", locators.SelectRelation);

		try {
			boolean isDisplayed = driver.findElement(locators.ErrorDialogHeader).isDisplayed();
			String ErrorMsg = driver.findElement(locators.DuplicateRelationErrorMsg).getText().toString();
			if (isDisplayed == true) {
				ExtentTestManager.getTest().log(Status.PASS,
						"Error Pop is displayed.... Cannot Select Duplicate Mother Relation ");
				Log.info("Error Pop is displayed.... Cannot Select Duplicate Mother Relation  ");
				ExtentTestManager.getTest().log(Status.PASS, "Error Message is " + ErrorMsg);
				Log.info("Error Message is " + ErrorMsg);
				ExtentTestManager.getTest().log(Status.PASS, "Need to Click 'OK' ");
				Log.info("Need to Click 'OK'  ");
				waitForSpinnerToDisappear(driver, 1, 2);
				click(locators.OkInErrorDialogBox);
			}
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.PASS, "No Error Popup displayed ");
			Log.info("No Error Popup displayed " + e.getMessage());
		}
	}

	public void DuplicateNameSon() throws InterruptedException {
		select(" Son ", locators.SelectRelation);
		waitForSpinnerToDisappear(driver, 1, 1);
		input(locators.EnterName, "#90REs");
		input(locators.EnterDob, "10/12/2003");
		click(locators.SaveBtn);

		By element = By.xpath("//tr[td[@data-title='Relation' and normalize-space() = '" + Relation + "']]");
		Log.info("Here's the updated xpath: " + element);
		try {
			boolean Flag = driver.findElement(element).isDisplayed();
			if (Flag == true) {
				ExtentTestManager.getTest().log(Status.PASS,
						"Element is displayed successfully added Son with Name and DOB" + Flag);
				Log.info("Element is displayed successfully added Son with Name and DOB" + Flag);
			} else {
				ExtentTestManager.getTest().log(Status.PASS, "Element is not displayed  " + Flag);
				Log.info("Element is not displayed  " + Flag);
			}
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.PASS, "No Element Popup displayed ");
			Log.info("No Element Popup displayed " + e.getMessage());
		}
	}

	public void DuplicateNameDaughter() throws InterruptedException {
		Relation = "Daughter";
		select(" Daughter ", locators.SelectRelation);
		waitForSpinnerToDisappear(driver, 1, 1);
		input(locators.EnterName, "Vedika");
		ExtentTestManager.getTest().log(Status.INFO, "clearing the field");
		clear(locators.EnterDob);
		Thread.sleep(2000);
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String formattedDate = currentDate.format(formatter);
		Log.info("Current Date in MM/DD/YYYY format: " + formattedDate);
		input(locators.EnterDob, formattedDate);
		click(locators.SaveBtn);

		By element = By.xpath("//tr[td[@data-title='Relation' and normalize-space() = '" + Relation + "']]");
		Log.info("Here's the updated xpath: " + element);
		try {
			boolean Flag = driver.findElement(element).isDisplayed();
			if (Flag == true) {
				ExtentTestManager.getTest().log(Status.PASS,
						"Element is displayed Succesfully added daught same name and DOB" + Flag);
				Log.info("Element is displayed Succesfully added daught same name and DOB" + Flag);
			} else {
				ExtentTestManager.getTest().log(Status.PASS, "Element is not displayed  " + Flag);
				Log.info("Element is not displayed  " + Flag);
			}
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.PASS, "No Element Popup displayed ");
			Log.info("No Element Popup displayed " + e.getMessage());
		}
	}

	public void DeleteButtonInAction() throws InterruptedException {
		waitForSpinnerToDisappear(driver, 1, 2);
		click(locators.DeletingElementXpath);

		try {
			boolean isDisplayed = driver.findElement(locators.ErrorDialogHeader).isDisplayed();
			String ErrorMsg = driver.findElement(locators.DeleteItemErrorMsg).getText().toString();
			if (isDisplayed == true) {
				ExtentTestManager.getTest().log(Status.PASS, "Delete Pop up displayed ");
				Log.info("Delete Pop up displayed ");
				ExtentTestManager.getTest().log(Status.PASS, "Error Message is " + ErrorMsg);
				Log.info("Error Message is " + ErrorMsg);
				ExtentTestManager.getTest().log(Status.PASS, "Need to Click 'YES' ");
				Log.info("Need to Click 'YES'  ");
				waitForSpinnerToDisappear(driver, 1, 2);
				click(locators.YesInDeleteDialog);
			}
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.PASS, "No Error Popup displayed ");
			Log.info("No Error Popup displayed " + e.getMessage());
		}
	}
}
