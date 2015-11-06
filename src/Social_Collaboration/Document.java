package Social_Collaboration;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Document {

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
		driver.findElement(By.id("_58_login")).sendKeys("test@liferay.com");
		driver.findElement(By.id("_58_password")).sendKeys("test");
		driver.findElement(By.cssSelector(".button-holder .btn-primary")).click();
		Thread.sleep(4000);
        driver.get("http://203.88.147.98:8080/web/guest/documents");
	}
	
	@Test(priority=1)
	public void addFolder() throws InterruptedException
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
	public void addDoc() throws InterruptedException, AWTException
	{
		List<WebElement> Cat = driver.findElements(By.cssSelector("#myTreeView .tree-view-content .icon-check"));
		Cat.get(Cat.size()-1).click();
		
		driver.findElement(By.id("addDocumentDiv")).click();
		driver.findElement(By.cssSelector(".button-holder .btn-cancel")).click();
        
		driver.findElement(By.id("addDocumentDiv")).click();
		driver.findElement(By.cssSelector(".button-holder .btn-primary")).click();
		
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
	    
	    driver.findElement(By.id("_20_title")).sendKeys("Test2");
	    driver.findElement(By.cssSelector(".button-holder .btn-primary")).click();
	}
	
	@Test(priority=3)
	public void checkDoc()
	{
		/*driver.findElement(By.id("checkoutDoc")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		driver.findElement(By.id("downloadLink")).click();
		alert.accept();
		driver.findElement(By.id("Delete")).click();
		alert.accept();*/
		driver.findElement(By.name("selectdocCheckBox")).click();
		driver.findElement(By.id("downloadLink")).click();
		driver.findElement(By.id("checkoutDoc")).click();
		driver.findElement(By.name("selectdocCheckBox")).click();
		driver.findElement(By.id("checkinDoc")).click();	
	}
}
