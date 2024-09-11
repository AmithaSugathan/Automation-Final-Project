package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {

	WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@href,'list-news') and @class='small-box-footer']")
	private WebElement manageNewsMoreInfo;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	private WebElement clickNewsButton;
	@FindBy(xpath = "//textarea[@id='news']")
	private WebElement enterNewsField;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	private WebElement manageNewsSaveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement newsCreated;

	public ManageNewsPage clickManageNewsMoreInfo() {
		manageNewsMoreInfo.click();
		return this;
	}

	public ManageNewsPage clickManageNewsButton() {
		clickNewsButton.click();
		return this;
	}

	public ManageNewsPage enterNews(String news) {
		enterNewsField.sendKeys(news);
		return this;
	}

	public ManageNewsPage clickNewsSaveButton() {
		manageNewsSaveButton.click();
		return this;
	}

	public boolean isNewsCreated() {
		return newsCreated.isDisplayed();
	}

}
