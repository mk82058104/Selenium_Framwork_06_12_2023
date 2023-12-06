package com.amazon.testrunner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.amazon.pom.LoginFindBy;
import com.amazon.utils.CreateDriver;
import com.amazon.utils.GetData;

public class LoginAmazonTest {
	public WebDriver driver;
	public LoginFindBy loginPage;
	
	@BeforeTest
	public void setUp() {
		driver=CreateDriver.getDriver();
	}
	
	@Test
	public void AM_01() {
		loginPage=PageFactory.initElements(driver,LoginFindBy.class);
		String userName=GetData.fromExcel("AmazonTestCase.xlsx","Amazon", 12,4);
		System.out.println("userName::" + userName);
		String passWord=GetData.fromExcel("AmazonTestCase.xlsx","Amazon", 14,4);
		loginPage.loginApp(userName, passWord);
		String actualTitle=GetData.fromExcel("AmazonTestCase.xlsx","Data", 0,0);
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(),actualTitle);
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	

}
