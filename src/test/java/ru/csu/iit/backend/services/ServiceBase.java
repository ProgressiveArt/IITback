package ru.csu.iit.backend.services;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.Properties;

import static io.restassured.RestAssured.given;

public abstract class ServiceBase {
    private final RequestSpecification spec;

    public ServiceBase(Properties properties, ContentType contentType) {
        RequestSpecBuilder specBuilder = new RequestSpecBuilder()
                .setContentType(contentType)
                .setBaseUri(properties.getProperty("base_uri"));

        boolean isDevEnvironment = Boolean.parseBoolean(properties.getProperty("dev", "false"));

        if (isDevEnvironment) {
            specBuilder.addFilter(new RequestLoggingFilter())
                    .addFilter(new ResponseLoggingFilter());
        }

        spec = specBuilder.build();
    }

    protected RequestSpecification baseRequest() {
        return given().spec(spec);
    }
}
