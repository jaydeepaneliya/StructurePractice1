package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class ProductEmailAFriend extends Utils {


    public void friendEmailDetails(){
        driver.findElement(By.id("FriendEmail")).sendKeys("abc@gmail.com"); //Command to type email of friend
        driver.findElement(By.id("YourEmailAddress")).sendKeys("xyz@gmail.com");//Command to type my email address
        driver.findElement(By.id("PersonalMessage")).sendKeys("Hi, ABC!"); //Command to write personal message in message box
        driver.findElement(By.xpath("//button[@name=\"send-email\"]")).click();//Command to click on send email button
//        String errormsg = driver.findElement(By.xpath("//div[@class=\"message-error validation-summary-errors\"]/ul[1]/li[1]")).getText();
//        System.out.println(errormsg);//printing error texts from the website
        String expectedMessage = "Your registration completed";
        String actualMessage = driver.findElement(By.xpath("//div[@class=\"message-error validation-summary-errors\"]//li")).getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Registration message does not match");
    }

}