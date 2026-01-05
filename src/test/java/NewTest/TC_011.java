package NewTest;

import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TC_011 {
	
	WebDriver driver;
	
	@AfterMethod
	
	public void closethebrowser() {
		driver.quit();
	}
	
	@Test
	
public void emailverificationwithhalf() throws IOException, InterruptedException {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	    driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
	    
	    driver.findElement(By.xpath("//a[@title='My Account']")).click();
		driver.findElement(By.xpath("(//a[text()='Register'])[1]")).click();
		
		driver.findElement(By.id("input-firstname")).sendKeys("ajay");
		driver.findElement(By.id("input-lastname")).sendKeys("ajjappa");
		driver.findElement(By.id("input-email")).sendKeys(generategmail());
		driver.findElement(By.id("input-telephone")).sendKeys("sdfr");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.id("input-confirm")).sendKeys("12345");	
	    driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		Thread.sleep(4000);
		
		String ectualresult = "Telephone number does not appear to be valid!";
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Telephone number does not appear to be valid!']")).getText(), ectualresult);

		//driver.quit();
		
		
	}

public static String generategmail() {
	return new Date().toString()
			.replaceAll("\\s", "")
			.replaceAll("\\:", "")
			+"@gmail.com";
	
}
}
