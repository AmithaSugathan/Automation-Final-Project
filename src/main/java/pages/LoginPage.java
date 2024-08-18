package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage { 
	
	WebDriver driver;
	public LoginPage(WebDriver driver)//Constructor
	{
		this.driver=driver;//instance driver=local driver
		PageFactory.initElements(driver,this);//initElements:a static method to use @FindBy, so With Page Factory
	}
	
	
	@FindBy(xpath="//input[@name='username']")private WebElement usernameField;//locate elements with Page Factory
	@FindBy(xpath="//input[@name='password']")private WebElement passwordField;
	@FindBy(xpath="//button[@type='submit']")private WebElement siginButton;
	@FindBy(xpath="//p[text()='Dashboard']")private WebElement dashboard;
	
	
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
	
	public boolean isDasboardLoadedSuccessfully()
	{
		return dashboard.isDisplayed();//Return TRUE if dashboard is displayed
	}

}
