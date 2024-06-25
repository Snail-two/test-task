package com.sovcombank.qa.page;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class SovcomMainPage {

    private WebDriver driver;

    public SovcomMainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "button_primary")
    private WebElement vacancy;

    @FindBy(className = "close-btn")
    private WebElement modalWindowButtonClose;

    @FindBy(className = "chat-bot-modal__container")
    private WebElement modalWindow;

    public void clickVacancy(){
        vacancy.click();
    }

    public void closeModalWindow(){
        modalWindowButtonClose.click();
    }

    public boolean checkModalWindow(){
        return modalWindow.isDisplayed();
    }
}
