package com.example.hoverdemo;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication
public class HoverdemoApplication {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriver driver = new ChromeDriver();

		Actions action = new Actions(driver);

		JavascriptExecutor js = (JavascriptExecutor)driver;

		driver.get("https://magento.softwaretestingboard.com/");
		Thread.sleep(2000);

		driver.findElement(By.id("search")).sendKeys("Shoes");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id='search_mini_form']/div[2]/button")).click();
		Thread.sleep(3000);
		

		//tocheck the presence of shoe
		if(driver.findElement(By.xpath("//*[@id='maincontent']/div[1]/h1/span")).getText().contains("Shoes"))
		{
			System.out.println("Search for results : Shoes is present");
		}
		else
		{
			System.out.println("Search for results : Shoes is not present");
		}


		TakesScreenshot srcshot = (TakesScreenshot)driver;
		File srcFile = srcshot.getScreenshotAs(OutputType.FILE);
		String filewithpath = "C:\\Users\\tpuga\\OneDrive\\Pictures\\Screenshots\\example.png";
		File destfile = new File(filewithpath);
		FileUtils.copyFile(srcFile,destfile);
		


		WebElement men = driver.findElement(By.xpath("//*[@id='ui-id-5']/span[2]"));
		action.moveToElement(men).build().perform();

		WebElement tops = driver.findElement(By.xpath("//*[@id='ui-id-17']/span[2]"));
		action.moveToElement(tops).build().perform();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id='ui-id-20']/span")).click();
		Thread.sleep(2000);

		driver.navigate().to("https://magento.softwaretestingboard.com/");
		Thread.sleep(2000);

		js.executeScript("window.scrollBy(0,600)","");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id='maincontent']/div[3]/div/div[3]/div[1]/div/a[2]/span[2]/span[2]")).click();
		Thread.sleep(2000);

		js.executeScript("window.scrollBy(0,600)","");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id='maincontent']/div[3]/div[1]/div[4]/ol/li[3]/div/div/strong/a")).click();
		Thread.sleep(2000);
		
		js.executeScript("window.scrollBy(0,400)","");
		Thread.sleep(2000);
		
		driver.findElement(By.id("option-label-size-143-item-168")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("option-label-color-93-item-56")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("qty")).clear();
		driver.findElement(By.id("qty")).sendKeys("4");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id='product-addtocart-button']/span")).click();


		Thread.sleep(2000);

		SpringApplication.run(HoverdemoApplication.class, args);
	}

}
