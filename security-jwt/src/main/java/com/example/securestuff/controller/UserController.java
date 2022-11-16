package com.example.securestuff.controller;

import com.example.securestuff.dto.LoginRequest;
import com.example.securestuff.dto.RegisterUserDto;
import com.example.securestuff.model.User;
import com.example.securestuff.service.TokenService;
import com.example.securestuff.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;
    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest userLogin) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLogin.username(), userLogin.password()));
        String token = tokenService.generateToken(authentication);
        return ResponseEntity.ok().body(token);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterUserDto userDto) {
        User user = new User(null, userDto.getUsername(), userDto.getPassword(), userDto.getRoles());
        userService.registerUser(user);
        return ResponseEntity.ok().body("Success!");
    }
}
