package com.sovcombank.qa.steps.api;

import com.sovcombank.qa.ConfProperties;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.*;

import static com.sovcombank.qa.endpoints.Endpoints.URL_RANDOM_API;

public class RandomUserApiSteps {
    @Step
    public Response sendPositiveRequest(){
        Response response = RestAssured.given().log().all()
                .when()
                .contentType(ContentType.JSON)
                .get(ConfProperties.getProperty("api_url") + URL_RANDOM_API)
                .then().log().all()
                .extract().response();
        return response;
    }
}
