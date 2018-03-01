package com.devOps_Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import driver.DriverFactory;
import pageFactory.DevOps_Validation;
import pageFactory.Login;
import utility_functions.Utility_Functions;

public class DevOps_Selenium {
	
WebDriver driver = DriverFactory.getdriver() ;	


@Test
public void Test_DevOps() throws Exception {
	DevOps_Validation validation = new DevOps_Validation(driver);
	Login login = new Login(driver);
	login.userLogin();
	validation.Setup_Request();
}
}