package com.sovcombank.qa.test.api;

import com.sovcombank.qa.steps.api.RandomUserApiSteps;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.Map;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RandomUserApiTest extends RandomUserApiSteps {

    public static final Method post = Method.POST;
    public static final Method get = Method.GET;
    public static final Method delete = Method.DELETE;
    public static final Method patch = Method.PATCH;
    public static final Method put = Method.PUT;

    Logger logger = Logger.getLogger(RandomUserApiTest.class.getName());

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

    @Test
    @DisplayName("Вызов метода с некорректным типом запроса")
    public void sendNegativeRequestUseNegativeMethodTest() {
        logger.info("Вызов метода с типом запроса POST");
        var negativePost = sendNegativeRequest(post);
        logger.info("Проверка статус кода");
        negativePost.then().assertThat().statusCode(404);

        logger.info("Вызов метода с типом запроса PATCH");
        var negativePatch = sendNegativeRequest(patch);
        logger.info("Проверка статус кода");
        negativePatch.then().assertThat().statusCode(404);

        logger.info("Вызов метода с типом запроса PUT");
        var negativePut = sendNegativeRequest(put);
        logger.info("Проверка статус кода");
        negativePut.then().assertThat().statusCode(404);

        logger.info("Вызов метода с типом запроса DELETE");
        var negativeDelete = sendNegativeRequest(delete);
        logger.info("Проверка статус кода");
        negativeDelete.then().assertThat().statusCode(404);
    }

    @Test
    @DisplayName("Вызов метода на несуществующий endpoint")
    public void sendRequestOnNegativeEndpointTest(){
        logger.info("Вызов метода");
        var negativeTest = sendRequestOnNegativeEndpoint("snail");
        logger.info("Проверка статус кода");
        negativeTest.then().assertThat().statusCode(404);

    }
}
