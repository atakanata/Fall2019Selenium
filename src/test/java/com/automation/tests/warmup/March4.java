package com.automation.tests.warmup;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;

public class March4 {
    static WebDriver driver;

    public static void main(String[] args) throws Exception{
//        ebayTest();
//        amazonTest();
        wikiTest();
    }

    /**
     * Go to ebay --->          driver.get("http://ebay.com");
     * enter search term        input.sendKeys("java book");
     * click on search button   searchButton.click();
     * print number of results
     */
    public static void ebayTest() throws Exception {
        WebDriver driver = DriverFactory.createDriver("chrome");
        //Go to ebay
        driver.get("http://ebay.com");

        Thread.sleep(2000);//to wait 2 seconds

        //enter search term
        driver.findElement(By.id("gh-ac")).sendKeys("java book");

        Thread.sleep(2000);//to wait 2 seconds

        //click on search button
        driver.findElement(By.id("gh-btn")).click();

        Thread.sleep(4000);//to wait 2 seconds

        WebElement searchResults = driver.findElement(By.tagName("h1"));

        //print number of results
        String[] searchSentence = searchResults.getText().split(" ");
        System.out.println(Arrays.toString(searchSentence));

        System.out.println(searchSentence[0]);
        driver.quit();
    }

    /**
     * go to amazon
     * enter search term
     * click on search button
     * verify title contains search term
     */
    public static void amazonTest() throws Exception{
        driver = DriverFactory.createDriver("chrome");
        //go to amazon
        driver.get("http://amazon.com");
        //enter search term + click on search button
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java book", Keys.ENTER);

        Thread.sleep(4000);//to wait 2 seconds

        String title = driver.getTitle();

        //verify title contains search term
        if(title.contains("java book")){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }
        driver.quit();
    }

    /**
     * Go to wikipedia.org
     * enter search term `selenium webdriver`
     * click on search button
     * click on search result `Selenium (software)`
     * verify url ends with `Selenium_(software)`
     */
    public static void wikiTest() throws Exception{
        driver = DriverFactory.createDriver("chrome");
        //Go to wikipedia.org
        driver.get("https://en.wikipedia.org/wiki/Main_Page");

        //enter search term `selenium webdriver` & click on search button
        driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver", Keys.RETURN);

        Thread.sleep(3000);

        //click on search result `Selenium (software)`
        driver.findElement(By.partialLinkText("Selenium (software)")).click();

        Thread.sleep(2000);

        String link = driver.getCurrentUrl(); // to get link as a String

        //verify url ends with `Selenium_(software)`
        if(link.endsWith("Selenium_(software)")){
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }

        driver.quit();
    }
}
