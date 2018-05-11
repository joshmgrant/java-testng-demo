package com.demo.Tests;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ValidLoginTest extends TestBase {

    @Test
    public void validUser() throws InterruptedException {
            driver.findElement(By.id("sign-in")).click();

            Thread.sleep(2000);

            driver.findElement(By.xpath("//*[@id='session_email']")).sendKeys("jgrant@saucelabs.com");
            driver.findElement(By.xpath("//*[@id='session_password']")).sendKeys("sauce");
            driver.findElement(By.cssSelector("[data-test='submit']")).click();

            Assert.assertTrue(driver.findElement(By.cssSelector("[data-test='sign-out']")).isDisplayed());
    }

}
