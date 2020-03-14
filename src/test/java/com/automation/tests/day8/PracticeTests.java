package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Create a class called PracticeTests
 *
 * - setup before/after methods
 * 	- in before method - instantiate webdriver and navigate to: http://practice.cybertekschool.com/
 * 	- in after method - just close webdriver.
 *
 * - create a test called loginTest
 * 	- go to "Form Authentication" page
 * 	- enter valid credentials
 * 		username: tomsmith
 * 		password: SuperSecretPassword
 *
 * 	- verify that following sub-header message is displayed: "Welcome to the Secure Area. When you are done click logout below."
 */
public class PracticeTests {
    private WebDriver driver;

    /**
     * We put @Test annotation to make methods executable as tests
     */
    @Test//create a test called loginTest
    public void loginTest(){
        //go to "Form Authentication" page
        driver.findElement(By.linkText("Form Authentication")).click();
        BrowserUtils.wait(3);
    }


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        //ChromeOptions - use to customize browser for tests
        ChromeOptions chromeOptions = new ChromeOptions();
        //to ignore "Your connection is not private issue"
        chromeOptions.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(chromeOptions);
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}

