package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageProductPage;
import utilities.ExcelUtility;

public class ManageProductTest extends Base{
	
	@Test
	
	public void verifyUserCanDeleteProduct() throws IOException
	{
		String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameInUsernameField(usernameValue);
		loginpage.enterPasswordInPasswordField(passwordValue);
		loginpage.clickSigninButton();
		
		ManageProductPage manageproductpage=new ManageProductPage(driver);
		manageproductpage.clickManageProductMoreInfo();
		manageproductpage.clickManageProductDeleteIcon();
		manageproductpage.clickManageProductDeleteOkButton();
		boolean isProductDeleted=manageproductpage.isDeleteAlertDisplayed();
		assertTrue(isProductDeleted,"The Selected Product is DELETED");
		
	}
	}


