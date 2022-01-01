package com.example.ratingapp.item;

import android.content.Context;
import android.content.SharedPreferences;

/** Use the key "food"
 *  to get cart data
 */
public class Cart {
    private final SharedPreferences cart;

    public Cart(Context context){
        cart = context.getSharedPreferences("food", 0);
    }

    public void setFoodAmount(String key, int amount){
        this.cart.edit().putInt(key, amount).apply();
    }

    public int getFoodAmount(String key){
        return this.cart.getInt(key, 0);
    }

    public void deleteFood(String key){
        this.cart.edit().remove(key).apply();
    }

    public void clearFood(){
        this.cart.edit().clear().apply();
    }
}
