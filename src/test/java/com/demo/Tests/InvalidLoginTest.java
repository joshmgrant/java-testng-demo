package com.demo.Tests;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.URL;

public class InvalidLoginTest extends TestBase {

    @Test
    public void blankCredentials() throws InterruptedException {
            driver.findElement(By.id("sign-in")).click();
            Thread.sleep(2000);
            driver.findElement(By.cssSelector("[data-test='submit']")).click();

            String expected = "Bad email or password.";
            String actual = driver.findElement(By.cssSelector("[data-test='notice']")).getText();

            Assert.assertEquals(expected, actual);
    }
}
