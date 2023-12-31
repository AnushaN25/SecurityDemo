package com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(String userName);
}
