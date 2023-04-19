package com.testninjalabs.qa.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testninjalabs.qa.base.Base;
import com.tutorialsninja.qa.utils.Utils;



public class Register extends Base{
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		driver=initializeBrowserAndOpenApplicatin("chrome");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click(); 
		
		
	}
	
	String Email;
	@Test(priority=1)
	public void verifyRegisteringAnAccountWithManadatoryFields() {
		
	driver.findElement(By.name("firstname")).sendKeys("Nk");
	driver.findElement(By.name("lastname")).sendKeys("Kurella");
	driver.findElement(By.name("email")).sendKeys(Utils.generateTimesstamp());
	driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("1234567890");
	driver.findElement(By.cssSelector("#input-password")).sendKeys("12345");
	driver.findElement(By.cssSelector("#input-confirm")).sendKeys("12345");
	driver.findElement(By.xpath("//input[@type='checkbox']")).click();
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	String actual= driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
	Assert.assertEquals(actual, "Your Account Has Been Created!");
	driver.quit();
	}
	
	@Test(priority=2)
	public void verifyRegisteringWithAllFields() {
		
		
	driver.findElement(By.name("firstname")).sendKeys("Nk");
	driver.findElement(By.name("lastname")).sendKeys("Kurella");
	Email=Utils.generateTimesstamp();
	driver.findElement(By.name("email")).sendKeys(Email);
	driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("1234567890");
	driver.findElement(By.cssSelector("#input-password")).sendKeys("12345");
	driver.findElement(By.cssSelector("#input-confirm")).sendKeys("12345");
	driver.findElement(By.xpath("//input[@name='newsletter' and @value='1']")).click();
	driver.findElement(By.xpath("//input[@type='checkbox']")).click();
	
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	String actual= driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
	Assert.assertEquals(actual, "Your Account Has Been Created!");
	driver.quit();
	}
	
	
	@Test(priority=3)
	public void verifyRegisteringAccountWithExistingEmailAddress() {
		
	driver.findElement(By.name("firstname")).sendKeys("Nk");
	driver.findElement(By.name("lastname")).sendKeys("Kurella");
	System.out.println(Email);
	driver.findElement(By.name("email")).sendKeys(Email);
	driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("1234567890");
	driver.findElement(By.cssSelector("#input-password")).sendKeys("12345");
	driver.findElement(By.cssSelector("#input-confirm")).sendKeys("12345");
	driver.findElement(By.xpath("//input[@name='newsletter' and @value='1']")).click();
	driver.findElement(By.xpath("//input[@type='checkbox']")).click();
	
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	//String actual= driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
	//Assert.assertEquals(actual, "Your Account Has Been Created!");
	String warning=driver.findElement(By.xpath("//div[contains(text(),'Warning: E-Mail Address is already registered!')]")).getText();
	Assert.assertTrue(warning.contains("Warning: E-Mail Address is already registered!"),"Email is already exist");
	driver.quit();
	}
	
	
	@Test(priority = 4)
	public void verifyRegisteringWithoutAnyFields() {
		
		 
	
	
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	
	String warning=driver.findElement(By.xpath("//input[@id='input-firstname']//following-sibling::div")).getText();
	Assert.assertTrue(warning.contains("First Name must be between 1 and 32 characters!"),"Account will not be created without mandatory fields");
	driver.quit();
		
	}
}
