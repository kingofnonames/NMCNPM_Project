package com.cnpm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnpm.household_management.model.User;
import com.cnpm.household_management.model.UserStatus;
import com.cnpm.household_management.repository.UserRepository;
@Service
public class UserService {

    @Autowired private UserRepository userRepository;

    /*
     * Registers a new user. The user is initially inactive 
     * @param user The user object to register.
     * @return The saved user.
     * @throws Exception if the username already exists.
     */
    public User register(User user) throws Exception {
        if (userRepository.existsByUserId(user.getUserId())) {
            throw new Exception("Username already exists!");
        }
        // Set initial status for new registrations
        user.setStatus(UserStatus.ACTIVE);
        return userRepository.save(user);
    }

    /**
     * Authenticates a user based on username and password.
     * @param userId The userId.
     * @param password The password.
     * @return An Optional containing the User if login is successful, otherwise an empty Optional.
     */
    public Optional<User> login(String userId, String password) {
        return userRepository.findByUserIdAndPassword(userId, password);
    }
    /**
     * Retrieves all user accounts from the database.
     * @return A list of all users.
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
