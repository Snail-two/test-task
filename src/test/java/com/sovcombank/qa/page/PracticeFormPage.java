package com.sovcombank.qa.page;

import lombok.Getter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static java.awt.SystemColor.window;

@Getter
public class PracticeFormPage {
    public WebDriver driver;

    public PracticeFormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "firstName")
    private WebElement firstName;

    @FindBy(id="lastName")
    private WebElement lastName;

    @FindBy(id="userEmail")
    private WebElement userEmail;

    @FindBy(xpath = "//label[@for='gender-radio-1']")
    private WebElement radioButtonMale;

    @FindBy(xpath = "//label[@for='gender-radio-2']")
    private WebElement radioButtonFemale;

    @FindBy(xpath = "//label[@for='gender-radio-3']")
    private WebElement radioButtonOther;

    @FindBy(xpath = "//input[@id='hobbies-checkbox-1']")
    private WebElement checkBoxSports;

    @FindBy(xpath = "//input[@id='hobbies-checkbox-2']")
    private WebElement checkBoxReading;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-3']")
    private WebElement checkBoxMusic;

    @FindBy(id="userNumber")
    private WebElement userNumber;

    @FindBy(id="dateOfBirthInput")
    private WebElement dateOfBirth;
    //Нужно добавить взаимодействие с календарем

    @FindBy(id="subjectsInput")
    private WebElement subjects;

    @FindBy(xpath = "//*[contains(text(),'Select picture')]")
    private WebElement selectPicture;
    //добавить взаимодействие с проводником для выбора фото

    @FindBy(id="currentAddress")
    private WebElement currentAddress;

    @FindBy(className = "css-tlfecz-indicatorContainer")
    private WebElement selectState;

    @FindBy(xpath = "//*[contains(text(),'Select City')]")
    private WebElement selectCity;

    @FindBy(id = "submit")
    private WebElement submit;

    @FindBy(xpath = "//span[cotains(text(),'© 2013-2020 TOOLSQA.COM | ALL RIGHTS RESERVED.')]")
    private WebElement down;

    public void scroll(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();


    }
    public WebElement pressEnter(WebElement element){
        $(element).pressEnter();
        return element;
    }

    public void inputFirstNameLine(String name){
        firstName.sendKeys(name);
    }

    public void inputLastNameLine(String secondName){
        lastName.sendKeys(secondName);
    }

    public void inputUserEmailLine(String email){
        userEmail.sendKeys(email);
    }

    public void selectGenderMale(){
        radioButtonMale.click();
    }

    public void selectGenderFemale(){
        radioButtonFemale.click();
    }

    public void selectGenderOther(){
        radioButtonOther.click();
    }

    public void inputUserNumberLine(String number){
        userNumber.sendKeys(number);
    }

    public void selectUserBirthsDay(){

    }

    public void selectCheckBoxSports(){
        checkBoxSports.click();
    }

    public void selectCheckBoxReading(){
        checkBoxReading.click();
    }

    public void selectCheckBoxMusic(){
        scroll(down);
        checkBoxMusic.click();
    }

    public void inputSubject(String sub){
        subjects.sendKeys(sub);
        pressEnter(subjects);
    }

    public void selectPicture(){

    }

    public void inputCurrentAddress(String address){
        scroll(currentAddress);
        currentAddress.sendKeys(address);
    }

    public void selectUserState(){
        selectState.click();
        pressEnter(selectState);
    }

    public void selectUserCity(){
        selectCity.click();
        pressEnter(selectCity);
    }

    public void clickSubmit(){
        submit.click();
    }
}
