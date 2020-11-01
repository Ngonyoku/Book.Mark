package com.ngonyoku.bookmark;

import com.ngonyoku.bookmark.Models.Books;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GoogleBooksAPI {
    @GET("volumes")
    Call<Books> getBooks(@Query("q") String bookName);
}
