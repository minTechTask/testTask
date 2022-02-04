package com.mintostechtask.cases.validation;

import com.mintostechtask.base.TestBaseManager;
import com.mintostechtask.constants.Titles;
import com.mintostechtask.constants.UnsortedWebElements;
import com.mintostechtask.constants.ValidationMessages;
import com.mintostechtask.pages.Home;
import com.mintostechtask.pages.signin.SigninPage;
import org.testng.annotations.Test;

public class Validation extends TestBaseManager {

    @Test(priority = 1)
    public void TC_001_Login_Validation_Without_Password() {

        Home home = new Home(driver);
        SigninPage signinPage = new SigninPage(driver);
        home.openSignIn();
        signinPage.checkTitle(Titles.LOGIN);
        signinPage.incorrectLoginWithoutPassword(config.getProperty("email"));
        signinPage.clickSignInButton();
        signinPage.validationIncorrectLoginWithoutPassword(ValidationMessages.LOGIN_WITHOUT_PASSWORD);
    }

    @Test(priority = 2)
    public void TC_001_Login_Validation_Without_Email() {

        Home home = new Home(driver);
        SigninPage signinPage = new SigninPage(driver);

        home.openSignIn();
        signinPage.checkTitle(Titles.LOGIN);
        signinPage.incorrectLoginWithoutEmail(config.getProperty("password"));
        signinPage.clickSignInButton();
        signinPage.validationIncorrectLoginWithoutEmail(ValidationMessages.LOGIN_WITHOUT_EMAIL);
    }

    @Test(priority = 3)
    public void TC_001_Login_Validation_Using_Incorrect_Email_And_Password() {

        Home home = new Home(driver);
        SigninPage signinPage = new SigninPage(driver);

        home.openSignIn();
        signinPage.checkTitle(Titles.LOGIN);
        signinPage.incorrectLogin(UnsortedWebElements.FAKE_EMAIL, UnsortedWebElements.FAKE_PASSWORD);
        signinPage.clickSignInButton();
        signinPage.validationIncorrectLoginAllCredentials(ValidationMessages.LOGIN_USING_INCORRECT_DATA);
    }

    @Test(priority = 4)
    public void TC_001_Login_Validation_Using_Only_Incorrect_Email() {

        Home home = new Home(driver);
        SigninPage signinPage = new SigninPage(driver);

        home.openSignIn();
        signinPage.checkTitle(Titles.LOGIN);
        signinPage.incorrectLogin(UnsortedWebElements.WRONG_EMAIL, UnsortedWebElements.FAKE_PASSWORD);
        signinPage.clickSignInButton();
        signinPage.validationIncorrectLoginBadEmail(ValidationMessages.LOGIN_USING_INCORRECT_EMAIL);
    }

}