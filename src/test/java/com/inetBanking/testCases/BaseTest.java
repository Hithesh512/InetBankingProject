package com.inetBanking.testCases;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.utils.FileUtil;
import com.inetBanking.utilities.ReadConfig;

public class BaseTest {
	
	ReadConfig config =new ReadConfig();
	
	public String URL = config.getUrl();
	public String UserName = config.getUserName();
	public String Password = config.getPassword();
	public String HomePageTitle = config.GetHomePageTitle();
	public static WebDriver driver;
	
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{	
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j2.properties");

		if(br.equals("Chrome"))
		{	
			//ChromeOptions options = new ChromeOptions();
			//File AddblockPath = new File(System.getProperty("user.dir")+"\\Extensions\\SadBlocker.crx");
			//options.addExtensions(AddblockPath);
			//options.addArguments("--disable-notifications");
			//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", config.getChromePath());
			driver = new ChromeDriver();
			
		}
		else if(br.equals("Firefox"))
			{
			System.setProperty("webdriver.gecko.driver", config.getFirefoxPath());
			driver = new FirefoxDriver();
			}
		else
		{
			System.out.println("Browser parameter is not correct");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		logger.info("URl is Opened");
		
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException 
	{
		Thread.sleep(3000);
		driver.quit();
	}
	
	public void takeScreenShot() {
		
		
		try
		{
		File Src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File Des = new File(System.getProperty("user.dir")+"\\Screenshots\\"+getClass().getName()+".png");
			FileUtils.copyFile(Src,Des);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getRandomNum(int i)
	{
		String num = RandomStringUtils.randomNumeric(i);
		return num;
	}
	
	public static String getRandomAlp(int i)
	{
		String alp = RandomStringUtils.randomAlphabetic(i);
		return alp;
	}
	
	public static void ScrollBottom()
	{
		JavascriptExecutor r= (JavascriptExecutor) driver;
		 String c="window.scrollTo(0,document.body.scrollHeight)";
		 r.executeScript(c);

	}
}
