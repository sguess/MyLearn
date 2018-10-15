package com.sguess.app;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteLogs;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;

public class TestSeleniumServiceLog {

    RemoteWebDriver driver;

    @Before
    public void setup() throws MalformedURLException {
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setPlatform(Platform.ANY);
        String urlStr = "http://localhost:4444/wd/hub";
        driver = new RemoteWebDriver(new URL(urlStr), cap);
    }


    @Test
    public void test() {
        RemoteLogs logs = (RemoteLogs) driver.manage().logs();
        driver.setLogLevel(Level.ALL);
        driver.get("http://www.baidu.com/");
        driver.get("http://www.hao123.com/");
        driver.get("http://www.baidu.com/");

        LogEntries logEntries = logs.get(LogType.SERVER);
        List<LogEntry> list = logEntries.getAll();
        System.err.println("<-------------------------------------------------------------------");
        System.err.println("log size is " + list.size());
        for (LogEntry logEntry : list) {
            System.err.println(logEntry.getMessage());
        }
        System.err.println("------------------------------------------------------------------->");
    }
    @After
    public void tearDown(){
        driver.close();
    }
}

