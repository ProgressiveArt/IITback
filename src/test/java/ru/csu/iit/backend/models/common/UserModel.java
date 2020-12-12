package ru.csu.iit.backend.models.common;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserModel {
    @JsonProperty(value = "id")
    public int Id;
    @JsonProperty(value = "email")
    public String email;
    @JsonProperty(value = "first_name")
    public String firstName;
    @JsonProperty(value = "last_name")
    public String lastName;
    @JsonProperty(value = "avatar")
    public String avatarUrl;
}
