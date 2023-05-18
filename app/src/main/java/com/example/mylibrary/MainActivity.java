package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), AllBooksActivity.class);
                startActivity(i);
            }
        });

    }
    }

//    public void goToLib(View view) {
//        Intent intent = new Intent(MainActivity.this, AllBooksActivity.class);
//        startActivity(intent);
//    }
//}