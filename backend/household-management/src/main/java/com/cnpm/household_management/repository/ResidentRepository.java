package com.cnpm.household_management.repository;

import org.springframework.data.jpa.repository.JpaRepository; // Import Entity Resident
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.cnpm.household_management.model.Resident;

import java.util.Optional;

@Repository
public interface ResidentRepository extends JpaRepository<Resident, String>, JpaSpecificationExecutor<Resident> {

}
