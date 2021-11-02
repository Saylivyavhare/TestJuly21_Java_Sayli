package code;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ComposeGmail {

	
	@Test
	void SendMail() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.gmail.com");
		// Send email address
		driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("vyavhare.sayli@gmail.com");
		driver.findElement(By.xpath("//div[@id='identifierNext']")).click();

		// send password
		WebElement passwordButton = driver.findElement(By.xpath("//input[@name='password']"));
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(passwordButton));
		passwordButton.sendKeys("Need to enter Password for Email");
		driver.findElement(By.xpath("//div[@id='passwordNext']")).click();

		// Click on compose button
		driver.findElement(By.xpath("//div[text()='Compose']")).click();

		// Enter the sender mail id
		driver.findElement(By.xpath("//textarea[@name='to']")).sendKeys("vyavhare.sayli@gmail.com");
		// Enter subject to the mail
		driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("Incubyte");
		driver.findElement(By.xpath("//div[@class='Am Al editable LW-avf']")).sendKeys("full");

		//Enter data in Mail Body
		driver.findElement(By.xpath("//div[@class=\"Ar Au\"]")).sendKeys("Automation QA test for Incubyte");
		driver.findElement(By.xpath("//div[text()='Send']")).click();
		driver.quit();
	}
}

