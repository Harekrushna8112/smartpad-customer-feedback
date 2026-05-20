Smartpad-customer-feedback Automation Testing

Project Description
   This project contains automated test scripts for the smartpad-customer-feedback website using Selenium WebDriver with Java and TestNG . The framework is built using Maven for dependency management.

Technologies Used
   Java
   Selenium WebDriver
   Maven
   TestNG
   ChromeDriver
   Visual Studio Code

Project Structure
    Project
        Src
           main
                Java\com\kristallball
                    Main.java
                resources
           test
                Java\com\kristallball
                    TestCases
                        Test_Cases.java
                    Utility
                        Action.java
                        LoggerUtil.java
                        ScreenshotUtil.java
                    Wrapper
                        FormFilling.java
                        HomePage.java
                        Login.java
                        Product.java
                        Register.java
                        Search.java
                resources
                    testng.xml
        Target
        pom.xml
        README.md

How to Run the Project
    Clone the repository
    Open the project in IDE (VS Code )
    Install Maven dependencies
    Run “mvn test” in terminal

Website Tested
    https://smartpad-customer-feedback.vercel.app/


Test Scenarios
     Home page validatin
     Product types validation
     Login validation
     Resister validation
     Continue without account
     Product feedback validation
     Search product and validate rating

Author
 Harekrushna Biswal



