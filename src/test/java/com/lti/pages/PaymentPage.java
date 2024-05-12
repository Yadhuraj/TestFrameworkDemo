package com.lti.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage {
	WebDriver driver;

	public PaymentPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "ul.payment-methods li label")
	WebElement payWithStripe;
	
	@FindBy(css = "input[value = 'Place order']")
	WebElement placeOrder;
	
	@FindBy(xpath = "//iframe[contains(@name,'privateStripeFrame')]")
	WebElement iframe;
	
	@FindBy(css = "input[name='cardnumber']")
	WebElement cardnumber;
	
	@FindBy(css = "input[name='exp-date']")
	WebElement expdate;
	
	@FindBy(css = "input[name='cvc']")
	WebElement cvc;
	
	public void makepayment(String cardnumber,int expdate ,int cvc) throws InterruptedException
	{
		Thread.sleep(2000);
		payWithStripe.click();
		Thread.sleep(5000);
//		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(placeOrder)).click();
		//when the button has input tag we should sue submit rather than click
		placeOrder.submit();
		driver.switchTo().frame(iframe);
//		this.cardnumber.sendKeys(String.valueOf(cardnumber));
		this.cardnumber.sendKeys(cardnumber);
		this.expdate.sendKeys(String.valueOf(expdate));
		this.cvc.sendKeys(String.valueOf(cvc));
//		this.cvc.sendKeys(cvc);
		
		Thread.sleep(5000);
	}
	
	
	
	
	

}
