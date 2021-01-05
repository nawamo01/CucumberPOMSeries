package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;
	
	//1. By Locators
	private By emailid = By.id("email");
	private By password = By.id("passwd");
	private By signInButton = By.id("SubmitLogin");
	private By forgotPwdLink = By.linkText("Forgot your password?");
	
	//2.Constructors
	public LoginPage(WebDriver driver) {
		this.driver = driver;	
	}
	
	//3. Page actions: features of the page in the form of methods
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean isForgotpwdLinkExist() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}
	
	public void enterUserName(String username) {
		driver.findElement(emailid).sendKeys(username);		
	}
	
	
	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickOnLoginButton() {
		driver.findElement(signInButton).click();
	}
}