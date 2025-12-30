package NewTest;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.File;
import java.nio.file.Files;
import java.time.Duration;
import java.util.logging.FileHandler;

import javax.imageio.ImageIO;

import org.apache.poi.ss.formula.functions.LookupUtils.CompareResult;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
//import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

public class TC_010 {
	
	
	@Test
	public void emailverificationwithhalf() throws IOException, InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	    driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
	    
	    driver.findElement(By.xpath("//a[@title='My Account']")).click();
		driver.findElement(By.xpath("(//a[text()='Register'])[1]")).click();
		
		driver.findElement(By.id("input-firstname")).sendKeys("ajay");
		driver.findElement(By.id("input-lastname")).sendKeys("ajjappa");
		driver.findElement(By.id("input-email")).sendKeys("amotoori");
		driver.findElement(By.id("input-telephone")).sendKeys("9754375456");
		driver.findElement(By.id("input-password")).sendKeys("vinay");
		driver.findElement(By.id("input-confirm")).sendKeys("vinay");	
		
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		Thread.sleep(4000);
		
		//File screenshot = driver.findElement(By.xpath("//form[@class='form-horizontal']")).getScreenshotAs(OutputType.FILE);
		
	    //FileHandler.class
		
		     WebElement form = driver.findElement(By.xpath("//form[@class='form-horizontal']"));

	        // Take screenshot of that area
	        File src = form.getScreenshotAs(OutputType.FILE);

	        // Destination file
	        File dest = new File("Screenshot folder/FormError.png");

	        // Save file
	        Files.copy(src.toPath(), dest.toPath());
		
	        System.out.println("Screenshot saved in Screenshot folder");
	        
	        
	        
	        BufferedImage expectedimage = ImageIO.read(new File("Screenshot folder/expected.png"));
	        
	        BufferedImage actualimage = ImageIO.read(dest);
	        
	        boolean result = compareImage
	        
	        
				
			driver.quit();
	}

}
