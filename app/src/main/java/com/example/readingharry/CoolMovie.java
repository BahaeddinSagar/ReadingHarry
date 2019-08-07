package com.example.readingharry;

public class CoolMovie {
    String ImageURL;
    String URL;
    String description;
    String name;
    long year;

    public CoolMovie(String ImageURL, String URL, String description, String name, long year) {
        this.ImageURL = ImageURL;
        this.URL = URL;
        this.description = description;
        this.name = name;
        this.year = year;
    }

    CoolMovie(){

    }

    public String getImageURL() {
        return ImageURL;
    }

    public void setImageURL(String imageURL) {
        ImageURL = imageURL;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }
}
