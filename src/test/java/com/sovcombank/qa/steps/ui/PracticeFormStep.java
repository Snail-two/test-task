package com.sovcombank.qa.steps.ui;

import com.sovcombank.qa.AbstractDemoQa;
import com.sovcombank.qa.asserts.ui.PracticeFormAsserts;
import com.sovcombank.qa.page.PracticeFormPage;
import io.qameta.allure.Step;
import lombok.Getter;
import org.apache.log4j.Logger;

@Getter
public class PracticeFormStep extends AbstractDemoQa {
    private PracticeFormPage page;

    private PracticeFormAsserts asserts;
    //TODO: изменить путь файла, сделать опциональным
    //TODO: Не получилось :((

    public Logger logger = Logger.getLogger(AbstractDemoQa.class.getName());

    @Step
    public PracticeFormPage fillingFieldsValidData() throws InterruptedException {
        page = new PracticeFormPage(driver);
        asserts = new PracticeFormAsserts(driver);
        logger.info("Заполнение поля 'First Name'");
        page.inputFirstNameLine("Дмитрий");
        logger.info("Заполнение поля 'Last Name'");
        page.inputLastNameLine("Селиванов");
        logger.info("Заполнение поля 'User email'");
        page.inputUserEmailLine("selivanovds@gmail.com");
        logger.info("Выбор пола");
        page.selectGenderMale();
        logger.info("Заполнение поля 'Mobile Number'");
        page.inputUserNumberLine("7788556699");
        logger.info("Выбор даты");
        page.selectUserBirthsDay();
        logger.info("Заполнение поля 'Subject'");
        page.inputSubject("English");
        logger.info("Выбор хобби");
        page.selectCheckBoxMusic();
        logger.info("Загрузка изображения");
        page.uploadPicture("C:/Users/Snail/IdeaProjects/test-task1/image.jpg");
        logger.info("Ввод адреса");
        page.inputCurrentAddress("text");
        logger.info("Выбор страны");
        page.selectUserState();
        logger.info("Выбор города");
        page.selectUserCity();
        logger.info("Нажатие на кнопку Submit'");
        page.clickSubmit();
        logger.info("Проверка отображения модального окна");
        asserts.checkModalWindow();
        logger.info("Проверка корректность заполненного модального окна");
        asserts.checkResultModalWindow();
        return page;
    }

    @Step
    public PracticeFormPage fillingRequiredFields() {
        page = new PracticeFormPage(driver);
        asserts = new PracticeFormAsserts(driver);
        logger.info("Заполнение поля 'First Name'");
        page.inputFirstNameLine("Дмитрий");
        logger.info("Заполнение поля 'Last Name'");
        page.inputLastNameLine("Селиванов");
        logger.info("Выбор пола");
        page.selectGenderMale();
        logger.info("Заполнение поля 'Mobile Number'");
        page.inputUserNumberLine("7788556699");
        logger.info("Ввод адреса");
        logger.info("Выбор страны");
        logger.info("Нажатие на кнопку Submit'");
        page.clickSubmit();
        logger.info("Проверка отображения модального окна");
        asserts.checkModalWindow();
        logger.info("Проверка корректность заполненного модального окна");
        asserts.checkModalWindowRequiredField();
        return page;
    }

    @Step
    public PracticeFormPage fillingOptionalFields() {
        page = new PracticeFormPage(driver);
        asserts = new PracticeFormAsserts(driver);
        logger.info("Заполнение поля 'User email'");
        page.inputUserEmailLine("selivanovds@gmail.com");
        logger.info("Заполнение поля 'Subject'");
        page.inputSubject("English");
        logger.info("Ввод адреса");
        page.inputCurrentAddress("text");
        logger.info("Выбор страны");
        page.selectUserState();
        logger.info("Выбор города");
        page.selectUserCity();
        logger.info("Нажатие на кнопку 'Submit'");
        page.clickSubmit();
        logger.info("Проверка нажатия кнопки и отображения модального окна");
        asserts.checkModalWindowOptionalField();
        return page;
    }
}
