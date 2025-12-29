package NewTest;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_005 {
	
	
	@Test
	public  void checkingthecheckbox(){
		
	
	
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
	
	//click button 
	driver.findElement(By.xpath("//input[@value=\"Continue\"]")).click();
	
	
	//2nd page
	driver.findElement(By.linkText("Continue")).click();
	
	//3rd page
	driver.findElement(By.linkText("Subscribe / unsubscribe to newsletter")).click();
	
	//4th page
	Assert.assertTrue(driver.findElement(By.xpath("//ul[@class=\"breadcrumb\"]//a[text()='Newsletter']")).isDisplayed());
	
	Assert.assertTrue(driver.findElement(By.xpath("//input[@value='0']")).isSelected());
	
	driver.quit();
	
}
	public static String generategmail() {
		return new Date().toString()
				.replaceAll("\\s", "")
				.replaceAll("\\:", "")
				+"@gmail.com";
	}
}
