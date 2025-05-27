package com.Page_Repositary;

import org.openqa.selenium.By;

public class PageRepositary_ExpenseModule 
{
	public By timesheetSection= By.xpath("//span[text()='Self Service']");
	public By futureDate= By.xpath("//div[text()=' Future date not allowed. ']");
	public By ExpenseDate= By.xpath("(//button[@aria-label='Open calendar'])[1]");
	public By ExpenseTitle= By.xpath("//input[@id='ExpenseTitle']");
	public By ProjectSelection= By.xpath("//input[@id='Project']");
	public By ProjectSearch= By.xpath("//input[@name='search']");
	public By ProkjectSerachOk= By.xpath("//button[text()='OK']");
	public By EnterDescription= By.xpath("//textarea[@id='Description']");
	public By selectProj= By.xpath("//table[@class='table']/tr/td");
	public By selectMonthandYear= By.xpath("//div[@class='mat-calendar-arrow']/parent::span");
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
	
	public By ExpenseModule1= By.xpath("//span[@class='nav-text'][normalize-space()='Expense']");
//	public By ApprovalsSection= By.xpath("//a[@class='open']");
//	public By Approvals= By.xpath("//a[@class='ng-star-inserted open']//span[@class='item-name lvl1']");
	public By ApprovalsSection= By.xpath("//span[normalize-space()='Approvals']");
	public By Approvals= By.xpath("//a[@href='#/expense/expenseApprovalList']//span[@class='item-name lvl1']");
	public By RejectButton= By.xpath("//i[text()='Reject']");
	public By EnterComments= By.xpath("//textarea[@id='RejectedComment']");
	public By clickOnReject= By.xpath("//button[contains(text(),'Reject')]");
	public By RejectConfirmYes= By.xpath("//button[normalize-space()='Yes']");
	public By ApproveButton= By.xpath("//i[normalize-space()='Approve']");
	public By EnterApproveComments= By.xpath("//textarea[@name='ApproverComment']");
	public By clickOnApprove= By.xpath("//button[contains(text(),'Approve')]");

	
	
	

	
	
	
	
	//button[normalize-space()='Yes']
	
		
}
