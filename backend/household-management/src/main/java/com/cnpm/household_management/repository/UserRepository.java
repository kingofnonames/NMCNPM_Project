package com.cnpm.household_management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cnpm.household_management.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Checks if a user exists with the given userId.
     * @param userId The userId to check.
     * @return true if a user with the userId exists, false otherwise.
     */
    boolean existsByUserId(String userId);

    /**
     * Finds a user by their userId and password.
     * Typically used for login functionality.
     * @param userId The user's userId.
     * @param password The user's password.
     * @return An Optional containing the User if found, otherwise an empty Optional.
     */
    Optional<User> findByUserIdAndPassword(String userId, String password);

    /**
     * Finds a user by their username.
     * @param userId The userId to search for.
     * @return An Optional containing the User if found, otherwise an empty Optional.
     */
    Optional<User> findByUserId(String userId);
}