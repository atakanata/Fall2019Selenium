package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonsTest {

    public static void main(String[] args) {
//        if DriverFactory doesn't work, use this:
//        WebDriverManager.chromedriver().version("79").setup();
//        WebDriver driver = new ChromeDriver();

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        BrowserUtils.wait(2);
        //<input type="radio" id="black" name="color">
        WebElement blackButton = driver.findElement(By.id("black"));

        blackButton.click();

        //how do we verify that button clicked
        //returns true, if button clicked
        if(blackButton.isSelected()){
            System.out.println("TEST PASSED!");
        }else {
            System.out.println("TEST FAILED");
        }



        driver.quit();
    }
}
