package com.wcci.reviews.repositories;

import com.wcci.reviews.entities.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, String> {
    Optional<Category> findByCategory(String category); //should this be in the controller?
}
