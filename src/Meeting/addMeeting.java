package Meeting;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class addMeeting {
	
	WebDriver driver;
	
	@BeforeTest
	public void login() throws InterruptedException
	{
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://192.168.15.116:8080/");
		/*Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.cssSelector("#layout_3 a img"))).moveToElement(driver.findElement(By.cssSelector("#layout_3 a img"))).click().build().perform();*/
		driver.findElement(By.cssSelector(".aui .dockbar.navbar .nav li a")).click();
		driver.findElement(By.id("_58_login")).clear();
		driver.findElement(By.id("_58_login")).sendKeys("test@liferay.com");
		driver.findElement(By.id("_58_password")).sendKeys("test");
		driver.findElement(By.cssSelector(".button-holder  .btn-primary")).click();
		Thread.sleep(4000);
		driver.get("http://192.168.15.116:8080/web/mission-control/meeting");
	}
	
	@Test
	public void addMeetingTest() throws InterruptedException
	{	
		driver.findElement(By.xpath("//input[@value='Create New Meeting']")).click();
		/*Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("_meeting_WAR_MissionControlportlet_Date"))).doubleClick().perform();*/
		driver.switchTo().frame(0);
		driver.findElement(By.id("checkClass")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("_meeting_WAR_MissionControlportlet_meetingObjective")).sendKeys("Test");
		driver.findElement(By.id("_meeting_WAR_MissionControlportlet_meetingName")).sendKeys("Test");
		driver.findElement(By.id("_meeting_WAR_MissionControlportlet_department")).sendKeys("Test");
		driver.findElement(By.id("_meeting_WAR_MissionControlportlet_Date")).sendKeys("");
		driver.findElement(By.linkText("6")).click();
		Select sel= new Select(driver.findElement(By.id("_meeting_WAR_MissionControlportlet_subproject")));
		driver.findElement(By.id("_meeting_WAR_MissionControlportlet_subproject")).click();
        driver.switchTo().frame(0);
        driver.findElement(By.id("28")).click();
        driver.findElement(By.id("32")).click();
        driver.findElement(By.id("checkClass")).click();
        driver.findElement(By.id("_meeting_WAR_MissionControlportlet_subcontact")).click();
        driver.switchTo().frame(0);
        driver.findElement(By.id("2")).click();
        driver.findElement(By.id("6")).click();
        driver.findElement(By.id("checkClass")).click();
		//driver.switchTo().window(parentWindowHandler);  // switch back to parent window
	}

}
