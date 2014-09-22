package com.models;


import java.util.Set;

/**
 * Created by Sunny on 4/15/14.
 */
public class Menu {
    private int id;
    private String name;
    private String imageURL;
    private String description;
    private Float price;
    private Float average;
    private Genre genre;
    private Set<Likes> likes;
    private Set<LineItem> lineItems;

    public Menu(){};

    public Set<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(Set<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setAverage(Float average) {
        this.average = average;
    }

    public Float getAverage() {
        return average;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setLikes(Set<Likes> likes) {
        this.likes = likes;
    }

    public Set<Likes> getLikes() {
        return likes;
    }

}
