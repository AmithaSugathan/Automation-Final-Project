package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageContactPage {
	
	WebDriver driver;

	public ManageContactPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@name='username']")private WebElement usernameField;
	@FindBy(xpath="//input[@name='password']")private WebElement passwordField;
	@FindBy(xpath="//button[@type='submit']")private WebElement siginButton;
	
	@FindBy(xpath="//a[contains(@href,'list-contact') and @class='small-box-footer']")private WebElement manageContactMoreInfo;
	@FindBy(xpath="//a[contains(@href,'edit_contact') and @class='btn btn-sm btn btn-primary btncss']")private WebElement manageContactEditButton;
	@FindBy(xpath="//input[@id='phone']")private WebElement manageContactPhoneNumberEditField;
	@FindBy(xpath="//input[@id='email']")private WebElement manageContactEmailField;
	@FindBy(xpath="//textarea[@id='content' and @placeholder='Enter the Address']")private WebElement manageContactAddressField;
	@FindBy(xpath="//textarea[@id='content' and @placeholder='Enter Delivery Time']")private WebElement manageContactDeliveryTimeEditField;
	@FindBy(xpath="//input[@id='del_limit']")private WebElement manageContactDeliveryChargeLimitField;
	@FindBy(xpath="//button[@name='Update']")private WebElement manageContactUpdateButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement contactUpdated;


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
	
	public void clickManageContactMoreInfo()
	{
		manageContactMoreInfo.click();
	}
	
	public void clickmanageContactEditButton()
	{
		manageContactEditButton.click();
	}
	
	public void manageContactPhoneNumberEdit(String phoneNumber)
	{
		manageContactPhoneNumberEditField.sendKeys(phoneNumber);
	}

	public void manageContactEmailEdit(String email)
	{
		manageContactEmailField.sendKeys(email);
		
	}
	
	public void manageContactAddressEdit(String address)
	{
	manageContactAddressField.sendKeys(address);
	}
	
	public void manageContactDeliveryTimeEdit(String deliveryTime)
	{
		manageContactDeliveryTimeEditField.sendKeys(deliveryTime);
	}
	
	public void manageContactDeliveryChargeLimit(String deliveryChrageLimit)
	{	
	manageContactDeliveryChargeLimitField.sendKeys(deliveryChrageLimit);
	}
	
	public void clickManageContactUpdateButton()
	{
	//manageContactUpdateButton.click();
		PageUtility pageutility=new PageUtility();
		pageutility.javaScriptClick(driver, manageContactUpdateButton);
	}
	
	public boolean isContactUpdateAlertDisplayed()
	{
		return contactUpdated.isDisplayed();
	}
	
	
	

}

