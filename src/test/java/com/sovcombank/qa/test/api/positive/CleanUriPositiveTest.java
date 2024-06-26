package com.sovcombank.qa.test.api.positive;

import com.sovcombank.qa.LinkProperties;
import com.sovcombank.qa.steps.api.positive.CleanUriPositiveSteps;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

import static com.sovcombank.qa.AbstractApi.getResourceAsString;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class CleanUriPositiveTest extends CleanUriPositiveSteps {

    /*
    Чек лист для ссылок:
    1. Вызвать метод с корректными данными
    2. Вызвать метод без тела запроса
    3. Вызвать метод с невалидными типами запроса
    4. Проверить ответ на json схему
    5. Проверить ответ на статус код
    6. Проверить ответ на текст ошибки
     */

    Logger logger = Logger.getLogger(CleanUriPositiveTest.class);

    @Test
    @DisplayName("Вызов корректного метода")
    public void sendPositiveRequestTest() {
        logger.info("Вызов метода");
        List<String> list = List.of("url_1", "url_2", "url_3");

        for (int i = 0; i < list.size(); i++) {
            var body = getResourceAsString("body_url.json")
                    .replace("value", LinkProperties.getProperty(list.get(i)));
            var response = sendPositiveRequest(body);

            logger.info("Проверка json схемы");
            response.then().assertThat().body(matchesJsonSchemaInClasspath("positive_cleanUp_api.json"));

            logger.info("Проверка статус кода");
            response.then().assertThat().statusCode(200);
        }

    }
}
