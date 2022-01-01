package com.example.ratingapp.item;

import com.example.ratingapp.R;
import java.util.ArrayList;

/** Use this class to manage
 *  <Food> , <Category> ,
 *  popular items and recommend items
 */
public class FoodList {
    private final ArrayList<Category>categoryList = new ArrayList<>();
    private final ArrayList<Food>allFoodList = new ArrayList<>();
    private final ArrayList<Food>popularList = new ArrayList<>();
    private final ArrayList<Food>recommendList = new ArrayList<>();

    public FoodList(){
        // Add category item here
        categoryList.add(new Category("Burger", R.drawable.category_1));
        categoryList.add(new Category("Pizza", R.drawable.category_2));
        categoryList.add(new Category("Drinks", R.drawable.category_3));
        categoryList.add(new Category("Others", R.drawable.category_others));

        // Add all food here
        allFoodList.add(new Food("Cheeses Burger", R.drawable.burger_2, "4.5", "20 min", 0, 150, ""));
        allFoodList.add(new Food("Bacon Burger", R.drawable.burger_1, "4.8", "20 min", 0, 150, ""));
        allFoodList.add(new Food("Chicken Burger", R.drawable.burger_3, "4.0", "20 min", 0, 150, "Spicy"));
        allFoodList.add(new Food("Pepperoni Pizza", R.drawable.pizza_1, "4.5", "30 min", 5, 350, ""));
        allFoodList.add(new Food("Margherita Pizza", R.drawable.pizza_2, "4.3", "30 min", 5, 350, "3 Cheese"));
        allFoodList.add(new Food("Deluxe Pizza", R.drawable.pizza_3, "4.1", "30 min", 5, 350, ""));
        allFoodList.add(new Food("Cola", R.drawable.drink_1, "3.8", "10 min", 0, 100, ""));
        allFoodList.add(new Food("Orange Juice", R.drawable.drink_3, "3.5", "10 min", 0, 100, ""));
        allFoodList.add(new Food("CockTail", R.drawable.drink_2, "4.0", "10 min", 0, 100, ""));

        // Add popular item here
        popularList.add(allFoodList.get(1));
        popularList.add(allFoodList.get(3));
        popularList.add(allFoodList.get(4));
        popularList.add(allFoodList.get(8));

        // Add recommend item here
        recommendList.add(allFoodList.get(0));
        recommendList.add(allFoodList.get(2));
        recommendList.add(allFoodList.get(5));
        recommendList.add(allFoodList.get(1));
        recommendList.add(allFoodList.get(4));
        recommendList.add(allFoodList.get(6));
        recommendList.add(allFoodList.get(7));

    }

    public ArrayList<Food> getAllFoodList(){
        return allFoodList;
    }

    public ArrayList<Category> getCategoryList(){
        return categoryList;
    }

    public ArrayList<Food> getPopularList(){
        return popularList;
    }

    public ArrayList<Food> getRecommendList(){
        return recommendList;
    }

}
