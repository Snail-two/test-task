package com.sovcombank.qa.steps.ui;

import com.sovcombank.qa.AbstractSovcom;
import com.sovcombank.qa.asserts.ui.SovcomVacancyAssert;
import com.sovcombank.qa.page.SovcomJobOpeningsPage;
import com.sovcombank.qa.page.SovcomMainPage;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;

public class SovcomJobOpeningsStep extends AbstractSovcom {
    Logger logger = Logger.getLogger(SovcomJobOpeningsStep.class);

    @Step
    public SovcomJobOpeningsPage positiveScenarioStep() {
        SovcomMainPage mainPage = new SovcomMainPage(driver);
        SovcomJobOpeningsPage vacancyPage = new SovcomJobOpeningsPage(driver);
        SovcomVacancyAssert vacancyAssert = new SovcomVacancyAssert(driver);
        logger.info("Проверка на наличие модального окна при открытии главной страницы");
        if (mainPage.checkModalWindow()) {
            logger.info("Закрыть модальное окно");
            mainPage.closeModalWindow();
        }
        logger.info("Нажать на кнопку 'Вакансии'");
        mainPage.clickVacancy();
        logger.info("Нажать на выпадающий список 'Город'");
        vacancyPage.selectCityDropDown();
        logger.info("Нажать на город 'Москва'");
        vacancyPage.selectCity();
        logger.info("Нажать на выпадающий список 'Компании'");
        vacancyPage.selectCompanyDropDown();
        logger.info("Нажать на чек-бокс 'Свокомбанк технологии'");
        vacancyPage.selectCompany();
        logger.info("Проверка результатов поиска");
        vacancyAssert.checkCityInResults();
        return vacancyPage;
    }
}
