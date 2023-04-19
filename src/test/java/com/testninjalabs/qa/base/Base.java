package com.testninjalabs.qa.base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	WebDriver driver;
	
	public WebDriver initializeBrowserAndOpenApplicatin(String browserName) {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		if(browserName.equals("chrome")) {
			driver = new ChromeDriver(options);
		} else if(browserName.equals("firefox")) {
			driver= new FirefoxDriver();
		} else if(browserName.equals("edge")) {
			driver=new EdgeDriver();
		}  
		
		/// driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			driver.get("http://tutorialsninja.com/demo/");
			
		
		return driver;
	}

}
