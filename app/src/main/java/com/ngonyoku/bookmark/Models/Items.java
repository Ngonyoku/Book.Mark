package com.ngonyoku.bookmark.Models;

import com.google.gson.annotations.SerializedName;

public class Items {
    private String id;

    @SerializedName("volumeInfo")
    private VolumeInfo volumeInfo;

    public Items(String id, VolumeInfo volumeInfo) {
        this.id = id;
        this.volumeInfo = volumeInfo;
    }

    public String getId() {
        return id;
    }

    public VolumeInfo getVolumeInfo() {
        return volumeInfo;
    }
}
