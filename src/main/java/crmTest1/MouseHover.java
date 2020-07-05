package crmTest1;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {
WebDriver driver;

		@Before
		public void launchBrowser() {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\admin\\eclipse-workspace\\Spring2020\\crm\\Driver\\chromedriver.exe");
			// System.setProperty("webdriver.chrome.driver","./Driver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
			@Test
			public void PracticeMouseHover() throws Exception {
			driver.get("https://www.dell.com/en-us");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://www.dell.com/en-us/shop");
			WebElement PRODUCT_LOCATOR = driver.findElement(By.xpath("//*[@id=\"navigation\"]/ul/li[1]/a/span"));
			Thread.sleep(3000);

			WebElement MONITOR_LOCATOR = driver.findElement(By.xpath("//*[@id=\"navigation\"]/ul/li[1]/ul/li[7]/a/span"));
			WebElement GAMING_MONITOR = driver.findElement(By.xpath("//*[@id=\"navigation\"]/ul/li[1]/ul/li[7]/ul/li[4]/a/span"));
			Actions action = new Actions(driver);
			action.moveToElement(PRODUCT_LOCATOR).build().perform();
			action.moveToElement(MONITOR_LOCATOR).build().perform();
			//baction.moveToElement(GAMING_MONITOR).build().perform();
			 GAMING_MONITOR.click();
			Thread.sleep(3000);

}

@After
public void teardown() {
	driver.close();

}
}

