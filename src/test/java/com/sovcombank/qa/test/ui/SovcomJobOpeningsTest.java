package com.sovcombank.qa.test.ui;

import com.sovcombank.qa.AbstractSovcom;
import com.sovcombank.qa.asserts.ui.SovcomVacancyAssert;
import com.sovcombank.qa.page.SovcomJobOpeningsPage;
import com.sovcombank.qa.page.SovcomMainPage;
import org.junit.jupiter.api.Test;

public class SovcomJobOpeningsTest extends AbstractSovcom {

    @Test
    public void vacancy() {
        SovcomMainPage mainPage = new SovcomMainPage(driver);
        SovcomJobOpeningsPage vacancyPage = new SovcomJobOpeningsPage(driver);
        SovcomVacancyAssert vacancyAssert = new SovcomVacancyAssert(driver);
        if (mainPage.checkModalWindow()) {
            mainPage.closeModalWindow();
        }
        mainPage.clickVacancy();
        vacancyPage.selectCityDropDown();
        vacancyPage.selectCity();
        vacancyPage.selectCompanyDropDown();
        vacancyPage.selectCompany();
        vacancyAssert.checkCityInResults();
    }
}
