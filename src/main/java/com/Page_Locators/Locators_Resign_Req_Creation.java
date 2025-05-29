package com.Page_Locators;

import org.openqa.selenium.By;

public class Locators_Resign_Req_Creation {

	public By NavigationBar = By.xpath("//div[@class='sidebar-left rtl-ps-none open ps']");
	public By Home = By.xpath("//span[normalize-space()='Home']");
	public By Dashboard = By.xpath("//a[normalize-space()='Dashboard']");
	public By SelfService = By.xpath("//span[normalize-space()='Self Service']");
	public By SelfServicExpanded = By.xpath("//div[@class='sidebar-left-secondary rtl-ps-none ps open']");
	public By OrganizationalTree = By.xpath("//span[normalize-space()='Organization Tree']");
	public By MyPage = By.xpath("//span[normalize-space()='My Page']");
	public By Request = By.xpath("//span[normalize-space()='Requests']");
	public By RequestExpanded = By
			.xpath("//li[@class='nav-item ng-star-inserted open']//div[@class='ng-star-inserted']");
	public By EmpVehicle = By.xpath("//span[normalize-space()='Vehicle Request']");
	public By EmpTransfer = By.xpath("//span[normalize-space()='Employee Initiated Transfer']");
	public By EmpSeparation = By.xpath("//span[normalize-space()='Employee Initiated Separation']");
	public By EmpSeparationHeader = By.xpath("//li[contains(text(),'Employee Initiated Separation')]");
	public By closeBtn = By.xpath("//button[contains(normalize-space(),'×')]");
	public By ExitTypeLabel = By.xpath("//label[normalize-space()='Exit Type']");
	public By SelectExitType = By.xpath("//select[@id='exitType']");
	public By RequestDateLabel = By.xpath("//label[normalize-space()='Request Date:']");
	public By InputRequestDate = By.xpath("//input[@id='RequestDate']");
	public By PreferredDateLabel = By.xpath("//label[normalize-space()='Preferred Relieving Date:']");
	public By InputPreferedDate = By.xpath("//input[@id='PreferredDate']");
	public By DatePickerPreferredDate = By.xpath("(//button[@aria-label='Open calendar'])[2]");
	public By CalenderPopup = By.xpath("//div[1]/mat-datepicker-content[1]/mat-calendar[1]");
	public By ChoseDate = By.xpath("//button[@aria-label='Choose month and year']");
	public By Pastyear = By.xpath("//div[normalize-space()='2016']");
	public By PastMon = By.xpath("//div[normalize-space()='FEB']");
	public By PastDate = By.xpath("//div[normalize-space()='9']");
	public By PastDateError = By.xpath("//div[@class='eform-validation ng-star-inserted']");
	public By Futureyear = By.xpath("//div[normalize-space()='2026']");
	public By FutureMon = By.xpath("//div[normalize-space()='DEC']");
	public By FutureDate = By.xpath("//div[normalize-space()='18']");
	public By InvalidDateError = By.xpath("//div[normalize-space()='Preferred relieving date is required.']");
	public By ActualRelievingDateLabel = By.xpath("//label[normalize-space()='Notice Period Relieving Date:']");
	public By InputActualRelievingDate = By.xpath("//input[@id='ActualRelievingDate']");
	public By ReasonsLabel = By.xpath("//label[normalize-space()='Reasons']");
	public By ReasonsDropDown = By.xpath("//span[@class='dropdown-btn']");
	public By SearchBoxReason = By.xpath("//input[@aria-label='multiselect-search']");
	public By SelectOption1 = By.xpath("//div[normalize-space()='Career Advancement']");
	public By SelectOption2 = By.xpath("//div[normalize-space()='Medical Reasons']");
	public By SelectOption3 = By.xpath("//div[normalize-space()='Rate of Pay']");
	public By paySearch = By.xpath("(//div[normalize-space()='Rate of Pay'])[2]");
	public By SelectOption4 = By.xpath("//div[normalize-space()='Type of work']");
	public By CommentsLabel = By.xpath("//label[normalize-space()='Comments']");
	public By CommentTextArea = By.xpath("//textarea[@id='Comments']");
	public By ErrorInComment = By.xpath("//div[normalize-space()='Comments is required.']");
	public By Savebtn = By.xpath("//button[normalize-space()='Save']");
	public By SubmitBtn = By.xpath("//button[normalize-space()='Submit']");
	public By YesInSubmit = By.xpath("//button[normalize-space()='Yes']");
	public By OkForSubmit = By.xpath("//button[normalize-space()='Ok']");
	public By ApproverDeatilsHeader = By.xpath("//h5[normalize-space()='Approver Details']");
	public By ManagerName = By
			.xpath("//tr[td[@data-title='Approval Level' and text()='1'] ]//td[@data-title='Approver Name']");
	public By ScrollTillTravel = By.xpath("//span[normalize-space()='Travel']");
	public By EmpTab = By.xpath("//span[contains(@class,'nav-text') and normalize-space()='Employee']");
	public By ApprovalTab = By.xpath("//span[contains(@class ,'item-name') and normalize-space()='Approvals']");
	public By EmpResignTab = By.xpath("//a[@href='#/employee/empexitapprovallist']");
	public By SearchIconClick = By.xpath("(//button[@id='dLabel' and @data-toggle='dropdown'])[1]");
	public By AddSearchCriteriaBtn = By.xpath("//button[normalize-space()='Add Another Search Criteria']");
	public By SearchColumn = By.xpath("//select[@id='SearchColumn']");
	public By SearchType = By.xpath("//select[@id='SearchType']");
	public By SearchValue = By.xpath("//input[@id='SearchValue']");
	public By searchBtnInDialog = By.xpath("//div[@class='modal-footer']//button[@id='dLabel']");
}
