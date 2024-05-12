package com.lti.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCourse {
	WebDriver driver;

	public SearchCourse(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "div#primary_menu input[name='search_course']")
	WebElement searchboxinput;

	@FindBy(css = "div#primary_menu button")
	WebElement searchclick;

	public void searchItem(String course) {
		searchboxinput.sendKeys(course);
		searchclick.click();
	}

}
