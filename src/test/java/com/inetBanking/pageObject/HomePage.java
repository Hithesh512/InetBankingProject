package com.inetBanking.pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(linkText = "Log out")
	private WebElement Logout;
	
	@FindBy(linkText = "New Customer")
	private WebElement AddCustomer;
	
	@FindBy(linkText = "Edit Customer")
	private WebElement EditCustomer;
	
	@FindBy(linkText = "New Account")
	private WebElement NewAccount;
	
	@FindBy(xpath = "//meta[@name='robots']")
	private WebElement SkipAdd;
	
	
	public HomePage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}
	
	public void ClickLogout()
	{
		Logout.click();
	}
	
	public void clickAddCustomer()
	{
		AddCustomer.click();
	}
	
	public void clickEditCustomer()
	{
		EditCustomer.click();
	}
	
	public void clickNewAccount()
	{
		NewAccount.click();
	}
	
}
