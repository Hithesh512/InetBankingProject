package com.inetBanking.testCases;


import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObject.LoginPage;

public class TC_LoginTest_001 extends BaseTest{

	@Test
	public void LoginTest() 
	{
	LoginPage l = new LoginPage(driver);
	
	l.setLogin(UserName);
	logger.info("UserName is Entered");
	
	l.setPassword(Password);
	logger.info("Password is Entered");
	
	l.clickLogin();
	logger.info("Clicked on Submit button");
	
	if(driver.getTitle().equals(HomePageTitle))
	{
		Assert.assertTrue(true);
		logger.info("Test is Pass");
	}
	
	else
	{
		Assert.assertTrue(false);
		logger.info("Test is Fail");
	}
	
	}
}
