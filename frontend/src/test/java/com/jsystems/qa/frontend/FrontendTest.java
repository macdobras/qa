package com.jsystems.qa.frontend;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FrontendTest {

    private WebDriver driver;

    @BeforeAll
    public void setUpAll() {
//      System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
//      driver = new ChromeDriver();

        System.setProperty("webdriver.geckodriver", "D:\\drivers\\geckodriver.exe");
    }

    @Test
    public void firstFrontendTest(){

        driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://wordpress.com");

//        try {
//            sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//      komentarz prowadzącego: nie używać sleep'a na PROD, tylko w trakcie developmentu

        WebElement login = driver.findElement(By.cssSelector("x...."));
        WebElement buildWebsite = driver.findElement(By.cssSelector("..." + "..."));
        assertTrue(buildWebsite.isDisplayed());
        assertEquals(buildWebsite.getText(), "Build a website,");

        assertTrue(login.isDisplayed());
        assertEquals(login.getText(),"Log In");
        login.click();


        driver.quit();
    }

}


