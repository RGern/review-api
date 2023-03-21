package com.wcci.reviews.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {
    @Test
    public void test() {
        final Category category = new Category("Cat1", "the first category");
        assertEquals("Cat1", category.getName());
        assertEquals("the first category", category.getDescription());
    }

}