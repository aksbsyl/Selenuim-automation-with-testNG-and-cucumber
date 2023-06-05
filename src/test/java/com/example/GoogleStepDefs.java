//This one is for demo example. Not used in this project

package com.example;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class GoogleStepDefs {
    WebDriver driver;
    @Given("Launch Google Home Page")
    public void googlePage(){
        driver.get("https://google.com");
        driver.manage().window().maximize();
        Assert.assertTrue(driver.getTitle().equals("Google"));
    }

    @Given("Open Facebook page")
    public void openFacebookPage() {
        driver.get("https://www.facebook.com");
    }

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","/Users/aakashbashyal/IdeaProjects/Demo-Project/src/main/resources/chromedriver");
        driver = new ChromeDriver();
        Assert.assertTrue(driver.getTitle().equals("Facebook"));
    }
    @After
    public void teardown(){
        driver.quit();
    }
}
