package com.example.demo.dto;

import lombok.Value;

@Value
public class UserDTO {
    private Long id;
    private String username, surname, email;
    private Boolean isActive;

}
