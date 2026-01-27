package NewTest;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_027 {

	
	@Test(dataProvider = "testinenvirommnment")
		public void verifyingtheapplicationinallbrowsers(String envirnment ) {
			
		String browername = "Chrome";
		WebDriver driver = null;
		if (browername.equals("Chrome")) {
			driver = new ChromeDriver();
		} else if (browername.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browername.equals("edge")) {
			driver = new EdgeDriver();				
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
	
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@title=\"My Account\"]")).click();
		driver.findElement(By.xpath("(//a[text()=\"Register\"])[1]")).click();
		
		//details for the register
		driver.findElement(By.id("input-firstname")).sendKeys("ajay");
		driver.findElement(By.id("input-lastname")).sendKeys("ajjappa");
		driver.findElement(By.id("input-email")).sendKeys(generategmail());
		driver.findElement(By.id("input-telephone")).sendKeys("9754375456");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.id("input-confirm")).sendKeys("12345");	
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.xpath("//input[@name='agree'][@value='1']")).click();
		
		//click button 
		driver.findElement(By.xpath("//input[@value=\"Continue\"]")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("(//a[text()='Logout'])[2]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class=\"breadcrumb\"]//a[text()='Success']")).isDisplayed());
        driver.findElement(By.xpath("//div[@class=\"pull-right\"]")).click();
        Assert.assertEquals(driver.getTitle(), "My Account");
        
        driver.quit();
        
      //ul[@class="breadcrumb"]//a[text()='Account']	
	}
	@DataProvider(name = "testinenvirommnment")
	public Object[][] passtestenvironment() {
		
		Object [][] envirnment = {{"Chrome"}, {"firefox"}, {"edge"}};
		return envirnment;
	}
		public static String generategmail() {
			return new Date().toString()
					.replaceAll("\\s", "")
					.replaceAll("\\:", "")
					+"@gmail.com";
		}

}
