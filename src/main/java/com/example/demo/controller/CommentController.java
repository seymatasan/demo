package com.example.demo.controller;

import com.example.demo.model.Comment;
import com.example.demo.service.CommentServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private CommentServiceImpl commentService;

    public CommentController(CommentServiceImpl commentService) {
        this.commentService = commentService;
    }

    public List<Comment> getComments() {
        return commentService.getComments();
    }
}
