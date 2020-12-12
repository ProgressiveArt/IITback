package ru.csu.iit.backend.builders;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import ru.csu.iit.backend.models.commands.AuthorizationCommand;


public class AuthorizationRequestBuilder {

    private final RequestSpecification requestSpecification;
    private AuthorizationCommand authorizationCommand;

    public AuthorizationRequestBuilder(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    public AuthorizationRequestBuilder createAuthorizationCommandModel(AuthorizationCommand query) {
        this.authorizationCommand = query;
        return this;
    }

    public RequestSpecification buildAuthorizationCommand() {
        JSONObject requestBody = new JSONObject();

        if (authorizationCommand.getEmail() != null && authorizationCommand.getPassword() != null) {
            requestBody.put("email", authorizationCommand.getEmail());
            requestBody.put("password", authorizationCommand.getPassword());

            requestSpecification.body(requestBody.toString());
            return requestSpecification;
        }

        if(authorizationCommand.getEmail() != null) {
            requestBody.put("email", authorizationCommand.getEmail());

            requestSpecification.body(requestBody.toString());
            return requestSpecification;
        }

        return requestSpecification;
    }
}

