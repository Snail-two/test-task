package com.sovcombank.qa.steps.ui;

import com.sovcombank.qa.AbstractDemoQa;
import com.sovcombank.qa.asserts.ui.PracticeFormAsserts;
import com.sovcombank.qa.page.PracticeFormPage;
import io.qameta.allure.Step;
import lombok.Getter;

@Getter
public class PracticeFormStep extends AbstractDemoQa {
    private PracticeFormPage page;

    private PracticeFormAsserts asserts;
    //TODO: изменить путь файла, сделать опциональным
    @Step("Корректное заполнение всех полей")
    public PracticeFormPage fillingFieldsValidData() {
        page = new PracticeFormPage(driver);
        asserts = new PracticeFormAsserts(driver);
        page.inputFirstNameLine("Олег");
        page.inputLastNameLine("Олег");
        page.inputUserEmailLine("name@gmail.com");
        page.selectGenderMale();
        page.inputUserNumberLine("7788556699");
        page.inputSubject("English");
        page.selectCheckBoxMusic();
        page.uploadPicture("C:/Users/Snail/IdeaProjects/test-task1/image.jpg");
        page.inputCurrentAddress("text");
        page.selectUserState();
        page.selectUserCity();
        page.clickSubmit();
        asserts.checkModalWindow();
        asserts.checkResultModalWindow();
        return page;
    }
}
