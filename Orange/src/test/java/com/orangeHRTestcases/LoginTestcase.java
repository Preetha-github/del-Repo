package com.orangeHRTestcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangeHRPageObjects.LoginPageObjects;

public class LoginTestcase extends Baseclass{
	

	
	@Test
	public void Login() {
		
		
		PageFactory.initElements(driver, LoginPageObjects.class);
		LoginPageObjects.username.sendKeys(username);
		logger.info("Entered username");
		
		LoginPageObjects.password.sendKeys(password);
		logger.info("Entered password");
		
		LoginPageObjects.Loginbutton.click();
		logger.info("Clicked loginbutton");
		
		
		System.out.println(driver.getTitle());
		logger.info("Title retrieved");
		
		if (driver.getTitle().equalsIgnoreCase("OrangeHRM"))
		{
			AssertJUnit.assertTrue(true);
		}
		else
		{
			AssertJUnit.assertTrue(false);
		}
		
		
	}

}
