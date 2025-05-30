package com.Page_Repositary;

import org.openqa.selenium.By;

public class Locators_TicketPage {
	
	public  By L_username = By.id("Username");
	public  By L_password = By.id("Password");
	public  By L_SignIn = By.xpath("//span[text()=' Sign In ']");
	
	//Ticket-Create
	public By ticketMenu= By.xpath("//span[text()='Ticket']/parent::div");
	public By newTicket=By.xpath("//span[text()='New Ticket ']/parent::a");
	public By subjectField= By.xpath("//input[@placeholder='Search here']");
	public By categoryDropdown= By.xpath("//select[@id='TicketCategoryId']");
	public By ticketTypeDropdown= By.xpath("//select[@id='TicketTypeId']");
	public By ticketPriorityDropdown= By.xpath("//select[@id='TicketPriorityId']");
	public By addWatchers= By.xpath("//span[text()='Select']/parent::span");
	public By expandDescription= By.xpath("//span[text()='Add Description*']");
	public By switchFrame= By.xpath("//iframe[@title='Rich Text Editor, editor1']");
	public By addDescriptionText= By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']/p");
	public By browse= By.xpath("//label[contains(text(),'Choose file or drag it here ')]/parent::div"); 
	public By submitButton= By.xpath("//button[text()='Submit ']");
	public By closeButton= By.xpath("//button[text()=' Close ']");
	public By confirmationMessage= By.xpath("//button[text()='Ok']");
	public By confirmationMessageText=By.xpath("//span[contains(text(),'Ticket-#')]");
	public By ConfirmationMessageDialogAppear=By.xpath("//h4[contains(text(),'Ticket')]");
	 //h4[contains(text(),'Ticket Submitted')]
	public By searchWatchersToSelect=By.xpath("//input[@placeholder='Search']/parent::li/input");
	public By selectWatcherCheckbox=By.xpath("//input[@type='checkbox']/following-sibling::div");
	public By deselecttheWatcher=By.xpath("//span[@class='dropdown-btn']");
	public By closeTicketDetailsPage=By.xpath("//button[contains(text(),'×')]");
	
	// My Tickets Page locators
	public By myTickets=By.xpath("//span[text()='My Tickets ']/parent::a");
	public By myTicketsPage = By.xpath("//li[contains(text(),'Ticket List')]");
	public By ticketStatus=By.xpath("//select[@class='form-control drp_dwn ng-untouched ng-pristine ng-valid']");
	public By ticketsDropdown=By.xpath("(//select[@class='form-control drp_dwn ng-untouched ng-pristine ng-valid'])[2]");		
	public By searchTicketIcon=By.xpath("//div[@class='dropdown pull-left']//button[@id='dLabel']");
	public By searchDialogueBox = By.xpath("//h4[normalize-space()='Search']");
	public By searchColumnInSearchDialogueBox = By.xpath("//select[@id='SearchColumn']");
	public By searchTypeInSearchDialogueBox = By.xpath("//select[@id='SearchType']");
	public By searchValueInSearchDialogueBox = By.xpath("//input[@id='SearchValue']");
	public By searchBtn = By.xpath("//div[@class='modal-footer']//button[@id='dLabel']");
	public By addMoreSearch = By.xpath("//button[text()=' Add Another Search Criteria']");
	public By searchedTicketNo = By.xpath("//tbody/tr/td[1]");
	public By noTicketFound =By.xpath("//tr/td[text()=' No Data Found']");
	public By download=By.xpath("//button[@class='btn btn-primary btn-download-file ng-star-inserted']");
	public By ticketsID=By.xpath("//span[@class='link ng-star-inserted']");	
	public By ticketOwner=By.xpath("//label[contains(text(),'Ticket Owner')]/following-sibling::input");
	public By status=By.xpath("(//input[@class='form-control ng-untouched ng-pristine'])[7]");
	public By viewTicketdisplayed=By.xpath("//li[contains(text(),'Total Items : - ')]");	
	public By disabledSubject =By.xpath("//input[@id='Subject']");
	public By disabledTicketOwner =By.xpath("//input[@id='Employee']");
	public By disabledCategory =By.xpath("//label[contains(text(),'Category')]/following-sibling::input");
	public By disabledTicketType =By.xpath("//label[contains(text(),'Ticket Type')]/following-sibling::input");
	public By disabledPriorityType =By.xpath("//label[contains(text(),'Priority Type')]/following-sibling::input");
	public By disabledStatus=By.xpath("(//input[@class='form-control ng-untouched ng-pristine'])[7]");
	
	//Ticket on behalf
	public By ticketOnBehalf=By.xpath("//span[contains(text(),'Ticket On Behalf ')]");
	public By navigateToOnBehalf=By.xpath("//li[contains(text(),'On Behalf')]");
	public By employeename =By.xpath("//input[@id='Employee']");
	public By searchedEmployee=By.xpath("(//span[@class='mat-option-text']/span)[1]");
	public By selectAddWatchers=By.xpath("//span[contains(text(),'Select')]");
	public By searchAddWatchers=By.xpath("(//input[@placeholder='Search'])[2]");
	public By description=By.xpath("//textarea[@id='Description']");  //textarea[@id='Description']/parent::div
	public By submit=By.xpath("//button[contains(text(),'Submit')]");
	public By confirmationText=By.xpath("//span[contains(text(),'has Submitted Successfully')]");
	public By cancel=By.xpath("//button[text()='Cancel']");
	public By statusDropdown=By.xpath("//select[@id='TicketStatusId']");
	
