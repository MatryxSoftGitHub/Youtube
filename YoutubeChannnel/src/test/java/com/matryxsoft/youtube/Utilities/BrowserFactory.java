package com.matryxsoft.youtube.Utilities;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;


public class BrowserFactory {
		//***************************************APP STATE ONSTART***************************************
	public static WebDriver OnStart(WebDriver driver, String BrowserName, String ApplicationURL)
	{

		if (BrowserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} 
		else if (BrowserName.equalsIgnoreCase("Firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			
		} 
		else if (BrowserName.equalsIgnoreCase("IE")) 
		{
			System.setProperty("webdriver.ie.driver", "./Drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else if (BrowserName.equalsIgnoreCase("Microsoftedge")) 
		{
			System.setProperty("webdriver.edge.driver", "C:\\Windows\\System32\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		}
		else if (BrowserName.equalsIgnoreCase("Opera")) 
		{
			System.setProperty("webdriver.opera.driver", "./Drivers/operadriver.exe");
			driver = new OperaDriver();
		}
		else 
		{
			System.out.println("We do not support this browser");
		}

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(ApplicationURL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		return driver;
   
	
  }
	//***************************************APP STATE ONFINISH***************************************
	public static void OnFinish(WebDriver driver)
	{
		driver.quit();
	}

}
