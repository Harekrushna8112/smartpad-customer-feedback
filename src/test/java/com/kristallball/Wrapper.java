package com.kristallball;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Wrapper {


    public static void navigatetoWebsite(WebDriver driver, String url) throws InterruptedException{
        driver.get(url);
        Thread.sleep(3000);
    }
    

    public static void click(WebDriver driver, By locator) throws InterruptedException{
        WebElement element= driver.findElement(locator);
        element.click();
        Thread.sleep(3000);

    }

    public static void feedbackform(WebDriver driver,String name,String email,String feedback) throws InterruptedException{
        WebElement name_field= driver.findElement(By.xpath("//input[@placeholder='Type your name here...']"));
        name_field.sendKeys(name);
        Thread.sleep(2000);
        WebElement email_field= driver.findElement(By.xpath("//input[@placeholder='Type your email here...']"));
        email_field.sendKeys(email);
        Thread.sleep(2000);
        WebElement rating= driver.findElement(By.xpath("(//div[contains(@class,' bg-transparent')])[4]"));
        rating.click();
        Thread.sleep(2000);
        WebElement feedback_field= driver.findElement(By.xpath("//textarea[@placeholder='Type your comments here...']"));
        feedback_field.sendKeys(feedback);
        Thread.sleep(2000);
        WebElement submit_button= driver.findElement(By.xpath("//p[text()='Submit']"));
        submit_button.click();
        Thread.sleep(3000);
        WebElement text= driver.findElement(By.xpath("//div[text()='Your feedback has been recorded!']"));
        Assert.assertTrue(text.isDisplayed(), "Feedback form is not submitted...");

        System.out.println("Feedback form is submitted successfully...");
        
    }


    public static void incomplete_feedbackform(WebDriver driver,String name,String email,String feedback) throws InterruptedException{
        WebElement name_field= driver.findElement(By.xpath("//input[@placeholder='Type your name here...']"));
        name_field.sendKeys(name);
        Thread.sleep(2000);
        WebElement email_field= driver.findElement(By.xpath("//input[@placeholder='Type your email here...']"));
        email_field.sendKeys(email);
        Thread.sleep(2000);
        WebElement rating= driver.findElement(By.xpath("(//div[contains(@class,' bg-transparent')])[4]"));
        rating.click();
        Thread.sleep(2000);
        WebElement feedback_field= driver.findElement(By.xpath("//textarea[@placeholder='Type your comments here...']"));
        feedback_field.sendKeys(feedback);
        Thread.sleep(2000);
        WebElement submit_button= driver.findElement(By.xpath("//p[text()='Submit']"));
        submit_button.click();
        Thread.sleep(3000);
        WebElement text= driver.findElement(By.xpath("//div[@class='go3958317564']"));
        Assert.assertTrue(text.isDisplayed(), "Error message for incomplete feedback form is not displayed...");

        System.out.println("Error message for incomplete feedback form is displayed...");
        
        
    }

   
    public static void handle_age_popup(WebDriver driver){
        List<WebElement> popups = driver.findElements(By.xpath("//button[text()='Yes']"));
        if(popups.size() > 0){
            WebElement popup = popups.get(0);
            if(popup.isDisplayed()){
                System.out.println("Age Popup is displayed ...");
                popup.click();
            }
        }else{
            System.out.println("AgePopup is not displayed ...");
        }
    }

    public static void search_product(WebDriver driver, String product_name) throws InterruptedException{
        WebElement search_field= driver.findElement(By.xpath("//input[contains(@placeholder,'Search by product name...')]"));
        search_field.sendKeys(product_name);
        Thread.sleep(2000);
    }
    public static String get_product_name(WebDriver driver) throws InterruptedException{
        WebElement product_name= driver.findElement(By.xpath("//div[@class='flex flex-col items-center']/div/p"));
        String name= product_name.getText();
        System.out.println("Actual Product name is: " + name);
        return name;
    }

    public static int feedback_count(WebDriver driver) throws InterruptedException{
        WebElement feedback_count= driver.findElement(By.xpath("//span[@class='text-[#999] text-[11px]']"));
        String count_text= feedback_count.getText();
        count_text= count_text.replaceAll("\\D+", ""); // Remove non-digit characters
        int count= Integer.parseInt(count_text);
        System.out.println("Number of feedbacks for the product: " + count);
        return count;
    }


    
    
}
