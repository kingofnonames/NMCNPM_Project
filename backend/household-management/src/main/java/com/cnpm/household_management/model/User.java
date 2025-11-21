// package com.cnpm.household_management.model;

// import jakarta.persistence.Entity;
// import jakarta.persistence.Table;
// import jakarta.persistence.EnumType;
// import jakarta.persistence.Id;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Column;
// import jakarta.persistence.Enumerated;
// import lombok.*;
// // import javax.persistence.Entity;
// // import javax.persistence.Table;
// // import javax.persistence.EnumType;
// // import javax.persistence.Id;
// // import javax.persistence.GeneratedValue;
// // import javax.persistence.GenerationType;
// // import javax.persistence.Column;
// // import javax.persistence.Enumerated;
// @Data
// @Entity
// @Table(name = "users")
// public class User {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(name = "user_name", unique = true, nullable = false)
//     private String userName;

//     @Column(nullable = false)
//     private String password;

//     @Enumerated(EnumType.STRING)
//     private String role;

//     @Enumerated(EnumType.STRING)
//     private UserStatus status;

//     @Column(nullable = false)
//     private boolean approved = false;

//     // Getter & Setter
//     // public Long getId() { return id; }
//     // public void setId(Long id) { this.id = id; }

//     // public String getUserName() { return userName; }
//     // public void setUserName(String userName) { this.userName = userName; }

//     // public String getPassword() { return password; }
//     // public void setPassword(String password) { this.password = password; }

//     // public String getRole() { return role; }
//     // public String setRole(String role) { this.role = role; }

//     // public UserStatus getStatus() { return status; }
//     // public void setStatus(UserStatus status) { this.status = status; }

//     // public boolean isApproved() { return approved; }
//     // public void setApproved(boolean approved) { this.approved = approved; }
// }
