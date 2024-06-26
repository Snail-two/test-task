package com.sovcombank.qa.test.api;

import com.sovcombank.qa.steps.api.RandomUserApiSteps;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.LoggerFactory;


import java.util.Map;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;

public class RandomUserApiTest extends RandomUserApiSteps {

    Logger logger = Logger.getLogger(RandomUserApiTest.class.getName());

    @Test
    public void sendPositiveTest(){
        logger.info("Запуск теста");
        var test = sendPositiveRequest();
        test.then().assertThat().body(matchesJsonSchemaInClasspath("positive_random_api.json"));
    }

    @Test
    public void sendPositiveTestUseQueryParams(){
        Map<String, String> queryParams1 = Map.of("gender", "female");
        Map<String, Integer> queryParams2 = Map.of("results", 2);
        var test = sendPositiveRequestUseQueryParams(queryParams1, queryParams2);
    }
}
