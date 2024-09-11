package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageContactPage {

	WebDriver driver;

	public ManageContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(@href,'list-contact') and @class='small-box-footer']")
	private WebElement manageContactMoreInfo;
	@FindBy(xpath = "//a[contains(@href,'edit_contact') and @class='btn btn-sm btn btn-primary btncss']")
	private WebElement manageContactEditButton;
	@FindBy(xpath = "//input[@id='phone']")
	private WebElement manageContactPhoneNumberEditField;
	@FindBy(xpath = "//input[@id='email']")
	private WebElement manageContactEmailField;
	@FindBy(xpath = "//textarea[@id='content' and @placeholder='Enter the Address']")
	private WebElement manageContactAddressField;
	@FindBy(xpath = "//textarea[@id='content' and @placeholder='Enter Delivery Time']")
	private WebElement manageContactDeliveryTimeEditField;
	@FindBy(xpath = "//input[@id='del_limit']")
	private WebElement manageContactDeliveryChargeLimitField;
	@FindBy(xpath = "//button[@name='Update']")
	private WebElement manageContactUpdateButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement contactUpdated;

	public ManageContactPage clickmanageContactEditButton() {
		manageContactEditButton.click();
		return this;
	}

	public ManageContactPage manageContactPhoneNumberEdit(String phoneNumber) {
		manageContactPhoneNumberEditField.sendKeys(phoneNumber);
		return this;
	}

	public ManageContactPage manageContactEmailEdit(String email) {
		manageContactEmailField.sendKeys(email);
		return this;

	}

	public ManageContactPage manageContactAddressEdit(String address) {
		manageContactAddressField.sendKeys(address);
		return this;
	}

	public ManageContactPage manageContactDeliveryTimeEdit(String deliveryTime) {
		manageContactDeliveryTimeEditField.sendKeys(deliveryTime);
		return this;
	}

	public ManageContactPage manageContactDeliveryChargeLimit(String deliveryChrageLimit) {
		manageContactDeliveryChargeLimitField.sendKeys(deliveryChrageLimit);
		return this;
	}

	public ManageFooterTextPage clickManageContactUpdateButton() {
		// manageContactUpdateButton.click();
		PageUtility pageutility = new PageUtility();
		pageutility.javaScriptClick(driver, manageContactUpdateButton);
		return new ManageFooterTextPage(driver);
	}

	public boolean isContactUpdateAlertDisplayed() {
		return contactUpdated.isDisplayed();
	}

}
