package org.example.client;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.example.config.Configuration;

public class RestClient {

    public RequestSpecification basicRequestSpecification() {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .baseUri(Configuration.CONFIG.baseUrl())
                .filter(new AllureRestAssured())
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

}
