package com.ngonyoku.bookmark.Models;

import com.google.gson.annotations.SerializedName;

public class VolumeInfo {
    private String title;
    private String[] authors;
    private String description;
    private String publisher;
    private String publisherDate;
    @SerializedName("imageLinks")
    private ImageLinks imageLinks;

    public VolumeInfo(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String[] getAuthors() {
        return authors;
    }

    public String getDescription() {
        return description;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getPublisherDate() {
        return publisherDate;
    }

    public ImageLinks getImageLinks() {
        return imageLinks;
    }
}
