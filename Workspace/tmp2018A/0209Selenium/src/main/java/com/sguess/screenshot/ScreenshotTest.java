package com.sguess.screenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotTest {

	public static void main(String[] args) throws IOException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.baidu.com");
		driver.manage().window().maximize();
		// File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File file = driver.getScreenshotAs(OutputType.FILE);
		File destFile = new File("out/destFileName.png");
		FileUtils.copyFile(file, destFile);
		driver.quit();
	}

}
