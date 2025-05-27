package com.Pages_LeaveModule;

import org.openqa.selenium.By;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_LeaveModule;

public class Leave_ApprovalModule extends Base_Class
{
	PageRepositary_LeaveModule PageRepositary= new PageRepositary_LeaveModule();
	
	public boolean NavigateToMyLeaveApproval() throws InterruptedException 
	{
		click(PageRepositary.LeaveSection);
		Thread.sleep(1000);
		
		return true;
	}
	
	public boolean NavigateToApproval() throws InterruptedException 
	{
		click(PageRepositary.approvalsSection);
		Thread.sleep(1000);
		click(PageRepositary.leaveEWC);
		Thread.sleep(2000);
		
		return true;
	}
	
	public void SelectEmployeeForApproval(String EmployeeName) throws InterruptedException {
			click(By.xpath("//option[text()='"+EmployeeName+"']"));
		
	}
	
	public boolean ElementDisplayed() throws InterruptedException {
	boolean flag1=ElementDisplayed(PageRepositary.leaveForDayButton);
	boolean flag2=ElementDisplayed(PageRepositary.sendForReview);
	boolean flag3=ElementDisplayed(PageRepositary.projectAllocation);
	boolean flag4=ElementDisplayed(PageRepositary.approveButton);
	boolean flag5=ElementDisplayed(PageRepositary.rejectButton);
	boolean flag= flag1 & flag2 & flag3 & flag4 & flag5;
			return flag;
}
	
//	public boolean Approval() throws InterruptedException 
//	{
//		click(PageRepositary.approveButton);
//		Thread.sleep(5000);
//		
//		return false;
//	}
//	
//	public boolean Approval() throws InterruptedException 
//	{
//		click(PageRepositary.approveButton);
//		Thread.sleep(5000);
//		
//		return false;
//	}
	
	
	
	
	

}
