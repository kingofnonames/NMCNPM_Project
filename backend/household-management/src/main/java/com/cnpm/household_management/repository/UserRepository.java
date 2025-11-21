package com.cnpm.household_management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cnpm.household_management.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Checks if a user exists with the given username.
     * @param userName The username to check.
     * @return true if a user with the username exists, false otherwise.
     */
    boolean existsByUserId(String userId);

    /**
     * Finds a user by their username and password.
     * Typically used for login functionality.
     * @param userName The user's username.
     * @param password The user's password.
     * @return An Optional containing the User if found, otherwise an empty Optional.
     */
    Optional<User> findByUserIdAndPassword(String userId, String password);

    /**
     * Finds a user by their username.
     * @param userName The username to search for.
     * @return An Optional containing the User if found, otherwise an empty Optional.
     */
    Optional<User> findByUserId(String userId);
}