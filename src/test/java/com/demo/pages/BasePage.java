package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;
    protected By signInLocator = By.id("sign-in");

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void shortSleep(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
            System.out.println(e.toString());
        }
    }

    public void clickSignInButton() {
        this.driver.findElement(this.signInLocator).click();
        this.shortSleep();
    }
}
