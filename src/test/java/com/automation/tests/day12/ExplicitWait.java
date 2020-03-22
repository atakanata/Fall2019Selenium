package com.automation.tests.day12;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWait {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");
    }

    @Test
    public void waitForTitle(){
        driver.get("https://google.com");

        WebDriverWait wait = new WebDriverWait(driver, 10);

        //wait up to 10 seconds until title contains Google
        wait.until(ExpectedConditions.titleIs("Google"));


        driver.navigate().to("https://amazon.com");
        wait.until(ExpectedConditions.titleContains("Amazon"));

    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
