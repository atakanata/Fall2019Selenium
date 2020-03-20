package com.automation.tests.practice;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GmailDarunNoor {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
//        WebElement profileMenu = driver.findElement(By.className("gb_ua gb_ra gb_va"));
//        WebElement signoutBttn = driver.findElement(By.id("gb_71"));
//        WebElement useAnotherAccount = driver.findElement(By.className("BHzsHc"));
//        WebElement emailNEXT = driver.findElement(By.id("yDmH0d"));

        driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
        WebElement userName = driver.findElement(By.id("identifierId") );
        BrowserUtils.wait(2);
        userName.sendKeys(
                "NaimahThomas@darunnoor.org"
                , Keys.ENTER);
        BrowserUtils.wait(5);
       WebElement password = driver.findElement(By.xpath("//*[@id='password']/div[1]/div/div[1]/input"));
       password.sendKeys("ilovereading",Keys.ENTER);
        BrowserUtils.wait(10);
        driver.close();
//==========================================================================
        driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
        BrowserUtils.wait(2);
        driver.findElement(By.id("identifierId") ).sendKeys(
                "NajeebAbdul-Hakeem@darunnoor.org"
                , Keys.ENTER);
        BrowserUtils.wait(5);
        driver.findElement(By.xpath("//*[@id='password']/div[1]/div/div[1]/input")).sendKeys("ilovereading",Keys.ENTER);
        BrowserUtils.wait(10);
        driver.close();









    }
}
