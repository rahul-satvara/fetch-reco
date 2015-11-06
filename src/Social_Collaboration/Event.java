package Social_Collaboration;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Event {

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
	
	
	@Test
	public void addEvent()
	{
		driver.get("http://203.88.147.98:8080/web/guest/social-colaboration");
		List<WebElement> group = driver.findElements(By.cssSelector(".Userpanel a"));
		group.get(group.size()-1).click();
		driver.findElement(By.id("EventDiv")).click();
		//Double click
		driver.findElement(By.cssSelector(".calendar-add-event-btn")).click();
		driver.switchTo().frame(driver.findElement(By.className("dialog-iframe-node ")));
		driver.findElement(By.id("_1_WAR_calendarportlet_title")).sendKeys("Event-2015");
		driver.findElement(By.id("_1_WAR_calendarportlet_allDayCheckbox")).click();
		driver.findElement(By.className("btn-primary")).click();
		driver.switchTo().defaultContent();
		driver.get("http://203.88.147.98:8080/web/guest/social-colaboration");
		List<WebElement> group1 = driver.findElements(By.cssSelector(".Userpanel a"));
		group1.get(group1.size()-1).click();
		driver.findElement(By.id("EventDiv")).click();
		driver.findElement(By.className("scheduler-view-table-more")).click();
		driver.findElement(By.linkText("Close")).click();
	}
    	
}

