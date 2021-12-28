package com.example.ratingapp.item;

import java.util.ArrayList;

public class Order {

    private final ArrayList<Food> foodList;
    private final ArrayList<Integer> food_amount_list;

    public Order(){
        this.foodList = new ArrayList<>();
        this.food_amount_list = new ArrayList<>();
    }

    public void addFood(Food food, int amount){
        this.foodList.add(food);
        this.food_amount_list.add(amount);
    }

    public void deleteFood(Food food){

        for(int i = 0; i < foodList.size(); i++){
            if(foodList.get(i).equals(food)){
                this.food_amount_list.remove(i);
                break;
            }
        }

        this.foodList.remove(food);
    }

    public void destroyOrder(){
        this.foodList.clear();
        this.food_amount_list.clear();
    }

}
