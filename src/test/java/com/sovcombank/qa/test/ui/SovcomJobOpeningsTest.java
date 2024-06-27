package com.sovcombank.qa.test.ui;

import com.sovcombank.qa.AbstractSovcom;
import com.sovcombank.qa.asserts.ui.SovcomVacancyAssert;
import com.sovcombank.qa.page.SovcomJobOpeningsPage;
import com.sovcombank.qa.page.SovcomMainPage;
import com.sovcombank.qa.steps.ui.SovcomJobOpeningsStep;
import org.junit.jupiter.api.Test;

public class SovcomJobOpeningsTest extends SovcomJobOpeningsStep {

    @Test
    public void vacancy() {
        SovcomJobOpeningsPage page = positiveScenarioStep();
    }
}
