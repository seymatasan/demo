package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.request.CreateUserRequest;
import com.example.demo.request.UpdateUserRequest;
import com.example.demo.service.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping("/")
    public ResponseEntity<UserDTO> postUser(@RequestBody CreateUserRequest createUserRequest) {
        return ResponseEntity.ok(userService.postUser(createUserRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> putUser(@PathVariable(value = "id") Long id, @RequestBody UpdateUserRequest updateUserRequest) {
       return ResponseEntity.ok(userService.putUser(id, updateUserRequest));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> deactiveUser(@PathVariable(value = "id") Long id) { // @PathVariable("id") -> same
        userService.deactiveUser(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable(value = "id") Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
    
}
