package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties  Pro;
	
	public ReadConfig()
	{
		try {//get file using file input stream
			FileInputStream fis = new FileInputStream("./Configurations/config.properties");
			Pro = new Properties();
			Pro.load(fis);//read and load
		}
		catch(Exception e)
		{
			System.out.println("Exception is "+ e.getMessage());
		}
		
	}
	
	public String getUrl()
	{
		return Pro.getProperty("URL");
	}
	
	public String getUserName()
	{
		return Pro.getProperty("UserName");
	}
	
	public String getPassword()
	{
		return Pro.getProperty("Password");
	}
	
	public String GetHomePageTitle()
	{
		return Pro.getProperty("HomePageTitle");
	}
	
	public String getChromePath()
	{
		return Pro.getProperty("Chromepath");
	}
	public String getFirefoxPath()
	{
		return Pro.getProperty("Firefoxpath");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
