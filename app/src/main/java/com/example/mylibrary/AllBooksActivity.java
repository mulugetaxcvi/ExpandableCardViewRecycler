package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class AllBooksActivity extends AppCompatActivity {

    private RecyclerView booksRecView;
    private BookRecViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);

        adapter = new BookRecViewAdapter(this);
        booksRecView = findViewById(R.id.booksRecView);

        booksRecView.setAdapter(adapter);
        booksRecView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Book> testBooks = new ArrayList<>();
        testBooks.add(new Book(1, "book1", "author1", 1000, "short desc", getResources().getString(R.string.lorem), "https://m.media-amazon.com/images/I/51Dlnsl5p6L._AC_UF1000,1000_QL80_FMwebp_.jpg"));
        testBooks.add(new Book(1, "book2", "author2", 1000, "short desc", getResources().getString(R.string.lorem), "https://m.media-amazon.com/images/I/51Dlnsl5p6L._AC_UF1000,1000_QL80_FMwebp_.jpg"));
        testBooks.add(new Book(1, "book3", "author3", 1000, "short desc", getResources().getString(R.string.lorem), "https://m.media-amazon.com/images/I/51Dlnsl5p6L._AC_UF1000,1000_QL80_FMwebp_.jpg"));

        adapter.setBooks(testBooks);
    }
}