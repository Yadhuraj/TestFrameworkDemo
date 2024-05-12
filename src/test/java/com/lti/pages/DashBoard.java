package com.lti.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoard {
	WebDriver driver;

	public DashBoard(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Dashboard']")
	WebElement dashboard_button;
	
	@FindBy(xpath = "//a[text()='Offered Academies']")
	WebElement offered_academies_link;
	
	@FindBy(xpath = "//div[@class='learn-press-tab']//li[1]//button")
	WebElement subscribe_now_buttonx;
	
	public void coursedashboard()
	{
		dashboard_button.click();
		offered_academies_link.click();
		subscribe_now_buttonx.click();
	}
	
}
