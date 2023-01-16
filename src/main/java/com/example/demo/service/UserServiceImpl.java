package com.example.demo.service;

import com.example.demo.converter.UserDTOConvertor;
import com.example.demo.dto.UserDTO;
import com.example.demo.exception.UserIsNotActiveException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.request.CreateUserRequest;
import com.example.demo.request.UpdateUserRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends RuntimeException {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

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
        createduser.setIsActive(false);
        return userDTOConvertor.convert(userRepository.save(createduser));
    }


    public UserDTO putUser(Long id, UpdateUserRequest updateUserRequest) {
        User updatedUser = findUserById(id);
        if(!updatedUser.getIsActive()) {
           throw new UserIsNotActiveException();
        }
        updatedUser.setUsername(updateUserRequest.getUserName());
        updatedUser.setEmail(updateUserRequest.getEmail());
        updatedUser.setPassword(updateUserRequest.getPassword());
        return userDTOConvertor.convert(userRepository.save(updatedUser));
    }

    public void deactiveUser(Long id) {
        User user= findUserById(id);
        user.setIsActive(false);
        userRepository.save(user);
    }

    public void activeUser(Long id) {
        User user = findUserById(id);
        user.setIsActive(true);
    }

    public void deleteUser(Long id) {
        User user = findUserById(id);
        userRepository.deleteById(id);
    }

    private User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User couldn't found by following id: " + id));
    }


}
