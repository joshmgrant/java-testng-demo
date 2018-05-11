package com.demo.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class TestBase {

    WebDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("version", "65.0");
        caps.setCapability("seleniumVersion", "3.1.0");

        String sauce_username = System.getenv("SAUCE_USERNAME");
        String sauce_access_key = System.getenv("SAUCE_ACCESS_KEY");

        URL url = new URL("https://" + sauce_username + ":" + sauce_access_key + "@ondemand.saucelabs.com/wd/hub/");

        driver = new RemoteWebDriver(url, caps);

        driver.get("http://a.testaddressbook.com");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
