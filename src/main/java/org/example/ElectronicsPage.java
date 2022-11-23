package org.example;

import org.openqa.selenium.By;

public class ElectronicsPage extends Utils{

    public void navigateToCameraAndPhoto(){
        clickOnElement(By.linkText("Camera & photo"));
    }
}
