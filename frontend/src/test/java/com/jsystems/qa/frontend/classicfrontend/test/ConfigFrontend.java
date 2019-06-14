package com.jsystems.qa.frontend.classicfrontend.test;


import com.jsystems.qa.frontend.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class ConfigFrontend {

    WebDriver driver;

//    String chromePath;
//    String fireFoxPath;
//
//    {
//        try {
//            chromePath = Paths.get(getClass().getClassLoader()
//                    .getResource("drivers/chromedriver.exe")
//                    .toURI()).toFile().getAbsolutePath();
//            fireFoxPath = Paths.get(getClass().getClassLoader()
//                    .getResource("drivers/geckodriver.exe")
//                    .toURI()).toFile().getAbsolutePath();
//        } catch (URISyntaxException e) {
//
//            e.printStackTrace();
//        }
//    }

    @BeforeAll
    public static void setUpAll() {

//        WebDriverManager.chromedriver().setup();


//      System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver", ClassLoader.getSystemClassLoader()
//                .getResource("drivers/chromedriver.exe").getFile());

        System.setProperty("webdriver.geckodriver", "D:\\drivers\\geckodriver.exe");
//        System.setProperty("webdriver.geckodriver", ClassLoader.getSystemClassLoader()
//                .getResource("drivers/geckodriver.exe").getFile());
    }

    @BeforeEach
    public void setUpEach(){

//        System.setProperty("webdriver.chrome.driver", chromePath);
//        System.setProperty("webdriver.gecko.driver", fireFoxPath);

        String browser = Configuration.getBROWSER();

        if(browser.equals("firefox")){
            driver = new FirefoxDriver();
        } else if (browser.equals("chrome")){
            driver = new ChromeDriver();
        }

        setDriver();
//        sktór CTRL+ALT+M = wyestrachowanie (refaktoring) oznaczonego kawałka kodu do nowej metody

        driver.get(Configuration.BASE_URL);

  }

    private void setDriver() {
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

}
