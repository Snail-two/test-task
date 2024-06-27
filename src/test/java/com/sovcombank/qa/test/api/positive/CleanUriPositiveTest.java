package com.sovcombank.qa.test.api.positive;

import com.sovcombank.qa.LinkProperties;
import com.sovcombank.qa.steps.api.positive.*;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static com.sovcombank.qa.AbstractApi.getResourceAsString;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class CleanUriPositiveTest extends CleanUriPositiveSteps {

    Logger logger = Logger.getLogger(CleanUriPositiveTest.class);

    @Test
    public void sendPositiveRequestTest() throws IOException {
        logger.info("Вызов метода");
        List<String> list = List.of("url_1", "url_2", "url_3");

        for (int i = 0; i < list.size(); i++){
            var body = getResourceAsString("body_url.json")
                    .replace("value", LinkProperties.getProperty(list.get(i)));
            var result = sendPositiveRequest(body);

            logger.info("Проверка json схемы");
            result.then().assertThat().body(matchesJsonSchemaInClasspath("positive_cleanUp_api.json"));

            logger.info("Проверка статус кода");
            result.then().assertThat().statusCode(200);
        }

    }
}
