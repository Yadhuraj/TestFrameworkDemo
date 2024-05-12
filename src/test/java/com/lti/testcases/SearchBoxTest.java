package com.lti.testcases;

import org.testng.annotations.Test;

import com.lti.pages.BaseClass;
import com.lti.pages.LoginPage;
import com.lti.pages.SearchCourse;

public class SearchBoxTest extends BaseClass{



	@Test(priority = 1)
	public void searchtest() throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		String username = excel.readCell(1, 0, "LoginData");
		String password = excel.readCell(1, 1, "LoginData");
		lp.login(username, password);
		
		SearchCourse search_course = new SearchCourse(driver);
		String course = excel.readCell(0, 0, "course");
		search_course.searchItem(course);
		
	}
	
}
