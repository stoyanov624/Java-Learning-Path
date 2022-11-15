package com.example.securestuff.service;
import com.example.securestuff.model.User;
import com.example.securestuff.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public void registerUser(User user) {
        System.out.println("registering");
        userRepository.save(new User(null, user.getUsername(), encoder.encode(user.getPassword())));
    }
}
