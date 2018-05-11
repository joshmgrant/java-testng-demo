package com.demo.pages;

import org.openqa.selenium.*;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void enterCredentials(String email, String password){
        this.shortSleep();
        driver.findElement(By.xpath("//*[@id='session_email']")).sendKeys(email);
        driver.findElement(By.xpath("//*[@id='session_password']")).sendKeys(password);
    }

    public void submitCredentials() {
        this.shortSleep();
        driver.findElement(By.cssSelector("[data-test='submit']")).click();
    }

    public String getInvalidLoginMessage() {
        try {
            return driver.findElement(By.cssSelector("[data-test='notice']")).getText();
        } catch (NoSuchElementException e) {
            return "";
        } catch (ElementNotVisibleException e) {
            return "";
        }

    }

    public boolean isSignOutControlDisplayed(){
        try {
            return driver.findElement(By.cssSelector("[data-test='sign-out']")).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        } catch (ElementNotVisibleException e) {
            return false;
        }
    }
}
