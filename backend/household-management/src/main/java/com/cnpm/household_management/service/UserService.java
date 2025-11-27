package com.cnpm.household_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnpm.household_management.model.User;
import com.cnpm.household_management.repository.ResidentRepository;
import com.cnpm.household_management.repository.UserRepository;
@Service
public class UserService {

    @Autowired private UserRepository userRepository;
    @Autowired private ResidentRepository residentRepository;

    /*
     * Registers a new user. The user is initially inactive 
     * @param user The user object to register.
     * @return The saved user.
     * @throws Exception if the username already exists.
     */
    public User register(User user) throws Exception {
        // Yêu cầu: residentId phải tồn tại trong bảng Resident
        if (!residentRepository.existsByResidentId(user.getResidentId())) {
            throw new Exception("Resident ID does not exist in the resident registry!");
        }

        if (userRepository.existsByResidentId(user.getResidentId())) {
            throw new Exception("Username already exists!");
        }
        // Set initial status for new registrations
        user.setActive(true );
        return userRepository.save(user);
    }

    /**
     * Authenticates a user based on username and password.
     * @param residentId The residentId.
     * @param password The password.
     * @return An Optional containing the User if login is successful, otherwise an empty Optional.
     */
    public Optional<User> login(String residentId, String password) {
        return userRepository.findByResidentIdAndPassword(residentId, password);
    }
    /**
     * Retrieves all user accounts from the database.
     * @return A list of all users.
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
