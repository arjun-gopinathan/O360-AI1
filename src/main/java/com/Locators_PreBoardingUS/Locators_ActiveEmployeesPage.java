package com.Locators_PreBoardingUS;

import org.openqa.selenium.By;

public class Locators_ActiveEmployeesPage {
	
	public By activeEmployeesPageHeader = By.xpath("//li[contains(text(),'Active Employees')]");
	
	public By searchIcon = By.xpath("//div[@class='dropdown pull-left']//button[@id='dLabel']");
	public By searchDialogueBox = By.xpath("//h4[normalize-space()='Search']");
	public By searchColumnInSearchDialogueBox = By.xpath("//select[@id='SearchColumn']");
	public By searchTypeInSearchDialogueBox = By.xpath("//select[@id='SearchType']");
	public By searchValueInSearchDialogueBox = By.xpath("//input[@id='SearchValue']");
	public By searchBtn = By.xpath("//div[@class='modal-footer']//button[@id='dLabel']");
	
	public By searchedCandidateName = By.xpath("//tbody/tr/td[2]");

}
