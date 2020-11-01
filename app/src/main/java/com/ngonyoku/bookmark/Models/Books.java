package com.ngonyoku.bookmark.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Books {
    @SerializedName("kind")
    private String kind;

    @SerializedName("totalItems")
    private int totalItems;

    @SerializedName("items")
    private List<Items> items;

    public Books(String kind, int totalItems, List<Items> items) {
        this.kind = kind;
        this.totalItems = totalItems;
        this.items = items;
    }


    public String getKind() {
        return kind;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public List<Items> getItems() {
        return items;
    }
}
