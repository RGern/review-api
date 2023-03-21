package com.wcci.reviews.entities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collection;
@Entity
public class Category {
    private String name;
    //should this be name or a long id? would it really make a difference in later use as long as its consistent?
    private String description;

    @OneToMany
    private Collection<Review> reviews;

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Category(){
    }

    public Collection<Review> getReviews() {
        return reviews;
    }

    public String getName() {
        return name;
    }

    public String getDescription() { return description; }


}
