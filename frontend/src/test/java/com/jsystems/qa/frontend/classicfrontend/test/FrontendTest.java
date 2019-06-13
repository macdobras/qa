package com.jsystems.qa.frontend.classicfrontend.test;

import com.jsystems.qa.frontend.Configuration;
import com.jsystems.qa.frontend.classicfrontend.page.LoginPage;
import com.jsystems.qa.frontend.classicfrontend.page.MainWorldpressPage;
import com.jsystems.qa.frontend.classicfrontend.page.UserPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FrontendTest extends ConfigFrontend{

    MainWorldpressPage worldpressPage;
    LoginPage loginPage;
    UserPage userPage;

    @Test
    public void firstFrontendTest(){

        worldpressPage = new MainWorldpressPage(driver);
        assertTrue(worldpressPage.buildWebsite.isDisplayed());
        assertEquals(worldpressPage.buildWebsite.getText(), "Build a website,");

        assertTrue(worldpressPage.login.isDisplayed());
        assertEquals(worldpressPage.login.getText(),"Log In");
        worldpressPage.login.click();

    }

    @Test
    public void loginTest(){

        login();

        userPage = new UserPage(driver);
        userPage.waitForVisibilityOfElement(userPage.userAvatar, 30);

        assertTrue(userPage.userAvatar.isDisplayed());

//        Przełączanie się na wyskakujące alerty - jako dodatek, cikawostka:
//
//        Alert alert = driver.switchTo().alert();
//        alert.accept();
//        driver.switchTo().alert()

    }

    @Test
    public void loginActionTest(){
        worldpressPage = new MainWorldpressPage(driver);
        worldpressPage.waitForVisibilityOfElement(worldpressPage.login, 30);
        worldpressPage.login.click();

        loginPage = new LoginPage(driver);

        loginPage.waitForVisibilityOfElement(loginPage.emailInput, 30);

        Actions actions = new Actions(driver);
        actions
                .moveToElement(loginPage.emailInput)
                .sendKeys(Configuration.LOGIN)
                .moveToElement(loginPage.buttonContinue)
                .click()
                .build().perform();

    }

    private void login() {
        worldpressPage = new MainWorldpressPage(driver);
        worldpressPage.waitForVisibilityOfElement(worldpressPage.login, 30);
        worldpressPage.login.click();

        loginPage = new LoginPage(driver);

        loginPage.waitForVisibilityOfElement(loginPage.emailInput, 30);
        loginPage.emailInput.clear();
        loginPage.emailInput.sendKeys(Configuration.LOGIN);
        loginPage.buttonContinue.click();

        loginPage.waitForVisibilityOfElement(loginPage.passwordInput, 30);
        loginPage.passwordInput.clear();
        loginPage.passwordInput.sendKeys(Configuration.PASSWORD);
        loginPage.buttonContinue.click();
    }

}


