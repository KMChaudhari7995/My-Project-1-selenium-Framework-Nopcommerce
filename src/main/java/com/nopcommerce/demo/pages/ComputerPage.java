package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class ComputerPage extends Utility {

    By desktop = By.xpath("//a[@title='Show products in category Desktops'][normalize-space()='Desktops']");
    By sortDesktopsPage = By.xpath("//select[@id='products-orderby']");
    public void desktopClick() {
        clickOnElement(desktop);
    }

}
