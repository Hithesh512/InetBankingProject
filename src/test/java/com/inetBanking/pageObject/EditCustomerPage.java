package com.inetBanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.inetBanking.testCases.BaseTest;

public class EditCustomerPage {

	@FindBy(xpath = "(//input)[1]")
	private WebElement CustomerIDTBox;
	
	@FindBy(xpath = "(//input[@type='submit'])[1]")
	private WebElement SubmitBtn;
	
	@FindBy(xpath = "//input[@name='emailid']")
	private WebElement EditEmailID;
	
	String text="";
	
	public EditCustomerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	
	}
	
	public void SetCustomerID(String customerID) {
		CustomerIDTBox.sendKeys(customerID); 
	}
	
	public void clickSubmit()
	{
		SubmitBtn.click();
	}
	
	public void EditEmail() throws InterruptedException
	{	EditEmailID.clear();
		Thread.sleep(2000);
		text = BaseTest.getRandomAlp(6)+"@gmail.com" ;
		EditEmailID.sendKeys(text);
	}
	
	public boolean verifyEmail()
	{
		String text2 = EditEmailID.getAttribute("value");
		if(text.equals(text2))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
