package com.sovcombank.qa.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    @FindBy(xpath = "//input[@for='hobbies-checkbox-1']")
    private WebElement checkBoxSports;

    @FindBy(xpath = "//input[@for='hobbies-checkbox-2']")
    private WebElement checkBoxReading;

    @FindBy(xpath = "//input[@for='hobbies-checkbox-3']")
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

    @FindBy(xpath = "//*[contains(text(),'Select State')]")
    private WebElement selectState;

    @FindBy(xpath = "//*[contains(text(),'Select City')]")
    private WebElement selectCity;

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
        checkBoxMusic.click();
    }
    public void inputSubject(String sub){
        subjects.sendKeys(sub);
    }

    public void selectPicture(){

    }

    public void inputCurrentAddress(String address){
        currentAddress.sendKeys(address);
    }

    public void selectUserState(){

    }
}
