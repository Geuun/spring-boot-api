package com.api.springbootapi.domain.dto;

public class UserRequestDto {
    private String id;
    private String name;
    private String password;

    public UserRequestDto(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
}
