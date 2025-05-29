package com.Pages_employeeapplicationtrackermodule;

import org.openqa.selenium.By;
import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_EmployeeModule;
import java.util.concurrent.TimeUnit;
//import com.Page_Repositary.PageRepositary_LeaveModule;
public class Employee_AppclicationTracker extends Base_Class
{
PageRepositary_EmployeeModule PageRepositary= new PageRepositary_EmployeeModule();
	
  public boolean clickOnEmployeeModule() throws InterruptedException {
	  
	  ScrollUntilElementVisible(PageRepositary.clickOnemp);
	 
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  //Thread.sleep(3000);
	click(PageRepositary.clickOnemp);
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	//Thread.sleep(2000);
	 
       return true;
   }
  
  
  public boolean clickOnapplicationtracker() throws InterruptedException 
	  {
	  click(PageRepositary.employeeapplicationtrackersection);
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  //Thread.sleep(2000);
	     
	     return true;
	  }
  
  
  public boolean clickOnaddnew() throws InterruptedException 
  {
 
     click(PageRepositary.clickOnAddNew);
     driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
     //Thread.sleep(2000);
     return true;
  }
  
  
  
  public boolean selecthiringclassification(String HiringClassification) throws InterruptedException
  {
  	click(PageRepositary.selecthiringclasification);
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
  	//Thread.sleep(3000);
 	input(PageRepositary.selecthiringclasification, HiringClassification);
 	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
 	//Thread.sleep(2000);
	/*
	 * if(HiringClassification.equals("Rehire")) { //Thread.sleep(3000);
	 * ElementEnabled(PageRepositary.selecrehire); Thread.sleep(3000);
	 * click(PageRepositary.selecrehire); Thread.sleep(3000);
	 * click(PageRepositary.selecrehiredropdown); Thread.sleep(3000);
	 * click(PageRepositary.selecrehiredropdownok); Thread.sleep(3000); } else {
	 * CheckElementDisable(PageRepositary.selecrehire); }
	 */
		return true;
  }
  
  public boolean selectsalutation(String Salutation) throws InterruptedException {
	  	click(PageRepositary.selectsalutation);
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  	//Thread.sleep(2000);
	  	input(PageRepositary.selectsalutation, Salutation);
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  	//Thread.sleep(2000);
			return true;
	  }
  
  public boolean selectfirstname(String firstname) throws InterruptedException {
	  	click(PageRepositary.selectfirstname);
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  	//Thread.sleep(2000);
	  	input(PageRepositary.selectfirstname, firstname);
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  	//Thread.sleep(2000);
			return true;
	  }
  
  public boolean selectmiddlename(String middlename) throws InterruptedException {
	  	click(PageRepositary.selectmiddlename);
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  	//Thread.sleep(2000);
	  	input(PageRepositary.selectmiddlename, middlename);
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  	//Thread.sleep(2000);
			return true;
	  }
  public boolean selectlastname(String lastname) throws InterruptedException {
	  	click(PageRepositary.selectlastname);
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  //	Thread.sleep(2000);
	  	input(PageRepositary.selectlastname, lastname);
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  	//Thread.sleep(2000);
			return true;
	  }
  
    public boolean enterpersonalemail() throws InterruptedException {
	  	click(PageRepositary.enterpersonalemail);
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  	//Thread.sleep(2000);
	    String email=generateRandomEmail();
	  	input(PageRepositary.enterpersonalemail, email);
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  	//Thread.sleep(2000);
	   
			return true;
	  }
 
     public boolean uploadFile(String filePath) {
     UploadFile(PageRepositary.selectresume, filePath);
     driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		return true;	    
      }

  public boolean entercontactnumber() throws InterruptedException {
	  	click(PageRepositary.entercontactnumber);
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  	//Thread.sleep(2000);
	    String contactnumber=generateRandomContactNumber();
	  	input(PageRepositary.entercontactnumber, contactnumber);
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  	//Thread.sleep(2000);
			return true;
	  }

  
  public boolean selectreportingto(String reportingto) throws InterruptedException {
	 
	  //Thread.sleep(2000);
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  ScrollUntilElementVisible(PageRepositary.entercontactnumber);
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  click(PageRepositary.selectreportingto);
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  //Thread.sleep(2000);
	  	input(PageRepositary.selectreportingto, reportingto);
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  	//Thread.sleep(2000);
	    click(PageRepositary.selectreportingtodropdown);
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    //Thread.sleep(2000);
	    click(PageRepositary.selectreportingtook);
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    //Thread.sleep(2000);
	  	 
			return true;
	  }
  
  
  
  
  public boolean selectdesignation(String designation) throws InterruptedException {
	  	click(PageRepositary.selectdesignation);
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  //	Thread.sleep(2000);
	  	input(PageRepositary.selectdesignation, designation);
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  	//Thread.sleep(2000);
	    click(PageRepositary.selectdesignationdropdown);
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    //Thread.sleep(2000);
		click(PageRepositary.selectdesignationok);
		  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		//Thread.sleep(2000);
			return true;
	  }

