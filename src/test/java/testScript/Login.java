package testScript;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Login extends Base{

	@Test
	public void login()
	{
		String usernameValue="admin";
		String passwordValue="admin";
		WebElement username=driver.findElement(By.xpath("//input[@name='username']"));
		WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
		username.sendKeys(usernameValue);
		password.sendKeys(passwordValue);
		WebElement sigin=driver.findElement(By.xpath("//button[@type='submit']"));
		sigin.click();
		WebElement dashboard=driver.findElement(By.xpath("//p[text()='Dashboard']"));
		boolean isHomePageAvailable=dashboard.isDisplayed();
		assertTrue(isHomePageAvailable,"Login Unsuccessful");
			
	}

}
