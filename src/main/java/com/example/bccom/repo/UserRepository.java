package com.example.bccom.repo;

import com.example.bccom.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByComLogin(String comLogin);
}