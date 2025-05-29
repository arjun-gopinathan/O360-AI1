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
public class Hr_Initiated_Transfer extends Base_Class
{
	PageRepositary_EmployeeModule PageRepositary= new PageRepositary_EmployeeModule();
	public void clickOnemp() throws InterruptedException 
	  {
		
		 ScrollUntilElementVisible(PageRepositary.clickOnemp);
		 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		click(PageRepositary.clickOnemp);
		 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	      
	  }
	public void clickonhrrequests() throws InterruptedException 
	  {
	  click(PageRepositary.clickonhrrequests);
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	     
	    
	  }
	public void clickonhrinitiatedtransfer() throws InterruptedException 
	  {
	
	  click(PageRepositary.clickonhrinitiatedtransfer);
		 WaitForLoaderToDisappear();
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	     
	    
	  }
	
	public void clickonhraddnew() throws InterruptedException 
	  {
	  click(PageRepositary.clickonhraddnew);
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	     
	     
	  }
	
	
	public void slectempname(String Employee) throws InterruptedException 
	  {
		
		
		
		

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});",driver.findElement(PageRepositary.slectempname));
        click(PageRepositary.slectempname);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
      //  WaitForLoaderToDisappear();

        click(PageRepositary.slectempnamesearch);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //click(PageRepositary.approvesearchtextbox);
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        clear(PageRepositary.slectempnamesearch);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        input(PageRepositary.slectempnamesearch, Employee);
     	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
     	 
     	 
    	 WebElement popupElement = driver.findElement(PageRepositary.searchedemp);
        // WaitForElementToBeVisible(PageRepositary.searchedemp);
         if (popupElement.isDisplayed()) {
        	 
        	  click(PageRepositary.searchedemp);
        	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        	  click(PageRepositary.slectempnamedropdownok);
        	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        	  
         }
         else {
             Log.info("Empolyee Name not present in the list");
             
             }
         
	    
	  }
	
	
	public void slectbusinessunit(String NewBusinessUnit) throws InterruptedException 
	  {
		
		  JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView({block: 'center'});",driver.findElement(PageRepositary.slectbusinessunit));
	        click(PageRepositary.slectbusinessunit);
	        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	      //  WaitForLoaderToDisappear();

	        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table mb-0']/tbody/tr/td[1]"));
	        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	        for (WebElement row : rows) {
	              js.executeScript("arguments[0].scrollIntoView({block: 'center'});", row);
	              if (row.getAttribute("innerHTML").trim().equalsIgnoreCase(NewBusinessUnit)) {
	            	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	                     row.click();
	                     ExtentTestManager.getTest().log(Status.PASS,"Business Unit is  selected from dialogue box: " + row.getAttribute("innerHTML"));
	                     Log.info("Business Unit is  selected from dialogue box: " + row.getAttribute("innerHTML"));
	                     break;
	              }
	        }

	  click(PageRepositary.slectbusinessunitdropdownok);
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	     
	     
	     
	  }
	
	public void slectoffice(String NewOffice) throws InterruptedException 
	  {
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});",driver.findElement(PageRepositary.slectoffice));
        click(PageRepositary.slectoffice);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
      //  WaitForLoaderToDisappear();

        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table mb-0']/tbody/tr/td[1]"));
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        for (WebElement row : rows) {
              js.executeScript("arguments[0].scrollIntoView({block: 'center'});", row);
              if (row.getAttribute("innerHTML").trim().equalsIgnoreCase(NewOffice)) {
            	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
                     row.click();
                     ExtentTestManager.getTest().log(Status.PASS,"New Office is selected from dialogue box: " + row.getAttribute("innerHTML"));
                     Log.info("New Office is selected from dialogue box: " + row.getAttribute("innerHTML"));
                     break;
              }
        }

	  click(PageRepositary.slectofficedropdownok);
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	     
	     
	  }
	
	
	public void checkiftransferrequestsubmitted(String empname) throws InterruptedException 
	  {
	  click(PageRepositary.approvesearch);
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  
	  
	  
	  
	  
	  boolean isCriteriaVisible = driver.findElement(PageRepositary.SearchColumn).isDisplayed();

	     if (isCriteriaVisible == false) {
	            // Click "Add Another Search Criteria" if the dropdown is not visible
	            Log.info("Clicking on Add Criteria Button");
	            click(PageRepositary.AddSearchCriteriaBtn);
	            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	            WaitForElementToBeVisible(PageRepositary.SearchColumn);
	           // wait.until(ExpectedConditions.visibilityOfElementLocated(PageRepositary.SearchColumn));
	            ExtentTestManager.getTest().log(Status.PASS, "Clicked on Add Another Search Criteria" + isCriteriaVisible);
	            Log.info("Clicked on Add Another Search Criteria" + isCriteriaVisible);
	     } else {
	            Log.info("continuing in dialog " + isCriteriaVisible);
	     }
	     
	  click(PageRepositary.approvesearchcategory);
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  
	 // click(PageRepositary.approvesearchcategoryempname);
	 //.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  
	  ScrollUntilElementVisible(PageRepositary.approvesearchcategoryempname);
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  click(PageRepositary.approvesearchcategoryempname);
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  
	  
	     input(PageRepositary.approvesearchtextbox, empname);
	  	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  	 click(PageRepositary.approvesearchbutton);
		  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  	 
	  	//handlePopupdate();
	  	//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  	 // click(PageRepositary.slectdateoftransferyes);
		  //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    
	    
	  }
	
		public void slectdateoftransfer(String dateoftransfer) throws InterruptedException 
		  {
		  click(PageRepositary.slectdateoftransfer);
		  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		     input(PageRepositary.slectdateoftransfer, dateoftransfer);
		  	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		  	handlePopupdate();
		  	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		  	 // click(PageRepositary.slectdateoftransferyes);
			  //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		     
		    
		  }
	  
		public void slectnewreportingto(String NewReportingTo) throws InterruptedException 
		  {
			  JavascriptExecutor js = (JavascriptExecutor) driver;
		        js.executeScript("arguments[0].scrollIntoView({block: 'center'});",driver.findElement(PageRepositary.slectnewreportingto));
		        click(PageRepositary.slectnewreportingto);
		        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		      //  WaitForLoaderToDisappear();

		        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table mb-0']/tbody/tr/td[1]"));
		        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		        for (WebElement row : rows) {
		              js.executeScript("arguments[0].scrollIntoView({block: 'center'});", row);
		              if (row.getAttribute("innerHTML").trim().equalsIgnoreCase(NewReportingTo)) {
		            	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		                     row.click();
		                     ExtentTestManager.getTest().log(Status.PASS,"Reporting To is selected from dialogue box: " + row.getAttribute("innerHTML"));
		                     Log.info("Reporting To is selected from dialogue box: " + row.getAttribute("innerHTML"));
		                     break;
		              }
		        }

		  click(PageRepositary.slectnewreportingtodropdownok);
		  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		     
		     
		  }
		
		public void slecttransfertype(String TransferType) throws InterruptedException 
		  {
			  JavascriptExecutor js = (JavascriptExecutor) driver;
		        js.executeScript("arguments[0].scrollIntoView({block: 'center'});",driver.findElement(PageRepositary.slecttransfertype));
		        click(PageRepositary.slecttransfertype);
		        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		      //  WaitForLoaderToDisappear();

		        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table mb-0']/tbody/tr/td[1]"));
		        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		        for (WebElement row : rows) {
		              js.executeScript("arguments[0].scrollIntoView({block: 'center'});", row);
		              if (row.getAttribute("innerHTML").trim().equalsIgnoreCase(TransferType)) {
		            	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		                     row.click();
		                     ExtentTestManager.getTest().log(Status.PASS,"Transfer Type is selected from dialogue box: " + row.getAttribute("innerHTML"));
		                     Log.info("Transfer Type is selected from dialogue box: " + row.getAttribute("innerHTML"));
		                     break;
		              }
		        }

		  click(PageRepositary.slecttransfertypedropdown);
		  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		    
		  }
		public void entercomments(String Comments) throws InterruptedException 
		  {
		  click(PageRepositary.entercomments);
		  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		     input(PageRepositary.entercomments, Comments);
		  	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		     
		     
		    
		  }
		
		public void submit() throws InterruptedException 
		  {
		  click(PageRepositary.submit);
		  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		  //click(PageRepositary.submitok);
		 // driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		     
		  }
	
	
	
	
}
