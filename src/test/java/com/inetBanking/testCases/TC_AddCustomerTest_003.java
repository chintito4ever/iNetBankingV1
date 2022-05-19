package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {

	@Test
	public void AddNewCustomer() throws InterruptedException, IOException {

		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		logger.info("Username is provided");
		lp.setPassword(password);
		logger.info("Password is provided");
		lp.getSubmitButton();

		Thread.sleep(2000);

		AddCustomerPage addcust = new AddCustomerPage(driver);

		logger.info("Providing customer details....");

		addcust.clickAddNewCustomer();
		addcust.custName("Vodai");
		addcust.custgender("female");
		addcust.custdob("01", "01", "2001");
		Thread.sleep(2000);
		addcust.custaddress("USA");
		addcust.custcity("Bronx");
		addcust.custstate("NY");
		addcust.custpinno("112201");
		addcust.custtelephoneno("9111191234");

		String email = randomString() + "@gmail.com";
		addcust.custemailid(email);
		logger.info("Email: " + email);

		String password = randomAlphaNumeric();
		addcust.custpassword(password);
		logger.info("Password: " + password);

		addcust.custsubmit();

		Thread.sleep(0);

		logger.info("Validation started...");
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");

		if (res == true) {
			Assert.assertTrue(true);
			logger.info("Test case passed....");
		} else {
			logger.info("Test case failed....");
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}
	}

}
