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
		WebElement product=driver.findElement(By.className("product-image-container"));
		Assert.assertTrue(product.isDisplayed());
	}
	
	@Test
	public void filterByView(){
		driver.findElement(By.linkText("Dresses")).click();
		WebElement grid= driver.findElement(By.xpath("//a[@title='Grid']"));
		WebElement list=driver.findElement(By.xpath("//a[@title='List']"));
		if(grid.isSelected()){
			list.click();
		} else if(list.isSelected()){
			grid.click();
		}
	}
	
	@Test
	public void sort() throws InterruptedException{
		WebElement lowestfirst= driver.findElement(By.id("selectProductSort"));
		Select dropdownlow = new Select(lowestfirst);
		dropdownlow.selectByVisibleText("Price: Lowest first");
		Thread.sleep(5000);
		WebElement highestfirst= driver.findElement(By.id("selectProductSort"));
		Select dropdownhigh = new Select(highestfirst);
		dropdownhigh.selectByVisibleText("Price: Highest first");	
		Thread.sleep(5000);
		WebElement sortProduct= driver.findElement(By.id("selectProductSort"));
		Select dropdownproduct = new Select(sortProduct);
		dropdownproduct.selectByVisibleText("Product Name: A to Z");
		Thread.sleep(5000);
		
	}
	
	

	

}
