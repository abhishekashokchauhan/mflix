package com.mongo.mflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.mflix.model.Comment;
import com.mongo.mflix.service.MovieService;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/comments")
    public List<Comment> getComments(@RequestParam String title) {
        return movieService.getCommentsForMovie(title);
    }
}
