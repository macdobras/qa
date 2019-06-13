package com.jsystems.qa.frontend.classicfrontend.test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class WindowsTest extends ConfigFrontend{

    @Test
    public void testWindows() {
        String firstPageWindowHandle;
        String secondTestWindowHandle = null;

        String contactUrl = "http://www.testdiary.com/training/selenium/selenium-test-page/";

        driver.get(contactUrl);

//        By by = By.id("mywindowframe");

        new WebDriverWait(driver, 25)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("mywindowframe")));

        firstPageWindowHandle = driver.getWindowHandle();

        int hyperlinkYCoordinate = driver.findElement(By.id("mywindowframe")).getLocation().getY();
        int hyperlinkXCoordinate = driver.findElement(By.id("mywindowframe")).getLocation().getX();

        JavascriptExecutor jsexecutor = (JavascriptExecutor) driver;
        jsexecutor.executeScript("window.scrollBy(" + hyperlinkXCoordinate + "," + hyperlinkYCoordinate + ")", "");

        new WebDriverWait(driver, 100)
                .until(ExpectedConditions.elementToBeClickable(By.id("mywindowframe")));

        driver.findElement(By.id("mywindowframe")).click();

        Set<String> testPageWindowHandle = driver.getWindowHandles();

        for (String windowHandle : testPageWindowHandle) {
            if (!firstPageWindowHandle.equals(windowHandle)) {
                secondTestWindowHandle = windowHandle;
            }
        }

        driver.switchTo().window(secondTestWindowHandle);

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("testpagelink")));

        driver.switchTo().window(secondTestWindowHandle).close();

        driver.switchTo().window(firstPageWindowHandle);

        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("mywindowframe")));

    }

}
