package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;

public class ManageContactTest extends Base{
	
	@Test
	
	public void verifyUserIsAbleToEditContact() throws IOException
	{
		String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");
		String phoneNumberValue=ExcelUtility.getIntegerData(1, 0, "ManageContact");
		String emailValue=ExcelUtility.getIntegerData(2, 0, "ManageContact");
		String addressValue=ExcelUtility.getIntegerData(3, 0, "ManageContact");
		String deliveryTimeValue=ExcelUtility.getIntegerData(4, 0, "ManageContact");
		String deliveryChargeValue=ExcelUtility.getIntegerData(5, 0, "ManageContact");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameInUsernameField(usernameValue);
		loginpage.enterPasswordInPasswordField(passwordValue);
		loginpage.clickSigninButton();
		
		ManageContactPage managecontactpage=new ManageContactPage(driver);
		managecontactpage.clickmanageContactEditButton();
		managecontactpage.manageContactPhoneNumberEdit(phoneNumberValue);
		managecontactpage.manageContactEmailEdit(emailValue);
		managecontactpage.manageContactAddressEdit(addressValue);
		managecontactpage.manageContactDeliveryTimeEdit(deliveryTimeValue);
		managecontactpage.manageContactDeliveryChargeLimit(deliveryChargeValue);
		boolean isContactUpdated=managecontactpage.isContactUpdateAlertDisplayed();
		assertTrue(isContactUpdated,"Contact Details of the User is NOT Edited");
	}

}
