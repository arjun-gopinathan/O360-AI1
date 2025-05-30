package com.Pages_ExpenseModule;

import org.openqa.selenium.By;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_ExpenseModule;
import com.Page_Repositary.PageRepositary_LeaveModule;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;


public class Expense_ExpenseRequest extends Base_Class
{
	PageRepositary_ExpenseModule PageRepositary= new PageRepositary_ExpenseModule();
	
	
	 public boolean clickExpenseSection() throws InterruptedException {
		 click(PageRepositary.timesheetSection);
	        Thread.sleep(3000);
	       click(PageRepositary.ExpenseModule);
	        return true;
	    }
	 
	 
	 public boolean ValidateLeaveModuleForm() throws InterruptedException 
		{
			Boolean flag1 = ElementDisplayed(PageRepositary.ExpenseDate);
			Boolean flag2 = ElementDisplayed(PageRepositary.ExpenseTitle);
			Boolean flag3 = ElementDisplayed(PageRepositary.ProjectSelection);
			Boolean flag4 = ElementDisplayed(PageRepositary.EnterDescription);
			Boolean flag5 = ElementDisplayed(PageRepositary.SelectCurrency);
			Boolean flag6 = ElementDisplayed(PageRepositary.ChooseFile);
			Boolean flag7 = ElementDisplayed(PageRepositary.BillDate);
			Boolean flag8 = ElementDisplayed(PageRepositary.ExpenseType);
			Boolean flag9 = ElementDisplayed(PageRepositary.EnterMerchant);
			Boolean flag10 = ElementDisplayed(PageRepositary.EnterCity);
			Boolean flag11 = ElementDisplayed(PageRepositary.ExpenseDescription);
			Boolean flag12 = ElementDisplayed(PageRepositary.EnterAmount);
			Boolean flag13 = ElementDisplayed(PageRepositary.SelectStatus);
			Boolean flag14 = ElementDisplayed(PageRepositary.ExpenseChooseFile);
			

			Boolean flag = flag1 & flag2 & flag3 & flag4 & flag5 & flag6 & flag7 & flag8 & flag9 & flag10 & flag11 & flag12 & flag13 & flag14;
			return flag;
		}
	 
	 public boolean ValidateMandatoryField() throws InterruptedException 
		{
		 click(PageRepositary.SaveButton);
		 Thread.sleep(1000);
			Boolean flag1 = ElementDisplayed(PageRepositary.ExpenseDate);
			Boolean flag2 = ElementDisplayed(PageRepositary.ExpenseTitle);
			Boolean flag3 = ElementDisplayed(PageRepositary.ProjectSelection);
			Boolean flag4 = ElementDisplayed(PageRepositary.EnterDescription);
			Boolean flag5 = ElementDisplayed(PageRepositary.SelectCurrency);
			Boolean flag6 = ElementDisplayed(PageRepositary.ChooseFile);
			Boolean flag7 = ElementDisplayed(PageRepositary.BillDate);
			Boolean flag8 = ElementDisplayed(PageRepositary.ExpenseType);
			Boolean flag9 = ElementDisplayed(PageRepositary.EnterMerchant);
			Boolean flag10 = ElementDisplayed(PageRepositary.EnterCity);
			Boolean flag11 = ElementDisplayed(PageRepositary.ExpenseDescription);
			Boolean flag12 = ElementDisplayed(PageRepositary.EnterAmount);
			Boolean flag13 = ElementDisplayed(PageRepositary.SelectStatus);
			Boolean flag14 = ElementDisplayed(PageRepositary.ExpenseChooseFile);
			

			Boolean flag = flag1 & flag2 & flag3 & flag4 & flag5 & flag6 & flag7 & flag8 & flag9 & flag10 & flag11 & flag12 & flag13 & flag14;
			return flag;
		}
	 
		
	 public boolean ExpenseDate(String fromYear, String fromMonth,String Day) throws InterruptedException 
		{
		 click(PageRepositary.ExpenseDate);
		 Thread.sleep(1000);
		 click(PageRepositary.selectMonthandYear);
		 Thread.sleep(1000);
		 click(By.xpath("//div[contains(text(),'"+fromYear+"')]"));
		 Thread.sleep(1000);
		 click(By.xpath("//div[contains(text(),'"+fromMonth+"')]"));
		 Thread.sleep(1000);
//		 //jsClick(By.xpath("//div[@class='cdk-overlay-backdrop mat-overlay-transparent-backdrop cdk-overlay-backdrop-showing']"));
//		 Thread.sleep(1000);
		 
		 try {
				//WaitForPageLoad();
				waitForElementClickable(By.xpath("//tbody/tr/td/div[contains(text(),'"+Day+"')]"));
				click(By.xpath("//tbody/tr/td/div[contains(text(),'"+Day+"')]"));
				//ExtentSuccessMessage("Successfully clicked FRS Authirization Form");
			} catch (Exception e) {
				Log.info("Unable to click on From Date" + e.getMessage());
			}

		 Thread.sleep(1000);
		
//			if(ElementDisplayed(PageRepositary.futureDate)) {
//					Log.info("Future date not allowed.");
//				} 
//			else {
//				Thread.sleep(1000);
//			}
				
			return true;
		 
		}
	 
