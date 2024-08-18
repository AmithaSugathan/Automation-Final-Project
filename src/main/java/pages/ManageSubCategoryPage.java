package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageSubCategoryPage {
	
	WebDriver driver;

	public ManageSubCategoryPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@name='username']")private WebElement usernameField;
	@FindBy(xpath="//input[@name='password']")private WebElement passwordField;
	@FindBy(xpath="//button[@type='submit']")private WebElement siginButton;

	@FindBy(xpath="//a[contains(@href,'list-sub-category') and @class='small-box-footer']")private WebElement manageSubCategoryMoreInfo;
	@FindBy(xpath="//span[@class='badge bg-success'][1]")private WebElement manageSubCategoryStatus;
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")private WebElement manageSubCategoryAlertDisplayed;

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
	
	public void clickManageSubCategoryMoreInfo()
	{
		manageSubCategoryMoreInfo.click();
	}
	public void clickManageSubCategoryStatusButton()
	{
		manageSubCategoryStatus.click();
	}
	
	public boolean isCategoryStatusUpdated()
	{
		return manageSubCategoryAlertDisplayed.isDisplayed();
	}
	
	
	
	
	
}
