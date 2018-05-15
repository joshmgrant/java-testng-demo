package com.demo;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.URL;

// valid user: jgrant@saucelabs.com, sauce

public class WorkflowTest {

    protected WebDriver driver;

    @Test
    public void workflowTest() {

        try {
            DesiredCapabilities caps = DesiredCapabilities.chrome();
            caps.setCapability("platform", "Windows 10");
            caps.setCapability("version", "65.0");
            caps.setCapability("seleniumVersion", "3.1.0");

            String sauce_username = System.getenv("SAUCE_USERNAME");
            String sauce_access_key = System.getenv("SAUCE_ACCESS_KEY");

            URL url = new URL("https://" + sauce_username + ":" + sauce_access_key + "@ondemand.saucelabs.com/wd/hub/");

            driver = new RemoteWebDriver(url, caps);

            driver.get("http://a.testaddressbook.com");

            driver.findElement(By.id("sign-in")).click();

            Thread.sleep(2000);
            driver.findElement(By.cssSelector("[data-test='submit']")).click();

            String expected = "Bad email or password.";
            String actual = driver.findElement(By.cssSelector("[data-test='notice']")).getText();

            Assert.assertEquals(expected, actual);

            Thread.sleep(2000);

            driver.findElement(By.xpath("//*[@id='session_email']")).sendKeys("jgrant@saucelabs.com");
            driver.findElement(By.xpath("//*[@id='session_password']")).sendKeys("sauce");
            driver.findElement(By.cssSelector("[data-test='submit']")).click();

            Assert.assertTrue(driver.findElement(By.cssSelector("[data-test='sign-out']")).isDisplayed());

        } catch (Exception e){
           System.out.println(e.toString());
        } finally {
            driver.quit();
        }
    }


}
