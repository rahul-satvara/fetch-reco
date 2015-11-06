package Social_Collaboration;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test
public class Activity {

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
		driver.findElement(By.cssSelector(".button-holder .btn-primary")).click();
	}
	
	/*@Test
	public void sharePost() throws InterruptedException, AWTException
	{
		 Thread.sleep(1000);
		 driver.get("http://203.88.147.98:8080/web/guest/social-colaboration");
		 driver.findElement(By.id("textfile")).click();
		 driver.switchTo().activeElement().sendKeys("C:\\Users\\attune60\\Downloads\\img\\test.png");
		 Robot robot = new Robot();
		 robot.keyPress(KeyEvent.VK_ENTER);
		 driver.findElement(By.className("sharetextarea")).sendKeys("How are you?");
		 driver.findElement(By.className("ShareActivity")).click();
		 driver.findElement(By.cssSelector("#like img")).click();
		 driver.findElement(By.className("CommentSub")).click();
		 driver.findElement(By.className("commentArea")).sendKeys("hello");
		 driver.findElement(By.className("CommentSub")).click();
		 driver.findElement(By.id("_activity_stream_WAR_MissionControlportlet_mydeletebitton_199806")).click();
		 driver.switchTo().frame(0);
		 driver.findElement(By.cssSelector(".form .btn.btn-primary")).click();
	}*/	
	
	@AfterTest
	public void logout() throws InterruptedException
	{
        driver.findElement(By.className("user-avatar-link")).click();
	    driver.findElement(By.className("sign-out ")).click();
	    Thread.sleep(3000);
	}
	
	
}
