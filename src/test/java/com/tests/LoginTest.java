package com.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class LoginTest {
	//
	//What is log? : capturing info/activities at the time of program execution. 
		// types of logs:
			//1. info
			//2. warn
			//3. debug
			//4. fatal
			
		//how to generate the logs? : use Apache log4j API (log4j jar)
		//How it works? : it reads log 4j configuration from log4j.properties file
		//where to create: create inside resources folder
		
		WebDriver driver;
		Logger log = Logger.getLogger(LoginTest.class);
		
		
		@BeforeMethod
		public void setup(){

			log.info("****************************** Starting test cases execution  *****************************************");

			
			System.setProperty("webdriver.chrome.driver", "/Users/amber/Documents/Drivers/chromedriver 2");	
			driver = new ChromeDriver(); 
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.get("https://classic.crmpro.com/login.cfm");
			
		}
		
		
		@Test(priority=1)
		public void freeCrmTitleTest(){
			
			log.info("****************************** starting test case *****************************************");
			log.info("****************************** freeCrmTitleTest *****************************************");
			
			String title = driver.getTitle();
			System.out.println(title);
			Assert.assertEquals(title,"CRMPRO Log In Screen");
			
			
			log.info("****************************** ending test case *****************************************");
			log.info("****************************** freeCrmTitleTest *****************************************");
			
		}
		
		@Test(priority=2)
		public void freemCRMLogoTest(){
			
			log.info("****************************** starting test case *****************************************");
			log.info("****************************** freemCRMLogoTest *****************************************");

			
			
			boolean b = driver.findElement(By.xpath("//a[@class='navbar-brand']//img[@class='img-responsive']")).isDisplayed();
			Assert.assertTrue(b);
			
			
			log.info("****************************** ending test case *****************************************");
			log.info("****************************** freemCRMLogoTest *****************************************");

		}
		
		

		@AfterMethod
		public void tearDown(){
			driver.quit();

			log.info("****************************** Browser is closed *****************************************");

			
		}
	

}
