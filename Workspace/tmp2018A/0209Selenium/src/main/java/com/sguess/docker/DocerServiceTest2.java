package com.sguess.docker;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DocerServiceTest2 {

    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setPlatform(Platform.ANY);
        String url = "http://192.168.1.70:4444/wd/hub";
        RemoteWebDriver driver = new RemoteWebDriver(new URL(url), cap);

        driver.get("http://www.baidu.com");
        String rst = driver.getScreenshotAs(OutputType.BASE64);
        System.err.println("data:image/png;base64," + rst);
//		driver.close();
    }


}
