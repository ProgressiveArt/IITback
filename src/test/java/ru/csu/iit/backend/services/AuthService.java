package ru.csu.iit.backend.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import ru.csu.iit.backend.builders.AuthorizationRequestBuilder;
import ru.csu.iit.backend.models.commands.results.AuthDataModel;

import java.io.IOException;
import java.util.Properties;

public class AuthService extends ServiceBase {

    public AuthService(Properties properties, ContentType contentType) {
        super(properties, contentType);
    }

    public AuthorizationRequestBuilder requestBuilder() {
        return new AuthorizationRequestBuilder(baseRequest());
    }

    public AuthDataModel PostAuthorizationData(RequestSpecification requestSpecification) throws IOException {
        String jsonString = executePostAuthorizationData(requestSpecification).getBody().prettyPrint();

        AuthDataModel model = new ObjectMapper().readValue(jsonString, AuthDataModel.class);

        return model;
    }

    public Response executePostAuthorizationData(RequestSpecification requestSpecification) {

        return requestSpecification.post("/api/login");
    }
}
