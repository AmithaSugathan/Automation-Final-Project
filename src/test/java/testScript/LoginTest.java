package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;


import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base{
	
	@Test

	public void verifyTheUserIsAbleToLoginUsingValidCredentials() throws IOException
	{
		
		//String usernameValue="admin";
		//String passwordValue="admin";
		String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameInUsernameField(usernameValue);
		loginpage.enterPasswordInPasswordField(passwordValue);
		loginpage.clickSigninButton();
		boolean isHomePageLoaded=loginpage.isDasboardLoadedSuccessfully();
		assertTrue(isHomePageLoaded,"Home Page is not Launched with Valid Credentials");

	}
	
	@Test
public void verifyTheUserIsAbleToLoginUsingInvalidUsername()
{
	String usernameValue="amitha";
	String passwordValue="admin";
	LoginPage loginpage=new LoginPage(driver);
	loginpage.enterUsernameInUsernameField(usernameValue);
	loginpage.enterPasswordInPasswordField(passwordValue);
	loginpage.clickSigninButton();
	boolean isHomePageLoaded=loginpage.isDasboardLoadedSuccessfully();
	assertTrue(isHomePageLoaded,"Home Page is Launched with Invalid Username and valid password");
	
}

	@Test
	public void verifyTheUserIsAbleToLoginUsingInvalidPassword()
	{
		String usernameValue="admin";
		String passwordValue="amitha";
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameInUsernameField(usernameValue);
		loginpage.enterPasswordInPasswordField(passwordValue);
		loginpage.clickSigninButton();
		boolean isHomePageLoaded=loginpage.isDasboardLoadedSuccessfully();
		assertTrue(isHomePageLoaded,"Home Page is Launched with valid username and Invalid Password");
	}
	
	@Test
	
	public void verifyTheUserIsAbleToLoginUsingInvalidUsernameAndPassword()
	{
		String usernameValue="amitha";
		String passwordValue="amitha";
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameInUsernameField(usernameValue);
		loginpage.enterPasswordInPasswordField(passwordValue);
		loginpage.clickSigninButton();
		boolean isHomePageLoaded=loginpage.isDasboardLoadedSuccessfully();
		assertTrue(isHomePageLoaded,"Home Page is Launched with Invalid Username and Invalid Password");
	}
	
	
	
	
	
}