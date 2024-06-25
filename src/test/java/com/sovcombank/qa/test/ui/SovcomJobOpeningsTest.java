package com.sovcombank.qa.test.ui;

import com.sovcombank.qa.AbstractSovcom;
import com.sovcombank.qa.asserts.SovcomMainAssert;
import com.sovcombank.qa.page.SovcomMainPage;
import org.junit.jupiter.api.Test;

public class SovcomJobOpeningsTest extends AbstractSovcom {

    @Test
    public void vacancy(){
        SovcomMainPage page = new SovcomMainPage(driver);
        SovcomMainAssert mainAssert = new SovcomMainAssert(driver);
        if (page.checkModalWindow()){
            page.closeModalWindow();
        }
        page.clickVacancy();
    }
}
