package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    public WebDriver driver;
    public XSSFWorkbook workbook;
    public String fromStation;
    public String toStation;

    @BeforeTest
    public void setUp() throws IOException
    {
        driver = new ChromeDriver();
        FileInputStream fis = new FileInputStream("D:\\Testing\\modelexam\\src\\Excel\\Data.xlsx");
        workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        fromStation = sheet.getRow(1).getCell(0).getStringCellValue();
        toStation = sheet.getRow(1).getCell(1).getStringCellValue();
    }
    @Test(priority = 1)
    public void loginTest() throws InterruptedException, IOException
    {
        driver.get("https://www.abhibus.com/");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id='train-link']/span[2]")).click();
        Thread.sleep(3000);
        
        if(driver.getCurrentUrl().contains("trains"))
        {
            System.out.println("URL contains Trains");
        }
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div[1]/a/img")).click();
        Thread.sleep(3000);
        
        driver.findElement(By.xpath("//*[@id=\"login-link\"]/span[2]")).click();
        Thread.sleep(4000);
        
        String popUp = driver.findElement(By.xpath("//*[@id=\"login-heading\"]/div[1]/h4")).getText();
        if(popUp.equals("Login to AbhiBus"))
        {
            System.out.println("Login to AbhiBus is present");
        }
        Thread.sleep(3000);

        TakesScreenshot srcshot = (TakesScreenshot)driver;
        File srcFile = srcshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("D:\\Testing\\modelexam\\src\\Screenshot\\login.png"));
    }
    @Test(priority = 2)
    public void testSearch() throws InterruptedException
    {
        driver.get("https://www.abhibus.com/");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id=\"search-from\"]/div/div/div/div/div[2]/input")).click();
        Thread.sleep(3000);
        
        WebElement element = driver.findElement(By.xpath("//*[@id=\"search-from\"]/div/div/div/div/div[2]/input"));
        element.sendKeys(fromStation);
        Thread.sleep(3000);
        element.sendKeys(Keys.ARROW_DOWN);
        element.sendKeys(Keys.ENTER);
        Thread.sleep(3000);


        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"search-to\"]/div/div/div/div/div[2]/input")));
        element = driver.findElement(By.xpath("//*[@id=\"search-to\"]/div/div/div/div/div[2]/input"));
        element.sendKeys(toStation);
        Thread.sleep(3000);
        element.sendKeys(Keys.ARROW_DOWN);
        element.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        
         driver.findElement(By.xpath("//*[@id=\"search-button\"]/button")).click();
         if(driver.getCurrentUrl().contains("Mumbai") && driver.getCurrentUrl().contains("Pune"))
         {  
            System.out.println("Mumbai and pune is present");
            
         }
         
    }
    @Test(priority = 3)
    public void testQuickLinks() throws InterruptedException, IOException
    {
        driver.get("https://www.abhibus.com/");
        Thread.sleep(3000);

        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,5500)");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id=\"footer-routes\"]/div/div[1]/div/div/div/div/button[5]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id='footer-routes']/div/div[2]/div/div/div/div[7]/a")).click();
        String name=driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/h2")).getText();
        if(name.equals("Media"))
        {
            System.out.println("Keyword Media is present");
        }

        TakesScreenshot srcshot = (TakesScreenshot)driver;
        File srcFile = srcshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("D:\\Testing\\modelexam\\src\\Screenshot\\news.png"));
    }
}
