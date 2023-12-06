package com.amazon.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginFindBy {
	WebDriver driver;
	
	@FindBy(id="nav-link-accountList-nav-line-1")
	WebElement helloSign;
	
	@FindBy(xpath = "//div[@id='nav-flyout-ya-signin']//span[@class='nav-action-inner'][normalize-space()='Sign in']")
	WebElement signButton;
	
	@FindBy(id = "ap_email")
	WebElement userName;
	
	@FindBy(id = "continue")
	WebElement conitueButton;
	
	@FindBy(id = "ap_password")
	WebElement userPassword;
	
	@FindBy(id = "signInSubmit")
	WebElement signInButton;
	
	
	public LoginFindBy(WebDriver driver) {
		this.driver=driver;
	}
	
	public void loginApp(String username,String password) {
		Actions act=new Actions(driver);
		act.moveToElement(helloSign).perform();
		signButton.click();
		userName.sendKeys(username);
		conitueButton.click();
		userPassword.sendKeys(password);
		signInButton.click();
		
	}

}
