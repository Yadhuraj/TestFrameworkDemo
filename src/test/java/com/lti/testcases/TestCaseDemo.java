package com.lti.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.lti.pages.BaseClass;
import com.lti.pages.LoginPage;
import com.lti.utilities.SceenShotCapture;

public class TestCaseDemo extends BaseClass {
	@Test(priority = 1, dataProvider = "LoginCredentails")
	public void testdemo(String user, String pass) throws IOException, InterruptedException {
		try {
			LoginPage loginpage = new LoginPage(driver);
			loginpage.login(user, pass);
			loginpage.logout();
		} catch (Exception e) {
			// TODO: handle exception
			SceenShotCapture.captureSc(driver, "testdemo");
			Assert.fail("Fail: "+e.toString());
		}
		

	}

	@DataProvider(name = "LoginCredentails")
	public String[][] data() throws IOException {

		int row = excel.countrow("LoginData");
		int col = excel.countcol("LoginData");

		String[][] data = new String[row][col];
		for (int i = 1; i <= row; i++) {
			for (int j = 0; j < col; j++) {
				data[i - 1][j] = excel.readCell(i, j, "LoginData");
				System.out.println("data: " + excel.readCell(i - 1, j, "LoginData"));
			}
		}
		return data;
	}
}
