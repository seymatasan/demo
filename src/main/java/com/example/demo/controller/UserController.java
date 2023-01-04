package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.request.UserRequest;
import com.example.demo.service.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {


    private UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public List<User> getUsers() {
        return userService.getUsers();
    }


    @GetMapping("/{userId}")
    public Optional<User> getUser(@PathVariable String userId){
        return userService.getUser(userId);
    }

    @PostMapping("/")
    public User postUser(@RequestParam UserRequest userRequest) {
        return userService.postUser(userRequest);
    }




}
