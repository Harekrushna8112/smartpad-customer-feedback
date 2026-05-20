package com.kristallball.Utility;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Action {


    public static void navigatetoWebsite(WebDriver driver, String url) throws InterruptedException{
        driver.get(url);
        Thread.sleep(3000);
    }
    

    public static void click(WebDriver driver, By locator) throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element= driver.findElement(locator);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
        

    }
   
    public static void handle_age_popup(WebDriver driver){
        List<WebElement> popups = driver.findElements(By.xpath("//button[text()='Yes']"));
        if(popups.size() > 0){
            WebElement popup = popups.get(0);
            LoggerUtil.logStatus(
                "INFO",
                "Age Popup is displayed ...",
                "PASSED"
            );
            popup.click();
            // if(popup.isDisplayed()){
            //     LoggerUtil.logStatus(
            //         "INFO",
            //         "Age Popup is displayed ...",
            //         "PASSED"
            //     );
            //     // popup.click();
            // }
        }else{
            LoggerUtil.logStatus(
                "INFO",
                "AgePopup is not displayed ...",
                "PASSED"
            );
        }
    }

    

    


    
    
}
