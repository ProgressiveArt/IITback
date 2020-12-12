package ru.csu.iit.backend.builders;

import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import ru.csu.iit.backend.models.commands.AuthorizationCommand;
import ru.csu.iit.backend.models.commands.RegistrationCommand;


public class RegistrationRequestBuilder {

    private final RequestSpecification requestSpecification;
    private RegistrationCommand registrationCommand;

    public RegistrationRequestBuilder(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    public RegistrationRequestBuilder createRegistrationCommandModel(RegistrationCommand query) {
        this.registrationCommand = query;
        return this;
    }

    public RequestSpecification buildRegistrationCommand() {
        JSONObject requestBody = new JSONObject();

        if (registrationCommand.getEmail() != null && registrationCommand.getPassword() != null) {
            requestBody.put("email", registrationCommand.getEmail());
            requestBody.put("password", registrationCommand.getPassword());

            requestSpecification.body(requestBody.toString());
            return requestSpecification;
        }

        if(registrationCommand.getEmail() != null) {
            requestBody.put("email", registrationCommand.getEmail());

            requestSpecification.body(requestBody.toString());
            return requestSpecification;
        }

        return requestSpecification;
    }
}

