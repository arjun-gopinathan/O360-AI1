package com.Page_Repositary;

import org.openqa.selenium.By;

public class PageRepositary_LeaveModule 
{
	public By LeaveSection= By.xpath("//span[text()='Leave']/parent::div");
	public By myLeaveSection=By.xpath("//span[text()='Leave']/parent::a");
	public By clickOnLeaveRequest= By.xpath("//span[text()='Leave Requests ']");
	public By GeneralRadioButton= By.xpath("(//div[@class='mat-radio-inner-circle'])[1]");
	public By selectFromDate= By.xpath("(//button[@aria-label='Open calendar'])[1]");
	public By selectMonthandYear= By.xpath("//div[@class='mat-calendar-arrow']/parent::span");
	public By leaveReson= By.xpath("//textarea[@id='LeaveReason']");
	public By selectEmployees= By.xpath("//span[text()='Select Employees']");
	public By searchEmployee= By.xpath("//li[@class='filter-textbox ng-star-inserted']");
	public By selectEmp= By.xpath("//li[@class='multiselect-item-checkbox ng-star-inserted']/child::div");

	public By SubmitButton= By.xpath("//button[text()='Submit']");
	public By clearButton= By.xpath("//button[text()='Clear']");
	public By clickOnDashboard= By.xpath("//span[text()='Dashboard ']");
	public By clickOnDuration= By.xpath("//div[@class='mat-select-arrow-wrapper']");
	public By selectToDate= By.xpath("(//button[@aria-label='Open calendar'])[2]");
	public By selectFile= By.xpath("//input[@id='fileInput']");
	public By clickOnOkButton= By.xpath("//button[text()='Ok']");

	public By DesktopNot = By.xpath("//button[text()='OK']");
	public By SamePeriod = By.xpath("//span[text()='You have already applied for a leave during the same period. ']");
	public By SamePeriodOk = By.xpath("//button[text()='Ok']");
	public By WeekendAndHoliday = By.xpath("(//div[@class='eform-validation errormsgmargin mb-2 ng-star-inserted'])[1]");
	public By floatingPeriodOk = By.xpath("//button[text()='Ok']");
	public By floatingPeriod = By.xpath("//span[text()='Floating Holidays should be applied before 7 days  ']");
	public By clickOnStatement = By.xpath("//div[text()='Statement ']");
	public By clickOnDD = By.xpath("//mat-select[@id='reportleavetype']");
	public By selectDDforStatement = By.xpath("//span[text()=' Casual Leave ']");
	public By clickOnApply = By.xpath("//button[text()='Apply']");
	public By ValidateField1 = By.xpath("//div[text()='Opening Balance']");
	public By ValidateField2 = By.xpath("//mat-panel-title[text()=' Availed Leaves ']");
	public By ValidateField3 = By.xpath("//mat-panel-title[text()=' Accrued Leaves ']");
	public By ValidateField4 = By.xpath("//div[text()='Closing Balance']");
	public By clickOnCloseButton = By.xpath("//button[text()='Close']");
	
	public By approvalUser = By.xpath("//span[text()='Clement Joseph ']");
	public By leaveForDayButton = By.xpath("//button[text()='Leave for the day ']");
	public By sendForReview = By.xpath("//button[text()='Send for review']");
	public By projectAllocation = By.xpath("//button[text()='Project Allocation']");
	public By approveButton = By.xpath("//i[@title='Approve']");
	public By rejectButton = By.xpath("//i[@title='Reject']");
	public By approvalsSection = By.xpath("//span[text()='Approvals']");
	public By leaveEWC = By.xpath("//span[text()='Leave/EWC ']");
	public By selectApprover = By.xpath("//select[@id='approver'][1]");
	public By sendButton = By.xpath("(//button[text()='Send'])[1]");
	
	//public By leaveEWC = By.xpath("//span[text()='Leave/EWC ']");



	//EWC
	public By EWCSection= By.xpath("//span[text()='EWC ']/parent::a");
	public By FromDate= By.xpath("(//span[@class='mat-button-wrapper'])[1]");
	public By ToDate= By.xpath("(//span[@class='mat-button-wrapper'])[2]");

	public By selectProject= By.xpath("//select[@id='ProjectId']");
	public By enterReason= By.xpath("//div[@class='form-group']/child::textarea");
	public By notifyOthers= By.xpath("(//span[@class='ng-star-inserted'])[6]");
	public By searchEmp= By.xpath("//input[@aria-label='multiselect-search']");
	public By wfhDisplayed= By.xpath("//span[text()='Work from Home']");
	public By compOffDisplayed= By.xpath("//span[text()=' Comp off Credit ']");
	public By clientHolidayDisplayed= By.xpath("//span[text()=' Client Holiday ']");
	public By clickOnArrowCalendar= By.xpath("//div[@class='mat-calendar-arrow']");
	public By cancelButton= By.xpath("//button[normalize-space()='Cancel']");
	public By submitButton= By.xpath("//button[normalize-space()='Submit']");
	public By okButton= By.xpath("//button[text()='Ok']");
	public By ewcSection= By.xpath("//span[@class='ng-star-inserted'][normalize-space()='EWC']");
	public By approvebutton= By.xpath("//i[@title='Approve']/parent::button");
	public By rejectbutton= By.xpath("//i[@title='Reject']/parent::button");
	public By sendForReview1= By.xpath("//button[normalize-space()='Send for review']");
	public By prjectAllocation1= By.xpath("//button[normalize-space()='Project Allocation']");
	public By enterRejectComments= By.xpath("//div[@class='dialog leave-approval-modal send-for-review commentbox']//textarea[@id='RejectComments']");
	public By send= By.xpath("//div[@class='dialog leave-approval-modal send-for-review commentbox']//textarea[@id='ApproverComments']/../div/button");
	public By sendButton1= By.xpath("(//button[text()='Send']/parent::div)[3]");
	public By enterApproveComments= By.xpath("//div[@class='dialog leave-approval-modal send-for-review commentbox']//textarea[@id='ApproverComments']");
	public By ApprovalsSection= By.xpath("//span[normalize-space()='Approvals']");
	public By EWCApprovalSection= By.xpath("//a[@href='#/leave/leaveapprovals']");
	public By approverSelection= By.xpath("(//select[@name='approver' and @id='approver'])[2]");
	public By sendForReview2= By.xpath("(//button[text()='Send'])[5]");
	public By overlay= By.xpath("(//div[@class='overlay'])[7]");
	public By leaveType= By.xpath("//select[@name='LeaveTypeId']");
	public By leaveRejectComments= By.xpath("(//textarea[@id='RejectComments'])[1]");

	public By CancelLeave= By.xpath("(//img[@title='Cancel Leave'])[1]");
	public By EnterComments= By.xpath("//textarea[@id='Comments']");
	public By SendButton= By.xpath("//button[text()='Send cancellation']");
	public By sendButton2= By.xpath("(//button[text()='Send']/parent::div)[2]");
	public By CancelLeaveBtn= By.xpath("//button[normalize-space()='Cancel Leave']");
	
	
	

			

			
	
	
	
	
	
	
	
	
	
	//option[text()=' A Aare ']
			
			
	//div[text()='22']
	
	//div[text()='2024']
	//div[text()='OCT']
	
	//span[text()=' Afternoon ']  //span[text()=" Forenoon "]//span[text()=" Full Day "]

	

}
