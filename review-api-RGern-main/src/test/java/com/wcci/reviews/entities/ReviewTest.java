package com.wcci.reviews.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReviewTest {

    @Test
    public void test() {
        final Category category = new Category("Cat1", "the first category");
        final Review review = new Review(1, "item", "me", "good", 5);
        assertEquals(1, review.getId());
        assertEquals("item", review.getProduct());
        assertEquals("me", review.getAuthor());
        assertEquals("good", review.getText());
        assertEquals(5, review.getRating());
    }


}