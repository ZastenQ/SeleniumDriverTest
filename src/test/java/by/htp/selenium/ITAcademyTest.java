package by.htp.selenium;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ITAcademyTest {
	private static WebDriver driver;

	@BeforeClass
	public static void initBrowser() {
		System.setProperty("webdriver.gecko.driver", "c://driver//geckodriver.exe");
		driver = new FirefoxDriver();
	}

	@Test
	public void itAcademy() {
		driver.get("http://www.it-academy.by/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		List<WebElement> menuElement = new ArrayList<WebElement>();
		menuElement = driver.findElements(By.xpath("//nav[@id='main-menu']//li[.//a[text()='На кого учиться?']]//a"));

		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		for (WebElement el : menuElement) {
			System.out.println(el.getText());
		}
	}

	@AfterClass
	public static void closeBrowser() {
		driver.quit();
	}
}
