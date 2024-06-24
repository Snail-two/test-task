package com.sovcombank.qa.ui;

import com.sovcombank.qa.page.PracticeFormPage;
import com.sovcombank.qa.steps.PracticeFormStep;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PracticeFormTest extends PracticeFormStep  {

    @Test
    @DisplayName("Заполнение корректными данными")
    public void inputPracticeForm() {
        PracticeFormPage page = fillingFieldsValidData();
    }
}
