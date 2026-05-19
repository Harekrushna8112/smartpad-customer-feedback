package com.kristallball;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.kristallball.Utility.LoggerUtil;
import com.kristallball.Utility.ScreenshotUtil;
import com.kristallball.Wrappers.FormFilling;
import com.kristallball.Wrappers.HomePage;
import com.kristallball.Wrappers.Login;
import com.kristallball.Wrappers.Product;
import com.kristallball.Wrappers.Register;
import com.kristallball.Wrappers.Search;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Test_Cases {

    ChromeDriver driver;
    SoftAssert softAssert = new SoftAssert();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

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
        LoggerUtil.logStatus(
            "INFO",
            "Testcase_01",
            "Testing the navigation to the website and validate the home page...");
        
        HomePage.varifyNavigation(driver);
        HomePage.validateHomePage(driver);

        
        LoggerUtil.logStatus(
            "INFO",
            "Testcase_01",
            "Navigation to the website and validate the home page test is passed...");
        System.out.println("Test Case 01 is Completed...");
       
    }

    @Test
    public void Testcase_02() throws InterruptedException{
        System.out.println("Test Case 02 is Started...");
        LoggerUtil.logStatus(
            "INFO",
            "Testcase_02",
            "Testing the products types ..."
        );
        HomePage.homePage(driver);
        Product.VerifyProductTypes(driver);
        
            LoggerUtil.logStatus(
                "INFO",
                "Testcase_02",
                "Product types test is passed ..."
            );
        System.out.println("Test Case 02 is Completed...");
       
    }

    @Test
    public void Testcase_03() throws InterruptedException{
        System.out.println("Test Case 03 is Started...");
        
        LoggerUtil.logStatus(
            "INFO",
            "Testcase_03",
            "Testing with invalid Login credentials..."
        );

        HomePage.homePage(driver);
        Product.prodyctTypes(driver, "Wine");
        Login.loging_in(driver, "hari@gmail.com","Hari@123");
        Login.message(driver);
        
        LoggerUtil.logStatus(
            "INFO",
            "Testcase_03",
            "Invalid credentials test is passed..."
        );
        System.out.println("Test Case 03 is Completed...");
       
    }

    @Test
    public void Testcase_04() throws InterruptedException{
        System.out.println("Test Case 04 is Started...");
        LoggerUtil.logStatus(
            "INFO",
            "Testcase_04",
            "Testing the registration process ..."
        );

        HomePage.homePage(driver);
        Product.prodyctTypes(driver, "Wine");
    
        Register.clickRegister(driver);
        Thread.sleep(1000);

        Action.handle_age_popup(driver);
        
        WebElement submit= driver.findElement
            (By.xpath("//div[contains(@class,' justify-center w-[300px] py-[10px]')]"));
        softAssert.assertTrue(submit.isDisplayed(), "Resister button is not displayed...");
        if(submit.isDisplayed()){
            
            LoggerUtil.logStatus(
                "INFO",
                "Testcase_04",
                "Registration page is displayed ..."
            );

            Register.registering(driver, "Hari Biswal", "hari@gmail.com", "Hari@123");
            Register.Validate_WrongOTP(driver, "12345");
            Register.Validate_WrongOTP(driver, "1234567");
            Register.Validate_WrongOTP(driver, "abc123");
            Register.Validate_WrongOTP(driver, "123abc");
            Register.Validate_WrongOTP(driver, "123456");
        }else{
            
            LoggerUtil.logStatus(
                "INFO",
                "Testcase_04",
                "Resistration test is failed ..."
            );
            
            LoggerUtil.logStatus(
                "INFO",
                "Testcase_04",
                "Registration process test is failed..."
            );
            //  softAssert.assertAll();
            //  return;
        }

        System.out.println("Test Case 04 is Completed...");
    }
    @Test
    public void Testcase_05() throws InterruptedException{
        System.out.println("Test Case 05 is Started...");
        
        LoggerUtil.logStatus(
            "INFO",
            "Testcase_05",
            "Testing the continue without an account and Successful feedback submition ..."
        );

        HomePage.homePage(driver);
        Product.prodyctTypes(driver, "Wine");
   
        HomePage.continueWithoutAccount(driver);
        
        LoggerUtil.logStatus(
            "INFO",
            "Testcase_05",
            "Continue without an account test is passed ..."
        );
        

        Thread.sleep(1000);
        Action.handle_age_popup(driver);
 
        
        
        LoggerUtil.logStatus(
            "INFO",
            "Testcase_05",
            "Submitting feedback test is started ..."
        );
        Product.clickOnProduct(driver);
        Product.clickOnShareFeedback(driver);
        // Rating should be in between 1 to 5....
        FormFilling.ratingform(driver, "John Doe", "john@gmail.com",2,"verygood");
        LoggerUtil.logStatus(
            "INFO",
            "Testcase_05",
            "Feedback submition test is passed ..."
        );
        System.out.println("Test Case 05 is Completed...");
       
    }

    @Test
    public void Testcase_06() throws InterruptedException{
        System.out.println("Test Case 06 is Started...");
        
        LoggerUtil.logStatus(
            "INFO",
            "Testcase_06",
            "Testing the error message for incomplete feedback form ..."
        );

        HomePage.homePage(driver);
        Product.prodyctTypes(driver, "Wine");
        
        HomePage.continueWithoutAccount(driver);
        Action.handle_age_popup(driver);
        Product.clickOnProduct(driver);
        Product.clickOnShareFeedback(driver);
        // Rating should be in between 1 to 5....
        FormFilling.incompleteRatingForm(driver, "", "john@gmail.com",4,"verygood");
        
        LoggerUtil.logStatus(
            "INFO",
            "Testcase_06",
            "Error message for incomplete feedback form test is passed ..."
        );
        System.out.println("Test Case 06 is Completed...");
       
    }

    @Test
    public void Testcase_07() throws InterruptedException{
        System.out.println("Test Case 07 is Started...");
        
        LoggerUtil.logStatus(
            "INFO",
            "Testcase_07",
            "Testing search product and validate rating ..."
        );

        HomePage.homePage(driver);
        Product.prodyctTypes(driver, "Gin");
        

        LoggerUtil.logStatus(
            "INFO",
            "Testcase_07",
            "Testing search product  ..."
        );
        HomePage.continueWithoutAccount(driver);
        Thread.sleep(1000);
        Action.handle_age_popup(driver);
        String product_name= "Beefeater Pink";
        
        LoggerUtil.logStatus(
            "INFO",
            "Testcase_07",
            "Searching product: " + product_name
        );
        Search.search_product(driver, product_name);
        Product.searchProduct(driver);
        
        String actual_name= Search.get_product_name(driver);

        Assert.assertEquals(actual_name, product_name, "Searched product is not displayed...");
        LoggerUtil.logStatus(
            "INFO",
            "Testcase_07",
            "Search product test is passed ..."
        );

        
        LoggerUtil.logStatus(
            "INFO",
            "Testcase_07",
            "Validating rating after submitting feedback ..."
        );
        int rating_before_feedback= FormFilling.feedback_count(driver);
        Product.clickOnShareFeedback(driver);
        // Rating should be in between 1 to 5....
        FormFilling.ratingform(driver, "John Snow", "johnsnow@gmail.com",1,"so nice");
        
       
        HomePage.continueWithoutAccount(driver);
        Thread.sleep(1000);
        Action.handle_age_popup(driver);
        Search.search_product(driver, "Beefeater Pink");
        
        
        Product.searchProduct(driver);
        int rating_after_feedback= FormFilling.feedback_count(driver);
        Assert.assertEquals(rating_after_feedback, rating_before_feedback+1,
             "Rating is not increased by 1 after submitting feedback...");
        LoggerUtil.logStatus(
            "INFO",
            "Testcase_07",
            "Number of rating is increasing by 1 ..."
        );
        LoggerUtil.logStatus(
            "INFO",
            "Testcase_07",
            "Search product and validate rating test is passed ..."
        );
        System.out.println("Test Case 07 is Completed...");
       
    }


    
    @BeforeMethod
    public void startTest(Method method) {

        LoggerUtil.logStatus("INFO",method.getName(),"Test Started");
    }
    
    @AfterMethod
    public void endTest(ITestResult result, Method method) {
        if (ITestResult.SUCCESS== result.getStatus()) {
            LoggerUtil.logStatus("INFO",method.getName(),"Test Passed");
        } else if (ITestResult.FAILURE== result.getStatus()) {
            LoggerUtil.logStatus("INFO",method.getName(),"Test Failed");
            ScreenshotUtil.takeScreenshot(driver,method.getName());
        } else {
            LoggerUtil.logStatus("INFO",method.getName(),"Test Skipped");
        }
    }
    @BeforeSuite
    public void setupSuite() {
         ScreenshotUtil.deleteOldScreenshots();
    }
}
