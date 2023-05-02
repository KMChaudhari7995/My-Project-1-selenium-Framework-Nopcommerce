package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DesktopPage extends Utility {

    By sortByPosition = By.xpath("//select[@id='products-orderby']");
    By productArrangement = By.xpath("//h2[@class='product-title']/a");
    By addToCart = By.xpath("//div[@class='details']//button[@type='button']");

    public void selectSortByPosition(String value) {
        selectByValueFromDropDown(sortByPosition, value);
    }


    public List<WebElement> returnListOfProductNamesElementsLocator() {
        List<WebElement> listOfElement = driver.findElements(productArrangement);
        return listOfElement;
    }


    public void addToCartClick() {
        clickOnElement(addToCart);
    }
}
