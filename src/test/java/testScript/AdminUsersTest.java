package testScript;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUsersTest extends Base {
	
	@Test(description="Verify that the user is able to login to the Supermarket app with Valid Username and Password")
	
	public void verifyUserCanCreateNewUserType() throws IOException
	{
		
			String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");
			String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");
			String newUserNameValue=ExcelUtility.getStringData(1, 0, "AdminUsers");
			String newUserPasswordValue=ExcelUtility.getStringData(1, 1, "AdminUsers");
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
			adminuserspage.clickNewUserSaveButton();
			boolean isNewUserSaved=adminuserspage.isNewUserCreated();
			assertTrue(isNewUserSaved,"The New User is not SAVED");
	}
	
	@Test (description="Verify that the user is able to login to the Supermarket app with Valid Username and Password")
	
	
	public void verifyUserCanEditExistingUserDetails() throws IOException
	{
		String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");
		String editUserNameValue=ExcelUtility.getStringData(1, 2, "AdminUsers");
		String editPasswordValue=ExcelUtility.getStringData(1, 3, "AdminUsers");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameInUsernameField(usernameValue);
		loginpage.enterPasswordInPasswordField(passwordValue);
		loginpage.clickSigninButton();
		
		AdminUsersPage adminuserspage=new AdminUsersPage(driver);
		adminuserspage.clickAdminUsersMoreInfo();
		adminuserspage.clickUserEditButton();		
		adminuserspage.userNameEdit(editUserNameValue);
		adminuserspage.userPasswordEdit(editPasswordValue);
		adminuserspage.selectUserTypeEditDropDown();
		adminuserspage.clickUserTypeUpdateButton();
		boolean isUserTypeUpdated=adminuserspage.isUserTypeUpdateAlertDisplayed();
		assertTrue(isUserTypeUpdated,"Details of the User Is NOT Updated");
		
	}
	
	@Test
	
	public void verifyUserCanChangeStatus() throws IOException
	{
		String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameInUsernameField(usernameValue);
		loginpage.enterPasswordInPasswordField(passwordValue);
		loginpage.clickSigninButton();
		
		AdminUsersPage adminuserspage=new AdminUsersPage(driver);
		adminuserspage.clickAdminUsersMoreInfo();
		String oldStatus=adminuserspage.userOldStatus();
		adminuserspage.clickUserTypeStatusUpdateButton();
		String newStatus=adminuserspage.userNewStatus();
		assertEquals(oldStatus,newStatus,"Status of the User is NOT Updated");
		
		
		
	}

}
