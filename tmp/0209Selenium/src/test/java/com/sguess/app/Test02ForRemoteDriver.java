package com.sguess.app;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Test02ForRemoteDriver {
    @Test
    public void test() throws IOException, InterruptedException {
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setPlatform(Platform.ANY);
        String urlStr = "http://localhost:4444/wd/hub";
        RemoteWebDriver driver = new RemoteWebDriver(new URL(urlStr), cap);
        driver.get("http://www.baidu.com");
        driver.findElement(By.cssSelector("#kw")).sendKeys("hello");
        driver.findElement(By.cssSelector("#su")).click();
        System.out.println("------------>" + driver.getSessionId());
        createShot(driver);
//        driver.quit();
    }

    @Test
    public void usingOpenedPageForAccessBaidu() throws MalformedURLException {
        String sessinId = "b0c01669-624f-4b9f-9ed4-e8419492f1891";
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setPlatform(Platform.ANY);
        String urlStr = "http://localhost:4444/wd/hub";
//        RemoteWebDriver driver=new RemoteWebDriver(new URL(urlStr),cap);
        MyWebDriver driver = new MyWebDriver(new URL(urlStr), cap);
        String newSessionId = driver.getSessionId().toString();
        try {
            driver.setSessionId(sessinId);
            String url = driver.getCurrentUrl();
            driver.get("http://www.baidu.com");
            driver.findElement(By.cssSelector("#kw")).sendKeys("hello");
            driver.findElement(By.cssSelector("#su")).click();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.setSessionId(newSessionId);
            driver.quit();
        }
    }

    @Test
    public void getAllSessionAndCloseIt() throws MalformedURLException {
        List<String> sessionList = new ArrayList<>();
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setPlatform(Platform.ANY);
        String urlStr = "http://localhost:4444/wd/hub";
        MyWebDriver driver = new MyWebDriver(new URL(urlStr), cap);
        driver.get("http://localhost:4444/wd/hub/static/resource/hub.html");
        List<WebElement> eles = driver.findElements(By.cssSelector(".session-container>.control-block>button"));
        WebElement refreshBtnEle = eles.get(1); //Click the refeash button
        refreshBtnEle.click();
        List<WebElement> tbsEles = driver.findElements(By.cssSelector(".goog-tab"));
        for (WebElement tbsEle : tbsEles) {
            tbsEle.click();
            WebElement sessionLabel = driver.findElements(By.cssSelector(".control-block span")).get(0);
            String session = sessionLabel.getText();
            System.out.println("session----->:" + session);
            sessionList.add(session);
        }
        for (String session : sessionList) {
            driver.setSessionId(session);
            driver.quit();
        }
    }

    @Test
    public void testCloseSession() throws MalformedURLException {
        List<String> sessionList = new ArrayList<>();
        sessionList.add("b0c01669-624f-4b9f-9ed4-e8419492f189");
        sessionList.add("a899f744-6b81-426f-9734-0e0ed8303285");
        sessionList.add("33f368df-b14d-4d45-b130-f652a656b969");
        sessionList.add("8e9cf4a5-e450-4e9e-9d94-162b7a2c21bc");
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setPlatform(Platform.ANY);
        String urlStr = "http://localhost:4444/wd/hub";
        MyWebDriver driver = new MyWebDriver(new URL(urlStr), cap);
        driver.quit();
        for (String s : sessionList) {
            driver.setSessionId(s);
            driver.quit();
        }

    }

    private void createShot(RemoteWebDriver driver) throws IOException, InterruptedException {
        Thread.sleep(1000 * 3);
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        System.out.println("--------------->File:" + file.getAbsolutePath());
        FileUtils.copyFile(file, new File("C:\\Selenium\\screenshot\\" + file.getName()));
    }
}
