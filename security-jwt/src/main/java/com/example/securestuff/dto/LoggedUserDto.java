package com.example.securestuff.dto;

import lombok.Data;

@Data
public class LoggedUserDto {
    Long id;
    String username;
    String roles;
}
