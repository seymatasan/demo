package com.example.demo.model;


import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column(columnDefinition="TEXT")
    private String text;



}
