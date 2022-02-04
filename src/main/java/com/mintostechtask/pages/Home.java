package com.mintostechtask.pages;

import com.mintostechtask.base.Page;
import com.mintostechtask.constants.Titles;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class Home extends Page {

    public Home (WebDriver driver){
        super(driver);
    }

    Random rand = new Random();

    final String SIGN_IN_BUTTON = "//div[@class='SignInLink']";
    final String ACCOUNT_BUTTON = "//div[@class='AccountLink']";

    final String SEARCH_ITEMS_FIELD = "//form/input[@type='search' and @id='txtSearch']";

    public void openSignIn(){
        driver.findElement(By.xpath(SIGN_IN_BUTTON)).click();
        checkTitle(Titles.LOGIN);
    }

    public void openAccount(){
        driver.findElement(By.xpath(ACCOUNT_BUTTON)).click();
        checkTitle(Titles.ACCOUNT_INFORMATION);
    }

    public void checkTitle(String expectedTitle){
        String actualTitle = driver.getTitle();
        System.out.println("Title of this page is " + actualTitle);
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    public void clickRandomElement(List<WebElement> webElements){
        int randomLink = rand.nextInt(webElements.size());
        webElements.get(randomLink).click();
    }

    public void searchItem(String searchItem){
        WebElement searchField = driver.findElement(By.xpath(SEARCH_ITEMS_FIELD));
        searchField.sendKeys(searchItem + Keys.ENTER);
        checkTitle(Titles.NIKE_CATEGORY);
    }

}