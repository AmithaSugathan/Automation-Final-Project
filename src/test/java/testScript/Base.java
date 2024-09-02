package testScript;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constants;
import utilities.ScreenShotUtility;

public class Base {

	public WebDriver driver;
	public Properties properties;
	
	FileInputStream fileinputstream;
	ScreenShotUtility screenshotutility;
	
	@BeforeMethod(alwaysRun=true)	
	@Parameters("browser")
	
	public void initializeBrowser(String browser) throws Exception
	{
		try {
			properties=new Properties();
			fileinputstream=new FileInputStream(Constants.CONFIGFILE);
			properties.load(fileinputstream);
			}
		
		catch(Exception e)
			{
		e.printStackTrace();
			}
			
		if(browser.equalsIgnoreCase("Chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Edge"))
		{
			driver=new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("Firefox"))
		{
		driver=new FirefoxDriver();
		}
		else
		{
			throw new Exception("Not a Valid browser");
		}
		
		//driver.get("https://groceryapp.uniqassosiates.com/admin");
		driver.get(properties.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//Global:Applicable for the entire framework
		driver.manage().window().maximize();
	}
	
	@AfterMethod(alwaysRun=true)
	public void browserQuit(ITestResult iTestResult) throws IOException
	{
		if(iTestResult.getStatus()==ITestResult.FAILURE)
		{
			screenshotutility=new ScreenShotUtility();
			screenshotutility.getScreenShot(driver,iTestResult.getName());//Pass failed testname and driver to getScreenShot()
		}
		driver.quit();
	}
	
	
}
