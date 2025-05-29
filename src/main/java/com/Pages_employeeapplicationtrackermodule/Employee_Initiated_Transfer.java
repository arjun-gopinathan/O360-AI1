
package com.Pages_employeeapplicationtrackermodule;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_EmployeeModule;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;
public class Employee_Initiated_Transfer extends Base_Class
{
	
	PageRepositary_EmployeeModule PageRepositary= new PageRepositary_EmployeeModule();
	
	public void clickonselfservice() throws InterruptedException 
	  {
	  click(PageRepositary.clickonselfservice);
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	     
	  }

	public void clickonemprequests() throws InterruptedException 
	  {
	  click(PageRepositary.clickonemprequests);
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	     
	    
	  }
	
	public void clickonempinitiatedtransfer() throws InterruptedException 
	  {
	  click(PageRepositary.clickonempinitiatedtransfer);
	  WaitForLoaderToDisappear();
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    
	  }

	
	
	public void slectempoffice(String EMPOFFICE) throws InterruptedException {

        //WaitForLoaderToDisappear();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});",driver.findElement(PageRepositary.slectempoffice));
        click(PageRepositary.slectempoffice);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table mb-0']/tbody/tr/td[1]"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        for (WebElement row : rows) {
               js.executeScript("arguments[0].scrollIntoView({block: 'center'});", row);
               if (row.getAttribute("innerHTML").trim().equalsIgnoreCase(EMPOFFICE)) {
                     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                     row.click();
                     ExtentTestManager.getTest().log(Status.PASS,"Office selected from dialogue box: " + row.getAttribute("innerHTML"));
                      Log.info("Office selected from dialogue box: " + row.getAttribute("innerHTML"));
                     break;
               }
        }

        click(PageRepositary.slectempofficedropdownok);

        // click(PageRepositary.slectempoffice);
        // driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        // click(PageRepositary.slectempofficedropdown);
        // driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        // click(PageRepositary.slectempofficedropdownok);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
 }



	
	
		public void slectempdateoftransfer(String dateoftransfer) throws InterruptedException 
		  {
		  click(PageRepositary.slectempdateoftransfer);
		  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		     input(PageRepositary.slectempdateoftransfer, dateoftransfer);
		  	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		  	handlePopupdate();
		  	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		  	 // click(PageRepositary.slectdateoftransferyes);
			  //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		     
		  }
		
		public void enterempcomments(String Comments) throws InterruptedException 
		  {
		  click(PageRepositary.enterempcomments);
		  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		     input(PageRepositary.enterempcomments, Comments);
		  	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		     
		     
		     
		  }
		public void empsubmit() throws InterruptedException 
		  {
		  click(PageRepositary.empsubmit);
		  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		  click(PageRepositary.submitok);
		  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		  click(PageRepositary.DesktopNot);
		     
		  }
	  
}
