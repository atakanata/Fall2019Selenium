package com.automation.tests.day12;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
        driver.get("http://google.com");

        WebDriverWait wait = new WebDriverWait(driver, 10);

        //wait up to 10 seconds until title contains Google
        wait.until(ExpectedConditions.titleContains("Google"));
    }

    @Test
    public void waitForVisibility(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.findElement(By.tagName("button")).click();
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement submitBttn = driver.findElement(By.cssSelector("button[type='submit']"));

        wait.until(ExpectedConditions.visibilityOf(username)).sendKeys("tomsmith");
        wait.until(ExpectedConditions.visibilityOf(password)).sendKeys("SuperSecretPassword");
        wait.until(ExpectedConditions.visibilityOf(submitBttn));
        wait.until(ExpectedConditions.elementToBeClickable(submitBttn)).click();

        String expected = "Welcome";
        String actual = driver.findElement(By.className("subheader")).getText();
        Assert.assertTrue(actual.contains(expected));
    }

    @Test
    public void elementToBeClickableTest(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/5");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement submitBttn = driver.findElement(By.cssSelector("button[type='submit']"));

        WebElement loadingOverlayIcon = driver.findElement(By.xpath("//div[@class='loadingoverlay']"));
        wait.until(ExpectedConditions.invisibilityOf(loadingOverlayIcon));

        wait.until(ExpectedConditions.elementToBeClickable(submitBttn));
        username.sendKeys("tomsmith");
        password.sendKeys("SuperSecretPassword");
        submitBttn.click();
    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}