package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageProductPage {

	WebDriver driver;

	public ManageProductPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@href,'list-product') and @class='small-box-footer']")
	private WebElement manageProductMoreInfo;
	@FindBy(xpath = "//a[contains(@href,'Product/delete') and @class='btn btn-sm btn btn-danger btncss'][1]")
	private WebElement manageProductDeleteButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement manageProductDeletedAlert;

	public ManageProductPage clickManageProductMoreInfo() {
		manageProductMoreInfo.click();
		return this;
	}

	public ManageProductPage clickManageProductDeleteIcon() {
		manageProductDeleteButton.click();
		return this;
	}

	public ManageProductPage clickManageProductDeleteOkButton() {
		driver.switchTo().alert().accept();
		return this;
	}

	public boolean isDeleteAlertDisplayed() {
		return manageProductDeletedAlert.isDisplayed();
	}

}
