package com.testninjalabs.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testninjalabs.qa.base.Base;

public class Search extends Base {
	
	WebDriver driver;
	
	
	@BeforeMethod
	public void setup() {
		
		driver=initializeBrowserAndOpenApplicatin("chrome");
	}
	
	
	@Test(priority = 1)
	public void searchWithValidProduct() {
		
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("hp");
		driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
		
	}
	
	@Test(priority = 2)
	public void searchWithInValidProduct() {
		
		
		
	}

}
