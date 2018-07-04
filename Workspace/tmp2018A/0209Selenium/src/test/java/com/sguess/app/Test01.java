package com.sguess.app;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test01 {

    @Test
    public void fun01() throws InterruptedException {
        String driverKey = "webdriver.chrome.driver";
        System.out.println(System.getProperty(driverKey));
        System.setProperty(driverKey, "C:\\Programs\\chromedriver\\chromedriver.exe");
        System.setProperty("webdriver.chrome.bin", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        System.out.println(System.getProperty(driverKey));
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.baidu.com");
        Thread.sleep(10 * 1000);
    }

    public static void main(String[] args) {
        String driverKey = "webdriver.chrome.driver";
        System.setProperty(driverKey, "C:\\Programs\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

    }
}
