package com.kristallball.Utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {
    // public static void takeScreenshot(WebDriver driver, String testName) {
    //     // Placeholder for screenshot logic
    //     // In a real implementation, you would use TakesScreenshot interface
    //     // and save the screenshot to a file with the testName
    //     TakesScreenshot ts=(TakesScreenshot)driver;
    //     File source= ts.getScreenshotAs(org.openqa.selenium.OutputType.FILE);
    //     String timeStamp = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
    //     String filePath = "screenshots/" + testName + "_" + timeStamp + ".png";
    //     try {
    //         org.apache.commons.io.FileUtils.copyFile(source, new File(filePath));
    //         System.out.println("Screenshot saved: " + filePath);
    //     } catch (Exception e) {
    //         System.out.println("Failed to save screenshot: " + e.getMessage());
    //     }
    //     System.out.println("Taking screenshot for test: " + testName);
    // }

      // Delete old screenshots
    public static void deleteOldScreenshots() {

        File folder = new File("./screenshots");
        if (folder.exists()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    file.delete();
                }
            }
        }
        System.out.println("Old screenshots deleted successfully");
    }

    // Take screenshot
    public static void takeScreenshot(WebDriver driver,String testName) {
        try {
            // Create screenshots folder if not exists
            File folder = new File("./screenshots");
            if (!folder.exists()) {
                folder.mkdir();
            }
            TakesScreenshot ts =(TakesScreenshot) driver;
            File source =ts.getScreenshotAs(OutputType.FILE);
            String timeStamp =new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String filePath ="./screenshots/"+ testName+ "_"+ timeStamp + ".png";
            File destination = new File(filePath);
            FileUtils.copyFile(source, destination);
            
            LoggerUtil.logStatus(
                "INFO", 
                "Screenshot saved: "+ filePath, 
                "PASSED");
        } catch (Exception e) {
            
            LoggerUtil.logStatus(
                "ERROR", 
                "Failed to save screenshot: "+ e.getMessage(), 
                "FAILED");
        }
    }
    
}
