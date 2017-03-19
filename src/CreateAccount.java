import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccount extends CapabilitySetup {
	List<String> inputTestList = new ArrayList<String>();
	String inputtesting;

	@Test
	public void createVariousEmail() throws IOException, InterruptedException {
		readFile("./testinput/falseEmail.txt");
		driver.findElement(By.linkText("Sign in")).click();
		Thread.sleep(10000);
		for (int i = 0; i < inputTestList.size(); i++) {
			inputtesting = inputTestList.get(i);
			driver.findElement(By.id("email_create")).sendKeys(inputtesting);
			driver.findElement(By.id("SubmitCreate")).click();
			driver.findElement(By.id("email_create")).clear();
			Thread.sleep(3000);
		}
		WebElement warningmessage = driver.findElement(By.id("create_account_error"));
		Assert.assertTrue(warningmessage.isDisplayed());
	}

	
	
	@Test
	public void registerAccount() throws IOException, InterruptedException {
		readFile("./testinput/createaccount.txt");
		driver.findElement(By.linkText("Sign in")).click();
		Thread.sleep(10000);
		driver.findElement(By.id("email_create")).sendKeys(inputTestList.get(0));
		driver.findElement(By.id("SubmitCreate")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("customer_firstname")).sendKeys(inputTestList.get(1));
		driver.findElement(By.id("customer_lastname")).sendKeys(inputTestList.get(2));
		driver.findElement(By.id("passwd")).sendKeys(inputTestList.get(3));
		driver.findElement(By.id("address1")).sendKeys(inputTestList.get(4));
		driver.findElement(By.id("city")).sendKeys(inputTestList.get(5));
		WebElement mySelectElement = driver.findElement(By.id("id_state"));
		Select dropdown = new Select(mySelectElement);
		dropdown.selectByVisibleText(inputTestList.get(6));
		driver.findElement(By.id("postcode")).sendKeys(inputTestList.get(7));
		driver.findElement(By.id("phone_mobile")).sendKeys(inputTestList.get(8));
		driver.findElement(By.id("submitAccount")).click();
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
