package com.tutorialsninja.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginTestActions {
    public static void openBrowser(WebDriver driver, String url){
        driver.get(url);
    }

    public static void enterUserName(WebDriver driver, String userName, String xpathOfUserNameInputBox){
        WebElement userNameTextBox = driver.findElement(By.xpath(xpathOfUserNameInputBox));
        userNameTextBox.sendKeys(userName);
    }

    public static void enterPassword(WebDriver driver, String password, String xpathOfPasswordInputBox){
        WebElement passwordTextBox = driver.findElement(By.xpath(xpathOfPasswordInputBox));
        passwordTextBox.sendKeys(password);
    }

    public static void clickLogInButton(WebDriver driver, String xpathOfLoginButton){
        WebElement loginButton = driver.findElement(By.xpath(xpathOfLoginButton));
        loginButton.click();
    }

    public static String testCaseValidation(WebDriver driver){
        String actualPageURL = driver.getCurrentUrl();
        return actualPageURL;
    }

}
