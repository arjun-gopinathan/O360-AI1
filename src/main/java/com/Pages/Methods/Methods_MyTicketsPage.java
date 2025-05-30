package com.Pages.Methods;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.BasePackage.Base_Class;
import com.Page_Repositary.Locators_TicketPage;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class Methods_MyTicketsPage extends Base_Class {
	
	
	Locators_TicketPage locators =new Locators_TicketPage();
	
	
	public void navigateMyTickets() {
		try {
			 click(locators.ticketMenu);
			 Thread.sleep(2000);
			 ExtentTestManager.getTest().log(Status.PASS, "Clicked on 'Ticket Menu'");
			 Log.info("Navigate and Click on Ticket Menu");
			 click(locators.myTickets);
		     Thread.sleep(5000); 
			 ExtentTestManager.getTest().log(Status.PASS, "Clicked on 'MY Tickets'");
			 Log.info("Click on My Ticktes page");
		}catch(Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL, "Failed to land on My Tickets Page");
			Log.info("\"Failed to land on My Tickets Page");
			
		}	
	}
		
		public static void writeTicketNumberToExcel(String excelFilePath, String ticketNumber) throws IOException {
	    	FileInputStream fis = new FileInputStream(new String(excelFilePath));

	        // Create a workbook instance for an existing Excel file
	        XSSFWorkbook workbook = new XSSFWorkbook(fis);
	        
	        // Get the first sheet of the workbook (sheet index 0)
	        XSSFSheet sheet = workbook.getSheetAt(2);

	        // Create or get the row number 2 (third row, index 2)
	        XSSFRow row = sheet.getRow(1); // 0-based index, so this is row 3 in Excel

	        // If row doesn't exist, create it
	        if (row == null) {
	            row = sheet.createRow(2);
	        }

	        // Create or get the cell in column 9 (tenth column, index 9)
	        XSSFCell cell = row.createCell(5); // 0-based index, so this is column 10 in Excel

	        // Set the value in the cell
	        cell.setCellValue(ticketNumber);

	        // Write the changes back to the Excel file
	        fis.close(); // Close the input stream before writing
	        FileOutputStream fos = new FileOutputStream(new String(excelFilePath));
	        workbook.write(fos);
	        fos.close();

	        // Close the workbook
	        workbook.close();

	        System.out.println("Ticket number written to Excel file successfully.");
	    }
	

	public static String extractTicketNumberWithoutHash(String ticketNumber) {
			// Trim leading and trailing whitespace characters just in case
	        ticketNumber = ticketNumber.trim();

	        // Debugging: Print out the ticket number as it is, including any invisible characters
	        System.out.println("Ticket Number (raw): [" + ticketNumber + "]");

	        // Remove '#' from the beginning of the ticket number using regex
	        String result = ticketNumber.replaceFirst("^#", "");  // Replace the first '#' with an empty string

	        // Debugging: Print the result after removing the '#'
	        System.out.println("Ticket Number after removing '#': [" + result + "]");
	        
	        return result;
	    }
	public void confirmationMessageDisplayed( ) throws InterruptedException {
			try {
	            WebElement successMessageElement = driver.findElement(By.xpath("//span[contains(text(),'Ticket-#')]")); // Replace with actual locator           
	            // Step 1: Extract the text from the success message
	            String successMessage = successMessageElement.getText();            
	            // Step 2: Use regular expression to extract the dynamic ticket number
	            String ticketNumberPattern = "#[A-Za-z0-9/]+";
	            Pattern pattern = Pattern.compile(ticketNumberPattern);
	            Matcher matcher = pattern.matcher(successMessage);            
	            // Step 3: Validate that a ticket number is found in the success message
	            if (matcher.find()) {
	                String dynamicTicketNumber = matcher.group();
	                System.out.println("Ticket created successfully with Ticket Number: " + dynamicTicketNumber);
	                // Optionally, validate the format (e.g., ensure it follows the pattern #SPIND/PMO/XXXX)
	                // If you need a specific format, you can add additional checks here
	                Assert.assertTrue( dynamicTicketNumber.matches("#[A-Za-z0-9/]+"),"Ticket created successfully with Ticket Number:");               
	               
	                // Trim leading and trailing whitespace characters just in case
	                dynamicTicketNumber = dynamicTicketNumber.trim();
	                // Debugging: Print out the ticket number as it is, including any invisible characters
	                System.out.println("Ticket Number (raw): [" + dynamicTicketNumber + "]");
	                // Remove '#' from the beginning of the ticket number using regex
	                String resultTicketNumber = dynamicTicketNumber.replaceFirst("^#", "");  // Replace the first '#' with an empty string
	                // Debugging: Print the result after removing the '#'
	                System.out.println("Ticket Number after removing '#': [" + resultTicketNumber + "]");
	        
	                // Step 4: Write the ticket number to Excel
	                writeTicketNumberToExcel("D:\\O360AutomationAI\\O360\\src\\test\\resources\\TestData.xlsx", resultTicketNumber);
	            } else {
	            	Assert.fail("Ticket number not found in the success message");
	            }
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
				ExtentTestManager.getTest().log(Status.FAIL, "Failed to confirm ticket creation");
				Log.info("Failed to confirm ticket creation");
			}		
		}
	
	
	public void valiadteTicketStatusandTickets(String TicketStatus, String Tickets) {
		try {
			Select ticketStatus =new Select(driver.findElement(locators.ticketStatus));
			ticketStatus.selectByVisibleText(TicketStatus);
			 Thread.sleep(2000);
			 ExtentTestManager.getTest().log(Status.PASS, "Selected the + TicketStatus+ value from dropdown'");
			 Log.info("Selected the + TicketStatus+ value from dropdown");		
			 Select tickets=new Select(driver.findElement(locators.ticketsDropdown));
			 tickets.selectByVisibleText(Tickets);
			 System.out.println(Tickets);
			 Thread.sleep(2000);
			 ExtentTestManager.getTest().log(Status.PASS, "Selected the + Tickets+ value from dropdown");
			 Log.info("Selected the + Tickets+ value from dropdown");
		}catch(Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL, "Failed to select the values");
			Log.info("\"Failed to select the values");
		}
	}
	
	public void verifyMyTicketsPage() throws InterruptedException
	{
		try {
		Thread.sleep(1000);
		String pageHeader = driver.findElement(locators.myTicketsPage).getText();
		System.out.println(pageHeader);
		if(pageHeader.equals("Ticket List"))
		{
			ExtentTestManager.getTest().log(Status.PASS, "Successfully landed on My tickets Page");
			Log.info("Successfully landed on My Ticket Page");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "Failed to land on My tickets Page");
			Log.info("Failed to land on My tickets Page");
		}	
		}
        catch(Exception e) {
        	System.out.println(e);
        }
			
		}
	
		
	public void clickSearchIcon() throws InterruptedException {
        try {
			click(locators.searchTicketIcon);
			ExtentTestManager.getTest().log(Status.PASS, "Clicked search Icon");
			Log.info("Clicked search Icon");
		} catch (Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL, "Failed to clicked search Icon");
			Log.info("Failed to clicked search Icon");
		}
    }
	
	 public void isSearchDialogOpened() {
	    	
	       if(driver.findElement(locators.searchDialogueBox).isDisplayed())
	       {
	    	   ExtentTestManager.getTest().log(Status.PASS, "Search Dialogue Box is Opened");
	    	   Log.info("Search Dialogue Box is Opened");
	       }else {
	    	   ExtentTestManager.getTest().log(Status.FAIL, "Failed to open Search Dialogue Box");
	    	   Log.info("Failed to open Search Dialogue Box");
	       }
	    }

	    public void isSearchColumnSelectedByDefault() {
	    	
	    	Select searchColumn = new Select(driver.findElement(locators.searchColumnInSearchDialogueBox));
			WebElement selectedOption = searchColumn.getFirstSelectedOption();
			String actualValue = selectedOption.getText();
			if(actualValue.contains("Ticket"))
			{
				ExtentTestManager.getTest().log(Status.PASS, "'Ticket' is selected by default in Search Column");
		    	Log.info("'Ticket' is selected by default in Search Column");
			}else {
				ExtentTestManager.getTest().log(Status.PASS, "'Ticket' is not selected by default in Search Column");
		    	Log.info("'Ticket' is not selected by default in Search Column");
			}
	    }

	    public void isSearchTypeSelectedByDefault() {
	    	
	    	Select searchType = new Select(driver.findElement(locators.searchTypeInSearchDialogueBox));
			WebElement selectedOption = searchType.getFirstSelectedOption();
			String actualValue = selectedOption.getText();
			if(actualValue.contains("Starts with"))
			{
				ExtentTestManager.getTest().log(Status.PASS, "'Starts with' is selected by default in Search Type");
		    	Log.info("'Starts with' is selected by default in Search Type");
			}else {
				ExtentTestManager.getTest().log(Status.PASS, "'Starts with' is selected by default in Search Type");
		    	Log.info("'Starts with' is selected by default in Search Type");
			}
	    }
	    
	    public void searchTicket(String TicketId) {
	    	try {
	    		
		    	clear(locators.searchValueInSearchDialogueBox);
	    		Thread.sleep(2000);
		    	input(locators.searchValueInSearchDialogueBox,TicketId);
		    	ExtentTestManager.getTest().log(Status.PASS, "Entered Name ' + TicketId +'in Search Value Field");
		    	Log.info("Entered Name '"+TicketId +"'in Search Value Field");
	    		
	    	}catch(Exception e) {
	    		System.out.println(e);
	    	}
	    }
	    
	    public void verifysearchedTicketNumberDisplayed(String TicketNO) throws InterruptedException
		{
						
			if(driver.findElement(locators.searchedTicketNo).getText().equals(TicketNO))
			{
				ExtentTestManager.getTest().log(Status.PASS,"Searched Ticket Number Found : "+TicketNO );
				Log.info("Searched Ticket Number Found: "+TicketNO);	
			}else {
				ExtentTestManager.getTest().log(Status.FAIL,"Unable to find the searched Ticket Number : "+TicketNO);
				Log.info("Unable to find the searched Ticket Number : "+TicketNO);		
			}
		}
	    
	    public void validateMultipleDynamicTicketIDs() {
	        // Find all ticket elements (assuming they have a class 'ticket-id')
	    	try {
	        List<WebElement> ticketElements = driver.findElements(By.xpath("//span[@class='link ng-star-inserted']"));
	        
	        for (WebElement ticketElement : ticketElements) {
	            String ticketID = ticketElement.getText();
	            
	            // Validate each ticket ID
	            Assert.assertNotNull(ticketID, "Ticket ID is null!");
	            Assert.assertTrue(ticketID.matches("^[A-Za-z0-9]/*$"), "Ticket ID contains invalid characters!");
	            
	            System.out.println("Ticket ID: " + ticketID);  // Print for debugging
	        }
	        }catch(Exception e){
	    			System.out.println(e);
	    		}
	        
	    }
	    
	    public void clickSearchButton() throws InterruptedException {
		       
	    	try {
				click(locators.searchBtn);
				ExtentTestManager.getTest().log(Status.PASS, "Clicked search Button");
				Log.info("Clicked search button");
			} catch (Exception e) {
				System.out.println(e);
				ExtentTestManager.getTest().log(Status.FAIL, "Failed to clicked search Button");
				Log.info("Failed to clicked search button");
			}
		}
	    
	    public void clickOnSearchedTicket() throws InterruptedException{
	    	click(locators.searchedTicketNo);
	        ExtentTestManager.getTest().log(Status.PASS,"Clicked on searched ticket");
			Log.info("Clicked on searched ticket");	
	    	
	    }
	    
	    public void verifyTicketdetails() throws InterruptedException {
			try {
				
				boolean flag = ElementDisplayed(locators.viewTicketdisplayed);
				ExtentTestManager.getTest().log(Status.PASS, "'Ticket ' page is opened : " + flag);
				Log.info("'Ticket ' page is opened : " + flag);
			} catch (Exception e) {
				System.out.println(e);
				ExtentTestManager.getTest().log(Status.FAIL, "Failed to open 'Ticket' page");
				Log.info("Failed to open 'Ticket' page");
			}
		}
	    

	    public boolean areFieldsNonEditable() {	    	 	
	        return isFieldNonEditable(locators.disabledSubject)
	            && isFieldNonEditable(locators.disabledTicketOwner)
	            && isFieldNonEditable(locators.disabledCategory)
	            && isFieldNonEditable(locators.disabledTicketType)
	            && isFieldNonEditable(locators.disabledPriorityType)
	            && isFieldNonEditable(locators.disabledStatus);
	            	            
	    }
	   

	    
		public boolean isFieldNonEditable(By field) {	    	
	    	   String fieldName = ""; 
	    	   String fieldXPath = field.toString().replace("By.xpath: ", "").trim();
	    	   
	    	   try {
	    	        fieldName = driver.findElement(By.xpath(
	    	            "(" + fieldXPath + "/preceding-sibling::label | " +
	    	            fieldXPath + "/parent::*/label | " +
	    	            fieldXPath + "/parent::*/parent::*/label)[1]"
	    	        )).getText();
	    	    } catch (NoSuchElementException e) {
	    	        fieldName = "Unknown Field"; // Fallback if no label is found
	    	    }

	    	if(!driver.findElement( field).isEnabled())
	    	{	    		
	    		ExtentTestManager.getTest().log(Status.PASS, fieldName + " : is not editable");
				Log.info(fieldName + " :  is not editable");
				return true;
	    	}else {
	    		ExtentTestManager.getTest().log(Status.FAIL, fieldName + " :  is editable");
				Log.info(fieldName + " :  is editable");
				return false;
	    	}
	    }
		
		public void downloadTickets() {
                try {
				Thread.sleep(2000);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});",
						driver.findElement(locators.download));
				boolean flag = ElementDisplayed(locators.download);
				click(locators.download);
				ExtentTestManager.getTest().log(Status.PASS, "'Tickets ' are downloaded : " + flag);
				Log.info("'Tickets ' are downloaded : " + flag);
			} catch (Exception e) {
				System.out.println(e);
				ExtentTestManager.getTest().log(Status.FAIL, "Failed to download tickets");
				Log.info("Failed to download tickets");
			}
			
			
		}

	
	

}
