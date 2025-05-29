package com.test.ProjectModule;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
//import com.Pages_LeaveModule.Leave_LeaveRequest;
import com.Pages_ProjectModule.Project_Client;
import com.Pages_ProjectModule.Project_Project;
import com.Pages_ProjectModule.Project_Projecttypes;
import com.Pages_ProjectModule.Project_Projecttypesfixed;
import com.Utility.Log;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;


public class Allscenerios_Project_projecttypesfixed extends Base_Class{
       
       
       
       com.Utility.ExcelReader ExcelReader;
       Base_Class Base_Class;
       Log log;
       TestListener TestListener;
       com.Utility.ScreenShot screenShot;
       Project_Projecttypesfixed Project_Projecttypesfixed;
   	ExtentTest extenttest;
       private static By userDropDown = By.xpath("//div[@id='userDropdown']/h4");
       private static By L_signout = By.xpath("//button[@class='dropdown-item ' and contains(text(),'Sign out')]");
       
       
       @BeforeSuite
       public void reference() {
              ExcelReader = new com.Utility.ExcelReader("ProjectModule");
              log = new Log();
              TestListener = new TestListener();
              screenShot = new com.Utility.ScreenShot(null);
              Base_Class = new Base_Class();
              
              Project_Projecttypesfixed  = new Project_Projecttypesfixed();

       }
       
//     public static void ScrollUntilElementVisible(By locator)
//     { 
       //     WebElement element = driver.findElement(locator);
       //     JavascriptExecutor js = (JavascriptExecutor) driver;
       //     js.executeScript("arguments[0].scrollIntoView();", element);
       //}
       @BeforeMethod
      	public void setupTest(Method method) throws Exception {
      		// Start a new ExtentTest for the current test method
      		extenttest = ExtentTestManager.startTest(method.getName()).assignCategory("Project project types fixed");		
      	}
       @Test(dataProvider = "TestData")
       public void RUNALL(Map<Object, Object> testdata, ITestContext context) throws IOException, InterruptedException {

              
              try {

                     if (testdata.get("Run").toString().equalsIgnoreCase("Yes")) {
                           // TC_BAC_Login_Positive case
                           ExtentTestManager.startTest(testdata.get("TestScenario").toString());
                           Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");
                           context.setAttribute("fileName", "Login");
                           String Username = testdata.get("Username").toString();
                           Base_Class.SetUp(Username);
                           Thread.sleep(2000);
                           handlePopupCovid();
                           handlePopupDesktop();
                           ExtentTestManager.getTest().log(Status.PASS,
                                         "Application Login" + com.BasePackage.Base_Class.Pagetitle);
                           Log.info("Login successful !");
                           Thread.sleep(2000);
                           
                           
                           boolean flag1 = Project_Projecttypesfixed.clickOnProjectsubModule(testdata, context);
                           Thread.sleep(1000);
                          // Logout
                           ExtentTestManager.startTest("Logout."); 
                           context.setAttribute("fileName", "Logout"); 
                           click(userDropDown);
                           click(L_signout);
                           
                           Thread.sleep(2000);
                           driver.quit();
                           ExtentTestManager.getTest().log(Status.PASS, "Application Logout");
                           Log.info("Logout is done");



                           // EndTest
                           System.out.println(("*** Test Suite " +  testdata.get("TestScenario").toString()+ " ending ***"));
                           ExtentTestManager.endTest();
                           ExtentManager.getInstance().flush();
                           Log.info("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***");

                     }

              }
              catch (Exception e) {
                     System.out.println("*** Test execution " +  testdata.get("TestScenario").toString() + " failed...");
                     Log.error("*** Test execution " +  testdata.get("TestScenario").toString() + " failed...");
                     Log.error("" + e.getMessage());
                     String fileName = (String) context.getAttribute("fileName");

                     try {
                           File file = new com.Utility.ScreenShot(driver).takeScreenShot(fileName, testdata.get("TestScenario").toString());
                           ExtentTestManager.getTest().fail(e.getMessage(),
                                         MediaEntityBuilder.createScreenCaptureFromPath(file.toString()).build());
                     } catch (Exception e1) {
                           System.out.println("File not found " + e1);
                     }
                     ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");

                     // Logout
                     context.setAttribute("fileName", "Logout");
                     //driver.quit();
                     ExtentTestManager.getTest().log(Status.PASS, "Application Logout");
                     Log.info("Logout is done");

                     // EndTest
                     System.out.println(("*** Test Suite " +  testdata.get("TestScenario").toString() + " ending ***"));
                     ExtentTestManager.endTest();
                     ExtentManager.getInstance().flush();
                     Log.info("*** Test Suite " +  testdata.get("TestScenario").toString() + " ending ***");
              }
              catch (AssertionError e) {
                     System.out.println("*** Test execution " +  testdata.get("TestScenario").toString() + " failed...");
                     Log.error("*** Test execution " +  testdata.get("TestScenario").toString() + " failed...");
                     Log.error("" + e.getMessage());
                     String fileName = (String) context.getAttribute("fileName");

                     try {
                           File file = new com.Utility.ScreenShot(driver).takeScreenShot(fileName, testdata.get("TestScenario").toString());
                           ExtentTestManager.getTest().fail(e.getMessage(),
                                         MediaEntityBuilder.createScreenCaptureFromPath(file.toString()).build());
                     } catch (Exception e1) {
                           System.out.println("File not found " + e1);
                     }
                     ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");

                     // Logout
                     context.setAttribute("fileName", "Logout");
                     //driver.quit();
                     ExtentTestManager.getTest().log(Status.PASS, "Application Logout");
                     Log.info("Logout is done");

                     // EndTest
                     System.out.println(("*** Test Suite " +  testdata.get("TestScenario").toString() + " ending ***"));
                     ExtentTestManager.endTest();
                     ExtentManager.getInstance().flush();
                     Log.info("*** Test Suite " +  testdata.get("TestScenario").toString() + " ending ***");
              }

       }

       @DataProvider(name = "TestData")
       public static Object[][] gettestdate() throws IOException{

              Object[][] objectarry=null;
              java.util.List<Map<String,String>> completedata=com.Utility.ExcelReader.getdata();

              objectarry=new Object[completedata.size()][1];

              for(int i=0;i<completedata.size();i++) {
                     objectarry[i] [0]= completedata.get(i);
              }
              return objectarry;

       }
}

