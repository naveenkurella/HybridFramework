package com.testninjalabs.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testninjalabs.qa.base.Base;

public class Search extends Base {
	
	WebDriver driver;
public Search() {
		
		super();
	}
	
	@BeforeMethod
	public void setup() {
		
		driver=initializeBrowserAndOpenApplicatin(prop.getProperty("browser"));
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@Test(priority = 1)
	public void searchWithValidProduct() {
		
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("hp");
		driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
		
	}
	
	@Test(priority = 2)
	public void searchWithInValidProduct() {
		
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("Honda");
		driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		String Actual=driver.findElement(By.xpath("//div[@id='content']/p[2]")).getText();
		Assert.assertEquals(Actual, "There is no product that matches the search criteria.","No Products in search resuls ddisplayed");
		
		
	}
	
	@Test(priority = 3)
	public void VerifysearchWithNoProduct() {
		
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("");
		driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		String Actual=driver.findElement(By.xpath("//div[@id='content']/p[2]")).getText();
		Assert.assertEquals(Actual, "There is no product that matches the search criteria.","No Products in search resuls ddisplayed");
		
		
	}


}
