package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends Utility {

    By welcomeToStoreLocator = By.xpath("//h2[normalize-space()='Welcome to our store']");
    By electronicMenuLocator = By.linkText("Electronics");
    By cellPhonesSubMenuLocator = By.linkText("Cell phones");

    public void selectMenu(String menu) {
        List<WebElement> listOfMenuElements = driver.findElements(By.xpath("//div[@class='header-menu']/ul[@class='top-menu notmobile']/li/a"));
        for (WebElement element : listOfMenuElements) {
            System.out.println(element.getText());

            if (element.getText().trim().equalsIgnoreCase(menu)) {
                element.click();
                break;
            }
        }
    }


    public String getTextFromWelcomeStore() {
        return getTextFromElement(welcomeToStoreLocator);
    }

    public void mouseHoverOnElectronics() {
        mouseHoverToElement(electronicMenuLocator);
    }

    public void mouseHoverAndClickOnCellPhone() {
        mouseHoverToElementAndClick(cellPhonesSubMenuLocator);
    }

}
