package com.sovcombank.qa.test.api.positive;

import com.sovcombank.qa.steps.api.positive.RandomUserApiPositiveSteps;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class RandomUserApiPositiveTest extends RandomUserApiPositiveSteps {

    /*
    Чек лист для random user:
    1. Вызвать метод без параметров
    2. Вызвать метод с параметрами
    3. Вызвать метод с некорректным типом запроса
    4. вызвать метод на несуществующий endpoint
    5. Проверить ответ на json схему
    6. Проверить ответ на статус код
    7. Проверить что переданный в параметре аргумент совпадает с значением в ответе
     */

    Logger logger = Logger.getLogger(RandomUserApiPositiveTest.class.getName());

    @Test
    @DisplayName("Выполнение корректного метода без параметров")
    public void sendPositiveRequestTest() {
        logger.info("Запуск теста");
        var response = sendPositiveRequest();
//        response.then().assertThat().body(matchesJsonSchemaInClasspath("positive_random_api.json"));
    }

    @Test
    @DisplayName("Выполнение корректного метода с параметрами")
    public void sendPositiveTestUseQueryParamsTest() {
        Map<String, String> queryParams1 = Map.of("gender", "female");
        Map<String, Integer> queryParams2 = Map.of("results", 2);
        logger.info("Вызов метода");
        var response = sendPositiveRequestUseQueryParams(queryParams1, queryParams2);
//        logger.info("Проверка json схемы на валидность");
//        response.then().assertThat().body(matchesJsonSchemaInClasspath("positive_random_api.json"));

        logger.info("Проверка статус кода");
        response.then().assertThat().statusCode(200);

        logger.info("Проверка значений переданных в параметрах и полученных в ответе");
        String text = response.jsonPath().getString("results[0].gender");
        Assertions.assertEquals(queryParams1.get("gender"), text);
    }
}
