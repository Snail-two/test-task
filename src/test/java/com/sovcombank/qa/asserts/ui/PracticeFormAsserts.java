package com.sovcombank.qa.asserts.ui;

import com.sovcombank.qa.AbstractDemoQa;
import com.sovcombank.qa.page.PracticeFormPage;
import org.apache.hc.core5.net.WWWFormCodec;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PracticeFormAsserts extends PracticeFormPage {

    public PracticeFormAsserts(WebDriver driver) {
        super(driver);
    }

    public void checkModalWindow(){
        assertTrue(getModalContent().isDisplayed());
    }

    //TODO: Переделать асерты (мне не нравится как сделано сейчас)
    //TODO: Добавить проверку на корректность заголовка модального окна
    public void checkResultModalWindow(){
        Map<String, String> formData = new HashMap<>();
        formData.put("Student Name", "Олег Олег");
        formData.put("Student Email", "name@gmail.com");
        formData.put("Gender", "Male");
        formData.put("Mobile", "7788556699");
        formData.put("Date of Birth", "26 June,2024");
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
}
