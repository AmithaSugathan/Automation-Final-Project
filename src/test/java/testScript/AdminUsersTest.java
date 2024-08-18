package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUsersTest extends Base {
	
	@Test
	
	public void verifyUserCanCreateNewUserType() throws IOException
	{
		
			String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");
			String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");
			String newUserNameValue=ExcelUtility.getStringData(1, 0, "AdminUsers");
			String newUserPasswordValue=ExcelUtility.getStringData(1, 1, newUserNameValue);
			LoginPage loginpage=new LoginPage(driver);
			loginpage.enterUsernameInUsernameField(usernameValue);
			loginpage.enterPasswordInPasswordField(passwordValue);
			loginpage.clickSigninButton();
			
			AdminUsersPage adminuserspage=new AdminUsersPage(driver);
			adminuserspage.clickAdminUsersMoreInfo();
			adminuserspage.clickNewUserButton();
			adminuserspage.enterNewUsername(newUserNameValue);
			adminuserspage.enterNewUserPassword(newUserPasswordValue);
			adminuserspage.selectNewUserTypeDropDown();
			boolean isNewUserSaved=adminuserspage.isNewUserCreated();
			assertTrue(isNewUserSaved,"The New User is not SAVED");
	}

}
