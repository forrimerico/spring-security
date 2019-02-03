package com.imooc.web.Controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.imooc.dto.User;
import com.imooc.dto.UserQueryCondition;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @JsonView(User.userSimpleView.class)
    public List<User> user(UserQueryCondition userQueryCondition)
    {
        System.out.println(ReflectionToStringBuilder
                .toString(userQueryCondition, ToStringStyle.MULTI_LINE_STYLE));
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());

        return users;
    }

    @RequestMapping(value = "/user/{id:\\d+}", method = RequestMethod.GET)
    @JsonView(User.userDetailView.class)
    public User getUser(@PathVariable(name = "id") String id)
    {
        User user = new User();
        user.setUsername("tom");
        return user;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @JsonView(User.userSimpleView.class)
    // 加了 RequestBody 后可以直接解析json串
    public User Create(@RequestBody @Valid User user, BindingResult error) throws Exception
    {
        if (error.hasErrors()) {
            error.getAllErrors().stream().forEach(err -> System.out.println(err.getDefaultMessage()));
            throw new Exception("error");
        }
        user.setId("1");

        return user;
    }

    @RequestMapping(value = "/user/{id:\\d+}", method = RequestMethod.PUT)
    @JsonView(User.userSimpleView.class)
    // 加了 RequestBody 后可以直接解析json串
    public User update(@RequestBody @Valid User user, BindingResult error) throws Exception
    {
        if (error.hasErrors()) {
            error.getAllErrors().stream().forEach(err -> System.out.println(err.getDefaultMessage()));
//            throw new Exception("error");
        }
        user.setId("1");

        return user;
    }
}
