package com.ngonyoku.bookmark.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ngonyoku.bookmark.Models.ImageLinks;
import com.ngonyoku.bookmark.Models.Items;
import com.ngonyoku.bookmark.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.BookListViewHolder> {
    private Context mContext;
    private List<Items> bookItems;
    private static final String TAG = "BookListAdapter";

    public BookListAdapter(Context context, List<Items> bookItems) {
        this.mContext = context;
        this.bookItems = bookItems;
    }

    @NonNull
    @Override
    public BookListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BookListViewHolder(
                LayoutInflater.from(mContext)
                        .inflate(R.layout.item_book, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull BookListViewHolder holder, int position) {
        Items currentBook = bookItems.get(position);
        holder.publishers.setText(currentBook.getVolumeInfo().getPublisher());
        for (String author : currentBook.getVolumeInfo().getAuthors()) {
            holder.authors.append(author + "\t");
        }
        holder.title.setText(currentBook.getVolumeInfo().getTitle());
        String description = (currentBook.getVolumeInfo().getDescription() != null)
                ? currentBook.getVolumeInfo().getDescription()
                : "\"---No Description---\"";
        holder.description.setText(description);
        ImageLinks imageLinks = currentBook.getVolumeInfo().getImageLinks();
        if (imageLinks != null) {
            String thumbnail = imageLinks.getSmallThumbnail().trim();
            assert thumbnail != null;
            Picasso.get().setIndicatorsEnabled(true);
            Picasso.get().setLoggingEnabled(true);
            Picasso.get().load(thumbnail).fit().into(holder.bookImage);
        }
    }

    @Override
    public int getItemCount() {
        return bookItems.size();
    }

    static class BookListViewHolder extends RecyclerView.ViewHolder {
        private TextView authors, publishers, title, description;
        private ImageView bookImage;

        public BookListViewHolder(@NonNull View itemView) {
            super(itemView);

            bookImage = itemView.findViewById(R.id.book_img);
            description = itemView.findViewById(R.id.book_description);
            title = itemView.findViewById(R.id.book_title);
            authors = itemView.findViewById(R.id.book_authors);
            publishers = itemView.findViewById(R.id.book_publisher);
        }
    }
}
