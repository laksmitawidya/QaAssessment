import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignIn extends CapabilitySetup {
	List<String> inputTestList = new ArrayList<String>();
	String inputtesting;

	@Test
	public void signIn() throws IOException, InterruptedException {
		readFile("./testinput/registeredaccount.txt");
		driver.findElement(By.linkText("Sign in")).click();
		Thread.sleep(10000);
		driver.findElement(By.id("email")).sendKeys(inputTestList.get(0));
		driver.findElement(By.id("passwd")).sendKeys(inputTestList.get(1));
		driver.findElement(By.id("SubmitLogin")).click();
		Thread.sleep(5000);
		WebElement myAccountPage = driver.findElement(By.className("page-heading"));
		Assert.assertTrue(myAccountPage.isDisplayed());
	}

	@Test
	public void forgetPassword() throws InterruptedException{
		driver.findElement(By.linkText("Sign in")).click();
		Thread.sleep(10000);
		driver.findElement(By.linkText("Forgot your password?")).click();
		driver.findElement(By.id("email")).sendKeys("mithawid@gmail.com");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		WebElement alertsuccess=driver.findElement(By.className("page-subheading"));
		Assert.assertTrue(alertsuccess.isDisplayed());
		
	}
	
	
	

	public void readFile(String filename) throws IOException {
		FileInputStream fstream = new FileInputStream(filename);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		String strLine;
		while ((strLine = br.readLine()) != null) {
			System.out.println(strLine + "\n");
			inputTestList.add(strLine);
		}
		br.close();
	}
}
