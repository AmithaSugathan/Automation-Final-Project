package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base{

	@Test
	
	public void verifyUserCanCreateNews() throws IOException
	{
		String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");
		String newsValue=ExcelUtility.getStringData(1, 0, "ManageNews");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameInUsernameField(usernameValue);
		loginpage.enterPasswordInPasswordField(passwordValue);
		loginpage.clickSigninButton();
		
		ManageNewsPage managenewspage=new ManageNewsPage(driver);
		managenewspage.clickManageNewsMoreInfo();
		managenewspage.clickManageNewsButton();
		managenewspage.enterNews(newsValue);
		managenewspage.clickNewsSaveButton();
		boolean isNewsSaved=managenewspage.isNewsCreated();
		assertTrue(isNewsSaved,"Latest News is not Saved");
	}
	
	
}
