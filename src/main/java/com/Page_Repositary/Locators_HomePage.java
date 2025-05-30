package com.Page_Repositary;

import org.openqa.selenium.By;

public class Locators_HomePage {
	
	public By SidePanelScroll = By.xpath("//ul[@class='navigation-left']");
	public By PopupDisplayedCovid = By.xpath("//div/button[1][text()=' Remind Me Later']");
	public By OkBtnCovid = By.xpath("//div/button[1][text()=' Remind Me Later']");
	public By PopupDisplayedDesktop = By.xpath("//*[@id=\"modal-basic-title\" and text()=' Desktop Notifications ']");
	public By dashBoard = By.xpath("//a[normalize-space()='Dashboard']");
	public By OkBtnDesktop = By.xpath("//div/button[2][text()='OK']");
	
}


