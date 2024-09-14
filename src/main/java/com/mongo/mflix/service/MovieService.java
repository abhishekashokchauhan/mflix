package com.mongo.mflix.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mongo.mflix.model.Comment;
import com.mongo.mflix.model.Movie;
import com.mongo.mflix.repository.CommentRepository;
import com.mongo.mflix.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private CommentRepository commentRepository;
	
	public Comment addComment(String title, Comment comment)
	{
		Optional<Movie> movieOptional = movieRepository.findByTitle(title);

		if (movieOptional.isPresent()) {
			Movie movie = movieOptional.get();
			// Find comments by movie ID
			ObjectId movieId = movie.getId();
			comment.setMovieId(movieId);
		}
		
		ObjectId commentId = new ObjectId();
		comment.setId(commentId);
		comment.setName("Abhishek Chauhan");
		comment.setEmail("xoxo@gmail.com");
		comment.setDate(new Date());
		return commentRepository.save(comment);
	}

	public List<Comment> getCommentsForMovie(String title) {
		// Find the movie by title
		Optional<Movie> movieOptional = movieRepository.findByTitle(title);

		if (movieOptional.isPresent()) {
			Movie movie = movieOptional.get();
			// Find comments by movie ID
			ObjectId movieId = movie.getId();
			return commentRepository.findByMovieId(movieId);
		}

		// Handle the case where the movie is not found
		throw new RuntimeException("Movie not found with title: " + title);
	}

	public Page<Movie> getMovies(Integer page, Integer size, String sortBy, Sort.Direction direction) {
		
		Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));
		return movieRepository.findAll(pageable);
	
	}
        
}
