package Personal;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class directory_chrome {

	WebDriver driver;
	
	@BeforeTest
	public void login() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://162.144.102.19:9090/");
		driver.findElement(By.id("_58_login")).clear();
		driver.findElement(By.id("_58_login")).sendKeys("admin@liferay.com");
		driver.findElement(By.id("_58_password")).sendKeys("admin@123");
		driver.findElement(By.cssSelector(".button-holder .btn-primary")).click();
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.cssSelector("#layout_4 a img"))).build().perform();
		driver.findElement(By.cssSelector("#layout_4 a img")).click();
		driver.findElement(By.xpath("//div/nav/ul/li/a")).sendKeys(Keys.ENTER);
	}
	
	@Test(priority=1)
	public void AddDirectory() throws InterruptedException
	{
		
		driver.findElement(By.linkText("Add/Manage")).click();
		driver.findElement(By.cssSelector(".directorysavebutton .btn-primary")).click();
		driver.findElement(By.id("_Directory_WAR_MissionControlportlet_userName")).sendKeys("xyz");
		driver.findElement(By.id("_Directory_WAR_MissionControlportlet_phoneNumber")).sendKeys("");
		driver.findElement(By.id("_Directory_WAR_MissionControlportlet_address")).sendKeys("abc");
		driver.findElement(By.id("_Directory_WAR_MissionControlportlet_privacyCheckbox")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".directorysavebutton .btn-primary")).click();
		driver.findElement(By.id("_Directory_WAR_MissionControlportlet_phoneNumber")).sendKeys("123454ewr1");
		driver.findElement(By.cssSelector(".directorysavebutton .btn-primary")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("_Directory_WAR_MissionControlportlet_phoneNumber")).clear();
		driver.findElement(By.id("_Directory_WAR_MissionControlportlet_phoneNumber")).sendKeys("1234567891");
		driver.findElement(By.cssSelector(".directorysavebutton .btn-primary")).click();
	}
	
	@Test(priority=1)
	public void EditDirectory()
	{
		driver.findElement(By.linkText(" Edit")).click();
		driver.findElement(By.id("cbox")).click();
		driver.findElement(By.linkText(" Edit")).click();
		driver.findElement(By.id("_Directory_WAR_MissionControlportlet_userName")).clear();
		driver.findElement(By.id("_Directory_WAR_MissionControlportlet_userName")).sendKeys("xyz1");
		driver.findElement(By.id("_Directory_WAR_MissionControlportlet_phoneNumber")).clear();
		driver.findElement(By.id("_Directory_WAR_MissionControlportlet_address")).clear();
		driver.findElement(By.id("_Directory_WAR_MissionControlportlet_address")).sendKeys("abc1");
		driver.findElement(By.cssSelector(".directorysavebutton .btn-primary")).click();
		driver.findElement(By.id("_Directory_WAR_MissionControlportlet_privacyCheckbox")).click();
		driver.findElement(By.id("_Directory_WAR_MissionControlportlet_phoneNumber")).sendKeys("9898989898");
		driver.findElement(By.cssSelector(".directorysavebutton .btn-primary")).click();
	}
	
	@Test(priority=3)
	public void searchNameDirectory() throws InterruptedException
	{
		driver.findElement(By.linkText("T")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("searchBk")).sendKeys("st");
		Thread.sleep(2000);
		Select sel = new Select(driver.findElement(By.id("_Directory_WAR_MissionControlportlet_TestSelect")));
		sel.selectByIndex(2);
		Thread.sleep(2000);
		driver.findElement(By.linkText("All")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("ion-grid")).click();
		driver.findElement(By.id("searchBk")).sendKeys("st");
		Thread.sleep(3000);
		Select sel1 = new Select(driver.findElement(By.id("_Directory_WAR_MissionControlportlet_TestSelect")));
		sel1.selectByIndex(1);
		Thread.sleep(2000);		
		driver.findElement(By.className("ion-grid")).click();
		driver.findElement(By.linkText("T")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("ion-grid")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("All")).click();
	}
	
	@Test(priority=4)
	public void deleteDirectory() throws InterruptedException
	{
		driver.findElement(By.linkText(" Delete")).click();
		driver.findElement(By.id("cbox")).click();
		driver.findElement(By.linkText(" Delete")).click();
		driver.switchTo().frame(0);
        driver.findElement(By.xpath("//input[@value='Ok']")).click();
        Thread.sleep(3000);
        driver.close();
	}
}
