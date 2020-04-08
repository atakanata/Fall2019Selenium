package com.automation.tests.warmup;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AmazonPractice1 {
    public static void main(String[] args) {


        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("https://www.amazon.com/");
        BrowserUtils.wait(3);
        Select deptSelectDropDown = new Select(driver.findElement(By.id("searchDropdownBox")));
        String deptDefaultSelected = deptSelectDropDown.getFirstSelectedOption().getText();
        System.out.println("deptDefaultSelected = " + deptDefaultSelected);
    }
}
