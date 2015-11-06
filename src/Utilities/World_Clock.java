package Utilities;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class World_Clock {

	WebDriver driver;
	
	@BeforeTest
	public void login()
	{
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://203.88.147.98:8080/");
		driver.findElement(By.id("_58_login")).clear();
		driver.findElement(By.id("_58_login")).sendKeys("test@liferay.com");
		driver.findElement(By.id("_58_password")).sendKeys("test");
		driver.findElement(By.cssSelector(".button-holder .btn-primary")).click();
	}
	
	@Test
	public void setTimeZone() throws InterruptedException
	{
		driver.get("http://203.88.147.98:8080/web/guest/world-clock");
		Select sel = new Select(driver.findElement(By.id("_WorldClock_WAR_MissionControlportlet_idd")));
		sel.selectByIndex(2);
		Thread.sleep(3000);
		sel.selectByIndex(4);
		Thread.sleep(3000);
		sel.selectByIndex(0);
	}
	
}
