package org.example;

import org.openqa.selenium.By;

public class AppleMacBook extends Utils {

    private By _emailAFriendButton = By.xpath("//button[@class=\'button-2 email-a-friend-button\']");

    public void clickOnEMailAFriend(){
        clickOnElement(_emailAFriendButton); //Command to click on 'Email to friend Button'
    }



}
