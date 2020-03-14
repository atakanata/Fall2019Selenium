package com.automation.tests.day8;

import org.testng.Assert;

public class BasicTestNGTests {

    public void test1(){
        String expected = "apple";
        String actual = "apple";
        Assert.assertEquals(actual,expected);
    }
}
