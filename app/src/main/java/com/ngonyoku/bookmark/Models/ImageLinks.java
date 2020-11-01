package com.ngonyoku.bookmark.Models;

public class ImageLinks {
    private String smallThumbnail;
    private String thumbnail;

    public ImageLinks(String smallThumbnail, String thumbnail) {
        this.smallThumbnail = smallThumbnail;
        this.thumbnail = thumbnail;
    }

    public String getSmallThumbnail() {
        return smallThumbnail;
    }

    public String getThumbnail() {
        return thumbnail;
    }
}
