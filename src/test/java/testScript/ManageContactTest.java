package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.AdminUsersPage;
import pages.LoginPage;
import pages.ManageContactPage;
import pages.ManageFooterTextPage;
import utilities.ExcelUtility;

public class ManageContactTest extends Base{
	public LoginPage login;
	public AdminUsersPage admin;
	public ManageContactPage contact;
	public ManageFooterTextPage footer;
		
	@Test(description="Verify that the user is able to Edit an Existing Contact in the Supermarket app")
	
	public void verifyUserIsAbleToEditContact() throws IOException
	{
		String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");
		
		String phoneNumberValue=ExcelUtility.getIntegerData(1, 0, "ManageContact");
		String emailValue=ExcelUtility.getStringData(1, 1, "ManageContact");
		String addressValue=ExcelUtility.getStringData(1, 2, "ManageContact");
		String deliveryTimeValue=ExcelUtility.getIntegerData(1, 3, "ManageContact");
		String deliveryChargeValue=ExcelUtility.getIntegerData(1, 4, "ManageContact");
		
		login=new LoginPage(driver);
		login.enterUsernameInUsernameField(usernameValue).enterPasswordInPasswordField(passwordValue);
		admin=login.clickSigninButton();
		contact=login.clickManageContactMoreInfo();
		footer=contact.clickmanageContactEditButton().manageContactPhoneNumberEdit(phoneNumberValue).manageContactEmailEdit(emailValue).manageContactAddressEdit(addressValue).manageContactDeliveryTimeEdit(deliveryTimeValue).manageContactDeliveryChargeLimit(deliveryChargeValue).clickManageContactUpdateButton();
				
		boolean isContactUpdated=contact.isContactUpdateAlertDisplayed();
		assertTrue(isContactUpdated,Constants.CONTACTNOTEDITED);
	}

}
