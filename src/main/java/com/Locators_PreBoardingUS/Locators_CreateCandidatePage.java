package com.Locators_PreBoardingUS;

import org.openqa.selenium.By;

public class Locators_CreateCandidatePage {

	public By AddNewBtn = By.xpath("//button[normalize-space()='Add New']");
	public By CandidateCreationForm = By.xpath("//h3[normalize-space()='Candidate Creation']");
	public By SubmitAndRequestEmailCreationBtn = By
			.xpath("//button[normalize-space()='Submit and Request Email Creation']");
	
	public By SubmitBtn = By.xpath("//button[normalize-space()='Submit']");

	// Validation Message
	public By HiringClassificationValidationMsg = By
			.xpath("//div[normalize-space()='Hiring Classification is required.']");
	public By FirstNameValidationMsg = By.xpath("//div[normalize-space()='First name is required.']");
	public By LasttNameValidationMsg = By.xpath("//div[normalize-space()='Last name is required.']");
	public By PersonalEmailValidationMsg = By.xpath("//div[normalize-space()='Personal email required.']");
	public By ContactNumberValidationMsg = By.xpath("//div[normalize-space()='Valid Contact Number is required.']");
	
	public By DateoFBirthValidationMsg = By.xpath("//label[normalize-space()='Date Of Birth']/following-sibling::div[2]");
	public By Race_EthnicityValidationMsg = By.xpath("//label[normalize-space()='Race/Ethnicity']/following-sibling::div[2]");
	public By AddressLine1ValidationMsg = By.xpath("//label[normalize-space()='Address Line 1']/following-sibling::div");
	public By ZipCodeValidationMsg = By.xpath("//label[normalize-space()='Zip Code']/following-sibling::div");
	public By CityValidationMsg = By.xpath("//label[normalize-space()='City']/following-sibling::div");
	public By StateValidationMsg = By.xpath("//label[normalize-space()='State']/following-sibling::div[2]");
	
	public By AttachResumeValidationMsg = By.xpath("//div[normalize-space()='Upload Resume.']");

	public By ReportingManagerValidationMsg = By.xpath("//div[normalize-space()='Reporting manager is required.']");
	public By DesignationValidationMsg = By.xpath("//div[normalize-space()='Designation is required.']");
	public By BusinessUnitValidationMsg = By.xpath("//div[normalize-space()='Project BU is required.']");
	public By DivisionValidationMsg = By.xpath("//div[normalize-space()='Division is required.']");
	public By TechnologyValidationMsg = By.xpath("//div[normalize-space()='Technology is required.']");
	public By DepartmentValidationMsg = By.xpath("//div[normalize-space()='Department is required.']");
	public By VisaTypeValidationMsg = By.xpath("//div[normalize-space()='Visa Type is required.']");
	public By DateOfJoiningValidationMsg = By.xpath("//div[normalize-space()='Valid date of joining is required.']");
	public By EmploymentTypeValidationMsg = By.xpath("//div[normalize-space()='Employment Type is required.']");
	public By BenefitsWaiverFormValidationMsg = By.xpath("//div[normalize-space()='Upload Benefits Waiver Form.']");

	public By AmountValidationMsg = By.xpath("//div[normalize-space()='Amount is required.']");
	public By SalaryTypeValidationMsg = By.xpath("//div[normalize-space()='Salary type is required.']");
	public By JobZipCodeValidationMsg = By.xpath("//input[@id='JobZipCode']/following-sibling::div");

	// Fields
	public By HiringClassification = By.xpath("//select[@id='Classificationtype']");
	public By ReHire = By.xpath("//input[@id='ReHireName']");
	public By ReHireDialogueBox = By.xpath("//h4[normalize-space()='ReHire']");
	public By ReHireDialogueBox_EmployeeColumn = By.xpath("//th[normalize-space()='Employee']");
	public By ReHireDialogueBox_dateOfJoiningColumn = By.xpath("//th[normalize-space()='Date Of Joining']");
	public By ReHireDialogueBox_dateOfRelieving = By.xpath("//th[normalize-space()='Date Of Relieving']");
	public By ReHireDialogueBox_oKBtn = By.xpath("//button[normalize-space()='OK']");
	public By ReHireDialogueBox_cancelBtn = By.xpath("//button[normalize-space()='Cancel']");
	public By FirstName = By.xpath("//input[@id='FirstName']");
	public By MiddleName = By.xpath("//input[@id='MiddleName']");
	public By LastName = By.xpath("//input[@id='LastName']");
	public By PreferredName = By.xpath("//input[@id='NickName']");
	public By PersonalEmail = By.xpath("//input[@id='Email']");
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
	public By AttachResume = By.xpath("//label[normalize-space()='Attach Resume (Max size: 4MB)']/following-sibling::div[2]");
	public By AttachedResumeName = By.xpath("//label[normalize-space()='Attach Resume (Max size: 4MB)']/following-sibling::div[2]/div/a[1]");
	public By SSN_Number = By.xpath("//input[@id='SSNNo']");
	public By SSN_Upload = By.xpath("//label[normalize-space()='SSN Upload (PDF Max size: 4MB )']/following-sibling::div[2]");
	public By SSNUploadName = By.xpath("//label[normalize-space()='SSN Upload (PDF Max size: 4MB )']/following-sibling::div[2]/div/a[1]");
	public By Certificate = By.xpath("//input[@id='Certification']");
	public By Certificate_Upload = By.xpath("//label[normalize-space()='Certificate Upload (PDF Max size: 4MB )']/following-sibling::div[2]");
	public By CertificateUploadName = By.xpath("//label[normalize-space()='Certificate Upload (PDF Max size: 4MB )']/following-sibling::div[3]/a[1]");

	public By ReportingTo = By.xpath("//input[@id='ReportingManager']");
	public By Designation = By.xpath("//input[@id='DesignationName']");
	public By RoleName = By.xpath("//input[@id='RoleName']");
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
	public By LaptopRequired_Yes = By.xpath("//label[normalize-space()='Laptop Required']/following-sibling::div/label[1]/input");
	public By BackgroundCheckRequired_Yes = By.xpath("//label[normalize-space()='Background Check Required']/following-sibling::div/label[1]/input");
	public By AddDistributionList_No = By.xpath("//label[normalize-space()='Add Distribution List ?']/following-sibling::div/label[2]/input");
	public By BenefitsWaiverForm = By.xpath("//label[normalize-space()='Benefits Waiver Form(Max size: 4MB)']/following-sibling::div[2]");
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
	
	public By searchInDialogueBox = By.xpath("//input[@placeholder='Search..']");
	public By oKBtnInDialogueBox = By.xpath("//button[normalize-space()='OK']");
	public By cancelBtnInDialogueBox = By.xpath("//button[normalize-space()='Cancel']");
	
	public By MailCreationRequest_OkBtn = By.xpath("//button[text()='Ok']");
	
	public By searchIcon = By.xpath("//div[@class='dropdown pull-left']//button[@id='dLabel']");
	public By searchText = By.xpath("//input[@id='SearchValue']");
	public By searchBtn = By.xpath("//div[@class='modal-footer']//button[@id='dLabel']");
	public By NameColumn = By.xpath("//td[@data-title='Name']/span");
}
