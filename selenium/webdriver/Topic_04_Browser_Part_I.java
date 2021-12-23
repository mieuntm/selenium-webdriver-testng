package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_04_Browser_Part_I {
	WebDriver driver;
	WebDriver element;
	String projectPath = System.getProperty("user.dir");


	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
	}

	@Test
	public void TC_01_Browser() {
		driver.get("https://www.sendo.vn/");
		driver.close();
		driver.quit();
		WebElement emailTextbox = driver.findElement(By.id("email"));
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		String homePageUrl = driver.getCurrentUrl();
		Assert.assertEquals(homePageUrl, "https://www.sendo.vn/");
		String homePageSource = driver.getPageSource();
		Assert.assertTrue(homePageSource.contains("Welcome to our store"));
		driver.findElement(By.id("email")).click();
		emailTextbox.clear();
		emailTextbox.sendKeys("");
		emailTextbox.getAttribute("value");
		String homePageTitle = driver.getTitle();
		Assert.assertEquals(homePageTitle, "Đăng nhập hoặc đăng ký");
		String signUpTabID = driver.getWindowHandle();
		Set<String> allTabID = driver.getWindowHandles();
		driver.manage().getCookies();
		driver.manager().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.sendo.vn/");
		driver.manage().window().fullscreen();
		driver.manage().window().maximize();
		Point browserPosition = driver.manage().window().getPosition();
		driver.manage().window().setPosition(new Point(0, 250));
		Dimension browserSize = driver.manage().window().getSize();
		driver.manage().window().setSize(new Dimension(1366, 768));
		driver.manage().window().setSize(new Dimension(1920, 1080));
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		driver.navigate().to("https://www.sendo.vn/");
		driver.switchTo().alert();
		driver.switchTo().frame(1);
		driver.switchTo().window("");
	}
	
	///
	@Test
	public void TC_02_Element() {
		
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	public void sleepInSecond(long second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}