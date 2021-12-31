package com.example.ratingapp.item;

import android.content.Context;
import android.content.SharedPreferences;

public class Order {
    private final SharedPreferences order, orderID;

    public Order(Context context){
        order = context.getSharedPreferences("order", 0);
        orderID = context.getSharedPreferences("orderID", 0);
    }

    public void setOrderID(int id){
        this.orderID.edit().putInt("id", id).apply();
    }

    public int getOrderID(String key){
        return this.orderID.getInt("id", 1);
    }

    public void setOrderFoodAmount(String key, int amount){
        this.order.edit().putInt(key, amount).apply();
    }

    public int getOrderFoodAmount(String key){
        return this.order.getInt(key, 0);
    }

    public void clearOrder(){
        this.order.edit().clear().apply();
    }

}
