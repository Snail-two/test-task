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

    @FindBy(xpath = "//input[@id='1']")
    WebElement cityInput;

    @FindBy(xpath = "//div[@role='listbox']//div[text()='Москва']")
    WebElement moscowOption;

    @FindBy(id = "2")
    public WebElement company;

    @FindBy(id = "input-1039")
    public WebElement dropDownCompany;

    @FindBy(xpath = "//div[@aria-expanded='true']")
    public WebElement divInputSlot;

    @FindBy(xpath = "//div[contains(@class, 'search-cities')]")
    public WebElement divThemeFlat;

    public void selectCity(String cityName) {
        clickElement(divThemeFlat);
        cityInput.sendKeys(cityName);
        wait.until(ExpectedConditions.visibilityOf(moscowOption));
        clickElement(moscowOption);
    }

    public void selectDropDownCompany() {
        clickElement(company);
        clickElement(dropDownCompany);
    }

    private void clickElement(WebElement element) {
        try {
            element.click();
        } catch (ElementClickInterceptedException e) {
            js.executeScript("arguments[0].click();", element);
        }
    }
}
