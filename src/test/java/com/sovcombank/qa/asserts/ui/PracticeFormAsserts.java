package com.sovcombank.qa.asserts.ui;

import com.sovcombank.qa.page.PracticeFormPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PracticeFormAsserts extends PracticeFormPage {
    Logger logger = Logger.getLogger(PracticeFormAsserts.class);

    public PracticeFormAsserts(WebDriver driver) {
        super(driver);
    }

    public void checkModalWindow() {
        assertTrue(getModalContent().isDisplayed());
    }

    public void checkResultModalWindow() {
        Map<String, String> formData = new HashMap<>();
        formData.put("Student Name", "Дмитрий Селиванов");
        formData.put("Student Email", "selivanovds@gmail.com");
        formData.put("Gender", "Male");
        formData.put("Mobile", "7788556699");
        formData.put("Date of Birth", "09 April,2024");
        formData.put("Subjects", "English");
        formData.put("Hobbies", "Music");
        formData.put("Picture", "image.jpg");
        formData.put("Address", "text");
        formData.put("State and City", "NCR Delhi");

        for (Map.Entry<String, String> entry : formData.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            String xpath = "//td[text()='" + key + "']/following-sibling::td";
            WebElement tableCell = driver.findElement(By.xpath(xpath));
            assertEquals("Value for " + key + " does not match", value, tableCell.getText());
        }
    }

    public void checkModalWindowRequiredField() {
        Map<String, String> formData = new HashMap<>();
        formData.put("Student Name", "Дмитрий Селиванов");
        formData.put("Student Email", "");
        formData.put("Gender", "Male");
        formData.put("Mobile", "7788556699");
        formData.put("Date of Birth", "27 June,2024");

        for (Map.Entry<String, String> entry : formData.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            String xpath = "//td[text()='" + key + "']/following-sibling::td";
            WebElement tableCell = driver.findElement(By.xpath(xpath));
            assertEquals("Value for " + key + " does not match", value, tableCell.getText());
        }
    }

    public void checkModalWindowOptionalField() {
        if (!getModalContent().isDisplayed()) {
            logger.info("Не отображается модальное окно");
        }
        logger.error("Модалное окно отображается");
    }
}
