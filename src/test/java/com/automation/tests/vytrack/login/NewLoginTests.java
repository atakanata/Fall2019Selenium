package com.automation.tests.vytrack.login;

import com.automation.pages.LoginPage;
import com.automation.tests.vytrack.TestBase;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewLoginTests extends TestBase {
    /**
     * Login and verify that page title is a "Dashboard"
     * 10 minutes : 1:37
     */
    @Test
    public void verifyPageTitle(){
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        Assert.assertEquals(Driver.getDriver().getTitle(), "Dashboard");
    }
}
