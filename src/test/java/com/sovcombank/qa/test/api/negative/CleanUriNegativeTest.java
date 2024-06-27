package com.sovcombank.qa.test.api.negative;

import com.sovcombank.qa.LinkProperties;
import com.sovcombank.qa.steps.api.negative.CleanUriNegativeSteps;
import io.restassured.http.Method;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.sovcombank.qa.AbstractApi.getResourceAsString;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class CleanUriNegativeTest extends CleanUriNegativeSteps {

    public final Method get = Method.GET;
    public final Method patch = Method.PATCH;
    public final Method post = Method.POST;
    public final Method put = Method.PUT;
    public final Method delete = Method.DELETE;

    Logger logger = Logger.getLogger(CleanUriNegativeTest.class);
    @Test
    public void sendRequestNullBodyTest(){
        logger.info("Вызов метода");
        var response = sendRequestNullBody();

        logger.info("Проверка json схемы");
        response.then().assertThat().body(matchesJsonSchemaInClasspath("negative_cleanUp_api.json"));

        logger.info("Проверка статус кода");
        response.then().assertThat().statusCode(400);

        logger.info("Проверка текста ошибки");
        String error = response.jsonPath().getString("error");
        Assertions.assertEquals("API Error: URL is empty", error);
    }

    @Test
    public void sendRequestInvalidMethodTest(){
        var body = getResourceAsString("body_url.json")
                .replace("value", LinkProperties.getProperty(("url_1")));
        logger.info("Вызов метода с типом запроса 'GET'");
        var responseMethodGet = sendRequestInvalidMethod(get, body);
        logger.info("Проверка статус кода");
        responseMethodGet.then().assertThat().statusCode(405);

        logger.info("Вызов метода с типом запроса 'PATCH'");
        var responseMethodPatch = sendRequestInvalidMethod(patch, body);
        logger.info("Проверка статус кода");
        responseMethodPatch.then().assertThat().statusCode(405);

        logger.info("Вызов метода с типом запроса 'DELETE'");
        var responseMethodDelete = sendRequestInvalidMethod(delete, body);
        logger.info("Проверка статус кода");
        responseMethodDelete.then().assertThat().statusCode(405);

        logger.info("Вызов метода с типом запроса 'PUT'");
        var responseMethodPut = sendRequestInvalidMethod(put, body);
        logger.info("Проверка статус кода");
        responseMethodPut.then().assertThat().statusCode(405);
    }
}
