package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class OrderCompletionPage extends Utility {

    By thankYouTitleLocator = By.xpath("//h1[normalize-space()='Thank you']");
    By successfullMessageLocator = By.xpath("//strong[normalize-space()='Your order has been successfully processed!']");
    By continueButtonCompletedOrderLocator = By.cssSelector(".button-1.order-completed-continue-button");



    public String getTextFromThankYouTitle() {
        return driver.findElement(thankYouTitleLocator).getText();
    }
    public String getTextFromOrderSuccessMessage() {
        return driver.findElement(successfullMessageLocator).getText();
    }

    public void clickOnContinueOrderCompletionButton(){
        clickOnElement(continueButtonCompletedOrderLocator);
    }
}
