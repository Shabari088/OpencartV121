package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseTestCaseClass;

public class TC002_LoginTest extends BaseTestCaseClass {

	@Test(groups = { "Sanity", "Master" })
	public void verify_login() {
		logger.info("****** Starting TC002_LoginTest ******");
		try {
			HomePage homePage = new HomePage(driver);
			homePage.clickOnMyAccount();
			logger.info("****** Clicked on My Account Link ******");
			homePage.clickOnLogin();
			logger.info("****** Clicked on My Login Link ******");
			LoginPage loginPage = new LoginPage(driver);
			loginPage.setEmailAddress(prop.getProperty("email"));
			loginPage.setPassword(prop.getProperty("password"));
			loginPage.clickOnLoginBtn();

			logger.info("****** Validating My Account Text ******");
			MyAccountPage myAccountPage = new MyAccountPage(driver);
			boolean targetPage = myAccountPage.isMyAccountPageExists();
			Assert.assertTrue(targetPage);
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("****** Ending TC002_LoginTest ******");
	}

}
