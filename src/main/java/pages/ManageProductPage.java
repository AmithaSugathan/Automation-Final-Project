package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageProductPage {

	WebDriver driver;

	public ManageProductPage(WebDriver driver)
	{
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@name='username']")private WebElement usernameField;
	@FindBy(xpath="//input[@name='password']")private WebElement passwordField;
	@FindBy(xpath="//button[@type='submit']")private WebElement siginButton;
	
	@FindBy(xpath="//a[contains(@href,'list-product') and @class='small-box-footer']")private WebElement manageProductMoreInfo;
	@FindBy(xpath="//a[contains(@href,'Product/delete') and @class='btn btn-sm btn btn-danger btncss'][1]")private WebElement manageProductDeleteButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement manageProductDeletedAlert;
	
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
	
	public void clickManageProductMoreInfo()
	{
		manageProductMoreInfo.click();
	}
	
	public void clickManageProductDeleteIcon()
	{
		manageProductDeleteButton.click();
	}
	
	public void clickManageProductDeleteOkButton()
	{
		driver.switchTo().alert().accept();
	}
	
	public boolean isDeleteAlertDisplayed()
	{
		return manageProductDeletedAlert.isDisplayed();
	}
	
}

