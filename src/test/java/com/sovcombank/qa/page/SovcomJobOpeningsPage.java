package com.sovcombank.qa.page;

import com.sovcombank.qa.AbstractSovcom;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SovcomJobOpeningsPage extends AbstractSovcom {
    private WebDriver driver;
    private JavascriptExecutor js;

    public SovcomJobOpeningsPage(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//label[contains(.,'Город')]")
    public WebElement cityDropDown;
    @FindBy(xpath = "//div[@role='listbox']//div[contains(text(),'Москва')]")
    public WebElement elementCityDropDown;
    @FindBy(xpath = "//label[contains(.,'Компания')]")
    public WebElement companyDropdown;
    @FindBy(xpath = "//div[@role='option']//div[contains(text(),'Совкомбанк Технологии')]")
    public WebElement dropDownCompany;
    @FindBy(xpath = "//label[contains(.,'Тип занятости')]")
    public WebElement scrollElement;

    public void scroll(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void selectCityDropDown() {
        wait.until(ExpectedConditions.visibilityOf(cityDropDown)).click();
    }

    public void selectCity() {
        wait.until(ExpectedConditions.elementToBeClickable(elementCityDropDown)).click();
    }

    public void selectCompanyDropDown() {
        wait.until(ExpectedConditions.visibilityOf(companyDropdown)).click();
        scroll(scrollElement);
    }

    public void selectCompany() {
        wait.until(ExpectedConditions.elementToBeClickable(dropDownCompany)).click();
    }
}
