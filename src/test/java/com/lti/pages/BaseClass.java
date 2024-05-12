package com.lti.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.lti.utilities.BrowserFactory;
import com.lti.utilities.ConfigReader;
import com.lti.utilities.ExcelReader;

public class BaseClass {

	public static WebDriver driver;
	public ConfigReader config;
	public ExcelReader excel;
//	public static BrowserFactory bfactory;

	@BeforeTest
	public void beforetest() throws IOException {
		config = new ConfigReader();
		driver = BrowserFactory.setupDriver(driver, config.getbrowser());
		excel = new ExcelReader("./TestData/TestInfo.xlsx");
		driver.get(config.geturl());
	}

	@AfterTest
	public void aftertest() {
		BrowserFactory.quitdriver(driver);
	}
}