  public boolean selectrolename(String rolename) throws InterruptedException {
	  	click(PageRepositary.selectrolename);
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  	//Thread.sleep(2000);
	  	input(PageRepositary.selectrolename, rolename);
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  	//Thread.sleep(2000);
	    click(PageRepositary.selectrolenamedropdown);
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    //Thread.sleep(2000);
	  	click(PageRepositary.selectrolenameok);
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  	//Thread.sleep(2000);
			return true;
	  }
  
  
  public boolean selectbusinessunit(String businessunit) throws InterruptedException {
	  	click(PageRepositary.selectbusinessunit);
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  	//Thread.sleep(2000);
	  	input(PageRepositary.selectbusinessunit, businessunit);
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  	//Thread.sleep(2000);
	    click(PageRepositary.selectbusinessunitdropdwon);
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    //Thread.sleep(2000);
			return true;
	  }
  
  
  public boolean selectdivisionname(String divisionname) throws InterruptedException {
	  ScrollUntilElementVisible(PageRepositary.selectreportingto);
	   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	 // Thread.sleep(3000);
	  	click(PageRepositary.selectdivisionname);
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  	//Thread.sleep(2000);
	  	input(PageRepositary.selectdivisionname, divisionname);
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  	//Thread.sleep(2000);
	    click(PageRepositary.selectdivisionnamedropdown);
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    //Thread.sleep(2000);
			return true;
	  }

  public boolean selecttechnologyname(String technologyname) throws InterruptedException {
	//  ScrollUntilElementVisible(PageRepositary.selecttechnologyname);
	  //Thread.sleep(3000);
	  click(PageRepositary.selecttechnologyname);
	   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	 // Thread.sleep(2000);
	  	input(PageRepositary.selecttechnologyname, technologyname);
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  	//Thread.sleep(2000);
	    click(PageRepositary.selecttechnologynamedropdown);
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    //Thread.sleep(2000);
			return true;
	  }
  
  
  public boolean selectdepartment(String departmentname) throws InterruptedException {
	  	click(PageRepositary.selectdepartment);
	  	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  //	Thread.sleep(2000);
	  	input(PageRepositary.selectdepartment, departmentname);
	  	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  	//Thread.sleep(2000);
	    click(PageRepositary.selectdepartmentdropdwon);
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    //Thread.sleep(2000);
			return true;
	  }

  public boolean selectimmigrationstatus(String immigrationstatus) throws InterruptedException {
	  	click(PageRepositary.selectimmigrationstatus);
	  	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  //	Thread.sleep(2000);
	  	input(PageRepositary.selectimmigrationstatus, immigrationstatus);
	  	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  	//Thread.sleep(2000);
	    click(PageRepositary.selectimmigrationstatusdropdown);
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    //Thread.sleep(2000);
			return true;
	  }

  
  public boolean selectvisatype(String visatype) throws InterruptedException {
	  	click(PageRepositary.selectvisatype);
	  	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  //	Thread.sleep(2000);
	  	input(PageRepositary.selectvisatype, visatype);
	  	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  	//Thread.sleep(2000);
	    click(PageRepositary.selectvisatypedropdown);
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	   // Thread.sleep(2000);
			return true;
	  }

  
  public boolean selectdateofjoining(String dateofjoining) throws InterruptedException {
	  	click(PageRepositary.selectdateofjoining);
	  	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  	//Thread.sleep(2000);
	 input(PageRepositary.selectdateofjoining, dateofjoining);
	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	 //Thread.sleep(2000);
			return true;
	  }

  
  public boolean selectemptypeemp() throws InterruptedException {
	  	click(PageRepositary.selectemptype);
	  	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  	//Thread.sleep(5000);
	 	click(PageRepositary.selectemptypedropdownemp);
	 	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	 	//Thread.sleep(5000);
	  
	  	
	  		click(PageRepositary.selectemptypeemp);
	  		 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  		//Thread.sleep(5000);
		  	click(PageRepositary.selectemptypeempdropdown);
		  	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		  	//Thread.sleep(5000);
	  	
	  	
			return true;
	  }

  public boolean selectemptypecontractor() throws InterruptedException {
	  	click(PageRepositary.selectemptype);
	  	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  	//Thread.sleep(5000);
	 	click(PageRepositary.selectemptypedropdowncontractor);
	 	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	 	//Thread.sleep(5000);
	  
	  	
	  	
	  	
	  	
			return true;
	  }
  
  
  public boolean selectpseaccessneeded(String speaccessneeded) throws InterruptedException {
	  	click(PageRepositary.selectpseaccessneeded);
	  	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  	//Thread.sleep(2000);
	  	input(PageRepositary.selectpseaccessneeded, speaccessneeded);
	  	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  	//Thread.sleep(2000);
			return true;
	  }

  
  public boolean selecttrainingrequired(String trainingrequired) throws InterruptedException {
	  	click(PageRepositary.selecttrainingrequired);
	  	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  //	Thread.sleep(2000);
	  	input(PageRepositary.selecttrainingrequired, trainingrequired);
	  	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  	//Thread.sleep(2000);
	  //  click(PageRepositary.selecttrainingrequireddropdown);
	  	// Thread.sleep(1000);
			return true;
	  }

