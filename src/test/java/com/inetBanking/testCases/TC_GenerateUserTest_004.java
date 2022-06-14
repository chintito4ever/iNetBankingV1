package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.inetBanking.pageObjects.GenerateUserInfoPage;
import com.inetBanking.utilities.XLUtility;

public class TC_GenerateUserTest_004 extends BaseClass {

	@Test(invocationCount = 3)
	public void generateUser() throws IOException {

		GenerateUserInfoPage gui = new GenerateUserInfoPage(driver);

		gui.visitHere();

		String email = randomString() + "@gmail.com";
		gui.setEmail(email);
		logger.info("Email is provided: " + email);

		gui.submitBtn();

		String path = "./Configuration/UserData.xlsx";

		XLUtility xlutil = new XLUtility(path);

		xlutil.setCellData("Sheet1", 0, 0, "Username");
		xlutil.setCellData("Sheet1", 0, 1, "Password");
		xlutil.setCellData("Sheet1", 0, 2, "Email");

		logger.info("Username: " + gui.username());
		logger.info("Password: " + gui.password());

		int lastRow = xlutil.sheet.getPhysicalNumberOfRows() - 1;
		for (int rownum = lastRow + 1; rownum <= 10; rownum++) {
			xlutil.setCellData("Sheet1", rownum, 0, gui.username());
			xlutil.setCellData("Sheet1", rownum, 1, gui.password());
			xlutil.setCellData("Sheet1", rownum, 2, email);
			break;
		}

	}

}
