package com.Pages.Methods;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import com.BasePackage.Base_Class;
import com.Page_Repositary.Locators_TicketPage;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class Methods_CreateTicket extends Base_Class{
	
	SoftAssert Assert =new SoftAssert();

	//to read from json file
	//JSONParser parser = new JSONParser();

	Locators_TicketPage locators = new Locators_TicketPage();
	
	public void CreateTicketPage() throws InterruptedException {
		 
	        try {
				click(locators.ticketMenu);
				 Thread.sleep(2000);
				 ExtentTestManager.getTest().log(Status.PASS, "Clicked on 'Ticket Menu'");
				 click(locators.newTicket);
			     Thread.sleep(5000); 
				 ExtentTestManager.getTest().log(Status.PASS, "Clicked on 'New ticket'");
			} catch (Exception e) {
				System.out.println(e);
				ExtentTestManager.getTest().log(Status.FAIL, "Failed to click on Menu and navigate to new ticket");
				Log.info("Failed to click on Menu and navigate to new ticket");
			}
	    }
	
	public void enterSubject(String subject) throws InterruptedException {
		 try {
			   
			   Thread.sleep(2000);
			   clear(locators.subjectField);
			   Thread.sleep(1000);
			   input(locators.subjectField,subject);
			   Thread.sleep(2000);
			   ExtentTestManager.getTest().log(Status.PASS, "Enter the subject");
			} 
		 catch (Exception e) {
				System.out.println(e);
				ExtentTestManager.getTest().log(Status.FAIL, "Failed to enter the subjet");
				Log.info("Failed to enter the subjet");
			}
	}
	public void selectCategory(String category) throws InterruptedException{
		        
	try {
		Thread.sleep(2000);
		Select dropdown = new Select(driver.findElement(locators.categoryDropdown));
		dropdown.selectByVisibleText(category);
		ExtentTestManager.getTest().log(Status.PASS, "Option selected from category dropdown : " + category);
		Log.info("Option selected from category dropdown  : " + category);
	} catch (Exception e) {
		ExtentTestManager.getTest().log(Status.FAIL,"Expected to select " + category + " from Category dropdown");
		Log.info("Expected to select " + category + " from Category dropdown");
	}
    }
	public void selectTicketType(String ticketType) throws InterruptedException{
		try {
			Thread.sleep(2000);
			Select dropdown = new Select(driver.findElement(locators.ticketTypeDropdown));
			dropdown.selectByVisibleText(ticketType);
			ExtentTestManager.getTest().log(Status.PASS, "Option selected from ticketType dropdown : " + ticketType);
			Log.info("Option selected from ticketType dropdown  : " + ticketType);
		} 
		catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL,"Expected to select " + ticketType + " from ticketType dropdown");
			Log.info("Expected to select " + ticketType + " from ticketType dropdown");
		}
    }
	public void selectPriorityType(String priorityType)throws InterruptedException {
		try {
			Thread.sleep(2000);
			Select dropdown = new Select(driver.findElement(locators.ticketPriorityDropdown));
			dropdown.selectByVisibleText(priorityType);
			ExtentTestManager.getTest().log(Status.PASS, "Option selected from priorityType dropdown : " + priorityType);
			Log.info("Option selected from priorityType dropdown  : " + priorityType);
		} 
		catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL,"Expected to select " + priorityType + " from priorityType dropdown");
			Log.info("Expected to select " + priorityType + " from priorityType dropdown");
		}
    }
	
	public void addWatchers(String watcher1)throws InterruptedException {
        try {
			Thread.sleep(2000);
			click(locators.addWatchers);
			Thread.sleep(2000);
			
			//Search and select watcher 1
			click(locators.searchWatchersToSelect);
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			Thread.sleep(2000);
			System.out.println(watcher1);
			jse.executeScript("arguments[0].value=arguments[1];", driver.findElement(locators.searchWatchersToSelect),watcher1);
			Thread.sleep(2000);
			driver.findElement(locators.searchWatchersToSelect).sendKeys(Keys.TAB);
			Thread.sleep(1000);
			driver.findElement(locators.searchWatchersToSelect).sendKeys(Keys.BACK_SPACE);
			Thread.sleep(1000);
			click(locators.selectWatcherCheckbox);
			Thread.sleep(2000);
			click(locators.deselecttheWatcher);
			ExtentTestManager.getTest().log(Status.PASS, "Option selected from watchers dropdown : " + watcher1 );
			Log.info("Option selected from watchers dropdown  : " + watcher1);
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
			ExtentTestManager.getTest().log(Status.FAIL,"Expected to select " + watcher1 +  " from watchers dropdown");
			Log.info("Expected to select " + watcher1 + " from watchers dropdown");
		}
    }
	
	

	public void enterDescription(String description)throws InterruptedException {
		try {
			//click(locators.expandDescription);
			Thread.sleep(2000);
			
			 // Locate the iframe by its ID, Name, XPath, or CSS Selector
	        WebElement iframe = driver.findElement(locators.switchFrame);  // Modify with actual iframe locator
	        // Switch to the iframe
	        driver.switchTo().frame(iframe);
			Thread.sleep(1000);
			input(locators.addDescriptionText,description);
			Thread.sleep(1000);
			// Switch back to the main content (default page)
	        driver.switchTo().defaultContent();
			ExtentTestManager.getTest().log(Status.PASS, " Add description about ticket " + description);
			Log.info(" Add description about ticket  : " + description);
		} 
		catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL," Add description about ticket as: " + description + " ");
			Log.info("Add description about ticket as: \" + description + \"");
		}
	}
	
	public void uploadFileTicket(String relativeFilePath) throws InterruptedException {
       try {        
	        String filepath = System.getProperty("user.dir") + relativeFilePath;
	        StringSelection selection = new StringSelection(filepath);
	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null); 
	        Robot robot = new Robot();
	   		// Simulate CTRL+V (Paste)
	   		robot.delay(1000); // Wait for the file dialog to appear
	   		robot.keyPress(KeyEvent.VK_CONTROL);
	   		robot.keyPress(KeyEvent.VK_V);
	   		robot.keyRelease(KeyEvent.VK_V);
	   		robot.keyRelease(KeyEvent.VK_CONTROL);

	   		// Simulate ENTER key
	   		robot.delay(500); // Small delay

	   		robot.keyPress(KeyEvent.VK_ENTER);
	   		robot.keyRelease(KeyEvent.VK_ENTER);
	   		ExtentTestManager.getTest().log(Status.INFO, "Selected Valid PDF file");         
       }
		catch(Exception e) {
		  System.out.println(e.getMessage());
          ExtentTestManager.getTest().log(Status.FAIL, " File not uploaded successfully " );
   		  Log.info(" File not uploaded successfully  ");
    	   
       }
       
    } 
       
  /*     public void uploadFileUsingRobot(String relativeFilePath) throws AWTException, InterruptedException {
    	   
    	// Locate the file input element
           WebElement uploadElement = driver.findElement(By.id("file-upload"));

           // Click the file input to open the file dialog
           uploadElement.click();
           String filePath = System.getProperty("user.dir") + relativeFilePath;
           StringSelection selection = new StringSelection(filePath);
           Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

           Robot robot = new Robot();

   		// Simulate CTRL+V (Paste)
   		robot.delay(1000); // Wait for the file dialog to appear
   		robot.keyPress(KeyEvent.VK_CONTROL);
   		robot.keyPress(KeyEvent.VK_V);
   		robot.keyRelease(KeyEvent.VK_V);
   		robot.keyRelease(KeyEvent.VK_CONTROL);

   		// Simulate ENTER key
   		robot.delay(500); // Small delay
   		robot.keyPress(KeyEvent.VK_ENTER);
   		robot.keyRelease(KeyEvent.VK_ENTER);
   		ExtentTestManager.getTest().log(Status.INFO, "Selected Valid PDF file");
   		
       } */
       
       
       	
		public void submitButton() throws InterruptedException {
			
			try {
				ElementToBeVisible(locators.submitButton);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});",
						driver.findElement(locators.submitButton));
				click(locators.submitButton);
				Thread.sleep(2000);
				ExtentTestManager.getTest().log(Status.PASS, " Clicked on submit button " );
				Log.info(" Clicked on submit button  : ");
			} 
			catch (Exception e) {
				System.out.println(e.getMessage());
				ExtentTestManager.getTest().log(Status.FAIL," Not able to click on submit button ");
				Log.info(" Not able to click on submit button");
			}
    }
		
		public void validateConfirmationPopUpDisplayed() {
			try {
				ElementToBeVisible(locators.ConfirmationMessageDialogAppear);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});",
						driver.findElement(locators.ConfirmationMessageDialogAppear));
				String confirmMessageDialogAppear =driver.findElement(locators.ConfirmationMessageDialogAppear).getText();
				System.out.println(confirmMessageDialogAppear);
				if(confirmMessageDialogAppear.contains("Ticket Submitted"));
				ExtentTestManager.getTest().log(Status.PASS,"Ticket Confirmation Meassge Dialog appears sucessfully");
				Log.info("Ticket Confirmation Meassge Dialog appears sucessfully");
				
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		public void confirmationMessage( ) throws InterruptedException {
			try {
			ElementToBeVisible(locators.confirmationMessageText);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});",
					driver.findElement(locators.confirmationMessageText));
			String confirmMessage =driver.findElement(locators.confirmationMessageText).getText();
			System.out.println(confirmMessage);
			
			if(confirmMessage.contains("Ticket-#"))
					{
				ExtentTestManager.getTest().log(Status.PASS, " Ticket-# has created successfully");
		    	Log.info("Ticket-# has created successfully");
			}else {
				ExtentTestManager.getTest().log(Status.PASS, "Ticket-# has not created successfully");
		    	Log.info("'Ticket-# has not created successfully");
			}		
			click(locators.confirmationMessage);
      		Thread.sleep(2000);
			
			ExtentTestManager.getTest().log(Status.PASS, "Clicked 'OK' Button in ticket Creation Requested Popup");
			Log.info("Clicked 'OK' Button in ticket Creation Requested Popup");
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
				ExtentTestManager.getTest().log(Status.FAIL, "Failed to confirm ticket creation");
				Log.info("Failed to confirm ticket creation");
			}
			
		}
		
		public static void writeTicketNumberToExcel(String excelFilePath, String ticketNumber) throws IOException {
	    	FileInputStream fis = new FileInputStream(new String(excelFilePath));

	        // Create a workbook instance for an existing Excel file
	        XSSFWorkbook workbook = new XSSFWorkbook(fis);
	        
	        // Get the first sheet of the workbook (sheet index 0)
	        XSSFSheet sheet = workbook.getSheetAt(1);

	        // Create or get the row number 2 (third row, index 2)
	        XSSFRow row = sheet.getRow(1); // 0-based index, so this is row 3 in Excel

	        // If row doesn't exist, create it
	        if (row == null) {
	            row = sheet.createRow(2);
	        }

	        // Create or get the cell in column 9 (tenth column, index 9)
	        XSSFCell cell = row.createCell(9); // 0-based index, so this is column 10 in Excel

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
		
		public void validateTicket() {
			try {
				Thread.sleep(2000);
				click(locators.searchedTicketNo);
				ExtentTestManager.getTest().log(Status.PASS,"Ticket created validated successfully");
				Log.info("Ticket created validated successfully");
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		
		public void closeTicketDetails() {
			try {
				Thread.sleep(2000);
				click(locators.closeTicketDetailsPage);
				ExtentTestManager.getTest().log(Status.PASS,"Close the ticket details");
				Log.info("Close the ticket details");
			}catch(Exception e) {
				System.out.println(e);
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

}
	
	
	

	


