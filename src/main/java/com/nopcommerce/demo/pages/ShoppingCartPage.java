package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage extends Utility {

    By shoppingCartTitleLocator = By.xpath("//h1[normalize-space()='Shopping cart']");
    By qtyFieldLocator = By.xpath("//input[@class='qty-input']");
    By shoppingCartLocator = By.cssSelector(".cart-label");
    By goToCartButtonLocator = By.cssSelector(".button-1.cart-button");
    By totalPriceLocator = By.xpath("//tr[@class='order-total']//td[@class='cart-total-right']/span");
    By termsOfServiceCheckBoxLocator = By.cssSelector("#termsofservice");
    By checkoutButtonLocator = By.cssSelector("#checkout");
    By updateShoppingCartButtonLocator = By.cssSelector("#updatecart");
    By qtyField1Locator = By.className("qty-input");

    public String getTextFromShoppingCart(){
        return driver.findElement(shoppingCartTitleLocator).getText();
    }

    public void mouseHoverOnShoppingCart(){
        mouseHoverToElement(shoppingCartLocator);
    }

    public void clickOnGoToCart(){
        clickOnElement(goToCartButtonLocator);
    }
    public void updateTheQuantity(String qty) {
        sendTextToElement(qtyFieldLocator, qty);
    }

    public void clickUpdateCartButton(){

        clickOnElement(updateShoppingCartButtonLocator);
    }

    public void clearAnElementFromUpdatedShoppingCart() {
        WebElement element = driver.findElement(qtyFieldLocator);
        element.clear();
    }
    public String getTextFromTotal(){
        return driver.findElement(totalPriceLocator).getText();

    }
    public void checkBoxClick(){
        clickOnElement(termsOfServiceCheckBoxLocator);
    }

    public void clickCheckOut(){
        clickOnElement(checkoutButtonLocator);
    }


    public String verifyQuantity(){
        return driver.findElement(qtyField1Locator).getAttribute("value");

    }

}
