package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column(columnDefinition="TEXT")
    private String text;
}
