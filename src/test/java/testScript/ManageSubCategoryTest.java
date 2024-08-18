package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageSubCategoryPage;
import utilities.ExcelUtility;

public class ManageSubCategoryTest extends Base{
	
	@Test
	
	public void verifyUserIsAbleToChangeStatus() throws IOException
	{
		String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameInUsernameField(usernameValue);
		loginpage.enterPasswordInPasswordField(passwordValue);
		loginpage.clickSigninButton();
		
		ManageSubCategoryPage managesubcategorypage=new ManageSubCategoryPage(driver);
		managesubcategorypage.clickManageSubCategoryMoreInfo();
		managesubcategorypage.clickManageSubCategoryStatusButton();
		boolean isCategoryAlertDisplayed=managesubcategorypage.isCategoryStatusUpdated();
		assertTrue(isCategoryAlertDisplayed,"Sub Category Status is NOT Updated");		
		
	}

}
