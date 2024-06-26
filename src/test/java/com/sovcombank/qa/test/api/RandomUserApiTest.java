package com.sovcombank.qa.test.api;

import com.sovcombank.qa.steps.api.RandomUserApiSteps;
import org.junit.jupiter.api.Test;
import com.sovcombank.qa.asserts.api.RandomUserAsserts;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;

public class RandomUserApiTest extends RandomUserApiSteps {

    @Test
    public void sendPositiveTest(){
        var test = sendPositiveRequest();
        test.then().assertThat().body(matchesJsonSchemaInClasspath("positive_random_api.json"));
    }

    @Test
    public void sendPositiveTestUseQueryParams(){

    }
}
