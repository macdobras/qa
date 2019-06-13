package com.jsystems.qa.frontend.classicfrontend.test;

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

        @Test
        public void firstFrontendTest2(){

 //        try {
//            sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//      komentarz prowadzącego: nie używać sleep'a na PROD, tylko w trakcie developmentu

            driver.get("https://wordpress.com/");

       }

       @AfterEach
       public void closeDriver() {

           driver.quit();
       }

}
