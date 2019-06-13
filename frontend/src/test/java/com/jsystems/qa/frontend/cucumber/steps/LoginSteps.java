package com.jsystems.qa.frontend.cucumber.steps;

import com.jsystems.qa.frontend.Configuration;
import com.jsystems.qa.frontend.cucumber.CucumberStepConfig;
import com.jsystems.qa.frontend.cucumber.page.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps {

    WebDriver driver;

    MainWorldpressPage worldpressPage;
    LoginPage loginPage;
    UserPage userPage;
    UserProfilePage userProfilePage;
    NotificationPage notificationPage;

    public LoginSteps(CucumberStepConfig stepConfig) {
        driver = stepConfig.setUp();
    }


    @Given("^User start on main page$")
        public void userStartOnMainPage () {

        driver.get(Configuration.BASE_URL);

        }

        @When("^User log in to the user page$")
        public void userLogInToTheUserPage () {

            login();

            userPage = new UserPage(driver);
            userPage.waitForVisibilityOfElement(userPage.userAvatar, 50);

            assertTrue(userPage.userAvatar.isDisplayed());

        }

        @Then("^User can modified user profile$")
        public void userCanModifiedUserProfiles () {

        userPage.userAvatar.click();
        userProfilePage = new UserProfilePage(driver);
        userProfilePage.waitForVisibilityOfElement(userProfilePage.buttonSave, 120);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntView(true)", userProfilePage.buttonSave);

        userProfilePage.waitForVisibilityOfElement(userProfilePage.buttonSave, 120);
        assertFalse(userProfilePage.buttonSave.isEnabled());

        }


    @Given("^User start on page \"([^\"]*)\"$")
    public void userStartOnPage(String arg0) throws Throwable {
        driver.get(arg0);

    }

    @Then("^User can modified notifications$")
    public void userCanModifiedNotifications() {
        userPage.userAvatar.click();
        userProfilePage = new UserProfilePage(driver);
        userProfilePage.waitForVisibilityOfElement(userProfilePage.notification, 50);
        userProfilePage.notification.click();
        notificationPage = new NotificationPage(driver);
        notificationPage.waitForVisibilityOfElement(notificationPage.firstCheckbox, 50);
        assertTrue(notificationPage.firstCheckbox.isSelected());
    }


    private void login() {
        worldpressPage = new MainWorldpressPage(driver);
        worldpressPage.waitForVisibilityOfElement(worldpressPage.login, 50);
        worldpressPage.login.click();

        loginPage = new LoginPage(driver);

        loginPage.waitForVisibilityOfElement(loginPage.emailInput, 50);
        loginPage.emailInput.clear();
        loginPage.emailInput.sendKeys(Configuration.LOGIN);
        loginPage.buttonContinue.click();

        loginPage.waitForVisibilityOfElement(loginPage.passwordInput, 50);
        loginPage.passwordInput.clear();
        loginPage.passwordInput.sendKeys(Configuration.PASSWORD);
        loginPage.buttonContinue.click();
    }
}
