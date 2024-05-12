package com.lti.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	public final Properties prop = new Properties();

	public ConfigReader() throws IOException {
		FileInputStream ip = new FileInputStream("./Configuration/config.properties");
		try {
			this.prop.load(ip);
		} catch (Exception e) {

			System.out.println("Error in loading the property file: " + e.toString());
		}

	}

	public String getbrowser() {
		return this.prop.getProperty("browser");
	}

	public String geturl() {
		return this.prop.getProperty("testurl");
	}
}
