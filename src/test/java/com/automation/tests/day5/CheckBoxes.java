package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxes {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/checkboxes");
        BrowserUtils.wait(5);
        //<input type="checkbox" checked="">
        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));

        checkBoxes.get(0).click(); // click on first checkbox

        BrowserUtils.wait(2);

        checkBoxes.get(1).click(); // click on the second checkbox

        BrowserUtils.wait(2);
        driver.quit();
    }
}
