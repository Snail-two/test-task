package com.sovcombank.qa.asserts.api;

import com.sovcombank.qa.steps.api.RandomUserApiSteps;

import static com.github.fge.jsonschema.library.DraftV4HyperSchemaLibrary.get;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;

public class RandomUserAsserts extends RandomUserApiSteps {

    public void checkValidationJsonSchemas(){
        sendPositiveRequest().then().assertThat().body(matchesJsonSchemaInClasspath("positive_random_api.json"));
    }
}
