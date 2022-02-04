package com.mintostechtask.pages.signin;

import com.mintostechtask.base.Page;
import com.mintostechtask.constants.Titles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SigninPage extends Page {

    final String EMAIL_FIELD = "//div/input[@type='email' and @name='Login.EmailAddress']";
    final String PASSWORD_FIELD = "//div/input[@type='password' and @name='Login.Password']";
    final String SIGN_IN_SECURELY_BUTTON = "//a[@id='LoginButton']";

    final String EDIT_PERSONAL_DETAILS_TEXTLINK = "Edit Personal Details";
    final String VERIFY_EMAIL = "//div/input[@id='txtEmailAddress']";

    final String ONLY_EMAIL_VALIDATION_MESSAGE = "//form[@id='login']/span[@data-valmsg-for='Login.Password']";
    final String ONLY_PASSWORD_VALIDATION_MESSAGE = "//form[@id='login']/span[@data-valmsg-for='Login.EmailAddress']";
    final String BOTH_EMAIL_PASSWORD_VALIDATION_MESSAGE = "//form[@id='login']/span[@data-valmsg-for='Login']";

    public SigninPage (WebDriver driver){
        super(driver);
    }

    public void login(String login, String password){
        driver.findElement(By.xpath(EMAIL_FIELD)).sendKeys(login);
        driver.findElement(By.xpath(PASSWORD_FIELD)).sendKeys(password);
    }

    public void clickSignInButton(){
        driver.findElement(By.xpath(SIGN_IN_SECURELY_BUTTON)).click();
    }

    public void verifySuccessfulLogin(String expectedEmail){
        driver.findElement(By.linkText(EDIT_PERSONAL_DETAILS_TEXTLINK)).click();
        String actualEmail = driver.findElement(By.xpath(VERIFY_EMAIL)).getAttribute("value");
        Assert.assertEquals(actualEmail, expectedEmail);
        checkTitle(Titles.EDIT_PERSONAL_DETAILS);
    }

    public void incorrectLoginWithoutPassword(String login){
        driver.findElement(By.xpath(EMAIL_FIELD)).sendKeys(login);
    }

    public void validationIncorrectLoginWithoutPassword(String expectedValidationMessage){
        String actualValidationMessage = driver.findElement(By.xpath(ONLY_EMAIL_VALIDATION_MESSAGE)).getText();
        Assert.assertEquals(actualValidationMessage,expectedValidationMessage);
    }

    public void incorrectLoginWithoutEmail(String password){
        driver.findElement(By.xpath(PASSWORD_FIELD)).sendKeys(password);
    }

    public void validationIncorrectLoginWithoutEmail(String expectedValidationMessage){
        String actualValidationMessage = driver.findElement(By.xpath(ONLY_PASSWORD_VALIDATION_MESSAGE)).getText();
        Assert.assertEquals(actualValidationMessage,expectedValidationMessage);
    }

    public void incorrectLogin(String fakeLogin, String fakePassword){
        driver.findElement(By.xpath(EMAIL_FIELD)).sendKeys(fakeLogin);
        driver.findElement(By.xpath(PASSWORD_FIELD)).sendKeys(fakePassword);
    }

    public void validationIncorrectLoginBadEmail(String expectedValidationMessage){
        String actualValidationMessage = driver.findElement(By.xpath(ONLY_PASSWORD_VALIDATION_MESSAGE)).getText();
        Assert.assertEquals(actualValidationMessage,expectedValidationMessage);
    }

    public void validationIncorrectLoginAllCredentials(String expectedValidationMessage){
        String actualValidationMessage = driver.findElement(By.xpath(BOTH_EMAIL_PASSWORD_VALIDATION_MESSAGE)).getText();
        Assert.assertEquals(actualValidationMessage,expectedValidationMessage);
    }

}