  public boolean additionaltraining(String additionaltraining) throws InterruptedException {
	  	click(PageRepositary.additionaltraining);
	  	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  	//Thread.sleep(2000);
	  	input(PageRepositary.additionaltraining, additionaltraining);
	  	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  	//Thread.sleep(2000);
	   // click(PageRepositary.selectbusinessunitdropdwon);
	  	 //Thread.sleep(1000);
			return true;
	  }
  
  public boolean uploadFile1(String filePath) {
	     UploadFile(PageRepositary.benefitswaiverform, filePath);
	     driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			return true;	    
	      }

  public boolean selectjoblocation(String joblocation) throws InterruptedException {
	  	click(PageRepositary.selectjoblocation);
	  	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  	//Thread.sleep(2000);
	  	input(PageRepositary.selectjoblocation, joblocation);
	  	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  	//Thread.sleep(2000);
	    click(PageRepositary.selectjoblocationdropdown);
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	   // Thread.sleep(2000);
			return true;
	  }

  public boolean selectcountry(String country) throws InterruptedException {
	  	click(PageRepositary.selectcountry);
	  	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  	//Thread.sleep(2000);
	  	input(PageRepositary.selectcountry, country);
	  	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  	//Thread.sleep(2000);
	    click(PageRepositary.selectcountrydropdown);
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    //Thread.sleep(2000);
			return true;
	  }

  public boolean enterzipcode(String zipcode) throws InterruptedException {
	  	click(PageRepositary.enterzipcode);
	  	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  	//Thread.sleep(2000);
	  	input(PageRepositary.enterzipcode, zipcode);
	  	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  	//Thread.sleep(2000);
	    //click(PageRepositary.selectbusinessunitdropdwon);
	  	 //Thread.sleep(1000);
			return true;
	  }

  public boolean entercity(String city) throws InterruptedException {
	  	click(PageRepositary.entercity);
	  	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  	//Thread.sleep(2000);
	  	input(PageRepositary.entercity, city);
	  	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  //	Thread.sleep(2000);
	    //click(PageRepositary.selectbusinessunitdropdwon);
	  	 //Thread.sleep(1000);
			return true;
	  }
  public boolean enterstate(String state) throws InterruptedException {
	  	click(PageRepositary.enterstate);
	  	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  	//Thread.sleep(2000);
	  	input(PageRepositary.enterstate, state);
	  	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  	//Thread.sleep(2000);
	    //click(PageRepositary.selectbusinessunitdropdwon);
	  	 //Thread.sleep(1000);
			return true;
	  }
  
  //SA
  
  public boolean Selectcurrency(String currency) throws InterruptedException {
	  ScrollUntilElementVisible(PageRepositary.Selectcurrency);
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  //Thread.sleep(2000);
	  click(PageRepositary.Selectcurrency);
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	 // Thread.sleep(2000);
	  	input(PageRepositary.Selectcurrency, currency);
	  	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  	//Thread.sleep(2000);
	    click(PageRepositary.selectcurrencydropdown);
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	   // Thread.sleep(2000);
			return true;
	  }
  public boolean enteramount(String amount) throws InterruptedException {
	  	click(PageRepositary.enteramount);
	  	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  //	Thread.sleep(2000);
	  	input(PageRepositary.enteramount, amount);
	  	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  	//Thread.sleep(2000);
	    //click(PageRepositary.selectbusinessunitdropdwon);
	  	 //Thread.sleep(1000);
			return true;
	  }
  public boolean Selectsalarytype(String salarytype) throws InterruptedException {
	  	click(PageRepositary.Selectsalarytype);
	  	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  	//Thread.sleep(2000);
	  	input(PageRepositary.Selectsalarytype, salarytype);
	  	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  	//Thread.sleep(2000);
	    click(PageRepositary.selectsalarytypedropdown);
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    //Thread.sleep(2000);
			return true;
	  }
  public boolean enteradditionalcomments(String additionalcomments) throws InterruptedException {
	  	click(PageRepositary.enteradditionalcomments);
	  	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  //	Thread.sleep(2000);
	  	input(PageRepositary.enteradditionalcomments, additionalcomments);
	  	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  	//Thread.sleep(2000);
	    //click(PageRepositary.selectbusinessunitdropdwon);
	  	 //Thread.sleep(1000);
			return true;
	  }
  public boolean submitbutton() throws InterruptedException {
	  ScrollUntilElementVisible(PageRepositary.Submitbutton);
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  //Thread.sleep(2000);
	  	click(PageRepositary.Submitbutton);
	  	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  	//Thread.sleep(2000);
	 	click(PageRepositary.Submitbuttonok);
	 	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	 	//Thread.sleep(2000);
	 	click(PageRepositary.Sendcandidateform);
	 	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	 	//Thread.sleep(2000);
	  	click(PageRepositary.Sendcandidateformok);
	  	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  	//Thread.sleep(2000);
	  	 
	  	 
	 //input(PageRepositary.selectdateofjoining, dateofjoining);
	    ///Thread.sleep(1000);
			return true;
	  }
  
}
