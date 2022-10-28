package com.api.springbootapi.dao;

import com.api.springbootapi.domain.User;
import com.api.springbootapi.domain.dto.UserRequestDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

@Component
public class UserDao {

    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    public UserDao(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    public void add(User user){
        this.jdbcTemplate.update("insert into `likelion-db`.users(id, name, password) values(?, ?, ?)", user.getId(), user.getName(), user.getPassword());

    }

    public void deleteAll(){
        this.jdbcTemplate.update("delete from `likelion-db`.users");
    }

    public void deleteById(String id){
        this.jdbcTemplate.update("delete from `likelion-db`.users where id = ?", id);
}