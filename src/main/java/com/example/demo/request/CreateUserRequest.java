package com.example.demo.request;

import lombok.Data;

@Data
public class CreateUserRequest {
    private String userName,email, Password;
}
