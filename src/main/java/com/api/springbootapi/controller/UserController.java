package com.api.springbootapi.controller;

import com.api.springbootapi.dao.UserDao;
import com.api.springbootapi.domain.User;
import com.api.springbootapi.domain.dto.UserRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/v1/user")
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

    @PostMapping("/add")
    public String  selectAndInsert() {
        User user1 = new User("1", "geun", "1234");
        userDao.insert(user1);
        return "id: " + user1.getId() + "/ name: " + user1.getName() + "/ password :" + user1.getPassword();
    }
    @DeleteMapping(value = "/deleteId")
    public String deleteId(@RequestParam String id) {
        log.info("deleteId path 입니다.");
        userDao.deleteById(id);
        return "id가 {" + id + "} 인 데이터가 삭제되었습니다.";
    }
    @DeleteMapping("/deleteAll")
    public String deleteAll() {
        log.info("deleteAll path 입니다.");
        userDao.deleteAll();
        return "모든 유저데이터가 삭제되었습니다.";
    }
}
