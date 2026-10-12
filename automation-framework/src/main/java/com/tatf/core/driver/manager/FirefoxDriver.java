package com.tatf.core.driver.manager;

import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriver extends DriverManager {

    public FirefoxDriver() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--start-maximized");
        firefoxOptions.setAcceptInsecureCerts(true);

        this.driver = new org.openqa.selenium.firefox.FirefoxDriver(firefoxOptions);
        setDefaultConfig();
    }
}
