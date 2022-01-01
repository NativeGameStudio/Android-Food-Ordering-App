package com.example.ratingapp.fragment;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.ratingapp.R;
import com.example.ratingapp.adapter.RecommendAdapter;
import com.example.ratingapp.adapter.CategoryAdapter;
import com.example.ratingapp.adapter.PopularAdapter;
import com.example.ratingapp.item.Category;
import com.example.ratingapp.item.Food;
import com.example.ratingapp.item.FoodList;
import java.util.List;

/** Use this fragment to
 *  manage menu page
 */
public class MenuFragment extends Fragment {
    private RecyclerView categoryRecyclerView, recommendedRecyclerView, allMenuRecyclerView;

    private CategoryAdapter categoryAdapter;
    private PopularAdapter popularAdapter;
    private RecommendAdapter recommendAdapter;

    public MenuFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Use onViewCreated so the content will update everytime the user open
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Food list
        FoodList foodList = new FoodList();
        getCategoryData(foodList.getCategoryList());
        getPopularData(foodList.getPopularList());
        getRecommendMenu(foodList.getRecommendList());

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