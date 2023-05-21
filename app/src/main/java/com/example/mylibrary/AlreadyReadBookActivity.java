package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class AlreadyReadBookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_already_read_book);

        RecyclerView bookRecyclerView = findViewById(R.id.bookRecyclerView);
        BookRecViewAdapter adapter = new BookRecViewAdapter(this);
        bookRecyclerView.setAdapter(adapter);
        bookRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter.setBooks(Utils.getAlreadyReadBooks());

    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}