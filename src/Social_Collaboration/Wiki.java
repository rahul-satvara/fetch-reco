package Social_Collaboration;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Wiki {

	WebDriver driver;
	
	@BeforeTest
	public void login()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		/*driver = new FirefoxDriver();*/
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://203.88.147.98:8080/");
		driver.findElement(By.id("_58_login")).clear();
		driver.findElement(By.id("_58_login")).sendKeys("test@liferay.com");
		driver.findElement(By.id("_58_password")).sendKeys("test");
		driver.findElement(By.cssSelector(".button-holder .btn-primary")).sendKeys(Keys.ENTER);
	}
	
	@Test(priority=1)
	public void AddWiki() throws InterruptedException
	{
		driver.get("http://203.88.147.98:8080/web/guest/social-colaboration");	
		List<WebElement> group = driver.findElements(By.cssSelector(".Userpanel a"));
		group.get(group.size()-1).click();
		driver.findElement(By.cssSelector("#wikiDiv a img")).click();
		driver.findElement(By.id("checkList1")).click();
		driver.findElement(By.cssSelector(".cancelbtn .btn")).click();
		driver.findElement(By.id("checkList1")).click();
		driver.findElement(By.id("_activity_stream_WAR_MissionControlportlet_CategoryName")).sendKeys("Test1");
	    driver.findElement(By.className("btn-primary")).click();
	    List<WebElement> Cat = driver.findElements(By.className("icon-check"));
	    Cat.get(Cat.size()-2).click();
	}
	
	@Test(priority=2)
	public void addPage()
	{
		driver.findElement(By.linkText("AddPage")).click();
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		driver.findElement(By.id("_activity_stream_WAR_MissionControlportlet_Wiki-Name")).sendKeys("AbcAbc");
		driver.findElement(By.id("cke_8_label")).click();
		driver.findElement(By.xpath("//div[@id='cke_1_contents']/textarea")).sendKeys("abc21");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
	}
	
	@Test(priority=3)
	public void editPage()
	{
		driver.findElement(By.linkText("Editlink")).click();
		driver.findElement(By.id("_activity_stream_WAR_MissionControlportlet_Wiki-Name")).clear();
		driver.findElement(By.id("_activity_stream_WAR_MissionControlportlet_Wiki-Name")).sendKeys("");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		
		if(isElementPresent(By.xpath("//input[@value='Submit']")))
		{
		   driver.findElement(By.id("cke_8_label")).click();
		   driver.findElement(By.xpath("//div[@id='cke_1_contents']/textarea")).sendKeys("abc1");
		   driver.findElement(By.xpath("//input[@value='Submit']")).click();
	    }
		else
		{
		   System.out.println("Validation Required");	
		}
		
		driver.findElement(By.id("deleteLink")).click();
		
    }

	private boolean isElementPresent(By xpath)
	{
		return false;
	}
}	
