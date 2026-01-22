package NewTest;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_023 {
	
	@Test
	
	public void verifyingthelinkofthepagewerelogedinfunctionalitu() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
		
		driver.findElement(By.xpath("//i[@class='fa fa-phone']")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Contact Us")).isDisplayed());
		
		driver.navigate().back();
		
		driver.findElement(By.xpath("//a/i[@class='fa fa-heart']")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Login")).isDisplayed());
		
		driver.navigate().back();
		
		driver.findElement(By.xpath("//span[text()='Shopping Cart']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Shopping Cart']")).isDisplayed());
		
		driver.navigate().back();
		
		driver.findElement(By.xpath("//span[text()='Checkout']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Shopping Cart']")).isDisplayed());
		
		driver.navigate().back();
		
		driver.findElement(By.xpath("//div[@id='logo']//a")).click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://tutorialsninja.com/demo/index.php?route=common/home");
		
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Search']")).isDisplayed());
		
		driver.navigate().back();	
		
		driver.findElement(By.xpath("//a[@title=\"My Account\"]")).click();
		driver.findElement(By.xpath("(//a[text()=\"Register\"])[1]")).click();
		
		driver.navigate().back();	
		driver.navigate().back();	

		/*
		 * driver.findElement(By.xpath("(//a[text()='Register'])[3]")).click();
		 * Assert.assertTrue(driver.findElement(By.xpath(
		 * "//ul[@class='breadcrumb']//a[text()='Register']")).isDisplayed());
		 * 
		 * driver.navigate().back();
		 */
		
		//driver.findElement(By.xpath("(//a[text()='Login'])[3]")).click();
		// Assert.assertTrue(driver.findElement(By.xpath("(//a[text()='Login'])[2]")).isDisplayed()); 
		// driver.navigate().back();	
		
		driver.findElement(By.xpath("//ul[@class=\"breadcrumb\"]//i[@class=\"fa fa-home\"]")).click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://tutorialsninja.com/demo/index.php?route=common/home");
		
		driver.navigate().back();	

		driver.quit();
	}

}
//   - //a/i[@class='fa fa-phone']