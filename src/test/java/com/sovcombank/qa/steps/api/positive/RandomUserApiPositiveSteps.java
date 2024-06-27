package com.sovcombank.qa.steps.api.positive;

import com.sovcombank.qa.ConfProperties;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

import static com.sovcombank.qa.endpoints.Endpoints.URL_RANDOM_API;

public class RandomUserApiPositiveSteps {
    @Step
    public Response sendPositiveRequest() {
        Response response = RestAssured.given().log().all()
                .when()
                .contentType(ContentType.JSON)
                .get(ConfProperties.getProperty("api_url_randomUser") + URL_RANDOM_API)
                .then().log().all()
                .extract().response();
        return response;
    }

    @Step
    public Response sendPositiveRequestUseQueryParams(Map<String, String> queryParameter1, Map<String, Integer> queryParameter2) {
        Response response = RestAssured.given().log().all()
                .when()
                .contentType(ContentType.JSON)
                .queryParams(queryParameter1)
                .queryParams(queryParameter2)
                .get(ConfProperties.getProperty("api_url_randomUser") + URL_RANDOM_API)
                .then().log().all()
                .extract().response();
        return response;
    }
}
