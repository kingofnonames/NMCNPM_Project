package com.cnpm.household_management.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "UserData")

public class User {
    @Id
    @Column(name = "residentId", unique = true, nullable = false)
    private String residentId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean isActive;
}
