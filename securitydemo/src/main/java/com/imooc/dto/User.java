package com.imooc.dto;

import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Past;
import java.util.Date;

public class User {

    public interface userSimpleView {};
    public interface userDetailView extends userSimpleView {};

    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;

    private String id;

    @Past(message = "生日必须是过去的时间")
    private Date birthDay;

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

    @JsonView(userSimpleView.class)
    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    @JsonView(userSimpleView.class)
    public Date getBirthDay() { return birthDay; }

    public void setBirthDay(Date birthDay) { this.birthDay = birthDay; }
}
