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

public class FormFilling {
     

     

    

public static void ratingform(WebDriver driver,String name,String email,int rating,String feedback) throws InterruptedException{
          WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Submit']")));
            if(rating <1 || rating >5){
                
                LoggerUtil.logStatus(
                    "ERROR", 
                    "Invalid rating value. Rating should be between 1 and 5.", 
                    "FAILED");
                return;
            }else{
                WebElement name_field= driver.findElement(By.xpath("//input[@placeholder='Type your name here...']"));
                name_field.sendKeys(name);
                // Thread.sleep(2000);
                WebElement email_field= driver.findElement(By.xpath("//input[@placeholder='Type your email here...']"));
                email_field.sendKeys(email);
                Thread.sleep(2000);
                // WebElement rating= driver.findElement(By.xpath("(//div[contains(@class,' bg-transparent')])[4]"));
                // rating.click();
                List<WebElement> ratings= driver.findElements(By.xpath("//p[contains(@class,'text-xl')]"));
                if(rating ==1){
                     ratings.get(0).click();
                }
                else if(rating ==2){
                     ratings.get(1).click();
                }
                else if(rating ==3){
                     ratings.get(2).click();
                }
                else if(rating ==4){
                     ratings.get(3).click();
                }
                else if(rating ==5){
                     ratings.get(4).click();
                }
                Thread.sleep(2000);
                WebElement feedback_field= driver.findElement(By.xpath("//textarea[@placeholder='Type your comments here...']"));
                feedback_field.sendKeys(feedback);
                Thread.sleep(2000);
                WebElement submit_button= driver.findElement(By.xpath("//p[text()='Submit']"));
                submit_button.click();
                Thread.sleep(3000);
                WebElement text= driver.findElement(By.xpath("//div[text()='Your feedback has been recorded!']"));
                Assert.assertTrue(text.isDisplayed(), "Feedback form is not submitted...");

                     LoggerUtil.logStatus(
                         "INFO", 
                         "Feedback form is submitted successfully...", 
                         "PASSED");
            }
       
        
    }

public static void incompleteRatingForm(WebDriver driver,String name,String email,int rating,String feedback) throws InterruptedException{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Submit']")));
            if(rating <1 || rating >5){
                    LoggerUtil.logStatus(
                         "ERROR", 
                         "Invalid rating value. Rating should be between 1 and 5.", 
                         "FAILED");
                return;
            }else{
                WebElement name_field= driver.findElement(By.xpath("//input[@placeholder='Type your name here...']"));
                name_field.sendKeys(name);
                Thread.sleep(2000);
                WebElement email_field= driver.findElement(By.xpath("//input[@placeholder='Type your email here...']"));
                email_field.sendKeys(email);
                List<WebElement> ratings= driver.findElements(By.xpath("//p[contains(@class,'text-xl')]"));
                if(rating ==1){
                     ratings.get(0).click();
                }
                else if(rating ==2){
                     ratings.get(1).click();
                }
                else if(rating ==3){
                     ratings.get(2).click();
                }
                else if(rating ==4){
                     ratings.get(3).click();
                }
                else if(rating ==5){
                     ratings.get(4).click();
                }
                WebElement feedback_field= driver.findElement(By.xpath("//textarea[@placeholder='Type your comments here...']"));
                feedback_field.sendKeys(feedback);
                Thread.sleep(2000);
                WebElement submit_button= driver.findElement(By.xpath("//p[text()='Submit']"));
                submit_button.click();
                Thread.sleep(3000);
                WebElement text= driver.findElement(By.xpath("//div[@class='go3958317564']"));
                Assert.assertTrue(text.isDisplayed(), "Error message for incomplete feedback form is not displayed...");

                LoggerUtil.logStatus(
                    "INFO", 
                    "Error message for incomplete feedback form is displayed...", 
                    "PASSED");
            }
    }

    public static int feedback_count(WebDriver driver) throws InterruptedException{
        WebElement feedback_count= driver.findElement(By.xpath("//span[@class='text-[#999] text-[11px]']"));
        String count_text= feedback_count.getText();
        count_text= count_text.replaceAll("\\D+", ""); // Remove non-digit characters
        int count= Integer.parseInt(count_text);
        
        LoggerUtil.logStatus(
            "INFO", 
            "Number of feedbacks for the product: " + count, 
            "PASSED");
        return count;
    }
    
}
