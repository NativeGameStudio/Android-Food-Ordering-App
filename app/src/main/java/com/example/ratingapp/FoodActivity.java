package com.example.ratingapp;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.ratingapp.item.Cart;

/** Now we will get data from intent,
 *  and set to UI
 **/
public class FoodActivity extends AppCompatActivity {

    private ImageView foodImage, btnBack;
    private TextView foodName, foodPrice, foodRating;
    private RatingBar ratingBar;
    private Button btnAdd;
    private Cart cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        this.initView();

    }

    private void initView(){
        Intent intent = getIntent();

        int imageUrl = intent.getIntExtra("image", 0);
        String name = intent.getStringExtra("name");
        int price = intent.getIntExtra("price", 0);
        String rating = intent.getStringExtra("rating");

        foodImage = findViewById(R.id.food_image);
        foodName = findViewById(R.id.name);
        foodPrice = findViewById(R.id.price);
        foodRating = findViewById(R.id.rating);
        ratingBar = findViewById(R.id.ratingBar);
        btnBack = findViewById(R.id.food_back);

        foodImage.setImageResource(imageUrl);
        foodName.setText(name);
        foodPrice.setText("$ "+ String.valueOf(price));
        foodRating.setText(rating);
        ratingBar.setRating(Float.parseFloat(rating));

        cart = new Cart(this);

        btnAdd = findViewById(R.id.btn_add_to_cart);
        // If cart doesn't has food
        if(cart.getFoodAmount(name) == 0) {
            btnAdd.setEnabled(true);
            btnAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.teal_700)));
            btnAdd.setText("Add to cart");
            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    // data
                    cart.setFoodAmount(name, 1);

                    // back to menu
                    Intent i = new Intent(FoodActivity.this, MainActivity.class);
                    startActivity(i);
                }
            });
        }

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // back to menu
                Intent i = new Intent(FoodActivity.this, MainActivity.class);
                startActivity(i);

            }
        });
    }

}
