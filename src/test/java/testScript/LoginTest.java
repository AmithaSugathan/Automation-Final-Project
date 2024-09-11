package testScript;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {

	@Test(dataProvider = "LoginProvider", retryAnalyzer = retry.Retry.class, description = "Verify that the user is able to login to the Supermarket app with Valid Username and Password", groups = {
			"Regression" })

	public void verifyTheUserIsAbleToLoginUsingValidCredentials(String usernameValue, String passwordValue)
			throws IOException {

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameInUsernameField(usernameValue).enterPasswordInPasswordField(passwordValue)
				.clickSigninButton();
		boolean isHomePageLoaded = loginpage.isDasboardLoadedSuccessfully();
		assertTrue(isHomePageLoaded, Constants.HOMENOTLOADEDMESSAGE_VALIDDATA);

	}

	@Test(retryAnalyzer = retry.Retry.class, description = "Verify that the user is able to login to the Supermarket app with Invalid Username", groups = {
			"Smoke" })

	public void verifyTheUserIsAbleToLoginUsingInvalidUsername() throws IOException {
		String usernameValue = ExcelUtility.getStringData(2, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(2, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameInUsernameField(usernameValue);
		loginpage.enterPasswordInPasswordField(passwordValue);
		loginpage.clickSigninButton();
		boolean isInvalidAlertDisplayed = loginpage.isInvalidLoginAlertDisplayed();
		assertTrue(isInvalidAlertDisplayed, Constants.HOMENOTLOADEDMESSAGE_INVALIDUNAME);

	}

	@Test(retryAnalyzer = retry.Retry.class, description = "Verify that the user is able to login to the Supermarket app with Invalid Password")
	public void verifyTheUserIsAbleToLoginUsingInvalidPassword() throws IOException {
		String usernameValue = ExcelUtility.getStringData(3, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(3, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameInUsernameField(usernameValue);
		loginpage.enterPasswordInPasswordField(passwordValue);
		loginpage.clickSigninButton();
		boolean isInvalidAlertDisplayed = loginpage.isInvalidLoginAlertDisplayed();
		assertTrue(isInvalidAlertDisplayed, Constants.HOMENOTLOADEDMESSAGE_INVALIDPASSWORD);
	}

	@Test(retryAnalyzer = retry.Retry.class, description = "Verify that the user is able to login to the Supermarket app with Invalid Username and Invalid Password")

	public void verifyTheUserIsAbleToLoginUsingInvalidUsernameAndPassword() throws IOException {
		String usernameValue = ExcelUtility.getStringData(4, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(4, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameInUsernameField(usernameValue);
		loginpage.enterPasswordInPasswordField(passwordValue);
		loginpage.clickSigninButton();
		boolean isInvalidAlertDisplayed = loginpage.isDasboardLoadedSuccessfully();
		assertTrue(isInvalidAlertDisplayed, Constants.HOMENOTLOADEDMESSAGE_INVALIDDATA);
	}

	@DataProvider(name = "LoginProvider")
	public Object[][] getDataFromTestData() throws IOException {// returns an object array
		return new Object[][] {
				{ ExcelUtility.getStringData(1, 0, "LoginPage"), ExcelUtility.getStringData(1, 1, "LoginPage") }, };// value
																													// is
																													// passed
																													// as
																													// object
																													// array

	}
}
