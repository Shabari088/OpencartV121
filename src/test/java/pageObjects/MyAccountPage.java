package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement lbl_MyAccount;

	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement lnk_Logout;

	public boolean isMyAccountPageExists() {
		try {
			return lbl_MyAccount.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void clickOnLogout() {
		lnk_Logout.click();
	}

}
