package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.button.MaterialButtonToggleGroup;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {

    private TextView txtBookLongDesc,txtBookTitle,txtBookAuthor,txtBookPages;
    private Button currentlyReading, wantToRead, alreadyRead, addToFav;
    private ImageView bookCover;
    public static final String BOOK_ID_KEY = "bookId";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        initViews();

        Intent intent = getIntent();
        if (null != intent){
            int bookId = intent.getIntExtra(BOOK_ID_KEY, -1);
            if (bookId != -1){
                Book incomingBook = Utils.getInstance().getBookById(bookId);
                if (null != incomingBook){
                    setData(incomingBook);
                    handleAlreadyRead(incomingBook);
                }
            }
        }
    }
    private void handleAlreadyRead(Book book){
        ArrayList<Book> alreadyReadBooks = Utils.getInstance().getAlreadyReadBooks();

        boolean existsInAlreadyRead = false;

        for (Book b : alreadyReadBooks){
            if (b.getId() == book.getId()){
                existsInAlreadyRead = true;
            }
        }
        if (existsInAlreadyRead){
            alreadyRead.setEnabled(false);
        } else {
            alreadyRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utils.getInstance().addToAlreadyRead(book)){
                        Toast.makeText(BookActivity.this, "Added to already Read", Toast.LENGTH_SHORT).show();

                        //disables button after adding book
                        alreadyRead.setEnabled(false);

                        //opens alreadyReadBooks activity after adding book to already read list
//                        Intent i = new Intent(BookActivity.this, AlreadyReadBookActivity.class);
//                        startActivity(i);
                    } else {
                        Toast.makeText(BookActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
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