package com.example.day4que1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day4que1Application {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driverChrome = new ChromeDriver();
		WebDriver driverEdge = new EdgeDriver();
		WebDriver driverFirefox = new FirefoxDriver();
		driverChrome.get("https://www.google.com");
		driverChrome.close();
		driverEdge.get("https://www.google.com");
		driverEdge.close();
		driverFirefox.get("https://www.google.com");
		driverFirefox.close();

		
		SpringApplication.run(Day4que1Application.class, args);
	}

}
