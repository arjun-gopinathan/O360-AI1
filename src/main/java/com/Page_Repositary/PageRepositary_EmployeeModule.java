package com.Page_Repositary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.BasePackage.Base_Class;

public class PageRepositary_EmployeeModule {


	//button[text()=' Remind Me Later']
	public static By DesktopNot = By.xpath("//button[text()='OK']");
	public By PopupDisplayedCovid = By.xpath("//div/button[1][text()=' Remind Me Later']");
	public By OkBtnCovid = By.xpath("//div/button[1][text()=' Remind Me Later']");
	public By PopupDisplayedDesktop = By.xpath("//*[@id=\"modal-basic-title\" and text()=' Desktop Notifications ']");
    public By dashBoard = By.xpath("//a[normalize-space()='Dashboard']");
    public By OkBtnDesktop = By.xpath("//div/button[2][text()='OK']");



	public By clickOnemp= By.xpath("//span[text()='Employee']");
	//public By EmployeeSection= By.xpath("//span[text()='Employee']/parent::div");
	public By employeeapplicationtrackersection=By.xpath("//span[text()='Application Tracker ']");
	public By clickOnAddNew= By.xpath("//button[text()='Add New']");
	//public By clickOnemp= By.xpath("//span[text()='Employee']");
	
	
	//PERSONAINFO
	public By selecthiringclasification= By.xpath("//select[@id='Classificationtype']");
	public By selecthiringclasificationdropdown= By.xpath("//option[text()= ' Rehire ' ]");
	
	public By selecrehire= By.xpath("//input[@id='ReHireName']");
	public By selecrehiredropdown= By.xpath("//td[text()=' Abi Philip ']");
	public By selecrehiredropdownok= By.xpath("//button[text()='OK']");
	
	public By selectsalutation= By.xpath("//select[@id='Salutation']");
	
	public By selectfirstname=By.id("FirstName");
	public By selectmiddlename= By.id("MiddleName");
	public By selectlastname= By.id("LastName");
	public By enterpersonalemail= By.xpath("//input[@name='Email']");
//	public By selectreportingtook= By.xpath("(//button[@class='btn btn-primary btn-rounded'])[1]");
	
	public By selectresume= By.xpath("//input[@id='chooseFile']");
	public By entercontactnumber= By.xpath("//input[@id='AlternateContactNumber1']");
	public By resume= By.xpath("(//input[@id='chooseFile'])[1]");
	public By upload= By.xpath("(//input[@id='chooseFile'])[1]");
	
	
	
	//EMPINFO
	public By selectreportingto= By.xpath("//input[@id='ReportingManager']");
	public By selectreportingtodropdown= By.xpath("//td[text()=' A Aare ']");
	public By selectreportingtook= By.xpath("(//button[@class='btn btn-primary btn-rounded'])[1]");
	
	public By selectdesignation= By.xpath("//input[@id='DesignationName']");
	public By selectdesignationdropdown= By.xpath("//td[text()= ' .Net Developer ' ]");
	public By selectdesignationok= By.xpath("(//button[@class='btn btn-primary btn-rounded'])[1]");
	
	public By selectrolename= By.xpath("//input[@id='RoleName']");
	public By selectrolenamedropdown= By.xpath("//td[text()=' Architect ']");
	public By selectrolenameok= By.xpath("(//button[@class='btn btn-primary btn-rounded'])[1]");
	
	
	
	
	public By selectbusinessunit= By.xpath("//input[@id='BusinessUnitSearch']");
	public By selectbusinessunitdropdwon= By.xpath("//span[text()='Benefitalign India']");
	
//	public By selectdivisionscroll= By.xpath("//label[text()='Business Unit']");
	public By selectdivisionname= By.xpath("//input[@id='DivisionName']");
	public By selectdivisionnamedropdown= By.xpath("//span[text()='TC']");
	
	
	
	
	
	
	public By selecttechnologyname= By.xpath("//input[@id='TechnologyName']");
	public By selecttechnologynamedropdown= By.xpath("//span[text()='Admin']");
	
	
	
	public By selectdepartment= By.xpath("//input[@id='ProjectDepartment']");
	public By selectdepartmentdropdwon= By.xpath("(//span[text()='Analytics'])[2]");
	
	
	
