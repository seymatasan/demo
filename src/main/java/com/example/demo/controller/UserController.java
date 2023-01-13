package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.User;
import com.example.demo.request.CreateUserRequest;
import com.example.demo.request.UpdateUserRequest;
import com.example.demo.service.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {


    private final  UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }


    @GetMapping("/{userId}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable("userId") Long userId){
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @PostMapping("/")
    public ResponseEntity<User> postUser(@RequestBody CreateUserRequest createUserRequest) {
        return ResponseEntity.ok(userService.postUser(createUserRequest));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> putUser(@RequestBody UpdateUserRequest updateUserRequest) {
        return ResponseEntity.ok(userService.putUser(updateUserRequest));
    }

    @PatchMapping("/{userId}")
    public ResponseEntity<Void> deactiveUser(@PathVariable("userId") Long userId) {
        userService.deactiveUser(userId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@RequestParam Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }
    
}
