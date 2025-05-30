package com.Pages.Methods;

import java.awt.Robot;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.BasePackage.Base_Class;
import com.Page_Repositary.Locators_TicketPage;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;
import java.time.Duration;
public class Methods_QuickTickets extends Base_Class {
	
	SoftAssert Assert = new SoftAssert();
	Locators_TicketPage locators = new Locators_TicketPage();
	
	public void navigateToTicketCreation() {
		try {
			 click(locators.quickTickets);
			 Thread.sleep(2000);
			 ExtentTestManager.getTest().log(Status.PASS, "Clicked on Quick Tickets'");
			 Log.info("Navigate and Click on Quick tickets");
		     
		}catch(Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL, "Failed to cick on quick Tickets");
			Log.info("\"Failed to cick on quick Tickets");		
		}			
       
    }
	
	public void valiadteQuickTickets() {
		
		try {
		Thread.sleep(1000);
		String quickTicketHeader = driver.findElement(locators.ticketSideBar).getText();
		System.out.println(quickTicketHeader);
		if(quickTicketHeader.contains("Ticket"))
		{
			ExtentTestManager.getTest().log(Status.PASS, "Successfully landed on Quick tickets");
			Log.info("Successfully landed on Quick tickets");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "Failed to land on quick tickets");
			Log.info("Failed to land on quick tickets");
		}	
		}
        catch(Exception e) {
        	System.out.println(e);
        }	
}
	public void clickNewTicket() {
		try {
			 click(locators.newTicketQuick);
			 Thread.sleep(2000);
			 ExtentTestManager.getTest().log(Status.PASS, "Clicked on new ticket");
			 Log.info("Clicked on new ticket");
		     
		}catch(Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL, "Failed to cick on new Tickets");
			Log.info("\"Failed to cick on new Tickets");		
		}		
	}
    
    public void enterRequiredFields(String subject, String category,String ticketType,String priorityType,String watcher1,String description) {
    	 try {
			   
			   Thread.sleep(2000);
			   clear(locators.subjectField);
			   Thread.sleep(1000);
			   input(locators.subjectField,subject);
			   Thread.sleep(2000);
			   ExtentTestManager.getTest().log(Status.PASS, "Enter the subject");
			   Log.info("Enter the subjet");
			   Thread.sleep(1000);
			   Select dropdown = new Select(driver.findElement(locators.categoryDropdown));
			   dropdown.selectByVisibleText(category);
			   ExtentTestManager.getTest().log(Status.PASS, "Option selected from category dropdown : " + category);
			   Log.info("Option selected from category dropdown  : " + category);
			   Thread.sleep(1000);
			   Select dropdown1 = new Select(driver.findElement(locators.ticketTypeDropdown));
			   dropdown1.selectByVisibleText(ticketType);
			   ExtentTestManager.getTest().log(Status.PASS, "Option selected from ticketType dropdown : " + ticketType);
			   Log.info("Option selected from ticketType dropdown  : " + ticketType);
			   Thread.sleep(2000);
			   Select dropdown3 = new Select(driver.findElement(locators.ticketPriorityDropdown));
			   dropdown3.selectByVisibleText(priorityType);
			   ExtentTestManager.getTest().log(Status.PASS, "Option selected from priorityType dropdown : " + priorityType);
			   Log.info("Option selected from priorityType dropdown  : " + priorityType);
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
				//Enter the description
				Thread.sleep(2000);			
				 // Locate the iframe by its ID, Name, XPath, or CSS Selector
		        WebElement iframeSwitch = driver.findElement(locators.iframeaddDescription);  
		        // Switch to the iframe
		        driver.switchTo().frame(iframeSwitch);
		        ExtentTestManager.getTest().log(Status.PASS, "Switch to frame");
				Thread.sleep(1000);
				input(locators.addDescriptionText,description);
				ExtentTestManager.getTest().log(Status.PASS, " Add description about ticket " + description);
				Log.info(" Add description about ticket  : " + description);
				Thread.sleep(1000);
				// Switch back to the main content (default page)
		        driver.switchTo().defaultContent();
		        ExtentTestManager.getTest().log(Status.PASS, " Switch back to default page");
		        Thread.sleep(2000);
			} 
		 catch (Exception e) {
				System.out.println(e);
				ExtentTestManager.getTest().log(Status.FAIL, "Failed to enter the required fields");
				Log.info("Failed to enter the required fields");
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
    
    public void submitButton() throws InterruptedException {
		
		try {
			ElementToBeVisible(locators.quickSubmit);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});",
					driver.findElement(locators.quickSubmit));
			click(locators.quickSubmit);
			Thread.sleep(2000);
			ExtentTestManager.getTest().log(Status.PASS, " Clicked on submit button " );
			Log.info(" Clicked on submit button  : ");
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
			ElementToBeVisible(locators.quickClose);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});",
					driver.findElement(locators.quickClose));
			click(locators.quickClose);
			Thread.sleep(2000);
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
                Thread.sleep(2000);
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
	
	public void clickOKONConfirmationPopup() {
		try {
			click(locators.confirmationMessage);
			Thread.sleep(4000);
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
		
    public void clickCloseButton() {
    	try {
			ElementToBeVisible(locators.quickClose);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});",
					driver.findElement(locators.quickClose));
			click(locators.quickClose);
			Thread.sleep(2000);
			ExtentTestManager.getTest().log(Status.PASS, " Clicked on close button " );
			Log.info(" Clicked on close button  : ");
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
			ExtentTestManager.getTest().log(Status.FAIL," Not able to click on close button ");
			Log.info(" Not able to click on close button");
		}
    }
    
    public void quickTicketCloseButton() throws Exception{
    	try {
    		Thread.sleep(2000);
			ElementToBeVisible(locators.closeBtn);
		    JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement XBtn = driver.findElement(locators.closeBtn);
            js.executeScript("arguments[0].scrollIntoView(true);", XBtn);
			// Optional: Use the click() method as a fallback
            XBtn.click();
            ExtentTestManager.getTest().log(Status.PASS," Close the opened ticket ");
			Log.info("Close the opened ticket ");
    		
    	}catch (Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL," Not able to click on close button ");
			Log.info(" Not able to click on close button");
		}
    }
    
    public void openTicketCloseButton() throws Exception{
    	try {
    		Thread.sleep(2000);
			ElementToBeVisible(locators.xBtn);
		    JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement XBtn = driver.findElement(locators.xBtn);
            js.executeScript("arguments[0].scrollIntoView(true);", XBtn);
			// Optional: Use the click() method as a fallback
            XBtn.click(); 
            ExtentTestManager.getTest().log(Status.PASS," Close the quick ticket page ");
			Log.info("Close the quick ticket page");
    	}catch (Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL," Not able to click on close button ");
			Log.info(" Not able to click on close button");
		}
    }
    public static void writeTicketNumberToExcel(String excelFilePath, String ticketNumber) throws IOException {
    	FileInputStream fis = new FileInputStream(new String(excelFilePath));

        // Create a workbook instance for an existing Excel file
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        
        // Get the first sheet of the workbook (sheet index 0)
        XSSFSheet sheet = workbook.getSheetAt(6);

        // Create or get the row number 2 (third row, index 2)
        XSSFRow row = sheet.getRow(1); // 0-based index, so this is row 3 in Excel

        // If row doesn't exist, create it
        if (row == null) {
            row = sheet.createRow(2);
        }

        // Create or get the cell in column 9 (tenth column, index 9)
        XSSFCell cell = row.createCell(10); // 0-based index, so this is column 10 in Excel

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
    
    public void navigateAndClickOnOpenTickets() {
    	try {
    		Thread.sleep(2000);
    		click(locators.openTicketsQuick);
    		ExtentTestManager.getTest().log(Status.PASS,"Navigate and click on Open tickets");
			Log.info("Navigate and click on Open tickets");
		}catch(Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL,"Not able to Navigate and click on Open tickets");
			Log.info("Not able to Navigate and click on Open tickets");
    	}
    }
    	 public void verifysearchedTicketNumberDisplayed(String TicketNO) throws InterruptedException
			{
							
				if(driver.findElement(locators.validateTicketAssigned).getText().equals(TicketNO))
				{
					ExtentTestManager.getTest().log(Status.PASS,"Searched Ticket Number Found : "+TicketNO );
					Log.info("Searched Ticket Number Found: "+TicketNO);	
				}else {
					ExtentTestManager.getTest().log(Status.FAIL,"Unable to find the searched Ticket Number : "+TicketNO);
					Log.info("Unable to find the searched Ticket Number : "+TicketNO);		
				}
			}
    
    
    public void validateOpenTickets() {
    	try {
    		Thread.sleep(2000);
    		click(locators.viewticketSideBar);
    		ExtentTestManager.getTest().log(Status.PASS,"Successfully open the tickets sidebar");
			Log.info("Successfully open the tickets sidebar");
		}catch(Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL,"Not able to Successfully open the tickets sidebar");
			Log.info("Not able to Successfully open the tickets sidebar");
    	}    	
    }
    public void enterInprogressStatusAddComments(String description)throws InterruptedException {
		try {
			click(locators.expandAddComments);
			ExtentTestManager.getTest().log(Status.PASS, " Click on add comments:");
			Log.info("  Click on add comments: ");
			Thread.sleep(1000);
			
			 // Locate the iframe by its ID, Name, XPath, or CSS Selector
	        WebElement iframe = driver.findElement(locators.iframeinprogresscomments);  // Modify with actual iframe locator
	   /*     JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});",
					driver.findElement(locators.switchFrame)); */

	        // Switch to the iframe
	        driver.switchTo().frame(iframe);
			Thread.sleep(2000);
			input(locators.addCommentsText,description);
			Thread.sleep(1000);
			// Switch back to the main content (default page)
	        driver.switchTo().defaultContent();
			ExtentTestManager.getTest().log(Status.PASS, " Add description about ticket " + description);
			Log.info(" Add description about ticket  : " + description);
			Thread.sleep(2000);
			 JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});",
						driver.findElement(locators.send));
			click(locators.send);
			ExtentTestManager.getTest().log(Status.PASS," Click on send to add the comments ");
			Log.info("Click on send to add the comments ");
		} 
		catch (Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL," Add description about ticket as: " + description + " ");
			Log.info("Add description about ticket as: \" + description + \"");
		}
	}
    
    
    public void selectStatus(String status)throws InterruptedException {
		try {
			Thread.sleep(2000);
			ElementToBeVisible(locators.statusTicket);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});",
					driver.findElement(locators.statusTicket));
			Select dropdown = new Select(driver.findElement(locators.statusTicket));
			dropdown.selectByVisibleText(status);
			ExtentTestManager.getTest().log(Status.PASS, "Option selected from status dropdown : " + status);
			Log.info("Option selected from status dropdown  : " + status);
		} 
		catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL,"Expected to select " + status + " from status dropdown");
			Log.info("Expected to select " + status + " from status dropdown");
		}
    }
    public void resolvedAddComments(String ResolvedComments) {
  	  try {
							
			 // Locate the iframe by its ID, Name, XPath, or CSS Selector
  		  
	        WebElement iframe = driver.findElement(locators.switchFrameToResolvedComments1);  // Modify with actual iframe locator
	        // Switch to the iframe
	        driver.switchTo().frame(iframe);
			Thread.sleep(2000);
			input(locators.addResolvedComments,ResolvedComments);
			Thread.sleep(1000);
			// Switch back to the main content (default page)
	        driver.switchTo().defaultContent();
			ExtentTestManager.getTest().log(Status.PASS, " Add comments for resolving" + ResolvedComments);
			Log.info(" Add comments for resolving : " + ResolvedComments);
			Thread.sleep(2000);
			 JavascriptExecutor js1 = (JavascriptExecutor) driver;
				js1.executeScript("arguments[0].scrollIntoView({block: 'center'});",
						driver.findElement(locators.submitTicketComments));
			click(locators.submitTicketComments);
			ExtentTestManager.getTest().log(Status.PASS," Click on submit to add the comments ");
			Log.info("Click on submit to add the comments ");
		} 
		catch (Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL," Fail to add resolved comments " + ResolvedComments + " ");
			Log.info(" Fail to add resolved comments \" + ResolvedComments + \"");		  
  	  }
  	  
    }
    public void clickSearchIcon() throws InterruptedException {
        try {
        	Thread.sleep(2000);
        	click(locators.searchIconOpenTicket);
			ExtentTestManager.getTest().log(Status.PASS, "Clicked search Icon");
			Log.info("Clicked search Icon");
		} catch (Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL, "Failed to clicked search Icon");
			Log.info("Failed to clicked search Icon");
		}
    }
    
    public void clickOnSearchedTicket() throws InterruptedException{
    	
		try {
			click(locators.SeachedTicketNoOpenTickets);
	        ExtentTestManager.getTest().log(Status.PASS,"Clicked on searched ticket");
			Log.info("Clicked on searched ticket");	
		} catch (Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL, "Failed to click on searched ticket");
			Log.info("Failed to click on searched ticket");
		}
    }
    
    public void enterAddComments(String description)throws InterruptedException {
		try {
			click(locators.expandAddComments);
			ExtentTestManager.getTest().log(Status.PASS, " Click on add comments:");
			Log.info("  Click on add comments: ");
			Thread.sleep(2000);
			
			 // Locate the iframe by its ID, Name, XPath, or CSS Selector
	        WebElement iframe = driver.findElement(locators.iframeOpenTicket);  // Modify with actual iframe locator
	        // Switch to the iframe
	        driver.switchTo().frame(iframe);
			Thread.sleep(2000);
			input(locators.addCommentsText,description);
			Thread.sleep(1000);
			// Switch back to the main content (default page)
	        driver.switchTo().defaultContent();
			ExtentTestManager.getTest().log(Status.PASS, " Add description about ticket " + description);
			Log.info(" Add description about ticket  : " + description);
			Thread.sleep(2000);
			 JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});",
						driver.findElement(locators.send));
			click(locators.send);
			ExtentTestManager.getTest().log(Status.PASS," Click on send to add the comments ");
			Log.info("Click on send to add the comments ");
		} 
		catch (Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL," Add description about ticket as: " + description + " ");
			Log.info("Add description about ticket as: \" + description + \"");
		}
	}
    
    public void rateAndClose(String ratingStr) {
    	try {
            // Parse the rating string to an integer
            int rating = Integer.parseInt(ratingStr.trim()); // Convert the rating string to an integer          
            // Wait for the stars to be visible and intractable
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            List<WebElement> stars = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.star-container")));
            // Debugging: Print out the number of stars found on the page
            System.out.println("Stars found: " + stars.size());
            // Check if the stars list is not empty
            if (stars.isEmpty()) {
                System.out.println("No stars found on the page.");
                ExtentTestManager.getTest().log(Status.FAIL, "Stars are not available on the page");
                Log.info("Stars are not available on the page");
                return; // Exit the method if no stars are found
            }

            // Validate the rating value and click the corresponding star
            if (rating > 0 && rating<=stars.size() ) {
                // Scroll the star into view if it's not in the viewport
                WebElement starToClick = stars.get(rating - 1);
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", starToClick);
                
                // Wait for the star to be clickable
                wait.until(ExpectedConditions.elementToBeClickable(starToClick));
                
                // Click the star corresponding to the rating (rating - 1 because list is 0-indexed)
                starToClick.click();
                ExtentTestManager.getTest().log(Status.PASS, "Rating of the ticket: " + rating );
                Log.info("Rating of the ticket: " + rating );
            } else {
                // Invalid rating value
                System.out.println("Invalid rating value: " + rating);
                ExtentTestManager.getTest().log(Status.FAIL, "Invalid rating value: " + rating);
                Log.info("Invalid rating value: " + rating);
            }

    	}catch(Exception e) {
    		System.out.println(e);
    	}
    }
    
    public void userClosed(String user) throws InterruptedException {
		try{
			Thread.sleep(2000);
			input(locators.L_username,user);
			ExtentTestManager.getTest().log(Status.PASS, "Closed username entered successfully");
			Log.info("Closed username entered successfully");
			Thread.sleep(1000);
			input(locators.L_password,"O360@uaL!tY2O2twO");
			ExtentTestManager.getTest().log(Status.PASS, "Closed password entered successfully");
			Log.info("Closed password entered successfully");
			Thread.sleep(1000);
			click(locators.L_SignIn);
			ExtentTestManager.getTest().log(Status.PASS, "Clicked on signin successfully and Landed into home dashboard");
			Log.info("Clicked on signin successfully and Landed into home dashboard");
			Thread.sleep(4000);
		} catch (Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL, "Failed to login as Closed user");
			Log.info("Failed to login as closed user");
		}
	}
    
    public void saveAndClose() {
    	try {
    		 Thread.sleep(1000);   
    		 click(locators.saveAndClose);          
             ExtentTestManager.getTest().log(Status.PASS," Save and close the ticket");
    	     Log.info("Save and close the ticket"); 		
    	}catch(Exception e) {
    		System.out.println(e);
    		ExtentTestManager.getTest().log(Status.FAIL,"Not able to close the ticket");
			Log.info("Not able to close the ticket");
    	}
    }
    
    public void reopen() {
    	try {
    		 Thread.sleep(1000);   
    		 click(locators.reopen);          
             ExtentTestManager.getTest().log(Status.PASS,"Able to reopen the ticket");
    	     Log.info("Save and close the ticket"); 		
    	}catch(Exception e) {
    		System.out.println(e);
    		ExtentTestManager.getTest().log(Status.FAIL,"Not able to reopen the tikcet");
			Log.info("Not able to reopen the tikcet");
    	}
    }
    
     public void closedTabIframe() {
    	 try {
    		   		 
    	 }catch(Exception e) {
    		 System.out.println(e);
    	 }
     }
     
     public void closedTabLink() {
    	 try {
    		 Thread.sleep(1000);
    		 click(locators.closedTab);
    		 ExtentTestManager.getTest().log(Status.PASS,"Able to link on closed Tab");
    	     Log.info("Able to link on closed Tab");
    	 }catch(Exception e) {
    		 System.out.println(e);
    		 ExtentTestManager.getTest().log(Status.FAIL,"Not able to click on closed tikcet");
 			Log.info("Not able to click on closed tikcet");
    	 }    	 
     }
     
     public void taggedUser(String user) {
    	 try {
    		 Thread.sleep(2000);
 			input(locators.L_username,user);
 			ExtentTestManager.getTest().log(Status.PASS, "tagged username entered successfully");
 			Log.info("Tagged username entered successfully");
 			Thread.sleep(1000);
 			input(locators.L_password,"O360@uaL!tY2O2twO");
 			ExtentTestManager.getTest().log(Status.PASS, "tagged password entered successfully");
 			Log.info("Tagged password entered successfully");
 			Thread.sleep(1000);
 			click(locators.L_SignIn);
 			ExtentTestManager.getTest().log(Status.PASS, "Clicked on signin successfully and Landed into home dashboard");
 			Log.info("Clicked on signin successfully and Landed into home dashboard");
 			Thread.sleep(4000);
 		} catch (Exception e) {
 			System.out.println(e);
 			ExtentTestManager.getTest().log(Status.FAIL, "Failed to login as tagged user");
 			Log.info("Failed to login as tagged user");
 		}
    		 
    	 }
     
     public void taggedTabMenu() {
    	 try {
    		 Thread.sleep(1000);
    		 click(locators.taggedLink);
    		 ExtentTestManager.getTest().log(Status.PASS,"Able to click on tagged Tab");
    	     Log.info("Able to click on tagged Tab");
    	 }catch(Exception e) {
    		 System.out.println(e);
    		 ExtentTestManager.getTest().log(Status.FAIL,"Not able to click on tagged tab");
 			Log.info("Not able to click on tagged tab");
    	 }    	 
     }
     
     public void verifyReopenButton() {
    	 try {
    		 Thread.sleep(6000);
    		 WebElement button = driver.findElement(locators.reopen);  // Adjust the locator as needed

    	        // Check if the button is visible
    	        if (button.isDisplayed()) {
    	            System.out.println("Button is visible");
    	            ExtentTestManager.getTest().log(Status.PASS,"Button is visible");
    	 			Log.info("Button is visible");
    	        } else {
    	            System.out.println("Button is not visible");
    	            ExtentTestManager.getTest().log(Status.FAIL,"Button is not visible");
    	 			Log.info("Button is not visible");
    	        }

    	        // Check if the button is enabled
    	        if (button.isEnabled()) {
    	            System.out.println("Button is enabled");
    	            ExtentTestManager.getTest().log(Status.PASS,"Button is enabled");
    	 			Log.info("Button is enabled");
    	        } else {
    	            System.out.println("Button is disabled");
    	            ExtentTestManager.getTest().log(Status.FAIL,"Button is disabled");
    	 			Log.info("Button is disabled");
    	        }

    	 }catch(Exception e) {
    		 System.out.println(e);
    		 ExtentTestManager.getTest().log(Status.FAIL,"Button not present");
 			Log.info("Button not present");
    	 }    	 
     }
     }


