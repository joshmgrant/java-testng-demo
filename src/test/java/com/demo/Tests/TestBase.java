package com.demo.Tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;


public abstract class TestBase {

    WebDriver driver;

    @BeforeMethod
    public void setUp(Method method) throws MalformedURLException {
        FirefoxOptions options = new FirefoxOptions();

        String username = System.getenv("SAUCE_USERNAME");
        String accesskey = System.getenv("SAUCE_ACCESS_KEY");

        options.setCapability("browserVersion", "65.0");
        options.setCapability("platformName", "Windows 10");

        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("seleniumVersion", "3.141.59");
        sauceOptions.setCapability("name", method.getName());
        sauceOptions.setCapability("build", "W3C");

        options.setCapability("sauce:options", sauceOptions);

        URL url = new URL("https://" + username + ":" + accesskey + "@ondemand.saucelabs.com/wd/hub/");

        driver = new RemoteWebDriver(url, options);

        driver.get("http://a.testaddressbook.com");

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        ((JavascriptExecutor) driver).executeScript("sauce:job-result=" + (result.isSuccess() ? "passed" : "failed"));
        driver.quit();
    }
}
