package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminUsersPage {

	WebDriver driver;
	PageUtility pageutility=new PageUtility();

	public AdminUsersPage(WebDriver driver)
	{
			this.driver = driver;
			PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='username']")private WebElement usernameField;
	@FindBy(xpath="//input[@name='password']")private WebElement passwordField;
	@FindBy(xpath="//button[@type='submit']")private WebElement siginButton;
	
	@FindBy(xpath="//a[contains(@href,'list-admin') and @class='small-box-footer']")private WebElement adminUsersMoreInfo;
	
	//TO ADD NEW USER
	@FindBy(xpath="//a[@onclick='click_button(1)']")private WebElement newUserButton;
	@FindBy(xpath="//input[@id='username']")private WebElement newUsernameField;
	@FindBy(xpath="//input[@id='password']")private WebElement newUserPasswordField;
	@FindBy(xpath="//select[@id='user_type']")private WebElement newUserTypeDropDown;
	@FindBy(xpath="//button[@name='Create']")private WebElement newUserSaveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement newUserSaveAlert;
	
	//TO EDIT USER DETAILS
	//@FindBy(xpath="//td[text()='amitha']//following::a[contains(@href,'user/edit')]")private WebElement userEditButton;
	@FindBy(xpath="//a[contains(@href,'user/edit') and @class='btn btn-sm btn btn-primary btncss'][1]")private WebElement userEditButton;
	@FindBy(xpath="//input[@id='username']")private WebElement userNameEditField;	
	@FindBy(xpath="//input[@id='password']")private WebElement passwordEditField;
	@FindBy(xpath="//select[@id='user_type']")private WebElement userTypeEditDropDown;
	@FindBy(xpath="//button[@name='Update']")private WebElement userTypeUpdateButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement userTypeUpdateAlertDisplayed;
	
	//TO CHANGE STATUS
	//@FindBy(xpath="//td[text()='amitha']//following::a[contains(@href,'user/status')]//following::span[@class='badge bg-success']")private WebElement userTypeStatusUpdateButton;
	@FindBy(xpath="//span[@class='badge bg-success'][1]")private WebElement userTypeStatusUpdateButton;
	
	
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
	
	
	//ADD NEW USER
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
		//Select select=new Select(newUserTypeDropDown);
		//select.selectByVisibleText("admin");
		pageutility.selectDropDrownUsingSelectByVisibleText(newUserTypeDropDown,"Admin");
	}
	public void clickNewUserSaveButton()
	{
		newUserSaveButton.click();
	}
	
	public boolean isNewUserCreated()
	{
	return newUserSaveAlert.isDisplayed();
	}
	
	//EDIT USER
	public void clickUserEditButton()
	{
		userEditButton.click();
	}
	
	public void userNameEdit(String editUserName)
	{
		userEditButton.clear();
		userNameEditField.sendKeys(editUserName);
	}
	
	public void userPasswordEdit(String editPassword)
	{
		passwordEditField.sendKeys(editPassword);
	}
	
	public void selectUserTypeEditDropDown()
	{
		Select select=new Select(userTypeEditDropDown);
		select.selectByVisibleText("Staff");
	}
	
	public void clickUserTypeUpdateButton()
	{
		userTypeUpdateButton.click();
	}
	 
	public boolean isUserTypeUpdateAlertDisplayed()
	{
	return userTypeUpdateAlertDisplayed.isDisplayed();
	}
	
	//TO CHANGE STATUS
	
	public String userOldStatus()
	{
		String oldStatus=userTypeStatusUpdateButton.getText();
		return oldStatus;
	}
	
	public void clickUserTypeStatusUpdateButton()
	{
		userTypeStatusUpdateButton.click();
	}
	
	public String userNewStatus()
	{
		String newStatus=userTypeStatusUpdateButton.getText();
		return newStatus;
	}
	
	
	
	
	
}
