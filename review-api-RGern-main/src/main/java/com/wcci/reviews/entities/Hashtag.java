package com.wcci.reviews.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Arrays;
import java.util.Collection;
@Entity
public class Hashtag {

    @Id
    private String name;



    @ManyToMany
    private Collection<Review> reviews;

    public Hashtag(String name) {
        this.name = name;

    }

    public Hashtag(){
    }

    public String getName() {
        return name;
    }

    public Collection<Review> getReviews() {
        return reviews;
    }
}
