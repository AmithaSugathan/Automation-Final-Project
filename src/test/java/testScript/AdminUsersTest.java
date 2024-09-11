package testScript;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.AdminUsersPage;
import pages.LoginPage;
import pages.ManageCategoryPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;

public class AdminUsersTest extends Base {
	public AdminUsersPage admin;
	public LoginPage login;
	public ManageContactPage contact;

	@Test(description = "Verify that the user is able to create a new user into the Supermarket app")

	public void verifyUserCanCreateNewUserType() throws IOException {

		String usernameValue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(1, 1, "LoginPage");
		String newUserNameValue = ExcelUtility.getStringData(1, 0, "AdminUsers");
		String newUserPasswordValue = ExcelUtility.getStringData(1, 1, "AdminUsers");
		login = new LoginPage(driver);
		admin = login.enterUsernameInUsernameField(usernameValue).enterPasswordInPasswordField(passwordValue)
				.clickSigninButton();
		contact = admin.clickAdminUsersMoreInfo().clickNewUserButton().enterNewUsername(newUserNameValue)
				.enterNewUserPassword(newUserPasswordValue).selectNewUserTypeDropDown().clickNewUserSaveButton();
		boolean isNewUserSaved = admin.isNewUserCreated();
		assertTrue(isNewUserSaved, Constants.NEWUSERNOTSAVED);
	}

	@Test(description = "Verify that the user is able to edit existing user details in the Supermarket app")

	public void verifyUserCanEditExistingUserDetails() throws IOException {
		String usernameValue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(1, 1, "LoginPage");
		String editUserNameValue = ExcelUtility.getStringData(1, 2, "AdminUsers");
		String editPasswordValue = ExcelUtility.getStringData(1, 3, "AdminUsers");
		login = new LoginPage(driver);
		admin = login.enterUsernameInUsernameField(usernameValue).enterPasswordInPasswordField(passwordValue)
				.clickSigninButton();
		admin.clickAdminUsersMoreInfo().clickUserEditButton().userNameEdit(editUserNameValue)
				.userPasswordEdit(editPasswordValue).selectUserTypeEditDropDown().clickUserTypeUpdateButton();
		boolean isUserTypeUpdated = admin.isUserTypeUpdateAlertDisplayed();
		assertTrue(isUserTypeUpdated, Constants.USERNOTUPDATED);

	}

	@Test(description = "Verify that the user is able to update status of a user in the Supermarket app")

	public void verifyUserCanChangeStatus() throws IOException {
		String usernameValue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(1, 1, "LoginPage");
		login = new LoginPage(driver);
		admin = login.enterUsernameInUsernameField(usernameValue).enterPasswordInPasswordField(passwordValue)
				.clickSigninButton();
		AdminUsersPage adminuserspage = new AdminUsersPage(driver);
		adminuserspage.clickAdminUsersMoreInfo();
		String oldStatus = adminuserspage.userOldStatus();
		adminuserspage.clickUserTypeStatusUpdateButton();
		String newStatus = adminuserspage.userNewStatus();
		assertEquals(oldStatus, newStatus, Constants.USERSTATUSNOTUPDATED);

	}

}
