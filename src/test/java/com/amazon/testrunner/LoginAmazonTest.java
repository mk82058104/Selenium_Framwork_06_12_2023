package com.amazon.testrunner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.amazon.pom.LoginFindBy;
import com.amazon.utils.CreateDriver;
import com.amazon.utils.GetData;

public class LoginAmazonTest {
	public WebDriver driver;
	public LoginFindBy loginPage;

	@BeforeMethod
	public void setUp() {
		driver=CreateDriver.getDriver();
	}

	@Test()
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

	@Test
	public void AM_02() {
		loginPage=PageFactory.initElements(driver,LoginFindBy.class);
		String userName=GetData.fromExcel("AmazonTestCase.xlsx","Amazon", 19,4);
		System.out.println("userName::" +userName);
		String actualInvalidUserNameErroMsg	=loginPage.getInvalidUserNameErrorMessage(userName);
		String expectedInvalidUserNameErroMsg=GetData.fromExcel("AmazonTestCase.xlsx","Data", 13,0);
		Assert.assertEquals(actualInvalidUserNameErroMsg,expectedInvalidUserNameErroMsg);
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}


}
