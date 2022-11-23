package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class RegistrationResultPage extends Utils {

    private By _registrationSuccessfulText = By.className("result");

    public void verifyUserRegisterSuccessfully() {

        //Assert result verification
        String expectedMessage = "Your registration completed";
        String actualMessage = driver.findElement(_registrationSuccessfulText).getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Regitration message does not match");

    }

}
