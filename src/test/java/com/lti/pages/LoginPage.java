package com.lti.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	/*
	 * initElements(): initElements is a static method in Page Factory class. Using
	 * the initElements method, one can initialize all the web elements located
	 * by @FindBy annotation.
	 * 
	 * lazy initialization: AjaxElementLocatorFactory is a lazy load concept in Page
	 * Factory. This only identifies web elements when used in any operation or
	 * activity. The timeout of a web element can be assigned to the object class
	 * with the help of the AjaxElementLocatorFactory.
	 */

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "nav a#loginlabel")
	public WebElement loginClick;
	@FindBy(id = "user_login")
	public WebElement username;
	@FindBy(id = "user_pass")
	public WebElement password;
	@FindBy(id = "wp-submit")
	public WebElement loginButton;
	
	@FindBy(css = "a#gk-login-toggle")
	public WebElement logoutelement;
	@FindBy(xpath = "//a[text()='Logout']")
	public WebElement logoutclick;

//	public void login() throws InterruptedException {
//		loginClick.click();
//		username.sendKeys("Demo12");
//		password.sendKeys("Test123456$");
//		loginButton.click();
//		Thread.sleep(3000);
//	}
	public void login(String user , String pass) throws InterruptedException {
		loginClick.click();
		username.sendKeys(user);
		password.sendKeys(pass);
		loginButton.click();
		Thread.sleep(3000);
	}
	public void logout() throws InterruptedException {
		logoutelement.click();
		logoutclick.click();
		Thread.sleep(3000);
	}
	}