	//Ticket Dashboard
	public By dashboardMenu=By.xpath("//span[contains(text(),'Dashboard')]");
	public By validateDashboardPage=By.xpath("//li//a[contains(text(),'Ticket List')]");
	public By ticketCreatedOn=By.xpath("//select[@id='SearchItem']");
	public By searchTicket=By.xpath("//input[@name='Search']");
	public By iconSearchTicket=By.xpath("//i[@class='fas fa-search fa_i']/parent::button");
	public By disableRequester=By.xpath("//input[@id='Employee']");
	public By subcategory=By.xpath("//select[@id='SubCategory']");
	public By assignedTo =By.xpath("//select[@name='AssignedTo']");
	public By reroutecategory=By.xpath("//select[@name='RerouteCategoryId']");
	public By auditTrail=By.xpath("//button[@title='Ticket Audit Trail']");
	public By validateAuditTrail=By.xpath("//li[contains(text(),'Ticket Audit Trail')]");
	public By validateTicketNoInAuditTrail=By.xpath("//span[contains(text(),'Ticket:')]");
	public By ticketHistoryIcon=By.xpath("//i[@title='Click to see ticket history']");
	public By ticketStatusHistoryIcon=By.xpath("//i[@title='Click to see ticket status history']");
	public By ticketHistoryDialog=By.xpath("//h4[contains(text(),'Ticket History')]");
	public By ticketStatusHistoryDialog=By.xpath("//h4[contains(text(),'Ticket Status History')]");
	public By closeDialog=By.xpath("(//button[contains(text(),'×')])[2]");
	public By subType =By.xpath("//select[@id='SubType']");
	public By ticketNotFound=By.xpath("//table/tr/td");
	public By validateTicketNumber=By.xpath("//tbody/tr/td[2]");
	public By verifyTicketDetails=By.xpath("//li[contains(text(),'Ticket Details')]");
	public By ticketTypeDisabled=By.xpath("//select[@id='TicketTypeId']");	
	public By priorityType=By.xpath("//select[@id='TicketPriority']");
	public By statusTicket=By.xpath("//select[@id='TicketStatusId']");
	
	//Assigned ticket locators
	public By assignedTickets=By.xpath("//span[contains(text(),'Assigned Tickets ')]");
	public By submitButtonAssigned =By.xpath("//button[contains(text(),'Submit')][1]");
	public By switchFrameToAddComents=By.xpath("//iframe[@title='Rich Text Editor, editor6']");
	public By addCommentsText = By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']/p[1]");
	public By expandAddComments=By.xpath("//span[text()='Add Comment']");
	public By send=By.xpath("//button[contains(text(),' Send ')]");
	public By validateAssignedTicketsPage=By.xpath(" //li[contains(text(),'Ticket Assigned List')]");
	public By validateTicket=By.xpath("//tbody/tr/td[2]");
	public By validateTicket1=By.xpath("//tbody/tr/td[1]");
	public By validateTicketNumberAssigned=By.xpath("//tbody/tr/td[1]");
	public By switchFrameToResolvedComments=By.xpath("//iframe[@title='Rich Text Editor, editor7']");
	public By addResolvedComments=By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']/p[1]");
	public By submitTicketComments=By.xpath("//div[@class='modal-footer ng-star-inserted']/button[1]");
	public By categorySelect=By.xpath("//select[@id='TicketCategoryId']/option[contains(text(),' ')]");
	
	//Quick Tickets
	//---Quick New tickets
	public By quickTickets=By.xpath("//i[@title='Tickets']/parent::div");
	public By newTicketQuick=By.xpath("//div[contains(@class,'button-ticket')][1]");
	public By openTicketsQuick=By.xpath("//div[contains(text(),'Open')]/parent::div");
	public By closedTicketsQuick=By.xpath("//div[contains(text(),'Closed')]/parent::div");
	public By taggedTicketsQuick=By.xpath("//div[contains(text(),'Tagged')]/parent::div");
	public By ticketSideBar=By.xpath("//div[contains(text(),'Ticket ')]");
	public By viewticketSideBar=By.xpath("//div[contains(text(),'View Ticket')]");
	public By iframeaddDescription=By.xpath("//iframe[@title='Rich Text Editor, editor1']");
	public By quickSubmit=By.xpath("//button[contains(text(),' Submit ')]");
	public By quickClose=By.xpath("//button[contains(text(),'Close')]");
	public By closeBtn=By.xpath("(//div[contains(text(),'X')])[1]");
	
	//---Quick Open tickets
	public By searchIconOpenTicket=By.xpath("//div[@class='dropdown-t pull-left mt-2']//button[@id='dLabel']");
	public By SeachedTicketNoOpenTickets =By.xpath("(//tbody/tr/td[1])[1]");
	public By iframeOpenTicket=By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']");
	public By xBtn=By.xpath("//div[@class='close']");
	public By validateTicketAssigned=By.xpath("//tbody/tr/td[1]");
	public By iframeinprogresscomments=By.xpath("(//iframe[@class='cke_wysiwyg_frame cke_reset'])[1]");
	public By switchFrameToResolvedComments1=By.xpath("(//iframe[@class='cke_wysiwyg_frame cke_reset'])[2]");
	
	//closed tickets
	public By closedTab=By.xpath("//div[contains(text(),'Closed')]/parent::div");
	public By saveAndClose=By.xpath("//button[text()='Save & close ']");
	public By reopen=By.xpath("//button[text()=' Reopen ' ]");
	public By closedIframe=By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']");
	public By rateAndClose= By.cssSelector("div.star-container");
	
	//Tagged Tab
	public By taggedLink=By.xpath("//div[contains(text(),'Tagged')]/parent::div");
	
			
}
