package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class CheckOutPage extends Utility {
    By welcomeSignInPageTitleLocator = By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']");
    By checkoutAsGuestButtonLocator = By.cssSelector(".button-1.checkout-as-guest-button");
    By firstNameFieldLocator = By.cssSelector("#BillingNewAddress_FirstName");
    By lastNameFieldLocator = By.cssSelector("#BillingNewAddress_LastName");
    By emailFieldLocator = By.cssSelector("#BillingNewAddress_Email");
    By countryDropDownLocator = By.cssSelector("#BillingNewAddress_CountryId");
    By cityFieldLocator = By.cssSelector("#BillingNewAddress_City");
    By addressFieldLocator = By.cssSelector("#BillingNewAddress_Address1");
    By postCodeFieldLocator = By.cssSelector("#BillingNewAddress_ZipPostalCode");
    By phoneNumberFieldLocator = By.cssSelector("#BillingNewAddress_PhoneNumber");
    By continueButtonLocator = By.name("save");
    //By ButtonRegister = By.cssSelector(".button-1.register-button");
    By ButtonRegister = By.linkText("Register");

    public String getTextFromWelcomeText() {
        return driver.findElement(welcomeSignInPageTitleLocator).getText();
    }

    public void clickCheckOut() {
        clickOnElement(checkoutAsGuestButtonLocator);
    }

    public void firstName(String fName) {
        sendTextToElement(firstNameFieldLocator, fName);
    }

    public void lastName(String lName) {
        sendTextToElement(lastNameFieldLocator, lName);
    }

    public void email(String email) {
        sendTextToElement(emailFieldLocator, email);
    }

    public void selectCountryFromDropDown() {
        selectByIndexFromDropDown(countryDropDownLocator, 2);

    }
    public void enterCity(String cityName){
        sendTextToElement(cityFieldLocator, cityName);
    }

    public void enterAddress(String address){
        sendTextToElement(addressFieldLocator,address );
    }

    public void enterPostCode(String postcode){
        sendTextToElement(postCodeFieldLocator, postcode);
    }

    public void enterPhoneNumber(String phoneNumber){
        sendTextToElement(phoneNumberFieldLocator, phoneNumber);
    }

    public void clickContinue(){
        clickOnElement(continueButtonLocator);
    }

    public void clickOnButtonRegister() throws InterruptedException {
        clickOnElement(ButtonRegister);
        Thread.sleep(1000);
    }
}
