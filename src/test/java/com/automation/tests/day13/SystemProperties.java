package com.automation.tests.day13;

import org.testng.annotations.Test;

public class SystemProperties {


    @Test
    public void test(){
        System.out.println(System.getProperty("user.dir"));
    }
}
