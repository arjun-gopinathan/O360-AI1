package com.Locators_PreBoardingUS;

import org.openqa.selenium.By;

public class Locators_HomePage {
	
	public By Employee = By.xpath("//span[normalize-space()='Employee']");
	public By EmployeeSubMenu = By.xpath("//span[@class='item-name'][normalize-space()='Employee']");
	public By PreBoardingUS = By.xpath("//span[normalize-space()='PreBoarding US']");
	public By OnBoarding = By.xpath("(//span[normalize-space()='On Boarding'])[2]");
	public By CreateCandidate = By.xpath("//a[@href='#/employee/onboardingUs/createcandidate']");
	public By SavedCandidate = By.xpath("//span[normalize-space()='PreBoarding US']/../../ul/li/a[@href='#/employee/onboardingUs/savedcandidate']");
	public By HrOnboardingPending = By.xpath("//a[@href='#/employee/onboardingUs/savedcandidate']//span[text()='HR Onboarding Pending ']");
	public By PendingWithCandidate = By.xpath("//span[normalize-space()='PreBoarding US']/../../ul/li/a[@href='#/employee/onboardingUs/pendingcandidate']");
	public By PendingWithHR = By.xpath("//span[normalize-space()='PreBoarding US']/../../ul/li/a[@href='#/employee/onboardingUs/pendingHr']");
	public By HROnBoardingQueue = By.xpath("//span[normalize-space()='PreBoarding US']/../../ul/li/a[@href='#/employee/onboardingUs/onboradingHr']");
	public By CandidateOnBoarding = By.xpath("//a[@href='#/employee/onboardingUs/onboradingHr']//span[text()='Candidate OnBoarding ']");
	public By ActiveEmployee = By.xpath("//span[normalize-space()='Employee']/../../ul/li/a[@href='#/employee/employees']");
	public By Approvals = By.xpath("//span[@class='item-name'][normalize-space()='Approvals']");
	public By UsEmailApprovals = By.xpath("//a[@href='#/employee/onboardingUs/emailapproval']");
	
	public By SidePanelScroll = By.xpath("//ul[@class='navigation-left']");
	
	public By PopupDisplayedCovid = By.xpath("//div/button[1][text()=' Remind Me Later']");
	public By OkBtnCovid = By.xpath("//div/button[1][text()=' Remind Me Later']");
	public By PopupDisplayedDesktop = By.xpath("//*[@id=\"modal-basic-title\" and text()=' Desktop Notifications ']");
	public By dashBoard = By.xpath("//a[normalize-space()='Dashboard']");
	public By OkBtnDesktop = By.xpath("//div/button[2][text()='OK']");

}
