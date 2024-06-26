package com.sovcombank.qa.steps.api.positive;

import com.sovcombank.qa.ConfProperties;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static com.sovcombank.qa.endpoints.Endpoints.URL_CLEAN;

public class CleanUriPositiveSteps {

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
}
