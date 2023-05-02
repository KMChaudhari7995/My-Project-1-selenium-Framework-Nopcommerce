package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.By;

import java.util.Random;

public class RegisterPage extends Utility {

    public static String generatedEmail;

    By titleTextOfRegisterPage = By.xpath("//h1[contains(text(),'Register')]");
    By firstNameInputBox = By.xpath("//input[@id='FirstName']");
    By lastNameInputBox = By.xpath("//input[@id='LastName']");
    By emailInputBox = By.xpath("//input[@id='Email']");
    By passwordInputBox = By.xpath("//input[@id='Password']");
    By confirmPasswordInputBox = By.xpath("//input[@id='ConfirmPassword']");
    By buttonRegister = By.cssSelector(".button-1.register-next-step-button");


    public void fillInFirstName(String fName){

        sendTextToElement(firstNameInputBox, fName);
    }

    public void fillInLastName(String lName){
        sendTextToElement(lastNameInputBox, lName);
    }

    public void fillInEmail(){
        Random randomPartOfEmailGenerator = new Random(5000);
        int randomNumberInEmail = randomPartOfEmailGenerator.nextInt();
        //random string generator - to use in email
        RandomString randomString = new RandomString(5);
        String randomStringInEmailGenerator = randomString.nextString();
        generatedEmail = "mocky" + randomNumberInEmail + randomStringInEmailGenerator + "mouse@gmail.com";

        sendTextToElement(emailInputBox, generatedEmail);
    }
    public void fillInPassword(String password){

        sendTextToElement(passwordInputBox, password);
    }

    public void fillInConfirmPassword(String confirmPassword){

        sendTextToElement(confirmPasswordInputBox, confirmPassword);
    }

    public void clickOnButtonRegisterNextStep() throws InterruptedException {
        clickOnElement(buttonRegister);
        Thread.sleep(2000);
    }

    public String actualTitleTextOfRegisterPage(){
        return getTextFromElement(titleTextOfRegisterPage);
    }
}
