package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageSubCategoryPage {

	WebDriver driver;

	public ManageSubCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@href,'list-sub-category') and @class='small-box-footer']")
	private WebElement manageSubCategoryMoreInfo;
	@FindBy(xpath = "//span[@class='badge bg-success'][1]")
	private WebElement manageSubCategoryStatus;
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement manageSubCategoryAlertDisplayed;

	public ManageSubCategoryPage clickManageSubCategoryMoreInfo() {
		manageSubCategoryMoreInfo.click();
		return this;
	}

	public ManageSubCategoryPage clickManageSubCategoryStatusButton() {
		manageSubCategoryStatus.click();
		return this;
	}

	public boolean isCategoryStatusUpdated() {
		return manageSubCategoryAlertDisplayed.isDisplayed();
	}

}
