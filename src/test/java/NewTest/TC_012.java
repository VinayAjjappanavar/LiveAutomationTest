package NewTest;

import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_012 {
	
	@Test
	public void tabactionchecking() {

	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
    driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
    
    driver.findElement(By.xpath("//a[@title='My Account']")).click();
	driver.findElement(By.xpath("(//a[text()='Register'])[1]")).click();
	
	Actions action = new Actions(driver);
	
	for(int i=1; i<=23; i++) {
		
	action.sendKeys(Keys.TAB).perform();
	}
	
	action.sendKeys("Ajay").pause(Duration.ofSeconds(2)).
	sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys("ajjappa").
	sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys(generategmail()).
	pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).
	sendKeys("1234567890").pause(Duration.ofSeconds(3)).sendKeys(Keys.TAB).
	pause(Duration.ofSeconds(1)).sendKeys("123456").pause(Duration.ofSeconds(1)).
	sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys("123456").
	pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB).pause(Duration.ofSeconds(2)).
	sendKeys(Keys.LEFT).pause(Duration.ofSeconds(2)).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
	sendKeys(Keys.SPACE).pause(Duration.ofSeconds(2)).sendKeys(Keys.TAB).pause(Duration.ofSeconds(2)).
	sendKeys(Keys.ENTER).build().perform();
	
	
	Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"column-right\"]//a[text()='Logout']")).isDisplayed());
	Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Success']")).isDisplayed());
	
	driver.quit();
	}
	
	public static String generategmail() {
		return new Date().toString()
				.replaceAll("\\s", "")
				.replaceAll("\\:", "")
				+"@gmail.com";
		
	}
}