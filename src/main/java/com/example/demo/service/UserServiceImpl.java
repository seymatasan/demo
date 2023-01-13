package com.example.demo.service;

import com.example.demo.converter.UserDTOConvertor;
import com.example.demo.dto.UserDTO;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.request.CreateUserRequest;
import com.example.demo.request.UpdateUserRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl {

    private final UserRepository userRepository;
    private final UserDTOConvertor userDTOConvertor;


    public UserServiceImpl(UserRepository userRepository, UserDTOConvertor userDTOConvertor) {
        this.userRepository = userRepository;
        this.userDTOConvertor = userDTOConvertor;
    }

    public List<UserDTO> getUsers() {
        return userRepository.findAll().stream().map(userDTOConvertor::convert).collect(Collectors.toList());
    }

    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public User postUser(CreateUserRequest userRequest) {
        User user = new User();
        user.setUsername(userRequest.getUserName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(user.getPassword());
        return userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public User putUser(UpdateUserRequest updateUserRequest) {
        return new User(); // developed
    }

    public void deactiveUser(Long userId) {
    }
}
