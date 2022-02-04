package com.mintostechtask.base;

import com.mintostechtask.constants.Titles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class Page {

    protected WebDriver driver;

    Random rand = new Random();

    public Page(WebDriver driver){
        this.driver=driver;
        checkTitle(Titles.MAIN);
    }

    final String SEARCH_ITEMS_FIELD = "//form/input[@type='search' and @id='txtSearch']";

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
        searchField.sendKeys(searchItem);
    }

    public void clickRandomSearchItem(String xPath){
        List<WebElement> advertsList = driver.findElements(By.xpath(xPath));
        clickRandomElement(advertsList);
    }

}