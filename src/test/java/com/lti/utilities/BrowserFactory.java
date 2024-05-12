package com.lti.utilities;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	public static WebDriver setupDriver(WebDriver driver, String browser) throws IOException {

		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			break;

		default:
			break;
		}

		return driver;
	}

	public static void quitdriver(WebDriver driver) {
		driver.quit();
	}

}
