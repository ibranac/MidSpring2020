package crmTest1;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {
	WebDriver driver;
@Before
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\admin\\eclipse-workspace\\Spring2020\\crm\\Driver\\chromedriver.exe");
		// System.setProperty("webdriver.chrome.driver","./Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.techfios.com/ibilling/?ng=admin/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		}
@Test
public  void loginTest() throws Exception  {
	driver.get("http://www.techfios.com/ibilling/?ng=admin/");
	
	driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
	driver.findElement(By.id("password")).sendKeys("abc123");
	driver.findElement(By.name("login")).click();
	Thread.sleep(2000);
	WebElement DASHBOARD = driver.findElement(By.xpath("//h2[contains(text(),' Dashboard' )]"));
	WebDriverWait wait = new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.visibilityOf(DASHBOARD));
}
@After
public  void tearDown() {
	driver.close();
}
}