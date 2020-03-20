package com.automation.tests.collectionPractice;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;

public class CollectionPractice {
    public static void main(String[] args) {
//        WebDriverManager.chromedriver().version("79").setup();
//        WebDriver driver = new ChromeDriver();
//
//        driver.get("https://www.amazon.com/");
//        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
//        BrowserUtils.wait(2);
//
//        List<WebElement> pricesAmazon = driver.findElements(By.className("a-price-whole"));
//
//        BrowserUtils.wait(2);

//        for (WebElement each:pricesAmazon
//             ) {
//            System.out.println(each.getText());
//        }
//
//        driver.quit();

//        String price1 = "100.99";
//        double priceNum1 = Double.parseDouble(price1);
//        System.out.println("priceNum1 = " + priceNum1);


        List<String> priceLstStr = new ArrayList<>(Arrays.asList("99.99", "56.45", "646.46","654.76","99.99"));
        priceLstStr.add("999.99");
        System.out.println(priceLstStr);

        List<Double> prices = new ArrayList<>();

        for (String s : priceLstStr) {
            prices.add(Double.parseDouble(s));
        }
        System.out.println("prices = " + prices);

        Set<Double> uniquePrices = new HashSet<>(prices);
        System.out.println(uniquePrices);

        Double max=prices.get(0);
        for (Double each:prices
             ) {
            if (each>max){
                max=each;
            }
        }
        System.out.println("max = " + max);



    }
}
