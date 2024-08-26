package com.inetBanking.testCases;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObject.HomePage;
import com.inetBanking.pageObject.LoginPage;
import com.inetBanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseTest {
	
	@Test(dataProvider = "LoginData")
	public void loginDDT(String usr,String pwd) throws InterruptedException
	{	
		
		LoginPage lp= new LoginPage(driver);
		logger.info("Data driven testing test case is executing");
		lp.setLogin(usr);
		logger.info("Username entered");
		
		lp.setPassword(pwd);
		logger.info("Password Entered");
		
		lp.clickLogin();
		logger.info("Login button Clicked");
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.info("login failed");
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login pass");
			HomePage homePage = new HomePage(driver);
			homePage.ClickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}
	
	public boolean isAlertPresent()
	{
		try {
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}
	
	@DataProvider(name = "LoginData")
	public String[][] getData()
	{
		String Xlpath = System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/Guru99.xlsx";
		int rownum = XLUtils.getRowCount(Xlpath,"Sheet1");
		int colnum = XLUtils.getCellCount(Xlpath, "Sheet1", 1);
		String [][] logindata = new String[rownum][colnum];
		
		for(int i =1;i<=rownum;i++)
		{
			for(int j = 0; j<colnum;j++)
			{
				logindata[i-1][j] = XLUtils.getCellData(Xlpath, "Sheet1", i, j);
				System.out.print(logindata[i-1][j]+" ");
			}
			System.out.println();
		}
		
		return logindata;
	}

}
