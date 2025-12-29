package NewTest;

import java.time.Duration;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC_case_003 {

	
	@Test
	public void verifyingtheloginpage () {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
		
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@title=\"My Account\"]")).click();
		driver.findElement(By.xpath("(//a[text()=\"Register\"])[1]")).click();
		
		driver.findElement(By.id("input-firstname")).sendKeys("ajay");
		driver.findElement(By.id("input-lastname")).sendKeys("ajjappa");
		driver.findElement(By.id("input-email")).sendKeys(generategmail());
		driver.findElement(By.id("input-telephone")).sendKeys("9754375456");
		driver.findElement(By.id("input-password")).sendKeys("herfbehjbfsnf");
		driver.findElement(By.id("input-confirm")).sendKeys("herfbehjbfsnf");	
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value=\"Continue\"]")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("(//a[text()='Logout'])[2]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Success']")).isDisplayed());
		
		String firststring = "Your Account Has Been Created!";
		
		String actualstring = driver.findElement(By.id("content")).getText();
				
		Assert.assertTrue(actualstring.contains(firststring));
		
		driver.findElement(By.linkText("Continue")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		
		driver.quit();
		
	}
	public static String generategmail() {
		return new Date().toString()
				.replaceAll("\\s", "")
				.replaceAll("\\:", "")
				+"@gmail.com";
	}
}