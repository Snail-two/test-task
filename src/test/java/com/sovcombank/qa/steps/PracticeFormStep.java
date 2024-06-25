package com.sovcombank.qa.steps;

import com.sovcombank.qa.AbstractDemoQa;
import com.sovcombank.qa.page.PracticeFormPage;
import io.qameta.allure.Step;

public class PracticeFormStep extends AbstractDemoQa {
    private PracticeFormPage page;
    @Step("Корректное заполнение всех полей")
    public PracticeFormPage fillingFieldsValidData() {
        page = new PracticeFormPage(driver);
        page.inputFirstNameLine("Олег");
        page.inputLastNameLine("Олег");
        page.inputUserEmailLine("name@gmail.com");
        page.selectGenderMale();
        page.inputUserNumberLine(randomNumber());
        page.inputSubject("English");
        page.selectCheckBoxMusic();
        page.uploadPicture("image.jpg");
        page.inputCurrentAddress("text");
        page.selectUserState();
        page.selectUserCity();
        page.clickSubmit();
        return page;
    }
}
