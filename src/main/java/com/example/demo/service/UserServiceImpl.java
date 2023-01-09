package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.request.CreateUserRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl {

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(String userId) {
        return userRepository.findById(userId);
    }

    public User postUser(CreateUserRequest userRequest) {
        User user = new User();
        user.setUsername(userRequest.getUserName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(user.getPassword());
        return userRepository.save(user);
    }
}
