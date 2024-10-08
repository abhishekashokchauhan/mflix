package com.mongo.mflix.repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongo.mflix.model.Movie;

public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
    Optional<Movie> findByTitle(String title);
    
    Page<Movie> findAll(Pageable page);
}

