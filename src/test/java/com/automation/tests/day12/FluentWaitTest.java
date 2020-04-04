package com.automation.tests.day12;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class FluentWaitTest {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("chrome");
    }

    @Test
    public void fluentWaitTest() {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/6");
        //10, TimeUnit.SECONDS = Duration.ofSeconds(10)
        Wait<WebDriver> wait = new FluentWait<>(driver).
                withTimeout(Duration.ofSeconds(10)).
                pollingEvery(Duration.ofSeconds(5)).
                ignoring(NoSuchElementException.class).
                ignoring(ElementClickInterceptedException.class);

        WebDriverWait  webDriverWait = new WebDriverWait(driver, 15);
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loadingoverlay")));

        //Anonymous - class without name
        WebElement submitBtn = wait.until(driver -> driver.findElement(By.xpath("//button[text()='Submit']")));

        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");

        submitBtn.click();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
