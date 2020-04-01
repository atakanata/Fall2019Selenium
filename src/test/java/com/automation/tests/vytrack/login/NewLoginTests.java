package com.automation.tests.vytrack.login;

import com.automation.pages.LoginPage;
import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.tests.vytrack.TestBase;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewLoginTests extends AbstractTestBase {


    @Test
    public void verifyPageTitle(){
        test = report.createTest("Verify page title");
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        test.info("Login as store manager");
        Assert.assertEquals(Driver.getDriver().getTitle(), "Dashboard");
        //BrowserUtils.getScreenshot("Dashboard_Verification");
        test.pass("Page title Dashboard was verified");
    }

    @Test
    public void verifyWarningMessage(){
        test = report.createTest("Verify Warning Message");
        LoginPage loginPage = new LoginPage();
        loginPage.login("wrong", "wrong");
        Assert.assertEquals(loginPage.getWarningMessageText(), "Invalid user name or password.");
        //BrowserUtils.getScreenshot("loginPage");
        test.pass("Warning message was verified.");
    }
}