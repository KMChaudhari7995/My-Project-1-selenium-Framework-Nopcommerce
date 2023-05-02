package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BuildYourOwnComputerPage extends Utility {

    By buildYourOwnComputerTitleLocator = By.xpath("//h2[@class='product-title']//a[normalize-space()='Build your own computer']");
    By processorDropdownLocator = By.cssSelector("#product_attribute_1");
    By ramDropdownLocator = By.cssSelector("#product_attribute_2");
    By hddRadioButtonLocator = By.cssSelector("#product_attribute_3_7");
    By osRadioButtonLocator = By.cssSelector("#product_attribute_4_9");
    By msOfficeCheckBoxLocator = By.cssSelector("#product_attribute_5_10");
    By totalCommanderCheckBoxLocator = By.cssSelector("#product_attribute_5_12");
    By priceTotalLocator = By.cssSelector("#price-value-1");
    By addToCartButton1Locator = By.xpath("//button[@id='add-to-cart-button-1']");
    By messageConfirmationLocator = By.cssSelector(".content");
    By crossToCloseLocator = By.xpath("//span[@title='Close']");

    public String getTextFromBuildYourOwnComputer() {
        return driver.findElement(buildYourOwnComputerTitleLocator).getText();
    }

    public void selectProcessor(){
        selectByIndexFromDropDown(processorDropdownLocator, 1);

    }
    public void selectRAM(){
        selectByIndexFromDropDown(ramDropdownLocator, 3);

    }
    public void selectHDD(){
        clickOnElement(hddRadioButtonLocator);
    }

    public void selectOS(){
        clickOnElement(osRadioButtonLocator);
    }

    public void selectMicrosoftOffice() {
        WebElement element = driver.findElement(msOfficeCheckBoxLocator);
        if (!element.isSelected()) {
            clickOnElement(msOfficeCheckBoxLocator);
        }
    }
    public void selectTotalCommander(){
        clickOnElement(totalCommanderCheckBoxLocator);
    }

    public String checkTotalPrice(){
        return driver.findElement(priceTotalLocator).getText();
    }

    public void addToCartButtonClick(){
        clickOnElement(addToCartButton1Locator);

    }

    public String shoppingCartMessage(){
        return driver.findElement(messageConfirmationLocator).getText();

    }

    public void crossBarClick(){
        clickOnElement(crossToCloseLocator);
    }



}
