package NewTest;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.File;
import java.nio.file.Files;
import java.time.Duration;
import java.util.logging.FileHandler;

import javax.imageio.ImageIO;

//import org.apache.poi.ss.formula.functions.LookupUtils.CompareResult;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.comparison.ImageDiffer;

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
	        File actualFile = form.getScreenshotAs(OutputType.FILE);
	        
	        File actualDest = new File("Screenshot folder/FormError.png");
	        Files.copy(actualFile.toPath(), actualDest.toPath());

	        // Read images
	        BufferedImage expectedImage =
	                ImageIO.read(new File("Screenshot folder/expected.png"));

	        BufferedImage actualImage =
	                ImageIO.read(actualDest);

	        // Compare images
	        boolean result = compareImages(expectedImage, actualImage);

	        Assert.assertTrue(result, "❌ Images are NOT matching");

	        System.out.println("✅ Images are matching");
	        
				
			driver.quit();
	}

	private boolean compareImages(BufferedImage expectedImage, BufferedImage actualImage) {
		
		// TODO Auto-generated method stub
		if (img1.getWidth() != img2.getWidth() || img1.getHeight() != img2.getHeight()) {
           
			return false;
        }

        for (int x = 0; x < img1.getWidth(); x++) {
            for (int y = 0; y < img1.getHeight(); y++) {
                if (img1.getRGB(x, y) != img2.getRGB(x, y)) {
                    return false;
                }
            }
        }
        return true;
		}
}