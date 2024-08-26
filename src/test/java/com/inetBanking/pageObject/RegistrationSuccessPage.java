package com.inetBanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationSuccessPage {
	
	@FindBy(xpath = "//td[.='Customer ID']/..//td[2]")
	private static WebElement CustomerID;
	
	@FindBy(xpath = "//p[contains(.,'Successfully')]")
	private static WebElement successfullMessage;
	
	public  RegistrationSuccessPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	
	}
	
	public static String GetCustomerID() {
		return CustomerID.getText();
	}
	
	public boolean isSuccessfullMsgDisplayed()
	{
		return successfullMessage.isDisplayed();
	}
}
