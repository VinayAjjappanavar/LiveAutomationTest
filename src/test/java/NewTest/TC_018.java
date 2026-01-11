package NewTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_018 {

	@Test
public void verifyingthehightandwidth() {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)) ;
		
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
		
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@title=\"My Account\"]")).click();
		driver.findElement(By.xpath("(//a[text()=\"Register\"])[1]")).click();
		
		String actualhight =    "34px";
		String actualwidth =  "701.25px";
		
	     String expectedight =	driver.findElement(By.id("input-firstname")).getCssValue("height");
	     String expectedwidth =	driver.findElement(By.id("input-firstname")).getCssValue("width");
	     
	     System.out.println(expectedight);
	     System.out.println(expectedwidth);
	     
	     Assert.assertEquals(expectedight, actualhight);
	     Assert.assertEquals(expectedwidth, actualwidth);
	    
	     driver.quit();
}
}