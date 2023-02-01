package com.example.demo.converter;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserDTOConvertor {
    private UserDTO userDTO;

    public UserDTO convert (User from) {
        return new UserDTO(from.getId(), from.getUsername(), from.getEmail(),from.getPassword());
    }
}
