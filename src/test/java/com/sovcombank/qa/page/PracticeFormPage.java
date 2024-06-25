package com.sovcombank.qa.page;

import lombok.Getter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class PracticeFormPage {
    public WebDriver driver;

    public PracticeFormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PracticeFormPage(){

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

    @FindBy(id = "uploadPicture")
    private WebElement selectPicture;

    @FindBy(id="currentAddress")
    private WebElement currentAddress;

    @FindBy(css = "#state .css-1hwfws3")
    private WebElement stateDropdown;

    @FindBy(id= "react-select-3-option-0")
    private WebElement stateDropdownIndicator;

    @FindBy(xpath = "//*[contains(text(),'Select City')]")
    private WebElement selectCity;

    @FindBy(id = "react-select-4-option-0")
    private WebElement cityDropdownIndicator;

    @FindBy(id = "submit")
    private WebElement submit;

    @FindBy(id= "Ad.Plus-970x250-2")
    private WebElement down;

    @FindBy(css = ".modal-content")
    private WebElement modalContent;

    public void scroll(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public WebElement pressEnter(WebElement element){
        $(element).pressEnter();
        return element;
    }

    public String inputFirstNameLine(String name){
        firstName.sendKeys(name);
        return name;
    }

    public void inputLastNameLine(String secondName){
        lastName.sendKeys(secondName);
    }

    public String inputUserEmailLine(String email){
        userEmail.sendKeys(email);
        return email;
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

    public String inputUserNumberLine(String number){
        userNumber.sendKeys(number);
        return number;
    }

    public void selectUserBirthsDay(){
        //TODO: добавить взаимодействие с календарем
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

    public String inputSubject(String sub){
        subjects.sendKeys(sub);
        pressEnter(subjects);
        return sub;
    }

    public void uploadPicture(String filePath){
        try {
            selectPicture.sendKeys(filePath);
        } catch (IllegalArgumentException e){
            e.getStackTrace();
            System.out.println("Файл не найден");
        }
    }

    public String inputCurrentAddress(String address){
        currentAddress.sendKeys(address);
        return address;
    }

    public void selectUserState(){
        stateDropdown.click();
        stateDropdownIndicator.click();
    }

    public void selectUserCity(){
        selectCity.click();
        cityDropdownIndicator.click();
    }

    public void clickSubmit(){
        submit.click();
    }

}
