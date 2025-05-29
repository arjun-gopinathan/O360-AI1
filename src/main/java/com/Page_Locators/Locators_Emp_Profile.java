package com.Page_Locators;

import org.openqa.selenium.By;

public class Locators_Emp_Profile {
	// popup element xpaths
	public By PopupDisplayedCovid = By.xpath("//div/button[1][text()=' Remind Me Later']");
	public By OkBtnCovid = By.xpath("//div/button[1][text()=' Remind Me Later']");
	public By PopupDisplayedDesktop = By.xpath("//*[@id=\"modal-basic-title\" and text()=' Desktop Notifications ']");
	public By OkBtnDesktop = By.xpath(
			"/html/body/app-root/block-ui/app-admin-layout-sidebar-large/div/div[3]/app-dashboard-general/block-ui/div[5]/div/div/div[1]/button");
	public By dashBoard = By.xpath("//a[normalize-space()='Dashboard']");
	// navigating to profile page and thabs xpaths
	public By ClickOnProfileDd = By.xpath("//*[@id=\"userDropdown\"]/h4");
	public By ClickOnProfileLink = By.xpath("//button[contains(.,'Profile')]");
	public By ProfileTab = By.xpath("//div[contains(text(),'Profile')]");
	public By DependantTab = By.xpath("//div[contains(text(),'Dependent Details')]");
	public By SocialMediaTab = By.xpath("//div[contains(text(),'Social Media')]");

	public By ErrorMsg = By.xpath("//*[@id=\"profileForm\"]/div/div[2]/div/span");
	// permanent address
	public By ObjectElement = By.xpath("//button[normalize-space()='Ok']");
	public By PermaAddClickEditBtn = By.xpath("//h5[normalize-space()='Permanent Address']/child::span/i");
	public By PermaHouseNo = By.xpath("//*[@id=\"HouseNo\"]");
	public By PermaHouseName = By.xpath("//*[@id=\"HouseName\"]");
	public By PermaStreet = By.xpath("//*[@id=\"Street\"]");
	public By PermaArea = By.xpath("//*[@id=\"Area\"]");
	public By PermaCity = By.xpath("//*[@id=\"City\"]");
	public By PermaState = By.xpath("//*[@id=\"State\"]");
	public By PermaZip = By.xpath("//*[@id=\"ZipCode\"]");
	public By PermaUploadDoc = By.xpath("//div[@id='PermanentAddress']//input[@type='file']");
	// present address
	public By PrestAddClickEditBtn = By.xpath("//h5[normalize-space()='Present Address']/child::span/i");
	public By PrestHouseNo = By.xpath("//*[@id=\"PresentAddressHouseNo\"]");
	public By PrestHouseName = By.xpath("//*[@id=\"PresentAddressHouseName\"]");
	public By PrestStreet = By.xpath("//*[@id=\"PresentAddressStreet\"]");
	public By PrestArea = By.xpath("//*[@id=\"PresentAddressArea\"]");
	public By PrestCity = By.xpath("//*[@id=\"PresentAddressCity\"]");
	public By PrestState = By.xpath("//*[@id=\"PresentAddressState\"]");
	public By PrestZip = By.xpath("//*[@id=\"PresentAddressZipCode\"]");
	public By PrestUploadDoc = By.xpath("//*[@id=\"PresentAddress\"]//input[@type='file']");
	public By ChkBxCpyPremaAdd = By.xpath("//*[@id=\"PresentAddress\"]/ul/li[1]/input");
	// contact
	public By ContactNoClickEditBtn = By.xpath("//*[@id=\"ContactDetails\"]/h5/span");
	public By PrimaryContactNo = By.xpath("//input[@name='ContactNumber']");
	public By SecondryContactNo = By.id("AlternateContactNumber");
	public By SecondaryCountryCode = By.id("AlternateCountryCode");
	public By emailIDField = By.id("PersonelEmail");
	// other Info
	public By OtherInfoTile = By.xpath("//*[@id=\"OtherInformation\"]");
	public By OtherInfoClickEditBtn = By.xpath("//*[@id=\"OtherInformation\"]/h5/a/i");
	public By PanNoField = By.id("PANNo");
	public By NameAsPerAddhar = By.id("NameinAdhar");
	public By AddharNo = By.id("AadharNo");
	public By UANNo = By.id("UANNumber");
	public By PFNo = By.id("PfNumber");
	public By ESINo = By.id("ESINumber");
	// personal details
	public By EmergencyDeatilsHeader = By.xpath("//h5[normalize-space()='Emergency Contact Details']");
	public By PersonalClickEditBtn = By.xpath("//*[@id=\"PersonalDetails\"]/h5/span/i");
	public By FatherName = By.xpath("//*[@id=\"FathersName\"]");
	public By MotherName = By.xpath("//*[@id=\"MothersName\"]");
	public By BloodGroup = By.id("BloodGroup");
	public By SelectingBldGrp = By.xpath("//*[@id=\"BloodGroup\"]/option[3]");
	// Bank details
	public By BankClickEditBtn = By.cssSelector("div[id='BankDetails'] i[class='fas fa-edit']");
	public By BankName = By.id("BankName");
	public By SelectBankNm = By.xpath("//option[@value='0: 1']");
	public By BankBranch = By.id("BankBranch");
	public By SelectBranchNm = By.xpath("//option[@value='1: 1']");
	public By AccountNum = By.id("AccountNo");
	public By IFSCCode = By.id("IFSCCode");
	public By UploaDbANK = By.xpath("//div[@id='BankDetails']//input[@type='file']");
	// passport details
	public By PassportClickEditBtn = By.cssSelector("div[id='PassportDetails'] i[class='fas fa-edit']");
	public By PassportNo = By.id("PassportNumber");
	public By NameAsPassposrt = By.id("NameInPassport");
	public By SurName = By.id("SurName");
	public By DateOfIssue = By.xpath("//input[@name='PassportIssueDate']");
	public By DateOfExpiry = By.xpath("//input[@name='PassportExpiryDate']");
	// EmergecyContact
	public By VisibleHeader = By.xpath("//span[normalize-space()='IFSC code']");
	public By EmergencyClickEditBtn = By.cssSelector("div[id='EmergencyContact'] i[class='fas fa-edit']");
	public By ContactPersonNm = By.id("EmergencyContactPerson");
	public By EmergencyCountryCode = By.id("EmergencyContactCountryCode");
	public By ContactPersonNo = By.id("EmergencyContactNumber");
	public By ContactEmail = By.id("EmergencyContactEmail");
	public By ContactRelationship = By.xpath("//*[@id=\"EmergencyRelationship\"]/option[1]");
	// HR notification
	public By HRNtfctnClickEditBtn = By.cssSelector("div[id='HrNotification'] i[class='fas fa-edit']");
	public By Bday = By.xpath("//label[normalize-space()='Birthday']");
	public By WorkAnnversary = By.xpath("//label[normalize-space()='Work Anniversary']");
	public By WeddingAnniversary = By.xpath("//label[normalize-space()='Wedding Anniversary']");
	// submit button
	public By SubmitBtn = By.xpath("//button[normalize-space()='Submit']");
	public By ClickYes = By.xpath("//button[@data-dismiss='modal' and text()='Yes']");

}