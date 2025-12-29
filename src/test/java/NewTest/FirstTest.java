package NewTest;

import static org.testng.Assert.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FirstTest {

	@org.testng.annotations.Test
	public void verifyregisteraccout(){
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
		
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@title=\"My Account\"]")).click();
		driver.findElement(By.xpath("(//a[text()=\"Register\"])[1]")).click();
		
		driver.findElement(By.id("input-firstname")).sendKeys("ajay");
		driver.findElement(By.id("input-lastname")).sendKeys("ajjappa");
		driver.findElement(By.id("input-email")).sendKeys(generategmail());
		driver.findElement(By.id("input-telephone")).sendKeys("9754375456");
		driver.findElement(By.id("input-password")).sendKeys("herfbehjbfsnf");
		driver.findElement(By.id("input-confirm")).sendKeys("herfbehjbfsnf");	
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value=\"Continue\"]")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("(//a[text()='Logout'])[2]")).isDisplayed());
		
		String expectedresult = "Your Account Has Been Created!";
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='common-success']//h1")).getText(), expectedresult);
		
		String Actualproperdetails1 =  "Congratulations! Your new account has been successfully created!";
		String Actualproperdetails2 = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String Actualproperdetails3 = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String Actualproperdetails4 = "contact us";
		
		String expectedproperties = driver.findElement(By.id("content")).getText();
		
		Assert.assertTrue(expectedproperties.contains(Actualproperdetails1));
		Assert.assertTrue(expectedproperties.contains(Actualproperdetails2));
		Assert.assertTrue(expectedproperties.contains(Actualproperdetails3));
		Assert.assertTrue(expectedproperties.contains(Actualproperdetails4));
		
		driver.findElement(By.xpath("//a[text()='Continue']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		
		driver.close();
		
	}
	    public static String generategmail() {
		return new Date().toString()
				.replaceAll("\\s", "")
				.replaceAll("\\:", "")
				+"@gmail.com";
	}
}