package com.wcci.reviews.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Entity
public class Review {

    @Id @GeneratedValue
    private long id;
    private String author;
    private String text;
    private int rating; //range 1-5 stars
    private String product;


    @ManyToOne
    private Category category;

    @ManyToMany
    private Collection<Hashtag> hashtag = new HashSet<>();

    public Review(long id, String product, String author, String text, int rating) {
        this.id = id;
        this.author = author;
        this.text = text;
        this.rating = rating;
        this.product = product;
    }

    public Review() {
    }

    public String getProduct() {
        return product;
    }

    public Collection<Hashtag> getHashtag() {
        return hashtag;
    }
    public long getId() {
        return id;
    }
    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    public int getRating() {
        return rating;
    }

    public Category getCategory() {
        return category;
    }
    public void setCategory(Category newCategory) {
        category = newCategory;
    }

    public void addHashtag(final Hashtag hashtag) {
        this.hashtag.add(hashtag);
    }
    public void removeHashtag(final Hashtag hashtag) {
        this.hashtag.remove(hashtag);
    }

}
