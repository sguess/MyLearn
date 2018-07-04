package com.sguess.av;


import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AVTest {
    Logger log = LoggerFactory.getLogger(AVTest.class);
    ChromeDriver driver;

    public static void main(String[] args) throws IOException, InterruptedException {
        new AVTest().start();
    }

    private void start() throws InterruptedException {
        driver = new ChromeDriver();
        boolean rst = isEHC();
        System.err.println("--------->>>" + rst);
        Thread.sleep(10000);
        driver.quit();
    }

    private boolean isWFC404Error() {
        driver.get("https://flooranddecor.kronos.net/wfc/logon?cloud=a03");
        driver.manage().window().maximize();
        try {
            String rst = driver.findElement(By.cssSelector("#content >.content-container >fieldset>h2")).getText();
            if (rst.contains("404")) {
                log.info("This is 404 error page");
                return true;
            }
        } catch (Exception e) {
            log.info("This is not 404 error page");
            return false;
        }
        return false;

    }

    private boolean isServiceTemporarilyUnavailable() {
        driver.get("https://orlandohealth-ea.kronos.net/wfc/navigator/logon");
        driver.manage().window().maximize();
        List<WebElement> eles;
        try {
            eles = driver.findElements(By.cssSelector("h1"));
        } catch (Exception e) {
            log.info("Find the Service Temporarily Unavailable element failed. ");
            return false;
        }
        if (eles.size() != 1) {
            log.info("This is not a Service Temporarily Unavailable page, because there is not only one h1 element. ");
            return false;
        }
        String rst = eles.get(0).getText();
        if (rst.equalsIgnoreCase("Service Temporarily Unavailable!")) {
            System.err.println("--------->" + rst);
            return true;
        }
        System.err.println(rst);
        return false;
    }

    private boolean isEHC() {
        driver.get("https://umchealthsystem-ehc.kronos.net/KronosHealthcare/login.aspx");
        driver.manage().window().maximize();
        WebElement logonEle;
        try {
            logonEle = driver.findElement(By.cssSelector("#btnLogin"));
            String logonLinkStr = logonEle.getAttribute("src");
            System.err.println(logonLinkStr);
            if (logonLinkStr.contains("/KronosHealthcare/img/default/login_btn.gif")) {
                return true;
            }
        } catch (Exception e) {
            log.info("Find EHC elements failed");
            return false;
        }
        log.info("This is not EHC environment");
        return false;
    }


}
