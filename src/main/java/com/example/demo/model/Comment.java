package com.example.demo.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="comments")
public class Comment {
    @Id
    private String id;
    @Column(columnDefinition="TEXT")
    private String text;
}
