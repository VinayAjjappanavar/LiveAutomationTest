package NewTest;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_021 {
	
	@Test

	public void verifyingthepolicycheckboxwarning() throws InterruptedException {

	
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
    driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
	
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//a[@title=\"My Account\"]")).click();
	driver.findElement(By.xpath("(//a[text()=\"Register\"])[1]")).click();
	
	//details for the register
	driver.findElement(By.id("input-firstname")).sendKeys("ajay");
	driver.findElement(By.id("input-lastname")).sendKeys("ajjappa");
	driver.findElement(By.id("input-email")).sendKeys(generategmail());
	driver.findElement(By.id("input-telephone")).sendKeys("9754375456");
	driver.findElement(By.id("input-password")).sendKeys("12345");
	driver.findElement(By.id("input-confirm")).sendKeys("12345");	
	//driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
	
	//click continue button
	 
	driver.findElement(By.xpath("//input[@value=\"Continue\"]")).click();
	
	String expectedwarmessage = "Warning: You must agree to the Privacy Policy!";
	
	Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText(), expectedwarmessage);
	
	Thread.sleep(4000);
	
	driver.quit();
	}
	
	public static String generategmail() {
		return new Date().toString()
				.replaceAll("\\s", "")
				.replaceAll("\\:", "")
				+"@gmail.com";
	}
	}