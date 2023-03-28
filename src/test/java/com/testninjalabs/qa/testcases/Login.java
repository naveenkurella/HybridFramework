package com.testninjalabs.qa.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login {
	

	@Test(priority = 1)
	public void verifyLoginWithValidCreds() {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("http://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[text()=\"Login\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("nk@gmail.com");
		driver.findElement(By.cssSelector("input#input-password")).sendKeys("12345");
		driver.findElement(By.cssSelector("input[value='Login']")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		driver.quit();
		
	}
	
	@Test(priority=2)
	public void verifyLoginWithInvalidCreds() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("http://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[text()=\"Login\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("nk@gmail.com2");
		driver.findElement(By.cssSelector("input#input-password")).sendKeys("12345");
		driver.findElement(By.cssSelector("input[value='Login']")).click();
		String actual=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		Assert.assertTrue(actual.contains("Warning: No match for E-Mail Address and/or Password."));
		driver.quit();	
		
	}
}
