package com.example.demo.model;


import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name="posts")
public class Post {

    @Id
    private String id;
    @Column(columnDefinition="TEXT")
    private String text;



}
