package com.inetBanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.inetBanking.testCases.BaseTest;

public class NewAccountPage {

	@FindBy(xpath = "(//input)[1]")
	private WebElement CustomerIDTBox;
	
	@FindBy(xpath = "(//input)[2]")
	private WebElement IntialDepositTBox;
	
	@FindBy(name = "selaccount")
	private WebElement AccountType;
	
	@FindBy(xpath = "(//input[@type='submit'])[1]")
	private WebElement SubmitBtn;
	
	
	
	public NewAccountPage(WebDriver driver) 
	{
	PageFactory.initElements(driver, this);	
	}
	
	public void SetCustomerID(String customerID)
	{
		CustomerIDTBox.sendKeys(customerID); 
	}

	public void setIntialDeposit()
	{
		IntialDepositTBox.sendKeys(BaseTest.getRandomNum(5));
	}
	
	public void selectCurrentType() {
		Select s = new Select(AccountType);
		s.selectByVisibleText("Current");
	}
	public void clickSubmit()
	{
		SubmitBtn.click();
	}
}
