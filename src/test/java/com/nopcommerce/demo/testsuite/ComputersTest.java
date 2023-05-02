package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;

public class ComputersTest extends BaseTest {

    ComputerPage computerPage = new ComputerPage();
    HomePage homePage = new HomePage();
    DesktopPage desktopPage = new DesktopPage();
    BuildYourOwnComputerPage buildYourOwnComputerPage = new BuildYourOwnComputerPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    CheckOutPage checkOutPage = new CheckOutPage();
    ShippingPage shippingPage = new ShippingPage();
    PaymentPage paymentPage = new PaymentPage();
    OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage();
    OrderCompletionPage orderCompletionPage = new OrderCompletionPage();

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() throws InterruptedException {
        //Click on Computer Menu
        homePage.selectMenu("Computers");

        //Click on Desktop
        computerPage.desktopClick();

        //Select Sort By position "Name: Z to A"
        desktopPage.selectSortByPosition("6");
        Thread.sleep(2000);

        //Verify the Product will arrange in Descending order.
        ArrayList<String> actualList = getArrayListOfStringsFromWebElements(desktopPage.returnListOfProductNamesElementsLocator());
        System.out.println("actual list: " + actualList);
        ArrayList<String> expectedList = getArrayListOfStringsFromWebElements(desktopPage.returnListOfProductNamesElementsLocator());

        Collections.sort(expectedList);
        Collections.reverse(expectedList);

        System.out.println("expected= " + expectedList);
        Assert.assertEquals(actualList, expectedList, "Error message: Products are not arranged in descending order");


    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //Click on Computer Menu.
        homePage.selectMenu("Computers");

        //Click on Desktop
        computerPage.desktopClick();

        //Select Sort By position "Name: A to Z"
        desktopPage.selectSortByPosition("5");
        Thread.sleep(2000);

        //Click on "Add To Cart"
        desktopPage.addToCartClick();

        //Verify the Text "Build your own computer"
        String actualMessage = buildYourOwnComputerPage.getTextFromBuildYourOwnComputer();
        String expectedMessage = "Build your own computer";
        Assert.assertEquals(actualMessage, expectedMessage, "Error message: Text verification is failed");

        //Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        buildYourOwnComputerPage.selectProcessor();

        //Select "8GB [+$60.00]" using Select class.
        buildYourOwnComputerPage.selectRAM();

        //Select HDD radio "400 GB [+$100.00]"
        buildYourOwnComputerPage.selectHDD();

        //Select OS radio "Vista Premium [+$60.00]"
        buildYourOwnComputerPage.selectOS();

        //Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        buildYourOwnComputerPage.selectMicrosoftOffice();
        buildYourOwnComputerPage.selectTotalCommander();

        //Verify the price "$1,315.00"
        String actualPrice = buildYourOwnComputerPage.checkTotalPrice();
        String expectedPrice = "$1,300.00";
        Assert.assertEquals(actualPrice, expectedPrice, "Error message: Price is not matching ");

        //Click on "ADD TO CARD" Button.
        Thread.sleep(2000);
        buildYourOwnComputerPage.addToCartButtonClick();

        //Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String actualShoppingCartMessage = buildYourOwnComputerPage.shoppingCartMessage();
        String expectedShoppingCartMessage = "The product has been added to your shopping cart";
        Assert.assertEquals(actualShoppingCartMessage, expectedShoppingCartMessage, "Error message:message is not matching ");

        // After that close the bar clicking on the cross button.
        buildYourOwnComputerPage.crossBarClick();

        //Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        shoppingCartPage.mouseHoverOnShoppingCart();
        shoppingCartPage.clickOnGoToCart();

        // Verify the message "Shopping cart"
        String expected = "Shopping cart";
        String actual = shoppingCartPage.getTextFromShoppingCart();
        Assert.assertEquals(actual, expected, "Shopping cart");

        //Change the Qty to "2" and Click on "Update shopping cart"
        shoppingCartPage.clearAnElementFromUpdatedShoppingCart();
        Thread.sleep(1000);
        shoppingCartPage.updateTheQuantity("2");
        Thread.sleep(2000);
        shoppingCartPage.clickUpdateCartButton();


        //Verify the Total"$2,630.00"
        String actualTotal = shoppingCartPage.getTextFromTotal();
        String expectedTotal = "$2,950.00";
        Assert.assertEquals(actualTotal, expectedTotal, "Error message: Total is not matching");

        //click on checkbox “I agree with the terms of service”
        shoppingCartPage.checkBoxClick();

        //Click on “CHECKOUT”
        shoppingCartPage.clickCheckOut();

        // Verify the Text “Welcome, Please Sign In!”
        String actualWelcomeText = checkOutPage.getTextFromWelcomeText();
        String expectedWelcomeText = "Welcome, Please Sign In!";
        Assert.assertEquals(actualWelcomeText, expectedWelcomeText, "Error message: Welcome text is not matching");

        //Click on “CHECKOUT AS GUEST”Tab
        checkOutPage.clickCheckOut();

        // Fill the all mandatory field-firstname
        checkOutPage.firstName("Khushi");

        // last name
        checkOutPage.lastName("Chaudhari");

        // email
        checkOutPage.email("XYZ@gmail.com");

        // country drop down
        checkOutPage.selectCountryFromDropDown();

        // city
        checkOutPage.enterCity("London");
        // address 1
        checkOutPage.enterAddress("Random Street");
        // post code
        checkOutPage.enterPostCode("WD17 ABC");
        // phone number
        checkOutPage.enterPhoneNumber("0777777777");

        // Click on “CONTINUE”
        checkOutPage.clickContinue();

        //Click on Radio Button “Next Day Air($0.00)”
        shippingPage.shippingMethod();

        //Click on “CONTINUE”
        shippingPage.shippingMethodContinueButton();

        //Select Radio Button “Credit Card”
        paymentPage.selectCreditCardRadioButton();

        //click on continue button
        paymentPage.continuePaymentButton();

        //Select “Master card” From Select credit card dropdown
        paymentPage.selectCreditCard(2);

        //cardholder name
        paymentPage.cardHolderName("Miss Khushi");

        // card number
        paymentPage.cardNumber("5425233430109903");

        //expiry month drop down
        paymentPage.selectExpiryMonth(1);

        //expiry year drop down
        paymentPage.selectExpiryYear(3);

        //card code
        paymentPage.enterCardCode("123");

        //Click on “CONTINUE”
        paymentPage.paymentContinueButton();

        //Verify “Payment Method” is “Credit Card”
        String actualPaymentMethodText = orderConfirmationPage.getTextFromPaymentMethod();
        String expectedPaymentMethodText = "Credit Card";
        Assert.assertEquals(actualPaymentMethodText, expectedPaymentMethodText, "Error message: payment method text is not matching");

        //Verify “Shipping Method” is “Next Day Air”
        String actualShippingMethodText = orderConfirmationPage.getTextFromShippingMethod();
        String expectedShippingMethodText = "Next Day Air";
        Assert.assertEquals(actualShippingMethodText, expectedShippingMethodText, "Error message: shipping method text is not matching");

        //Verify Total is “$2,980.00”
        String actualTotalText = orderConfirmationPage.getTextFromTotalPrice();
        String expectedTotalText = "$2,950.00";
        Assert.assertEquals(actualTotalText, expectedTotalText, "Error message: total price text is not matching");

        //Click on “CONFIRM”
        orderConfirmationPage.clickConfirmButton();

        //Verify the Text “Thank You”
        String actualThankMessage = orderCompletionPage.getTextFromThankYouTitle();
        String expectedThankMessage = "Thank you";
        Assert.assertEquals(actualThankMessage, expectedThankMessage, "Error message");

        //Verify the message “Your order has been successfully processed!”
        String actualOrderSuccess = orderCompletionPage.getTextFromOrderSuccessMessage();
        String expectedOrderSuccess = "Your order has been successfully processed!";
        Assert.assertEquals(actualOrderSuccess, expectedOrderSuccess, "Error message");

        //Click on “CONTINUE”
        orderCompletionPage.clickOnContinueOrderCompletionButton();

        //Verify the text “Welcome to our store
        String actual1 = homePage.getTextFromWelcomeStore();
        String expected1 = "Welcome to our store";
        Assert.assertEquals(actual1, expected1, "Error message");


    }


}
