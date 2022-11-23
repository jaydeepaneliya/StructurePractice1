package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CameraAndPhoto extends Utils{

    public void getProductsName(){
        List<WebElement> productsNamesList = driver.findElements(By.xpath("//h2[@class=\"product-title\"]"));

        for (WebElement p : productsNamesList){
            System.out.println(p.getText());
        }
    }

}
