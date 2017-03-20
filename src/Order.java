import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Order extends CapabilitySetup{
	@Test
	public void checkoutwithoutlogin() throws InterruptedException{
		driver.findElement(By.linkText("T-shirts")).click();
		Thread.sleep(5000);
		driver.findElement(By.className("product_img_link")).click();
		driver.findElement(By.id("add_to_cart")).click();
		driver.findElement(By.xpath("//a[@title='Proceed to checkout']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title='Proceed to checkout']")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("email")).sendKeys("mithawid@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("test1234");
		driver.findElement(By.id("SubmitLogin")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@title='Proceed to checkout']")).click();
		Thread.sleep(10000);
		driver.findElement(By.id("cgv")).click();
		driver.findElement(By.xpath("//a[@title='Proceed to checkout']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//a[@class='bankwire']")).click();
		Thread.sleep(100000);
		driver.findElement(By.xpath(("//button[@type='submit']"))).click();
		WebElement confirmedpayment=driver.findElement(By.className("cheque-indent"));
		Assert.assertTrue(confirmedpayment.isDisplayed());
		
	}
}
