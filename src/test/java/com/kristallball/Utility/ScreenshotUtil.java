package com.kristallball.Utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    public static void deleteOldScreenshots() {
        // Delete old screenshots.
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

    
    public static void takeScreenshot(WebDriver driver,String testName) {
        try {
            // Create screenshots folder if not exists.
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
