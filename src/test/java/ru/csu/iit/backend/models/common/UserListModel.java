package ru.csu.iit.backend.models.common;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

public class UserListModel {
    @JsonProperty(value = "page")
    public int CurrentPage;

    @JsonProperty(value = "per_page")
    public int CountRecordsOnPage;

    @JsonProperty(value = "total")
    public int CountRecords;

    @JsonProperty(value = "total_pages")
    public int CountPages;

    @JsonProperty(value = "data")
    public Collection<UserModel> Records;

    @JsonProperty(value = "support")
    public SupportModel support;
}
