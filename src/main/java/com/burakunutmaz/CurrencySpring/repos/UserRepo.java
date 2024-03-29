package com.burakunutmaz.CurrencySpring.repos;

import com.burakunutmaz.CurrencySpring.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
