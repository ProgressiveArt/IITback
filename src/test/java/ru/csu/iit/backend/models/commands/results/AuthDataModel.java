package ru.csu.iit.backend.models.commands.results;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthDataModel {

    @JsonProperty(value = "token")
    private String token;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
