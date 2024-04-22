// package com.example;




// import org.openqa.selenium.By;
// import org.openqa.selenium.JavascriptExecutor;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.interactions.Actions;
// import org.testng.annotations.AfterTest;
// import org.testng.annotations.BeforeTest;
// import org.testng.annotations.Test;

// /**
//  * Unit test for simple App.
//  */
// public class AppTest 
// {
//     public WebDriver driver;
//     @BeforeTest
//     public void beforetest()
//     {
//         driver = new ChromeDriver();
//         driver.get("https://economictimes.indiatimes.com/et-now/results");
//     }
//     @Test
//     public void shouldAnswerWithTrue() throws InterruptedException
//     {
//         Thread.sleep(2000);
// 		driver.findElement(By.xpath("//*[@id='topnav']/div[10]/a")).click();
// 		Thread.sleep(2000);
		
// 		JavascriptExecutor js = (JavascriptExecutor)driver;
// 		js.executeScript("window.scrollBy(0,300)", "");
// 		Thread.sleep(2000);

// 		driver.findElement(By.id("amcSelection")).click();
// 		// Actions actions = new Actions(driver);
//     }
//     @AfterTest
//     public void aftertest() throws InterruptedException
//     {
//         Thread.sleep(3000);
//         driver.quit();
//     }

// }












package com.example;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
     WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromViewport(10, 10);

     WebElement element,options;
    WebDriver chromeDriver;
    JavascriptExecutor js;
    Actions actions;
    @BeforeTest
    public void beforeTest(){
        chromeDriver=new ChromeDriver();
		js=(JavascriptExecutor)chromeDriver;
		 actions=new Actions(chromeDriver);
		chromeDriver.get("https://www.google.com");
        chromeDriver.navigate().to("https://economictimes.indiatimes.com/et-now/results/.");
    }
    @Test
    public void test() throws InterruptedException
    {
        chromeDriver.findElement(By.xpath("//*[@id='topnav']/div[10]/a")).click();
		js.executeScript("window.scrollBy(0,250)");
		Thread.sleep(10000);
		Select amc=new Select(chromeDriver.findElement(By.name("amc")));
		amc.selectByValue("8");
		Thread.sleep(10000);
		Select scheme=new Select(chromeDriver.findElement(By.id("schemenm")));
		scheme.selectByVisibleText("Canara Robeco Bluechip Equity Direct-G");
		Thread.sleep(10000);
		chromeDriver.findElement(By.id("getDetails")).click();
		js.executeScript("window.scrollBy(0,250)");
		Thread.sleep(10000);
		System.out.println(chromeDriver.getCurrentUrl());
		Thread.sleep(10000);
		String handles=chromeDriver.getWindowHandle();
		for(String handle:chromeDriver.getWindowHandles()){
			if(!handles.equals(handle)){
				chromeDriver.switchTo().window(handles);
				System.out.print(chromeDriver.getCurrentUrl());
				break;
			}
		}
		Thread.sleep(10000);
		String originalWindow = chromeDriver.getWindowHandle();
		for (String windowHandle : chromeDriver.getWindowHandles()) {
			if(!originalWindow.contentEquals(windowHandle)) {
				chromeDriver.switchTo().window(windowHandle);
				break;
			}
		}
		element = chromeDriver.findElement(By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[2]/ul"));
		element.click();
		options = element.findElement(By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[2]/ul/li/ul/li[1]/span"));
		options.click();
		Thread.sleep(3000);

		//select amount
		element = chromeDriver.findElement(By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[3]/ul"));
		element.click();
		options = element.findElement(By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[3]/ul/li/ul/li[3]/span"));
		options.click();
		Thread.sleep(3000);

		//select period
		element = chromeDriver.findElement(By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[4]/ul"));
		element.click();
		options = element.findElement(By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[4]/ul/li/ul/li[3]/span"));
		options.click();
		Thread.sleep(3000);

		actions
                .scrollFromOrigin(scrollOrigin, 0, 100)
                .perform();
		
		Thread.sleep(3000);

		//click returns
		chromeDriver.findElement(By.xpath("//*[@id='mfNav']/div/ul/li[2]")).click();

		//fetching first table row and print in terminal
		element = chromeDriver.findElement(By.xpath("/html/body/main/div[10]/section[5]/div/div[1]/section[1]/div[2]/div[2]/ul/li[1]/table/tbody/tr[1]"));
		
		System.out.println("TRAILING RETURNS");
		System.out.println(element.getText());
    }
    @AfterTest
    public void afterTest() throws InterruptedException{
        Thread.sleep(3000);
        chromeDriver.quit();
    }
}