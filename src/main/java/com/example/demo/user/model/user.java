package com.example.demo.user.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class user {

    @GeneratedValue
    @Id
    private String id;

    private String username;
    private String password;
}
