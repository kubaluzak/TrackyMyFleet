package com.example.trackmyfleet.service;

import com.example.trackmyfleet.entity.User;
import com.example.trackmyfleet.repostiory.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }


    public void deleteUser(Long id) {
        User user = getUserById(id);
        userRepository.delete(user);
    }


}
