package com.jsystems.qa.frontend.cucumber.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

//    public WebElement emailInput = driver.findElement(By.id("usernameOrEmail"));
    @FindBy (id = "usernameOrEmail")
    public WebElement emailInput;

//    public WebElement buttonContinue = driver.findElement(By.cssSelector(".button.form-button"));
    @FindBy (css = ".button.form-button")
    public WebElement buttonContinue;

    @FindBy (id = "password")
    public WebElement passwordInput;

}
