package com.kristallball.Wrappers;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.kristallball.Utility.LoggerUtil;



public class HomePage {

    public static void homePage(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://smartpad-customer-feedback.vercel.app/");
        wait.until(ExpectedConditions.visibilityOfElementLocated
            (By.xpath("//div[text()='Get started']")));
        driver.findElement(By.xpath("//div[text()='Get started']")).isDisplayed();
        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Get started']")).isDisplayed(),
            "Get Started button is not displayed");
        driver.findElement(By.xpath("//div[text()='Get started']")).click();

    }

    public static void continueWithoutAccount(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated
            (By.xpath("//div[text()='Continue without an account']")));
        driver.findElement(By.xpath("//div[text()='Continue without an account']")).isDisplayed();
        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Continue without an account']")).isDisplayed(), 
            "Continue without an account button is not displayed");
        driver.findElement(By.xpath("//div[text()='Continue without an account']")).click();

    } 

    public static void varifyNavigation(WebDriver driver){

        LoggerUtil.logStatus(
            "INFO",
             "Verifying the website...",
              "PASSED");
        String url ="https://smartpad-customer-feedback.vercel.app/";
        driver.get(url);
        String current_url = driver.getCurrentUrl();
        Assert.assertEquals(url, current_url);
        LoggerUtil.logStatus(
            "INFO",
             "Website is verified successfully...",
              "PASSED");
    }
    public static void validateHomePage(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated
            (By.xpath("//div[@class='text-white text-[32px] font-bold w-[100%] text-center']")));
         LoggerUtil.logStatus(
            "INFO",
             "Validating the home page...",
              "PASSED");
        WebElement text_show= driver.findElement
             (By.xpath("//div[@class='text-white text-[32px] font-bold w-[100%] text-center']"));
        boolean is_text_show=text_show.isDisplayed();
        Assert.assertTrue(is_text_show, "Text is not displayed...");
        LoggerUtil.logStatus(
            "INFO",
             "Text is displayed...",
              "PASSED");

        WebElement get_started_button= driver.findElement(By.xpath("//div[text()='Get started']"));
        boolean is_enabled=get_started_button.isEnabled();
        Assert.assertTrue(is_enabled, "Get started button is not enabled...");
        LoggerUtil.logStatus(
            "INFO",
             "Home page is validated successfully...",
              "PASSED");

    }
}
