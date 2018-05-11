package com.demo.Tests;

import com.demo.pages.LoginPage;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.URL;

public class InvalidLoginTest extends TestBase {

    protected LoginPage loginPage;

    @Test
    public void blankCredentials() {
        loginPage = new LoginPage(driver);

        loginPage.clickSignInButton();
        loginPage.enterCredentials("", "");
        loginPage.submitCredentials();

        String expected = "Bad email or password.";
        String actual = loginPage.getInvalidLoginMessage();

        Assert.assertEquals(expected, actual);
    }
}
