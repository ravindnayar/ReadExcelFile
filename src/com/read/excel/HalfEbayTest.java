package com.read.excel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.utility.TestUtility;

public class HalfEbayTest {
	
	WebDriver driver ;
	
	@BeforeTest
	public void setup(){
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Driver\\chrome driver 83.0.4103.39\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://reg.ebay.in/reg/PartialReg");
	}
	
	@DataProvider
	//fetch data from excel file
	public Iterator<Object[]> getTestData(){
		ArrayList<Object[]> testData = TestUtility.getDataFromExcel();
		return testData.iterator();
	}

	@Test(dataProvider="getTestData")
	public void halfebay(String FirstName, String LastName, String Email, String Password){
		//enter data
		driver.findElement(By.xpath("//*[@id='firstname']")).clear();
		driver.findElement(By.xpath("//*[@id='firstname']")).sendKeys(FirstName);
		
		driver.findElement(By.xpath("//*[@id='lastname']")).clear();
		driver.findElement(By.xpath("//*[@id='lastname']")).sendKeys(LastName);
		
		driver.findElement(By.xpath("//*[@id='email']")).clear();
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys(Email);
		
		driver.findElement(By.xpath("//*[@id='PASSWORD']")).clear();
		driver.findElement(By.xpath("//*[@id='PASSWORD']")).sendKeys(Password);
	}
	
	
	
	@AfterTest
	public void tearDown(){
		driver.close();
	}
	}
