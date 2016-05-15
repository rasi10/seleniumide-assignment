package se.nackademin.seleniumide.assignment;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TestProductCategoriesMenu {

    private final String BASE_URL = "http://store.demoqa.com/";
    private WebDriver driver;    

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.get(BASE_URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    
    public void navigateMenuProductCategories(WebElement element, String identifier,WebDriver driver,String assertionTitle ){
        Actions builder = new Actions(driver);
        element = driver.findElement(By.cssSelector("#menu-item-33"));
        builder.moveToElement(element).perform();               
        driver.findElement(By.cssSelector(identifier)).click();
        Assert.assertEquals(assertionTitle, driver.getTitle());
    }        
    
    @Test
    public void testProductcategories() throws Exception {
        WebElement productCategoryMenu = null;       
        navigateMenuProductCategories (productCategoryMenu,"#menu-item-34",driver,"Accessories | ONLINE STORE");
        navigateMenuProductCategories (productCategoryMenu,"#menu-item-35",driver,"iMacs | ONLINE STORE");
        navigateMenuProductCategories (productCategoryMenu,"#menu-item-36",driver,"iPads | ONLINE STORE");
        navigateMenuProductCategories (productCategoryMenu,"#menu-item-37",driver,"iPhones | ONLINE STORE");
        navigateMenuProductCategories (productCategoryMenu,"#menu-item-38",driver,"iPods | ONLINE STORE");
        navigateMenuProductCategories (productCategoryMenu,"#menu-item-39",driver,"MacBooks | ONLINE STORE");       
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        
    }

}
