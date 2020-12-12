package ru.csu.iit.backend.models.common;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SupportModel {
    @JsonProperty(value = "url")
    public String url;

    @JsonProperty(value = "text")
    public String text;
}
