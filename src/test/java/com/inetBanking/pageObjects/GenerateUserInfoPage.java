package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GenerateUserInfoPage {

	WebDriver driver;

	public GenerateUserInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "/html/body/div[4]/ol/li[1]/a")
	WebElement visitHere;

	@FindBy(xpath = "//*[@name='emailid']")
	WebElement email;

	@FindBy(xpath = "//*[@name='btnLogin']")
	WebElement submitBtn;

	@FindBy(xpath = "/html/body/table/tbody/tr[4]/td[2]")
	WebElement username;
	// String username = storeUsernameXpath.getText();

	@FindBy(xpath = "/html/body/table/tbody/tr[5]/td[2]")
	WebElement password;
	// String password = storePasswordXpath.getText();

	public void visitHere() {
		visitHere.click();
	}

	public void setEmail(String generatedemail) {
		email.sendKeys(generatedemail);
	}

	public void submitBtn() {
		submitBtn.click();
	}

	public String username() {

		String uname = username.getText();
		return (uname);
	}

	public String password() {

		String pass = password.getText();
		return (pass);

	}

}
