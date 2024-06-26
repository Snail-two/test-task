package com.sovcombank.qa.steps.api;

import com.sovcombank.qa.ConfProperties;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;

import static com.sovcombank.qa.endpoints.Endpoints.URL_RANDOM_API;

public class RandomUserApiNegativeSteps {
    @Step
    public Response sendNegativeRequest(Method method){
        Response response = RestAssured.given().log().all()
                .when()
                .contentType(ContentType.JSON)
                .request(method, ConfProperties.getProperty("api_url") + URL_RANDOM_API)
                .then().log().all()
                .extract().response();
        return response;
    }

    @Step
    public Response sendRequestOnNegativeEndpoint(String endpoint){
        Response response = RestAssured.given().log().all()
                .when()
                .contentType(ContentType.JSON)
                .get(ConfProperties.getProperty("api_url") + endpoint)
                .then().log().all()
                .extract().response();
        return response;
    }
}
