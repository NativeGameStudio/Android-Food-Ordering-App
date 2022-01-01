package com.example.ratingapp.item;

import android.content.Context;
import android.content.SharedPreferences;

/** Use the key "order"
 *  to get order data
 */
public class Order {
    private final SharedPreferences order;

    public Order(Context context){
        order = context.getSharedPreferences("order", 0);
    }

    public void setOrderID(int id){
        this.order.edit().putInt("id", id).apply();
    }

    public int getOrderID(String key){
        return this.order.getInt("id", 0);
    }

    // state: 0 for delivering, 1 for order complete
    public void setOrderState(int key){
        this.order.edit().putInt("state", key).apply();
    }

    public int getOrderState(String key){
        return this.order.getInt("state", 0);
    }

    public void setOrderPrice(int key){
        this.order.edit().putInt("price", key).apply();
    }

    public int getOrderPrice(String key){
        return this.order.getInt("price", 0);
    }

    public void clearOrder(){
        this.order.edit().clear().apply();
    }

}
