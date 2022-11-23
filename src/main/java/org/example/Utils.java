package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;


public class Utils extends BasePage {

    public static void clickOnElement(By by) {
        driver.findElement(by).click();
    }
    public static void typeText(By by, String text){

        driver.findElement(by).sendKeys(text);
    }

    public static String getText(By by){

        return driver.findElement(by).getText();
    }

    public static String getTimeStamp(){
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
    }

    public static String getTextFromElement(By by){
        return driver.findElement(by).getText();
    }

    public static void waitForElementToBeClickable(By by, int timeInSeconds){
       WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeInSeconds));
       wait.until(ExpectedConditions.elementToBeClickable(by));
    }
//    public static void waitForElementToBeVisible(By by,int time)
//    {
//        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds());
//        wait.until(ExpectedConditions.)
//    }
    public static void waitForURLToBe(String url,int timeInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.urlToBe(url));
    }
    public static void selectByText(By by, String text)
    {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);

    }
    public static void selectByIndex(By by, int indexValue)
    {
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(indexValue);
    }
    public static void selectByValue(By by, String text)
    {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(text);
    }

    public static void captureScreenShot(){
    //Convert web driver object to take a screenshot
        TakesScreenshot srcShot = ((TakesScreenshot) driver);
        //Call getScreenshotAs method to create image file

        File SrcFile = srcShot.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination

        File DestFile = new File ("src/ScreenShots/" + getTimeStamp()+".jpg");
        //Copy file at destination

        try {
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
