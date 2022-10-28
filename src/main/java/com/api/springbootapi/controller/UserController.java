package com.api.springbootapi.controller;

import com.api.springbootapi.dao.UserDao;
import com.api.springbootapi.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user/post")
public class UserController {
    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/")
    public String Hello() {
        return "Hello Welcome User API";
    }

    @PostMapping("/user")
    public User addAndGet() {
        userDao.add(new User("1", "geun", "1234"));
        return userDao.findById("1");
    }

    @DeleteMapping("/user/all")
    public ResponseEntity<Integer> deleteAll() {
        return ResponseEntity
                .ok()
                .body(userDao.deleteAll());
    }
}
