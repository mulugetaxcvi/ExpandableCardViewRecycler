package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.button.MaterialButtonToggleGroup;

public class BookActivity extends AppCompatActivity {

    private TextView txtBookLongDesc,txtBookTitle,txtBookAuthor,txtBookPages;
    private Button currentlyReading, wantToRead, alreadyRead, addToFav;
    private ImageView bookCover;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        initViews();

        Book book = new Book(1, "very very very very very very very very very very very long title", "author1", 1000, "short desc", getResources().getString(R.string.lorem)+getResources().getString(R.string.lorem), "https://m.media-amazon.com/images/I/51Dlnsl5p6L._AC_UF1000,1000_QL80_FMwebp_.jpg");
        setData(book);

    }

    private void setData(Book book){
        txtBookTitle.setText(book.getName());
        txtBookAuthor.setText(book.getAuthor());
        txtBookPages.setText(String.valueOf(book.getPages()));
        txtBookLongDesc.setText(book.getLongDesc());
        Glide.with(this)
                .asBitmap()
                .load(book.getImageUrl())
                .into(bookCover);
    }

    private void initViews(){
        txtBookLongDesc = findViewById(R.id.txtBookLongDesc);
        txtBookTitle = findViewById(R.id.txtBookTitle);
        txtBookAuthor = findViewById(R.id.txtBookAuthor);
        txtBookPages = findViewById(R.id.txtBookPages);

        currentlyReading = findViewById(R.id.currentlyReading);
        wantToRead = findViewById(R.id.wantToRead);
        alreadyRead = findViewById(R.id.alreadyRead);
        addToFav = findViewById(R.id.addToFav);

        bookCover = findViewById(R.id.bookCover);
    }
}