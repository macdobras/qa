package com.jsystems.qa.frontend;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrontendTest2 {

       private WebDriver driver;

       @BeforeEach
       public void startDriver() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
       }

        @AfterEach
        public void closeDriver() {
            driver.quit();
        }

        @Test
        public void firstFrontendTest2(){

            driver.get("https://wordpress.com/");

       }
}
