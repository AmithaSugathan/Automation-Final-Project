package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageFooterTextPage;
import utilities.ExcelUtility;

public class ManageFooterTextTest extends Base{

	@Test(description="Verify that the User Is Able To Edit Details(Address,Phone & Email) of Footer Text Page")
	public void verifyUserIsAbleToEditFooterTextDetails() throws IOException
	{
		String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");
		
		String addressValue=ExcelUtility.getStringData(1, 0, "ManageFooter");
		String emailValue=ExcelUtility.getStringData(1, 1, "ManageFooter");
		String phoneValue=ExcelUtility.getIntegerData(1, 2, "ManageFooter");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameInUsernameField(usernameValue);
		loginpage.enterPasswordInPasswordField(passwordValue);
		loginpage.clickSigninButton();
		
		ManageFooterTextPage managefootertextpage=new ManageFooterTextPage(driver);
		managefootertextpage.clickManageFooterMoreInfo();
		managefootertextpage.clickManageFooterEditButton();
		managefootertextpage.enterAddress(addressValue);
		managefootertextpage.enterEmail(emailValue);
		managefootertextpage.enterPhoneNumber(phoneValue);
		managefootertextpage.clickSigninButton();
		boolean isupdateAlertDisplayed=managefootertextpage.isFooterTextUpdateAlertDisplayed();
		assertTrue(isupdateAlertDisplayed,"Details of Footer Text Page are NOT Updated");
		
		
		
	}
	
	
}
