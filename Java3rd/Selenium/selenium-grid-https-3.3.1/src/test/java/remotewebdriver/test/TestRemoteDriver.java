package remotewebdriver.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestRemoteDriver {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\selenium-grid\\chromedriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		RemoteWebDriver driver = new RemoteWebDriver(new URL("https://sch3-sa01-alh01.hosting.local:4444/wd/hub"), capabilities);
		driver.get("http://www.google.com");
		Thread.sleep(5000);
		driver.quit();
	}

}
