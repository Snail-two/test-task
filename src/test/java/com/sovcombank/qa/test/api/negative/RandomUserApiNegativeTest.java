package com.sovcombank.qa.test.api.negative;

import com.sovcombank.qa.steps.api.negative.RandomUserApiNegativeSteps;
import io.restassured.http.Method;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomUserApiNegativeTest extends RandomUserApiNegativeSteps {
    public final Method post = Method.POST;

    public final Method get = Method.GET;

    public final Method delete = Method.DELETE;

    public final Method patch = Method.PATCH;

    public final Method put = Method.PUT;

    Logger logger = Logger.getLogger(RandomUserApiNegativeTest.class.getName());

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
    public void sendRequestOnNegativeEndpointTest() {
        logger.info("Вызов метода");
        var negativeTest = sendRequestOnNegativeEndpoint("snail");
        logger.info("Проверка статус кода");
        negativeTest.then().assertThat().statusCode(404);
    }
}
