package com.wcci.reviews.repositories;


import com.wcci.reviews.entities.Hashtag;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface HashtagRepository extends CrudRepository<Hashtag, Long> {
    Optional<Hashtag> findByHashtag(String hashtag);
}
