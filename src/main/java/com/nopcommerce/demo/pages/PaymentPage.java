package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class PaymentPage extends Utility {

    By creditCartRadioLocator = By.cssSelector("#paymentmethod_1");
    By continueButtonPaymentMethodLocator = By.cssSelector(".button-1.payment-method-next-step-button");
    By creditCardDropdownLocator = By.id("CreditCardType");
    By cardHolderNameFieldLocator = By.id("CardholderName");
    By cardNumberFieldLocator = By.id("CardNumber");
    By expireMonthDropdownLocator = By.id("ExpireMonth");
    By expireYearDropdownLocator = By.id("ExpireYear");
    By cardCodeFieldLocator = By.xpath("//input[@data-val-regex-pattern='^[0-9]{3,4}$']");
    By continueButtonAfterCreditCardInfoLocator = By.cssSelector(".button-1.payment-info-next-step-button");

    public void selectCreditCardRadioButton() {
        clickOnElement(creditCartRadioLocator);
    }

    public void continuePaymentButton() {
        clickOnElement(continueButtonPaymentMethodLocator);
    }

    public void selectCreditCard(int index) {
        selectByIndexFromDropDown(creditCardDropdownLocator, index);
    }

    public void cardHolderName(String name) {
        sendTextToElement(cardHolderNameFieldLocator, name);
    }

    public void cardNumber(String cardNumber) {
        sendTextToElement(cardNumberFieldLocator, cardNumber);
    }

    public void selectExpiryMonth(int index) {
        selectByIndexFromDropDown(expireMonthDropdownLocator, index);
    }

    public void selectExpiryYear(int index) {
        selectByIndexFromDropDown(expireYearDropdownLocator, index);
    }

    public void enterCardCode(String cardNumber) {
        sendTextToElement(cardCodeFieldLocator, cardNumber);
    }

    public void paymentContinueButton(){
        clickOnElement(continueButtonAfterCreditCardInfoLocator);
    }

}
