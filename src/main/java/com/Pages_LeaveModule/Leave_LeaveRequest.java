package com.Pages_LeaveModule;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_LeaveModule;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;


public class Leave_LeaveRequest extends Base_Class
{
	PageRepositary_LeaveModule PageRepositary= new PageRepositary_LeaveModule();
	
	
	 public boolean clickOnLeaveModule() throws InterruptedException {
		 WaitForLoaderToDisappear();
		 click(PageRepositary.LeaveSection);
		 Thread.sleep(1000);		 
		 click(PageRepositary.myLeaveSection);
	      Thread.sleep(2000);
	      click(PageRepositary.clickOnLeaveRequest);
	      WaitForLoaderToDisappear();
	        return true;
	    }
	 
	 public boolean clickOnDashboard() throws InterruptedException {
		 click(PageRepositary.LeaveSection);
		 Thread.sleep(1000);
		 click(PageRepositary.clickOnDashboard);
	      Thread.sleep(3000);
	      click(PageRepositary.DesktopNot);
	      Thread.sleep(3000);
	      Log.info("All the Details Visible Properly");
	        return true;
	    }
	 
	 public boolean selectLeaveType(String leaveType) throws InterruptedException {
		 WaitForLoaderToDisappear();
		 click_JS(By.xpath("//div[contains(text(),'"+leaveType+"')]"));
		 
		 Thread.sleep(2000);
	        return true;
	    }
	 
	public boolean leaveRequestForm(String leaveType, String fromYear, String fromMonth, String fromDate1, String toYear, String toMonth, String toDate, String duration, String Reason, String Employee) throws InterruptedException {
			WaitForLoaderToDisappear();
			 ScrollUntilElementVisible(PageRepositary.selectFromDate);
			 Thread.sleep(2000);
			 click(PageRepositary.GeneralRadioButton);
			 Thread.sleep(1000);
			 click(PageRepositary.selectFromDate);
			 Thread.sleep(1000);
			 click(PageRepositary.selectMonthandYear);
			 Thread.sleep(1000);
			 click(By.xpath("//div[contains(text(),'"+fromYear+"')]"));
			 Thread.sleep(1000);
			 click(By.xpath("//div[contains(text(),'"+fromMonth+"')]"));
			 Thread.sleep(1000);
			 click(By.xpath("//tbody/tr/td/div[contains(text(),'"+fromDate1+"')]"));
			 Thread.sleep(1000);

			 Thread.sleep(1000);
			 if(leaveType.equals("Floating Holidays")) {
				 boolean flag1=ElementDisplayed(PageRepositary.floatingPeriod);
				 ExtentTestManager.getTest().log(Status.FAIL, "Floating Holidays should be applied before 7 days: " + false);
				Log.info("Floating Holidays should be applied before 7 days : " + false);
				return flag1; 
			 }
			 else {
				 Thread.sleep(1000);
			 }
			 
			 click(PageRepositary.selectToDate);
			 Thread.sleep(1000);
			 click(PageRepositary.selectMonthandYear);
			 Thread.sleep(1000);
			 click(By.xpath("//div[contains(text(),'"+toYear+"')]"));
			 Thread.sleep(1000);
			 click(By.xpath("//div[contains(text(),'"+fromMonth+"')]"));
			 Thread.sleep(1000);
			 click(By.xpath("//tbody/tr/td/div[contains(text(),'"+toDate+"')]"));
			 try {
				 
			 
			 Boolean flag01=ElementDisplayed(PageRepositary.WeekendAndHoliday);
			 if (flag01)
				{ 	
				 	
					ExtentTestManager.getTest().log(Status.PASS, "Selected Date is not a working day");
					Log.info("Selected Date is not a working day");	
				}
			 }
			 catch(Exception e1)
				{
					Log.info("No timesheet saved for ");
				}
				
	
			// Thread.sleep(1000);
				click(PageRepositary.clickOnDuration);
				 Thread.sleep(1000);
				 boolean flag1 = ElementDisplayed(By.xpath("//span[contains(text(),'"+duration+"')]")); 
				click(By.xpath("//span[contains(text(),'"+duration+"')]"));
				Thread.sleep(1000);
				input(PageRepositary.leaveReson, Reason);
				Thread.sleep(1000);
				click(PageRepositary.selectEmployees);
				Thread.sleep(1000);
				input(PageRepositary.searchEmp, Employee);
				Thread.sleep(1000);
				click(PageRepositary.selectEmp);
				Thread.sleep(1000);
				return flag1;

		 }
	 public boolean uploadFileNew(String filePath) {
		 UploadFileNew(PageRepositary.selectFile, filePath);
			return false;	    
	        }
	 public static void UploadFileNew(By locator, String path)
		{
			WebElement uploadElement = driver.findElement(locator);
			String path1=System.getProperty("user.dir");
			Log.info("path is :" + path1);
			uploadElement.sendKeys(path1 + path);
			
		}
	 public boolean uploadFile(String filePath) {
	        UploadFile(PageRepositary.selectFile, filePath);
			return false;	    
	        }

