package com.nextbasecrm.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ClickAndVerifyRadio {
    public static void clickAndVerifyRadioButton(WebDriver driver, String nameAttribute, String IDValue){
        List<WebElement> radioButtons  = driver.findElements(By.name(nameAttribute));

        for (WebElement each : radioButtons) {
            String eachID = each.getAttribute("id");
            if (eachID.equals(IDValue)){
                each.click();
                System.out.println(eachID + " is selected :" + each.isSelected());
                break;
            }
        }


    }
}
