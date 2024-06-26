package com.sovcombank.qa.test.api;

import com.sovcombank.qa.steps.api.RandomUserApiPositiveSteps;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class RandomUserApiPositiveTest extends RandomUserApiPositiveSteps {

    Logger logger = Logger.getLogger(RandomUserApiPositiveTest.class.getName());

    @Test
    @DisplayName("Выполнение корректного запроса без параметров")
    public void sendPositiveTest() {
        logger.info("Запуск теста");
        var positiveTest = sendPositiveRequest();
        positiveTest.then().assertThat().body(matchesJsonSchemaInClasspath("positive_random_api.json"));
    }

    @Test
    @DisplayName("Выполнение корректного запроса с параметрами")
    public void sendPositiveTestUseQueryParamsTest() {
        Map<String, String> queryParams1 = Map.of("gender", "female");
        Map<String, Integer> queryParams2 = Map.of("results", 2);
        logger.info("Вызов метода");
        var positiveRequestUseQueryParams = sendPositiveRequestUseQueryParams(queryParams1, queryParams2);
        logger.info("Проверка json схемы на валидность");
        positiveRequestUseQueryParams.then().assertThat().body(matchesJsonSchemaInClasspath("positive_random_api.json"));

        logger.info("Проверка статус кода");
        positiveRequestUseQueryParams.then().assertThat().statusCode(200);

        logger.info("Проверка значений переданных в параметрах и полученных в ответе");
        String text = positiveRequestUseQueryParams.jsonPath().getString("results[0].gender");
        Assertions.assertEquals(queryParams1.get("gender"), text);
    }
}
