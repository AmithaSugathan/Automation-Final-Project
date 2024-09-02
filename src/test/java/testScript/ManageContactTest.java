package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;

public class ManageContactTest extends Base{
	
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
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameInUsernameField(usernameValue);
		loginpage.enterPasswordInPasswordField(passwordValue);
		loginpage.clickSigninButton();
		
		ManageContactPage managecontactpage=new ManageContactPage(driver);
		managecontactpage.clickManageContactMoreInfo();
		managecontactpage.clickmanageContactEditButton();
		managecontactpage.manageContactPhoneNumberEdit(phoneNumberValue);
		managecontactpage.manageContactEmailEdit(emailValue);
		managecontactpage.manageContactAddressEdit(addressValue);
		managecontactpage.manageContactDeliveryTimeEdit(deliveryTimeValue);
		managecontactpage.manageContactDeliveryChargeLimit(deliveryChargeValue);
		managecontactpage.clickManageContactUpdateButton();
		boolean isContactUpdated=managecontactpage.isContactUpdateAlertDisplayed();
		assertTrue(isContactUpdated,"Contact Details of the User is NOT Edited");
	}

}
