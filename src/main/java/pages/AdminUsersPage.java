package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminUsersPage {

	WebDriver driver;
	PageUtility pageutility = new PageUtility();

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@href,'list-admin') and @class='small-box-footer']")
	private WebElement adminUsersMoreInfo;

	// TO ADD NEW USER
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	private WebElement newUserButton;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement newUsernameField;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement newUserPasswordField;
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement newUserTypeDropDown;
	@FindBy(xpath = "//button[@name='Create']")
	private WebElement newUserSaveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement newUserSaveAlert;

	// TO EDIT USER DETAILS
	@FindBy(xpath = "//a[contains(@href,'user/edit') and @class='btn btn-sm btn btn-primary btncss'][1]")
	private WebElement userEditButton;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement userNameEditField;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordEditField;
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement userTypeEditDropDown;
	@FindBy(xpath = "//button[@name='Update']")
	private WebElement userTypeUpdateButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement userTypeUpdateAlertDisplayed;

	// TO CHANGE STATUS
	@FindBy(xpath = "//span[@class='badge bg-success'][1]")
	private WebElement userTypeStatusUpdateButton;

	// ADD NEW USER
	public AdminUsersPage clickAdminUsersMoreInfo() {
		adminUsersMoreInfo.click();
		return this;
	}

	public AdminUsersPage clickNewUserButton() {
		newUserButton.click();
		return this;
	}

	public AdminUsersPage enterNewUsername(String newUsername) {
		newUsernameField.sendKeys(newUsername);
		return this;
	}

	public AdminUsersPage enterNewUserPassword(String newUserPassword) {
		newUserPasswordField.sendKeys(newUserPassword);
		return this;
	}

	public AdminUsersPage selectNewUserTypeDropDown() {
		// Select select=new Select(newUserTypeDropDown);
		// select.selectByVisibleText("admin");
		pageutility.selectDropDrownUsingSelectByVisibleText(newUserTypeDropDown, "Admin");
		return this;
	}

	public ManageContactPage clickNewUserSaveButton() {
		newUserSaveButton.click();
		return new ManageContactPage(driver);
	}

	public boolean isNewUserCreated() {
		return newUserSaveAlert.isDisplayed();
	}

	// EDIT USER
	public AdminUsersPage clickUserEditButton() {
		userEditButton.click();
		return this;
	}

	public AdminUsersPage userNameEdit(String editUserName) {
		userEditButton.clear();
		userNameEditField.sendKeys(editUserName);
		return this;
	}

	public AdminUsersPage userPasswordEdit(String editPassword) {
		passwordEditField.sendKeys(editPassword);
		return this;
	}

	public AdminUsersPage selectUserTypeEditDropDown() {
		Select select = new Select(userTypeEditDropDown);
		select.selectByVisibleText("Staff");
		return this;
	}

	public ManageContactPage clickUserTypeUpdateButton() {
		userTypeUpdateButton.click();
		return new ManageContactPage(driver);
	}

	public boolean isUserTypeUpdateAlertDisplayed() {
		return userTypeUpdateAlertDisplayed.isDisplayed();
	}

	// TO CHANGE STATUS

	public String userOldStatus() {
		String oldStatus = userTypeStatusUpdateButton.getText();
		return oldStatus;
	}

	public AdminUsersPage clickUserTypeStatusUpdateButton() {
		userTypeStatusUpdateButton.click();
		return this;
	}

	public String userNewStatus() {
		String newStatus = userTypeStatusUpdateButton.getText();
		return newStatus;
	}

}
