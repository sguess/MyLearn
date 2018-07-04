package com.sguess.app;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test03 {

    //	@Test
    public void fun01() throws InterruptedException {
        String driverKey = "webdriver.chrome.driver";
        System.out.println(System.getProperty(driverKey));
        System.setProperty(driverKey, "C:\\Programs\\chromedriver\\chromedriver.exe");
        System.setProperty("webdriver.chrome.bin", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        System.out.println(System.getProperty(driverKey));

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("allow-running-insecure-content");
        WebDriver driver = new ChromeDriver(chromeOptions);

        String url = "";
//		String url = "https://acme-v8customer06.kronos.net/wfc/applications/navigator/Navigator.do";
        url = "https://acme-v8customer04.kronos.net/wfc/logon";
//		url="https://objectivapoc4-mvp-dev.kronos.net/wfc/logon";
        driver.get(url);
//		Thread.sleep(1*1000);
//		driver.get(url);
        Thread.sleep(3 * 1000);
        driver.findElement(By.cssSelector("#username")).sendKeys("superuser");
        ;
        driver.findElement(By.cssSelector("#passInput")).sendKeys("kronites");
        ;
        driver.findElement(By.cssSelector("#loginSubmit")).click();
        Thread.sleep(10 * 1000);
        url = "https://acme-v8customer06.kronos.net/wfc/applications/wpk/html/AllServers.jsp";
        driver.navigate().to(url);
        Thread.sleep(10 * 1000);
        driver.quit();

    }

    public static void main(String[] args) throws InterruptedException {
//		String driverKey = "webdriver.chrome.driver";
//		System.setProperty(driverKey,"C:\\Programs\\chromedriver\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
        new Test03().fun01();
    }
}
