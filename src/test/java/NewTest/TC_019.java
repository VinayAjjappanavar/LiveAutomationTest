package NewTest;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TC_019 {
	
	WebDriver driver;
		
	
	@AfterMethod

	public void closeapplication() {
		
		driver.quit();

	}
	
	@Test
	public void Leadingandtrimmingontextbox() {

		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)) ;
		
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
		
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@title=\"My Account\"]")).click();
		driver.findElement(By.xpath("(//a[text()=\"Register\"])[1]")).click();
		
		//details
		String firstname = "  kariyappa    ";
		driver.findElement(By.id("input-firstname")).sendKeys(firstname);
		
		String secandname = "   mariyappa  ";
		driver.findElement(By.id("input-lastname")).sendKeys(secandname);
		
		String emailfor ="    "+generategmail()+ "   ";
		driver.findElement(By.id("input-email")).sendKeys(emailfor);
		
		String phoneno = "   9375804375   ";
		driver.findElement(By.id("input-telephone")).sendKeys(phoneno);
		
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.id("input-confirm")).sendKeys("12345");	
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.xpath("//input[@name='agree'][@value='1']")).click();
		
		//click button 
		driver.findElement(By.xpath("//input[@value=\"Continue\"]")).click();
		
		//nextpage click button
		
		driver.findElement(By.xpath("//a[text()='Continue']")).click();
		
		
		//click edit profile link
		driver.findElement(By.linkText("Edit your account information")).click();
		
		Assert.assertEquals(driver.findElement(By.id("input-firstname")).getText(), firstname.trim());
		Assert.assertEquals(driver.findElement(By.id("input-lastname")).getText(), secandname.trim());
		Assert.assertEquals(driver.findElement(By.id("input-email")).getText(), emailfor.trim());
		Assert.assertEquals(driver.findElement(By.id("input-telephone")).getText(), phoneno.trim());
		
	
	}
		public static String generategmail() {
			return new Date().toString()
					.replaceAll("\\s", "")
					.replaceAll("\\:", "")
					+"@gmail.com";
			
		}
	}
