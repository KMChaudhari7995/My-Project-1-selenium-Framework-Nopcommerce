package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CellPhonePage extends Utility {
    By cellPhoneTitleLocator = By.xpath("//h1[normalize-space()='Cell phones']");
    By ListViewIcon = By.xpath("//a[contains(text(),'List')]");


    public String actualPageTitleTextOfCellPhonePage() {
        return getTextFromElement(cellPhoneTitleLocator);
    }

    public void clickOnListViewIcon()  {
        clickOnElement(ListViewIcon);

    }
    public void clickOnProductNokiaLumia1020()  {
        List<WebElement> mobileTitlesList = driver.findElements(By.xpath("//h2[@class='product-title']/a"));
        for (WebElement element : mobileTitlesList) {
            if (element.getText().contains("Nokia")) {
                element.click();
                break;
            }
        }
    }

}
