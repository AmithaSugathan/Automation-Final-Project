package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {

	WebDriver driver;
	public ManageNewsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@name='username']")private WebElement usernameField;
	@FindBy(xpath="//input[@name='password']")private WebElement passwordField;
	@FindBy(xpath="//button[@type='submit']")private WebElement siginButton;
	
	@FindBy(xpath="//a[contains(@href,'list-news') and @class='small-box-footer']")private WebElement manageNewsMoreInfo;	
	@FindBy(xpath="//a[@onclick='click_button(1)']")private WebElement clickNewsButton;
	@FindBy(xpath="//textarea[@id='news']")private WebElement enterNewsField;	
	@FindBy(xpath="//button[@class='btn btn-danger']")private WebElement manageNewsSaveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement newsCreated;
	
	
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
	
	
	public void clickManageNewsMoreInfo()
	{
		manageNewsMoreInfo.click();
	}
	
	public void clickManageNewsButton()
	{
		clickNewsButton.click();
	}
	
	public void enterNews(String news)
	{
		clickNewsButton.sendKeys(news);
	}
	
	public void clickNewsSaveButton()
	{
		manageNewsSaveButton.click();
	}
	
	public boolean isNewsCreated()
	{
		return newsCreated.isDisplayed();
	}
	
	
	
}
