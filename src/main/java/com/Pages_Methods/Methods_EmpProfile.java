/* 
 * This is test case 1 
 * Steps 1 
 * Open O360 --> Login --> if any popup coming giving action --> 
 */
package com.Pages_Methods;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Locators.Locators_Approve_Process;
import com.Page_Locators.Locators_Emp_Profile;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class Methods_EmpProfile extends Base_Class {

	Locators_Approve_Process ApproveLoc = new Locators_Approve_Process();
	Locators_Emp_Profile locators = new Locators_Emp_Profile();
	Methods_Approver_EmpProfile ApproveMethods = new Methods_Approver_EmpProfile();
	// JavascriptExecutor js = (JavascriptExecutor) driver;

	public void CheckIfEmpPresentOrNot(String UserName, String EmpName) throws InterruptedException, IOException, AWTException {
		// Format the username: remove "." and replace with a space
		// String formattedUserName = userName.replace(".", " ").trim();
		click(ApproveLoc.QuickApprove);
		click(ApproveLoc.profileApproval);
		click(ApproveLoc.SearchIcon);
		String employeeFound = SearchEmpAndVerify(EmpName);

		if (employeeFound.equalsIgnoreCase(EmpName)) {
			Log.info("Employee found in approval list, approving...");
			IfPresentInApproval(EmpName, UserName);
		} else {
			Log.info("Employee not in approval list, proceeding with edit...");
			IfNotPresentInApproval(UserName);
		}
	}

	public void IfPresentInApproval(String EmpName, String UserName) throws InterruptedException, IOException, AWTException {
		Thread.sleep(1000);
		By ResultEmpName = By.xpath("//span[@class='link ng-star-inserted'][normalize-space()='" + EmpName + "']");
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click();", driver.findElement(ResultEmpName));
		click(ResultEmpName);
		ZoomOut();
		ApproveMethods.ApproveRequest();
		Signout();
		SignInAsEmployee(UserName);
		handlePopupCovid();
		handlePopupDesktop();
	}

	public void IfNotPresentInApproval(String userName) throws InterruptedException, IOException {
		Thread.sleep(1000);
		Signout();
		SignInAsEmployee(userName);
		handlePopupCovid();
		handlePopupDesktop();
	}

	public String SearchEmpAndVerify(String userName) throws InterruptedException {
		click(ApproveLoc.SelectSearchCol);
		input(ApproveLoc.TypeSearchValue, userName); // Use the formatted username here
		click(ApproveLoc.SearchBtnInDialog);
		By ResultEmpName = By.xpath("//span[@class='link ng-star-inserted'][normalize-space()='" + userName + "']");
		System.out.println("Xpaths = " + ResultEmpName);
		try {
			Log.info(driver.findElement(ResultEmpName).getText());
			return driver.findElement(ResultEmpName).getText(); // Fetch result
		} catch (Exception e) {
			Log.info("Employee not found in approval list.");
			return "";
		}
	}

	public void navigateToProfile() throws InterruptedException {
		Thread.sleep(5000);
		click(locators.ClickOnProfileDd);
		ExtentTestManager.getTest().log(Status.PASS, "Clicked on Profile Drop Down ");
		Log.info("Clicked on Profile Drop Down");
		ExtentTestManager.getTest().log(Status.PASS, "Clicked on Profile ");
		click(locators.ClickOnProfileLink);
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.PASS, "Navigated to Profile Page ");
		Log.info("Navigated to Profile Page ");
	}

	public void navigateToDependant() throws InterruptedException {
		click(locators.DependantTab);
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.PASS, "Navigating to Dependant Page ");
		Log.info("Navigated to Dependant Page ");
	}

	public void navigateToSocialTab() throws InterruptedException {
		click(locators.SocialMediaTab);
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.PASS, "Navigating to Social Media Page ");
		Log.info("Navigated to Social Media Page ");
	}

	public void checkVisiblityInProfilePg() throws InterruptedException {
		Log.info("Element is Profile Displayed " + driver.findElement(locators.ProfileTab).isDisplayed());
		ExtentTestManager.getTest().log(Status.PASS, "Verified Profile Tab is Visible ");
		Log.info("Verified Profile Tab is Visible ");

		Log.info("Element is Dependant Displayed " + driver.findElement(locators.DependantTab).isDisplayed());
		ExtentTestManager.getTest().log(Status.PASS, "Verified Dependant Tab is Visible ");
		Log.info("Verified Dependant Tab is Visible ");

		Log.info("Element is Social media Displayed " + driver.findElement(locators.SocialMediaTab).isDisplayed());
		ExtentTestManager.getTest().log(Status.PASS, "Verified Social Media Tab is Visible ");
		Log.info("Verified Social Media Tab is Visible ");
	}

	public void checkDefaultTab() throws InterruptedException {
		click(locators.ProfileTab);
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.PASS, "Navigated to Profile Page ");
		Log.info("Navigated to Profile Page ");

		driver.findElement(locators.ProfileTab).isDisplayed();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.PASS, "Verified Profile Tab is Default ");
		Log.info("Verified Profile Tab is Default ");
	}

	public void permaAddClickBtn() throws InterruptedException {
		click(locators.PermaAddClickEditBtn);
		Thread.sleep(35000);
		ExtentTestManager.getTest().log(Status.PASS, "Clicked on Edit btn of Permanent Address");
		Log.info("Clicked on Edit btn of Permanent Address ");
	}

	public boolean PermantCheckIfDisplayedOrNot() throws InterruptedException {
		Thread.sleep(1000);
		boolean flag1 = ElementDisplayed(locators.PermaHouseNo);
		boolean flag2 = ElementDisplayed(locators.PermaHouseName);
		boolean flag3 = ElementDisplayed(locators.PermaStreet);
		boolean flag4 = ElementDisplayed(locators.PermaArea);
		boolean flag5 = ElementDisplayed(locators.PermaCity);
		boolean flag6 = ElementDisplayed(locators.PermaState);
		boolean flag7 = ElementDisplayed(locators.PermaZip);
		boolean flag8 = ElementDisplayed(locators.PermaUploadDoc);
		boolean flag = flag1 & flag2 & flag3 & flag4 & flag5 & flag6 & flag7 & flag8;

		ExtentTestManager.getTest().log(Status.PASS, "All element is permanent address tile is displayed ");
		Log.info("All element is permanent address tile is displayed ");

		return flag;
	}

	public void enterPremaAdd(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException, AWTException {

		String PermaHouseNo = testdata.get("PermaHouseNo").toString();
		String PermaHouseNm = testdata.get("PermaHouseName").toString();
		String PermaStreet = testdata.get("PermaStreet").toString();
		String PermaArea = testdata.get("PermaArea").toString();
		String PermaCity = testdata.get("PermaCity").toString();
		String PermaState = testdata.get("PermaState").toString();
		String PermaZip = testdata.get("PermaZip").toString();

		ExtentTestManager.getTest().log(Status.PASS, "Entering details in Permanent Address tile ");

		clear(locators.PermaHouseNo);
		input(locators.PermaHouseNo, PermaHouseNo);
		ExtentTestManager.getTest().log(Status.PASS, "Entered House No ");
		Log.info("Entered House No ");

		clear(locators.PermaHouseName);
		input(locators.PermaHouseName, PermaHouseNm);
		ExtentTestManager.getTest().log(Status.PASS, "Entered House Name ");
		Log.info("Entered House Name ");

		clear(locators.PermaStreet);
		input(locators.PermaStreet, PermaStreet);
		ExtentTestManager.getTest().log(Status.PASS, "Entered Street ");
		Log.info("Entered House No ");

		clear(locators.PermaArea);
		input(locators.PermaArea, PermaArea);
		ExtentTestManager.getTest().log(Status.PASS, "Entered Area ");
		Log.info("Entered Area ");

		clear(locators.PermaCity);
		input(locators.PermaCity, PermaCity);
		ExtentTestManager.getTest().log(Status.PASS, "Entered City ");
		Log.info("Entered City ");

		clear(locators.PermaState);
		input(locators.PermaState, PermaState);
		ExtentTestManager.getTest().log(Status.PASS, "Entered State ");
		Log.info("Entered State ");

		clear(locators.PermaZip);
		input(locators.PermaZip, PermaZip);
		ExtentTestManager.getTest().log(Status.PASS, "Entered ZipCode");
		Log.info("Entered ZipCode ");

		Thread.sleep(10000);
		String projectpath = System.getProperty("user.dir");
		input(locators.PermaUploadDoc, projectpath + "\\doc\\img1.jpg");
		ExtentTestManager.getTest().log(Status.PASS, "Uploaded proof");
		Log.info("Uploaded Proof ");

	}

	public void prestAddClickBtn() throws InterruptedException {
		Thread.sleep(20000);
		click(locators.PrestAddClickEditBtn);
		Thread.sleep(35000);
		ExtentTestManager.getTest().log(Status.PASS, "Clicked on edit button of Present Address ");
		Log.info("Clicked on edit button of Present Address ");
	}

	public void enterPrestAdd() throws InterruptedException, AWTException {
		ExtentTestManager.getTest().log(Status.PASS, "Entering details in Present Address tile");

		clear(locators.PrestHouseNo);
		input(locators.PrestHouseNo, "HNo 20");
		ExtentTestManager.getTest().log(Status.PASS, "Entered House No ");
		Log.info("Entered House No ");

		clear(locators.PrestHouseName);
		input(locators.PrestHouseName, "Aradhya homes ");
		ExtentTestManager.getTest().log(Status.PASS, "Entered House Name ");
		Log.info("Entered House Name ");

		clear(locators.PrestStreet);
		input(locators.PrestStreet, "lane 4 A");
		ExtentTestManager.getTest().log(Status.PASS, "Entered Street ");
		Log.info("Entered Street ");

		clear(locators.PrestArea);
		input(locators.PrestArea, "Koregaon Park");
		ExtentTestManager.getTest().log(Status.PASS, "Entered Area ");
		Log.info("Entered Area ");

		clear(locators.PrestCity);
		input(locators.PrestCity, "pune");
		ExtentTestManager.getTest().log(Status.PASS, "Entered City ");
		Log.info("Entered City ");

		clear(locators.PrestState);
		input(locators.PrestState, "maharashtra");
		ExtentTestManager.getTest().log(Status.PASS, "Entered State ");
		Log.info("Entered State ");

		clear(locators.PrestZip);
		input(locators.PrestZip, "411001");
		ExtentTestManager.getTest().log(Status.PASS, "Entered ZipCode ");
		Log.info("Entered ZipCode ");

		Thread.sleep(10000);
		String projectpath = System.getProperty("user.dir");
		input(locators.PrestUploadDoc, projectpath + "\\doc\\img2.jpg");
		ExtentTestManager.getTest().log(Status.PASS, "Uploaded Proof");
		Log.info("Uploaded Proof ");

	}

	public void CopyPermaAdd() throws InterruptedException {
		click(locators.ChkBxCpyPremaAdd);
		ExtentTestManager.getTest().log(Status.PASS, "Present Address is same as Permanent Address");
		Thread.sleep(1000);
		System.out.println("Visibility is " + PresentCheckIfDisplayedOrNot());
		Thread.sleep(1000);
	}

	public boolean PresentCheckIfDisplayedOrNot() throws InterruptedException {
		boolean flag1 = ElementDisplayed(locators.PrestHouseNo);
		boolean flag2 = ElementDisplayed(locators.PrestHouseName);
		boolean flag3 = ElementDisplayed(locators.PrestStreet);
		boolean flag4 = ElementDisplayed(locators.PrestArea);
		boolean flag5 = ElementDisplayed(locators.PrestCity);
		boolean flag6 = ElementDisplayed(locators.PrestState);
		boolean flag7 = ElementDisplayed(locators.PrestZip);
		// boolean flag8 = ElementDisplayed(locators.PrestUploadDoc);
		boolean flag = flag1 & flag2 & flag3 & flag4 & flag5 & flag6 & flag7;
		ExtentTestManager.getTest().log(Status.PASS, "All Elements are present as permanent address ");
		Log.info("All Elements are present as permanent address ");
		return flag;
	}

	public void ContactNoClickBtn() throws InterruptedException {
		ScrollUntilElementVisible(locators.HRNtfctnClickEditBtn);
		Thread.sleep(20000);
		click(locators.ContactNoClickEditBtn);
		Thread.sleep(35000);
		ExtentTestManager.getTest().log(Status.PASS, "Clicked on edit of Contact Details ");
		Log.info("Clicked on edit of Contact Details ");
	}

	public boolean ContactCheckIfDisplayedOrNot() throws InterruptedException {
		boolean flag1 = ElementDisplayed(locators.PrimaryContactNo);
		boolean flag2 = ElementDisplayed(locators.SecondryContactNo);
		boolean flag3 = ElementDisplayed(locators.emailIDField);
		boolean flag = flag1 & flag2 & flag3;
		ExtentTestManager.getTest().log(Status.PASS, "All Elements are Displayed ");
		Log.info("All Elements are displayed ");
		return flag;
	}

	public void enterContactNo() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.PASS, "Entering details in Contact tile");

		clear(locators.PrimaryContactNo);
		ExtentTestManager.getTest().log(Status.PASS, "Cleared Primary Contact ");
		clear(locators.SecondryContactNo);
		ExtentTestManager.getTest().log(Status.PASS, "Cleared Secondary Contact ");
		clear(locators.SecondaryCountryCode);
		ExtentTestManager.getTest().log(Status.PASS, "Cleared Secondary Country Code ");
		clear(locators.emailIDField);
		ExtentTestManager.getTest().log(Status.PASS, "Cleared Email Id ");

		input(locators.PrimaryContactNo, "9021367867");
		ExtentTestManager.getTest().log(Status.PASS, "Entered Primary Contact No ");
		Log.info("Entered Primary Contact No ");

		input(locators.SecondryContactNo, "8812345673");
		ExtentTestManager.getTest().log(Status.PASS, "Entered Secondary Contact No ");
		Log.info("Entered Secondary Contact No ");

		input(locators.SecondaryCountryCode, "+91");
		ExtentTestManager.getTest().log(Status.PASS, "Entered Secondary Country Code ");
		Log.info("Entered Secondary Country Code ");

		input(locators.emailIDField, "qretf@gmail.com");
		ExtentTestManager.getTest().log(Status.PASS, "Entered Secondary Email ID ");
		Log.info("Entered Secondary Email ID ");
	}

	public void OtherInfoClickBtn() throws InterruptedException {
		ScrollUntilElementVisible(locators.HRNtfctnClickEditBtn);
		Thread.sleep(2000);
		click(locators.OtherInfoClickEditBtn);
		Thread.sleep(3500);
		ExtentTestManager.getTest().log(Status.PASS, "Clicked on edit of Other Information Details  ");
		Log.info("Clicked on edit of Other Information Details ");
	}

	public boolean OtherInfoIfDisplayedOrNot() throws InterruptedException {
		boolean flag1 = ElementDisplayed(locators.PanNoField);
		boolean flag2 = ElementDisplayed(locators.NameAsPerAddhar);
		boolean flag3 = ElementDisplayed(locators.AddharNo);
		boolean flag4 = ElementDisplayed(locators.UANNo);
		boolean flag5 = ElementDisplayed(locators.PFNo);
		boolean flag6 = ElementDisplayed(locators.ESINo);
		boolean flag = flag1 & flag2 & flag3 & flag4 & flag5 & flag6;
		ExtentTestManager.getTest().log(Status.PASS, "All Elements are Displayed ");
		Log.info("All Elements are displayed ");
		return flag;
	}

	public void enterOtherInfo() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.PASS, "Entering details in Contact tile");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = '';", driver.findElement(locators.PanNoField));
		ExtentTestManager.getTest().log(Status.PASS, "Cleared PAN No Field ");

		/// clear(locators.NameAsPerAddhar);(
		js.executeScript("arguments[0].value = '';", driver.findElement(locators.NameAsPerAddhar));
		ExtentTestManager.getTest().log(Status.PASS, "Cleared Name Field");

		// clear(locators.AddharNo);
		js.executeScript("arguments[0].value = '';", driver.findElement(locators.AddharNo));
		ExtentTestManager.getTest().log(Status.PASS, "Cleared Aadhar Card Field ");

		input(locators.PanNoField, "ABCPX1234A");
		ExtentTestManager.getTest().log(Status.PASS, "Entered PAN NO ");
		Log.info("Entered PAN NO ");

		input(locators.NameAsPerAddhar, "Reshma Murali");
		ExtentTestManager.getTest().log(Status.PASS, "Entered Name As per Addhar ");
		Log.info("Entered Name As per Addhar ");

		input(locators.AddharNo, "123456789018");
		ExtentTestManager.getTest().log(Status.PASS, "Entered Addhar Number ");
		Log.info("Addhar Number ");
	}

	public void PersonalClickBtn() throws InterruptedException {
		ScrollUntilElementVisible(locators.HRNtfctnClickEditBtn);
		Thread.sleep(2000);
		click(locators.PersonalClickEditBtn);
		Thread.sleep(3500);
		ExtentTestManager.getTest().log(Status.PASS, "Clicked on edit of Personal Details ");
		Log.info("Clicked on edit of Personal Details ");
	}

	public boolean PersonalIfDisplayedOrNot() throws InterruptedException {
		boolean flag1 = ElementDisplayed(locators.FatherName);
		boolean flag2 = ElementDisplayed(locators.MotherName);
		boolean flag3 = ElementDisplayed(locators.BloodGroup);
		boolean flag = flag1 & flag2 & flag3;
		ExtentTestManager.getTest().log(Status.PASS, "All Elements are Displayed ");
		Log.info("All Elements are displayed ");
		return flag;
	}

	public void enterPersonal(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {
		String FatherName = testdata.get("FatherName").toString();
		String MotherName = testdata.get("MotherName").toString();

		ExtentTestManager.getTest().log(Status.PASS, "Entering details in Personal Details tile");

		clear(locators.FatherName);
		ExtentTestManager.getTest().log(Status.PASS, "Cleared Father's Name Field ");

		input(locators.FatherName, FatherName);
		ExtentTestManager.getTest().log(Status.PASS, "Entered Father's Name ");
		Log.info("Entered Father's Name ");

		clear(locators.MotherName);
		ExtentTestManager.getTest().log(Status.PASS, "Cleared Mother's Name Field ");

		input(locators.MotherName, MotherName);
		ExtentTestManager.getTest().log(Status.PASS, "Entered Mother's Name ");
		Log.info("Entered Mother's Name ");

		click(locators.BloodGroup);
		ExtentTestManager.getTest().log(Status.PASS, "Clicking on BloodGroup List ");
		Log.info("Clicking on BloodGroup List ");

		click(locators.SelectingBldGrp);
		ExtentTestManager.getTest().log(Status.PASS, "Selecting option from List Displayed  ");
		Log.info("Selecting option from List Displayed ");
	}

	public void BankClickBtn() throws InterruptedException {
		ScrollUntilElementVisible(locators.HRNtfctnClickEditBtn);
		Thread.sleep(2000);
		click(locators.BankClickEditBtn);
		Thread.sleep(3500);
		ExtentTestManager.getTest().log(Status.PASS, "Clicked on edit of Personal Details ");
		Log.info("Clicked on edit of Personal Details ");
	}

	public boolean BankIfDisplayedOrNot() throws InterruptedException {
		boolean flag1 = ElementDisplayed(locators.BankName);
		boolean flag2 = ElementDisplayed(locators.BankBranch);
		boolean flag3 = ElementDisplayed(locators.IFSCCode);
		boolean flag4 = ElementDisplayed(locators.AccountNum);
		boolean flag = flag1 & flag2 & flag3 & flag4;
		ExtentTestManager.getTest().log(Status.PASS, "All Elements are Displayed ");
		Log.info("All Elements are displayed ");
		return flag;
	}

	public void enterBankDetails() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.PASS, "Entering details in Passport Details tile");
		click(locators.SelectBankNm);
		ExtentTestManager.getTest().log(Status.PASS, "Selectd Bank Name ");
		Log.info("Selectd Bank Name ");

		click(locators.SelectBranchNm);
		ExtentTestManager.getTest().log(Status.PASS, "Select Branch Name");
		Log.info("Select Branch Name");

		// clear(locators.AccountNum);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = '';", driver.findElement(locators.AccountNum));
		input(locators.AccountNum, "12345678906708");
		ExtentTestManager.getTest().log(Status.PASS, "Entered Account No ");
		Log.info("Entered Account No  ");

		Thread.sleep(20000);
		String projectpath = System.getProperty("user.dir");
		input(locators.UploaDbANK, projectpath + "\\doc\\img3.jpg");
		ExtentTestManager.getTest().log(Status.PASS, "Uploaded Proof");
		Log.info("Uploaded Proof ");

		try {
			boolean flag = driver.findElement(locators.ObjectElement).isDisplayed();
			if (flag == true) {
				Log.info("Object element is displayed");
				click(locators.ObjectElement);
				Log.info("Handled popup");
			}
		} catch (Exception e) {
			Log.info("Object element is not displayed");
		}
	}

	public void PassportClickBtn() throws InterruptedException {
		ScrollUntilElementVisible(locators.HRNtfctnClickEditBtn);
		Thread.sleep(2000);
		click(locators.PassportClickEditBtn);
		Thread.sleep(3500);
		ExtentTestManager.getTest().log(Status.PASS, "Clicked on edit of Passport Details ");
		Log.info("Clicked on edit of Passport Details ");
	}

	public boolean PassportIfDisplayedOrNot() throws InterruptedException {
		boolean flag1 = ElementDisplayed(locators.PassportNo);
		boolean flag2 = ElementDisplayed(locators.NameAsPassposrt);
		boolean flag3 = ElementDisplayed(locators.SurName);
		boolean flag4 = ElementDisplayed(locators.DateOfIssue);
		boolean flag5 = ElementDisplayed(locators.DateOfExpiry);
		boolean flag = flag1 & flag2 & flag3 & flag4 & flag5;
		ExtentTestManager.getTest().log(Status.PASS, "All Elements are Displayed ");
		Log.info("All Elements are displayed ");
		return flag;
	}

	public void enterPassportDetails() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.PASS, "Entering details in Passport Details tile");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// clear(locators.PassportNo);
		js.executeScript("arguments[0].value = '';", driver.findElement(locators.PassportNo));
		ExtentTestManager.getTest().log(Status.PASS, "Cleared Passport Number field ");

		// clear(locators.NameAsPassposrt);
		js.executeScript("arguments[0].value = '';", driver.findElement(locators.NameAsPassposrt));
		ExtentTestManager.getTest().log(Status.PASS, "Cleared Passport Name field ");

		// clear(locators.SurName);
		js.executeScript("arguments[0].value = '';", driver.findElement(locators.SurName));
		ExtentTestManager.getTest().log(Status.PASS, "Cleared SurNme field ");

		// clear(locators.DateOfIssue);
		js.executeScript("arguments[0].value = '';", driver.findElement(locators.DateOfIssue));
		ExtentTestManager.getTest().log(Status.PASS, "Cleared Date of Issue ");

		// clear(locators.DateOfExpiry);
		js.executeScript("arguments[0].value = '';", driver.findElement(locators.DateOfExpiry));
		ExtentTestManager.getTest().log(Status.PASS, "Cleared Date of Expiry ");

		input(locators.PassportNo, "123REDGPas234");
		ExtentTestManager.getTest().log(Status.PASS, "Entered Passport Number ");
		Log.info("Entered Passport Number ");

		input(locators.NameAsPassposrt, "Name");
		ExtentTestManager.getTest().log(Status.PASS, "Entered Passport Name ");
		Log.info("Entered Passport Number ");

		input(locators.SurName, "XYz");
		ExtentTestManager.getTest().log(Status.PASS, "Entered SurName ");
		Log.info("Entered Passport Number ");

		input(locators.DateOfIssue, "1/27/2025");
		ExtentTestManager.getTest().log(Status.PASS, "Entered Date of Issues ");
		Log.info("Entered Passport Number ");

		input(locators.DateOfExpiry, "4/7/2046");
		ExtentTestManager.getTest().log(Status.PASS, "Entered Date of Expiry ");
		Log.info("Entered Passport Number ");
	}

	public void EmergencyClickBtn() throws InterruptedException {
		ScrollUntilElementVisible(locators.HRNtfctnClickEditBtn);
		Thread.sleep(2000);
		click(locators.EmergencyClickEditBtn);
		Thread.sleep(3500);
		ExtentTestManager.getTest().log(Status.PASS, "Clicked on edit of Emergency Contact Details ");
		Log.info("Clicked on edit of Emergency Contact Details ");
	}

	public boolean EmergencyIfDisplayedOrNot() throws InterruptedException {
		boolean flag1 = ElementDisplayed(locators.ContactPersonNm);
		boolean flag2 = ElementDisplayed(locators.ContactPersonNm);
		boolean flag3 = ElementDisplayed(locators.ContactEmail);
		boolean flag4 = ElementDisplayed(locators.ContactRelationship);
		boolean flag = flag1 & flag2 & flag3 & flag4;
		ExtentTestManager.getTest().log(Status.PASS, "All Elements are Displayed ");
		Log.info("All Elements are displayed ");
		return flag;
	}

	public void enterEmergencyDetails(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {
		String ContactPersonName = testdata.get("ContactPersonName").toString();
		String ContactPersonNumber = testdata.get("ContactPersonNumber").toString();

		ExtentTestManager.getTest().log(Status.PASS, "Entering details in Emergency Contact Details tile");

		clear(locators.ContactPersonNm);
		ExtentTestManager.getTest().log(Status.PASS, "Cleared Emergency Contact Person Name ");

		clear(locators.ContactPersonNo);
		ExtentTestManager.getTest().log(Status.PASS, "Cleared Emergency Contact Person Number ");

		clear(locators.EmergencyCountryCode);
		ExtentTestManager.getTest().log(Status.PASS, "Cleared Emergency Country Code ");

		clear(locators.ContactEmail);
		ExtentTestManager.getTest().log(Status.PASS, "Cleared Emergency Contact Email Id ");

		input(locators.ContactPersonNm, ContactPersonName);
		ExtentTestManager.getTest().log(Status.PASS, "Entered Person Name ");
		Log.info("Entered Person Name ");

		input(locators.EmergencyCountryCode, "+91");
		ExtentTestManager.getTest().log(Status.PASS, "Entered Country Code ");
		Log.info("Entered Country Code ");

		input(locators.ContactPersonNo, ContactPersonNumber);
		ExtentTestManager.getTest().log(Status.PASS, "Entered Person Number ");
		Log.info("Entered Person Number ");

		input(locators.ContactEmail, "emergencyPerson@gmail.com");
		ExtentTestManager.getTest().log(Status.PASS, "Entered Email  ");
		Log.info("Entered Email");

		click(locators.ContactRelationship);
		ExtentTestManager.getTest().log(Status.PASS, "Select relationship  ");
		Log.info("Select relationship ");
	}

	public void HRNtfctonClickBtn() throws InterruptedException {
		ScrollUntilElementVisible(locators.SubmitBtn);
		Thread.sleep(2000);
		click(locators.HRNtfctnClickEditBtn);
		Thread.sleep(3500);
		ExtentTestManager.getTest().log(Status.PASS, "Clicked on edit of HR Notification ");
		Log.info("Clicked on edit of HR Notification ");
	}

	public boolean HRNtfctonIfDisplayedOrNot() throws InterruptedException {
		boolean flag1 = ElementDisplayed(locators.WeddingAnniversary);
		boolean flag2 = ElementDisplayed(locators.Bday);
		boolean flag3 = ElementDisplayed(locators.WorkAnnversary);
		boolean flag = flag1 & flag2 & flag3;
		ExtentTestManager.getTest().log(Status.PASS, "All Elements are Displayed ");
		Log.info("All Elements are displayed ");
		return flag;
	}

	public void ClickSubmitBtn() throws InterruptedException {
		click(locators.SubmitBtn);
		Thread.sleep(15000);
		ExtentTestManager.getTest().log(Status.PASS, "Clicked on Submit button ");
		Log.info("Clicked on Submit button ");
		Thread.sleep(5000);
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.PASS, "Submitted the changes ");
		Log.info("Submitted the changes ");
	}

}
