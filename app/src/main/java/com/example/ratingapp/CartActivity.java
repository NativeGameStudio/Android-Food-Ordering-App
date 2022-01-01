package com.example.ratingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.ratingapp.adapter.CartAdapter;
import com.example.ratingapp.item.Cart;
import com.example.ratingapp.item.Food;
import com.example.ratingapp.item.FoodList;
import com.example.ratingapp.item.Order;
import java.util.ArrayList;
import java.util.List;

/** Now the user will see all the food added in cart.
 *  Use <Cart> to add and get data
 */
public class CartActivity extends AppCompatActivity {
    private RecyclerView cartRecyclerView;
    private CartAdapter cartAdapter;
    private final ArrayList<Food> cartList = new ArrayList<>();
    private Cart cart;
    // View
    private TextView txtTotalFood, txtDelivery, txtTotal;
    private Button btnCheckout;
    // price
    private int totalPrice = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        // Get data
        cart = new Cart(this);
        FoodList foodList = new FoodList();
        for(Food food : foodList.getAllFoodList()){
            if(cart.getFoodAmount(food.getName()) > 0){
                cartList.add(food);
            }
        }

        initView();
        if(cartList.size() > 0){
            calculateFee();
            getCartData(cartList);
        }
    }

    private void initView(){

        // Back button
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
        // If cart has food
        if(cartList.size() > 0) {
            btnCheckout.setEnabled(true);
            btnCheckout.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.teal_700)));
            btnCheckout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    // Store data from cart to order
                    cart.clearFood();
                    Order order = new Order(CartActivity.this);
                    order.setOrderID(1);
                    order.setOrderPrice(totalPrice);
                    order.setOrderState(0);

                    // Go to order
                    Intent i = new Intent(CartActivity.this, MainActivity.class);
                    startActivity(i);
                }
            });
        }

    }

    private void getCartData(List<Food> cartList){

        cartRecyclerView = findViewById(R.id.cart_recycler);
        cartAdapter = new CartAdapter(this, cartList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        cartRecyclerView.setLayoutManager(layoutManager);
        cartRecyclerView.setAdapter(cartAdapter);

    }

    public void calculateFee(){

        // Calculate food fee
        int totalFood = 0;
        for(Food food : cartList){
            totalFood += food.getPrice() * cart.getFoodAmount(food.getName());
        }
        txtTotalFood.setText("$ " + String.valueOf(totalFood));

        // Calculate delivery fee
        int totalDelivery = 0;
        for(Food food : cartList){
            totalDelivery += food.getDeliveryCharges() * cart.getFoodAmount(food.getName());
        }
        txtDelivery.setText("$ " + String.valueOf(totalDelivery));

        // Calculate total fee
        totalPrice = totalFood + totalDelivery;
        txtTotal.setText("$ " + String.valueOf(totalPrice));

        // Change add button state if no food in cart
        if(totalPrice == 0){
            btnCheckout.setEnabled(false);
            btnCheckout.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.gray)));
            btnCheckout.setOnClickListener(null);
        }
    }
}