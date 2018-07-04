package com.sguess.sample;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class BaiduDemo {
    Logger LOG = LoggerFactory.getLogger(BaiduDemo.class);

    // @Test
    public void test() throws IOException {
        WebClient webClient = new WebClient();
        webClient.getOptions().setJavaScriptEnabled(false);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setUseInsecureSSL(false);

        // 获取页面
        String url = "https://www.baidu.com";
        HtmlPage page = webClient.getPage(url);

        System.out.println("页面文本:" + page.getTitleText());

        // 获取页面元素
        HtmlInput htmlInput = page.getHtmlElementById("kw");
        System.out.println(htmlInput.asText());
        htmlInput.setValueAttribute("test");

        HtmlInput btn = page.getHtmlElementById("su");
        HtmlPage page2 = btn.click();

        System.out.println("页面2:" + page2.getTitleText());
    }

    // @Test
    public void test2() throws IOException, InterruptedException {
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://www.baidu.com");
        WebElement inputEle = driver.findElement(By.cssSelector("#kw"));
        inputEle.sendKeys("Selenium");
        driver.findElement(By.cssSelector("#su")).click();

    }

    // @Test
    public void test3() throws IOException, InterruptedException {
        WebDriver driver = new HtmlUnitDriver();
        driver.get("https://logging.apache.org/log4j/2.x/");
        List<WebElement> list = driver.findElements(By.cssSelector(".nav>li"));
        LOG.info("list.size(): {}", list.size());

        String contStr;
        for (int i = 0; i < list.size(); i++) {
            contStr = list.get(i).getText();
            LOG.info("nav {}: {}", i, contStr);
            if (contStr.equals("Download")) {
                list.get(i).click();
                break;
            }
        }

    }

    // @Test
    public void test4() throws IOException, InterruptedException {
        String driverKey = "webdriver.chrome.driver";
        System.setProperty(driverKey, "C:\\Programs\\chromedriver\\chromedriver.exe");
        System.setProperty("webdriver.chrome.bin", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        WebDriver driver;
        // driver= new ChromeDriver();
        driver = new HtmlUnitDriver();
        // driver.setJavascriptEnabled(true);
        driver.get(
                "https://objectivapoc1-mvp-dev.kronos.net/wfc/applications/suitenav/navigation.do?ESS=true&ESS=true");
        driver.findElement(By.cssSelector("#username")).sendKeys("superuser");
        driver.findElement(By.cssSelector("#passInput")).sendKeys("Kronos@123");
        driver.findElement(By.cssSelector("#loginSubmit")).click();
        List<WebElement> eles = driver.findElements(By.className("#kronos>.ColumnarLayout>tbody"));
        LOG.info("eles.size(): {}", eles.size());
    }

    @Test
    public void test5() throws IOException, InterruptedException {

        WebClient webClient = new WebClient();
        webClient.getOptions().setJavaScriptEnabled(false);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setUseInsecureSSL(false);

        String url = "https://objectivapoc1-mvp-dev.kronos.net/wfc/applications/suitenav/navigation.do?ESS=true&ESS=true";
        HtmlPage page = webClient.getPage(url);

        HtmlInput usernameInput = page.getHtmlElementById("username");
        usernameInput.setValueAttribute("superuser");

        HtmlInput password = page.getHtmlElementById("username");
        password.setValueAttribute("superuser");

        HtmlButton loginBtn = page.getHtmlElementById("loginSubmit");
        loginBtn.click();

        HtmlPage newPage = page.getPage();
        String str = page.getBaseURI();
        LOG.info("-------->0:", str);
        LOG.info("-------->0:", page.getPage());

    }
}