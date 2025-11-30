package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseTestCaseClass;
import utilities.DataProviders;

public class TC003_LoginDataDrivenTest extends BaseTestCaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void verify_login(String email, String password, String result) {
		logger.info("****** Starting TC002_LoginTest ******");
		try {
			HomePage homePage = new HomePage(driver);
			homePage.clickOnMyAccount();
			logger.info("****** Clicked on My Account Link ******");
			homePage.clickOnLogin();
			logger.info("****** Clicked on My Login Link ******");
			LoginPage loginPage = new LoginPage(driver);
			loginPage.setEmailAddress(email);
			loginPage.setPassword(password);
			loginPage.clickOnLoginBtn();

			logger.info("****** Validating My Account Page Exists ******");
			MyAccountPage myAccountPage = new MyAccountPage(driver);
			boolean targetPage = myAccountPage.isMyAccountPageExists();

			if (result.equals("Valid")) {
				if (targetPage == true) {
					myAccountPage.clickOnLogout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}

			if (result.equals("Invalid")) {
				if (targetPage == true) {
					myAccountPage.clickOnLogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}

		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("****** Ending TC002_LoginTest ******");
	}

}
