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


    public User register(User user) throws Exception {
        if (!residentRepository.existsByResidentId(user.getResidentId())) {
            throw new Exception("Resident ID does not exist in the resident registry!");
        }

        if (userRepository.existsByResidentId(user.getResidentId())) {
            throw new Exception("Username already exists!");
        }

        return userRepository.save(user);
    }

    public Optional<User> login(String residentId, String password) {
        return userRepository.findByResidentIdAndPassword(residentId, password);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
