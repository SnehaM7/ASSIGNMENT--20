package com.app.studentapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.studentapi.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);
}
