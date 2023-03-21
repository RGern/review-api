package com.wcci.reviews.restControllers;

import com.wcci.reviews.entities.Category;
import com.wcci.reviews.entities.Review;
import com.wcci.reviews.repositories.CategoryRepository;
import com.wcci.reviews.repositories.ReviewRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
public class CategoryController {
    private CategoryRepository categoryRepository;
    private ReviewRepository reviewRepository;


    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;

    }

    @GetMapping("/categories")
    public Iterable<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @GetMapping("/category/{name}")
    public Category getCategory(@PathVariable String name) {
        return categoryRepository.findByCategory(name).get();
    }
    //write an option to find a category by searching the category, include an exception if the category doesn't exist
    @PostMapping("/categories")
    public Iterable<Category> addNewCategory(@RequestBody Category category) {
        Optional<Category> existingCategory = categoryRepository.findByCategory(category.getName());
        if (existingCategory.isEmpty()) {
            categoryRepository.save(category);
        }
        return categoryRepository.findAll();
    }


    @PutMapping("/categories/{name}/addReview") //I think this is already done at review creation...or it needs moved to review controller
    public Category addReviewToCategory(@PathVariable String name, @RequestBody Review review) {
        Optional<Category> existingCategory = categoryRepository.findByCategory(name);
        if (existingCategory.isPresent()) {
            review.setCategory(existingCategory.get());
            reviewRepository.save(review);
        }
        return categoryRepository.findByCategory(name).get();
    }
    // add delete mapping to remove a category and an exception there if it doesn't exist
    @DeleteMapping("/categories/{category_id}")
    public void deleteCategory(@PathVariable final String category_id) {
        categoryRepository.findByCategory(category_id)
                .ifPresentOrElse(
                        category -> {
                            categoryRepository.delete(category);//need to look up the arrow syntax, good way to say, do this or that?
                        },
                        () -> { //what is this line doing
                        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "category not found");
                        }); //can I use this same syntax on the add review instead of the if statement?
    }
}
