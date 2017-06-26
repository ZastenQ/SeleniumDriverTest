package by.htp.selenium;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleTest {
	private static WebDriver driver;

	@BeforeClass
	public static void initBrowser() {

		System.setProperty("webdriver.gecko.driver", "c://driver//geckodriver.exe");

		driver = new FirefoxDriver();
		// явное ожидание, чтобы все элементы подгрузились
		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
	}

	@Test
	public void googleSearchTest() {
		String inputLine = "Java";
		driver.get("http://www.google.com");
		WebElement searchElement = driver.findElement(By.id("lst-ib"));
		searchElement.sendKeys(inputLine);
		searchElement.submit();

		(new WebDriverWait(driver, 5)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle().contains(inputLine);
			}
		});

	}

	@AfterClass
	public static void closeBrowser() {
		driver.quit();
	}
}
