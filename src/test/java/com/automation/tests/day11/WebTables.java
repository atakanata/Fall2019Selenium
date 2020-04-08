package com.automation.tests.day11;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class WebTables {
    private WebDriver driver;
    @BeforeMethod
    public void setup() {
        //driver = DriverFactory.createDriver("chrome");
        WebDriverManager.chromedriver().version("79").setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(false);
        driver = new ChromeDriver(chromeOptions);
        driver.get("http://practice.cybertekschool.com/tables");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
    }
    @AfterMethod
    public void teardown() {
        BrowserUtils.wait(3);
        driver.quit();
    }

    @Test
    public void getColumnNames(){
        List<String> expected = Arrays.asList("Last Name" ,
                "First Name" ,
                "Email" ,
                "Due" ,
                "Web Site" ,
                "Action");
        List<WebElement> columnNames = driver.findElements(By.xpath("//table[1]//th"));
//        for (WebElement columnname:columnNames
//             ) {
//            System.out.println(columnname.getText());
//        }
        List<String> actual = BrowserUtils.getTextFromWebElements(columnNames);
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void getSpecificColumn(){
        List<WebElement> links = driver.findElements(By.xpath("//table[1]//tbody//tr//td[5]"));
        System.out.println(BrowserUtils.getTextFromWebElements(links));
    }

    @Test
    public void deleteSpecificRow(){
        //  //table[1]//td[text()='jsmith@gmail.com’]//following-sibling::td/a[text()=‘delete’]
        driver.findElement(By.xpath("//table[1]//td[text()='jsmith@gmail.com']//following-sibling::td/a[text()='delete']")).click();
        BrowserUtils.wait(3);

        int rowCount = driver.findElements(By.xpath("//table[1]//tbody//tr")).size();
        Assert.assertTrue(driver.findElements(By.xpath("//table[1]//td[text()='jsmith@gmail.com']")).isEmpty() );
        Assert.assertTrue(rowCount==3);
    }

    @Test
    public void getColumnIndexByName(){
        String columnName = "Email";
        List<WebElement> columnNames = driver.findElements(By.xpath("//table[1]//th"));

        int index = 0;
        for (int i = 0; i < columnNames.size(); i++) {
            if (columnNames.get(i).getText().equals(columnName)){
                index = i + 1;
                break;
            }
        }
        Assert.assertEquals(index,3);
    }

    @Test
    public void getSpecificCell(){
        String url35 = "http://www.jdoe.com";

        int row = 3;
        int column = 5;
        String xpath = "//table[1]//tbody//tr["+row+"]//td["+column+"]";
        WebElement cell = driver.findElement(By.xpath(xpath));
        Assert.assertEquals(cell.getText(),url35);
    }
}