package com.Pages_ExpenseModule;

import org.openqa.selenium.By;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_ExpenseModule;
import com.Page_Repositary.PageRepositary_LeaveModule;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;


public class Expense_ExpenseApproval extends Base_Class
{
	PageRepositary_ExpenseModule PageRepositary= new PageRepositary_ExpenseModule();
	
	
	 public boolean clickExpenseSection() throws InterruptedException {
		 click(PageRepositary.ExpenseModule1);
	        Thread.sleep(2000);
	       click(PageRepositary.ApprovalsSection);
	       Thread.sleep(1000);
	       click(PageRepositary.Approvals);
	       Thread.sleep(2000);
	        return true;
	    }
	 
	 public boolean clickOnExpenseNumber(String ExpenseNumber) throws InterruptedException {
		 click(By.xpath("//span[contains(text(),'"+ExpenseNumber+"')]"));
	        Thread.sleep(3000);
	     
	        return true;
	    }
	 
	 public boolean clickOnExpenseNumber1(String ExpenseNumber1) throws InterruptedException {
		 click(By.xpath("//span[contains(text(),'"+ExpenseNumber1+"')]"));
	        Thread.sleep(3000);
	     
	        return true;
	    }
	 
	 public boolean RejectButton() throws InterruptedException {
		 ScrollUntilElementVisible(PageRepositary.RejectButton);
		 Thread.sleep(1000);
		 click(PageRepositary.RejectButton);
		 Thread.sleep(1000);
		input(PageRepositary.EnterComments, "Rejected for Testing Reason");
	        Thread.sleep(1000);

	     
	      
	        return true;
	    }
	 
	 
	 public boolean clickRejectButton() throws InterruptedException {

	       ScrollUntilElementVisible(PageRepositary.clickOnReject);
			 Thread.sleep(1000);
			 click(PageRepositary.clickOnReject);
			 Thread.sleep(1000);
			 click(PageRepositary.RejectConfirmYes);
			 Thread.sleep(1000);
	        ExtentTestManager.getTest().log(Status.PASS, "Expense Rejected Successfully");
	      
	        return true;
	    }
	 
	 public boolean clickOnAproveButton() throws InterruptedException {

		 ScrollUntilElementVisible(PageRepositary.ApproveButton);
		 Thread.sleep(1000);
		 click(PageRepositary.ApproveButton);
		 Thread.sleep(1000);
		 ScrollUntilElementVisible(PageRepositary.EnterApproveComments);
		 Thread.sleep(1000);
		 input(PageRepositary.EnterApproveComments, "Approved");
		 Thread.sleep(1000);
		 click(PageRepositary.clickOnApprove);
		 Thread.sleep(1000);
        ExtentTestManager.getTest().log(Status.PASS, "Expense Approved Successfully");
	      
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
