package testScript;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;

public class ManageCategoryTest extends Base{
	@Test(description="Verify that the user is able to Add New Category to the Supermarket app")
	
	public void verifyUserIsAbleToAddNewCategory() throws IOException, AWTException
	{
		String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");
		String categoryValue=ExcelUtility.getStringData(1, 0, "ManageCategory");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameInUsernameField(usernameValue);
		loginpage.enterPasswordInPasswordField(passwordValue);
		loginpage.clickSigninButton();
		
		ManageCategoryPage managecategorypage=new ManageCategoryPage(driver);
		managecategorypage.clickManageCategoryMoreInfo();
		managecategorypage.clickManageCategoryNewButton();
		managecategorypage.enterCategoryField(categoryValue);
		managecategorypage.clickManageCategorySelectGroup();
		managecategorypage.clickManageCategoryImageChooseFile();
		
		boolean isCategoryTopMenuYesRadioButtonDisplayed=managecategorypage.isTopMenuYesRadioButtonDisplayed();
		assertTrue(isCategoryTopMenuYesRadioButtonDisplayed,"Top Menu Yes Button NOT Displayed");
		
		managecategorypage.clickTopMenuYesRadioButton();
		boolean isCategoryTopMenuYesRadioButtonEnabled=managecategorypage.isTopMenuYesRadioButtonEnabled();
		assertTrue(isCategoryTopMenuYesRadioButtonEnabled,"Top Menu Yes Button NOT Enabled");
		
		boolean isCategoryLeftMenuYesRadioButtonDisplayed=managecategorypage.isLeftMenuYesRadioButtonDisplayed();
		assertTrue(isCategoryLeftMenuYesRadioButtonDisplayed,"Left Menu Yes Button NOT Displayed");
		
		managecategorypage.clickLeftMenuYesRadioButton();
		boolean isCategoryLeftMenuYesRadioButtonEnabled=managecategorypage.isLeftMenuYesRadioButtonEnabled();
		assertTrue(isCategoryLeftMenuYesRadioButtonEnabled,"Left Menu Yes Button NOT Enabled");
		
		managecategorypage.clickManageCategorySaveButton();
		
		boolean isCategoryAlertDisplayed= managecategorypage.isManageCategoryAlertDisplayed();
		assertTrue(isCategoryAlertDisplayed,Constants.NEWCATEGORYNOTSAVED);
	}
	
	/*@Test(description="Verify that the user is able to Search an Existing Category in the Supermarket app")
	
	public void verifyUserIsAbleToSearchCategory() throws IOException
	{
		String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");
		String searchCategoryValue=ExcelUtility.getStringData(1, 1, "ManageCategory");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameInUsernameField(usernameValue);
		loginpage.enterPasswordInPasswordField(passwordValue);
		loginpage.clickSigninButton();
		
		ManageCategoryPage managecategorypage=new ManageCategoryPage(driver);
		managecategorypage.clickCategorySearchButton();
		managecategorypage.enterCategoryToSearch(searchCategoryValue);
		managecategorypage.clickEnterCategorySearchButton();
		boolean isSearchCategoryResultDisplayed=managecategorypage.isSearchCategoryFound(searchCategoryValue);
		assertTrue(isSearchCategoryResultDisplayed,"Search Category Is Present");
		
	}*/
	
}
