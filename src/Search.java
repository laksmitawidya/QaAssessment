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

public class Search extends CapabilitySetup{
	@Test
	public void searchproduct() throws InterruptedException {
		driver.findElement(By.id("search_query_top")).sendKeys("Dresses");
		driver.findElement(By.name("submit_search")).click();
	}
	
	@Test
	public void searchproductbyCategory() throws InterruptedException {
		driver.findElement(By.linkText("Dresses")).click();
		
		
	}
	

	

}
