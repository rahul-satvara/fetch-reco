package Social_Collaboration;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Member {

	WebDriver driver;
	boolean admin=true;
	
	@BeforeTest
	public void openBrowser()
	{
		/*System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");*/
		driver = new FirefoxDriver();
		/*driver = new ChromeDriver();*/
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void login()
	{
		driver.get("http://203.88.147.98:8080/");
		driver.findElement(By.id("_58_login")).clear();
		if(admin){
			driver.findElement(By.id("_58_login")).sendKeys("test@liferay.com");
			driver.findElement(By.id("_58_password")).sendKeys("test");
			admin = false;
		}else{
			driver.findElement(By.id("_58_login")).sendKeys("user1@liferay.com");
			driver.findElement(By.id("_58_password")).sendKeys("123123");
			admin = true;
		}
		
		driver.findElement(By.cssSelector(".button-holder .btn-primary")).click();
		
	}
	
	@Test(priority=1)
	public void sendMemberRequest() throws InterruptedException
	{
		Thread.sleep(4000);
		driver.get("http://203.88.147.98:8080/web/guest/social-colaboration");
		List<WebElement> group = driver.findElements(By.cssSelector(".Userpanel a"));
		group.get(group.size()-1).click();
		driver.findElement(By.id("memberLink")).click();
		Actions action = new Actions(driver);
		/*driver.findElement(By.linkText("M")).click();*/
		driver.findElements(By.cssSelector(".invitaReqe .btn")).get(1).click();
	}
	
	@Test(priority=2)
	public void AcceptMemberRequest() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.get("http://203.88.147.98:8080/web/guest/social-colaboration");
		driver.findElement(By.id("_2_WAR_notificationsportlet_userNotificationsCount")).click();
		driver.findElement(By.linkText("GroupLink")).click();
		driver.findElement(By.id("Confirm")).click();
	}
	
	
	@AfterMethod
	public void logout() throws InterruptedException
	{
        driver.findElement(By.className("user-avatar-link")).click();
	    driver.findElement(By.className("sign-out ")).click();
	    Thread.sleep(3000);
	}
}
