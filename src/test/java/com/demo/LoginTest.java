package com.demo;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

// valid user: jgrant@saucelabs.com, sauce

public class LoginTest {

    protected WebDriver driver;

    @Test
    public void workflowTest() {

        try {
            driver = new ChromeDriver();

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

            driver.findElement(By.cssSelector("[data-test='addresses']")).click();
            Thread.sleep(2000);

            Assert.assertTrue(driver.findElement(By.cssSelector("[data-test='create']")).isDisplayed());

        } catch (Exception e){
           System.out.println(e.toString());
        } finally {
            driver.quit();
        }
    }


}
