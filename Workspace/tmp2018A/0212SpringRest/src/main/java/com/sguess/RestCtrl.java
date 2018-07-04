package com.sguess;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/rest")
public class RestCtrl {
    @RequestMapping(path = "/get01/{id}")
    public ResponseEntity<?> get01(@PathVariable int id) {
        User user = new User("Tom", id * 10);
        user.setId(id);
        if (user == null) {
            Error error = new Error(4, "Spittle [" + id + "] not found");
            return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(path = "/get02/{id}")
    public User get02(@PathVariable int id) {
        User user = new User("Tom", 2);
        user.setId(id);
        return user;
    }

    @RequestMapping(path = "/get03")
    public User get03() {
        System.out.println("----------------Start fun get03");
        User user = new User("Tom", 3);
        return user;
    }
}
