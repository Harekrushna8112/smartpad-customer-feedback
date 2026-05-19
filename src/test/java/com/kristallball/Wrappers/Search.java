package com.kristallball.Wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.kristallball.Utility.LoggerUtil;

public class Search {

    public static void search_product(WebDriver driver, String product_name) throws InterruptedException{
        WebElement search_field= driver.findElement(By.xpath("//input[contains(@placeholder,'Search by product name...')]"));
        search_field.sendKeys(product_name);
        Thread.sleep(3000);
    }
    public static String get_product_name(WebDriver driver) throws InterruptedException{
        WebElement product_name= driver.findElement(By.xpath("//div[@class='flex flex-col items-center']/div/p"));
        String name= product_name.getText();
        LoggerUtil.logStatus(
            "INFO",
             "Actual Product name is: " + name,
              "PASSED");
        return name;
    }
    
}
