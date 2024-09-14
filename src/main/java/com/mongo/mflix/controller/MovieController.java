package com.mongo.mflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.mflix.model.Comment;
import com.mongo.mflix.model.Movie;
import com.mongo.mflix.service.MovieService;

@RestController
public class MovieController {

	@Autowired
	private MovieService movieService;

	@GetMapping("/comments")
	public List<Comment> getComments(@RequestParam String title) {
		return movieService.getCommentsForMovie(title);
	}

	@GetMapping("/movies")
	public Page<Movie> getAllMovies(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size,
			@RequestParam(defaultValue = "year") String sortBy,
			@RequestParam(defaultValue = "ASC") org.springframework.data.domain.Sort.Direction direction) {
		return movieService.getMovies(page, size, sortBy , direction);
	}
	
	@PostMapping("/comments")
	public Comment addComment(@RequestParam String title, @RequestBody Comment comment) {
		return movieService.addComment(title, comment);
	}
	
	
}
