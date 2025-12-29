package NewTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_009 {
	
	
	@Test
	public void warningmessageverify() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	    driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
	    
	    driver.findElement(By.xpath("//a[@title='My Account']")).click();
		driver.findElement(By.xpath("(//a[text()='Register'])[1]")).click();
		
		driver.findElement(By.id("input-firstname")).sendKeys("ajay");
		driver.findElement(By.id("input-lastname")).sendKeys("ajjappa");
		driver.findElement(By.id("input-email")).sendKeys("vinay@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("9754375456");
		driver.findElement(By.id("input-password")).sendKeys("vinay");
		driver.findElement(By.id("input-confirm")).sendKeys("vinay");	
		
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String actualstring = "Warning: E-Mail Address is already registered!";
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText(), actualstring);
		
		Thread.sleep(4000);
		
		driver.quit();
		
	}

}
