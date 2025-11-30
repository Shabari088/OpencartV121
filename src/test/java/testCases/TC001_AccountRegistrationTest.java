package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseTestCaseClass;

public class TC001_AccountRegistrationTest extends BaseTestCaseClass {

	@Test(groups = {"Regression","Master"})
	public void verify_account_registration() {

		logger.info("****** Starting TC001_AccountRegistrationTest ******");
		try {
			HomePage homePage = new HomePage(driver);
			homePage.clickOnMyAccount();
			logger.info("****** Clicked on My Account Link ******");
			homePage.clickOnRegister();
			logger.info("****** Clicked on Register Link ******");
			AccountRegistrationPage accountRegPage = new AccountRegistrationPage(driver);

			logger.info("****** Enter the Regestration Details ******");
			accountRegPage.setFirstName(randomAlphabets());
			accountRegPage.setLastName(randomAlphabets());
			accountRegPage.setEmail(randomAlphabets() + "@test.com");
			accountRegPage.setTelephone(randomNumber());
			String password = randomAlphaNumeric();
			accountRegPage.setPassword(password);
			accountRegPage.setPasswordConfirm(password);
			accountRegPage.clickOnPrivacyPolicyCheckBox();
			accountRegPage.clickOnContinue();

			logger.info("****** Validating Account has be created ******");
			Assert.assertEquals(accountRegPage.getConfirmMessage(), "Your Account Has Been Created!");
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("****** Ending TC001_AccountRegistrationTest ******");
	}

}
