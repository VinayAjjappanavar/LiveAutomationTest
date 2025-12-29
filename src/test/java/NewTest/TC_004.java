package NewTest;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_004 {
	
	@Test
	
	public void registrationpagetest() {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)) ;
		
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
		
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@title=\"My Account\"]")).click();
		driver.findElement(By.xpath("(//a[text()=\"Register\"])[1]")).click();
		
		driver.findElement(By.xpath("//input[@value=\"Continue\"]")).click();
		
		String first = "First Name must be between 1 and 32 characters!";
		String secand = "Last Name must be between 1 and 32 characters!";
		String third = "E-Mail Address does not appear to be valid!" ;
		String forth = "Telephone must be between 3 and 32 characters!" ;
		String fifth = "Password must be between 4 and 20 characters!" ;
		String sixth = "Warning: You must agree to the Privacy Policy!";
		
		Assert.assertEquals(driver.findElement(By.xpath("//input[@name='firstname']/following-sibling::div")).getText(), first);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText(), secand);
	    Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText(), third);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText(), forth);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText(), fifth);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class=\"alert alert-danger alert-dismissible\"]")).getText(), sixth);
				
		driver.quit();
	}
}