package com.example.securestuff.controller;

import com.example.securestuff.dto.RegisterUserDto;
import com.example.securestuff.model.User;
import com.example.securestuff.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<User> login() {
        return null;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterUserDto userDto) {
        User user = new User(null, userDto.getUsername(), userDto.getPassword());
        userService.registerUser(user);
        return ResponseEntity.ok().body("Success!");
    }
}
