package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ElectronicsTest extends BaseTest {

    HomePage homePage = new HomePage();
    CellPhonePage cellPhonePage = new CellPhonePage();
    NokiaLumia1020Page nokiaLumia1020Page = new NokiaLumia1020Page();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    CheckOutPage checkOutPage = new CheckOutPage();
    RegisterPage registerPage = new RegisterPage();
    RegistrationSuccessfulPage registrationSuccessfulPage = new RegistrationSuccessfulPage();
    LoginPage loginPage = new LoginPage();
    CheckOutAfterRegistrationPage checkOutAfterRegistrationPage = new CheckOutAfterRegistrationPage();
    OrderCompletionPage orderCompletionPage = new OrderCompletionPage();


    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {

        //Mouse Hover on “Electronics” Tab
        homePage.mouseHoverOnElectronics();

        //Mouse Hover on “Cell phones” and click
        homePage.mouseHoverAndClickOnCellPhone();

        //Verify the text “Cell phones”
        String expectedMessage = "Cell phones";
        Assert.assertEquals(cellPhonePage.actualPageTitleTextOfCellPhonePage(), expectedMessage, "cell phone page title not matched");

    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {

        //Mouse Hover on “Electronics” Tab
        homePage.mouseHoverOnElectronics();

        //Mouse Hover on “Cell phones” and click
        homePage.mouseHoverAndClickOnCellPhone();

        //Verify the text “Cell phones”
        String expectedMessage = "Cell phones";
        Assert.assertEquals(cellPhonePage.actualPageTitleTextOfCellPhonePage(), expectedMessage, "cell phone page title not matched");

        //Click on List View Tab
        cellPhonePage.clickOnListViewIcon();

        //Click on product name “Nokia Lumia 1020” link
        Thread.sleep(4000);
        cellPhonePage.clickOnProductNokiaLumia1020();

        //Verify the text “Nokia Lumia 1020”
        String expectedTextOfNokiaLumia1020Page = "Nokia Lumia 1020";
        Assert.assertEquals(nokiaLumia1020Page.actualTitleTextOfProductNokiaLumia1020Page(), expectedTextOfNokiaLumia1020Page, "Nokia Lumia 1020 page title text not matched");

        //Verify the price “$349.00”
        String expectedPriceOfNokiaLumia1020 = "$349.00";
        Assert.assertEquals(nokiaLumia1020Page.actualPriceOfProductNokiaLumia1020(), expectedPriceOfNokiaLumia1020, "Price of nokia lumia 1020 not matched");

        //Change quantity to 2
        nokiaLumia1020Page.clearAnElementBeforeEnteringQty();
        nokiaLumia1020Page.updateTheQuantity("2");

        //Click on “ADD TO CART” tab
        nokiaLumia1020Page.clickOnButtonAddToCartFromPageNokiaLumia1020();

        //Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String expectedMessageOfProductBeingInShoppingCart = "The product has been added to your shopping cart";
        Assert.assertEquals(nokiaLumia1020Page.actualMessageOfProductBeingInShoppingCart(), expectedMessageOfProductBeingInShoppingCart, "message 'The product has been added to your shopping cart' not displayed");

        //After that close the bar clicking on the cross button.
        nokiaLumia1020Page.clickOnCrossFromMessage();

        //Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        nokiaLumia1020Page.hoverToShoppingCartAndClickOnAddToCart();

        //Verify the message "Shopping cart"
        String expectedShoppingCartTitleMessage = "Shopping cart";
        Assert.assertEquals(shoppingCartPage.getTextFromShoppingCart(), expectedShoppingCartTitleMessage, "Shopping cart title message not displayed");

        //Verify the quantity is 2
        Thread.sleep(2000);
        String expectedQty = "2";
        Assert.assertEquals(shoppingCartPage.verifyQuantity(), expectedQty, "Qty of Nokia lumia in shopping cart not matched");

        //Verify the Total $698.00
        String expectedTotalAmount = "$698.00";
        Assert.assertEquals(shoppingCartPage.getTextFromTotal(), expectedTotalAmount, "Total amount not matched");

        //click on checkbox “I agree with the terms of service”
        shoppingCartPage.checkBoxClick();

        //Click on “CHECKOUT”
        shoppingCartPage.clickCheckOut();

        //Verify the Text “Welcome, Please Sign In!”
        Assert.assertEquals(checkOutPage.getTextFromWelcomeText(), "Welcome, Please Sign In!", "Error message: not matching");
        Thread.sleep(5000);

        //Click on “REGISTER” tab
        checkOutPage.clickOnButtonRegister();

        //Verify the text “Register”
        String expectedPageTitleOfRegisterPage = "Register";
        Assert.assertEquals(registerPage.actualTitleTextOfRegisterPage(), expectedPageTitleOfRegisterPage, "Title of register page not matched");

        //Fill the mandatory fields
        //first name
        registerPage.fillInFirstName("Khushi");

        //last name
        registerPage.fillInLastName("Chaudhari");

        // email
        registerPage.fillInEmail();

        // password
        registerPage.fillInPassword("Password1");


        //confirm password
        registerPage.fillInConfirmPassword("Password1");

        //Click on “REGISTER” Button
        registerPage.clickOnButtonRegisterNextStep();
        Thread.sleep(3000);

        //Verify the message “Your registration completed”
        String expectedMessageOfSuccessfulRegistration = "Your registration completed";
        Assert.assertEquals(registrationSuccessfulPage.actualMessageOfSuccessfulRegistration(), expectedMessageOfSuccessfulRegistration, "Successful registration message not displayed");

        //Click on “CONTINUE” tab
        registrationSuccessfulPage.clickOnButtonContinue();

        //Verify the text “Shopping cart”
        Thread.sleep(3000);
        String expectedShoppingCartTitleMessage1 = "Shopping cart";
        Assert.assertEquals(shoppingCartPage.getTextFromShoppingCart(), expectedShoppingCartTitleMessage1, "Shopping cart title message not displayed");

        //click on Log in
        Thread.sleep(2000);
        loginPage.loginLink();

        //Email field
        loginPage.emailField(RegisterPage.generatedEmail);

        //password field
        loginPage.passwordField("Password1");

        //login button
        loginPage.clickOnLoginButton();

        //click on checkbox “I agree with the terms of service”
        shoppingCartPage.checkBoxClick();

        //Click on “CHECKOUT”
        shoppingCartPage.clickCheckOut();

        //Fill the Mandatory fields
        checkOutAfterRegistrationPage.firstName("Khushi");
        checkOutAfterRegistrationPage.lastName("Chaudhari");
        checkOutAfterRegistrationPage.email(RegisterPage.generatedEmail);
        checkOutAfterRegistrationPage.selectCountryFromDropDown();
        checkOutAfterRegistrationPage.enterCity("London");
        checkOutAfterRegistrationPage.enterAddress("Watford");
        checkOutAfterRegistrationPage.enterPostCode("WD17 ABC");
        checkOutAfterRegistrationPage.enterPhoneNumber("1234567890");

        //Click on “CONTINUE”
        Thread.sleep(2000);
        checkOutAfterRegistrationPage.clickContinue();

        //Click on Radio Button “2nd Day Air ($0.00)”
        checkOutAfterRegistrationPage.clickOnRadioButton2ndDayAir();

        //Click on “CONTINUE”
        checkOutAfterRegistrationPage.clickOnButtonContinueFromShippingMethod();

        //Select Radio Button “Credit Card”
        checkOutAfterRegistrationPage.clickOnRadioButtonCreditCard();

        // click on continue button --> button 2
        checkOutAfterRegistrationPage.clickOnButtonContinueFromPaymentMethod();

        //Select “Visa” From Select credit card dropdown
        checkOutAfterRegistrationPage.clickOnDropDownSelectCard("visa");

        //Fill all the details
        checkOutAfterRegistrationPage.fillInCardHolderNameInputBox("Miss Khushi");

        checkOutAfterRegistrationPage.fillInCardNumberInputBox("5105105105105100");

        checkOutAfterRegistrationPage.selectDropDownExpiryDateMonth("12");

        checkOutAfterRegistrationPage.selectDropDownExpiryDateYear("2023");

        checkOutAfterRegistrationPage.fillInCardCodeInputBox("203");

        //Click on “CONTINUE”
        checkOutAfterRegistrationPage.clickOnButtonContinueFromPaymentInformation();

        //Verify “Payment Method” is “Credit Card”
        String expectedTextOfCardMethod = "Credit Card";
        Assert.assertEquals(checkOutAfterRegistrationPage.verifyActualTextOfCardMethod(), expectedTextOfCardMethod, "Text of type of payment method not displayed");

        //Verify “Shipping Method” is “2nd Day Air”
        String expectedTextOfShippingMethod = "2nd Day Air";
        Assert.assertEquals(checkOutAfterRegistrationPage.verifyActualTextOfShippingMethod(), expectedTextOfShippingMethod, "Text of shipping method not displayed");

        //Verify Total is “$698.00”
        String expectedTotalFinalPrice = "$698.00";
        Assert.assertEquals(checkOutAfterRegistrationPage.verifyActualTotalFinalPrice(), expectedTotalFinalPrice, "total final price not displayed");

        //Click on “CONFIRM”
        checkOutAfterRegistrationPage.clickOnButtonConfirm();

        //Verify the Text “Thank You”
        String expectedPageTitleMessageAfterPayment = "Thank you";
        Assert.assertEquals(orderCompletionPage.getTextFromThankYouTitle(), expectedPageTitleMessageAfterPayment, "after payment page title not displayed");

        //Verify the message “Your order has been successfully processed!”
        String expectedOrderSuccessfulMessage = "Your order has been successfully processed!";
        Assert.assertEquals(orderCompletionPage.getTextFromOrderSuccessMessage(), expectedOrderSuccessfulMessage, "After payment successfull message not displayed");

        //Click on “CONTINUE”
        orderCompletionPage.clickOnContinueOrderCompletionButton();

        //Verify the text “Welcome to our store”
        String expectedTitleMessageOfHomePage = "Welcome to our store";
        Assert.assertEquals(homePage.getTextFromWelcomeStore(), expectedTitleMessageOfHomePage,"home page welcome message not displayed");

        //Click on “Logout” link
        clickOnElement(By.xpath("//a[normalize-space()='Log out']"));
        Thread.sleep(2000);

        //Verify the URL is “https://demo.nopcommerce.com/”
        String actualCurrentUrl = getCurrentUrlForVerification();
        String expectedCurrentUrl = "https://demo.nopcommerce.com/";
        Assert.assertEquals(actualCurrentUrl,expectedCurrentUrl, "Error message");


    }


}
