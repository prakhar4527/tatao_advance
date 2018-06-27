package qainfotech.tatoc_advance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import junit.framework.Assert;

public class hoverMenu 
{
	WebDriver driver;
	public hoverMenu(WebDriver driver)
	{
		this.driver=driver;
	}
	public void hoverPage()
	{
		Assert.assertEquals("Hover Menu - Advanced Course - T.A.T.O.C", driver.getTitle());
	}
	public void menu2Hover()
	{
		WebElement web_Element_To_Be_Hovered = driver.findElement(By.className("menutitle"));
		Actions builder = new Actions(driver);
		builder.moveToElement(web_Element_To_Be_Hovered).build().perform();
	}
	public void goNextClick()
	{
		driver.findElement(By.xpath("//*[text()[contains(.,'Go Next')]]")).click();
	}
	public QueryGate afterClickingGoNext()
	{
		menu2Hover();
		goNextClick();
		Assert.assertEquals("Query Gate - Advanced Course - T.A.T.O.C", driver.getTitle());
		return new QueryGate(driver);
	}
}

