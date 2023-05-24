package com.testninjalabs.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tutorialsninja.qa.utils.Utils;

public class Base {
	
	WebDriver driver;
	
	public Properties prop , dataProp ;

	
	public Base() {
		
		prop = new Properties();
		dataProp= new Properties();
		
		File propFile  = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties");
		File dataPropFile  = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\testdata\\testdata.properties");
		
		try {
			FileInputStream fis = new FileInputStream(propFile);
			FileInputStream dfis = new FileInputStream(dataPropFile);
			prop.load(fis);
			dataProp.load(dfis);
			prop.getProperty("browser");
			System.out.println(prop.getProperty("browser"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
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
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utils.IMPLICIT_WAIT));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utils.PAGE_WAIT));
			driver.get(prop.getProperty("url"));
			
		
		return driver;
	}

}
