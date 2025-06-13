package com.BasePackage;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.print.DocFlavor.STRING;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Locators_PreBoardingUS.Locators_HomePage;
import com.Page_Repositary.PageRepositary_EmployeeModule;
import com.Utility.ExcelReader;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class {
	PageRepositary_EmployeeModule Locators=new PageRepositary_EmployeeModule();
	Locators_HomePage locators = new Locators_HomePage();
//	Locators_Approve_Process locators = new Locators_Approve_Process();
	public static RemoteWebDriver driver = null;

	public static WebDriver getDriver() {
		return driver;
	}

	private static By L_username = By.xpath("//input[@name='Username' and @placeholder='Username']");
	private static By L_password = By.xpath("//input[@name='Password' and @placeholder='Password']");
	private static By L_SignIn = By.xpath("//button[@type='submit']");
	
	public static By L_BusyAnimation = By.xpath("//*[@id='pageLoader']|//*[@id='pojqxLoader']|//*[@id='djqxLoader']|//*[@id='njqxLoader']");
    public static By loader = By.xpath("//div[contains(@class, 'spinner')]");
   
	public By DesktopNot = By.xpath("//button[text()='OK']");
	public By CovidPopup_RemindMeLaterBtn = By.xpath("//div/button[1][text()=' Remind Me Later']");
	//private static By L_LogOut= By.xpath("//div[@class='user position ng-tns-c3-15 ng-star-inserted']");
	//private static By L_LogAlert= By.xpath("//button[text()='Sign out']");
	public By home = By.xpath("//div[@class='main-header']//div[@class='logo']");
	public static String Pagetitle;

	public static Properties configloader() throws IOException {
		FileInputStream File = new FileInputStream(".\\src\\test\\resources\\config.properties");
		Properties properties = new Properties();
		properties.load(File);
		return properties;
	}
	public WebElement waitForElementClickable(By by) {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	        return wait.ignoring(StaleElementReferenceException.class)
	                   .until(ExpectedConditions.elementToBeClickable(by));
	    } catch (Exception e) {
	        Log.info(e.getMessage());
	    }
	    return null;
	}
	public static void ElementToBeVisible(By element) {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	    } catch (Exception e) {
	        Log.info(e.getMessage());
	    }
	}
	public void ifemptbelongstootherbu() {
        try {
               WebElement popupElement = driver.findElement(Locators.slectempdateoftransferyes);
               WaitForElementToBeVisible(Locators.slectempdateoftransferyes);
               if (popupElement.isDisplayed()) {
                     System.out.println("Popup displayed for Employee belongs to other BU... Clicking Yes");
                     driver.findElement(Locators.slectempdateoftransferyes).click();
                     WaitForLoaderToDisappear();
                     ExtentTestManager.getTest().log(Status.PASS, "Handled Popup displayed for Employee belongs to other BU");
                     Log.info("Employee belongs to other BU Popup");
                    // click(DesktopNot);
               }
        } catch (Exception e) {
               System.out.println("Employee belongs to other BU Popup is not displayed");
        }
 }
	public static void waitForSpinnerToDisappear(WebDriver driver, int timeoutMinutes, int pollingSeconds) {
		Wait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofMinutes(timeoutMinutes)) // Max
				.pollingEvery(Duration.ofSeconds(pollingSeconds)) // Polling interval
				.ignoring(NoSuchElementException.class) // Ignore if spinner is not found
				.ignoring(StaleElementReferenceException.class); // Handle dynamic elements
		fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(loader)); // Wait for spinner to disappear
	}
	public void handlePopupdate() {
        try {
               WebElement popupElement = driver.findElement(Locators.slectempdateoftransferyes);
              // WaitForElementToBeVisible(Locators.slectempdateoftransferyes);
               if (popupElement.isDisplayed()) {
            	  // driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
                     System.out.println("Popup displayed for Date Selection.. Clicking OK");
                     driver.findElement(Locators.slectempdateoftransferyes).click();
                    //WaitForLoaderToDisappear();
                     driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
                     ExtentTestManager.getTest().log(Status.PASS, "Handled Date Popup");
                     Log.info("Handling Date Selection Popup");
               }
        } catch (Exception e) {
               System.out.println("Popup is not displayed for Date Selection");
        }
 }
	public static void checkDropdown(By dropdownLocator) {
		try {
			// Set implicit wait for general element handling
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			// Wait up to 2 minutes for the dropdown to be enabled and have values
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));

			boolean isDropdownReady = wait.until(d -> {
				WebElement dropdownElement = d.findElement(dropdownLocator);
				Select dropdown = new Select(dropdownElement);
				List<WebElement> options = dropdown.getOptions();

				return dropdownElement.isEnabled() && !options.isEmpty();
			});

			if (isDropdownReady) {
				System.out.println("Dropdown has values and is enabled. Continuing execution...");
			} else {
				throw new RuntimeException("Test failed: Dropdown is empty or disabled after waiting for 2 minutes!");
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			throw new RuntimeException("Dropdown check failed due to an exception.");
		}
	}


	public static void SignInAsEmployee(String userName) throws InterruptedException, IOException {
		// Fetch the employee password from properties or test data (assuming it is
		// stored)
		String password = configloader().getProperty("Password");
		// Login with the provided username and password
		input(L_username, userName);
		input(L_password, password);
		click(L_SignIn);
		ExtentTestManager.getTest().log(Status.PASS, "Successfully logged in as employee: " + userName);
		Log.info("Successfully logged in as employee: " + userName);
		Base_Class base_Class = new Base_Class();
		base_Class.handlePopupCovid();
		base_Class.handlePopupDesktop();
	}
	public static void SetUp(String UserName) throws IOException, InterruptedException {

		String Browser = configloader().getProperty("Browser");
		String Url = configloader().getProperty("URL");
//		String UserName = configloader().getProperty("Username");
		String Password = configloader().getProperty("Password");
		
//		String excelFilePath = ".\\src\\test\\resources\\TestData.xlsx";
//		int rowIndex = 1;
//	    int cellIndex = 2;
//	    String UserName = ExcelReader.getUsernameFromExcel(excelFilePath, sheetName, rowIndex, cellIndex);

		switch (Browser.toUpperCase()) {
		case "CHROME":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-extensions");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
			break;
		case "FIREFOX":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			System.err.println("The Driver is not defined");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		Log.info("Driver has initialized successfully for " + Browser + "browser");
		driver.get(Url);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(9000);
		Pagetitle = driver.getTitle();
		Log.info("Title is displayed : " + Pagetitle);
		input(L_username, UserName);
		input(L_password, Password);
		click(L_SignIn);
		Log.info("Successfullly login");
		Thread.sleep(4000);
	}
public  void SetUp1() throws IOException, InterruptedException {
		
		String Browser = configloader().getProperty("Browser");
		String Url = configloader().getProperty("URL");
		String UserName = configloader().getProperty("UserName");
		String Password = configloader().getProperty("Password");
		switch (Browser.toUpperCase()) {

		case "CHROME":

			ChromeOptions options = new ChromeOptions();
			//options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
			options.addArguments("--disable-extensions");
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\linita.shivalkar\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);		
			break;

		case "FIREFOX":

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();			
			break;

		default:
			System.err.println("The Driver is not defined");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		Log.info("Driver has initialized successfully for "+Browser+"browser");
		driver.get(Url);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(9000);
		Pagetitle = driver.getTitle();
		Log.info("Title is displayed : "+Pagetitle);
		input(L_username, UserName);
		input(L_password, Password);
		click(L_SignIn);
//		Thread.sleep(4000);
		WaitForElementToBeVisible(home);
		handlePopupCovid();
		click(DesktopNot);
		Thread.sleep(1000);


	}
	public void ZoomOut() throws InterruptedException, AWTException {
		// Zoom out to 67%
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='75%'");
		ExtentTestManager.getTest().log(Status.PASS, "Zoomed page to 75%");
		Log.info("Zoom page to 75%");
	}

	public void verifySuccessfulLogin() throws InterruptedException {
		Thread.sleep(2000);
		Log.info("Validating successful login");
		String title = driver.getTitle().toString();
		if (title.equals("Organization 360")) {
			System.out.println(title);
			ExtentTestManager.getTest().log(Status.PASS, "Successful login");
		} else {
			System.out.println("error in login");
			ExtentTestManager.getTest().log(Status.FAIL, "Failed to Login");
		}
	}

	public void validateDashBoard() throws InterruptedException {
		Thread.sleep(2000);
		String exptectedTxt = "Dashboard";
		Thread.sleep(2000);
		String actualTxt = driver.findElement(locators.dashBoard).getText().toString();
		Assert.assertEquals(exptectedTxt, actualTxt, " User is still into Login Page");
		ExtentTestManager.getTest().log(Status.PASS, "Verifying dashboard is displayed successfully");
	}

	public static void input(By element, String Value) throws InterruptedException {
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait2.until(ExpectedConditions.presenceOfElementLocated(element)).sendKeys(Value);
	}

	public static void click(By element) throws InterruptedException {
		//Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		Thread.sleep(2000);
	}

	public static void select(String value, By element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		Select selWeekDayDropDown = new Select(driver.findElement(element));
		selWeekDayDropDown.selectByVisibleText(value);
	}

	public static void clear(By element) throws InterruptedException {
//		//WebDriverWait wait = new WebDriverWait(driver, 30);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element)).clear();
		Thread.sleep(2000);
	}

	public static void AcceptAlert() {
		driver.switchTo().alert().accept();
		// driver.switchTo().alert().dismiss();

	}

	public static void INclick(By element) throws InterruptedException {
		Thread.sleep(2000);
		// WebDriverWait wait = new WebDriverWait(driver, 60);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
		Thread.sleep(2000);
	}

	public static void SwitchToFrame(By frameName) { // WebDriverWait wait = new
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));
	}

	public static void ScrollUntilElementVisible(By locator) {

		WebElement element = driver.findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);

	}

	public static boolean ElementDisplayed(By locator) throws InterruptedException {
		//Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		WebElement element = driver.findElement(locator);
		Boolean flag = element.isDisplayed();
		return flag;
	}
	
	public static boolean inVisiblityOfElement(By locator, int time) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		WebElement element = driver.findElement(locator);
		Boolean flag = element.isDisplayed();
		return flag;
	}
	
	public static boolean ElementEnabled(By locator) throws InterruptedException {
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		WebElement element = driver.findElement(locator);
		Boolean flag = element.isEnabled();
		return flag;
	}

	public static void UploadFile(By locator) {
		WebElement uploadElement = driver.findElement(locator);
		String path = System.getProperty("user.dir");
		Log.info("path is :" + path);
		// System.out.Directory.GetParent(this.GetType().Assembly.Location).ToString();
		uploadElement.sendKeys(path);
	}
	public static void UploadFile(By locator, String path)
	{
		WebElement uploadElement = driver.findElement(locator);
		String path1=System.getProperty("user.dir");
		Log.info("path is :" + path1);
		uploadElement.sendKeys(path1 + path);
		
	}
	public static Boolean ElementEnableOrDisable(By locator) {
		WebElement element = driver.findElement(locator);
		Boolean flag = element.isEnabled();
		return flag;
	}

	public static boolean CheckElementDisable(By locator) { // disable
		WebElement element = driver.findElement(locator);
		Boolean flag = element.isEnabled();
		if (flag == false) {
			flag = true;
		} else if (flag == true)
			flag = false;
		return flag;
	}

	public static void Hover(By element) throws InterruptedException {
		WebElement element1 = driver.findElement(element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element1).perform();
	}

	public void handlePopupCovid() {
		try {
			WebElement popupElement = driver.findElement(locators.PopupDisplayedCovid);
			if (popupElement.isDisplayed()) {
				Log.info("Popup displayed for COVID.. Clicking OK");
				driver.findElement(locators.OkBtnCovid).click();
				ExtentTestManager.getTest().log(Status.PASS, "Handled Vaccination Popup");
				Log.info("Handing Vaccination Popup");
			}
		} catch (Exception e) {
			Log.info("Popup is not displayed for COVID");
		}
	}

	public void handlePopupDesktop() {
		try {
			WebElement popupElement = driver.findElement(locators.PopupDisplayedDesktop);
			if (popupElement.isDisplayed()) {
				Log.info("Popup displayed for Desktop.. Clicking OK");
				driver.findElement(locators.OkBtnDesktop).click();
				ExtentTestManager.getTest().log(Status.PASS, "Handled Desktop Notification Popup");
				Log.info("Handing Desktop Notification Popup");
			}
		} catch (Exception e) {
			Log.info("Popup is not displayed for desktop");
		}
	}

	public static void Signout() throws InterruptedException {
		By userDropDown = By.xpath("//h4[@class='username desktop-username']");
		By L_signout = By.xpath("//button[normalize-space()='Sign out']");
		click(userDropDown);
		click(L_signout);
		ExtentTestManager.getTest().log(Status.PASS, "Successfully logged out");
		Log.info("Successfully logged out");
	}

	public static void SignInAsEmployee() throws InterruptedException, IOException {

		String UserName = configloader().getProperty("Username");
		String Password = configloader().getProperty("Password");
		input(L_username, UserName);
		input(L_password, Password);
		click(L_SignIn);
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.PASS, "Successfully logged In as Employee");
		Log.info("Successfully logged In as Employeee");
	}

	public static void tearDown() {
		driver.quit();
	}

	public void ClearingLetterByLetter(By locator, int length) throws InterruptedException {
		WebElement InputField = driver.findElement(locator);
		for (int i = 0; i < length; i++) {
			InputField.sendKeys(Keys.BACK_SPACE); // Deletes one character
			Thread.sleep(1000); // Wait for suggestions to update
		}
	}

	public String fetchingProjectMnr() throws InterruptedException {
		By ClickOnProfileDd = By.xpath("//*[@id=\"userDropdown\"]/h4");
		By ClickOnProfileLink = By.xpath("//button[contains(.,'Profile')]");
		By reportingTo = By.xpath("//div[contains(@class,'profile-wrap')]//div[@class='reportingto']");
		click(ClickOnProfileDd);
		click(ClickOnProfileLink);

		String Name = driver.findElement(reportingTo).getAttribute("value");
		// Split the name into parts
		String[] nameParts = Name.split(" ");

		// Ensure the name contains exactly two parts
		if (nameParts.length != 2) {
			throw new IllegalArgumentException("Name must contain exactly two words");
		}

		String str1 = nameParts[0];
		String str2 = nameParts[1];

		// Concatenate the strings with a '.' in between
		String ReportingMngName = str1 + "." + str2;
		Log.info(ReportingMngName);
		return ReportingMngName;

	}

		public static void WaitForElementToBeVisible(By by) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
		}
	
		public static void WaitForElementToBeClickable(By by) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			wait.until(ExpectedConditions.elementToBeClickable(by));
		}
	
		public static void WaitForLoaderToDisappear() throws InterruptedException {

			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
				wait.pollingEvery(Duration.ofSeconds(10));
				wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
			} catch (Exception e) {
				
			}

		}

	public static void JavascriptClick(By by, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", driver.findElement(by));
	}
	
	public static String generateRandomName() {
        int nameLength = 4;
        StringBuilder randomName = new StringBuilder(nameLength);
        Random random = new Random();

        for (int i = 0; i < nameLength; i++) {
            char randomChar = (char) ('A' + random.nextInt(26));
            randomName.append(randomChar);
        }
        return randomName.toString();
    }
	
	
	public static String generateRandomEmail() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String domain = "@example.com"; // You can change the domain if needed

        Random random = new Random();
        StringBuilder email = new StringBuilder();

 
        int usernameLength = 4 + random.nextInt(5);
        for (int i = 0; i < usernameLength; i++) {
            email.append(alphabet.charAt(random.nextInt(alphabet.length())));
        }

        int numberCount = 2 + random.nextInt(3);
        for (int i = 0; i < numberCount; i++) {
            email.append(numbers.charAt(random.nextInt(numbers.length())));
        }

        // Append the domain
        email.append(domain);

        return email.toString();
    }
	
	public static String generateRandomContactNumber() {
        Random random = new Random();
        
        int firstDigit = random.nextInt(9) + 1; 
        StringBuilder contactNumber = new StringBuilder();
        contactNumber.append(firstDigit);
        
        for (int i = 0; i < 9; i++) {
            contactNumber.append(random.nextInt(10)); 
        }
        return contactNumber.toString();
    }
	
	public static void smoothScrollIntoView(By locator) {
	    WebElement element = driver.findElement(locator);
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
	}
	
	public static void scrollIntoView(By locator) {
	    WebElement element = driver.findElement(locator); // Find the element
	    JavascriptExecutor js = driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public static String getInputText(By element) throws InterruptedException {
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		String value = wait2.until(ExpectedConditions.presenceOfElementLocated(element)).getAttribute("value");
		return value;
	}
	
	public static void doubleClick(By element) {
		Actions act = new Actions(driver);
		WebElement btnElement = driver.findElement(element);
		act.doubleClick(btnElement).perform();
		
	}
	
	
}
