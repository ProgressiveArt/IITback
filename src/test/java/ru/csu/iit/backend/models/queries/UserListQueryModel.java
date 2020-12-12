package ru.csu.iit.backend.models.queries;

public class UserListQueryModel {
    private Integer page;

    public UserListQueryModel(Integer page) {
        this.page = page;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
