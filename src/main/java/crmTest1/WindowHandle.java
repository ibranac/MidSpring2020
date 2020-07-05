package crmTest1;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {
	WebDriver driver;

	@Before
	public void launchBrowser() {
		
		System.setProperty("webdriver.chrome.driver","./Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}
		@Test
		public void PracticeWindowHandle() throws Exception {
			System.out.println(driver.getTitle());
			System.out.println(driver.getWindowHandle());
			driver.get("http://www.yahoo.com/");
			driver.findElement(By.xpath("//input[@id=\'header-search-input\']")).sendKeys("xpath");
			driver.findElement(By.xpath("//button[@id='header-desktop-search-button']")).click();
			driver.findElement(By.linkText("XPath Tutorial - W3Schools")).click();
			for(String i: driver.getWindowHandles()) {
				System.out.println(i);
				driver.switchTo().window(i);
				//driver.findElement(By.linkText("CSS")).click();
			}
			
			Thread.sleep(3000);
			
			
			
		}
		@After
		public void teardown() {
			driver.close();

		}

}
