package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class OrderConfirmationPage extends Utility {

    By paymentMethodTextLocator = By.xpath("//li[@class='payment-method']//span[2]");
    By shippingMethodTextLocator = By.xpath("//li[@class='shipping-method']//span[2]");
    By totalPriceLocator = By.xpath("//tr[@class='order-total']/td[@class='cart-total-right']/span");
    By confirmButtonLocator = By.cssSelector(".button-1.confirm-order-next-step-button");



    public String getTextFromPaymentMethod() {
        return driver.findElement(paymentMethodTextLocator).getText();
    }

    public String getTextFromShippingMethod() {
        return driver.findElement(shippingMethodTextLocator).getText();
    }

    public String getTextFromTotalPrice() {
        return driver.findElement(totalPriceLocator).getText();
    }

    public void clickConfirmButton() {
        clickOnElement(confirmButtonLocator);

    }
}
