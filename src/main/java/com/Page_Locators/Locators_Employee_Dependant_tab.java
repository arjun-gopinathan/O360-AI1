package com.Page_Locators;

import org.openqa.selenium.By;

import com.BasePackage.Base_Class;

public class Locators_Employee_Dependant_tab extends Base_Class {
	public By NavigationBar = By.xpath("//div[@class='sidebar-left rtl-ps-none open ps']");
	// In Case of approval pages
	public By ScrollTillTravel = By.xpath("//span[normalize-space()='Travel']");
	public By ClickOnProfileDd = By.xpath("//*[@id=\"userDropdown\"]/h4");
	public By ClickOnProfileLink = By
			.xpath("//button[contains(@class,'dropdown-item') and contains(text(),'Profile')]");
	public By DependantTab = By.xpath("//div[contains(text(),'Dependent Details')]");
	public By DependantNameHeadInTable = By.xpath("//th[text()='Dependent Name']");
	public By RelationHead = By.xpath("//div[@class = 'form-group']/label[text()='Relation']");
	public By NameHead = By.xpath("(//div[@class = 'form-group']/label[text()='Name'])[1]");
	public By DOBHead = By.xpath("//div[@class = 'form-group']/label[text()='Date Of Birth']");
	public By SaveBtn = By.xpath("//div[@class = 'form-group']/button[text()=' Save']");
	public By CloseBtn = By.xpath("//button[@type='button' and contains(@class, 'close-window')]");
	public By DOBHeadInTable = By.xpath("//th[text()='Date of Birth']");
	public By RelationHeaderInTable = By.xpath("//th[text()='Relation']");
	public By StatusHeaderInTable = By.xpath("//th[text()='Status']");
	public By ActionHeaderInTable = By.xpath("//th[text()='Action']");
	public By DashBoardHeader = By.xpath("//a[normalize-space()='Dashboard']");
	public By SelectRelation = By.xpath("//select[@id='Relation']");
	public By EnterName = By.xpath("//input[@id='DependentName']");
	public By EnterDob = By.xpath("//input[@id='DOB']");
	public By DatePicker = By.xpath("(//button[@aria-label='Open calendar'])");
	public By CalenderPopup = By.xpath("//mat-calendar[contains(@id,'mat-datepicker')]");
	public By ErrorDialogHeader = By.xpath("//h4[normalize-space()='Dependent Details']");
	public By ErrorMsgInDialog = By.xpath("//span[contains(text(),'Please fill dependent details')]");
	public By OkInErrorDialogBox = By.xpath("//button[text()='Ok']");
	public By ChoseDate = By.xpath("//button[@aria-label='Choose month and year']");
	public By Futureyear = By.xpath("//div[normalize-space()='2026']");
	public By FutureMon = By.xpath("//div[normalize-space()='DEC']");
	public By FutureDate = By.xpath("//div[normalize-space()='26']");
	public By FutureDateErrorMsg = By.xpath("//span[contains(text(),'DOB can not be a future Date.')]");
	public By DuplicateRelationErrorMsg = By.xpath("//span[normalize-space()='Relation Data already exists.']");
	public By DeletingElementXpath = By.xpath(
			"(//td[@data-title='Relation' and text()='Daughter']/following-sibling::td[contains(@class,'action-btn')]/a)[1]");
	public By DeleteItemErrorMsg = By
			.xpath("//span[normalize-space()='Are you sure you want to delete this document']");
	public By YesInDeleteDialog = By.xpath("//button[normalize-space()='Yes']");

}
