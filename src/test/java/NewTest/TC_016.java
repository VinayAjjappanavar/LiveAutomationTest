package NewTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_016 {

	@Test
	public void verifyingthespaceisacceptingornot() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	    driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");

	    driver.findElement(By.xpath("//a[@title='My Account']")).click();
		driver.findElement(By.xpath("(//a[text()='Register'])[1]")).click();
	
		driver.findElement(By.id("input-firstname")).sendKeys(" ");
		driver.findElement(By.id("input-lastname")).sendKeys(" ");
		driver.findElement(By.id("input-email")).sendKeys(" ");
		driver.findElement(By.id("input-telephone")).sendKeys(" ");
		driver.findElement(By.id("input-password")).sendKeys("");
		driver.findElement(By.id("input-confirm")).sendKeys("");	
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.xpath("//input[@name='agree'][@value='1']")).click();
		driver.findElement(By.xpath("//input[@value=\"Continue\"]")).click();
		
		String firstnamefiels = "First Name must be between 1 and 32 characters!";
		String lastname = "Last Name must be between 1 and 32 characters!";
		String emailfield = "E-Mail Address does not appear to be valid!";
		String telephone = "Telephone must be between 3 and 32 characters!";
		String password = "Password must be between 4 and 20 characters!";
		
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-firstname']//following-sibling::div")).getText(), firstnamefiels);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-lastname']//following-sibling::div")).getText(), lastname);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-email']//following-sibling::div")).getText(), emailfield);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-telephone']//following-sibling::div")).getText(), telephone);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-password']//following-sibling::div")).getText(), password);		
	
		driver.quit();
	}
	
}
