package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility
{
	public void selectDropDrownUsingSelectByVisibleText(WebElement dropdown,String VisibleText)
	{
		Select select=new Select(dropdown);
		select.selectByVisibleText(VisibleText);
	}
	
	public void selectDropDownUsingSelectByIndexValue(WebElement dropdown,int index)
	{
		Select select=new Select(dropdown);
		select.selectByIndex(index);
	}
	
	public void selectCategoryUsingSelectByValue(WebElement dropdown, String Value) 
	{
		Select select = new Select(dropdown);
		select.selectByValue(Value);
	}
		
	public void actionsMouseHover(WebDriver  driver, WebElement element)
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(element).build().perform();
	}
	
	public void actionsDoubleClick(WebDriver  driver, WebElement element)
	{
		Actions actions=new Actions(driver);
		actions.doubleClick(element).build().perform();
	}
	
	public void actionsRightClick(WebDriver  driver, WebElement element)
	{
		Actions actions=new Actions(driver);
		actions.contextClick(element).build().perform();
	}
	
	public void actionDragAndDrop(WebDriver driver,WebElement sourceElement,WebElement destinationElement)
    
    {
  	  Actions actions=new Actions(driver);
  	  actions.dragAndDrop(sourceElement, destinationElement).build().perform();
    }

	public String getTextAlert(WebDriver driver)
    {
  	 String alertText=driver.switchTo().alert().getText();
	 return alertText; 
    }
		
	public void javaScriptClick(WebDriver  driver,WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",element);
	}
	
	
	
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	public void enterTextIntoAlert(WebDriver driver, String element)
	{
		driver.switchTo().alert().sendKeys(element);
	
	}

}
