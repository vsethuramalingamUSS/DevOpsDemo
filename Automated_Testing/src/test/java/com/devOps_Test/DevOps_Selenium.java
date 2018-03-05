package com.devOps_Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import driver.DriverFactory;
import pageFactory.DevOps_Validation;
import pageFactory.Login;
import utility_functions.Utility_Functions;

public class DevOps_Selenium {

@Test
public void Test_DevOps_PatientAddress() throws Exception {
	boolean b = false;
	WebDriver driver = DriverFactory.getdriver();
	try {
	DevOps_Validation validation = new DevOps_Validation(driver);
	Login login = new Login(driver);
	login.userLogin();
	driver.findElement(By.xpath("//a[@title='Patient Enrollment Form Tab']")).click();
	Thread.sleep(5000);
	
	Select s=new Select(driver.findElement(By.id("pageId:formId:pb:pbs:gen")));
	s.selectByVisibleText("Male");
	
	driver.findElement(By.id("pageId:formId:pb:pbs:fn")).sendKeys("Test");
	driver.findElement(By.id("pageId:formId:pb:pbs:ln")).sendKeys("Automation");
	driver.findElement(By.id("pageId:formId:pb:pbs:dob")).sendKeys("3/5/1990");
	driver.findElement(By.id("pageId:formId:pb:pbs:email")).sendKeys("test@automation.com");
	driver.findElement(By.id("pageId:formId:pb:pbs:uninsured")).click();
	
	s = new Select(driver.findElement(By.id("pageId:formId:pb:pbs:condition_unselected")));
	s.selectByVisibleText("Asthma");
	
	driver.findElement(By.id("pageId:formId:pb:pbs:condition_right_arrow")).click();
	
	driver.findElement(By.id("pageId:formId:pb:pbsAddress:s1")).sendKeys("Street1");
	driver.findElement(By.id("pageId:formId:pb:pbsAddress:s2")).sendKeys("Street3");
	driver.findElement(By.id("pageId:formId:pb:pbsAddress:city")).sendKeys("City");
	s=new Select(driver.findElement(By.id("pageId:formId:pb:pbsAddress:cntry")));
	s.selectByVisibleText("United States");
	
	s=new Select(driver.findElement(By.id("pageId:formId:pb:pbsAddress:state")));
	s.selectByVisibleText("RI");
	
	driver.findElement(By.id("pageId:formId:pb:j_id1:bottom:enrol")).click();
	Thread.sleep(5000);
	b = driver.findElement(By.xpath("//a[contains(text(),'PA-')]")).isDisplayed();
	System.out.println("Patient Address is displayed");
	driver.quit();
	}
	catch(Exception e){
		System.out.println("Patient Address is not displayed");
		Assert.assertEquals(b,"True");
		driver.quit();
		}
}

@Test
public void Test_DevOps_OpenActivities() throws Exception {
	boolean b = false;
	WebDriver driver = DriverFactory.getdriver();
	try {
	DevOps_Validation validation = new DevOps_Validation(driver);
	Login login = new Login(driver);
	login.userLogin();
	driver.findElement(By.xpath("//a[@title='Patient Enrollment Form Tab']")).click();
	Thread.sleep(5000);
	
	Select s=new Select(driver.findElement(By.id("pageId:formId:pb:pbs:gen")));
	s.selectByVisibleText("Male");
	
	driver.findElement(By.id("pageId:formId:pb:pbs:fn")).sendKeys("Test");
	driver.findElement(By.id("pageId:formId:pb:pbs:ln")).sendKeys("Automation");
	driver.findElement(By.id("pageId:formId:pb:pbs:dob")).sendKeys("3/5/1990");
	driver.findElement(By.id("pageId:formId:pb:pbs:email")).sendKeys("test@automation.com");
	driver.findElement(By.id("pageId:formId:pb:pbs:uninsured")).click();
	
	s = new Select(driver.findElement(By.id("pageId:formId:pb:pbs:condition_unselected")));
	s.selectByVisibleText("Asthma");
	
	driver.findElement(By.id("pageId:formId:pb:pbs:condition_right_arrow")).click();
	
	driver.findElement(By.id("pageId:formId:pb:pbsAddress:s1")).sendKeys("Street1");
	driver.findElement(By.id("pageId:formId:pb:pbsAddress:s2")).sendKeys("Street3");
	driver.findElement(By.id("pageId:formId:pb:pbsAddress:city")).sendKeys("City");
	s=new Select(driver.findElement(By.id("pageId:formId:pb:pbsAddress:cntry")));
	s.selectByVisibleText("United States");
	
	s=new Select(driver.findElement(By.id("pageId:formId:pb:pbsAddress:state")));
	s.selectByVisibleText("RI");
	
	driver.findElement(By.id("pageId:formId:pb:j_id1:bottom:enrol")).click();
	Thread.sleep(5000);
	b = driver.findElement(By.xpath("//a[text()='Follow-up with patient for services opt-in']")).isDisplayed();
	System.out.println("Open Activities is displayed");
	driver.quit();
	}
	catch(Exception e){
		System.out.println("Open Activities is not displayed");
		driver.quit();
		Assert.assertEquals(b,"True");
		}
	}
}