package com.sguess.docker;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DocerServiceTest {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities cap=DesiredCapabilities.chrome();
		cap.setPlatform(Platform.ANY);
		ChromeOptions chromeOptions=new ChromeOptions();
		chromeOptions.addArguments("allow-running-insecure-content");
		cap.setCapability(ChromeOptions.CAPABILITY,chromeOptions);
		String url="http://192.168.1.70:4444/wd/hub";
		RemoteWebDriver driver=(ChromeDriver) new RemoteWebDriver(new URL(url),cap);
		driver.get("http://www.baidu.com");
		String rst=driver.getScreenshotAs(OutputType.BASE64);
		System.out.println(rst);
		driver.close();
	}


}
