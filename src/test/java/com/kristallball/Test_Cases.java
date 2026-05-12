package com.kristallball;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_Cases {

    ChromeDriver driver;

    
    @BeforeTest
    public void createDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        
        // Maximize Window....
        driver.manage().window().maximize();

        // Adding Implicit Wait...
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterTest
    public void endTest()
    {
        driver.close();
        driver.quit();

    }

    @Test
    public void Testcase_01() throws InterruptedException{
        System.out.println("Test Case 01 is Started...");
        System.out.println("Testing the navigation to the website and validate the home page...");

        System.out.println("Verifying  the website...");
        String url ="https://smartpad-customer-feedback.vercel.app/";
        Wrapper.navigatetoWebsite(driver,url);
        String current_url = driver.getCurrentUrl();
        Assert.assertEquals(url, current_url);
        System.out.println("Website is verified successfully...");

        System.out.println("Validating the home page...");
        WebElement text_show= driver.findElement(By.xpath("//div[@class='text-white text-[32px] font-bold w-[100%] text-center']"));
        boolean is_text_show=text_show.isDisplayed();
        Assert.assertTrue(is_text_show, "Text is not displayed...");

        WebElement get_started_button= driver.findElement(By.xpath("//div[text()='Get started']"));
        boolean is_enabled=get_started_button.isEnabled();
        Assert.assertTrue(is_enabled, "Get started button is not enabled...");
        System.out.println("Home page is validated successfully...");

        System.out.println("Navigation to the website and validate the home page test is passed...");
        System.out.println("Test Case 01 is Completed...");
       
    }

    @Test
    public void Testcase_02() throws InterruptedException{
        System.out.println("Test Case 02 is Started...");
        System.out.println("Testing the products types ...");

        Wrapper.navigatetoWebsite(driver,"https://smartpad-customer-feedback.vercel.app/");
        WebElement get_started_button= driver.findElement(By.xpath("//div[text()='Get started']"));
        get_started_button.click();
        WebElement text=driver.findElement(By.xpath("//h1[text()='What type of']"));
        Assert.assertTrue(text.isDisplayed(), "Text is not displayed...");
        List<WebElement> products= driver.findElements(By.xpath("//a[@class='rounded-[15px]']"));
        Assert.assertEquals(products.size(), 10, "Products are not 10...");
        
        System.out.println("Found " + products.size() + " products.");
        System.out.println("Test Case 02 is Completed...");
       
    }

    @Test
    public void Testcase_03() throws InterruptedException{
        System.out.println("Test Case 03 is Started...");
        System.out.println("Testing with invalid credentials...");

        Wrapper.navigatetoWebsite(driver,"https://smartpad-customer-feedback.vercel.app/");
        Wrapper.click(driver, By.xpath("//div[text()='Get started']"));
        Wrapper.click(driver, By.xpath("//div[text()='Wine']"));
        Login_Test.loging_in(driver, "hari@gmail.com","Hari@123");
        WebElement message= driver.findElement(By.xpath("//div[text()='Invalid Credentials!']"));
        Assert.assertTrue(message.isDisplayed(), "Invalid Credentials message is not displayed...");
        
        System.out.println("Invalid credentials test is passed...");
        System.out.println("Test Case 03 is Completed...");
       
    }

    @Test
    public void Testcase_04() throws InterruptedException{
        System.out.println("Test Case 04 is Started...");
        System.out.println("Testing the registration process ...");

        Wrapper.navigatetoWebsite(driver,"https://smartpad-customer-feedback.vercel.app/");
        Wrapper.click(driver, By.xpath("//div[text()='Get started']"));
        Wrapper.click(driver, By.xpath("//div[text()='Wine']"));
        Thread.sleep(5000);
        WebElement dontHaveAccount = driver.findElement(By.xpath("//div[@class='text-[13px]']"));
        dontHaveAccount.click();
        Thread.sleep(5000);
        Wrapper.handle_age_popup(driver);
        WebElement submit= driver.findElement(By.xpath("//div[contains(@class,' justify-center w-[300px] py-[10px]')]"));
        if(submit.isDisplayed()){
            System.out.println("Resister page is displayed ...");

            Resister_Test.registering(driver, "Hari Biswal", "hari@gmail.com", "Hari@123");
            Resister_Test.Validate_WrongOTP(driver, "12345");
            Resister_Test.Validate_WrongOTP(driver, "1234567");
            Resister_Test.Validate_WrongOTP(driver, "abc123");
            Resister_Test.Validate_WrongOTP(driver, "123abc");
            Resister_Test.Validate_WrongOTP(driver, "123456");
        }else{
            System.out.println("Resister button is not displayed ...");
            System.out.println("Resistration test is failed ...");
        }

        System.out.println("Test Case 04 is Completed...");
    }
    @Test
    public void Testcase_05() throws InterruptedException{
        System.out.println("Test Case 05 is Started...");
        System.out.println("Testing the continue without an account and Successful feedback submition ...");

        Wrapper.navigatetoWebsite(driver,"https://smartpad-customer-feedback.vercel.app/");
        Wrapper.click(driver, By.xpath("//div[text()='Get started']"));
        Wrapper.click(driver, By.xpath("//div[text()='Wine']"));
        Thread.sleep(5000);
        WebElement element= driver.findElement(By.xpath("//div[text()='Continue without an account']"));
        Assert.assertTrue(element.isDisplayed(), "Continue without an account is not displayed...");
        System.out.println("Continue without an account is displayed ...");
        element.click();
        Thread.sleep(2000);
        Wrapper.handle_age_popup(driver);
        Thread.sleep(2000);
        System.out.println("Feedback submition....");
        Wrapper.click(driver, By.xpath("(//div[contains(@class,'0 justify-between')])[3]"));
        Wrapper.click(driver, By.xpath("//p[text()='Share Feedback']"));
        Wrapper.feedbackform(driver, "John Doe", "john@gmail.com","verygood");
        System.out.println("Feedback submition test is passed ...");

        System.out.println("Test Case 05 is Completed...");
       
    }

    @Test
    public void Testcase_06() throws InterruptedException{
        System.out.println("Test Case 06 is Started...");
        System.out.println("Testing the error message for incomplete feedback form ...");

        Wrapper.navigatetoWebsite(driver,"https://smartpad-customer-feedback.vercel.app/");
        Wrapper.click(driver, By.xpath("//div[text()='Get started']"));
        Wrapper.click(driver, By.xpath("//div[text()='Wine']"));
        Wrapper.click(driver, By.xpath("//div[text()='Continue without an account']"));
        Wrapper.handle_age_popup(driver);
        Wrapper.click(driver, By.xpath("(//div[contains(@class,'0 justify-between')])[3]"));
        Wrapper.click(driver, By.xpath("//p[text()='Share Feedback']"));
        Wrapper.incomplete_feedbackform(driver, "", "john@gmail.com","verygood");
        
        System.out.println("Error message for incomplete feedback form test is passed ...");
        System.out.println("Test Case 06 is Completed...");
       
    }

    @Test
    public void Testcase_07() throws InterruptedException{
        System.out.println("Test Case 07 is Started...");
        System.out.println("Testing search product and validate rating");

        Wrapper.navigatetoWebsite(driver,"https://smartpad-customer-feedback.vercel.app/");
        Wrapper.click(driver, By.xpath("//div[text()='Get started']"));
        Wrapper.click(driver, By.xpath("//div[text()='Gin']"));

        System.out.println("Testing search product  ...");
        Wrapper.click(driver, By.xpath("//div[text()='Continue without an account']"));
        Wrapper.handle_age_popup(driver);
        String product_name= "Beefeater Pink";
        System.out.println("Expected product name: " + product_name);
        Wrapper.search_product(driver, product_name);
        Thread.sleep(4000);
        Wrapper.click(driver, By.xpath("//div[contains(@class,'0 justify-between')]"));
        Thread.sleep(2000);
        String actual_name= Wrapper.get_product_name(driver);
        Assert.assertEquals(actual_name, product_name, "Searched product is not displayed...");
        System.out.println("Search product test is passed ...");

        System.out.println("Validate rating after submitting feedback ...");
        int rating_before_feedback= Wrapper.feedback_count(driver);
        Wrapper.click(driver, By.xpath("//p[text()='Share Feedback']"));
        Wrapper.feedbackform(driver, "John Snow", "johnsnow@gmail.com","so nice");
        Thread.sleep(2000);
        Wrapper.click(driver, By.xpath("//div[text()='Continue without an account']"));
        Wrapper.handle_age_popup(driver);
        Wrapper.search_product(driver, "Beefeater Pink");
        Thread.sleep(4000);
        Wrapper.click(driver, By.xpath("//div[contains(@class,'0 justify-between')]"));
        Thread.sleep(2000);
        int rating_after_feedback= Wrapper.feedback_count(driver);
        Assert.assertEquals(rating_after_feedback, rating_before_feedback+1, "Rating is not increased by 1 after submitting feedback...");
        System.out.println("Number of rating is increasing by 1 ...");
        
        System.out.println("Search product and validate rating test is passed ...");
        System.out.println("Test Case 07 is Completed...");
       
    }

    public static void logStatus(String type, String message, String status) {

        System.out.println(String.format("%s |  %s  |  %s | %s", String.valueOf(java.time.LocalDateTime.now()), type,
                message, status));
    }
    
}
