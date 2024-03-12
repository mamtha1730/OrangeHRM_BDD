package Stepdefinitions;

import java.io.IOException;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Factory.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks 
{
  public WebDriver driver;
	
	Properties p;
	
	@Before
	public void  dosetup() throws IOException
	{
		p=BaseClass.getProperties();
		System.out.println("Inside setup");
		driver=BaseClass.initilizeBrowser();

	}
	
	
	@After
	public void teardown() 
	{
		System.out.println("Inside teardown");
		driver.quit();
		
	}
	@AfterStep
	public void addscreenshot(Scenario scenario)
	{
		//screenshots
		if(scenario.isFailed())
		{
			final byte[] tempBytes = ((TakesScreenshot) driver)
	                .getScreenshotAs(OutputType.BYTES);
			scenario.attach(tempBytes, "image/png", "screenshots");
	    }		
				
	}
	
	

}
