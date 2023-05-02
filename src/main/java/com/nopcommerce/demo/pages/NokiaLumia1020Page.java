package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NokiaLumia1020Page extends Utility {


    By TitleTextOfProductNokiaLumia1020Page = By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]");
    By PriceOfProductNokiaLumia1020 = By.xpath("//span[@id='price-value-20']");
    By QtyProductNokiaLumia1020 = By.xpath("(//input[@id='product_enteredQuantity_20'])[1]");
    By ButtonAddToCartFromPageNokiaLumia1020 = By.xpath("(//button[@id='add-to-cart-button-20'])[1]");
    By MessageOfProductBeingInShoppingCart = By.xpath("//p[@class='content']");
    By CrossFromMessage = By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]");
    By ShoppingCartLinkFromNokiaLumia1020Page = By.xpath("//span[contains(text(),'Shopping cart')]");


    public String actualTitleTextOfProductNokiaLumia1020Page() {
        return getTextFromElement(TitleTextOfProductNokiaLumia1020Page);
    }

    public String actualPriceOfProductNokiaLumia1020() {
        return getTextFromElement(PriceOfProductNokiaLumia1020);
    }

    public void clearAnElementBeforeEnteringQty() {
        WebElement element = driver.findElement(QtyProductNokiaLumia1020);
        element.clear();
    }

    public void updateTheQuantity(String qty) {
        sendTextToElement(QtyProductNokiaLumia1020, qty);
    }

    public void clickOnButtonAddToCartFromPageNokiaLumia1020() throws InterruptedException {
        clickOnElement(ButtonAddToCartFromPageNokiaLumia1020);
        Thread.sleep(1000);
    }

    public String actualMessageOfProductBeingInShoppingCart() throws InterruptedException {
        return getTextFromElement(MessageOfProductBeingInShoppingCart);
    }

    public void clickOnCrossFromMessage() throws InterruptedException {
        clickOnElement(CrossFromMessage);
        Thread.sleep(1000);
    }

    public void hoverToShoppingCartAndClickOnAddToCart() throws InterruptedException {
        mouseHoverToElementAndClick(ShoppingCartLinkFromNokiaLumia1020Page);
        Thread.sleep(2000);
    }
}
