package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected By signInLocator = By.id("sign-in");
    protected WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 10);
    }

//    public void shortSleep(){
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e){
//            System.out.println(e.toString());
//        }
//    }

    public void waitToClick(By locator){
        this.wait.until(ExpectedConditions.elementToBeClickable(locator));
        this.driver.findElement(locator).click();
    }

    public void waitToSendKeys(By locator, CharSequence text){
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        this.driver.findElement(locator).sendKeys(text);
    }

    public String getText(By locator){
        try {
            return driver.findElement(locator).getText();
        } catch (NoSuchElementException e) {
            return "";
        } catch (ElementNotVisibleException e) {
            return "";
        }
    }

    public boolean isDisplayed(By locator){
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        } catch (ElementNotVisibleException e) {
            return false;
        }
    }

    public void clickSignInButton() {
        this.waitToClick(this.signInLocator);
    }
}
