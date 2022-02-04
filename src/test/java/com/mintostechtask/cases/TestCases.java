package com.mintostechtask.cases;

import com.mintostechtask.base.TestBaseManager;
import com.mintostechtask.constants.Titles;
import com.mintostechtask.constants.UnsortedWebElements;
import com.mintostechtask.pages.Home;
import com.mintostechtask.pages.brand.nike.Nike;
import com.mintostechtask.pages.signin.SigninPage;
import org.testng.annotations.Test;

public class TestCases extends TestBaseManager {

    @Test(priority = 1)
    public void TC_001_Login() {

        Home home = new Home(driver);
        SigninPage signinPage = new SigninPage(driver);

        home.openSignIn();
        signinPage.checkTitle(Titles.LOGIN);
        signinPage.login(config.getProperty("email"), config.getProperty("password"));
        signinPage.clickSignInButton();
        home.openAccount();
        signinPage.verifySuccessfulLogin(config.getProperty("email"));
    }

    @Test(priority = 2)
    public void TC_002_SearchItem() {

        Home home = new Home(driver);
        Nike nike = new Nike(driver);

        home.searchItem(UnsortedWebElements.NIKE_BRAND);
        nike.openMensNewIn();
        nike.clickRandomNikeItem();
        nike.selectAnySize();
        nike.addNikeItemToBag();
        nike.doCheckout();
    }

}