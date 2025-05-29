package com.Pages_ProjectModule;

import java.util.Map;

import org.openqa.selenium.By;
import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_ProjectModule;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

import jdk.internal.org.jline.utils.Log;
//import com.Page_Repositary.PageRepositary_LeaveModule;
public class Project_Client extends Base_Class
{
PageRepositary_ProjectModule PageRepositary= new PageRepositary_ProjectModule();

       
  public boolean clickOnProjectModule(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {
	  
	  String projectname=testdata.get("Clientname").toString();
         

	  ScrollUntilElementVisible(PageRepositary.clickOnproject);
	  ExtentTestManager.getTest().log(Status.PASS,"Project module is displayed");
         Thread.sleep(3000);
       click(PageRepositary.clickOnproject);
       Thread.sleep(1000);
       //Dashboard
       ExtentTestManager.startTest("TC_01 Project dashboard");
       click(PageRepositary.ProjectDashboard);
       ExtentTestManager.getTest().log(Status.PASS,"Project Dashboard is displayed");
       Thread.sleep(1000);
       handlePopupDesktop();
       ExtentTestManager.endTest();
       ExtentTestManager.startTest("TC_02 verifying element in Project dashboard");
       ElementDisplayedDashboard();
       ExtentTestManager.getTest().log(Status.PASS,"all required dashboard elements are displayed");
       ExtentTestManager.endTest();
       
       //Allocated projects
       ExtentTestManager.startTest("TC_06 View allocated Projects in the project dashboard");
       click(PageRepositary.AllocatedProjects);
       ExtentTestManager.getTest().log(Status.PASS,"allocated projects is shown");
       Thread.sleep(2000);
       ExtentTestManager.endTest();
       ExtentTestManager.startTest("TC_07 verifying the close button");
       ExtentTestManager.getTest().log(Status.PASS,"close button is verified");
       click(PageRepositary.closebutton);
       handlePopupDesktop();
       ExtentTestManager.endTest();
       
       
       ScrollUntilElementVisible(PageRepositary.clickOnproject);
       Thread.sleep(3000);
     click(PageRepositary.clickOnproject);
     Thread.sleep(1000);
     
     //Clients submenu
     ExtentTestManager.startTest("TC_08 Navigating to submenu Clients");
       click(PageRepositary.Clickonclients);
       ExtentTestManager.getTest().log(Status.PASS,"clients with sub menu is displayed");
     Thread.sleep(2000);
     ExtentTestManager.endTest();
     
     //clientlistpage
     ExtentTestManager.startTest("TC_09 verifying client list page");
     click(PageRepositary.Clientlist);
     ExtentTestManager.getTest().log(Status.PASS,"all clients displayed in clientlist page");
     Thread.sleep(5000);
     ExtentTestManager.endTest();
     ExtentTestManager.startTest("TC_10 verifying all elements client list page"); 
     ElementDisplayedclientlist();
     ExtentTestManager.getTest().log(Status.PASS,"all columns of clientlist page is verified");
     ExtentTestManager.endTest();
     
     //Downloading clientlist
     ExtentTestManager.startTest("TC_23 Downloading clientlist details");
     click(PageRepositary.downloadicon);
     ExtentTestManager.getTest().log(Status.PASS,"client list downloaded");
     ExtentTestManager.endTest(); 
     
     //search in clientlist page
     ExtentTestManager.startTest("TC_24  verifying search is available in  clientlist page");
     click(PageRepositary.searchicon);
     ExtentTestManager.endTest(); 
     ExtentTestManager.startTest("TC_25  performing search in  clientlist page");
     click(PageRepositary.searchfield);
     input(PageRepositary.searchfield,"clie");
     click(PageRepositary.searchbutton);
     ExtentTestManager.getTest().log(Status.PASS,"search performed");
     Thread.sleep(2000);
     click(PageRepositary.searchclose);
     ExtentTestManager.endTest();  
     
     
     //View client details in client list
     ExtentTestManager.startTest("TC_26 Verify its able to select a client in client list");
     click(PageRepositary.Clickonclient);
     ExtentTestManager.endTest(); 
     ExtentTestManager.startTest("TC_27 details of selected client is displayed");
     ExtentTestManager.getTest().log(Status.PASS,"details of the selected client is shown");
     Thread.sleep(2000);
     click(PageRepositary.closebutton);
     Thread.sleep(2000);
     ExtentTestManager.endTest(); 
     
     //cliet request
     ExtentTestManager.startTest("TC_28 Navigating to client request page");
     ScrollUntilElementVisible(PageRepositary.clickOnproject);
     click(PageRepositary.clickOnproject);
     Thread.sleep(1000);
       click(PageRepositary.Clickonclients);
     Thread.sleep(2000);
     ExtentTestManager.endTest(); 
     ExtentTestManager.startTest("TC_29 client request page is available");
     click(PageRepositary.ClientRequest);
     ExtentTestManager.getTest().log(Status.PASS,"new client request page is opened");
     Thread.sleep(2000);
     ExtentTestManager.endTest(); 
     
     //verifying fields in client request page
     ExtentTestManager.startTest("TC_30 verifying fields in client request page");
     ElementDisplayedclientrequest();
     ExtentTestManager.getTest().log(Status.PASS,"all fields are displayed correctly in client request page");
     ExtentTestManager.endTest(); 

     //providing details in client request
     ExtentTestManager.startTest("TC_48 providing details to create client request");
     click(PageRepositary.inputclientname);
     input(PageRepositary.inputclientname,"c client");
     click(PageRepositary.inputcontactperson);
     input(PageRepositary.inputcontactperson,"anil");
     click(PageRepositary.inputcontactemail);
     input(PageRepositary.inputcontactemail,"abc@email.com");
     click(PageRepositary.inputaddress);
     input(PageRepositary.inputaddress,"mg road");
     click(PageRepositary.selectcountry);
     input(PageRepositary.selectcountry,"india");
     click(PageRepositary.indiacountry);
     click(PageRepositary.inputzipcode);
     input(PageRepositary.inputzipcode,"683101");
     click(PageRepositary.selectaccountmanager);
     input(PageRepositary.selectaccountmanager,"aana");
     click(PageRepositary.aanacaccountmanager);
     click(PageRepositary.selectbusineesunit);
     input(PageRepositary.selectbusineesunit,"india");
     click(PageRepositary.indiabusinessunit);
     click(PageRepositary.selectprojectsector);
     click(PageRepositary.publicsector);
     ExtentTestManager.getTest().log(Status.PASS,"details to create a new client request is provided");
     ExtentTestManager.endTest();
     
     //saving client request
     ExtentTestManager.startTest("TC_49 saving the client request");
     ScrollUntilElementVisible(PageRepositary.savebutton);
     click(PageRepositary.savebutton);
     ExtentTestManager.getTest().log(Status.PASS,"new client request saved successfully");
     ExtentTestManager.endTest();
     ExtentTestManager.startTest("TC_50 saved client request moved to saved requests");
     ExtentTestManager.endTest();
     //Attaching document after saving
     ExtentTestManager.startTest("TC_51 verify to attach the first client document");
     click(PageRepositary.addDocumentbutton);
     click(PageRepositary.attachbutton);
     click(PageRepositary.datepick);
     click(PageRepositary.nextmonth);
     click(PageRepositary.nextmonth);
     click(PageRepositary.nextmonth);
     click(PageRepositary.nextmonth);
     click(PageRepositary.date);
     uploadfileattachment("\\src\\test\\resources\\sample.pdf");
     ExtentTestManager.endTest();
     ExtentTestManager.startTest("TC_52 verifying the first document is uploaded");
     click(PageRepositary.uploadbutton);
     Thread.sleep(3000);
     ExtentTestManager.endTest();
     
     //Attaching second doc
     ExtentTestManager.startTest("TC_53 verify to attach the second client document");
     click(PageRepositary.attachdoc2);
     click(PageRepositary.datepick);
     click(PageRepositary.nextmonth);
     click(PageRepositary.nextmonth);
     click(PageRepositary.nextmonth);
     click(PageRepositary.nextmonth);
     click(PageRepositary.date);
     uploadfileattachment("\\src\\test\\resources\\sample.pdf");
     ExtentTestManager.endTest();
     ExtentTestManager.startTest("TC_54 verifying the second document is uploaded");
     click(PageRepositary.uploadbutton);
     Thread.sleep(3000);
     ExtentTestManager.endTest();
     
     
     //verifying document fields is available only after saving
     //ExtentTestManager.startTest("TC_12 verifying document field is enabled");
     //click(PageRepositary.checkbox);
     //ExtentTestManager.getTest().log(Status.PASS,"checkbox is enabled after saving client request");
     //ExtentTestManager.endTest();
     
     //submitting the client request
     ExtentTestManager.startTest("TC_55 submitting a client request");
     ScrollUntilElementVisible(PageRepositary.submitbutton);
     click(PageRepositary.submitbutton);
     ExtentTestManager.getTest().log(Status.PASS,"client request submitted successfully");
     handlePopupDesktop();
     Thread.sleep(3000);
     ExtentTestManager.endTest();
     ExtentTestManager.startTest("TC_56 validating client request is submitted successfully");
     ExtentTestManager.endTest();
     //navigating to saved request page 
     ExtentTestManager.startTest("TC_57 navigating to saved request page");
     ScrollUntilElementVisible(PageRepositary.clickOnproject);
     click(PageRepositary.clickOnproject);
     Thread.sleep(1000);
     click(PageRepositary.Clickonclients);
     Thread.sleep(2000);
     click(PageRepositary.Savedclientpage);
     ExtentTestManager.endTest();
     
     //verifying saved request page
     ExtentTestManager.startTest("TC_58 valuating saved request page and elements");
     ExtentTestManager.getTest().log(Status.PASS,"displayed all the saved client requests");
     Thread.sleep(2000);
     ElementDisplayedsavedclientrequests();
     ExtentTestManager.getTest().log(Status.PASS,"all columns of saved client request page is verified");
     ExtentTestManager.endTest();
     
     //download saved request details
     ExtentTestManager.startTest("TC_71 download saved request details");
     click(PageRepositary.downloadicon);
     ExtentTestManager.getTest().log(Status.PASS,"saved client request list downloaded");
     ExtentTestManager.endTest();
     
   //search in clientlist page
     ExtentTestManager.startTest("TC_72 search is available in saved client request page");
     click(PageRepositary.searchicon);
     click(PageRepositary.searchfield);
     ExtentTestManager.endTest();
     ExtentTestManager.startTest("TC_73 search is performed");
     input(PageRepositary.searchfield,"clien");
     click(PageRepositary.searchbutton);
     ExtentTestManager.getTest().log(Status.PASS,"search performed");
     Thread.sleep(2000);
     click(PageRepositary.searchclose);
     ExtentTestManager.endTest();  
     
     //display saved client request details
     ExtentTestManager.startTest("TC_74 display the detail of a client in saved request page");
     click(PageRepositary.selectsavedclient);
     ExtentTestManager.getTest().log(Status.PASS,"details of selected saved client request displayed");
     Thread.sleep(2000);
     ExtentTestManager.endTest();
     ExtentTestManager.startTest("TC_75 verifying close button in saved request page");
     click(PageRepositary.closebutton);
     handlePopupDesktop();
     Thread.sleep(3000);
     ExtentTestManager.endTest();
     
     //navigating to submitted client request page
     ExtentTestManager.startTest("TC_76 navigating to submitted client request page");
     ScrollUntilElementVisible(PageRepositary.clickOnproject);
     click(PageRepositary.clickOnproject);
     Thread.sleep(1000);
     click(PageRepositary.Clickonclients);
     Thread.sleep(2000);
     click(PageRepositary.submittedclientpage);
     ExtentTestManager.getTest().log(Status.PASS,"displayed all the submitted client requests");
     ExtentTestManager.endTest();
     
     //Verifying the submitted request page
     ExtentTestManager.startTest("TC_77 Verifying the submitted request page and its elements");
     ElementDisplayedsubmittedclientrequest();
     ExtentTestManager.getTest().log(Status.PASS,"all columns of submitted client request page is verified");
     ExtentTestManager.endTest();
     
     //downloading the submitted request details
     ExtentTestManager.startTest("TC_92 downloading the submitted request details");
     click(PageRepositary.downloadicon);
     ExtentTestManager.getTest().log(Status.PASS,"submitted client request list downloaded");
     ExtentTestManager.endTest();
     
     //search in submitted request page page
     ExtentTestManager.startTest("TC_93 search in submitted request page page");
     click(PageRepositary.searchicon);
     click(PageRepositary.searchfield);
     ExtentTestManager.endTest();  
     ExtentTestManager.startTest("TC_94 search is performed submitted request page page");
     input(PageRepositary.searchfield,"clien");
     click(PageRepositary.searchbutton);
     ExtentTestManager.getTest().log(Status.PASS,"search performed");
     Thread.sleep(2000);
     click(PageRepositary.searchclose);
     ExtentTestManager.endTest();  
     
     
     
       return true;
   }
  public boolean ElementDisplayedDashboard() throws InterruptedException {
	    ExtentTestManager.startTest("TC_03 allocated project graph is displayed");
		boolean flag1=ElementDisplayed(PageRepositary.allocatedprojectgraph);
		System.out.println("allocated project graph is displayed ");
		ExtentTestManager.endTest(); 
		ExtentTestManager.startTest("TC_04 Hours graph graph is displayed");
		boolean flag2=ElementDisplayed(PageRepositary.hoursgraph);
		System.out.println("Hours graph graph is displayed");
		ExtentTestManager.endTest();
		ExtentTestManager.startTest("TC_05 Project utilization  graph is displayed");
		boolean flag3=ElementDisplayed(PageRepositary.projectutilizationgraph);
		System.out.println("Project utilization  graph is displayed");
		ExtentTestManager.endTest();
		boolean flag= flag1 & flag2 & flag3;
				return flag;
	}
  public boolean ElementDisplayedclientlist() throws InterruptedException {
	    ExtentTestManager.startTest("TC_11 Clientname is displayed");
		boolean flag1=ElementDisplayed(PageRepositary.Clientnamecolumn);
		System.out.println("Clientname is displayed "+ flag1);
		ExtentTestManager.getTest().log(Status.PASS,"clientname is is displayed");
		ExtentTestManager.endTest();
		ExtentTestManager.startTest("TC_12 Clientcode is displayed");
		boolean flag2=ElementDisplayed(PageRepositary.Clientcodecolumn);
		System.out.println("Clientcode is displayed "+ flag2);
		ExtentTestManager.getTest().log(Status.PASS,"code  is displayed");
		ExtentTestManager.endTest();
		ExtentTestManager.startTest("TC_13 Clientcontactperson is displayed");
		boolean flag3=ElementDisplayed(PageRepositary.Clientcontactpersoncolumn);
		System.out.println("Clientcontactperson is displayed "+ flag3);
		ExtentTestManager.getTest().log(Status.PASS,"clientcontactperson is displayed");
		ExtentTestManager.endTest();
		ExtentTestManager.startTest("TC_14 Clientcontactnumber is displayed");
		boolean flag4=ElementDisplayed(PageRepositary.Clientcontactnumbercolumn);
		System.out.println("Clientcontactnumber is displayed "+ flag4);
		ExtentTestManager.getTest().log(Status.PASS,"clientcontactnumber is displayed");
		ExtentTestManager.endTest();
		ExtentTestManager.startTest("TC_15 clientcontactemail is displayed");
		boolean flag5=ElementDisplayed(PageRepositary.clientcontactemailcolumn);
		System.out.println("clientcontactemail is displayed "+ flag5);
		ExtentTestManager.endTest();
		ExtentTestManager.startTest("TC_16 clientcompanywebsite is displayed");
		boolean flag6=ElementDisplayed(PageRepositary.clientcompanywebsitecolumn);
		System.out.println("clientcompanywebsite is displayed "+ flag6);
		ExtentTestManager.endTest();
		ExtentTestManager.startTest("TC_17 clientaddress is displayed");
		boolean flag7=ElementDisplayed(PageRepositary.clientaddresscolumn);
		System.out.println("clientaddress is displayed "+ flag7);
		ExtentTestManager.endTest();
		ExtentTestManager.startTest("TC_18 addnewbutton is displayed");
		boolean flag8=ElementDisplayed(PageRepositary.addnewbutton);
		System.out.println("addnewbutton is displayed "+ flag8);
		ExtentTestManager.endTest();
		ExtentTestManager.startTest("TC_19 searchicon is displayed");
		boolean flag9=ElementDisplayed(PageRepositary.searchicon);
		System.out.println("searchicon is displayed "+ flag9);
		ExtentTestManager.endTest();
		ExtentTestManager.startTest("TC_20 downloadicon is displayed");
		boolean flag10=ElementDisplayed(PageRepositary.downloadicon);
		System.out.println("downloadicon is displayed "+ flag10);
		ExtentTestManager.endTest();
		ExtentTestManager.startTest("TC_21 pagination is displayed");
		boolean flag11=ElementDisplayed(PageRepositary.pagination);
		System.out.println("pagination is displayed "+ flag11);
		ExtentTestManager.endTest();
		ExtentTestManager.startTest("TC_22 totalitems is displayed");
		boolean flag12=ElementDisplayed(PageRepositary.totalitems);
		System.out.println("totalitems is displayed "+ flag12);
		ExtentTestManager.endTest();
		boolean flag= flag1 & flag2 & flag3 & flag4 & flag5 & flag6 & flag7 & flag8 & flag9 & flag10 & flag11 & flag12;
				return flag;
	}
  public boolean ElementDisplayedsubmittedclientrequest() throws InterruptedException {
	    ExtentTestManager.startTest("TC_78 clientname is displayed");
		boolean flag1=ElementDisplayed(PageRepositary.Clientnamecolumn);
		System.out.println("Clientname is displayed "+ flag1);
		ExtentTestManager.endTest();
		ExtentTestManager.startTest("TC_79 clientcode is displayed");
		boolean flag2=ElementDisplayed(PageRepositary.Clientcodecolumn);
		System.out.println("Clientcode is displayed "+ flag2);
		ExtentTestManager.endTest();
		ExtentTestManager.startTest("TC_80 clientcontactperson is displayed");
		boolean flag3=ElementDisplayed(PageRepositary.Clientcontactpersoncolumn);
		System.out.println("Clientcontactperson is displayed "+ flag3);
		ExtentTestManager.endTest();
		ExtentTestManager.startTest("TC_81 clientcontactnumber is displayed");
		boolean flag4=ElementDisplayed(PageRepositary.Clientcontactnumbercolumn);
		System.out.println("Clientcontactnumber is displayed "+ flag4);
		ExtentTestManager.endTest();
		ExtentTestManager.startTest("TC_82 clientcontactemail is displayed");
		boolean flag5=ElementDisplayed(PageRepositary.clientcontactemailcolumn);
		System.out.println("clientcontactemail is displayed "+ flag5);
		ExtentTestManager.endTest();
		ExtentTestManager.startTest("TC_83 clientcompanywebsite is displayed");
		boolean flag6=ElementDisplayed(PageRepositary.clientcompanywebsitecolumn);
		System.out.println("clientcompanywebsite is displayed "+ flag6);
		ExtentTestManager.endTest();
		ExtentTestManager.startTest("TC_84 clientcountry is displayed");
		boolean flag7=ElementDisplayed(PageRepositary.clientcountrycolumn);
		System.out.println("clientcountry is displayed "+ flag7);
		ExtentTestManager.endTest();
		ExtentTestManager.startTest("TC_85 clientzipcode is displayed");
		boolean flag8=ElementDisplayed(PageRepositary.clientzipcodecolumn);
		System.out.println("clientzipcode is displayed "+ flag8);
		ExtentTestManager.endTest();
		ExtentTestManager.startTest("TC_86 clientrequestedby is displayed");
		boolean flag9=ElementDisplayed(PageRepositary.clientrequestedbycolumn);
		System.out.println("clientrequestedby is displayed "+ flag9);
		ExtentTestManager.endTest();
		ExtentTestManager.startTest("TC_87 addnewbutton is displayed");
		boolean flag10=ElementDisplayed(PageRepositary.addnewbutton);
		System.out.println("addnewbutton is displayed "+ flag10);
		ExtentTestManager.endTest();
		ExtentTestManager.startTest("TC_88 searchicon is displayed");
		boolean flag11=ElementDisplayed(PageRepositary.searchicon);
		System.out.println("searchicon is displayed "+ flag11);
		ExtentTestManager.endTest();
		ExtentTestManager.startTest("TC_89 downloadicon is displayed");
		boolean flag12=ElementDisplayed(PageRepositary.downloadicon);
		System.out.println("downloadicon is displayed "+ flag12);
		ExtentTestManager.endTest();
		ExtentTestManager.startTest("TC_90 pagination is displayed");
		boolean flag13=ElementDisplayed(PageRepositary.pagination);
		System.out.println("pagination is displayed "+ flag13);
		ExtentTestManager.endTest();
		ExtentTestManager.startTest("TC_91 totalitems is displayed");
		boolean flag14=ElementDisplayed(PageRepositary.totalitems);
		System.out.println("totalitems is displayed "+ flag14);
		ExtentTestManager.endTest();
		boolean flag= flag1 & flag2 & flag3 & flag4 & flag5 & flag6 & flag7 & flag8 & flag9 & flag10 & flag11 & flag12 & flag13 & flag14;
				return flag;
	}
  public boolean ElementDisplayedsavedclientrequests() throws InterruptedException {
	    ExtentTestManager.startTest("TC_59 allocated project graph is displayed");
		boolean flag1=ElementDisplayed(PageRepositary.Clientnamecolumn);
		System.out.println("Clientname is displayed "+ flag1);
		ExtentTestManager.endTest();
		ExtentTestManager.startTest("TC_60 allocated project graph is displayed");
		boolean flag2=ElementDisplayed(PageRepositary.Clientcodecolumn);
		System.out.println("Clientcode is displayed "+ flag2);
		ExtentTestManager.endTest();
		ExtentTestManager.startTest("TC_61 allocated project graph is displayed");
		boolean flag3=ElementDisplayed(PageRepositary.Clientcontactpersoncolumn);
		System.out.println("Clientcontactperson is displayed "+ flag3);
		ExtentTestManager.endTest();
		ExtentTestManager.startTest("TC_62 allocated project graph is displayed");
		boolean flag4=ElementDisplayed(PageRepositary.Clientcontactnumbercolumn);
		System.out.println("Clientcontactnumber is displayed "+ flag4);
		ExtentTestManager.endTest();
		ExtentTestManager.startTest("TC_63 allocated project graph is displayed");
		boolean flag5=ElementDisplayed(PageRepositary.clientcontactemailcolumn);
		System.out.println("clientcontactemail is displayed "+ flag5);
		ExtentTestManager.endTest();
		ExtentTestManager.startTest("TC_64 allocated project graph is displayed");
		boolean flag6=ElementDisplayed(PageRepositary.clientcompanywebsitecolumn);
		System.out.println("clientcompanywebsite is displayed "+ flag6);
		ExtentTestManager.endTest();
		ExtentTestManager.startTest("TC_65 allocated project graph is displayed");
		boolean flag7=ElementDisplayed(PageRepositary.clientaddresscolumn);
		System.out.println("clientaddress is displayed "+ flag7);
		ExtentTestManager.endTest();
		ExtentTestManager.startTest("TC_66 allocated project graph is displayed");
		boolean flag8=ElementDisplayed(PageRepositary.addnewbutton);
		System.out.println("addnewbutton is displayed "+ flag8);
		ExtentTestManager.endTest();
		ExtentTestManager.startTest("TC_67 allocated project graph is displayed");
		boolean flag9=ElementDisplayed(PageRepositary.searchicon);
		System.out.println("searchicon is displayed "+ flag9);
		ExtentTestManager.endTest();
		ExtentTestManager.startTest("TC_68 allocated project graph is displayed");
		boolean flag10=ElementDisplayed(PageRepositary.downloadicon);
		System.out.println("downloadicon is displayed "+ flag10);
		ExtentTestManager.endTest();
		ExtentTestManager.startTest("TC_69 allocated project graph is displayed");
		boolean flag11=ElementDisplayed(PageRepositary.pagination);
		System.out.println("pagination is displayed "+ flag11);
		ExtentTestManager.endTest();
		ExtentTestManager.startTest("TC_70 allocated project graph is displayed");
		boolean flag12=ElementDisplayed(PageRepositary.totalitems);
		System.out.println("totalitems is displayed "+ flag12);
		ExtentTestManager.endTest();
		boolean flag= flag1 & flag2 & flag3 & flag4 & flag5 & flag6 & flag7 & flag8 & flag9 & flag10 & flag11 & flag12;
				return flag;
	}
  public boolean ElementDisplayedclientrequest() throws InterruptedException {
	    ExtentTestManager.startTest("TC_31 clientname is displayed");
		boolean flag1=ElementDisplayed(PageRepositary.clientnameheading);
		ExtentTestManager.endTest();
		ExtentTestManager.startTest("TC_32 clientcode is displayed");
		boolean flag2=ElementDisplayed(PageRepositary.clientcodeheading);
		ExtentTestManager.endTest();
		ExtentTestManager.startTest("TC_33 contactperson is displayed");
		boolean flag3=ElementDisplayed(PageRepositary.contactpersonheading);
		ExtentTestManager.endTest();
		ExtentTestManager.startTest("TC_34 contactnumber is displayed");
		boolean flag4=ElementDisplayed(PageRepositary.contactnumberheading);
		ExtentTestManager.endTest();
		ExtentTestManager.startTest("TC_35 contactemail is displayed");
		boolean flag5=ElementDisplayed(PageRepositary.contactemailheading);
		ExtentTestManager.endTest();
		ExtentTestManager.startTest("TC_36 company website is displayed");
		boolean flag6=ElementDisplayed(PageRepositary.companywebsiteheading);
		ExtentTestManager.endTest();
		ExtentTestManager.startTest("TC_37 address1 is displayed");
		boolean flag7=ElementDisplayed(PageRepositary.address1heading);
		ExtentTestManager.endTest();
		ExtentTestManager.startTest("TC_38 address2 is displayed");
		boolean flag8=ElementDisplayed(PageRepositary.address2heading);
		ExtentTestManager.endTest();
		ExtentTestManager.startTest("TC_39 address3 is displayed");
		boolean flag9=ElementDisplayed(PageRepositary.address3heading);
		ExtentTestManager.endTest();
		ExtentTestManager.startTest("TC_40 country is displayed");
		boolean flag10=ElementDisplayed(PageRepositary.countryheading);
		ExtentTestManager.endTest();
		ExtentTestManager.startTest("TC_41 zipcode is displayed");
		boolean flag11=ElementDisplayed(PageRepositary.zipcodeheading);
		ExtentTestManager.endTest();
		ExtentTestManager.startTest("TC_42 accountmanager is displayed");
		boolean flag12=ElementDisplayed(PageRepositary.accountmanagerheading);
		ExtentTestManager.endTest();
		ExtentTestManager.startTest("TC_43 salesmanager is displayed");
		boolean flag13=ElementDisplayed(PageRepositary.salesmanagerheading);
		ExtentTestManager.endTest();
		ExtentTestManager.startTest("TC_44 salesexecutive is displayed");
		boolean flag14=ElementDisplayed(PageRepositary.salesexecutiveheading);
		ExtentTestManager.endTest();
		ExtentTestManager.startTest("TC_45 businessunit is displayed");
		boolean flag15=ElementDisplayed(PageRepositary.businessunitheading);
		ExtentTestManager.endTest();
		ExtentTestManager.startTest("TC_46 gst is displayed");
		boolean flag16=ElementDisplayed(PageRepositary.gstnoheading);
		ExtentTestManager.endTest();
		ExtentTestManager.startTest("TC_47 projectsector is displayed");
		boolean flag17=ElementDisplayed(PageRepositary.projectsectorheading);
		ExtentTestManager.endTest();
		boolean flag= flag1 & flag2 & flag3 & flag4 & flag5 & flag6 & flag7 & flag8 & flag9 & flag10 & flag11 & flag12 & flag13 & flag14 & flag15 & flag16 & flag17;
		System.out.println("all fields are displayed correctly in client request page  "+ flag);
				return flag;
	}
  //public boolean uploadFile(String filePath) {
	     //UploadFile(PageRepositary.Logoupload, filePath);
	             // return false;     
	    //  }
  
 // public void uploadlogofun() throws InterruptedException {
	  //String projectpath=System.getProperty("user.dir");
	 // Thread.sleep(3000);
    //  input(PageRepositary.Logoupload,  projectpath +"\src\test\resources\picture.jpg");
      //Thread.sleep(3000);
     // ExtentTestManager.getTest().log(Status.PASS,"logo uploaded");
  //}
  public boolean uploadfileattachment(String filePath) throws InterruptedException {
	  Thread.sleep(2000);
      UploadFile(PageRepositary.choosefile, filePath);
		return false;	    
      }
}
