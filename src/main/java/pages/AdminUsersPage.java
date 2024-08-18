package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUsersPage {

	WebDriver driver;

	public AdminUsersPage(WebDriver driver)
	{
			this.driver = driver;
			PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='username']")private WebElement usernameField;
	@FindBy(xpath="//input[@name='password']")private WebElement passwordField;
	@FindBy(xpath="//button[@type='submit']")private WebElement siginButton;
	
	@FindBy(xpath="//a[contains(@href,'list-admin') and @class='small-box-footer']")private WebElement adminUsersMoreInfo;
	@FindBy(xpath="//a[@onclick='click_button(1)']")private WebElement newUserButton;
	@FindBy(xpath="//input[@id='username']")private WebElement newUsernameField;
	@FindBy(xpath="//input[@id='password']")private WebElement newUserPasswordField;
	@FindBy(xpath="//select[@id='user_type']")private WebElement newUserTypeDropDown;
	@FindBy(xpath="//button[@name='Create']")private WebElement newUserSaveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement newUserSaveAlert;
	
	public void enterUsernameInUsernameField(String username)
	{
		usernameField.sendKeys(username);
	}
	
	public void enterPasswordInPasswordField(String password)
	{
		passwordField.sendKeys(password);
	}
	
	public void clickSigninButton()
	{
		siginButton.click();
	}
	
	public void clickAdminUsersMoreInfo()
	{
		adminUsersMoreInfo.click();
	}
	public void clickNewUserButton()
	{
		newUserButton.click();
	}
	public void enterNewUsername(String newUsername)
	{
		newUsernameField.sendKeys(newUsername);
	}
	public void enterNewUserPassword(String newUserPassword)
	{
		newUserPasswordField.sendKeys(newUserPassword);
	}
	
	public void selectNewUserTypeDropDown()
	{
		Select select=new Select(newUserTypeDropDown);
		select.selectByVisibleText("admin");
	}
	
	public boolean isNewUserCreated()
	{
	return newUserSaveAlert.isDisplayed();
	}
	
	
}
