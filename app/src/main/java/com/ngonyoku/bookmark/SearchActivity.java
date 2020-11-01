package com.ngonyoku.bookmark;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputLayout;

public class SearchActivity extends AppCompatActivity {
    public static final String SEARCH_QUERY = "com.ngonyoku.bookmark.SEARCH_QUERY";
    private TextInputLayout mSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        mSearch = findViewById(R.id.search_tel);
    }

    public void search(View view) {
        String query = mSearch.getEditText().getText().toString();
        if (!query.trim().isEmpty()) {
            mSearch.setError(null);
            startActivity(
                    new Intent(this, BooksListActivity.class)
                            .putExtra(SEARCH_QUERY, query)
            );
        } else {
            mSearch.setError(getString(R.string.txt_empty_error));
            mSearch.requestFocus();
        }
    }
}