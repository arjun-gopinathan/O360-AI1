package com.Locators_PreBoardingUS;

import org.openqa.selenium.By;

public class Locators_CandidateOnBoardingPage {
	
	public By CandidateOnBoardingPageHeader = By.xpath("//li[contains(text(),'Candidate On Boarding')]");
	
	public By searchIcon = By.xpath("//div[@class='dropdown pull-left']//button[@id='dLabel']");
	public By searchDialogueBox = By.xpath("//h4[normalize-space()='Search']");
	public By searchColumnInSearchDialogueBox = By.xpath("//select[@id='SearchColumn']");
	public By searchTypeInSearchDialogueBox = By.xpath("//select[@id='SearchType']");
	public By searchValueInSearchDialogueBox = By.xpath("//input[@id='SearchValue']");
	public By searchBtn = By.xpath("//div[@class='modal-footer']//button[@id='dLabel']");
	
	public By searchedCandidateName = By.xpath("//tbody/tr/td[1]");
	public By searchedCandidateRow = By.xpath("//tbody/tr");
	public By CandidateOnBoardingForm = By.xpath("//h3[normalize-space()='Candidate On Boarding']");
	
	
	//fields
	public By hiringClassification = By.xpath("//select[@id='Classificationtype']");
	public By rehire = By.xpath("//input[@id='ReHireName']");
	public By salutation = By.xpath("//select[@id='Salutation']");
	
	public By firstName = By.xpath("//input[@id='FirstName']");
	public By middleName = By.xpath("//input[@id='MiddleName']");
	public By lastName = By.xpath("//input[@id='LastName']");
	public By preferredName = By.xpath("//input[@id='NickName']");
	public By email = By.xpath("//input[@id='Email']");
	public By ContactNumber = By.xpath("//input[@id='AlternateContactNumber1']");
	public By Gender = By.xpath("//select[@id='Gender']");
	public By MaritalStatus = By.xpath("//select[@id='MaritalStatus']");
	public By DateOfBirth = By.xpath("//input[@id='DateOfBirth']");
	public By DateOfBirthField = By.xpath("//input[@id='DateOfBirth']/..");
	public By Race_Ethnicity = By.xpath("//select[@id='ethnicOrigin']");
	public By AddressLine1 = By.xpath("//input[@id='PerHouseNo']");
	public By AddressLine2 = By.xpath("//input[@id='PerHouseName']");
	public By ZipCode = By.xpath("//input[@id='PerZipCode']");
	public By City = By.xpath("//input[@id='PerCityText']");
	public By State = By.xpath("//select[@id='PerState']");
	public By AttachResume = By.xpath("//label[normalize-space()='Attach Resume (Max size: 4MB)']/../child::div[2]/child::div/input");
	public By AttachedResumeName = By.xpath("//label[normalize-space()='Attach Resume (Max size: 4MB)']/following-sibling::div[2]/div/a[1]");
	public By SSN_Number = By.xpath("//input[@id='SSNNo']");
	public By SSN_Upload = By.xpath("//label[normalize-space()='SSN Upload (PDF Max size: 4MB )']/../child::div[2]/child::div/input");
	public By SSNUploadName = By.xpath("//label[normalize-space()='SSN Upload (PDF Max size: 4MB )']/following-sibling::div[2]/div/a[1]");
	public By Certificate = By.xpath("//input[@id='Certification']");
	public By Certificate_Upload = By.xpath("//label[normalize-space()='Certificate Upload (PDF Max size: 4MB )']/../child::div[2]/child::div/input");
	public By Certificate_Upload1 = By.xpath("//label[normalize-space()='Certificate Upload (PDF Max size: 4MB )']/../child::div[2]/input");
	public By CertificateUploadName = By.xpath("//label[normalize-space()='Certificate Upload (PDF Max size: 4MB )']/following-sibling::div/a[1]");
	public By CertificateUploadPopup = By.xpath("//div[contains(@class,'modal-body')]//div//span[contains(text(),'Certificate')]");
	public By CertificateUploadPopupOkBtn = By.xpath("//button[normalize-space()='Ok']");
	
	public By ReportingTo = By.xpath("//input[@id='ReportingManager']");
	public By Designation = By.xpath("//input[@id='DesignationName']");
	public By RoleName = By.xpath("//input[@id='RoleName']");
	public By ParentOffice = By.xpath("//input[@id='ParentOfficeName']");
	public By BusinessUnit=By.xpath("//input[@id='BusinessUnitSearch']");
	public By Division=By.xpath("//input[@id='DivisionName']");
	public By Technology = By.xpath("//input[@id='TechnologyName']");
	public By Department = By.xpath("//input[@id='ProjectDepartment']");
	public By ImmigrationStatus = By.xpath("//select[@id='ImmigrationStatus']");
	public By VisaType=By.xpath("//select[@id='Citizenshiptype']");
	public By DateOfJoining=By.xpath("//input[contains(@id,'mat-input')]");
	public By DateOfJoiningCalender=By.xpath("//input[contains(@id,'mat-input')]/../child::mat-datepicker-toggle/button");
	public By EmploymentType = By.xpath("//select[@id='EmploymentType']");
	public By EmploymentSubType = By.xpath("//select[@id='EmploymentSubType']");
	public By SpecialAccessNeeded = By.xpath("//input[@id='SpecialAccess']");
	public By TrainingRequired = By.xpath("//textarea[@id='TrainingRequired']");
	public By AdditionalTraining = By.xpath("//input[@id='AdditionalTraining']");
	
