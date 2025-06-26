package allmenu;

import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;

import java.io.IOException;
import java.util.Map;
import java.util.regex.Pattern;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

	public class menunavigation {
		
	      com.Utility.ExcelReader ExcelReade =  new com.Utility.ExcelReader("TimeSheetNew");
	      
		@DataProvider(name = "TestData")
		public static Object[][] gettestdate() throws IOException {

			Object[][] objectarry = null;
			java.util.List<Map<String, String>> completedata = com.Utility.ExcelReader.getdata();

			objectarry = new Object[completedata.size()][1];

			for (int i = 0; i < completedata.size(); i++) {
				objectarry[i][0] = completedata.get(i);
			}
			return objectarry;
		}
		@Test(dataProvider = "TestData")
	  public void test(Map<Object, Object> testdata) {
	    try (Playwright playwright = Playwright.create()) {
	      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
	        .setHeadless(false));
	      BrowserContext context = browser.newContext();
	      Page page = context.newPage();
	      
	      String project = testdata.get("project").toString();
			String moduleName = testdata.get("module").toString();
			String year = testdata.get("year").toString();
			String month = testdata.get("month").toString();
			String day = testdata.get("day").toString();
			String weekViewRange = testdata.get("range").toString();
			String pmo = testdata.get("PMO").toString();
			String pwd = testdata.get("password").toString();
	     
	      ExtentTestManager.startTest("TestScenario05 : Verify Able to Log Timesheet in Day view");
	      page.navigate("https://o360qa.speridian.com/#/sessions/signin?returnUrl=%2Fdashboard%2Fv1");
	      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Username")).click();
	      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Username")).fill("clement.joseph");
	      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Username")).press("Tab");
	      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).click();
	      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).fill("O360@uaL!tY2O2twO");
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign In")).click();
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign In")).click();
	      ExtentTestManager.startTest("TestScenario05 : Verify Able to Log Timesheet in Day view");
	      page.navigate("https://o360qa.speridian.com/#/employee/profile");
	      page.locator("block-ui-content div").first().click();
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("OK")).click();
	      page.locator("span").filter(new Locator.FilterOptions().setHasText("Home")).click();
	      page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText("Self Service")).locator("i").click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" My Timesheet")).click();
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Week View")).click();
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Month View")).click();
	      page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Timesheet$"))).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Approvals")).click();
	      page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Leave$"))).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Dashboard")).click();
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("OK")).click();
	      page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Leave$"))).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Leave Calendar")).click();
	      page.locator("app-employee-leave-calendar i").nth(2).click();
	      page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Leave$"))).locator("i").click();
	      page.locator("app-sidebar-large a").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Leave$"))).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Employee Leave")).click();
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Search")).click();
	      page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Leave$"))).locator("i").click();
	      page.locator("a").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Leave$"))).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Leave Requests")).click();
	      page.getByText("Casual Leave", new Page.GetByTextOptions().setExact(true)).click();
	      page.getByText("Loss Of Pay").click();
	      page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Leave$"))).locator("span").click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" EWC")).click();
	      page.getByText("Comp off Credit").click();
	      page.getByText("Client Holiday").click();
	      page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Leave$"))).locator("i").click();
	      page.locator("a").filter(new Locator.FilterOptions().setHasText("Approvals")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Leave/EWC")).click();
	      page.getByRole(AriaRole.TAB, new Page.GetByRoleOptions().setName("EWC")).locator("span").click();
	      page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Expense$"))).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Dashboard")).click();
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("OK")).click();
	      page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Expense$"))).locator("span").click();
	      page.locator("a").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Expense$"))).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Assign Expense On Behalf")).click();
	      page.getByText("Self Service").click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" My Expense")).click();
	      page.getByText("Saved").click();
	      page.getByText("Approved").click();
	      page.getByText("Rejected").click();
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Close×")).click();
	      page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Expense$"))).locator("span").click();
	      page.locator("a").filter(new Locator.FilterOptions().setHasText("Approvals")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Expense Approval")).click();
	      page.getByText("Approved").click();
	      page.getByText("Ticket").click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" New Ticket")).click();
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Close").setExact(true)).click();
	      page.getByText("Ticket").click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" My Tickets")).click();
	      page.locator("#SearchItem").first().selectOption("1: 2");
	      page.locator("app-sidebar-large").getByText("Ticket", new Locator.GetByTextOptions().setExact(true)).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Approvals")).click();
	      page.locator("app-sidebar-large").getByText("Ticket", new Locator.GetByTextOptions().setExact(true)).click();
	      page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText("Projects")).locator("i").click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Dashboard")).click();
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("OK")).click();
	      page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Projects$"))).locator("i").click();
	      page.locator("a").filter(new Locator.FilterOptions().setHasText("Clients")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Client List")).click();
	      page.navigate("https://o360qa.speridian.com/#/project/clientList");
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add New")).click();
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Close×")).click();
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("OK")).click();
	      page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Projects$"))).locator("i").click();
	      page.locator("a").filter(new Locator.FilterOptions().setHasText("Clients")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Client Request")).click();
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Close×")).click();
	      page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Projects$"))).locator("i").click();
	      page.locator("a").filter(new Locator.FilterOptions().setHasText("Clients")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Saved Request 15")).click();
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Close×")).click();
	      page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Projects$"))).locator("i").click();
	      page.locator("a").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Allocation$"))).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Manage Allocation")).click();
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Close×")).click();
	      page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Projects$"))).locator("i").click();
	      page.locator("a").filter(new Locator.FilterOptions().setHasText("Approvals")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Allocation Approval List")).click();
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Close×")).click();
	      page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Projects$"))).locator("span").click();
	      page.locator("a").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Allocation$"))).click();
	      page.locator("a").filter(new Locator.FilterOptions().setHasText("Invoice request")).click();
	      page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Employee$"))).click();
	      page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^DMS$"))).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" My HR Documents")).click();
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Close×")).click();
	      page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText("Employee")).locator("i").click();
	      page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText("Performance")).locator("i").click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Dashboard")).click();
	      ExtentTestManager.getTest().log(Status.PASS, "Application Logout");
	    }
	  }
	}
	
