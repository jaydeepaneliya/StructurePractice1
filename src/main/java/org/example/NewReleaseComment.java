package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class NewReleaseComment extends Utils{

    public void commentOnNewRelease(){
        String timestamp = new SimpleDateFormat("ddHHmmss").format(new java.util.Date()); //Stored object in string
        driver.findElement(By.className("enter-comment-title")).sendKeys("Satisfied");//Command to type title
        driver.findElement(By.className("enter-comment-text")).sendKeys("Your news seems accurate always."); //Command to type the comment
        driver.findElement(By.xpath("//button[@class=\"button-1 news-item-add-comment-button\"]")).click();//Command to click on the 'new comment' button
//        String message = driver.findElement(By.className("result")).getText();//Created variable to print the text from the website
//        System.out.println(message);//print out the message

    }

    public void verifyCommentAddedMessage(){
        String actualMessage = driver.findElement(By.xpath("//div[@class=\"result\"]")).getText();
        String expectedMessage = "News comment is successfully added.";
        Assert.assertEquals(actualMessage,expectedMessage, "Comment is not added successfully.");
    }

    public void verifyCommentAddedAtLast(){
        String title = driver.findElement(By.xpath("//strong[@class=\"comment-text\"]")).getText();
        List<WebElement> comments = driver.findElements(By.xpath("//div[@class=\"comment-title\"]"));
        List<String> listOfComments = new ArrayList<>();
        for (WebElement a : comments ){
            listOfComments.add(a.getText());
        }
        Assert.assertTrue(listOfComments.contains(title));
        String lastComment = listOfComments.get(listOfComments.size()-1);
        System.out.println(lastComment);
        Assert.assertEquals(lastComment,title, "Comments are not listed in correct order.");
    }
}
