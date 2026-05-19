package com.kristallball.Wrappers;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.kristallball.Utility.LoggerUtil;

public class Login {

    public  static void loging_in(WebDriver driver,String email, String password){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
         wait.until(ExpectedConditions.visibilityOfElementLocated
            (By.xpath("//div[contains(@class,' justify-center w-[300px] py-[10px]')]")));
        WebElement email_field= driver.findElement
            (By.xpath("//input[contains(@placeholder,'email')]"));
        email_field.sendKeys(email);
        WebElement password_field= driver.findElement
            (By.xpath("//input[contains(@placeholder,'password')]"));
        password_field.sendKeys(password);
        WebElement login_button= driver.findElement
            (By.xpath("//div[contains(@class,' justify-center w-[300px] py-[10px]')]"));
        login_button.click();
    }

    public static void message(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement message= driver.findElement
            (By.xpath("//div[text()='Invalid Credentials!']"));
        wait.until(ExpectedConditions.visibilityOf(message));
        Assert.assertTrue(message.isDisplayed(),
             "Invalid Credentials message is not displayed...");
        LoggerUtil.logStatus(
            "INFO",
             "Invalid Credentials message is displayed successfully...",
              "PASSED");
    }   
    
    
}
