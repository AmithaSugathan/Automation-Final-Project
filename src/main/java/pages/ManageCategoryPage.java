package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageCategoryPage {

	WebDriver driver;

	public ManageCategoryPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@name='username']")private WebElement usernameField;
	@FindBy(xpath="//input[@name='password']")private WebElement passwordField;
	@FindBy(xpath="//button[@type='submit']")private WebElement siginButton;
	
	@FindBy(xpath="//a[contains(@href,'list-product') and @class='small-box-footer']")private WebElement manageCategoryMoreInfo;
	
	//TO SAVE A CATEGORY
	@FindBy(xpath="//a[@onclick='click_button(1)']")private WebElement manageCategoryNewButton;
	@FindBy(xpath="//input[@id='category']")private WebElement manageCategoryField;
	@FindBy(xpath="//li[@id='134-selectable']")private WebElement manageCategorySelectGroup;
	@FindBy(xpath="//input[@id='main_img']")private WebElement manageCategoryImageChooseFile;
		
	//ASK TRAINER 
	@FindBy(xpath="//div/label/input[@name='top_menu' and @value='yes']")private WebElement manageCategoryTopMenuYesRadioButton;
	@FindBy(xpath="//div/label/input[@name='top_menu' and @value='no']")private WebElement manageCategoryTopMenuNoRadioButton;
	@FindBy(xpath="//div/label/input[@name='show_home' and @value='yes']")private WebElement manageCategoryLeftMenuYesRadioButton;
	@FindBy(xpath="//div/label/input[@name='show_home' and @value='no']")private WebElement manageCategoryLeftMenuNoRadioButton;
	
	@FindBy(xpath="//button[contains(@class,'btn btn-danger')]")private WebElement manageCategorySaveButton;
	@FindBy(xpath="//div[contains(@class,'success alert-dismissible')]")private WebElement manageCategoryAlertDisplayed;
	
	//TO SEARCH A CATEGORY
	@FindBy(xpath="//a[@onclick='click_button(2)']")private WebElement manageCategorySearchButton;
	@FindBy(xpath="//input[@placeholder='Category']")private WebElement enterCategoryToSearchField;
	@FindBy(xpath="//button[@name='Search']")private WebElement enterCategorySearchButton;
	@FindBy(xpath="//td[contains(text(),'Electric')]")private List<WebElement> searchResultList;
	
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
	
	public void clickManageCategoryMoreInfo()
	{
		manageCategoryMoreInfo.click();
	}
	
	//TO SAVE A CATEGORY
	
	public void clickManageCategoryNewButton()
	{
		manageCategoryNewButton.click();
	}
	public void enterCategoryField(String newCategory)
	{
		manageCategoryField.sendKeys(newCategory);
	}
	
	public void clickManageCategorySelectGroup()
	{
		manageCategorySelectGroup.click();
	}
	
	public void clickManageCategoryImageChooseFile()
	{
		manageCategoryImageChooseFile.click();
	}

	public boolean isTopMenuYesRadioButtonDisplayed()
	{
		return manageCategoryTopMenuYesRadioButton.isDisplayed();
		
	}
	
	public void clickTopMenuYesRadioButton()
	{
		manageCategoryTopMenuYesRadioButton.click();
	}
	
	public boolean isTopMenuYesRadioButtonEnabled()
	{
	return manageCategoryTopMenuYesRadioButton.isEnabled();
	}
	
	public boolean isLeftMenuYesRadioButtonDisplayed()
	{
		return manageCategoryLeftMenuYesRadioButton.isDisplayed();
		
	}	
	public void clickLeftMenuYesRadioButton()
	{
		manageCategoryLeftMenuYesRadioButton.click();
	}
	
	public boolean isLeftMenuYesRadioButtonEnabled()
	{
	return manageCategoryLeftMenuYesRadioButton.isEnabled();
	}
	
	public void clickManageCategorySaveButton()
	{
		manageCategorySaveButton.click();
	}
	public boolean isManageCategoryAlertDisplayed()
	{
		return manageCategoryAlertDisplayed.isDisplayed();
	}
	
	//TO SEARCH A CATEGORY
	public void clickCategorySearchButton()
	{
		manageCategorySearchButton.click();
	}
	
	public void enterCategoryToSearch(String searchCategory)
	{
		enterCategoryToSearchField.sendKeys(searchCategory);
	}
	
	public void clickEnterCategorySearchButton()
	{
		enterCategorySearchButton.click();
	}
	
	public boolean isSearchCategoryFound(String searchCategory)
	{
		boolean flag=false;
		List <WebElement> tableListRow=searchResultList;
		for(WebElement tableR:tableListRow)
		{
			String tableTextR=tableR.getText();
			if(tableTextR.equals(searchCategory))
			{
			flag=true;
			}
		}
		return flag;
		
	}
	
}

