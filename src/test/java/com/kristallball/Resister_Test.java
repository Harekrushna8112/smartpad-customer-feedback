package com.kristallball;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Resister_Test {

    public static void  registering(WebDriver driver, String name, String email, String password)throws InterruptedException{
        Thread.sleep(2000);
        WebElement name_field= driver.findElement(By.xpath("//input[contains(@placeholder,'name')]"));
        name_field.sendKeys(name);
        Thread.sleep(2000);
        WebElement email_field= driver.findElement(By.xpath("//input[contains(@placeholder,'email')]"));
        email_field.sendKeys(email);
        Thread.sleep(2000);
        WebElement password_field= driver.findElement(By.xpath("(//input[contains(@placeholder,'password')])[1]"));
        password_field.sendKeys(password);
        Thread.sleep(2000);
        WebElement confirm_password_field= driver.findElement(By.xpath("(//input[contains(@placeholder,'password')])[2]"));
        confirm_password_field.sendKeys(password);
        Thread.sleep(2000);
        WebElement privacy_checkbox= driver.findElement(By.xpath("//div[contains(@class,'items-center select-none mt-5')]/input"));
        privacy_checkbox.click();
        Thread.sleep(2000);
        WebElement register_button= driver.findElement(By.xpath("//div[contains(@class,' justify-center w-[300px] py-[10px]')]"));
        register_button.click();
    }

    public static void Validate_WrongOTP(WebDriver driver, String otp)throws InterruptedException{
        if(!otp.matches("\\d{6}")){
            System.out.println("Invalid OTP format. OTP should be a 6-digit number.");
            return;
        }
        WebElement otp_field= driver.findElement(By.xpath("//input[contains(@placeholder,'OTP')]"));
        otp_field.sendKeys(otp);
        Thread.sleep(2000);
        WebElement verify_button= driver.findElement(By.xpath("//div[contains(@class,' justify-center w-[300px] py-[10px]')]"));
        verify_button.click();
        Thread.sleep(2000);
        WebElement error_message= driver.findElement(By.xpath("//div[text()='Incorrect OTP. Please enter the correct one!']"));
        Assert.assertTrue(error_message.isDisplayed(), "Error message for incorrect OTP is not displayed...");
        System.out.println("Wrong OTP test is passed...");


    }
    
    
}
