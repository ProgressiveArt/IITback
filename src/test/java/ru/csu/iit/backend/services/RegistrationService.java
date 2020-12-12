package ru.csu.iit.backend.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import ru.csu.iit.backend.builders.RegistrationRequestBuilder;
import ru.csu.iit.backend.models.commands.results.RegDataModel;

import java.io.IOException;
import java.util.Properties;

public class RegistrationService extends ServiceBase {

    public RegistrationService(Properties properties, ContentType contentType) {
        super(properties, contentType);
    }

    public RegistrationRequestBuilder requestBuilder() {
        return new RegistrationRequestBuilder(baseRequest());
    }

    public RegDataModel PostRegistrationData(RequestSpecification requestSpecification) throws IOException {
        String jsonString = executePostRegistrationData(requestSpecification).getBody().prettyPrint();

        RegDataModel model = new ObjectMapper().readValue(jsonString, RegDataModel.class);

        return model;
    }

    public Response executePostRegistrationData(RequestSpecification requestSpecification) {

        return requestSpecification.post("/api/login");
    }
}
