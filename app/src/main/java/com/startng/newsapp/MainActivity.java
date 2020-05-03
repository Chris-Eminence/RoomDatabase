package com.startng.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText name;
    EditText surname;
    EditText emailAddress;
    Button savedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.firstName);
        surname = findViewById(R.id.lastName);
        emailAddress = findViewById(R.id.lastName);
        savedButton = findViewById(R.id.savedBtn);

        final AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "production")
                .allowMainThreadQueries()
                .build();

        savedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: Saved to database


                for (int i = 0; i < 10; i++) {

                    User user = new User(name.getText().toString(), surname.getText().toString(), emailAddress.getText().toString());
                    db.userDao().insertAll(user);

                }
                startActivity(new Intent(MainActivity.this, HeadlinesActivity.class));


            }
        });











//        Find textviews, get the extras and assign both to each other
//        TextView textView = findViewById(R.id.textView3);
//        String headline = getIntent().getStringExtra("headline");
//        textView.setText(headline);
    }
}
