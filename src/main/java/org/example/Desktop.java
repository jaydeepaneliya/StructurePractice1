package org.example;

import org.openqa.selenium.By;

public class Desktop extends Utils {

    private By _buildYourOwnComputer = By.linkText("Build your own computer");
    private By _digitalStormVanquish = By.linkText("Digital Storm VANQUISH 3 Custom Performance PC");
    private By _lenovoIdeaCentre = By.linkText("Lenovo IdeaCentre 600 All-in-One PC");

    public void productLists(){
        String product1 = getText(_buildYourOwnComputer); //command to store text
//                getText(By.xpath("//h2[1]/a[@href=\"/build-your-own-computer\"]"));
//                driver.findElement(By.xpath("//h2[1]/a[@href=\"/build-your-own-computer\"]")).getText();

        System.out.println(product1); //printing product1

        String product2 = getText(_digitalStormVanquish); //command to store text
//                getText(By.xpath("//div/h2/a[@href=\"/digital-storm-vanquish-3-custom-performance-pc\"]"));
//                driver.findElement(By.xpath("//div/h2/a[@href=\"/digital-storm-vanquish-3-custom-performance-pc\"]")).getText();

        System.out.println(product2); //printing product2

        String product3 = getText(_lenovoIdeaCentre); //command to store text
//                getText(By.xpath("//div/h2/a[@href=\"/lenovo-ideacentre-600-all-in-one-pc\"]"));
//                driver.findElement(By.xpath("//div/h2/a[@href=\"/lenovo-ideacentre-600-all-in-one-pc\"]")).getText();

        System.out.println(product3); //printing product3

    }


}
