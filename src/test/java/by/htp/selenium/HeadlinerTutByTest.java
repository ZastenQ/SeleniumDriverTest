package by.htp.selenium;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HeadlinerTutByTest {
	private static WebDriver driver;

	@BeforeClass
	public static void initBrowser() {
		System.setProperty("webdriver.gecko.driver", "c://driver//geckodriver.exe");
		driver = new FirefoxDriver();
		// driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
	}

	@Test
	public void headlinerTutBy() {
		driver.get("http://www.tut.by");
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

		WebElement titleElement = driver.findElement(By.className("entry-head"));
		titleElement.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement headliner = driver.findElement(By.id("article_body"));
		List<WebElement> paragraph = new ArrayList<WebElement>();
		paragraph = headliner.findElements(By.tagName("p"));
		System.out.println("Count of paragraphs: " + paragraph.size());
	}

	@AfterClass
	public static void closeBrowser() {
		driver.quit();
	}
}
