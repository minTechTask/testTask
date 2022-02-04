package com.mintostechtask.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

/*
    With help of this class you can run tests using corresponding driver files.
    Because of this the files must be added to the project and defined.
 */

public class TestBase {

    public WebDriver driver;
    public static Properties config = new Properties();
    public static FileInputStream propertyFile;
    private final static String PATH_TO_BASE_PROPERTIES = "\\src\\test\\resources\\base.properties";
    private final static String PATH_TO_EDGE_DRIVER = "\\src\\test\\resources\\edgeDriver\\msedgedriver.exe";
    private final static String PATH_TO_CHROME_DRIVER = "\\src\\test\\resources\\chromeDriver\\chromedriver.exe";

    @BeforeMethod
    public void setUp(){
            try {
                propertyFile = new FileInputStream(
                        System.getProperty("user.dir") + PATH_TO_BASE_PROPERTIES);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                config.load(propertyFile);
                System.out.println("Config file loaded !!!");
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (config.getProperty("browser").equals("edge")) {

                System.setProperty("webdriver.edge.driver",
                        System.getProperty("user.dir") + PATH_TO_EDGE_DRIVER);

                driver = new EdgeDriver();
                System.out.println("Edge Launched");

            } else if (config.getProperty("browser").equals("chrome")) {

                System.setProperty("webdriver.chrome.driver",
                        System.getProperty("user.dir") + PATH_TO_CHROME_DRIVER);

                driver = new ChromeDriver();
                System.out.println("Chrome Launched");
            }

            driver.get(config.getProperty("baseUrl"));
            System.out.println("Navigated to : " + config.getProperty("baseUrl"));
            checkURL();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void checkURL(){
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL,config.getProperty("baseUrl"));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
