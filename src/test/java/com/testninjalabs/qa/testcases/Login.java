package com.testninjalabs.qa.testcases;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testninjalabs.qa.base.Base;
import com.tutorialsninja.qa.utils.Utils;

public class Login extends Base {
	WebDriver driver;
	
	
	
	public Login() {
		
		super();
	}
	
	@BeforeMethod
	public void setup() {
		
		driver=initializeBrowserAndOpenApplicatin(prop.getProperty("browser"));
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
			driver.findElement(By.xpath("//a[text()=\"Login\"]")).click();
		
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void verifyLoginWithValidCreds() {
		
		
		driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys(prop.getProperty("validEmail"));
		driver.findElement(By.cssSelector("input#input-password")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.cssSelector("input[value='Login']")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
	
		
	}
	
	@Test(priority=2)
	public void verifyLoginWithInvalidCreds() {
		
		driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys(Utils.generateTimesstamp());
		driver.findElement(By.cssSelector("input#input-password")).sendKeys(dataProp.getProperty("invalidPassword"));
		driver.findElement(By.cssSelector("input[value='Login']")).click();
		String actual=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		Assert.assertTrue(actual.contains(dataProp.getProperty("emailPasswordNoMatch")));
		
		
	}
	
	@Test(priority = 3)
	public void verifyLoginWithInvalidEmailValidPW() {
		
		
		driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys(Utils.generateTimesstamp());
		driver.findElement(By.cssSelector("input#input-password")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.cssSelector("input[value='Login']")).click();
		String actual=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		Assert.assertTrue(actual.contains(dataProp.getProperty("emailPasswordNoMatch")));
		
		
	}
	
	@Test(priority = 4)
	public void verifyLoginWithValidEmailInvalidPW() {
		
		driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys(dataProp.getProperty("invalidEmail"));
		driver.findElement(By.cssSelector("input#input-password")).sendKeys(dataProp.getProperty("invalidPassword"));
		driver.findElement(By.cssSelector("input[value='Login']")).click();
		String actual=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		Assert.assertTrue(actual.contains(dataProp.getProperty("emailPasswordNoMatch")));
		
		
	}
	
	@Test(priority = 5)
	public void verifyLoginWithoutCreds() {
	
		//driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("nk@gmail.com");
		//driver.findElement(By.cssSelector("input#input-password")).sendKeys("123456");
		driver.findElement(By.cssSelector("input[value='Login']")).click();
		String actual=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		Assert.assertTrue(actual.contains(dataProp.getProperty("emailPasswordNoMatch")));
		
		
	}
	
	
	
}
