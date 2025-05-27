package com.Locators_PreBoardingUS;

import org.openqa.selenium.By;

public class Locators_CandidateEmailApprovalPage {
	
	public By candidateEmailApprovalPageHeader = By.xpath("//li[normalize-space()='Candidate Email Approval']");
	
	public By searchIcon = By.xpath("//div[@class='dropdown pull-left']//button[@id='dLabel']");
	public By searchDialogueBox = By.xpath("//h4[normalize-space()='Search']");
	public By searchColumnInSearchDialogueBox = By.xpath("//select[@id='SearchColumn']");
	public By searchTypeInSearchDialogueBox = By.xpath("//select[@id='SearchType']");
	public By searchValueInSearchDialogueBox = By.xpath("//input[@id='SearchValue']");
	public By searchBtn = By.xpath("//div[@class='modal-footer']//button[@id='dLabel']");
	
	public By searchedCandidateName = By.xpath("//tbody/tr/td[1]");
	public By emailApprovalForm = By.xpath("//h3[normalize-space()='Email Approval']");
	
	//fields
	public By firstName = By.xpath("//input[@id='FirstName']");
	public By middleName = By.xpath("//input[@id='MiddleName']");
	public By lastName = By.xpath("//input[@id='LastName']");
	public By preferredName = By.xpath("//input[@id='NickName']");
	public By email = By.xpath("//input[@id='Email']");
	public By reportingManager = By.xpath("//input[@id='ReportingManager']");
	public By designation = By.xpath("//input[@id='DesignationName']");
	public By businessUnit = By.xpath("//input[@id='BusinessUnitSearch']");
	public By division = By.xpath("//input[@id='DivisionName']");
	public By technology = By.xpath("//input[@id='TechnologyName']");
	public By department = By.xpath("//input[@id='ProjectDepartment']");
	public By dateOfJoining = By.xpath("//input[@name='DateOfJoining']");
	public By specialAccessNeeded = By.xpath("//input[@id='SpecialAccess']");
	public By trainingRequired = By.xpath("//textarea[@id='TrainingRequired']");
	public By additionalTraining = By.xpath("//input[@id='AdditionalTraining']");
	public By jobCountry = By.xpath("//select[@id='JobCountry']");
	public By jobZipCode = By.xpath("//input[@id='JobZipCode']");
	public By jobCityText = By.xpath("//input[@id='JobCityText']");
	public By jobStateText = By.xpath("//input[@id='JobStateText']");
	public By suggestedCompanyEmail = By.xpath("//input[@id='CompanyEmail']");
	public By suggestedCompanyUserName  = By.xpath("//input[@id='UserName']");
	
	public By confirmEmailBtn = By.xpath("//button[normalize-space()='Confirm Email']");
	
	
	public By LaptopRequired_Yes = By.xpath("//label[normalize-space()='Laptop Required']/following-sibling::div/label[1]/input");
	public By BackgroundCheckRequired_Yes = By.xpath("//label[normalize-space()='Background Check Required']/following-sibling::div/label[1]/input");

	public By approvedCompanyEmail = By.xpath("//input[@id='ConfCompanyEmail']");
	public By approvedUserName = By.xpath("//input[@id='ConfUserName']");
	public By temporaryPassword = By.xpath("//input[@id='TempPasswd']");
	public By webmailUrl = By.xpath("//input[@id='Webmail']");
	
//	validation msg

	public By approvedCompanyEmailValidationMsg = By.xpath("(//label[normalize-space()='Company Email'])[2]/following-sibling::div");
	public By approvedUserNameValidationMsg = By.xpath("(//label[normalize-space()='User Name'])[2]/following-sibling::div");
	public By temporaryPasswordValidationMsg = By.xpath("//label[normalize-space()='Temporary Password']/following-sibling::div");
	public By webmailUrlValidationMsg = By.xpath("//label[normalize-space()='Webmail url']/following-sibling::div");
	
	public By MailDetailsConfirmed_OkBtn = By.xpath("//button[text()='Ok']");

}