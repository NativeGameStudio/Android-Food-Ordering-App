package com.example.ratingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ratingapp.adapter.CartAdapter;
import com.example.ratingapp.fragment.OrderFragment;
import com.example.ratingapp.item.Cart;
import com.example.ratingapp.item.Food;
import com.example.ratingapp.item.FoodList;
import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {
    private RecyclerView cartRecyclerView;
    private CartAdapter cartAdapter;
    private final ArrayList<Food> cartList = new ArrayList<>();
    private Cart cart;

    private TextView txtTotalFood, txtDelivery, txtTotal;
    private Button btnCheckout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cart = new Cart(this);
        FoodList foodList = new FoodList();

        for(Food food : foodList.getAllFoodList()){
            if(cart.getFoodAmount(food.getName()) > 0){
                cartList.add(food);
            }
        }

        initView();
        calculateFee();
        getCartData(cartList);
    }

    private void initView(){

        // back button
        ImageView btnBack = findViewById(R.id.cart_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CartActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        txtTotalFood = findViewById(R.id.txt_totalFood);
        txtDelivery = findViewById(R.id.txt_delivery);
        txtTotal = findViewById(R.id.txt_total);
        btnCheckout = findViewById(R.id.btn_checkout);
        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // store data from cart to order
                // Order order = new Order();
                cart.clearFood();

                // go to order
                Intent i = new Intent(CartActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

    }

    private void getCartData(List<Food> cartList){

        cartRecyclerView = findViewById(R.id.cart_recycler);
        cartAdapter = new CartAdapter(this, cartList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        cartRecyclerView.setLayoutManager(layoutManager);
        cartRecyclerView.setAdapter(cartAdapter);

    }

    public void calculateFee(){
        int totalFood = 0;
        for(Food food : cartList){
            totalFood += food.getPrice() * cart.getFoodAmount(food.getName());
        }
        txtTotalFood.setText("$ " + String.valueOf(totalFood));

        int totalDelivery = 0;
        for(Food food : cartList){
            totalDelivery += food.getDeliveryCharges() * cart.getFoodAmount(food.getName());
        }
        txtDelivery.setText("$ " + String.valueOf(totalDelivery));

        txtTotal.setText("$ " + String.valueOf(totalFood + totalDelivery));
    }
}