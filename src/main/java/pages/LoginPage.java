package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver)// Constructor
	{
		this.driver = driver;// instance driver=local driver
		PageFactory.initElements(driver, this);// initElements:a static method to use @FindBy, so With Page Factory
	}

	@FindBy(xpath = "//input[@name='username']")
	private WebElement usernameField;// locate elements with Page Factory
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordField;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement siginButton;
	@FindBy(xpath = "//img[@class='img-circle']")
	private WebElement dashboardImage;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement invalidLoginAlert;
	@FindBy(xpath = "//a[contains(@href,'list-contact') and @class='small-box-footer']")
	private WebElement manageContactMoreInfo;

	public LoginPage enterUsernameInUsernameField(String username) {
		usernameField.sendKeys(username);
		return this;
	}

	public LoginPage enterPasswordInPasswordField(String password) {
		passwordField.sendKeys(password);
		return this;
	}

	public AdminUsersPage clickSigninButton() {
		WaitUtility waitutility = new WaitUtility();
		waitutility.waitForElementToBeClickable(driver, siginButton);
		siginButton.click();
		return new AdminUsersPage(driver);
	}

	public boolean isDasboardLoadedSuccessfully() {
		return dashboardImage.isDisplayed();// Return TRUE if dashboard is displayed
	}

	public boolean isInvalidLoginAlertDisplayed() {
		return invalidLoginAlert.isDisplayed();// Return TRUE if InvalidLoginAlert is displayed
	}
	
	public ManageContactPage clickManageContactMoreInfo() {
		manageContactMoreInfo.click();
		return new ManageContactPage(driver);
	}

}
