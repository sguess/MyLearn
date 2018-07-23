package com.sguess.app;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Test04Grid {

	public void exec() throws InterruptedException, IOException {
		DesiredCapabilities cap=DesiredCapabilities.chrome();
		cap.setPlatform(Platform.ANY);
		String urlStr="http://localhost:4444/wd/hub";
		RemoteWebDriver driver=new RemoteWebDriver(new URL(urlStr),cap);
		driver.get("http://www.baidu.com");
		driver.findElement(By.cssSelector("#kw")).sendKeys("hello");
		driver.findElement(By.cssSelector("#su")).click();
		
		createShot(driver);
		String url="https://acme-v8customer04.kronos.net/wfc/logon";
		driver.get(url);
		Thread.sleep(3*1000);
		driver.findElement(By.cssSelector("#username")).sendKeys("superuser");;
		driver.findElement(By.cssSelector("#passInput")).sendKeys("kronites");;
		driver.findElement(By.cssSelector("#loginSubmit")).click();
		createShot(driver);
		System.out.println("--------------->End");
		driver.quit();
	}
	private void createShot(RemoteWebDriver driver) throws IOException, InterruptedException {
		Thread.sleep(1000*3);
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		System.out.println("--------------->File:"+file.getAbsolutePath());
		FileUtils.copyFile(file, new File("C:\\Selenium\\screenshot\\"+file.getName()));
	}
	public static void main(String[] args) throws InterruptedException, IOException {
		new Test04Grid().exec();
	}
}
