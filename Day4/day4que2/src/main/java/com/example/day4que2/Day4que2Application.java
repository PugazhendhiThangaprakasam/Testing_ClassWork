package com.example.day4que2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day4que2Application {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driverChrome = new ChromeDriver();
		driverChrome.get("https://www.shoppersstop.com");
		driverChrome.findElement(By.id("profileImage")).click();
		Thread.sleep(100000);
		driverChrome.close();
		SpringApplication.run(Day4que2Application.class, args);
	}

}
