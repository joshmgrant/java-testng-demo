package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;

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
        this.driver.findElement(By.id("sign-in")).click();
        this.shortSleep();
    }
}
