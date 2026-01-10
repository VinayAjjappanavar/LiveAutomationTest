package NewTest;

import java.awt.Window;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_014 {

	@Test
	public void verifythemandatodyfield() {
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	    driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");

	    driver.findElement(By.xpath("//a[@title='My Account']")).click();
		driver.findElement(By.xpath("(//a[text()='Register'])[1]")).click();
		
		//Startfromhear
		
		String expectedcolor = "\"* \"";
		String expectedfont  = "rgb(255, 0, 0)";
		
		WebElement Firstlabel = driver.findElement(By.cssSelector("label[for='input-firstname']"));
		JavascriptExecutor js =  (JavascriptExecutor)driver;
		String fnContent = (String)js.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", Firstlabel);
	    String fnColor = (String)js.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", Firstlabel);
	    Assert.assertEquals(fnContent, expectedcolor);
	    Assert.assertEquals( fnColor ,expectedfont);
	  
	    //Lastname method
	    
        WebElement Lastlabel = driver.findElement(By.cssSelector("label[for='input-lastname']"));
		JavascriptExecutor jes =  (JavascriptExecutor)driver;
		String lnContent = (String)jes.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", Lastlabel);
	    String lnColor = (String)jes.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", Lastlabel);
	    Assert.assertEquals(lnContent, expectedcolor);
	    Assert.assertEquals( lnColor ,expectedfont);
	    
	    //emailchecking
	    
        WebElement emaillabel = driver.findElement(By.cssSelector("label[for='input-email']"));
		
		JavascriptExecutor jees =  (JavascriptExecutor)driver;
		String emailContent = (String)jees.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", emaillabel);		
	    String emailColor = (String)jees.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", emaillabel);
	    Assert.assertEquals(emailContent, expectedcolor);
	    Assert.assertEquals(emailColor ,expectedfont);
	    
	    //telephone
	    WebElement telephonelabel = driver.findElement(By.cssSelector("label[for='input-telephone']"));
		
	  		JavascriptExecutor jess =  (JavascriptExecutor)driver;
	  		String telContent = (String)jess.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", emaillabel);		
	  	    String telColor = (String)jess.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", emaillabel);
	  	    Assert.assertEquals(telContent, expectedcolor);
	  	    Assert.assertEquals(telColor,expectedfont);
	    
	  	  //password
	  	    
	  	    WebElement passwordlabel = driver.findElement(By.cssSelector("label[for='input-password']"));
			
			JavascriptExecutor jepw =  (JavascriptExecutor)driver;
			String pwContent = (String)jepw.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", emaillabel);		
		    String pwColor = (String)jepw.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", emaillabel);
		    Assert.assertEquals(pwContent , expectedcolor);
		    Assert.assertEquals(pwColor ,expectedfont);
	    
		    //confirm password
		    
            WebElement confpasswordlabel = driver.findElement(By.cssSelector("label[for='input-password']"));
			
			JavascriptExecutor jecpw =  (JavascriptExecutor)driver;
			String cpwContent = (String)jecpw.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", emaillabel);		
		    String cpwColor = (String)jecpw.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", emaillabel);
		    Assert.assertEquals(cpwContent , expectedcolor);
		    Assert.assertEquals(cpwColor ,expectedfont);
	    
	    driver.quit();
	    
	}

}
