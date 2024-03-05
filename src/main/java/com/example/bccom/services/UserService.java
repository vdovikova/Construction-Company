package com.example.bccom.services;

import com.example.bccom.models.User;
import com.example.bccom.models.enums.Role;
import com.example.bccom.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;

    public boolean createUser (User user) {
        if (userRepository.findByComLogin(user.getComLogin()).isPresent()) {
            return false;
        }
        user.setActive(1);
        user.setComPass(user.getPassword());
        user.getRoles().add(Role.ROLE_USER);
        log.info("Saving new user with login {}", user.getComLogin());
        return true;
    }
}

