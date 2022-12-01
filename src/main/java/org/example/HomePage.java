package org.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.Iterator;
import java.util.List;
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

    public void navigateToDesktopByMouseHovering(){
        // Locating the Main Menu (Parent element)
        WebElement mainMenu = driver.findElement(By.xpath("//a[@href=\"/computers\"]"));

    //Instantiating Actions class
        Actions actions = new Actions(driver);

    //Hovering on main menu
        actions.moveToElement(mainMenu);

    // Locating the element from Sub Menu
        WebElement subMenu = driver.findElement(By.xpath("//a[@href=\"/desktops\"]"));

    //To mouseover on sub menu
        actions.moveToElement(subMenu);

    //build()- used to compile all the actions into a single step
        actions.click().build().perform();
    }

    public void noticeChangeOfTheColor(){
        WebElement computerTab = driver.findElement(By.xpath("//a[@href=\"/computers\"]"));
        Actions actions = new Actions(driver);
//        actions.moveToElement(computerTab);

        Action mouseOverComputer = actions.moveToElement(computerTab).build();
//        mouseOverComputer
        String bgColor = computerTab.getCssValue("Color");
        System.out.println("Before hover:"+bgColor);

        mouseOverComputer.perform();

        bgColor = computerTab.getCssValue("background-color");
        System.out.println("After hover:"+bgColor);

    }

    public void searchBoxWorkingProperly(){
//        WebElement searchField = driver.findElement(By.id("id=\"small-searchterms\""));

//        searchField.click()
//        clickOnElement(By.id("id=\"small-searchterms\""));

        WebElement searchField =driver.findElement(By.xpath("//form[@id=\"small-search-box-form\"]"));
        Actions actions = new Actions(driver);
        Actions seriesOfActions = actions.moveToElement(searchField).click().sendKeys(searchField, "nike");
        seriesOfActions.perform();
        clickOnElement(By.xpath("//button[@type=\"submit\"]"));

        WebElement listOfSearchedProducts = driver.findElement(By.xpath("//h2"));






    }


}
