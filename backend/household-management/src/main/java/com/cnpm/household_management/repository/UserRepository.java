package com.cnpm.household_management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cnpm.household_management.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    boolean existsByResidentId(String residentId);

    Optional<User> findByResidentIdAndPassword(String residentId, String password);
}
