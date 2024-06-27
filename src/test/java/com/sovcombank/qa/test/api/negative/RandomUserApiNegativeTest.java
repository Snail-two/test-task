package com.sovcombank.qa.test.api.negative;

import com.sovcombank.qa.steps.api.negative.RandomUserApiNegativeSteps;
import io.restassured.http.Method;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomUserApiNegativeTest extends RandomUserApiNegativeSteps {


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
        var negativePost = sendNegativeRequestUseNegativeMethod(post);
        logger.info("Проверка статус кода");
        negativePost.then().assertThat().statusCode(404);

        logger.info("Вызов метода с типом запроса PATCH");
        var negativePatch = sendNegativeRequestUseNegativeMethod(patch);
        logger.info("Проверка статус кода");
        negativePatch.then().assertThat().statusCode(404);

        logger.info("Вызов метода с типом запроса PUT");
        var negativePut = sendNegativeRequestUseNegativeMethod(put);
        logger.info("Проверка статус кода");
        negativePut.then().assertThat().statusCode(404);

        logger.info("Вызов метода с типом запроса DELETE");
        var negativeDelete = sendNegativeRequestUseNegativeMethod(delete);
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
