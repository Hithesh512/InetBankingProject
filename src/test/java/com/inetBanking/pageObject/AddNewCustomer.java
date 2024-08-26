package com.inetBanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.inetBanking.testCases.BaseTest;

public class AddNewCustomer {

	@FindBy(xpath = "//input[@name='name']")
	private WebElement CustomerNameTxtBox;
	
	@FindBy(xpath = "//input[@value='m']")
	private WebElement MaleRadioButton;
	
	@FindBy(xpath = "//input[@type='date']")
	private WebElement Calender;
	
	@FindBy(xpath = "//textarea[@name='addr']")
	private WebElement Address;

	@FindBy(xpath = "//input[@name='city']")
	private WebElement City;

	@FindBy(xpath = "//input[@name='state']")
	private WebElement State;

	@FindBy(xpath = "//input[@name='pinno']")
	private WebElement PinCode;
	
	@FindBy(xpath = "//input[@name='telephoneno']")
	private WebElement MobileNumber;
	
	@FindBy(xpath = "//input[@name='emailid']")
	private WebElement EmailID;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement Password;

	@FindBy(xpath = "//input[@name='sub']")
	private WebElement Submit;
	
	@FindBy(xpath = "//p[contains(text(),'Successfully')]")
	private WebElement SuccessMessage;
	
	public AddNewCustomer(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void getCustomerName() {
	
	CustomerNameTxtBox.sendKeys("hithesh");	
	}
	
	public void selecctMale()
	{
		MaleRadioButton.click();
	}
	
	public void getDOB()
	{
		Calender.sendKeys("12121997");
	}
	
	public void getAddress()
	{
		Address.sendKeys("tumkuru");
	}
	
	public void getCity() {
		City.sendKeys("tumkuru");
	}
	
	public void getState() {
		State.sendKeys("Karnataka");
	}
	
	public void getPincode(){
		PinCode.sendKeys("672217");
	}
	
	public void getPhoneNum() {
		MobileNumber.sendKeys(BaseTest.getRandomNum(10));
	}
	
	public void getEmail()
	{
		EmailID.sendKeys(BaseTest.getRandomAlp(6)+"@gmail.com");
	}
	
	public void getPassword()
	{
		Password.sendKeys(BaseTest.getRandomAlp(7));
	}
	
	
	public void clickSubmit()
	{
		Submit.click();
	}
	
	public boolean isSuccessMessageDisplayed()
	{
		return SuccessMessage.isDisplayed();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
