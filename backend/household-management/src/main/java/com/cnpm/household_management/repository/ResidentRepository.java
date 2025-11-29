package com.cnpm.household_management.repository;

import org.springframework.data.jpa.repository.JpaRepository; // Import Entity Resident
import org.springframework.stereotype.Repository;

import com.cnpm.household_management.model.Resident;

import java.util.Optional;

@Repository
public interface ResidentRepository extends JpaRepository<Resident, Long> {
    boolean existsByResidentId(String residentId);

    Optional<Resident> findByResidentId(String residentId);

    void deleteByResidentID(String residentId);
}
