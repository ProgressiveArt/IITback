package ru.csu.iit.backend.models.commands.results;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegDataModel {
    @JsonProperty(value = "id")
    private int id;
    @JsonProperty(value = "token")
    private String token;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
