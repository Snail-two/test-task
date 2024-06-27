package com.sovcombank.qa.test.ui;

import com.sovcombank.qa.AbstractSovcom;
import com.sovcombank.qa.page.SovcomJobOpeningsPage;
import com.sovcombank.qa.page.SovcomMainPage;
import org.junit.jupiter.api.Test;

public class SovcomJobOpeningsTest extends AbstractSovcom {

    @Test
    public void vacancy(){
        SovcomMainPage mainPage = new SovcomMainPage(driver);
        SovcomJobOpeningsPage jobPage = new SovcomJobOpeningsPage(driver);
        if (mainPage.checkModalWindow()){
            mainPage.closeModalWindow();
        }
        mainPage.clickVacancy();
        jobPage.selectCityDropDown();
        jobPage.selectCity();
        jobPage.selectCompanyDropDown();
        jobPage.selectCompany();
    }
}
