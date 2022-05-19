package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@name='uid']")
	WebElement email;
	@FindBy(xpath = "//*[@name='password']")
	WebElement password;
	@FindBy(xpath = "//*[@name='btnLogin']")
	WebElement clickSignIn;
	@FindBy(xpath = "/html/body/div[3]/div/ul/li[15]/a")
	WebElement clickLogOut;

	public void setUserName(String uname) {
		email.sendKeys(uname);
	}

	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}

	public void getSubmitButton() {
		clickSignIn.click();
	}

	public void getLogOut() {
		clickLogOut.click();
	}

}
