package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class LoginPage extends Utility {

    By logInLink = By.linkText("Log in");
    By emailField = By.cssSelector("#Email");
    By passwordField = By.cssSelector("#Password");
    By loginButton = By.cssSelector(".button-1.login-button");

    public void loginLink() {
        clickOnElement(logInLink);
    }

    public void emailField(String email) {
        sendTextToElement(emailField, email);
    }

    public void passwordField(String password) throws InterruptedException {
        Thread.sleep(2000);
        sendTextToElement(passwordField, password);
    }

    public void clickOnLoginButton() {
        clickOnElement(loginButton);
    }
}
