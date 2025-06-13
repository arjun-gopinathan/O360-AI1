package com.Page_Repositary;

import org.openqa.selenium.By;

public class PageRepositary_ExpenseModule 
{
	public By timesheetSection= By.xpath("//span[text()='Self Service']");
	public By myExpense = By.xpath("//span[normalize-space(text()) ='My Expense']");
	public By newRequest = By.xpath("(//div[.='New Request'])[1]");
	public By approvedTab = By.xpath("(//div[.='Approved'])[1]");
	public By saved = By.xpath("(//div[.='Saved'])[1]");
	public By submitted = By.xpath("(//div[.='Submitted'])[1]");
	public By expenses = By.xpath("(//span[.='Expense'])[1]");
	
	//public By futureDateError= By.xpath("//div[text()=' Future date not allowed. ']");
	public By ExpenseDate= By.xpath("(//button[@aria-label='Open calendar'])[1]");
	public By selectMonthandYear= By.xpath("//div[@class='mat-calendar-arrow']/parent::span");
	public By year(String fromYear) { return By.xpath("//div[contains(text(),'" + fromYear + "')]"); }
	public By month(String fromMonth) { return By.xpath("//div[contains(text(),'"+fromMonth+"')]"); }
	public By date(String day) { return By.xpath("//td//div[.='"+day+"']"); }
	
	
	public By ExpenseTitle= By.xpath("//input[@id='ExpenseTitle']");
	
	public By ProjectSelection= By.xpath("//input[@id='Project']");
	public By ProjectSearch= By.xpath("//input[@name='search']");
	public By projectNameSelect(String projectName) { return By.xpath("//td[contains(normalize-space(.), '"+projectName+"')]"); }
	public By ProjectSerachOk= By.xpath("//button[text()='OK']");
	
	public By EnterDescription= By.xpath("//textarea[@id='Description']");
	public By selectProj= By.xpath("//table[@class='table']/tr/td");
	
	public By SelectCurrency= By.xpath("//select[@id='Currency']");
	public By ChooseFile= By.xpath("//input[@id='chooseFile']");
	public By BillDate= By.xpath("(//button[@aria-label='Open calendar'])[2]");
	public By ExpenseType= By.xpath("//input[@id='ExpenseType']");
	public By ExpenseSearch= By.xpath("//input[@name='search']");
	public By EnterMerchant= By.xpath("//input[@id='Merchant']");
	public By EnterCity= By.xpath("//input[@id='City']");
	public By ExpenseDescription= By.xpath("//textarea[@id='ItemDescription']");
	public By EnterAmount= By.xpath("//input[@id='Amount']");
	public By SelectStatus= By.xpath("//select[@id='ReimbursableStatus']");
	public By ExpenseChooseFile= By.xpath("//input[@id='chooseFile1']");
	public By SaveButton= By.xpath("//button[@title='Save']");
	public By AddButton= By.xpath("//i[@title='Add']");
	public By exp_expNumber = By.xpath("//input[@name='Expense Number']");
	public By exp_saveMsg = By.xpath("//span[normalize-space(.)='Expense saved successfully.']");
	
	//save session
	public By searchIcon = By.xpath("//i[@class='i-Magnifi-Glass1']/..");
	public By searchCol = By.xpath("//select[@id='SearchColumn']");
	public By searchInput = By.xpath("//input[@id='SearchValue']");
	public By searchBtn = By.xpath("//button[normalize-space(text())='Search']");
	public By expNumber = By.xpath("//td[@data-title='Expense Number']//span");
	public By submit = By.xpath("(//button[normalize-space(.)='Submit'])[1]");
	public By exp_submittMsg = By.xpath("//span[.='Expense submitted successfully.']");
	