	 public boolean submitButton() throws InterruptedException {
	        click(PageRepositary.SubmitButton);
	        Thread.sleep(5000);
	       // Thread.sleep(1000);
	        
	        if(ElementDisplayed(PageRepositary.clickOnOkButton))
			{
				click(PageRepositary.clickOnOkButton);
				ExtentTestManager.getTest().log(Status.PASS, "Modal closed : ");
				Log.info("Modal closed : ");
				
			}
	        else if (ElementDisplayed(PageRepositary.SamePeriod))
					{ 	
					 	click(PageRepositary.SamePeriodOk);
					 	
						ExtentTestManager.getTest().log(Status.PASS, "Selected Date is not a working day");
						Log.info("Selected Date is not a working day");	
					}
	        
			return true;	    
	        }
	 
	 public boolean clearButton(String leaveType) throws InterruptedException {
	        click(PageRepositary.clearButton);
	        Thread.sleep(2000);
		 ScrollUntilElementVisible(By.xpath("//div[contains(text(),'"+leaveType+"')]"));
		 Thread.sleep(2000);
			return false;	    
	        }
	 
	 public boolean ValidateLeaveModule(String leaveType) throws InterruptedException 
		{
			Boolean flag1 = ElementDisplayed(By.xpath("//div[contains(text(),'"+leaveType+"')]"));
			Log.info("All the Leave Type Appeared Properly");
			Boolean flag = flag1;
			return flag;
		}
	 
	 public boolean ValidateLeaveModuleForm(String leaveType) throws InterruptedException 
		{
			Boolean flag1 = ElementDisplayed(By.xpath("//div[contains(text(),'"+leaveType+"')]"));
			Boolean flag2 = ElementDisplayed(PageRepositary.GeneralRadioButton);
			Boolean flag3 = ElementDisplayed(PageRepositary.selectFromDate);
			Boolean flag4 = ElementDisplayed(PageRepositary.selectToDate);
			Boolean flag5 = ElementDisplayed(PageRepositary.clickOnDuration);
			Boolean flag6 = ElementDisplayed(PageRepositary.leaveReson);
			Boolean flag7 = ElementDisplayed(PageRepositary.selectEmployees);

			Boolean flag = flag1 & flag2 & flag3 & flag4 & flag5 & flag6 & flag7;
			return flag;
		}
	 
		
	 public boolean ValidateStatementModal() throws InterruptedException 
		{
		 click(PageRepositary.clickOnStatement);
		 Thread.sleep(1000);
		 click(PageRepositary.clickOnDD);
		 Thread.sleep(1000);
		 click(PageRepositary.selectDDforStatement);
		 Thread.sleep(1000);
		 click(PageRepositary.clickOnApply);
		 Thread.sleep(1000);
			Boolean flag1 = ElementDisplayed(PageRepositary.ValidateField1);
			Boolean flag2 = ElementDisplayed(PageRepositary.ValidateField2);
			Boolean flag3 = ElementDisplayed(PageRepositary.ValidateField3);
			Boolean flag4 = ElementDisplayed(PageRepositary.ValidateField4);
			 Thread.sleep(1000);
			click(PageRepositary.clickOnCloseButton);
			Boolean flag = flag1 & flag2 & flag3 & flag4;
			return flag;
		 
		}
	 
