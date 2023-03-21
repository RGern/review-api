package com.wcci.reviews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReviewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewsApplication.class, args);
	}
// need a GET to /reviews/{reviewed} should return a JSON containing the review *return a review from a database*
//Get to /categories/{categoryID} should return all the reviews within a category
//Get to /categories should return a JSON list of all categories
}
