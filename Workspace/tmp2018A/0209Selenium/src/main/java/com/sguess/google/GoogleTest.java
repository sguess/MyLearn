package com.sguess.google;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTest {
	public static void main(String[] args) throws IOException, InterruptedException {
		funSelenium();
	}

	private static void funGoogle() throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("#lst-ib")).sendKeys("Selenium");
		driver.getKeyboard().sendKeys(Keys.ENTER);
		Thread.sleep(10000);
		driver.quit();
	}
	private static void funSelenium() throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.seleniumhq.org/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Projects")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Selenium Grid")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Download")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Documentation")).click();
		Thread.sleep(10000);
		driver.quit();
	}

}
