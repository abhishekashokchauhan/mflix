package com.mongo.mflix.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongo.mflix.model.Comment;

public interface CommentRepository extends MongoRepository<Comment, ObjectId> {
    List<Comment> findByMovieId(ObjectId movie_id);
}

