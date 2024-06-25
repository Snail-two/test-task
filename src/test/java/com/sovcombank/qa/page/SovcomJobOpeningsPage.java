package com.sovcombank.qa.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SovcomJobOpeningsPage {

    private WebDriver driver;

    public SovcomJobOpeningsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}
