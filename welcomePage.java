package qainfotech.tatoc_advance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import junit.framework.Assert;

public class welcomePage
{
	WebDriver driver;
	public welcomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void WelcomePage()
	{
		Assert.assertEquals("Welcome - T.A.T.O.C", driver.getTitle());
		
	}
	public hoverMenu ToHoverPage()
	{
		driver.findElement(By.linkText("Advanced Course")).click();
		return new hoverMenu(driver);
	}
	
}
