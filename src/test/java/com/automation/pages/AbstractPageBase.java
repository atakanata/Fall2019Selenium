package com.automation.pages;

import com.automation.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * This class will be extended by page classes
 * Ant common webelements/locators can be stored here
 * Since navigation menu doesn't belong to particular page
 * We cannot really create a dedicated page class to store
 * elements from that menu
 */
public abstract class AbstractPageBase {
    protected WebDriver driver = Driver.getDriver();

    public AbstractPageBase(){
        PageFactory.initElements(driver, this);
    }

    public void navigateTo(String tabName, String moduleName){
        String tabNameXpath = "//span[@class='title title-level-1' and contains(text(),'"+tabName+"')]";

    }
}
