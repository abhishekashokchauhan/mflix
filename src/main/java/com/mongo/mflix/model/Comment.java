package com.mongo.mflix.model;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@Document( collection = "comments")
public class Comment {
	
	@Id
    private ObjectId id; // MongoDB ObjectId
	
	@Field(name = "movie_id") 
    private ObjectId movieId; // ID of the movie related to this comment

    private String name; // Name of the user who made the comment

    private String email; // Email of the user who made the comment

    private String text; // Text content of the comment

    private Date date; // Date when the comment was posted

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public ObjectId getMovieId() {
		return movieId;
	}

	public void setMovieId(ObjectId movieId) {
		this.movieId = movieId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
    

}
