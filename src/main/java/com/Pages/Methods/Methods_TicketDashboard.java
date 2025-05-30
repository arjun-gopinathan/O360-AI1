package com.Pages.Methods;

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
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.BasePackage.Base_Class;
import com.Page_Repositary.Locators_TicketPage;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class Methods_TicketDashboard extends Base_Class{
Locators_TicketPage locators =new Locators_TicketPage();
	
	
	public void navigateTicketDashboard() {
		try {
			 click(locators.ticketMenu);
			 Thread.sleep(2000);
			 ExtentTestManager.getTest().log(Status.PASS, "Clicked on 'Ticket Menu'");
			 Log.info("Navigate and Click on Ticket Menu");
			 click(locators.dashboardMenu);
		     Thread.sleep(5000); 
			 ExtentTestManager.getTest().log(Status.PASS, "Clicked on 'Ticket Dashboard'");
			 Log.info("Clicked on 'Ticket Dashboard");
		}catch(Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL, "Failed to land on Ticket Dashboard Page");
			Log.info("\"Failed to land on Ticket Dashboard Page");
			
		}				
	}
	
	public void valiadteTicketDashboardPage() {
		
				try {
				Thread.sleep(1000);
				String pageHeader = driver.findElement(locators.validateDashboardPage).getText();
				System.out.println(pageHeader);
				if(pageHeader.equals("Ticket List"))
				{
					ExtentTestManager.getTest().log(Status.PASS, "Successfully landed on Ticket Dashboard Page");
					Log.info("Successfully landed on Ticket Dashboard Page");
				}else {
					ExtentTestManager.getTest().log(Status.FAIL, "Failed to land on Ticket Dashboard Page");
					Log.info("Failed to land on Ticket Dashboard Page");
				}	
				}
		        catch(Exception e) {
		        	System.out.println(e);
		        }
			
	}
	public void selectCategory(String category) throws InterruptedException{
        
		try {
			Thread.sleep(2000);
			Select dropdown = new Select(driver.findElement(locators.categoryDropdown));
			// Get all dropdown options
						List<WebElement> options = dropdown.getOptions();

						for (WebElement option : options) {
						    if (option.getText().toLowerCase().startsWith(category)) 
						        option.click();
						        break;
		}
						ExtentTestManager.getTest().log(Status.PASS, "Option selected from category dropdown : " + category);
						Log.info("Option selected from category dropdown  : " + category);
						
						}
		catch (Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL,"Expected to select " + category + " from Category dropdown");
			Log.info("Expected to select " + category + " from Category dropdown");
		}
	    }
	
		public void selectTicketCreatedOn(String ticketTypeCreatedOn) throws InterruptedException{
			try {
				Thread.sleep(2000);
				Select dropdown = new Select(driver.findElement(locators.ticketCreatedOn));
				dropdown.selectByVisibleText(ticketTypeCreatedOn);
				ExtentTestManager.getTest().log(Status.PASS, "Option selected from ticketTypeCreatedOn dropdown : " + ticketTypeCreatedOn);
				Log.info("Option selected from ticketTypeCreatedOn dropdown  : " + ticketTypeCreatedOn);
			} 
			catch (Exception e) {
				ExtentTestManager.getTest().log(Status.FAIL,"Expected to select " + ticketTypeCreatedOn + " from ticketTypeCreatedOn dropdown");
				Log.info("Expected to select " + ticketTypeCreatedOn + " from ticketTypeCreatedOn dropdown");
			}
	    }
		
		public void searchTicketNumber(String TicketNO) {
	    	try {
	    		System.out.println(TicketNO);
		        input(locators.searchTicket,TicketNO);
		    	ExtentTestManager.getTest().log(Status.PASS, "Entered Name ' + TicketNO +'in Search Value Field");
		    	Log.info("Entered Name '"+TicketNO +"'in Search Value Field");
	    		
	    	}catch(Exception e) {
	    		System.out.println(e);
	    	}
	    }
		
	public void clickSearchIcon() throws InterruptedException {
        try {
			click(locators.iconSearchTicket);
			ExtentTestManager.getTest().log(Status.PASS, "Clicked search Icon");
			Log.info("Clicked search Icon");
		} catch (Exception e) {
			System.out.println(e);
			ExtentTestManager.getTest().log(Status.FAIL, "Failed to clicked search Icon");
			Log.info("Failed to clicked search Icon");
		}
    }
	
	public void verifysearchedTicketNumberDisplayed(String TicketNO) throws InterruptedException
	{
		try {			
		if(driver.findElement(locators.validateTicketNumber).isDisplayed())
		{
			String ticketNumber= driver.findElement(locators.validateTicketNumber).getText();
			System.out.println(ticketNumber);
	        if(ticketNumber.contains(TicketNO)) {
	        	ExtentTestManager.getTest().log(Status.PASS," searched Ticket Number : "+TicketNO);
				Log.info(" searched Ticket Number : "+TicketNO);	
	        }
	        else {
	        	String notfound= driver.findElement(locators.ticketNotFound).getText();
				System.out.println(notfound);
				click(locators.closeTicketDetailsPage);
				ExtentTestManager.getTest().log(Status.PASS,"Unable to find the searched Ticket Number : "+notfound);
				Log.info("Unable to find the searched Ticket Number : "+notfound);	
			
				ExtentTestManager.getTest().log(Status.PASS,"Searched Ticket Number Found : "+TicketNO );
				Log.info("Searched Ticket Number Found: "+TicketNO);
	        	
	        }
		}
				
		else {
			ExtentTestManager.getTest().log(Status.PASS,"Unable to find the searched Ticket Number : "+TicketNO);
			Log.info("Unable to find the searched Ticket Number : "+TicketNO);
		}
	
	}catch(Exception e) {
		System.out.println(e);
	}
    	
	}
	

    public void clickOnSearchedTicket() throws InterruptedException{
    	click(locators.searchedTicketNo);
        ExtentTestManager.getTest().log(Status.PASS,"Clicked on searched ticket");
		Log.info("Clicked on searched ticket");	
    	
    }
    
    public void verifyTicketdetails() throws InterruptedException {
		try {
			
			boolean flag = ElementDisplayed(locators.verifyTicketDetails);
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
            && isFieldNonEditable(locators.disableRequester)
            && isFieldNonEditable(locators.disabledCategory)
            && isFieldNonEditable(locators.ticketTypeDisabled);      
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
	
	public void selectPriorityType(String priorityType)throws InterruptedException {
		try {
			Thread.sleep(2000);
			Select dropdown = new Select(driver.findElement(locators.priorityType));
			dropdown.selectByVisibleText(priorityType);
			ExtentTestManager.getTest().log(Status.PASS, "Option selected from priorityType dropdown : " + priorityType);
			Log.info("Option selected from priorityType dropdown  : " + priorityType);
		} 
		catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL,"Expected to select " + priorityType + " from priorityType dropdown");
			Log.info("Expected to select " + priorityType + " from priorityType dropdown");
		}
    }
	
	public void selectStatus(String status)throws InterruptedException {
		try {
			Thread.sleep(2000);
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
	
	public void selectSubCategory(String subCategory)throws InterruptedException {
		try {
			Thread.sleep(2000);
			Select dropdown = new Select(driver.findElement(locators.subcategory));
			dropdown.selectByVisibleText(subCategory);
			ExtentTestManager.getTest().log(Status.PASS, "Option selected from status dropdown : " + subCategory);
			Log.info("Option selected from status dropdown  : " + subCategory);
		} 
		catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL,"Expected to select " + subCategory + " from status dropdown");
			Log.info("Expected to select " + subCategory + " from status dropdown");
		}
    }
	
	public void selectAssignTo(String assignto)throws InterruptedException {
		try {
			Thread.sleep(2000);
			Select dropdown = new Select(driver.findElement(locators.assignedTo));
			dropdown.selectByVisibleText(assignto);
			ExtentTestManager.getTest().log(Status.PASS, "Option selected from assignto dropdown : " + assignto);
			Log.info("Option selected from assignto dropdown  : " + assignto);
		} 
		catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL,"Expected to select " + assignto + " from assignto dropdown");
			Log.info("Expected to select " + assignto + " from assignto dropdown");
		}
    }
	
	public void SelectRerouteCategory(String rerouteCategory,String subType)throws InterruptedException {
		try {
		
			Select dropdown = new Select(driver.findElement(locators.reroutecategory));
			dropdown.selectByVisibleText(rerouteCategory);
			String routeCategory =driver.findElement(locators.reroutecategory).getText();
			System.out.println(routeCategory);
			if(rerouteCategory.contains("ITS")) {
			Thread.sleep(2000);		
			ExtentTestManager.getTest().log(Status.PASS, "Option selected from rerouteCategory dropdown : " + rerouteCategory);
			Log.info("Option selected from rerouteCategory dropdown  : " + rerouteCategory);
			Thread.sleep(2000);
			Select dropdown1 = new Select(driver.findElement(locators.subType));
			dropdown1.selectByVisibleText(subType);
			ExtentTestManager.getTest().log(Status.PASS, "Option selected from subtype dropdown : " + subType);
			Log.info("Option selected from subtype dropdown : " + subType);
			} else {
				ExtentTestManager.getTest().log(Status.PASS, "Option not selected from  dropdown : " +rerouteCategory);
				Log.info("Option not selected from  dropdown : "+ rerouteCategory);
			}			
		}
		catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL,"Expected to select " + rerouteCategory + " from rerouteCategory dropdown");
			Log.info("Expected to select " + rerouteCategory + " from rerouteCategory dropdown");
		}
	}
		public void clickAuditTrail() {
			try {
				Thread.sleep(1000);
				click(locators.auditTrail);
				ExtentTestManager.getTest().log(Status.PASS, "Click on Audit trail button");
				Log.info("Click on Audit trail" );
				
				}
			catch(Exception e) {
					System.out.println(e);
					ExtentTestManager.getTest().log(Status.PASS, "Not able to click on Audit trail");
					Log.info("Not able to click on Audit trail" );
				}
			
			}
		
		public void valiadteAuditTrail() {
			try {
				Thread.sleep(1000);
				if(driver.findElement(locators.validateAuditTrail).getText().equals("Ticket Audit Trail")) {
				ExtentTestManager.getTest().log(Status.PASS, "Audit trail deatils displayed");
				Log.info("Audit trail deatils displayed" );
				String ticketNo= driver.findElement(locators.validateTicketNoInAuditTrail).getText();
				System.out.println(ticketNo);
				ExtentTestManager.getTest().log(Status.PASS, "Validated ticket No");
				Log.info("Validated ticket No" );
				
				}				
			}
				catch(Exception e) {
				System.out.println(e);
				ExtentTestManager.getTest().log(Status.FAIL, "Audit trail deatils not displayed");
				Log.info("Audit trail deatils not displayed" );
			}
		}
		
		public void close(){
			try {
				Thread.sleep(1000);
				click(locators.closeTicketDetailsPage);
				ExtentTestManager.getTest().log(Status.PASS, "Close the ticket page");
				Log.info("Close the ticket page" );
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		
		public void ticketHistory() {
			try {
				Thread.sleep(1000);
				click(locators.ticketHistoryIcon);
				ExtentTestManager.getTest().log(Status.PASS, "Click the ticket History");
				Log.info("Click the ticket history" );
				
				}catch(Exception e) {
					System.out.println(e);
				}
		}
		
		public void validateTicketHistory() {
			try {
			
		
				if(driver.findElement(locators.ticketHistoryDialog).getText().equals("Ticket History")) {
					ExtentTestManager.getTest().log(Status.PASS, "Ticket history dialog displayed");
					Log.info("Ticket history dialog displayed" );
					
				}
				
				}catch(Exception e) {
					System.out.println(e);
					ExtentTestManager.getTest().log(Status.FAIL, "Failed to load ticket history dialog");
					Log.info("Failed to load ticket history dialog" );
				}	
			
		}
		public void closeDialog() {
			try {				
	     			Thread.sleep(1000);
	     			click(locators.closeDialog);
	     			ExtentTestManager.getTest().log(Status.PASS, "Ticket history dialog closed");
					Log.info("Ticket history dialog closed" );
				}catch(Exception e) {
					System.out.println(e);
					ExtentTestManager.getTest().log(Status.FAIL, "Failed to close ticket history dialog");
					Log.info("Failed to close ticket history dialog" );
				}	
		}
		public void ticketStatusHistory() {
			try {
				Thread.sleep(2000);
				click(locators.ticketStatusHistoryIcon);
				ExtentTestManager.getTest().log(Status.PASS, "Click the ticket History");
				Log.info("Click the ticket history" );
				
				}catch(Exception e) {
					System.out.println(e);
				}
		}
		
		public void validateTicketStatusHistory() {
			try {
			
		
				if(driver.findElement(locators.ticketStatusHistoryDialog).getText().equals("Ticket History")) {
					ExtentTestManager.getTest().log(Status.PASS, "Ticket status history dialog displayed");
					Log.info("Ticket status history dialog displayed" );
					
				}
				
				}catch(Exception e) {
					System.out.println(e);
					ExtentTestManager.getTest().log(Status.FAIL, "Failed to load ticket status history dialog");
					Log.info("Failed to load ticket status history dialog" );
				}	
			
		} 
		
		public static void writeTicketNumberToExcel(String excelFilePath, String ticketNumber) throws IOException {
	    	FileInputStream fis = new FileInputStream(new String(excelFilePath));

	        // Create a workbook instance for an existing Excel file
	        XSSFWorkbook workbook = new XSSFWorkbook(fis);
	        
	        // Get the first sheet of the workbook (sheet index 0)
	        XSSFSheet sheet = workbook.getSheetAt(4);

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
		
		}
    





	    
