package ru.csu.iit.backend.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import ru.csu.iit.backend.builders.UserRequestBuilder;
import ru.csu.iit.backend.models.common.UserListModel;

import java.io.IOException;
import java.util.Properties;

public class UserService extends ServiceBase{

    public UserService(Properties properties, ContentType contentType) {
        super(properties, contentType);
    }

    public UserRequestBuilder requestBuilder() {
        return new UserRequestBuilder(baseRequest());
    }

    public UserListModel getUserListData(RequestSpecification requestSpecification) throws IOException {

        String jsonString = executeGetUserListQuery(requestSpecification).getBody().prettyPrint();

        UserListModel model = new ObjectMapper().readValue(jsonString, UserListModel.class);

        return model;
    }

    public Response executeGetUserListQuery(RequestSpecification requestSpecification) {

        return requestSpecification.get("/api/users");
    }
}
