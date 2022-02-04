package com.mintostechtask.pages.brand.nike;

import com.mintostechtask.base.Page;
import com.mintostechtask.constants.Titles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Nike extends Page {

    public Nike (WebDriver driver){
        super(driver);
    }

    final String MENU_MENS_NEWIN = "//div/a[@href='/nike/nike-mens/new-in-nike-mens']";
    final String NIKE_NAVIGATION_ITEMS = "//ul/li[@li-brand='Nike']";
    final String NIKE_SIZE = "//ul[@id='ulSizes']";
    final String NIKE_ADD_TO_BAG = "//div[@id='ProductStandardAddToBag']";
    final String NIKE_BAG = "//a[@id='aBagLink']";


    public void openMensNewIn(){
        WebElement mensNewIn = driver.findElement(By.xpath(MENU_MENS_NEWIN));
        mensNewIn.click();
        checkTitle(Titles.NIKE_MENS_NEW_IN_SUBCATEGORY);
    }

    public void clickRandomNikeItem(){
        clickRandomSearchItem(NIKE_NAVIGATION_ITEMS);
    }

    public void selectAnySize(){
        clickRandomSearchItem(NIKE_SIZE);
    }

    public void addNikeItemToBag(){
        WebElement nikeItemInBag = driver.findElement(By.xpath(NIKE_ADD_TO_BAG));
        nikeItemInBag.click();
    }

    public void doCheckout(){
        WebElement nikeCheckout = driver.findElement(By.xpath(NIKE_BAG));
        nikeCheckout.click();
        checkTitle(Titles.CART);
    }

}