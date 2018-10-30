package com.example.ikhsannursyahbanu.myfilmapps.Activities.Model;

public class Movie {
    private String name;
    private String sinopsis;
    private String category;
    private String rating;
    private String image_url;

    public Movie() {
    }

    public Movie(String name, String sinopsis, String category, String rating, String image_url) {
        this.name = name;
        this.sinopsis = sinopsis;
        this.category = category;
        this.rating = rating;
        this.image_url = image_url;
    }

    //Getter
    public String getName() {
        return name;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public String getCategory() {
        return category;
    }

    public String getRating() {
        return rating;
    }

    public String getImage_url() {
        return image_url;
    }

    //Setter
    public void setName(String name) {
        this.name = name;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}