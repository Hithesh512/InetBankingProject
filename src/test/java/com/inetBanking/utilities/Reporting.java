package com.inetBanking.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.inetBanking.testCases.BaseTest;


public class Reporting extends TestListenerAdapter {
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extend;
	public ExtentTest  logger;

	@Override
	public void onStart(ITestContext testContext) {
		Date date  = new Date();
		String ReportNameFormat = date.toString().replace(" ", "-").replace(":", "-")+".html";
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/Reports/"+ReportNameFormat);
		htmlReporter.loadConfig(System.getProperty("user.dir")+"/extent-config.xml");
		htmlReporter.config().setDocumentTitle("InetBanking Test Project");
		htmlReporter.config().setReportName("Functional test Automation report");
		htmlReporter.config().setTheme(Theme.DARK);
		
		extend = new ExtentReports();
		extend.attachReporter(htmlReporter);
		extend.setSystemInfo("Host Name", "Local Host");
		extend.setSystemInfo("Environment", "QA");
		extend.setSystemInfo("User", "Hithesh Gowda M");
	}
	
	@Override
	public void onTestSuccess(ITestResult tr) 
	{
		logger = extend.createTest(tr.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
						
	}
	@Override
	public void onTestFailure(ITestResult tr)
	{
	logger = extend.createTest(tr.getName());//will create new entry in the report
	logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
	try
	{
	File Src = ((TakesScreenshot)BaseTest.driver).getScreenshotAs(OutputType.FILE);
	File Des = new File(System.getProperty("user.dir")+"/Screenshots/"+tr.getName()+".png");
		FileUtils.copyFile(Src,Des);
	}
	catch (IOException e) {
		e.printStackTrace();
	}
	}
	@Override
	public void onTestSkipped(ITestResult tr)
	{
		logger = extend.createTest(tr.getName());//create new entry
		logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}
	 
	@Override
	public void onFinish(ITestContext testContext) {
		extend.flush();
	}



	
	
	
}
