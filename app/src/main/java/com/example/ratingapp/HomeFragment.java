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
import com.example.ratingapp.adapter.AllMenuAdapter;
import com.example.ratingapp.adapter.PopularAdapter;
import com.example.ratingapp.adapter.RecommendedAdapter;
import com.example.ratingapp.model.Allmenu;
import com.example.ratingapp.model.Popular;
import com.example.ratingapp.model.Recommended;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private RecyclerView popularRecyclerView, recommendedRecyclerView, allMenuRecyclerView;

    private PopularAdapter popularAdapter;
    private RecommendedAdapter recommendedAdapter;
    private AllMenuAdapter allMenuAdapter;

    private ArrayList<Popular> popularList = new ArrayList<>();
    private ArrayList<Recommended> recommendedList = new ArrayList<>();
    private List<Allmenu> allmenuList = new ArrayList<>();

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

        popularList.add(new Popular("food1", 0, "4.5", "20 min", "Free", "150", ""));
        popularList.add(new Popular("food2", 0, "4.5", "20 min", "Free", "150", ""));
        popularList.add(new Popular("food3", 0, "4.5", "20 min", "Free", "150", ""));
        popularList.add(new Popular("food4", 0, "4.5", "20 min", "Free", "150", ""));
        popularList.add(new Popular("food5", 0, "4.5", "20 min", "Free", "150", ""));

        recommendedList.add(new Recommended("food1", 0, "4.5", "20 min", "Free", "150", ""));
        recommendedList.add(new Recommended("food2", 0, "4.5", "20 min", "Free", "150", ""));
        recommendedList.add(new Recommended("food3", 0, "4.5", "20 min", "Free", "150", ""));
        recommendedList.add(new Recommended("food4", 0, "4.5", "20 min", "Free", "150", ""));
        recommendedList.add(new Recommended("food5", 0, "4.5", "20 min", "Free", "150", ""));

        allmenuList.add(new Allmenu("food1", 0, "4.5", "20 min", "Free", "150", ""));
        allmenuList.add(new Allmenu("food2", 0, "4.5", "20 min", "Free", "150", ""));
        allmenuList.add(new Allmenu("food3", 0, "4.5", "20 min", "Free", "150", ""));
        allmenuList.add(new Allmenu("food4", 0, "4.5", "20 min", "Free", "150", ""));
        allmenuList.add(new Allmenu("food5", 0, "4.5", "20 min", "Free", "150", ""));


        getPopularData(popularList);
        getRecommendedData(recommendedList);
        getAllMenu(allmenuList);

    }

    private void getPopularData(List<Popular> popularList){

        popularRecyclerView = getView().findViewById(R.id.popular_recycler);
        popularAdapter = new PopularAdapter(getActivity(), popularList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        popularRecyclerView.setLayoutManager(layoutManager);
        popularRecyclerView.setAdapter(popularAdapter);

    }

    private void  getRecommendedData(List<Recommended> recommendedList){

        recommendedRecyclerView = getView().findViewById(R.id.recommended_recycler);
        recommendedAdapter = new RecommendedAdapter(getActivity(), recommendedList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recommendedRecyclerView.setLayoutManager(layoutManager);
        recommendedRecyclerView.setAdapter(recommendedAdapter);

    }

    private void  getAllMenu(List<Allmenu> allmenuList){

        allMenuRecyclerView = getView().findViewById(R.id.all_menu_recycler);
        allMenuAdapter = new AllMenuAdapter(getActivity(), allmenuList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        allMenuRecyclerView.setLayoutManager(layoutManager);
        allMenuRecyclerView.setAdapter(allMenuAdapter);
        allMenuAdapter.notifyDataSetChanged();

    }
}