package com.orangeHRTestcases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.orangeHRUtilities.ReadConfig;

public class Baseclass {

	ReadConfig readconfig = new ReadConfig();
	public String baseurl = readconfig.getbaseurl();
	public String username = readconfig.getusername();
	public String password = readconfig.getpassword();
	public static WebDriver driver;

	public static Logger logger;
	
	@Parameters ("browser")
	@BeforeClass
	public void setup(String br) {

		logger = Logger.getLogger(Baseclass.class);
		PropertyConfigurator.configure("log4j.properties");

		
		if (br.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", readconfig.getchromepath());
			driver = new ChromeDriver();
			
		} 
		else if (br.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.getfirefoxpath());
			driver = new FirefoxDriver();
			
		}
		

		driver.manage().window().maximize();
		logger.info("Browser maximized");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to(readconfig.getbaseurl());
		logger.info("website is launched");

	}

	@AfterClass
	public void teardown() {

		driver.quit();
		logger.info("Browser quit/closed");
	}

}
