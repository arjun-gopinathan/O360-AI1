package com.Page_Locators;

import org.openqa.selenium.By;

public class Locators_Approve_Process {

	public By PopupDisplayedCovid = By.xpath("//div/button[1][text()=' Remind Me Later']");
	public By OkBtnCovid = By.xpath("//div/button[1][text()=' Remind Me Later']");
	public By PopupDisplayedDesktop = By.xpath("//*[@id=\"modal-basic-title\" and text()=' Desktop Notifications ']");
	public By dashBoard = By.xpath("//a[normalize-space()='Dashboard']");
	public By OkBtnDesktop = By.xpath("//div/button[2][text()='OK']");
	public By QuickApHead = By.xpath("//span[normalize-space()='Approvals Pending']");
	public By QuickApprove = By.xpath("//i[@title='Quick Approvals']");
	public By profileApproval = By.xpath("//li/a[contains(.,'Profile Approval')]");
	public By ProfileApHead = By.xpath("//a[normalize-space()='Profile Edit Approvals']");
	public By SearchBtn = By.id("dLabel");
	public By closeBtn = By.xpath("//button[contains(normalize-space(),'×')]");
	public By EmpNameLabel = By.xpath("//span[normalize-space()='Employee Name']");
	public By ReportingToLabel = By.xpath("//span[normalize-space()='Reporting To']");
	public By OfficeLabel = By.xpath("//span[normalize-space()='Office']");
	public By DepartmentLabel = By.xpath("//span[normalize-space()='Department']");
	public By DesignationLabel = By.xpath("//span[normalize-space()='Designation']");
	public By RequestedDate = By.xpath("//span[normalize-space()='Requested Date']");
	public By RequestedBy = By.xpath("//span[normalize-space()='Requested By']");
	public By PendingWithAction = By.xpath("//span[normalize-space()='Action Pending With']");
	public By ActionPendingUserGroup = By.xpath("//span[normalize-space()='Action Pending User Group']");
	public By TotalNoItem = By.xpath("//b[contains(.,'Total Items :')]");
	public By Pagination = By.xpath("//li[@class='current ng-star-inserted']");
	public By EmpNamePage = By.xpath("//a[normalize-space()='Approval']");
	public By SearchIcon = By.xpath("//button[@id='dLabel']");
	public By SearchColumnDropDown = By.id("SearchColumn");
	public By SearchTypeDropDown = By.id("SearchType");
	public By SearchValueTextField = By.id("SearchValue");
	public By SearchBtnInDialog = By.xpath("//div[@class='modal-footer']//button[@id='dLabel']");
	public By CancelBtnInDialog = By.xpath("//button[normalize-space()='Cancel']");
	public By SelectSearchCol = By.xpath("//*[@id='SearchColumn']/option[5]");
	public By SelectSearchType = By.xpath("//*[@id='SearchType']/option[3]");
	public By TypeSearchValue = By.xpath("//*[@id=\"SearchValue\"]");
	public By ResultEmpName = By.xpath("(//span[@class='link ng-star-inserted'])[1]");
	// xpaths for approval list page
	public By EmployeeDetails = By.xpath("//div[@class='employee-detail']");
	public By closeBtnEmp = By.xpath("//button[contains(text(),'×')]");
	public By FooterCard = By.xpath("//div[contains(@class,'footer-btn-holder card mt-')]//div[@class='card-body']");
	public By VisibleElement = By.xpath("//div[@id='btnstyle1']");
	public By ApproveBtn = By.xpath("(//button[normalize-space()='Approve'])[1]");
	public By RejectBtn = By.xpath("//button[normalize-space()='Reject']");
	public By CloseBtnApp = By
			.xpath("(//button[@class='btn btn-primary btn-rounded m-1'][normalize-space()='Close'])[1]");
	public By ApproveBtnInDialog = By.xpath("(//button[text()='Approve'])[2]");
	public By CommentCLick = By.xpath("//textarea[@class='ng-untouched ng-pristine ng-valid']");
	public By RejectCommentBox = By.xpath("//label[text()='Reason']/following-sibling::div[@class='row']//textarea");
	public By RejectBtnInDialog = By.xpath("(//button[normalize-space()='Reject'])[2]");
}
//select[@id='SearchType']