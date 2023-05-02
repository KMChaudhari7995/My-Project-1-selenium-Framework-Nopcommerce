package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class RegistrationSuccessfulPage extends Utility {

    By messageOfSuccessfulRegistration = By.xpath("//div[contains(text(),'Your registration completed')]");
    By buttonContinue = By.xpath("//a[contains(text(),'Continue')]");

    public String actualMessageOfSuccessfulRegistration(){
        return getTextFromElement(messageOfSuccessfulRegistration);
    }

    public void clickOnButtonContinue() throws InterruptedException {
        clickOnElement(buttonContinue);
        Thread.sleep(2000);
    }

}
