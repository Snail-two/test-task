package com.sovcombank.qa.steps.api;

import com.sovcombank.qa.ConfProperties;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.*;
import org.apache.xalan.lib.sql.QueryParameter;

import java.util.Map;

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

    @Step
    public Response sendPositiveRequestUseQueryParams(Map<String, String> queryParameter1, Map<String, Integer> queryParameter2){
        Response response = RestAssured.given().log().all()
                .when()
                .contentType(ContentType.JSON)
                .queryParams(queryParameter1)
                .queryParams(queryParameter2)
                .get(ConfProperties.getProperty("api_url") + URL_RANDOM_API)
                .then().log().all()
                .extract().response();
        return response;
    }

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