	 public boolean BillDate(String billYear, String billMonth,String billDay) throws InterruptedException 
		{
		 click(PageRepositary.BillDate);
		 Thread.sleep(1000);
		 click(PageRepositary.selectMonthandYear);
		 Thread.sleep(1000);
		 click(By.xpath("//div[contains(text(),'"+billYear+"')]"));
		 Thread.sleep(1000);
		 click(By.xpath("//div[contains(text(),'"+billMonth+"')]"));
		 Thread.sleep(1000);
		waitForElementClickable(By.xpath("//tbody/tr/td/div[contains(text(),'"+billDay+"')]"));
		click(By.xpath("//tbody/tr/td/div[contains(text(),'"+billDay+"')]"));
				
			return true;
		 
		}
	 
	 
	 public boolean FillForm(String ExpenseTitle, String Project, String Description, String Currency, String filePath) throws InterruptedException 
		{
		 input(PageRepositary.ExpenseTitle, ExpenseTitle);
		 Thread.sleep(1000);
		 click(PageRepositary.ProjectSelection);
		 Thread.sleep(1000);
			
		 input(PageRepositary.ProjectSearch, Project);
		 Thread.sleep(1000);
		 
		click(PageRepositary.selectProj);
		click(PageRepositary.ProkjectSerachOk);
		Thread.sleep(1000);
		input(PageRepositary.EnterDescription, Description);
		Thread.sleep(1000);
		click(PageRepositary.SelectCurrency);
    	Thread.sleep(1000);
    	click(By.xpath("//option[contains(text(),'"+Currency+"')]"));
		Thread.sleep(1000);
		click(PageRepositary.SelectCurrency);
		Thread.sleep(1000);
		UploadFile(PageRepositary.ChooseFile, filePath);
		
		return true;
		 
		}
	 
	 public boolean LineItemFillForm(String Expense, String MerchantName, String CityName, String ExpenseDescription,String Amount,String ExpenseStatus,String filePath) throws InterruptedException 
		{

		 click(PageRepositary.ExpenseType);
		 Thread.sleep(1000);
			
		 input(PageRepositary.ExpenseSearch, Expense);
		 Thread.sleep(1000);
		 
		click(PageRepositary.selectProj);
		click(PageRepositary.ProkjectSerachOk);
		Thread.sleep(1000);
		input(PageRepositary.EnterMerchant, MerchantName);
		Thread.sleep(1000);
		input(PageRepositary.EnterCity, CityName);
		Thread.sleep(1000);
		input(PageRepositary.ExpenseDescription, ExpenseDescription);
		Thread.sleep(1000);
		input(PageRepositary.EnterAmount, Amount);
		Thread.sleep(1000);
		click(PageRepositary.SelectStatus);
    	Thread.sleep(1000);
    	click(By.xpath("//option[contains(text(),'"+ExpenseStatus+"')]"));
		Thread.sleep(1000);
		click(PageRepositary.SelectStatus);
    	Thread.sleep(1000);
		UploadFile(PageRepositary.ExpenseChooseFile, filePath);
		Thread.sleep(1000);
		return true;
		 
		}
	 
	 
	 public boolean ResetButton() throws InterruptedException {
		 click(PageRepositary.ResetButton);
	        Thread.sleep(3000);
	      
	        return true;
	    }
	 
	 public boolean AddButton() throws InterruptedException {
		 click(PageRepositary.AddButton);
	        Thread.sleep(3000);
	      
	        return true;
	    }
	 
	 public boolean RemoveLineItem() throws InterruptedException {
		 click(PageRepositary.lineRemove);
	        Thread.sleep(1000);
	      click(PageRepositary.lineRemoveYes);
	      Thread.sleep(2000);
	      ScrollUntilElementVisible(PageRepositary.SaveButton);
	      Thread.sleep(1000);
	        return true;
	    }
	 
	 public boolean EditButton() throws InterruptedException {
		 click(PageRepositary.EditButton);
	        Thread.sleep(1000);
	      click(PageRepositary.EditSaveButton);
	      Thread.sleep(2000);
	        return true;
	    }
	 
	 public boolean SaveButton() throws InterruptedException {
		 ScrollUntilElementVisible(PageRepositary.SaveButton);
		 Thread.sleep(1000);
		 click(PageRepositary.SaveButton);
	        Thread.sleep(3000);
	        ExtentTestManager.getTest().log(Status.PASS, "Expense Save Successfully");
	      
	        return true;
	    }
	 
	 public boolean clickOnExpenseNumber(String ExpenseNumber) throws InterruptedException {
		 click(By.xpath("//span[contains(text(),'"+ExpenseNumber+"')]"));
	        Thread.sleep(3000);
	     
	        return true;
	    }
	 
	 public boolean DeleteButton() throws InterruptedException {
		 ScrollUntilElementVisible(PageRepositary.deleteButton);
		 Thread.sleep(1000);
		 click(PageRepositary.deleteButton);
		 Thread.sleep(1000);
		 click(PageRepositary.deleteButtonYes);
	        Thread.sleep(3000);
	        ExtentTestManager.getTest().log(Status.PASS, "Expense Deleted Successfully");
	      
	        return true;
	    }
	 
	 public boolean AddNewButton() throws InterruptedException {

		 click(PageRepositary.clickOnAdd);
	        Thread.sleep(3000);
	        //ExtentTestManager.getTest().log(Status.PASS, "Expense Save Successfully");
	      
	        return true;
	    }
	 
	 public boolean SubmitButton() throws InterruptedException {
		 ScrollUntilElementVisible(PageRepositary.SubmiteButton);
		 Thread.sleep(1000);
		 click(PageRepositary.SubmiteButton);
	        Thread.sleep(3000);
	        ExtentTestManager.getTest().log(Status.PASS, "Expense Submitted Successfully");
	      
	        return true;
	    }
	 
	 public boolean closeButton() throws InterruptedException {

		 click(PageRepositary.closeButton);
	        Thread.sleep(3000);
	        //ExtentTestManager.getTest().log(Status.PASS, "Expense Save Successfully");
	      
	        return true;
	    }
}
