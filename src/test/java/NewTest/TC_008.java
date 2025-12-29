package NewTest;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_008 {
	
	
	@Test
	public void differentpasseordforsame() {
	
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
    driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
    
    driver.findElement(By.xpath("//a[@title='My Account']")).click();
	driver.findElement(By.xpath("(//a[text()='Register'])[1]")).click();
	
	driver.findElement(By.id("input-firstname")).sendKeys("ajay");
	driver.findElement(By.id("input-lastname")).sendKeys("ajjappa");
	driver.findElement(By.id("input-email")).sendKeys(generategmail());
	driver.findElement(By.id("input-telephone")).sendKeys("9754375456");
	driver.findElement(By.id("input-password")).sendKeys("vinay");
	driver.findElement(By.id("input-confirm")).sendKeys("vinay123");	
	
	driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
	
	driver.findElement(By.name("agree")).click();
	driver.findElement(By.xpath("//input[@value='Continue']")).click();
	
	String actualpassword = "Password confirmation does not match password!";
	
	String expectedpassword = driver.findElement(By.xpath("//input[@name='confirm']/following-sibling::div")).getText();
	Assert.assertEquals(expectedpassword, actualpassword);

	driver.quit();
	
	}	
	
	public static String generategmail() {
		return new Date().toString()
				.replaceAll("\\s", "")
				.replaceAll("\\:", "")
				+"@gmail.com";
	}
	
}