	public By EligibleForBenefits_No = By.xpath("//label[normalize-space()='Eligible for Benefits']/following-sibling::div/label[2]/input");
	public By EligibleForBenefits_Yes = By.xpath("//label[normalize-space()='Eligible for Benefits']/following-sibling::div/label[1]/span[2]");
	
	public By LaptopRequired_Yes = By.xpath("//label[normalize-space()='Laptop Required']/following-sibling::div/label[1]/input");
	public By LaptopRequired_No = By.xpath("//label[normalize-space()='Laptop Required']/following-sibling::div/label[2]/span[2]");
	
	public By BackgroundCheckRequired_Yes = By.xpath("//label[normalize-space()='Background Check Required']/following-sibling::div/label[1]/input");
	public By BackgroundCheckRequired_No = By.xpath("//label[normalize-space()='Background Check Required']/following-sibling::div/label[2]/span[2]");
	
	public By AddDistributionList_No = By.xpath("//label[normalize-space()='Add Distribution List ?']/following-sibling::div/label[2]/input");
	public By AddDistributionList_Yes = By.xpath("//label[normalize-space()='Add Distribution List ?']/following-sibling::div/label[1]/span[2]");

	public By BenefitsWaiverForm = By.xpath("//label[normalize-space()='Benefits Waiver Form(Max size: 4MB)']/../child::div[2]/child::div/input");
	public By BenefitsWaiverForm_UploadName = By.xpath("//label[normalize-space()='Benefits Waiver Form(Max size: 4MB)']/following-sibling::div[2]/div/a[1]");
	
	public By JobLocation = By.xpath("//select[@id='JbLocation']");
	public By JobCountry = By.xpath("//select[@id='JobCountry']");
	public By JobZipCode = By.xpath("//input[@id='JobZipCode']");
	public By jobCityText = By.xpath("//input[@id='JobCityText']");
	public By JobStateText = By.xpath("//input[@id='JobStateText']");
	
	public By Currency = By.xpath("//select[@id='Currency']");
	public By Amount = By.xpath("//input[@id='SalaryAmount']");
	public By SalaryType = By.xpath("//select[@id='SalaryType']");
	public By AdditionalComments = By.xpath("//textarea[@id='AdditionalComments']");
	
	public By SuggestedCompanyEmail = By.xpath("//input[@id='CompanyEmail']");
	public By SuggestedUserName = By.xpath("//input[@id='UserName']");
	
	public By approvedCompanyEmail = By.xpath("//input[@id='ConfCompanyEmail']");
	public By approvedUserName = By.xpath("//input[@id='ConfUserName']");
	
	//Form List
	public By personalInformationForm = By.xpath("//td[normalize-space()='Personal Information']");
	public By W4 = By.xpath("//td[normalize-space()='W4']");
	public By Handbook = By.xpath("//td[normalize-space()='Handbook']");
	public By directDeposit = By.xpath("//td[normalize-space()='Direct Deposit']");
	public By PayDay_iSolved = By.xpath("//td[normalize-space()='PayDay_iSolved']");
	public By speridianTravelDocumentSupplement = By.xpath("//td[normalize-space()='Speridian Travel Document Supplement']");
	public By EEO = By.xpath("//td[normalize-space()='EEO']");
	public By paySchedule = By.xpath("//td[normalize-space()='Pay Schedule']");
	public By I9Documents = By.xpath("//td[normalize-space()='I9 Documents']");
	public By I9 = By.xpath("//td[normalize-space()='I9']");
	
	//buttons
	public By backedOutBtn = By.xpath("//button[normalize-space()='BackedOut']");
	public By confirmOnBoardingBtn = By.xpath("//button[normalize-space()='Confirm Onboarding']");
	
	public By confirmationPopup = By.xpath("//h1[normalize-space()='Confirmation']");
	public By comment_ConfirmationPopup = By.xpath("//textarea[@id='PMOComments']");
	public By OkBtn_ConfirmationPopup = By.xpath("//button[normalize-space()='Ok']");
	public By CancelBtn_ConfirmationPopup = By.xpath("//button[normalize-space()='Cancel']");

}