	 public boolean CancelLeaveRequest(String CancelComments) throws InterruptedException 
		{
		 WaitForLoaderToDisappear();
		 ScrollUntilElementVisible(PageRepositary.CancelLeave);
		 Thread.sleep(1000);
		 click(PageRepositary.CancelLeave);
		 Thread.sleep(1000);
		 input(PageRepositary.EnterComments, CancelComments);
		 Thread.sleep(1000);
//		 ScrollUntilElementVisible(PageRepositary.SendButton);
//		 Thread.sleep(1000);
//		 click(PageRepositary.SendButton);
//		 Thread.sleep(1000);
//		 click(PageRepositary.clickOnOkButton);
		 

		 click(PageRepositary.CancelLeaveBtn);
		 Thread.sleep(1000);
		 click(PageRepositary.clickOnOkButton);
		 Thread.sleep(1000);
		 
			return true;
		 
		}
	 
	 
	 public boolean CancelLeaveRequestWithDate(String CancelComments, String leaveType, String fromYear,
				String fromMonth, String fromDate1, String toYear, String toMonth, String toDate, String duration,
				String Reason, String Employee) throws InterruptedException {
			String Year = fromMonth;
			String Month = fromYear;
			String Date = fromDate1;
			String formattedDate = getFormattedDate(Date, Month, Year);
			String xpath = "//span[contains(text(),'" + formattedDate + " - " + formattedDate
					+ "')]/ancestor::div[contains(@class,'d-flex')][1]//img[@title='Cancel Leave']";
			WaitForLoaderToDisappear();
			ScrollUntilElementVisible(PageRepositary.CancelLeave);
			Thread.sleep(1000);
			click_JS(PageRepositary.ShowMore);
			WaitForLoaderToDisappear();
			Thread.sleep(1000);
			ScrollUntilElementVisible(PageRepositary.CancelLeave);
			WebElement element = driver.findElement(By.xpath(xpath));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			js.executeScript("arguments[0].click();", element);
			Thread.sleep(1000);
			input(PageRepositary.EnterComments, CancelComments);
			Thread.sleep(1000);
			click_JS(PageRepositary.CancelLeaveBtn);
			Thread.sleep(1000);
			click_JS(PageRepositary.clickOnOkButton);
			Thread.sleep(1000);
			return true;
		}
	 
	 public static String getFormattedDate(String day, String month, String year) {
	        try {
	            // Convert inputs to a date
	            String inputDate = day + "-" + month.substring(0, 3) + "-" + year;

	            // Parse using custom input format with uppercase month
	            SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
	            Date date = inputFormat.parse(inputDate);

	            // Output format as required
	            SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
	            return outputFormat.format(date); // returns like "16-May-2025"
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	 
	 
	 public boolean clickOnEWCModuleApproval() throws InterruptedException {
		 click(PageRepositary.LeaveSection);
		 Thread.sleep(1000);
		 click(PageRepositary.ApprovalsSection);
	      Thread.sleep(1000);
	      click(PageRepositary.EWCApprovalSection);
	      Thread.sleep(3000);
	        return true;
	    }
	 
	 public boolean RejectFunctionality(String EmployeeName)throws InterruptedException {
		 WaitForLoaderToDisappear();
		 click(By.xpath("//span[contains(text(),'"+EmployeeName+"')]"));
		 Thread.sleep(2000);
		 click(PageRepositary.rejectbutton);
		 WaitForLoaderToDisappear();
		 input(PageRepositary.leaveRejectComments, "Rejected");
		 Thread.sleep(1000);
		 click(PageRepositary.sendButton2);
		 Thread.sleep(3000);
		 ExtentTestManager.getTest().log(Status.PASS, "EWC Leave Request Rejected Successfully");
		 Log.info("EWC Leave Request Rejected Successfully!");
		 return true;
	    }
	 
}
