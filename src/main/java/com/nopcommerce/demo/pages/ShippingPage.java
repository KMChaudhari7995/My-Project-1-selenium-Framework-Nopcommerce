package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class ShippingPage extends Utility {

    By nextDayAirRadioLocator = By.cssSelector("#shippingoption_1");
    By continueButtonAfterShippingLocator = By.cssSelector(".button-1.shipping-method-next-step-button");


    public void shippingMethod(){
        clickOnElement(nextDayAirRadioLocator);
    }

    public void shippingMethodContinueButton(){
        clickOnElement(continueButtonAfterShippingLocator);


    }
}
