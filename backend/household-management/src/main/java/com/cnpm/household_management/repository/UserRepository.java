package com.cnpm.household_management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cnpm.household_management.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Checks if a user exists with the given residentId.
     * @param residentId The residentId to check.
     * @return true if a user with the residentId exists, false otherwise.
     */
    boolean existsByResidentId(String residentId);

    /**
     * Finds a user by their residentId and password.
     * Typically used for login functionality.
     * @param residentId The user's residentId.
     * @param password The user's password.
     * @return An Optional containing the User if found, otherwise an empty Optional.
     */
    Optional<User> findByResidentIdAndPassword(String residentId, String password);
    
    /**
     * Finds a user by their residentId.
     * @param residentId The residentId to search for.
     * @return An Optional containing the User if found, otherwise an empty Optional.
     */
    Optional<User> findByResidentId(String residentId);
}