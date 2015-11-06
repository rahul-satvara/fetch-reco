package Meeting;	

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.webdriven.commands.Click;

public class Mistake {

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
	
	@BeforeMethod
	public void checkFolder() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.get("http://203.88.147.98:8080/web/guest/mistake");
		List<WebElement> Cat = driver.findElements(By.cssSelector("#myTreeView .tree-view-content .icon-check"));
        Cat.get(Cat.size()-1).click();
	}
	
	@Test(priority=1)
	public void createMistake()
	{
		driver.findElement(By.className("createmistake")).click();
		driver.switchTo().frame(0); 
		driver.findElement(By.id("_mistake_WAR_MissionControlportlet_myDate")).sendKeys("");
		driver.findElement(By.linkText("16")).click();
		driver.findElement(By.id("_mistake_WAR_MissionControlportlet_subcontact")).click();
		driver.switchTo().frame(0);
		driver.findElement(By.linkText("Page 1 of 1,396")).click();
		driver.findElement(By.linkText("14")).click();
		driver.findElement(By.className("max-display-items-15")).click();
		driver.findElement(By.linkText("32")).click();
		driver.findElement(By.id("341")).click();
		driver.findElement(By.id("343")).click();
		driver.findElement(By.id("checkClass")).click();
		driver.switchTo().frame(0);
		driver.findElement(By.id("_mistake_WAR_MissionControlportlet_whathappend")).sendKeys("nothing");
		driver.findElement(By.id("_mistake_WAR_MissionControlportlet_decissiontaken")).sendKeys("good");
		driver.findElement(By.className("btn-primary")).click();
		//driver.switchTo().window(parentWindowHandler);  // switch back to parent window
	}
	
	@Test(priority=2)
	public void editMistake()
	{
		driver.findElement(By.className("searchcheck")).click();
		driver.findElement(By.id("editmistake")).click();
		driver.switchTo().frame(0);
		driver.findElement(By.id("_mistake_WAR_MissionControlportlet_myDate")).sendKeys("");
		driver.findElement(By.linkText("19")).click();
		driver.findElement(By.id("_mistake_WAR_MissionControlportlet_whathappend")).clear();
		driver.findElement(By.id("_mistake_WAR_MissionControlportlet_whathappend")).sendKeys("anything");
		driver.findElement(By.id("_mistake_WAR_MissionControlportlet_decissiontaken")).clear();
		driver.findElement(By.id("_mistake_WAR_MissionControlportlet_decissiontaken")).sendKeys("bad");
		driver.findElement(By.className("btn-primary")).click();
	}
	
	@Test(priority=3)
	public void deleteMistake()
	{
		driver.findElement(By.className("searchcheck")).click();
		driver.findElement(By.id("checkClassdelete")).click();
		Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//input[@value='Ok']")).click();
	}

	@Test(priority=4)
	public void editCat()
	{
	    driver.findElement(By.id("editmistakecat")).click();
	    driver.switchTo().frame(0);
	    driver.findElement(By.id("_mistake_WAR_MissionControlportlet_category")).clear();
	    driver.findElement(By.id("_mistake_WAR_MissionControlportlet_category")).sendKeys("Test23");
	    driver.findElement(By.cssSelector(".button-holder .btn-primary")).sendKeys(Keys.ENTER);	 
	}
	
	@Test(priority=5)
	public void deleteCat()
	{
		driver.findElement(By.id("deletecat")).click();
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@value='Ok']")).click();	
	}
	
	
}
