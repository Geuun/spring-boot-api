package com.api.springbootapi.controller;

import com.api.springbootapi.dao.UserDao;
import com.api.springbootapi.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/v1/user/post")
public class UserController {
    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/")
    public String Hello() {
        log.info("default path 입니다.");
        return "Hello Welcome User API";
    }

    @PostMapping("/user")
    public User addAndGet(@ModelAttribute User user) {
        userDao.add(user);
        log.info("회원가입 user = {}", user);
        return user;
    }

    @DeleteMapping("/user/all")
    public String deleteAll() {
        log.info("deleteAll path 입니다.");
        userDao.deleteAll();
        return "전체 유저를 삭제했습니다.";
    }
}
