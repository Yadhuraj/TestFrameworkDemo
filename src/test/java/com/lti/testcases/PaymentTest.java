package com.lti.testcases;

import org.testng.annotations.Test;

import com.lti.pages.BaseClass;
import com.lti.pages.DashBoard;
import com.lti.pages.LoginPage;
import com.lti.pages.PaymentPage;

public class PaymentTest extends BaseClass{

	@Test(priority=1)
	public void dashboard() throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		String username = excel.readCell(1, 0, "LoginData");
		String password = excel.readCell(1, 1, "LoginData");
		lp.login(username, password);
		
		DashBoard db = new DashBoard(driver);
		db.coursedashboard();
		
		String cardnumber = excel.readCell(0, 0, "payment");
		int  exp= (int)excel.readCellNum(0, 1, "payment");
		int cvc = (int)(excel.readCellNum(0, 2, "payment"));
		
		System.out.println("cardnumber: "+cardnumber);
		System.out.println("exp: "+exp);
		System.out.println("cvc: "+cvc);
		PaymentPage pp = new PaymentPage(driver);
		pp.makepayment(cardnumber, exp, cvc);
	}
}
