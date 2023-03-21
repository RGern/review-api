package com.wcci.reviews.restControllers;

import com.wcci.reviews.entities.Hashtag;
import com.wcci.reviews.repositories.HashtagRepository;
import com.wcci.reviews.repositories.ReviewRepository;
import com.wcci.reviews.entities.Review;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ReviewController {
    private ReviewRepository reviewRepository;
    private HashtagRepository hashtagRepository;

    public ReviewController(ReviewRepository reviewRepository, HashtagRepository hashtagRepository) {
        this.reviewRepository = reviewRepository;
        this.hashtagRepository = hashtagRepository;
    }

    @GetMapping("/reviews")
    public Iterable<Review> getAllReviews() {
        return reviewRepository.findAll();
        //do we really wanna list all of them, for the scope here, probably
    }

    @GetMapping("/reviews/{id}")
    public Review getReviewById(@PathVariable long id) {
        return reviewRepository.findById(id).get();
    }

    @DeleteMapping("/reviews/{id}/deleteReview")
    public void deleteReview(long id) {
        Optional<Review> existingReview = reviewRepository.findById(id);
        if (existingReview.isPresent()) {
            reviewRepository.delete(getReviewById(id));
        }
    }

    @PutMapping("/reviews/{id}/addHashtag")
    public Review addHashtagToReview(@PathVariable long id, @RequestBody Hashtag hashtag) {
        Optional<Review> existingReview = reviewRepository.findById(id);
        Optional<Hashtag> newHashtag = hashtagRepository.findByHashtag(hashtag.getName());
        if (existingReview.isPresent()) {
            if (newHashtag.isPresent()) {
                Hashtag existingHashtag = newHashtag.get();
                if (!existingReview.get().getHashtag().contains(existingHashtag)) {
                    existingReview.get().addHashtag(hashtag);
                    hashtagRepository.save(existingHashtag);
                }
            }
            else {
                Hashtag hashtagToAdd = new Hashtag(hashtag.getName());
                hashtagRepository.save(hashtagToAdd);
            }
        }
        return reviewRepository.findById(id).get();
    }
}

