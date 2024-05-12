package com.lti.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class SceenShotCapture {

	public static void captureSc(WebDriver driver,String TestName) throws IOException
	{
		TakesScreenshot sc = ((TakesScreenshot)driver);
		
		File src = sc.getScreenshotAs(OutputType.FILE);
		File srcpath = new File(".//Screenshots//"+TestName+".png");
		
		FileUtils.copyFile(src, srcpath);
	}
}
