package com.example.ratingapp;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.ratingapp.adapter.RecommendAdapter;
import com.example.ratingapp.adapter.CategoryAdapter;
import com.example.ratingapp.adapter.PopularAdapter;
import com.example.ratingapp.item.Category;
import com.example.ratingapp.item.Food;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private RecyclerView categoryRecyclerView, recommendedRecyclerView, allMenuRecyclerView;

    private CategoryAdapter categoryAdapter;
    private PopularAdapter popularAdapter;
    private RecommendAdapter recommendAdapter;

    private final List<Category> categoryList = new ArrayList<>();
    private final List<Food> popularList = new ArrayList<>();
    private final List<Food> recommendList = new ArrayList<>();

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Add category item here
        categoryList.add(new Category("Burger", R.drawable.category_1));
        categoryList.add(new Category("Pizza", R.drawable.category_2));
        categoryList.add(new Category("Drinks", R.drawable.category_3));
        categoryList.add(new Category("Others", R.drawable.category_others));

        //Add popular item here
        popularList.add(new Food("Bacon Burger", R.drawable.burger_1, "4.8", "20 min", "Free Delivery", "150", ""));
        popularList.add(new Food("Pepperoni Pizza", R.drawable.pizza_1, "4.5", "30 min", "$ 5", "350", ""));
        popularList.add(new Food("Margherita Pizza", R.drawable.pizza_2, "4.3", "30 min", "$ 5", "350", ""));
        popularList.add(new Food("CockTail", R.drawable.drink_2, "4.0", "10 min", "Free Delivery", "100", ""));

        //Add recommend item here
        recommendList.add(new Food("Cheeses Burger", R.drawable.burger_2, "4.5", "20 min", "Free Delivery", "150", ""));
        recommendList.add(new Food("Chicken Burger", R.drawable.burger_3, "4.0", "20 min", "Free Delivery", "150", "Spicy"));
        recommendList.add(new Food("Deluxe Pizza", R.drawable.pizza_3, "4.1", "30 min", "$ 5", "350", ""));
        recommendList.add(new Food("Bacon Burger", R.drawable.burger_1, "4.8", "20 min", "Free Delivery", "150", ""));
        recommendList.add(new Food("Margherita Pizza", R.drawable.pizza_2, "4.3", "30 min", "$ 5", "350", "3 Cheese"));
        recommendList.add(new Food("Cola", R.drawable.drink_1, "3.8", "10 min", "Free Delivery", "100", ""));
        recommendList.add(new Food("Orange Juice", R.drawable.drink_3, "3.5", "10 min", "Free Delivery", "100", ""));


        getCategoryData(categoryList);
        getPopularData(popularList);
        getRecommendMenu(recommendList);

    }

    private void getCategoryData(List<Category> categoryList){

        categoryRecyclerView = getView().findViewById(R.id.popular_recycler);
        categoryAdapter = new CategoryAdapter(getActivity(), categoryList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        categoryRecyclerView.setLayoutManager(layoutManager);
        categoryRecyclerView.setAdapter(categoryAdapter);

    }

    private void getPopularData(List<Food> popilarList){

        recommendedRecyclerView = getView().findViewById(R.id.recommended_recycler);
        popularAdapter = new PopularAdapter(getActivity(), popilarList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recommendedRecyclerView.setLayoutManager(layoutManager);
        recommendedRecyclerView.setAdapter(popularAdapter);

    }

    private void getRecommendMenu(List<Food> recommendList){

        allMenuRecyclerView = getView().findViewById(R.id.all_menu_recycler);
        recommendAdapter = new RecommendAdapter(getActivity(), recommendList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        allMenuRecyclerView.setLayoutManager(layoutManager);
        allMenuRecyclerView.setAdapter(recommendAdapter);
        //recommendAdapter.notifyDataSetChanged();

    }
}