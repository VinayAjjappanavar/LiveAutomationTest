package NewTest;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_017 {
	
	WebDriver driver;
	
	@AfterMethod
	public void tabclose() {
		
		driver.quit();
	}

	@Test(dataProvider="datasupplyer")
	public void verifyingthepasswordwasacceprtingthestrongpasswordornot(String passwordtext) {
		
		driver = new ChromeDriver();
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
		driver.findElement(By.id("input-password")).sendKeys(passwordtext);
		driver.findElement(By.id("input-confirm")).sendKeys(passwordtext);	
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.xpath("//input[@name='agree'][@value='1']")).click();
		
		//click button 
		driver.findElement(By.xpath("//input[@value=\"Continue\"]")).click();
		
		String actualmessage = "The password entered was not matching the complexity standard";
		
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-password']//following-sibling::div")).getText(), actualmessage);
		
		Assert.assertFalse(driver.findElement(By.linkText("Success")).isDisplayed());
		
	}
	
	public static String generategmail() {
		return new Date().toString()
				.replaceAll("\\s", "")
				.replaceAll("\\:", "")
				+"@gmail.com";
		
	}
	@DataProvider(name="datasupplyer")
	public Object[][] supplypassword() {
	       Object[][] data = {{"12345"},{"abcdef"},{"abcdef123"},{"kjsdbg@jfkjf"},{"gcv$245#@"}};
	       return data;
	       
	}
}
//input[@id='input-password']//following-sibling::div