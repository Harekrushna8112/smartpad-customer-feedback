package com.kristallball.Wrappers;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.kristallball.Utility.LoggerUtil;


public class Product {
    

    public static void VerifyProductTypes(WebDriver driver) throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        
        WebElement text=driver.findElement(By.xpath("//h1[text()='What type of']"));
        Assert.assertTrue(text.isDisplayed(), "Text is not displayed...");
        LoggerUtil.logStatus(
            "INFO",
             "Text is displayed...",
              "PASSED");
        List<WebElement> productTypes= driver.findElements
             (By.xpath("//a[@class='rounded-[15px]']"));
        wait.until(ExpectedConditions.visibilityOfAllElements(productTypes));
        
        Assert.assertTrue(!productTypes.isEmpty(),
             "Product types are not displaying...");
        LoggerUtil.logStatus(
            "INFO",
             "Found " + productTypes.size() + " products.",
              "PASSED");

    }
    public static void prodyctTypes(WebDriver driver,String productName) throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        
        List<WebElement> productTypes= driver.findElements
             (By.xpath("//a[@class='rounded-[15px]']"));
        wait.until(ExpectedConditions.visibilityOfAllElements(productTypes));
        for(WebElement productType: productTypes){
            if(productType.getText().equalsIgnoreCase(productName)){
                Assert.assertTrue(productType.isDisplayed(), "Product " + productName + " is not displayed...");
                productType.click();

                LoggerUtil.logStatus(
                    "INFO",
                     "Product " + productName + " is found.",
                      "PASSED");
                return;
            }else{
                LoggerUtil.logStatus(
                    "INFO",
                     "Product " + productName + " is not found in this iteration...",
                      "PASSED");
            }
        }       

    }
    public static void clickOnProduct(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated
            (By.xpath("(//div[contains(@class,'0 justify-between')])[3]")));
        WebElement product= driver.findElement
             (By.xpath("(//div[contains(@class,'0 justify-between')])[3]"));
        wait.until(ExpectedConditions.elementToBeClickable
            (By.xpath("(//div[contains(@class,'0 justify-between')])[3]")));
        
        product.click();

    }
    public static void searchProduct(WebDriver driver) throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'0 justify-between')]")));
            
        WebElement product= driver.findElement
             (By.xpath("//div[contains(@class,'0 justify-between')]"));
        
        product.click();
        Thread.sleep(1000);

    }

    public static void clickOnShareFeedback(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//p[text()='Share Feedback']")));
        WebElement shareFeedback= driver.findElement
             (By.xpath("//p[text()='Share Feedback']"));
        
        shareFeedback.click();

    }
    
}
