package com.sguess.app;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class MyWebDriver extends RemoteWebDriver {

    public MyWebDriver(URL url, DesiredCapabilities cap) {
        super(url, cap);
    }

    @Override
    public void setSessionId(String opaqueKey) {
        super.setSessionId(opaqueKey);
    }
}
