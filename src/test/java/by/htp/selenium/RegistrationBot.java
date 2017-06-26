package by.htp.selenium;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegistrationBot {
	private static WebDriver driver;

	@BeforeClass
	public static void initBrowser() {
		System.setProperty("webdriver.gecko.driver", "c://driver//geckodriver.exe");
		driver = new FirefoxDriver();
	}

	@Test
	public void registrateQuizfulNet() {
		driver.get("http://www.quizful.net/LoginAction.registration");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebElement registryElement = driver.findElement(By.id("register-form"));
		registryElement.findElement(By.name("registrationForm.login")).sendKeys("IvanDurak");
		registryElement.findElement(By.name("registrationForm.password")).sendKeys("IvanPW");
		registryElement.findElement(By.name("registrationForm.repassword")).sendKeys("IvanPW");
		registryElement.findElement(By.name("registrationForm.email")).sendKeys("IvanDurak@tut.by");
		registryElement.findElement(By.name("registrationForm.corporate")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		registryElement.findElement(By.xpath("//div[@id='register-form']/div[3]/form/label[4]")).submit();
	}

	@AfterClass
	public static void closeBrowser() {
		driver.quit();
	}
}
