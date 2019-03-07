package com.example.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
@RestController
@RequestMapping(value = "/userservice")
public class UserServiceImpl implements UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @RequestMapping(value = "createUser")
    public void createUser(String name, int age) {
        jdbcTemplate.update("INSERT INTO `user` (`name`, `age`) VALUES (?, ?)",name,age);
    }

    @Override
    @RequestMapping("deleteByUsername")
    public void deleteByUsername(String name) {
        jdbcTemplate.update("delete from  user where name = ?",name);
    }

    @Override
    @RequestMapping(value = "getAllUsersCount")
    public Integer getAllUsersCount() {
        return jdbcTemplate.queryForObject("SELECT count(1) from user;",Integer.class);
    }

    @Override
    @RequestMapping(value = "deleteAllUser")
    public void deleteAllUser() {
        jdbcTemplate.update("delete FROM user;");
    }
}
