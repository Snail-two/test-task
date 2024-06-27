package com.sovcombank.qa.steps.api.negative;

import com.sovcombank.qa.ConfProperties;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;

import static com.sovcombank.qa.endpoints.Endpoints.URL_CLEAN;

public class CleanUriNegativeSteps {

    @Step
    public Response sendRequestNullBody() {
        Response response = RestAssured.given().log().all()
                .when()
                .contentType(ContentType.JSON)
                .post(ConfProperties.getProperty("api_url_cleanUri") + URL_CLEAN)
                .then().log().all()
                .extract().response();
        return response;
    }

    @Step
    public Response sendRequestInvalidMethod(Method method, String body) {
        Response response = RestAssured.given().log().all()
                .when()
                .contentType(ContentType.JSON)
                .body(body)
                .request(method, ConfProperties.getProperty("api_url_cleanUri") + URL_CLEAN)
                .then().log().all()
                .extract().response();
        return response;
    }
}
