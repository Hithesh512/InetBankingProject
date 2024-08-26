package com.inetBanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
@FindBy(name="uid")
private WebElement UerName;

@FindBy(name="password")
private WebElement Password;

@FindBy(name="btnLogin")
private WebElement login;

@FindBy(name="btnReset")
private WebElement Reset;


WebDriver driver;
public LoginPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver,this);
}


public void setLogin(String un)
{
	UerName.sendKeys(un);
}

public void setPassword(String Pwd)
{
	Password.sendKeys(Pwd);
}

public void clickLogin()
{
	login.click();
}

public void clickReset()
{
	Reset.click(); 
}





















}
