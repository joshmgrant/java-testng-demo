package com.demo.Tests;

import com.demo.pages.LoginPage;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ValidLoginTest extends TestBase {

    LoginPage loginPage;

    @Test
    public void validUser() {
        loginPage = new LoginPage(driver);

        loginPage.loginAs("jgrant@saucelabs.com", "sauce");

        Assert.assertTrue(loginPage.isSignOutControlDisplayed());
    }

}
