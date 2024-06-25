package com.sovcombank.qa.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SovcomJobOpeningsPage {

    private WebDriver driver;

    public SovcomJobOpeningsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //TODO: попраить локатор
    @FindBy(xpath = "//*[@id='1']")
    public WebElement city;

    @FindBy(id = "list-item-1009-0")
    public WebElement dropDownCity;

    @FindBy(id = "2")
    public WebElement company;

    @FindBy(id = "input-1039")
    public WebElement dropDownCompany;

    public void selectDropDownCity(){
        city.click();
        dropDownCity.click();
    }

    public void selectDropDownCompany(){
        company.click();
        dropDownCompany.click();
    }
}
