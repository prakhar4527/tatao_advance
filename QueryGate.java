package qainfotech.tatoc_advance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class QueryGate
{
	WebDriver driver;
	/*private static Logger log = (Logger) LogFactory
		       .getLog(QueryGate.class);*/
	public QueryGate(WebDriver driver)
	{
		this.driver=driver;
	}
	public void databaseQuery() throws ClassNotFoundException, SQLException
	{
		String hostUrl="jdbc:mysql://10.0.1.86/tatoc";
		String userName="tatocuser";
		String password="tatoc01";
		// Setup the connection with the DB
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(hostUrl,userName,password);
		java.sql.Statement stmt = conn.createStatement();
		WebElement symbol=driver.findElement(By.id("symboldisplay"));
		WebElement sendName=driver.findElement(By.id("name"));
		WebElement sendPass=driver.findElement(By.id("passkey"));
		WebElement proceed=driver.findElement(By.id("submit"));
		String symTxt=symbol.getText();
		// System.out.println(symTxt);
		String query="SELECT identity.id,credentials.id,name,passkey,symbol FROM identity INNER JOIN credentials ON identity.id=credentials.id";
		ResultSet rs = stmt.executeQuery(query);
		//System.out.println(rs.getString("name")+" "+rs.getString("passkey"));
		while (rs.next()) 
		{
			String sym= rs.getString("symbol");
			// System.out.println(symTxt);
			//int f=0;
			String  name = rs.getString("name");
			String pass= rs.getString("passkey");
			//System.out.println("   "+name+"    "+pass);
			if(sym.equalsIgnoreCase(symTxt))
			{
				//f=1;
				// System.out.println("   "+name+"    "+pass);
				sendName.sendKeys(name);
				sendPass.sendKeys(pass);
				proceed.click();
			}
			// System.out.println(f);
			//int i=rs.getInt("id");  
		}
		String url="http://10.0.1.86/tatoc/advanced/video/player";
		Assert.assertEquals(url, driver.getCurrentUrl());

	}
}

