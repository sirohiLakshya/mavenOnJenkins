package com.tutorialsninja.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropDownMenuTest {

    @Test
    public void dropDownMenuTest(){
        WebDriver driver = new ChromeDriver();
        Actions action = new Actions(driver);
        driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");

        WebElement desktopTab = driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/a"));
        WebElement pcs = driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/div/div/ul/li[1]/a"));

        action.moveToElement(desktopTab).build().perform();
        action.moveToElement(desktopTab).click().build().perform();
        action.moveToElement(pcs).build().perform();
        action.moveToElement(pcs).click().build().perform();

        String expectedURL = driver.getCurrentUrl();
        String actualURL = "https://tutorialsninja.com/demo/index.php?route=product/category&path=20_26";
        Assert.assertEquals(expectedURL, actualURL);

        driver.quit();
    }

}
