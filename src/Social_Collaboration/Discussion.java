package Social_Collaboration;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Discussion {

	WebDriver driver;
	@BeforeClass
	public void login() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		/*driver = new FirefoxDriver();*/
		driver = new ChromeDriver();
		driver.navigate();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://203.88.147.98:8080/web/guest/welcome");
		driver.findElement(By.id("_58_login")).clear();
		driver.findElement(By.id("_58_login")).sendKeys("user3@liferay.com");
		driver.findElement(By.id("_58_password")).sendKeys("123123");
		driver.findElement(By.cssSelector(".button-holder .btn-primary")).click();		
        driver.get("http://203.88.147.98:8080/web/guest/discussion");
	}
	
	@Test(priority=1)
	public void addNewThread()
	{
	   	List<WebElement> Cat = driver.findElements(By.cssSelector("#myTreeView .tree-view-content .icon-check"));
	   	Cat.get(Cat.size()-2).click();
	   	driver.findElement(By.id("newThread")).click();
	   	driver.findElement(By.className("btn-cancel")).sendKeys(Keys.ENTER);
	   	driver.findElement(By.id("newThread")).click();
	   	driver.findElement(By.id("_19_publishButton")).click();
	   	driver.findElement(By.id("_19_subject")).sendKeys("test");
	   	driver.findElement(By.id("_19_publishButton")).click();
	   	driver.findElement(By.linkText("Edit")).click();
	   	driver.findElement(By.id("_19_subject")).clear();
	   	driver.findElement(By.id("_19_subject")).sendKeys("test1");
	   	driver.findElement(By.id("_19_saveButton")).click();
	   	driver.get("http://203.88.147.98:8080/web/guest/discussion");
	   	driver.findElement(By.id("myposts")).click();
	   	/*driver.findElement(By.id("_19_publishButton")).click();*/
	   	/*driver.findElement(By.linkText("Move to the Recycle Bin")).click();*/
	}
	
	@Test(priority=2)
	public void PublishPost()
	{
		driver.findElement(By.id("_58_login")).clear();
		driver.findElement(By.id("_58_login")).sendKeys("user3@liferay.com");
		driver.findElement(By.id("_58_password")).sendKeys("123123");
		driver.findElement(By.cssSelector(".button-holder .btn-primary")).click();		
        driver.get("http://203.88.147.98:8080/web/guest/discussion");
        driver.findElement(By.id("myposts")).click();
        driver.findElement(By.id("messageSubject")).click();
        driver.findElement(By.linkText("Edit")).click();
        driver.findElement(By.id("_19_publishButton")).click();   
	}
	
	@AfterMethod
	public void logout() throws InterruptedException
	{
	    driver.findElement(By.className("user-avatar-link")).click();
	    driver.findElement(By.className("sign-out ")).click();
	    driver.findElement(By.id("_58_login")).clear();
		driver.findElement(By.id("_58_login")).sendKeys("test@liferay.com");
		driver.findElement(By.id("_58_password")).sendKeys("test");
		driver.findElement(By.cssSelector(".button-holder .btn-primary")).click();		
        driver.get("http://203.88.147.98:8080/web/guest/discussion");
        driver.findElement(By.id("myposts")).click();
        driver.get("http://203.88.147.98:8080/web/guest/documents");
        driver.findElement(By.className("user-avatar-link")).click();
	    driver.findElement(By.className("sign-out ")).click();
	    Thread.sleep(3000);
	}
}
