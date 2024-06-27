package com.sovcombank.qa.asserts.ui;

import com.sovcombank.qa.page.SovcomJobOpeningsPage;
import com.sovcombank.qa.page.SovcomMainPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class SovcomVacancyAssert extends SovcomJobOpeningsPage {
    public SovcomVacancyAssert(WebDriver driver) {
        super(driver);
    }

    public void checkCityInResults() {
        List<WebElement> vacancies = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".section-vacancies .vacancy-main")));
        List<String> errors = new ArrayList<>();

        for (WebElement vacancy : vacancies) {
            WebElement tagsElement = vacancy.findElement(By.cssSelector(".vacancy__tags span.t2vac"));
            String tagsText = tagsElement.getText();

            if (!tagsText.contains("Москва")) {
                errors.add("Город не указан как Москва в вакансии: " + tagsText);
            }

            if (!tagsText.contains("Совкомбанк Технологии")) {
                errors.add("Компания не указана как Совкомбанк Технологии в вакансии: " + tagsText);
            }
        }

        assertTrue("Ошибки: \n" + String.join("\n", errors), errors.isEmpty());
    }
}