	public By selectimmigrationstatus= By.xpath("//select[@id='ImmigrationStatus']");
	public By selectimmigrationstatusdropdown= By.xpath("//option[text()=' Visa ']");
	
	
	
	public By selectvisatype= By.xpath("//select[@id='Citizenshiptype']");
	public By selectvisatypedropdown= By.xpath("//option[text()=' J1 ']");
	
    public By selectdateofjoining= By.xpath("//input[@placeholder='mm/dd/yyyy']");
	
	
	public By selectemptype= By.xpath("//select[@id='EmploymentType']");
	public By selectemptypedropdowncontractor= By.xpath("//option[text()=' Contractor ']");
	
	public By selectemptypedropdownemp= By.xpath("//option[text()=' Employee ' ]");
	
	
	public By selectemptypeemp= By.xpath("//select[@id='EmploymentSubType']");
	public By selectemptypeempdropdown= By.xpath("//option[text()=' Annual ']");
	
	
	
	
	public By selectpseaccessneeded= By.xpath("//input[@id='SpecialAccess']");
	//public By selectdateofjoining= By.xpath("//td[@aria-label='December 24, 2024']");
	
	public By selecttrainingrequired= By.xpath("//textarea[@id='TrainingRequired']");
	public By additionaltraining= By.xpath("//input[@id='AdditionalTraining']");
	
	public By iselegibleforbenefitsno= By.xpath("(//span[text()='No'])[1]");
	
	public By benefitswaiverform= By.xpath("(//input[@class='custom-file-input'])[2]");

	
	////JOB 
	
	public By selectjoblocation= By.xpath("//select[@id='JbLocation']");
	public By selectjoblocationdropdown= By.xpath("//option[text()=' Remote ']");
	
	public By selectcountry= By.xpath("//select[@id='JobCountry']");
	public By selectcountrydropdown= By.xpath("//option[text()=' India ']");
	
	public By enterzipcode= By.xpath("//input[@id='JobZipCode']");
	public By entercity= By.xpath("//input[@id='JobCityText']");
	public By enterstate= By.xpath("//input[@id='JobStateText']");

	
	//Salary
	public By Selectcurrency= By.xpath("//select[@id='Currency']");
	public By selectcurrencydropdown= By.xpath("//option[text()=' INR ']");
	public By enteramount= By.xpath("//input[@id='SalaryAmount']");

	public By Selectsalarytype= By.xpath("//select[@id='SalaryType']");
	public By selectsalarytypedropdown= By.xpath("//option[text()='Per Hour']");
	
	public By enteradditionalcomments= By.xpath("//textarea[@name='AdditionalComments']");
	
	public By Submitbutton= By.xpath("//button[@class= 'btn btn-primary submit-butn leavebtn mr-2']");
	
	public By Submitbuttonok= By.xpath("//button[text()='Ok']");
	
	public By Sendcandidateform= By.xpath("//button[@class='btn btn-primary submit-butn leavebtn mr-2']");
	
	
	public By Sendcandidateformok= By.xpath("//button[text()='Ok']");
	
	
	//EMP_INITIATED_TRANSFER
	public By clickonselfservice= By.xpath("//span[text()='Self Service']");
	public By clickonemprequests= By.xpath("//span[text()='Requests']");
	public By clickonempinitiatedtransfer= By.xpath("//span[text()='Employee Initiated Transfer '] ");

	public By slectempoffice= By.xpath("//input[@id='ToOffice']");
	public By slectempofficedropdown= By.xpath("//td[text()=' Beacon ']");
	public By slectempofficedropdownok= By.xpath("//button[text()='OK'] ");
	
	public By slectempdateoftransfer= By.xpath("(//input[@placeholder='mm/dd/yyyy'])[3]");
	
	public By slectempdateoftransferyes= By.xpath("//button[text()='Yes']");
	public By enterempcomments= By.xpath("//textarea[@id='Comments']");
	public By empsubmit= By.xpath("//button[text()='Submit']");
	
	
	public By empalreadysubmitted= By.xpath("//button[text()='Close']");
	
	
	//HR_INITIATED_TRANSFER
	
