package Utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.tools.Tool;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Audio_Video {

	WebDriver driver;
	
	@BeforeClass
	public void login() throws InterruptedException
	{
		/*System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");*/
		driver = new FirefoxDriver();
		/*driver = new ChromeDriver();*/	
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://203.88.147.98:8080/web/guest/welcome");
		driver.findElement(By.id("_58_login")).clear();
		driver.findElement(By.id("_58_login")).sendKeys("test@liferay.com");
		driver.findElement(By.id("_58_password")).sendKeys("test");
		driver.findElement(By.cssSelector(".button-holder .btn-primary")).click();
		Thread.sleep(4000);
        driver.get("http://203.88.147.98:8080/web/guest/photos-videos");
	}
	
	@Test(priority=1)
	public void AddCat() throws InterruptedException
	{
		driver.findElement(By.cssSelector("#myTreeView a img")).click();
		driver.findElement(By.cssSelector(".button-holder .btn-cancel")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#myTreeView a img")).click();
		driver.findElement(By.cssSelector(".button-holder .btn-primary")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("_20_name")).sendKeys("Tes4");
		driver.findElement(By.id("_20_description")).sendKeys("desfdsfs");
		driver.findElement(By.cssSelector(".button-holder .btn-primary")).click();
	}
	
	@Test(priority=2)
	public void addFileCat() throws AWTException, InterruptedException
	{
		List<WebElement> Cat = driver.findElements(By.cssSelector("#myTreeView .tree-view-content .icon-check"));
        Cat.get(Cat.size()-1).click();
		driver.findElement(By.id("addDocumentDiv")).click();
		driver.findElement(By.className("btn-cancel")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.id("addDocumentDiv")).click();
		driver.findElement(By.id("_20_publishButton")).click();
		Thread.sleep(3000);
		//Upload an image
		driver.findElement(By.id("_20_file")).click();
		StringSelection stringSelection = new StringSelection("C:\\Users\\attune60\\Downloads\\img\\test.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		 
		//imitate mouse events like ENTER, CTRL+C, CTRL+V
	    Robot robot = new Robot();
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    Thread.sleep(3000);
	    driver.findElement(By.id("_20_title")).sendKeys("Test2");
	    driver.findElement(By.id("_20_publishButton")).click();
	}
	
	@Test(priority=3)
	public void AddSubCat() throws InterruptedException
	{
		List<WebElement> plus = driver.findElements(By.cssSelector("#myTreeView .tree-view-content .icon-check"));
		plus.get(plus.size()-1).click();
		List<WebElement> Cat1 = driver.findElements(By.cssSelector("#myTreeView .tree-view-content .icon-check"));
        Cat1.get(Cat1.size()-1).click();
		driver.findElement(By.cssSelector("#myTreeView a img")).click();
		driver.findElement(By.cssSelector(".button-holder .btn-primary")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("_20_name")).sendKeys("Tes41");
		driver.findElement(By.id("_20_description")).sendKeys("desfdsfs");
		driver.findElement(By.cssSelector(".button-holder .btn-primary")).click();
	}
	
	
	
	@Test(priority=4)
	public void addFileSubCat() throws AWTException, InterruptedException
	{
		List<WebElement> plus = driver.findElements(By.cssSelector("#myTreeView .tree-view-content .icon-plus"));
		Thread.sleep(3000);
		List<WebElement> Cat = driver.findElements(By.cssSelector("#myTreeView .tree-view-content .icon-check"));
		plus.get(plus.size()-2).click();
		Cat.get(Cat.size()-1).click();
		driver.findElement(By.id("addDocumentDiv")).click();
		driver.findElement(By.className("btn-cancel")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("addDocumentDiv")).click();
		driver.findElement(By.id("_20_publishButton")).click();
		Thread.sleep(3000);
		//Upload an image
		driver.findElement(By.id("_20_file")).click();
		StringSelection stringSelection = new StringSelection("C:\\Users\\attune60\\Downloads\\img\\test.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		 
		//imitate mouse events like ENTER, CTRL+C, CTRL+V
	    Robot robot = new Robot();
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    Thread.sleep(3000);
	    driver.findElement(By.id("_20_title")).sendKeys("Test2");
	    driver.findElement(By.id("_20_publishButton")).click();
	}
	
	
}
