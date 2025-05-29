//Pagelocator resign approval 

package com.Page_Locators;

import org.openqa.selenium.By;

public class Locators_Resign_Req_Approval {
	public By QuickApHead = By.xpath("//span[normalize-space()='Approvals Pending']");
	public By QuickApprove = By.xpath("//i[@title='Quick Approvals']");
	public By EmpSeparationApproval = By.xpath("//a[text()='Employee Separation']");
	public By EmpSepHeader = By.xpath("//li[normalize-space()='Employee Exit for Approval']");
	public By RequestApprovalHeader = By.xpath("//li[normalize-space()='Employee Exit Request']");
	public By SearchBtn = By.id("dLabel");
	public By closeBtn = By.xpath("//button[contains(normalize-space(),'×')]");
	public By ApprovalBtn = By.xpath("//button[normalize-space()='Approval']");
	public By OverRideBtn = By.xpath("//button[normalize-space()='Override']");
	public By Table = By.xpath("//div[@class='table-wrap']");
	public By CodeLable = By.xpath("(//span[normalize-space()='Code'])");
	public By EmployeeLable = By.xpath("//th[contains(@class,'ng-star-inserted' )]//span[contains(text(),'Employee')]");
	public By RequestDateLable = By.xpath("//span[normalize-space()='Request Date']");
	public By LastWorkingDayLable = By.xpath("//span[normalize-space()='LastWorkingDate']");
	public By OfficeLocationLable = By.xpath("//span[normalize-space()='Office Location']");
	public By StatusLable = By.xpath("//span[normalize-space()='Status']");
	public By PlannedRelievingLable = By.xpath("//span[normalize-space()='Planned Relieving Date']");
	public By PreferredRelievingLable = By.xpath("//span[contains(text(),'Preferred Relieving Date')]");
	public By SearchIconClick = By.xpath("(//button[@id='dLabel' and @data-toggle='dropdown'])[1]");
	public By AddSearchCriteriaBtn = By
			.xpath("//div/button[contains(normalize-space(),'Add Another Search Criteria')]");
	public By TotalNoItem = By.xpath("//b[contains(.,'Total Items :')]");
	public By SelectDropDown = By.xpath("//select[@id='IsActive']");
	public By DOwnloadBtn = By.xpath("//i[@class='i-Download']");
	public By ExcelFile = By.xpath("//option[@value='0: 0']");
	public By CssFile = By.xpath("//option[@value='1: 1']");
	public By Pagination = By.xpath("//li[@class='current ng-star-inserted']");
	public By SearchColumn = By.xpath("//select[@id='SearchColumn']");
	public By SearchType = By.xpath("//select[@id='SearchType']");
	public By SearchValue = By.xpath("//input[@id='SearchValue']");
	public By searchBtnInDialog = By.xpath("//div[@class='modal-footer']//button[@id='dLabel']");
	public By cancelBtnInDialog = By.xpath("//button[normalize-space()='Cancel']");
	public By ResignationApproval = By.xpath("//a[contains(.,'Employee Separation')]");
	public By EmployeeNameLabel = By.xpath("//label[normalize-space()='Employee Name']");
	public By EmployeeNameInput = By.xpath("//input[@id='EmployeeFullName']");
	public By DepartmentLabel = By.xpath("//label[normalize-space()='Department']");
	public By DepartmentInput = By.xpath("//input[@id='DepartmentName']");
	public By DesignationLabel = By.xpath("//label[normalize-space()='Designation']");
	public By DesignationInput = By.xpath("//input[@id='DesignationName']");
	public By ExitType = By.xpath("//label[normalize-space()='Exit Type']");
	public By ExitInput = By.xpath("//input[@id='EmployeeExitTypeName']");
	public By RequestDateLabel1 = By.xpath("//label[normalize-space()='Exit Type']");
	public By RequestDateInput = By.xpath("//input[@id='AppliedDate']");
	public By PreferredDateLabel1 = By.xpath("//label[normalize-space()='Preferred Date:']");
	public By PreferredDateInput = By.xpath("//input[@id='PreferredDate']");
	public By PlannedRelievingDateLable1 = By.xpath("//label[normalize-space()='Planned Relieving Date:']");
	public By PlannedRelievingDateInput = By.xpath("//input[@id='ActualRelievingDate']");
	public By LastWorkingDateLable = By.xpath("//label[normalize-space()='Last Working Date:']");
	public By LastWorkingDateInput = By.xpath("//input[@id='ActualRelievingDate']");
	public By CommentLable = By.xpath("(//label[contains(text(),'Comments:')])[1]");
	public By CommentTextArea = By.xpath("//textarea[@id='Comments']");
	public By ReasonLable = By.xpath("//label[normalize-space()='Reasons:']");
	public By UploadDoc = By.xpath("//label[normalize-space()='Upload Document']");
	public By ForwardEmailReq = By.xpath("//label[normalize-space()='Forward Email Required?']");
	public By EmailBackupReq = By.xpath("//label[normalize-space()='Email Backup Required?']");
	public By DataBackupReq = By.xpath("//label[normalize-space()='Data Backup Required?']");
	public By ApproverName = By.xpath("//th[normalize-space()='Approver Name']");
	public By ApprovalLevel = By.xpath("//th[normalize-space()='Approval Level']");
	public By ApprovalStatus = By.xpath("//th[normalize-space()='Approval Status']");
	public By ApprovalComment = By.xpath("//th[normalize-space()='Approval Comments']");
	public By Manager = By.xpath("//th[normalize-space()='Managers']");
	public By ManagerTabLastworking = By.xpath("//th[normalize-space()='Managers']");
	public By ManagerTabComment = By.xpath("//th[normalize-space()='Comments']");
	public By Replacement = By.xpath("//th[normalize-space()='Replacement']");
	public By ViewDependencies = By.xpath("//button[normalize-space()='View Dependencies']");
	public By HRClearance = By.xpath("//button[normalize-space()='HR Exit Clearance']");
	public By SaveBtn = By.xpath("//button[normalize-space()='Save']");
	public By RequestApprovalComment = By.xpath("(//label[contains(text(),'Comments:')])[2]");
	public By RejectBtn = By.xpath("//button[text()='Reject']");
	public By WithdrawBtn = By.xpath("//button[text()='Withdraw']");
	public By ApproveBtn = By.xpath("//button[text()='Approve']");
	public By ScrollTillViewDep = By.xpath("//button[text()='Reject']");
	public By Yes = By.xpath("//button[text()='Yes']");
	public By Ok = By.xpath("//button[text()='Ok']");
	public By SelfService = By.xpath("//span[normalize-space()='Self Service']");
	public By Request = By.xpath("//span[normalize-space()='Requests']");
	public By EmpSeparationRequest = By.xpath("//span[normalize-space()='Employee Initiated Separation']");
	public By ManagerName = By
			.xpath("//tr[td[@data-title='Approval Level' and text()='1'] ]//td[@data-title='Approver Name']");
	public By HR1Name = By
			.xpath("//tr[td[@data-title='Approval Level' and text()='2'] ]//td[@data-title='Approver Name']");
	public By HR2Name = By
			.xpath("//tr[td[@data-title='Approval Level' and text()='3'] ]//td[@data-title='Approver Name']");
	public By ScrollTillTravel = By.xpath("//span[normalize-space()='Travel']");
	public By EmpTabMain = By.xpath("//span[contains(@class,'nav-text') and normalize-space()='Employee']");
	public By EmployeeTab = By.xpath("//span[@class='item-name'][normalize-space()='Employee']");
	public By ActiveEmp = By.xpath("//a[@href='#/employee/employees']//span[@class='item-name lvl1']");
	public By ApprovalTab = By.xpath("//span[contains(@class ,'item-name') and normalize-space()='Approvals']");
	public By EmpResignTab = By.xpath("//a[@href='#/employee/empexitapprovallist']");
	public By ReasonsDropDown = By.xpath("//span[@class='dropdown-btn']");
	public By CareerAdvancement = By.xpath("//div[normalize-space()='Career Advancement']");
	public By Relocation = By.xpath("//div[normalize-space()='Relocation']");
	public By Comments = By.xpath("//textarea[@id='Comments']");
	public By SubmitBtn = By.xpath("//button[normalize-space()='Submit']");
	public By YesInSubmit = By.xpath("//button[normalize-space()='Yes']");
	public By OkForSubmit = By.xpath("//button[normalize-space()='Ok']");
	public By scrollTillNoticeOn = By.xpath("//label[normalize-space()='On Notice Period?']");
	public By userNameFIeld = By.xpath("//input[@id='UserName']");
	public By ScrollTillEMp = By.xpath("//b[normalize-space()='Employment History']");
	public By CloseButton = By.xpath("//button[@class='btn btn-primary btn-rounded m-1'][normalize-space()='Close']");
	public By OkInWithdraw = By.xpath(
			"//span[contains(., 'withdrawn')]/ancestor::div[contains(@class,'dialog')]/div[@class='modal-footer']/button[text()='Ok']");
	public By OkInApprove = By.xpath(
			"//span[contains(., 'approved')]/ancestor::div[contains(@class,'dialog')]/div[@class='modal-footer']/button[text()='Ok']");
}