package com.inetBanking.testCases;

import java.time.Duration;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObject.AddNewCustomer;
import com.inetBanking.pageObject.EditCustomerPage;
import com.inetBanking.pageObject.HomePage;
import com.inetBanking.pageObject.LoginPage;
import com.inetBanking.pageObject.NewAccountPage;
import com.inetBanking.pageObject.RegistrationSuccessPage;

public class TC_AddNewAccount_005 extends BaseTest {

	@Test
	public void AddNewAccount() throws InterruptedException
	{
		LoginPage l = new LoginPage(driver);
		l.setLogin(UserName);
		l.setPassword(Password);
		l.clickLogin();

		HomePage hp = new HomePage(driver);
		hp.clickAddCustomer();
		Thread.sleep(3000);

		driver.navigate().refresh();
		logger.info("closed the ads");
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
			
			logger.info("Customer added");

		}
		else
		{	
			logger.info("Customer not added");
			Assert.assertTrue(false);
		}
		
		RegistrationSuccessPage rs = new RegistrationSuccessPage(driver);
		String customerId = rs.GetCustomerID();
		
		hp.clickNewAccount();
		logger.info("Clicked New Account");
		
		NewAccountPage na = new NewAccountPage(driver);
		na.SetCustomerID(customerId);
		logger.info("Entered Customer ID");
		
		na.selectCurrentType();
		logger.info("Selected Current Account Type");
		
		na.setIntialDeposit();
		logger.info("Entered Intial Deposit");
		
		na.clickSubmit();
		logger.info("Clicked Submit");
		
		
		if(rs.isSuccessfullMsgDisplayed()==true)
		{
			Assert.assertTrue(true);
			logger.info("Testcase pass");
		}
		else
		{
			logger.info("TestCase fail");
			Assert.assertTrue(false);
		}

	}
}
