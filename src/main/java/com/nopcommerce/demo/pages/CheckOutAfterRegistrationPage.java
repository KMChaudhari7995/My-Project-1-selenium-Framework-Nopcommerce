package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class CheckOutAfterRegistrationPage extends Utility {
    By firstNameInputBox = By.xpath("//input[@id='BillingNewAddress_FirstName']"); // value "Micky"
    By lastNameInputBox = By.xpath("//input[@id='BillingNewAddress_LastName']"); // value "Mouse"
    By emailInputBox = By.xpath("//input[@id='BillingNewAddress_Email']"); // value "mickmouse0000@gmail.com"
    By countryDropDown = By.xpath("//select[@id='BillingNewAddress_CountryId']"); //value "233"
    By cityInputBox = By.xpath("//input[@id='BillingNewAddress_City']"); //value "Glasgow"
    By address1InputBox = By.xpath("//input[@id='BillingNewAddress_Address1']"); //value "10 Paris Street"
    By postalCodeInputBox = By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"); // value "GS10 2FC"
    By billingNewAddressPhoneNumber = By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"); // value "02022039384"
    By buttonContinueFromBillingAddress = By.xpath("//button[@onclick='Billing.save()']"); //button 1
    By radioButtonNextDayAir = By.xpath("//input[@id='shippingoption_1']");
    By buttonContinueFromShippingMethod = By.xpath("//button[@class='button-1 shipping-method-next-step-button']"); // button 2
    By radioButtonCreditCard = By.xpath("//input[@id='paymentmethod_1']");
    By buttonContinueFromPaymentMethod = By.xpath("//button[@class='button-1 payment-method-next-step-button']"); // button 3
    By dropDownSelectCard = By.xpath("//select[@id='CreditCardType']"); // value  "MasterCard"
    By cardHolderNameInputBox = By.xpath("//input[@id='CardholderName']");// value "Mr Micky"
    By cardNumberInputBox = By.xpath("//input[@id='CardNumber']"); // value "5105105105105100"
    By dropDownExpiryDateMonth = By.xpath("//select[@id='ExpireMonth']"); // "12"
    By dropDownExpiryDateYear = By.xpath("//select[@id='ExpireYear']"); // value "2023"
    By cardCodeInputBox = By.xpath("//input[@id='CardCode']"); // value "203"
    By buttonContinueFromPaymentInformation = By.xpath("//button[@class='button-1 payment-info-next-step-button']"); // button 4
    By actualTextOfCardMethod = By.xpath("//span[contains(text(),'Credit Card')]");
    By actualTextOfShippingMethod = By.xpath("//span[normalize-space()='2nd Day Air']");
    By actualTotalFinalPrice = By.xpath("//span[@class='product-subtotal']");
    By buttonConfirm = By.xpath("//button[normalize-space()='Confirm']"); // button confirm
    By radioButton2ndDayAir = By.xpath("(//input[@id='shippingoption_2'])[1]");


    /**
     * List of methods to perform actions using above locators variables
     */

    // Fill the all mandatory field

    public void firstName(String fName) {
        clearValue(firstNameInputBox);
        sendTextToElement(firstNameInputBox, fName);
    }

    public void lastName(String lName) {

        clearValue(lastNameInputBox);
        sendTextToElement(lastNameInputBox, lName);
    }

    public void email(String email) {

        clearValue(emailInputBox);
        sendTextToElement(emailInputBox, email);
    }

    public void selectCountryFromDropDown() {
        selectByIndexFromDropDown(countryDropDown, 2);
    }
    public void enterCity(String cityName){
        sendTextToElement(cityInputBox, cityName);
    }

    public void enterAddress(String address){
        sendTextToElement(address1InputBox,address );
    }

    public void enterPostCode(String postcode){
        sendTextToElement(postalCodeInputBox, postcode);
    }

    public void enterPhoneNumber(String phoneNumber){
        sendTextToElement(billingNewAddressPhoneNumber, phoneNumber);
    }

    public void clickContinue(){
        clickOnElement(buttonContinueFromBillingAddress);
    }


    //Click on Radio Button “Next Day Air($0.00)”
    public void clickOnRadioButtonNextDayAir(){
        clickOnElement(radioButtonNextDayAir);
    }

    //    2.25 Click on “CONTINUE”
    public void clickOnButtonContinueFromShippingMethod(){
        clickOnElement(buttonContinueFromShippingMethod);
    }

    //    2.26 Select Radio Button “Credit Card”
    public void clickOnRadioButtonCreditCard(){
        clickOnElement(radioButtonCreditCard);
    }

    // click on continue button --> button 2
    public void clickOnButtonContinueFromPaymentMethod(){
        clickOnElement(buttonContinueFromPaymentMethod);
    }

    //    2.27 Select “Master card” From Select credit card dropdown
    public void clickOnDropDownSelectCard(String visa){

        selectByValueFromDropDown(dropDownSelectCard, visa);
    }

    //    2.28 Fill all the details
    public void fillInCardHolderNameInputBox(String name){
        sendTextToElement(cardHolderNameInputBox, name);
    }

    // fill in card number
    public void fillInCardNumberInputBox(String cardNumber){

        sendTextToElement(cardNumberInputBox, cardNumber);
    }

    // select month
    public void selectDropDownExpiryDateMonth(String month){

        selectByValueFromDropDown(dropDownExpiryDateMonth, month);
    }

    // select year
    public void selectDropDownExpiryDateYear(String year){

        selectByValueFromDropDown(dropDownExpiryDateYear, year);
    }

    // fill in card code
    public void fillInCardCodeInputBox(String cardCode){

        sendTextToElement(cardCodeInputBox, cardCode);
    }

    //    2.29 Click on “CONTINUE” --> button 4
    public void clickOnButtonContinueFromPaymentInformation(){

        clickOnElement(buttonContinueFromPaymentInformation);
    }

    //    2.30 Verify “Payment Method” is “Credit Card”
    public String verifyActualTextOfCardMethod(){
        return getTextFromElement(actualTextOfCardMethod);
    }

    //    2.32 Verify “Shipping Method” is “Next Day Air”
    public String verifyActualTextOfShippingMethod(){
        return getTextFromElement(actualTextOfShippingMethod);
    }

    //    2.33 Verify Total is “$2,950.00”
    public String verifyActualTotalFinalPrice(){
        return getTextFromElement(actualTotalFinalPrice);
    }

    //    2.34 Click on “CONFIRM”
    public void clickOnButtonConfirm(){
        clickOnElement(buttonConfirm);
    }

    public void clickOnRadioButton2ndDayAir() throws InterruptedException {
        clickOnElement(radioButton2ndDayAir);
        Thread.sleep(1000);
    }
}
