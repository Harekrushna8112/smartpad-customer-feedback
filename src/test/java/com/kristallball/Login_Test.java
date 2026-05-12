package com.kristallball;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login_Test {

    public  static void loging_in(WebDriver driver,String email, String password){
        WebElement email_field= driver.findElement(By.xpath("//input[contains(@placeholder,'email')]"));
        email_field.sendKeys(email);
        WebElement password_field= driver.findElement(By.xpath("//input[contains(@placeholder,'password')]"));
        password_field.sendKeys(password);
        WebElement login_button= driver.findElement(By.xpath("//div[contains(@class,' justify-center w-[300px] py-[10px]')]"));
        login_button.click();
    }
    
    
}
