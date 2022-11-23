package com.careerdevs.capstone.repositories;

import com.careerdevs.capstone.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByLoginToken(String loginToken);
}
