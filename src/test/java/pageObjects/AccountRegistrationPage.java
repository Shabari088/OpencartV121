package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txt_FirstName;
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txt_LastName;
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txt_Email;
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txt_Telephone;
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txt_Password;
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txt_PasswordConfirm;
	@FindBy(xpath = "//input[@name='agree']")
	WebElement chk_PrivacyPolicy;
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btn_Continue;
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement lbl_msgConfirmation;

	public void setFirstName(String fName) {
		txt_FirstName.sendKeys(fName);
	}

	public void setLastName(String lName) {
		txt_LastName.sendKeys(lName);
	}

	public void setEmail(String email) {
		txt_Email.sendKeys(email);
	}

	public void setTelephone(String telephone) {
		txt_Telephone.sendKeys(telephone);
	}

	public void setPassword(String password) {
		txt_Password.sendKeys(password);
	}

	public void setPasswordConfirm(String passwordConfirm) {
		txt_PasswordConfirm.sendKeys(passwordConfirm);
	}

	public void clickOnPrivacyPolicyCheckBox() {
		chk_PrivacyPolicy.click();
	}

	public void clickOnContinue() {
		btn_Continue.click();
	}

	public String getConfirmMessage() {
		return lbl_msgConfirmation.getText();
	}

}
