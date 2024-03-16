package com.tutorialsninja.tests;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class LoginTest {
    WebDriver driver;

    @Test(dataProvider = "credentials")
    public void loginTest(String caseName, String userName, String password) throws IOException, InterruptedException {
        driver = new ChromeDriver();
        FileInputStream file = new FileInputStream("D:\\testing\\projects\\tutorialsNinjaTesting\\src\\test\\java" +
                    "\\com\\tutorialsninja\\utils\\KeyWords.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        int rows = sheet.getLastRowNum();

        for(int row=1;row<=rows;row++){
            XSSFRow rowData = sheet.getRow(row);
            String currAction = rowData.getCell(1).toString();
            if(currAction.equals("openBrowser")){
                LoginTestActions.openBrowser(driver,"https://tutorialsninja.com/demo/index.php?route=account/login");
            }else if(currAction.equals("enterUsername")){
                LoginTestActions.enterUserName(driver,userName,"//*[@id=\"input-email\"]");
            }else if(currAction.equals("enterPassword")){
                LoginTestActions.enterPassword(driver,password,"//*[@id=\"input-password\"]");
            }else if(currAction.equals("clickLogin")){
                LoginTestActions.clickLogInButton(driver,"//*[@id=\"content\"]/div/div[2]/div/form/input");
            }else if(currAction.equals("fetchURL")){
                String expectedURL = "https://tutorialsninja.com/demo/index.php?route=account/account";
                String actualURL = LoginTestActions.testCaseValidation(driver);
                System.out.println("Case: "+caseName);
                System.out.println("User Name: "+userName);
                System.out.println("Password: "+password);
                System.out.println();
                Assert.assertEquals(actualURL, expectedURL);
            }
        }
        Thread.sleep(5000);
        driver.close();
        driver.quit();
    }

    @DataProvider(name = "credentials")
    public Object[][] credentialsDataProvider(){
        return new Object[][] {
                {"Both Correct", "lakshyakumarsirohi@gmail.com", "zfmUj2c@U@8p2r"},
                {"Both Wrong", "lks@gmail.com", "rrgghhc@U@8p2r"},
                {"Username Wrong","lks@gmail.com", "zfmUj2c@U@8p2r"},
                {"Password Wrong","lakshyakumarsirohi@gmail.com", "tttyyzz2c@U@8p2r"}
        };
    }
}
