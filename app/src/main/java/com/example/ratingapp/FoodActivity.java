package com.example.ratingapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

/** Now we will get data from intent and set to UI
 **/

public class FoodActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView itemName, itemPrice, itemRating;
    private RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        Intent intent = getIntent();

        int imageUrl = intent.getIntExtra("image", 0);
        String name = intent.getStringExtra("name");
        String price = intent.getStringExtra("price");
        String rating = intent.getStringExtra("rating");


        imageView = findViewById(R.id.food_image);
        itemName = findViewById(R.id.name);
        itemPrice = findViewById(R.id.price);
        itemRating = findViewById(R.id.rating);
        ratingBar = findViewById(R.id.ratingBar);

        imageView.setImageResource(imageUrl);
        itemName.setText(name);
        itemPrice.setText("$ "+ price);
        itemRating.setText(rating);
        ratingBar.setRating(Float.parseFloat(rating));

    }
}
