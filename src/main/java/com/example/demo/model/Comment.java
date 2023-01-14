package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition="TEXT")
    private String text;
}
