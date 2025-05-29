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

public class Transfer_Approvals extends Base_Class {
	PageRepositary_EmployeeModule PageRepositary= new PageRepositary_EmployeeModule();
	
	public void clickOnemp() throws InterruptedException 
	  {
		
		 ScrollUntilElementVisible(PageRepositary.clickOnemp);
		 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		click(PageRepositary.clickOnemp);
		 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	      
	  }
	public void clickonapprovals() throws InterruptedException 
	  {
	  click(PageRepositary.approvals);
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	     
	  }
	public void clickonemptransfer() throws InterruptedException 
	  {
	  click(PageRepositary.emptransfer);
	  WaitForLoaderToDisappear();
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	     
	     
	  }
	
	
	
	
	public void slectempcode(String EMPCODE) throws InterruptedException 
	  {
		
		  // WaitForElementToBeVisible(PageRepositary.searchedempcode);
		 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

      JavascriptExecutor js = (JavascriptExecutor) driver;
      //js.executeScript("arguments[0].scrollIntoView({block: 'center'});",driver.findElement(PageRepositary.slectempoffice));
    //  click(PageRepositary.slectempoffice);
     // driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
     WaitForLoaderToDisappear();
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

     
     
     click(PageRepositary.approvesearchtextbox);
     driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
     input(PageRepositary.approvesearchtextbox, EMPCODE);
  	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
  	 click(PageRepositary.approvesearchbutton);
  	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

  	
     
   //   List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table mb-0 ']/tbody/tr/td[1]/span"));
    //  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    //  for (WebElement row : rows) {
           // js.executeScript("arguments[0].scrollIntoView({block: 'center'});", row);
          //  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
          //  if (row.getText().trim().equalsIgnoreCase(EMPCODE)) {
          	//  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
                //   row.click();
                  // ExtentTestManager.getTest().log(Status.PASS,"Employee is selected from the list: " + row.getAttribute("innerHTML"));
                 //  Log.info("Employee is selected from the list: " + row.getAttribute("innerHTML"));
             //      break;
           // }
          //  else {
          //  Log.info("Empolyee Code not present in the list");
            
        //    }
    //  }

      //click(PageRepositary.slectempofficedropdownok);
		
	  //click(PageRepositary.slectempoffice);
	 // driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	 // click(PageRepositary.slectempofficedropdown);
	  //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	 // click(PageRepositary.slectempofficedropdownok);
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	     
	    
	  }
	
	public void enterapprovercomments(String Comments) throws InterruptedException 
	  {
	  click(PageRepositary.approvercomments);
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	     input(PageRepositary.approvercomments, Comments);
	  	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	     
	     
	     
	  }
	public void approve() throws InterruptedException 
	  {
		ScrollUntilElementVisible(PageRepositary.approvercomments);
		 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		 // click(PageRepositary.submitok);
	  click(PageRepositary.approvbutton);
	  WaitForLoaderToDisappear();
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  click(PageRepositary.approveyes);
	  WaitForLoaderToDisappear();
	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	     
	  }
	
	public void reject() throws InterruptedException 
	  {
		ScrollUntilElementVisible(PageRepositary.approvercomments);
		 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		 // click(PageRepositary.submitok);
	  click(PageRepositary.rejectbutton);
	  WaitForLoaderToDisappear();
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  click(PageRepositary.rejectyes);
	  WaitForLoaderToDisappear();
	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	     
	  }
}
