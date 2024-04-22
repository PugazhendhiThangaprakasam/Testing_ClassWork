package com.example.day5que1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
// import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day5que1Application {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.demoblaze.com/");
		driver.manage().window().maximize();;
		
		// Thread.sleep(10000);
		// driver.findElement(By.linkText("Laptops")).click();
		// Thread.sleep(3000);
		// driver.findElement(By.linkText("MacBook air")).click();
		// Thread.sleep(3000);
		// driver.findElement(By.linkText("Add to cart")).click();
		// Thread.sleep(3000);
		// driver.switchTo().alert().accept();
		// Thread.sleep(3000);
		// driver.findElement(By.linkText("Cart")).click();
		// Thread.sleep(3000);
		// List<WebElement>list = driver.findElements(By.tagName("td"));
		// if(list.isEmpty())
		// {
		// 	System.out.print("Empty");
		// }
		// else
		// {
			// 	for(WebElement i:list)
			// 	{
				// 		System.out.println(i.getText());
				// 	}
				// }
				
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1200)","");
		
		// SpringApplication.run(Day5que1Application.class, args);
	}

}
