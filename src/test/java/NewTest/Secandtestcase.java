package NewTest;

import java.time.Duration;

import org.junit.jupiter.api.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Secandtestcase {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.amazon.in/");
        driver.findElement(By.xpath("//button[text()='Continue shopping']")).click();
        driver.findElement(By.xpath("//span[text()='Hello, sign in']")).click();
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("vinayca333@gmail.com");
        driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
      //  driver.findElement(By.id("auth-fpp-link-bottom")).click();
        
        
        
	}

}