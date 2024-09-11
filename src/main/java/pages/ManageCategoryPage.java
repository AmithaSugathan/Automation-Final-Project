package pages;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
//import bsh.org.objectweb.asm.Constants;
import utilities.FileUploadUtility;
import utilities.PageUtility;

public class ManageCategoryPage {

	WebDriver driver;

	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@href,'list-category') and @class='small-box-footer'][1]")
	private WebElement manageCategoryMoreInfo;

	// TO SAVE A CATEGORY
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	private WebElement manageCategoryNewButton;
	@FindBy(xpath = "//input[@id='category']")
	private WebElement manageCategoryField;
	@FindBy(xpath = "//li[@id='134-selectable']")
	private WebElement manageCategorySelectGroup;
	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement manageCategoryImageChooseFile;

	// ASK
	@FindBy(xpath = "//div/label/input[@name='top_menu' and @value='yes']")
	private WebElement manageCategoryTopMenuYesRadioButton;
	@FindBy(xpath = "//div/label/input[@name='top_menu' and @value='no']")
	private WebElement manageCategoryTopMenuNoRadioButton;
	@FindBy(xpath = "//div/label/input[@name='show_home' and @value='yes']")
	private WebElement manageCategoryLeftMenuYesRadioButton;
	@FindBy(xpath = "//div/label/input[@name='show_home' and @value='no']")
	private WebElement manageCategoryLeftMenuNoRadioButton;

	@FindBy(xpath = "//button[contains(@class,'btn btn-danger')]")
	private WebElement manageCategorySaveButton;
	@FindBy(xpath = "//div[contains(@class,'success alert-dismissible')]")
	private WebElement manageCategoryAlertDisplayed;

	// TO SEARCH A CATEGORY
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	private WebElement manageCategorySearchButton;
	@FindBy(xpath = "//input[@placeholder='Category']")
	private WebElement enterCategoryToSearchField;
	@FindBy(xpath = "//button[@name='Search']")
	private WebElement enterCategorySearchButton;
	@FindBy(xpath = "//td[contains(text(),'Electric')]")
	private List<WebElement> searchResultList;

	public ManageCategoryPage clickManageCategoryMoreInfo() {
		manageCategoryMoreInfo.click();
		return this;
	}

	// TO SAVE A CATEGORY

	public ManageCategoryPage clickManageCategoryNewButton() {
		manageCategoryNewButton.click();
		return this;
	}

	public ManageCategoryPage enterCategoryField(String newCategory) {
		manageCategoryField.sendKeys(newCategory);
		return this;
	}

	public ManageCategoryPage clickManageCategorySelectGroup() {
		manageCategorySelectGroup.click();
		return this;
	}

	public ManageCategoryPage clickManageCategoryImageChooseFile() throws AWTException {
		// manageCategoryImageChooseFile.click();
		FileUploadUtility fileuploadutility = new FileUploadUtility();
		// fileuploadutility.fileuploadUsingRobertClass(manageCategoryImageChooseFile,Constants.GROCERYIMAGE);
		fileuploadutility.fileUploadUsingSendKeys(manageCategoryImageChooseFile, Constants.GROCERYIMAGE);
		return this;
	}

	public boolean isTopMenuYesRadioButtonDisplayed() {
		return manageCategoryTopMenuYesRadioButton.isDisplayed();

	}

	public ManageCategoryPage clickTopMenuYesRadioButton() {
		// manageCategoryTopMenuYesRadioButton.click();
		PageUtility pageutility = new PageUtility();
		pageutility.javaScriptClick(driver, manageCategoryTopMenuYesRadioButton);
		return this;
	}

	public boolean isTopMenuYesRadioButtonEnabled() {
		return manageCategoryTopMenuYesRadioButton.isEnabled();
	}

	public boolean isLeftMenuYesRadioButtonDisplayed() {
		return manageCategoryLeftMenuYesRadioButton.isDisplayed();

	}

	public ManageCategoryPage clickLeftMenuYesRadioButton() {
		// manageCategoryLeftMenuYesRadioButton.click();
		PageUtility pageutility = new PageUtility();
		pageutility.javaScriptClick(driver, manageCategoryLeftMenuYesRadioButton);
		return this;
	}

	public boolean isLeftMenuYesRadioButtonEnabled() {
		return manageCategoryLeftMenuYesRadioButton.isEnabled();
	}

	public ManageCategoryPage clickManageCategorySaveButton() {
		// manageCategorySaveButton.click();
		PageUtility pageutility = new PageUtility();
		pageutility.javaScriptClick(driver, manageCategorySaveButton);
		return this;

	}

	public boolean isManageCategoryAlertDisplayed() {
		return manageCategoryAlertDisplayed.isDisplayed();
	}

	// TO SEARCH A CATEGORY
	public ManageCategoryPage clickCategorySearchButton() {
		manageCategorySearchButton.click();
		return this;
	}

	public ManageCategoryPage enterCategoryToSearch(String searchCategory) {
		enterCategoryToSearchField.sendKeys(searchCategory);
		return this;
	}

	public ManageCategoryPage clickEnterCategorySearchButton() {
		enterCategorySearchButton.click();
		return this;
	}

	public boolean isSearchCategoryFound(String searchCategory) {
		boolean flag = false;
		List<WebElement> tableListRow = searchResultList;
		for (WebElement tableR : tableListRow) {
			String tableTextR = tableR.getText();
			if (tableTextR.equals(searchCategory)) {
				flag = true;
			}
		}
		return flag;

	}

}