	public By ResetButton= By.xpath("//i[@title='Reset']");
	public By ExpenseModule= By.xpath("//span[normalize-space()='My Expense']");
	public By EditButton= By.xpath("//i[@title='Edit']");
	public By EditSaveButton= By.xpath("//i[@title='Save']");
	public By lineRemove= By.xpath("//i[@title='Remove']");
	public By lineRemoveYes= By.xpath("//button[normalize-space()='Yes']");
	public By deleteButton= By.xpath("//button[normalize-space()='Delete']");
	public By deleteButtonYes= By.xpath("//button[normalize-space()='Yes']");
	public By clickOnAdd= By.xpath("//button[normalize-space()='Add New']");
	public By SubmiteButton= By.xpath("//button[@title='Submit']");
	public By closeButton= By.xpath("//button[contains(text(),'×')");
	
	
	public By ApprovalsSection= By.xpath("//span[normalize-space()='Approvals']");
	public By expensesApproval = By.xpath("//span[normalize-space(text())='Expense Approval']");
	public By toApproval = By.xpath("(//div[normalize-space(.)='To Approve'])[2]");
	public By approved = By.xpath("(//div[normalize-space(.)='Approved'])[2]");
	
	public By approveComment = By.xpath("//textarea[@name='ApproverComment']");
	public By approveBtn = By.xpath("//div[@id='btnstyle1']//button[.='Approve']");
	
	public By exp_ApproveMsg = By.xpath("//span[.='Expense approved successfully.']");
	public By exp_empNum(String expNum) {
		By xpath = By.xpath("//td[@data-title='Expense Number']//span[.='"+expNum+"']");
		return xpath;
	}
	
	
	public By RejectButton= By.xpath("//i[text()='Reject']");
	public By EnterComments= By.xpath("//textarea[@id='RejectedComment']");
	public By clickOnReject= By.xpath("//button[contains(text(),'Reject')]");
	public By RejectConfirmYes= By.xpath("//button[normalize-space()='Yes']");
	public By ApproveButton= By.xpath("//i[normalize-space()='Approve']");
	public By EnterApproveComments= By.xpath("//textarea[@name='ApproverComment']");
	public By clickOnApprove= By.xpath("//button[contains(text(),'Approve')]");
	
	public By username = By.xpath("//input[@name='Username']");
	public By password = By.xpath("//input[@name='Password']");
	public By signin = By.xpath("//button[normalize-space(.)='Sign In']");
	
	public By error = By.xpath("//div[@class='modal-footer']//button[.='Ok']");
	public By exp_successMsg = By.xpath("//span[.='Expense bill verification status saved successfully.']");
	
	public By billVerificationSubTab = By.xpath("//span[normalize-space(text())='Bill Verification']");
	public By billVerificationStatus = By.xpath("//select[@name='BillVerificationStatus']");
	public By billVerificationComment = By.xpath("//textarea[@name='BillVerificationComment']");
	public By billVerificationSave = By.xpath("//button[.='Save']");
	
	public By bilVerify(String expNumber) {
		return By.xpath("//td//span[.='"+expNumber+"']");
	}
	
	public By accVerificationSubTab = By.xpath("//span[normalize-space(text())='Account Verification']");
	public By accVerificationPaymentStatus =By.xpath("//select[@name='PaymentStatus']");
	public By accVerificationPaymentOn = By.xpath("//select[@name='PaymentOn']");
	public By accVerificationComment = By.xpath("//textarea[@id='Description']");
	public By exp_accVerificationMsg = By.xpath("//span[.='Expense payment status saved successfully.']");
	
	public By payReleaseSubTab = By.xpath("//span[normalize-space(text())='Pay Release']");
	
	public By paymentStatus = By.xpath("//select[@name='PaymentStatus']"); 
	public By paymentStatusComment = By.xpath("//textarea[@name='PaymentStatusComment']");
	public By exp_paymentSuccessMsg = By.xpath("//span[.='Expense payment status saved successfully.']");
	
	public By exp_paymentDoneMsg(String expNum) { return By.xpath("(//td//span[.='"+expNum+"']/../../td)[12]/span[.='Payment Done']"); }
	
	
	public By rejectExpBtn = By.xpath("(//button[.='Reject'])[1]");
	public By rejectExpComment = By.xpath("//textarea[@id='RejectedComment']");
	public By rejectBtn = By.xpath("(//button[.='Reject'])[2]");
	public By rejectOk = By.xpath("//button[.='Yes']");
	public By rejectSuccessMsg = By.xpath("//span[.='Expense rejected successfully.']");
	
	public By rejectTab = By.xpath("(//div[.='Rejected'])[2]");
	
	
	
			
}
