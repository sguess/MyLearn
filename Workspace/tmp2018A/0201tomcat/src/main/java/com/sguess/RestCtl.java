package com.sguess;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestCtl {

    @GetMapping(value = "/get/alluser/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<User> getUserList(@RequestHeader RequestHeader header) {
        List<User> userList = new ArrayList<User>();
        userList.add(new User("Tom", "address 01"));
        userList.add(new User("Jerry", "address 02"));
        return userList;
    }

    @GetMapping(value = "/get/user/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User getUserById(@PathVariable("id") String id) {
        User user = new User("Tom", "Address 01");
        return user;
    }

    @GetMapping(value = "/zh", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User zh() {
        User user = new User("中文", "Address 02");
        return user;
    }
}
