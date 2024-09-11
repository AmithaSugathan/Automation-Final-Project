package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooterTextPage {
	WebDriver driver;

	public ManageFooterTextPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@href,'list-footertext') and @class='small-box-footer']")
	private WebElement manageFooterMoreInfo;
	@FindBy(xpath = "//a[contains(@href,'Footertext/edit') and @class='btn btn-sm btn btn-primary btncss'][1]")
	private WebElement manageFooterEditButton;
	@FindBy(xpath = "//textarea[@id='content']")
	private WebElement addressField;
	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailField;
	@FindBy(xpath = "//input[@id='phone']")
	private WebElement phoneNumberField;
	@FindBy(xpath = "//button[@name='Update']")
	private WebElement updateButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement updateAlertDisplayed;

	public ManageFooterTextPage clickManageFooterMoreInfo() {
		manageFooterMoreInfo.click();
		return this;
	}

	public ManageFooterTextPage clickManageFooterEditButton() {
		manageFooterEditButton.click();
		return this;
	}

	public ManageFooterTextPage enterAddress(String newAddress) {
		addressField.clear();
		addressField.sendKeys(newAddress);
		return this;
	}

	public ManageFooterTextPage enterEmail(String email) {
		emailField.clear();
		emailField.sendKeys(email);
		return this;
	}

	public ManageFooterTextPage enterPhoneNumber(String phone) {
		phoneNumberField.clear();
		phoneNumberField.sendKeys(phone);
		return this;
	}

	public ManageFooterTextPage clickUpdate() {
		updateButton.click();
		return this;
	}

	public boolean isFooterTextUpdateAlertDisplayed() {
		return updateAlertDisplayed.isDisplayed();
	}
}
