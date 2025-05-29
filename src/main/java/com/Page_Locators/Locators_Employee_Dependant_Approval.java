package com.Page_Locators;

import org.openqa.selenium.By;

import com.BasePackage.Base_Class;

public class Locators_Employee_Dependant_Approval extends Base_Class {

	public By NavigationBar = By.xpath("//div[@class='sidebar-left rtl-ps-none open ps']");
	public By ScrollUntilTravels = By.xpath("//span[normalize-space()='Travel']");
	public By EmployeeTabInBar = By.xpath("//span[@class='nav-text'][normalize-space()='Employee']");
	public By ApprovalsInBar = By.xpath("//span[@class='item-name'][normalize-space()='Approvals']");
	public By ScrollUntillDependant = By.xpath("//span[contains(normalize-space(),'Dependent Approvals')]");
	public By DependantApprovalTab = By.xpath("//a//span[text()='Dependent Approvals ']");
	public By DependantHeader = By.xpath("//li[text()='Employee Dependents']");
	public By CloseBtn = By.xpath("//button[normalize-space()='×']");
	public By EmployeeCode = By.xpath("//span[normalize-space()='Employee Code']");
	public By EmployeeName = By.xpath("//span[normalize-space()='Employee Name']");
	public By ReportingManager = By.xpath("//span[normalize-space()='Reporting Manger']");
	public By Office = By.xpath("//span[normalize-space()='Office']");
	public By Department = By.xpath("//span[normalize-space()='Department']");
	public By RequestedBy = By.xpath("//span[normalize-space()='Requested By']");
	public By RequestedOn = By.xpath("//span[normalize-space()='Requested On']");
	public By PendingWith = By.xpath("//span[normalize-space()='Requested On']");
	public By TotalItem = By.xpath("//b[contains(normalize-space(),'Total Items :')]");
	public By DownloadTypeDropDown = By.xpath("//select[@id='IsActive']");
	public By downloadButton = By.xpath("//i[@class='i-Download']");
	public By DashBoardHeader = By.xpath("//a[normalize-space()='Dashboard']");
	public By EmployeeNameInRequestPage = By.xpath("//label[normalize-space()='Employee Name']");
	public By EmployeeNameInputBox = By.xpath("//input[@name='EmployeeFullName']");
	public By EmployeeCodeInRequestPage = By.xpath("//label[contains(normalize-space(),'Employee Code')]");
	public By EMployeeCodeInputBox = By.xpath("//input[@name='EmployeeCode']");
	public By OfficeNameInRequestPage = By.xpath("//label[normalize-space()='Office Name']");
	public By OfficeNameINputBOx = By.xpath("//input[@name='OfficeName']");
	public By ReportingToInRequestPage = By.xpath("//label[normalize-space()='Reporting To']");
	public By ReportingToInputBox = By.xpath("//input[@name='ReportingManager']");
	public By DepartmentInRequestPage = By.xpath("//label[normalize-space()='Department Name']");
	public By DepartmentInputBox = By.xpath("//input[@name='DepartmentName']");
	public By DependantNameHeader = By.xpath("//th[normalize-space()='Dependent Name']");
	public By DOBHeader = By.xpath("//th[normalize-space()='DOB']");
	public By RelationHeader = By.xpath("//th[normalize-space()='Relation']");
	public By DependantStatusHeader = By.xpath("//th[normalize-space()='Dependent Status']");
	public By ActionHeader = By.xpath("//th[normalize-space()='Actions']");
	public By UpdateBtn = By.xpath("//button[normalize-space()='Update']");
	public By CloseBtnInRequestPage = By.xpath("//button[normalize-space()='Close']");
	public By YesBtnInDialogOnUpdate = By.xpath(
			"//div[h4[text()='Update Employee Dependents']]/following-sibling::div[@class='modal-footer']//button[text()='Yes']");
	public By OkBtnInDialogOnUpdate = By.xpath(
			"//div[h4[text()='Update Employee Dependents']]/following-sibling::div[@class='modal-footer']//button[text()='Ok']");
	public By ClickOnProfileDd = By.xpath("//*[@id=\"userDropdown\"]/h4");
	public By ClickOnProfileLink = By
			.xpath("//button[contains(@class,'dropdown-item') and contains(text(),'Profile')]");
	public By DependantTab = By.xpath("//div[contains(text(),'Dependent Details')]");
	public By DependantNameHeadInTable = By.xpath("//th[text()='Dependent Name']");
}