	public By clickonhrrequests= By.xpath("//span[text()='Requests']");
	public By clickonhrinitiatedtransfer= By.xpath("//span[text()='HR Initiated Transfer '] ");
	public By clickonhraddnew= By.xpath("//button[text()='Add New']");
	
	
	public By slectempname= By.xpath("//input[@id='EmployeeName']");
	public By slectempnamesearch= By.xpath("(//input[@type='text'])[14]");
	public By searchedemp= By.xpath("//table[@class='table mb-0']/tbody/tr/td[1]");
	public By slectempnamedropdownok= By.xpath("//button[text()='OK'] ");
	public By slectbusinessunit= By.xpath("//input[@id='ToBU']");
	public By slectbusinessunitdropdown= By.xpath("//td[text()=' Speridian Canada '] ");
	public By slectbusinessunitdropdown1= By.xpath("//td[text()=' Speridian India '] ");
	public By slectbusinessunitdropdownok= By.xpath("//button[text()='OK'] ");
	
	public By slectoffice= By.xpath("//input[@id='ToOffice']");
	public By slectofficedropdown= By.xpath("//td[text()=' Beacon ']");
	public By slectofficedropdownok= By.xpath("//button[text()='OK'] ");
	
	public By slectdateoftransfer= By.xpath("(//input[@placeholder='mm/dd/yyyy'])[3]");
	//public By slectdateoftransferyes= By.xpath("//button[text()='Yes']");
	
	public By slectnewreportingto= By.xpath("//input[@id='NewReportingTo']");
	public By slectnewreportingtodropdown= By.xpath("//td[text()=' Aanya Singh ']");
	public By slectnewreportingtodropdownok= By.xpath("//button[text()='OK'] ");
	
	public By slecttransfertype= By.xpath("//Select[@id='TransferType']");
	public By slecttransfertypedropdown= By.xpath("//option[text()= ' Company Initiated Transfer ' ]");
	public By entercomments= By.xpath("//textarea[@id='Comments']");
	public By submit= By.xpath("//button[text()='Submit']");
	public By submitok= By.xpath("//button[text()='Ok']");
	
	public By ifhrtransferalreadysubmitted= By.xpath("//button[text()='Ok']");
	
	
	//TRANSFERAPPROVE
	
	public By approvals= By.xpath("(//span[text()='Approvals'])[2]");
	public By emptransfer= By.xpath("//span[text()='Employee Transfer '] ");
	
	public By approvesearch= By.xpath("(//button[@id='dLabel'])[1]");
	public By approvesearchcategory= By.xpath("//select[@id='SearchColumn']");
	
	public By approvesearchcategoryempname= By.xpath("//option[text()=' Employee Name ']");
	
	public By approvesearchtextbox= By.xpath("//input[@id='SearchValue']");
	public By approvesearchbutton= By.xpath("(//button[@id='dLabel'])[2]");
	
	public By selectemprequest= By.xpath("//span[text()='SP10225']");
	public By distributionlist= By.xpath("//textarea[@id='DL']");
	public By approvercomments= By.xpath("//textarea[@id='ApproverRemarks']");
	public By approvbutton= By.xpath("//button[text()='Approve']");
	public By approveyes= By.xpath("//button[text()='Yes']");
	public By rejectbutton= By.xpath("//button[text()='Reject']");
	public By rejectyes= By.xpath("//button[text()='Yes']");
	public By searchedempcode= By.xpath("//table[@class='table mb-0 ']/tbody/tr/td[1]");
	public By searchedempname= By.xpath("//table/tbody/tr/td[@data-title='Code']");
	public By AddSearchCriteriaBtn = By.xpath("//button[normalize-space()='Add Another Search Criteria']");
	public By SearchColumn = By.xpath("//select[@id='SearchColumn']");

	
	
	//quick transfer approvals 
	public By quickapprovals= By.xpath("//i[@title='Quick Approvals']");
	public By quicktransferapprovals= By.xpath("//a[text()='Employee Transfer']");
	
	//us approvals
	
	public By preboardingus= By.xpath("//span[text()='PreBoarding US']");
	public By createcandidate= By.xpath("(//span[text()='Create Candidate '] )[2]");
	public By searchbyempname= By.xpath("//option[text()=' Name ']");
	
	
}
