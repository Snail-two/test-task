package com.sovcombank.qa.asserts.ui;

import com.sovcombank.qa.page.SovcomJobOpeningsPage;
import com.sovcombank.qa.page.SovcomMainPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SovcomVacancyAssert extends SovcomJobOpeningsPage {
    private WebDriver driver;

    public SovcomVacancyAssert(WebDriver driver) {
        super(driver);
    }

    public void checkCityInResults(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("vacancy-main")));
        List<WebElement> vacancies = driver.findElements(By.className("vacancy-main"));
        for (WebElement vacancy : vacancies) {
            WebElement tags = vacancy.findElement(By.className("vacancy__tags"));
            String tagsText = tags.getText();
            Assert.assertTrue("Город не указан как Москва: " + tagsText, tagsText.contains("Москва"));
            Assert.assertTrue("Компания не указана как Совкомбанк Технологии: " + tagsText, tagsText.contains("Совкомбанк Технологии"));
        }
    }
}
