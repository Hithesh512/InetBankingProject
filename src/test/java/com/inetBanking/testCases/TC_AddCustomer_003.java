package com.inetBanking.testCases;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.inetBanking.pageObject.AddNewCustomer;
import com.inetBanking.pageObject.HomePage;
import com.inetBanking.pageObject.LoginPage;

public class TC_AddCustomer_003 extends BaseTest{

	@Test
	public void addCustomer() throws InterruptedException
	{
		LoginPage l = new LoginPage(driver);
		l.setLogin(UserName);
		l.setPassword(Password);
		l.clickLogin();

		HomePage hp = new HomePage(driver);
		hp.clickAddCustomer();
		Thread.sleep(3000);

		driver.navigate().refresh();
		Thread.sleep(3000);

		hp.clickAddCustomer();
		logger.info("Clicked add Customer");
		Thread.sleep(3000);


		AddNewCustomer ac = new AddNewCustomer(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));
		ac.getCustomerName();
		logger.info("Entered Customer Name");
		ac.selecctMale();
		logger.info("Selected Male");
		ac.getDOB();
		logger.info("Entered DOB");
		ac.getAddress();
		logger.info("Entered Address");
		ac.getCity();
		logger.info("Entered City Name");
		ac.getState();
		logger.info("Entered State Name");
		ac.getPincode();
		logger.info("Entered Pincode");
		ac.getPhoneNum();
		logger.info("Entered PhoneNumber");
		ac.getEmail();
		logger.info("Entered Email");
		ac.getPassword();
		logger.info("Entered Password");
		Thread.sleep(3000);
		ac.clickSubmit();
		logger.info("Clicked submit");
		Thread.sleep(3000);


		if(ac.isSuccessMessageDisplayed()==true)
		{
			Assert.assertTrue(true);
			logger.info("TestCase Pass");

		}
		else
		{	logger.info("TestCase Fail");
		Assert.assertTrue(false);
		}


	}

}
