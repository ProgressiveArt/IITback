package ru.csu.iit.backend.builders;

import io.restassured.specification.*;
import ru.csu.iit.backend.models.queries.UserListQueryModel;


public class UserRequestBuilder {

    private final RequestSpecification requestSpecification;
    private UserListQueryModel userListQueryModel;

    public UserRequestBuilder(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    public UserRequestBuilder createUserListQueryModel(UserListQueryModel query) {
        this.userListQueryModel = query;
        return this;
    }

    public RequestSpecification buildUserListQuery() {
        if(userListQueryModel.getPage() != null) {
            requestSpecification.queryParam("page", userListQueryModel.getPage());
        }

        return requestSpecification;
    }
}

