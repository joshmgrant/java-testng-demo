package com.demo.pages;

import org.openqa.selenium.*;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void enterCredentials(String email, String password){
        this.waitToSendKeys(By.id("session_email"), email);
        this.waitToSendKeys(By.id("session_password"), password);
    }

    public void submitCredentials() {
        this.waitToClick(By.cssSelector("[data-test='submit']"));
    }

    public String getInvalidLoginMessage() {
        return this.getText(By.cssSelector("[data-test='notice']"));
    }

    public boolean isSignOutControlDisplayed(){
        return this.isDisplayed(By.cssSelector("[data-test='sign-out']"));
    }

    public void loginAs(String email, String password) {
        this.clickSignInButton();
        this.enterCredentials(email, password);
        this.submitCredentials();
    }
}
