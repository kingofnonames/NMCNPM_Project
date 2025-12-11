package com.cnpm.household_management.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Resident")
public class Resident {
    @Id
    @Column(name = "residentId", unique = true, nullable = false)
    private String residentId;

    @Column(name = "householdBookID", nullable = false)
    private String householdBookID;

    @Column(name = "idIssueDate", nullable = false)
    private LocalDate idIssueDate;

    @Column(name = "idIssuePlace", nullable = false)
    private String idIssuePlace;

    @Column(name = "fullName", nullable = false)
    private String fullName;

    @Column(name = "alias")
    private String alias;

    @Column(name = "dateOfBirth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "placeOfBirth", nullable = false)
    private String placeOfBirth;

    @Column (name = "hometown", nullable = false)
    private String hometown;

    @Column(name = "ethnicity", nullable = false)
    private String ethnicity;

    @Column(name = "occupation")
    private String occupation;

    @Column(name = "workplace")
    private String workplace;

    @Column(name = "permanentRegistrationDate", nullable = false)
    private LocalDate permanentRegistrationDate;

    @Column(name = "permanentResidenceAddress", nullable = false)
    private String permanentResidenceAddress;

    @Column(name = "isDead", nullable = false)
    private boolean isDead;
}
