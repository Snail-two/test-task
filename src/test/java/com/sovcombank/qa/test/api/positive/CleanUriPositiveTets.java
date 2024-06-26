package com.sovcombank.qa.test.api.positive;

import com.sovcombank.qa.AbstractApi;
import com.sovcombank.qa.ConfProperties;
import com.sovcombank.qa.LinkProperties;
import com.sovcombank.qa.steps.api.positive.*;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.jupiter.api.TestTemplate;

import java.io.IOException;

import static com.sovcombank.qa.endpoints.Endpoints.URL_CLEAN;

public class CleanUriPositiveTets extends AbstractApi {

    @Step
    public Response sendPositiveRequest(String body){
        Response response = RestAssured.given().log().all()
                .when()
                .contentType(ContentType.JSON)
                .body(body)
                .post(ConfProperties.getProperty("api_url_cleanUri") + URL_CLEAN)
                .then().log().all()
                .extract().response();
        return response;
    }

    @Test
    public void test() throws IOException {
        var body = getResourceAsString("body_url.json")
                .replace("value", LinkProperties.getProperty("url_1"));
        var result = sendPositiveRequest(body);
    }
}
