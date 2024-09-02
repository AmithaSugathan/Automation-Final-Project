package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooterTextPage {
	WebDriver driver;

	public ManageFooterTextPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@name='username']")private WebElement usernameField;
	@FindBy(xpath="//input[@name='password']")private WebElement passwordField;
	@FindBy(xpath="//button[@type='submit']")private WebElement siginButton;
	
	@FindBy(xpath="//a[contains(@href,'list-footertext') and @class='small-box-footer']")private WebElement manageFooterMoreInfo;
	@FindBy(xpath="//a[contains(@href,'Footertext/edit') and @class='btn btn-sm btn btn-primary btncss'][1]")private WebElement manageFooterEditButton;
	@FindBy(xpath="//textarea[@id='content']")private WebElement addressField;
	@FindBy(xpath="//input[@id='email']")private WebElement emailField;
	@FindBy(xpath="//input[@id='phone']")private WebElement phoneNumberField;
	@FindBy(xpath="//button[@name='Update']")private WebElement updateButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement updateAlertDisplayed;
	
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
	
	public void clickManageFooterMoreInfo()
	{
		manageFooterMoreInfo.click();
	}
	
	public void clickManageFooterEditButton()
	{
		manageFooterEditButton.click();
	}
	
	public void enterAddress(String newAddress)
	{
		addressField.clear();
		addressField.sendKeys(newAddress);
	}
	
	public void enterEmail(String email)
	{
		emailField.clear();
		emailField.sendKeys(email);
	}
	
	public void enterPhoneNumber(String phone)
	{
		phoneNumberField.clear();
		phoneNumberField.sendKeys(phone);
	}
	public void clickUpdate()
	{
		updateButton.click();
	}
	public boolean isFooterTextUpdateAlertDisplayed()
	{
		return updateAlertDisplayed.isDisplayed();
	}
}
