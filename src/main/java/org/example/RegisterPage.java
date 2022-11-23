package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends Utils {
    public void verifyUserOnRegisterPage()
    {
        // driver.findElement(By.className("ico-register")).click(); //command to click on register button
        //driver.findElement(By.id("FirstName")).sendKeys("Jaydeep"); //Command to type first name
        typeText(By.id("FirstName"),"Jaydeep");
        //driver.findElement(By.id("LastName")).sendKeys("Paneliya"); //Command to type last name
        typeText(By.id("LastName"),"Paneliya");

//        Select selectDate = new Select(driver.findElement(By.name("DateOfBirthDay")));
//        selectDate.selectByIndex(1);
        selectByIndex(By.name("DateOfBirthDay"),10);


//        Select selectMonth = new Select(driver.findElement(By.name("DateOfBirthMonth")));
//        selectMonth.selectByVisibleText("December");
        selectByText(By.name("DateOfBirthMonth"), ("December"));

//        Select selectYear = new Select(driver.findElement(By.name("DateOfBirthYear")));
//        selectYear.selectByValue("2022");
        selectByValue(By.name("DateOfBirthYear"),"2022");

        driver.findElement(By.id("Email")).sendKeys("jaydeep"+getTimeStamp()+"@gmail.com"); //Command to type email
        //typeText(By.id("Email"),"jaydeep"+getTimeStamp()+"@gmail.com");

        //driver.findElement(By.id("Password")).sendKeys("Jaydeep123");//command to type password
        typeText(By.id("Password"),"Jaydeep123");

        driver.findElement(By.id("ConfirmPassword")).sendKeys("Jaydeep123"); //Command to retype password
        driver.findElement(By.id("register-button")).click(); //Command to click on register button

    }
}
