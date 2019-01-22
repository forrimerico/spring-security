package com.imooc.dto;

import com.fasterxml.jackson.annotation.JsonView;

public class User {

    public interface userSimpleView {};
    public interface userDetailView extends userSimpleView {};

    private String username;

    private String password;

    @JsonView(userSimpleView.class)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonView(userDetailView.class)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
