package org.example;

import org.openqa.selenium.By;

public class RegisterPage extends Utils {
    public void verifyUserOnRegisterPage()
    {
        typeText(By.id("FirstName"),LoadProperty.getProperty("firstName"));
        typeText(By.id("LastName"),LoadProperty.getProperty("lastName"));

        selectByIndex(By.name("DateOfBirthDay"),10);


        selectByText(By.name("DateOfBirthMonth"), ("December"));

        selectByValue(By.name("DateOfBirthYear"),"2022");

        driver.findElement(By.id("Email")).sendKeys("jaydeep"+getTimeStamp()+"@gmail.com"); //Command to type email

        typeText(By.id("Password"),"Jaydeep123");

        driver.findElement(By.id("ConfirmPassword")).sendKeys("Jaydeep123"); //Command to retype password
        driver.findElement(By.id("register-button")).click(); //Command to click on register button

    }
}
