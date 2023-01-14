package com.example.demo.service;

import com.example.demo.converter.UserDTOConvertor;
import com.example.demo.dto.UserDTO;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.request.CreateUserRequest;
import com.example.demo.request.UpdateUserRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends RuntimeException {

    private final UserRepository userRepository;
    private final UserDTOConvertor userDTOConvertor;


    public UserServiceImpl(UserRepository userRepository, UserDTOConvertor userDTOConvertor) {
        this.userRepository = userRepository;
        this.userDTOConvertor = userDTOConvertor;
    }

    public List<UserDTO> getUsers() {
        return userRepository.findAll().stream().map(userDTOConvertor::convert).collect(Collectors.toList());
    }

    public UserDTO getUserById(Long id) {
        User user = findUserById(id);
        return userDTOConvertor.convert(user);
    }

    public UserDTO postUser(CreateUserRequest userRequest) {
        User createduser = new User();
        createduser.setUsername(userRequest.getUserName());
        createduser.setEmail(userRequest.getEmail());
        createduser.setPassword(userRequest.getPassword());
        return userDTOConvertor.convert(userRepository.save(createduser));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public UserDTO putUser(Long id, UpdateUserRequest updateUserRequest) {
        User user = findUserById(id);
        User updatedUser = new User();
        updatedUser.setUsername(user.getUsername());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setPassword(user.getPassword());
        return userDTOConvertor.convert(userRepository.save(updatedUser)); // developed
    }

    public void deactiveUser(Long id) {
    }

    private User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User couldn't found by following id: " + id));
    }


}
