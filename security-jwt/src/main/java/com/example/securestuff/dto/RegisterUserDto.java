package com.example.securestuff.dto;

import lombok.Data;

@Data
public class RegisterUserDto {
    String username;
    String password;
    String roles;
}
