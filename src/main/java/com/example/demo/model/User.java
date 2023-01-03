package com.example.demo.model;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Table(name="users")
public class User {

    @Id
    private String id;
    private String username;
    private String email;
    private String password;

}
