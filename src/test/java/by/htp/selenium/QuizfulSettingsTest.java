package by.htp.selenium;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class QuizfulSettingsTest {
	private static WebDriver driver;

	@BeforeClass
	public static void initBrowser() {
		System.setProperty("webdriver.gecko.driver", "c://driver//geckodriver.exe");
		driver = new FirefoxDriver();

		driver.get("http://www.quizful.net/LoginAction.loginForm");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebElement loginElement = driver.findElement(By.id("login-form"));
		 loginElement.findElement(By.name("registrationForm.login")).sendKeys("IvanDurak");
		 loginElement.findElement(By.name("registrationForm.password")).sendKeys("IvanPW");
		//loginElement.findElement(By.name("loginForm.login")).sendKeys("ZastenQ");
		//loginElement.findElement(By.name("loginForm.password")).sendKeys("QuizAcc7");
		loginElement.findElement(By.name("ok")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void personalSettings() {
		driver.get("http://www.quizful.net/ProfileAction.settings");

		WebElement setElement = driver.findElement(By.id("edit-profile-page"));
		setElement.findElement(By.id("profile-personal-form")).findElement(By.className("title")).click();
		setElement.findElement(By.name("personalForm.name")).sendKeys("Victor");
		setElement.findElement(By.name("personalForm.surname")).sendKeys("Z");
		setElement.findElement(By.name("personalForm.birthyear")).sendKeys("1986");
		setElement.findElement(By.name("personalForm.company")).sendKeys("My company");
		setElement.findElement(By.name("personalForm.site")).sendKeys("www.site.com");

		Select countrySelect = new Select(setElement.findElement(By.name("personalForm.countryId")));
		countrySelect.selectByVisibleText("Беларусь");

		Select citySelect = new Select(setElement.findElement(By.name("personalForm.cityId")));
		citySelect.selectByVisibleText("Минск");

		Select zoneSelect = new Select(setElement.findElement(By.name("personalForm.zone")));
		zoneSelect.selectByValue("Europe/Minsk");

		setElement.findElement(By.name("personalForm.about")).sendKeys("Cualquiera cosa/Anything");
		setElement.findElement(By.name("personalForm.save")).click();
	}

	@Test
	public void privacySettings() {
		driver.get("http://www.quizful.net/ProfileAction.settings");

		WebElement setElement = driver.findElement(By.id("edit-profile-page"));
		setElement.findElement(By.id("profile-privacy-form")).findElement(By.className("title")).click();

		setElement
				.findElement(By
						.xpath("//*[@id='edit-profile-page']/div[@id='profile-privacy-form']//input[@name='privacyForm.profileVisibility'][@value='closed']"))
				.click();

		setElement.findElement(By.name("privacyForm.save")).click();
	}

	@Test
	public void notificationSettings() {
		driver.get("http://www.quizful.net/ProfileAction.settings");

		WebElement setElement = driver.findElement(By.id("edit-profile-page"));
		setElement.findElement(By.id("profile-notifications-form")).findElement(By.className("title")).click();

		WebElement radioNotif = setElement.findElement(By.xpath(
				"//*[@id='edit-profile-page']/div[@id='profile-notifications-form']//input[@name='notificationsForm.notificationsEnabled'][@checked='checked']"));
		boolean radioStatusNot = radioNotif.isSelected();
		if (radioStatusNot) {
			radioNotif.click();
		}

		WebElement radioDeliv = setElement.findElement(By.xpath(
				"//*[@id='edit-profile-page']/div[@id='profile-notifications-form']//input[@name='notificationsForm.deliveryEnabled'][@checked='checked']"));
		boolean radioStatusDel = radioDeliv.isSelected();
		if (radioStatusDel) {
			radioDeliv.click();
		}
		setElement.findElement(By.name("notificationsForm.save")).click();
	}

	@AfterClass
	public static void closeBrowser() {
		 driver.quit();
	}
}
