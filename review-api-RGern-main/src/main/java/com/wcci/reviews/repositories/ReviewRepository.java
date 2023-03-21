package com.wcci.reviews.repositories;

import com.wcci.reviews.entities.Category;
import com.wcci.reviews.entities.Hashtag;
import com.wcci.reviews.entities.Review;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ReviewRepository extends CrudRepository<Review, Long> {
    Optional<Hashtag> findByHashtag(String hashtag);
    Optional<Category> findByCategory(String category);

}

