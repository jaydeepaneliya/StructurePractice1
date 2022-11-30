package org.example;

import org.openqa.selenium.By;

public class Computers extends Utils {

    private By _desktop = By.linkText("Desktops");

    public void clickOnDesktop() {
        clickOnElement(_desktop);
    }

}
