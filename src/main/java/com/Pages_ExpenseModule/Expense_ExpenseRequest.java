package com.Pages_ExpenseModule;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_ExpenseModule;
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
	 
		
	 public boolean ExpenseDate(String fromYear, String fromMonth,String day) throws InterruptedException {
		 click(PageRepositary.ExpenseDate);
		 click(PageRepositary.selectMonthandYear);
		 click(PageRepositary.year(fromYear));
		 click(PageRepositary.month(fromMonth));
		 click(PageRepositary.date(day));
				
		 return true;
	 }
	 
	 public boolean BillDate(String billYear, String billMonth,String billDay) throws InterruptedException {
		 click(PageRepositary.BillDate);
		 click(PageRepositary.selectMonthandYear);
		 click(PageRepositary.year(billYear));
		 click(PageRepositary.month(billMonth));
		 click(PageRepositary.date(billDay));
				
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
		click(PageRepositary.ProjectSerachOk);
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
		click(PageRepositary.ProjectSerachOk);
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
	 
	 public boolean projectSelect(String projectName) throws InterruptedException {
		 click(PageRepositary.ProjectSelection);
		 input(PageRepositary.ProjectSearch, projectName);
		 click(PageRepositary.projectNameSelect(projectName));
		 click(PageRepositary.ProjectSerachOk);
		 return true;
	 }
	 
	 public boolean ExpenseTypeSelect(String expType) throws InterruptedException {
		 click(PageRepositary.ExpenseType);
		 input(PageRepositary.ProjectSearch, expType);
		 click(PageRepositary.projectNameSelect(expType));
		 click(PageRepositary.ProjectSerachOk);
		 return true;
	 }
	 
	 public String getExpNumber() throws InterruptedException {
		 return getInputText(PageRepositary.exp_expNumber);
	 }
	 
	 
	 public boolean validate1(String year, String month, String day, String project,
			 String currency, String expenseType, String amount, String status, String filePath) throws InterruptedException {
		 click(PageRepositary.timesheetSection);
		 click(PageRepositary.myExpense);
		 ExpenseDate(year, month, day);
		 input(PageRepositary.ExpenseTitle, "Data");
		 projectSelect(project);
		 input(PageRepositary.EnterDescription, "description");
		 select(currency, PageRepositary.SelectCurrency);
		 BillDate(year, month, day);
		 ExpenseTypeSelect(expenseType);
		 input(PageRepositary.EnterMerchant, "data");
		 input(PageRepositary.EnterCity, "city");
		 input(PageRepositary.ExpenseDescription, "description");
		 input(PageRepositary.EnterAmount, amount);
		 select(status, PageRepositary.SelectStatus);
		 UploadFile(PageRepositary.ExpenseChooseFile, filePath);
		 JavascriptClick(PageRepositary.AddButton, driver);
		 
		 boolean flag = ElementDisplayed(PageRepositary.exp_expNumber);
		 
		 return flag;
	 }
	 
	 public Map<String, Object> validate2() throws InterruptedException {
		 
		 String expNumber = getExpNumber();
		 JavascriptClick(PageRepositary.SaveButton, driver);
		 boolean flag = ElementDisplayed(PageRepositary.exp_saveMsg);

		 Map<String, Object> result = new HashMap<>();
		 result.put("flag", flag);
		 result.put("expNumber", expNumber);
		 return result;
	}
	 
	 public boolean validate3(String expNumber) throws InterruptedException {
		 click(PageRepositary.newRequest);
		 click(PageRepositary.saved);
		 click(PageRepositary.searchIcon);
		 select(" Expense Number ", PageRepositary.searchCol);
		 input(PageRepositary.searchInput, expNumber);
		 click(PageRepositary.searchBtn);
		 click(PageRepositary.expNumber);
		 JavascriptClick(PageRepositary.submit, driver);
		 
		 boolean flag = ElementDisplayed(PageRepositary.exp_submittMsg);
		 
		 return flag;
		 
	}
	 
	 public boolean validate4(String expNumber) throws InterruptedException {
		 click(PageRepositary.newRequest);
		 click(PageRepositary.submitted);
		 click(PageRepositary.searchIcon);
		 select(" Expense Number ", PageRepositary.searchCol);
		 input(PageRepositary.searchInput, expNumber);
		 click(PageRepositary.searchBtn);
		 
		 boolean flag = ElementDisplayed(PageRepositary.expNumber);
		 
		 return flag;
		 
	}
	 
	 public boolean validate5(String firstLevelUserName, String password, String expNumber) throws InterruptedException {
		input(PageRepositary.username, firstLevelUserName);
		input(PageRepositary.password, password);
		click(PageRepositary.signin);
		
		try {
			 click(PageRepositary.remindMe);
		 } catch (Exception e) { }



		
		click(PageRepositary.expenses);
		click(PageRepositary.ApprovalsSection);
		click(PageRepositary.expensesApproval);
		
		click(PageRepositary.searchIcon);
		select(" Expense Number ", PageRepositary.searchCol);
		input(PageRepositary.searchInput, expNumber);
		click(PageRepositary.searchBtn);
		click(PageRepositary.expNumber);
		input(PageRepositary.approveComment, "Approved");
		JavascriptClick(PageRepositary.approveBtn, driver);
		 
		 boolean flag0 = ElementDisplayed(PageRepositary.exp_ApproveMsg);
		 
		click(PageRepositary.approved);
		click(PageRepositary.searchIcon);
		select(" Expense Number ", PageRepositary.searchCol);
		input(PageRepositary.searchInput, expNumber);
		click(PageRepositary.searchBtn);
		 
		boolean flag1 = ElementDisplayed(PageRepositary.exp_empNum(expNumber));
		 
		boolean flag = flag0 && flag1;
		 
		return flag;
		 
	}
	 
	 public boolean validate6(String secondLevelUserName, String pwd, String expNumber) throws InterruptedException {
		 
			input(PageRepositary.username, secondLevelUserName);
			input(PageRepositary.password, pwd);
			click(PageRepositary.signin);
				
			 try {
				click(PageRepositary.error);
			} catch (Exception e) {
				// TODO: handle exception
			}
			 try {
				 click(PageRepositary.remindMe);
			 } catch (Exception e) { }
			
			click(PageRepositary.expenses);
			click(PageRepositary.ApprovalsSection);
			click(PageRepositary.expensesApproval);
			
			click(PageRepositary.searchIcon);
			select(" Expense Number ", PageRepositary.searchCol);
			input(PageRepositary.searchInput, expNumber);
			click(PageRepositary.searchBtn);
			click(PageRepositary.expNumber);
			input(PageRepositary.approveComment, "Approved");
			JavascriptClick(PageRepositary.approveBtn, driver);
			 
			 boolean flag0 = ElementDisplayed(PageRepositary.exp_ApproveMsg);
			 
			click(PageRepositary.approved);
			click(PageRepositary.searchIcon);
			select(" Expense Number ", PageRepositary.searchCol);
			input(PageRepositary.searchInput, expNumber);
			click(PageRepositary.searchBtn);
			 
			boolean flag1 = ElementDisplayed(PageRepositary.exp_empNum(expNumber));
			 
			boolean flag = flag0 && flag1;
			 
			return flag;
			 
		}
	 
     public boolean validate7(String thirdLevelUserName, String pwd, String expNumber) throws InterruptedException {
		 
			input(PageRepositary.username, thirdLevelUserName);
			input(PageRepositary.password, pwd);
			click(PageRepositary.signin);
			try {
				 click(PageRepositary.remindMe);
			 } catch (Exception e) { }
			
			click(PageRepositary.expenses);
			WaitForElementToBeVisible(PageRepositary.ApprovalsSection);
			click(PageRepositary.ApprovalsSection);
			WaitForElementToBeVisible(PageRepositary.expensesApproval);
			click(PageRepositary.expensesApproval);
			
			click(PageRepositary.searchIcon);
			select(" Expense Number ", PageRepositary.searchCol);
			input(PageRepositary.searchInput, expNumber);
			click(PageRepositary.searchBtn);
			click(PageRepositary.expNumber);
			input(PageRepositary.approveComment, "Approved");
			JavascriptClick(PageRepositary.approveBtn, driver);
			 
			 boolean flag0 = ElementDisplayed(PageRepositary.exp_ApproveMsg);
			 
			click(PageRepositary.approved);
			click(PageRepositary.searchIcon);
			select(" Expense Number ", PageRepositary.searchCol);
			input(PageRepositary.searchInput, expNumber);
			click(PageRepositary.searchBtn);
			 
			boolean flag1 = ElementDisplayed(PageRepositary.exp_empNum(expNumber));
			 
			boolean flag = flag0 && flag1;
			 
			return flag;
			 
		}
     
       public boolean validate8(String username, String pwd, String expNumber) throws InterruptedException {
		 
			 input(PageRepositary.username, username);
			 input(PageRepositary.password, pwd);
			 click(PageRepositary.signin);
			 try {
				 click(PageRepositary.remindMe);
			 } catch (Exception e) { }
			
			 click(PageRepositary.timesheetSection);
			 click(PageRepositary.myExpense);
		 
		 	click(PageRepositary.approvedTab);
			
			click(PageRepositary.searchIcon);
			select(" Expense Number ", PageRepositary.searchCol);
			input(PageRepositary.searchInput, expNumber);
			click(PageRepositary.searchBtn);
			 
			boolean flag = ElementDisplayed(PageRepositary.exp_empNum(expNumber));
			 
			return flag;
		}
       
       public boolean validate9(String billVerificationUserName, String pwd, String billVerificationStatus, String expNumber) throws InterruptedException {
  		 
			 input(PageRepositary.username, billVerificationUserName);
			 input(PageRepositary.password, pwd);
			 click(PageRepositary.signin);
			 try {
				 click(PageRepositary.remindMe);
			 } catch (Exception e) { }
			
			 click(PageRepositary.expenses);
			 click(PageRepositary.ApprovalsSection);
		 
		 	JavascriptClick(PageRepositary.billVerificationSubTab, driver);
		 	
		 	click(PageRepositary.searchIcon);
			select(" Expense Number ", PageRepositary.searchCol);
			input(PageRepositary.searchInput, expNumber);
			click(PageRepositary.searchBtn);
			 
			doubleClick(PageRepositary.bilVerify(expNumber));
			
			select(billVerificationStatus, PageRepositary.billVerificationStatus);
			
			input(PageRepositary.billVerificationComment, "data");
			click(PageRepositary.billVerificationSave);
			
			boolean flag = ElementDisplayed(PageRepositary.exp_successMsg);
			 
			return flag;
		}
       
       //
       
       public boolean validate10(String accountVerificationUserName, String pwd, String accVerificationPaymentStatus, String accVerificationPaymentOn, String expNumber) throws InterruptedException {
			
    	   input(PageRepositary.username, accountVerificationUserName);
			 input(PageRepositary.password, pwd);
			 Thread.sleep(Duration.ofSeconds(2));
			 JavascriptClick(PageRepositary.signin,driver);
			 try {
				 click(PageRepositary.remindMe);
			 } catch (Exception e) { }
			 click(PageRepositary.expenses);
			 click(PageRepositary.ApprovalsSection);
		 
		 	click(PageRepositary.accVerificationSubTab);
		 	
		 	click(PageRepositary.searchIcon);
			select(" Expense Number ", PageRepositary.searchCol);
			input(PageRepositary.searchInput, expNumber);
			click(PageRepositary.searchBtn);
			 
			doubleClick(PageRepositary.bilVerify(expNumber));
			
			select(accVerificationPaymentStatus, PageRepositary.accVerificationPaymentStatus);
			select (accVerificationPaymentOn, PageRepositary.accVerificationPaymentOn);
			
			input(PageRepositary.paymentStatusComment, "data");
			
			click(PageRepositary.billVerificationSave);
			
			boolean flag = ElementDisplayed(PageRepositary.exp_accVerificationMsg);
			 
			return flag;
		}
       
      public boolean validate11(String paymentStatus, String expNumber) throws InterruptedException {
				
			 click(PageRepositary.expenses);
			 click(PageRepositary.ApprovalsSection);
		 
		 	click(PageRepositary.payReleaseSubTab);
		 	
		 	click(PageRepositary.searchIcon);
			select(" Expense Number ", PageRepositary.searchCol);
			input(PageRepositary.searchInput, expNumber);
			click(PageRepositary.searchBtn);
			 
			doubleClick(PageRepositary.bilVerify(expNumber));
			
			select(paymentStatus, PageRepositary.paymentStatus);
			
			input(PageRepositary.paymentStatusComment, "data");
			
			click(PageRepositary.billVerificationSave);
			
			boolean flag = ElementDisplayed(PageRepositary.exp_paymentSuccessMsg);
			 
			return flag;
		}
       
      public boolean validate12(String username, String pwd, String expNumber) throws InterruptedException {
    	    input(PageRepositary.username, username);
			 input(PageRepositary.password, pwd);
			 click(PageRepositary.signin);
			 try {
				 click(PageRepositary.remindMe);
			 } catch (Exception e) { }
			 click(PageRepositary.timesheetSection);
			 click(PageRepositary.myExpense);
		 
		 	click(PageRepositary.approvedTab);
			
			click(PageRepositary.searchIcon);
			select(" Expense Number ", PageRepositary.searchCol);
			input(PageRepositary.searchInput, expNumber);
			click(PageRepositary.searchBtn);
			
			
			boolean flag = ElementDisplayed(PageRepositary.exp_paymentDoneMsg(expNumber));
			 
			return flag;
		}
      
      public boolean validate13(String firstLevel, String pwd, String expNumber) throws InterruptedException {
  		input(PageRepositary.username, firstLevel);
  		input(PageRepositary.password, pwd);
  		click(PageRepositary.signin);
  		try {
			 click(PageRepositary.remindMe);
		 } catch (Exception e) { }
  		click(PageRepositary.expenses);
  		click(PageRepositary.ApprovalsSection);
  		click(PageRepositary.expensesApproval);
  		
  		click(PageRepositary.searchIcon);
  		select(" Expense Number ", PageRepositary.searchCol);
  		input(PageRepositary.searchInput, expNumber);
  		click(PageRepositary.searchBtn);
  		click(PageRepositary.expNumber);
  		
  		click(PageRepositary.rejectExpBtn);
  		input(PageRepositary.rejectExpComment, "rejecting");
  		JavascriptClick(PageRepositary.rejectBtn, driver);
  		Thread.sleep(Duration.ofSeconds(2));
  		click(PageRepositary.rejectOk);
  		 
  		 boolean flag = ElementDisplayed(PageRepositary.rejectSuccessMsg);
  		 
  		return flag;
  		 
  	}
      
      public boolean validate14(String username, String pwd, String expNumber) throws InterruptedException {
    	  	input(PageRepositary.username, username);
	  		input(PageRepositary.password, pwd);
    		click(PageRepositary.signin);
    		try {
   			 click(PageRepositary.remindMe);
   		 } catch (Exception e) { }
    		click(PageRepositary.timesheetSection);
   		 	click(PageRepositary.myExpense);
   		 	Thread.sleep(Duration.ofSeconds(2));
   		 	click(PageRepositary.rejectTab);
   		 	
	   		click(PageRepositary.searchIcon);
	   		select(" Expense Number ", PageRepositary.searchCol);
	   		input(PageRepositary.searchInput, expNumber);
	   		click(PageRepositary.searchBtn);
   		 	
    		boolean flag = ElementDisplayed(PageRepositary.exp_empNum(expNumber));
    		 
    		return flag;
    		 
    	}
	 
}
