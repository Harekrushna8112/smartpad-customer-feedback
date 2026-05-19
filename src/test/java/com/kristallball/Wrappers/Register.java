package com.kristallball.Wrappers;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.kristallball.Utility.LoggerUtil;

public class Register {
    

    public static void  registering(WebDriver driver, String name, String email, String password)throws InterruptedException{
        
        WebDriverWait waits= new WebDriverWait(driver, Duration.ofSeconds(10));
        waits.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//input[contains(@placeholder,'name')]")));
        
            WebElement name_field= driver.findElement
                (By.xpath("//input[contains(@placeholder,'name')]"));
            name_field.sendKeys(name);
        
            WebElement email_field= driver.findElement
                (By.xpath("//input[contains(@placeholder,'email')]"));
            email_field.sendKeys(email);
        
            WebElement password_field= driver.findElement
                (By.xpath("(//input[contains(@placeholder,'password')])[1]"));
            password_field.sendKeys(password);
        
            WebElement confirm_password_field= driver.findElement
                (By.xpath("(//input[contains(@placeholder,'password')])[2]"));
            confirm_password_field.sendKeys(password);
        
            WebElement privacy_checkbox= driver.findElement
                (By.xpath("//div[contains(@class,'items-center select-none mt-5')]/input"));
            privacy_checkbox.click();
       
            WebElement register_button= driver.findElement
                (By.xpath("//div[contains(@class,' justify-center w-[300px] py-[10px]')]"));
            register_button.click();
        
    }

    public static void Validate_WrongOTP(WebDriver driver, String otp)throws InterruptedException{
        if(!otp.matches("\\d{6}")){
            LoggerUtil.logStatus(
                "ERROR", 
                "Invalid OTP format. OTP should be a 6-digit number.", 
                "FAILED");
            return;
        }
        WebElement otp_field= driver.findElement(By.xpath("//input[contains(@placeholder,'OTP')]"));
        otp_field.sendKeys(otp);
        
        WebElement verify_button= driver.findElement(By.xpath("//div[contains(@class,' justify-center w-[300px] py-[10px]')]"));
        verify_button.click();
        
        WebElement error_message= driver.findElement(By.xpath("//div[text()='Incorrect OTP. Please enter the correct one!']"));
        Assert.assertTrue(error_message.isDisplayed(), "Error message for incorrect OTP is not displayed...");
        LoggerUtil.logStatus(
            "INFO",
             "Wrong OTP test is passed...",
              "PASSED");


    }
    public static void clickRegister(WebDriver driver){
        WebDriverWait waits= new WebDriverWait(driver, Duration.ofSeconds(10));
        waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='text-[13px]']")));
        WebElement dontHaveAccount = driver.findElement
            (By.xpath("//div[@class='text-[13px]']"));
            dontHaveAccount.click();
    }
    
    
}
