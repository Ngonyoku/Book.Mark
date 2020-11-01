package com.ngonyoku.bookmark;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.ngonyoku.bookmark.Adapters.BookListAdapter;
import com.ngonyoku.bookmark.Models.Books;
import com.ngonyoku.bookmark.Models.Items;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BooksListActivity extends AppCompatActivity {
    public static final String BASE_URL = "https://www.googleapis.com/books/v1/";
    private static final String TAG = "BooksListActivity";
    private GoogleBooksAPI mBooksAPI;
    private RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_list);

        mRecyclerView = findViewById(R.id.booksRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mBooksAPI = retrofit.create(GoogleBooksAPI.class);
        if (getIntent() != null) {
            String query = getIntent().getStringExtra(SearchActivity.SEARCH_QUERY);
            runSearchQuery(query);
        }
    }

    private void runSearchQuery(String query) {
        Call<Books> call = mBooksAPI.getBooks(query);
        call.enqueue(new Callback<Books>() {
            @Override
            public void onResponse(Call<Books> call, Response<Books> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(BooksListActivity.this, "Code" + response.code(), Toast.LENGTH_LONG).show();
                    return;
                }
                Books books = response.body();
                List<Items> items = books.getItems();
                BookListAdapter adapter = new BookListAdapter(BooksListActivity.this, items);
                mRecyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Books> call, Throwable t) {
                Toast.makeText(BooksListActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "Failed Request: -> " + t.getMessage());
            }
        });
    }
}