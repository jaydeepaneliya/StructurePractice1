package org.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;

public class HomePage extends Utils {

    private By _registerButton = By.linkText("Register");
    private By _searchField = By.id("small-searchterms");
    private By _AppleMcBook = By.linkText("Apple MacBook Pro 13-inch");



    public void clickOnRegisterButton()
    {
        //clickOnElement(By.linkText("Register");
        clickOnElement(_registerButton);
    }

    public void clickOnMacBookPro(){
        clickOnElement(_AppleMcBook);
//        driver.findElement(By.linkText("Apple MacBook Pro 13-inch")).click();
//                "//img[@src=\"https://demo.nopcommerce.com/images/thumbs/0000024_apple-macbook-pro-13-inch_415.jpeg\"]")).click(); //Command to click on given link

    }

    public void printProductCategoriesList(){
        String category1 = driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[1]/a[1]")).getText();//created variable
        System.out.println(category1);//print out the category
        String category2 = driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[2]/a[1]")).getText();//created variable
        System.out.println(category2);//print out the category
        String category3 = driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[3]/a[1]")).getText();//created variable
        System.out.println(category3);//print out the category
        String category4 = driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[4]/a[1]")).getText();//created variable
        System.out.println(category4);//print out the category
        String category5 = driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[5]/a[1]")).getText();//created variable
        System.out.println(category5);//print out the category
        String category6 = driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[6]/a[1]")).getText();//created variable
        System.out.println(category6);//print out the category
        String category7 = driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[7]/a[1]")).getText();//created variable
        System.out.println(category7);//print out the category
    }

    public void clickOnNewsDetailsButton(){
        clickOnElement(By.xpath("//div[@class=\"buttons\"]/a[@href=\"/nopcommerce-new-release\"]"));
        //Click on details under nopcommerce new release
    }
    public void clickOnComputer() {
        clickOnElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[1]/a[1]"));
    }

    public void verifyRegisterButtonPresent()
    {
        Assert.assertEquals(getTextFromElement(By.className("ico-register")),"Register","Register button is not present");

    }

    public void navigateToElectronicsPage(){
        clickOnElement(By.linkText("Electronics")); //Click on electronics
    }

    public void checkDollarSymbol(){

        String actualMessage = driver.findElement(By.xpath("//span[@class=\"price actual-price\"]")).getText();
        Assert.assertTrue(actualMessage.startsWith("$"), "Currency selected is not US Dollar.");
    }

    public void selectEuroSymbol(){
        selectByText(By.xpath("//select[@id=\"customerCurrency\"]"), "Euro");
    }

    public void verifyEuroSymbolOnHomePage(){
        String actualMessage = driver.findElement(By.xpath("//span[contains(text(),'€1032.00')]")).getText();
        Assert.assertTrue(actualMessage.contains("Euro"),"Currency selected is not Euro.");
    }

    public void voteButton(){
        clickOnElement(By.xpath("//button[@id=\"vote-poll-1\"]"));
    }

    public void handleVoteAlert(){
        Alert alert = driver.switchTo().alert();

        driver.switchTo().alert().accept();
    }

    public void clickOnDetailsButtonInNewRelease(){
        clickOnElement(By.linkText("/nopcommerce-new-release"));
    }

    public void ClickOnFacebookSymbolAndThenComeBackToMainTab(){
        String MainWindow=driver.getWindowHandle();

        clickOnElement(By.linkText("Facebook"));

        // To handle all new opened window.
        Set<String> s1=driver.getWindowHandles();
        Iterator<String> i1=s1.iterator();

        while(i1.hasNext())
        {
            String ChildWindow=i1.next();

            if(!MainWindow.equalsIgnoreCase(ChildWindow))
            {

                // Switching to Child window
                driver.switchTo().window(ChildWindow);

                // Closing the Child Window.
                driver.close();
            }
        }
        // Switching to Parent window i.e Main Window.
        driver.switchTo().window(MainWindow);
    }


}
