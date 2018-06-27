package qainfotech.tatoc_advance;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest 
{
	WebDriver driver;
	welcomePage page1;
	hoverMenu hm;
	QueryGate qg;
	@BeforeTest
	public void launchBrowser()
	{
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://10.0.1.86/tatoc");
		page1 = new welcomePage(driver);
	}
	@Test
	public void checkWelcomePage()
	{
		page1.WelcomePage();
	}
	@Test(dependsOnMethods = { "checkWelcomePage" })
	public void checkHoverPage()
	{

		hm=page1.ToHoverPage();
		hm.hoverPage();
	}
	@Test(dependsOnMethods = { "checkHoverPage" })
	public void checkQueryGatePage() throws ClassNotFoundException, SQLException 
	{

		qg=hm.afterClickingGoNext();
		qg.databaseQuery();
	}

}