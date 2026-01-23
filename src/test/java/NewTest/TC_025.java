package NewTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_025 {	
	
		@Test
		public void verifyingtheregisterpage() {
		
		WebDriver driver = new ChromeDriver();
			
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)) ;
			
	    driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
			
	    driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@title=\"My Account\"]")).click();
		driver.findElement(By.xpath("(//a[text()=\"Register\"])[1]")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class=\"breadcrumb\"]//a[text()='Register']")).isDisplayed());
		
		String Actualtitle = "Register Account";
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id=\"content\"]//h1")).getText(), Actualtitle);
		
		String actualUrl = "https://tutorialsninja.com/demo/index.php?route=account/register";
		Assert.assertEquals(driver.getCurrentUrl(), actualUrl);
		
		String expectedtitle = "Register Account";
		Assert.assertEquals(driver.getTitle(), expectedtitle);
		
		driver.quit();
		}
	}
