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
import com.example.ratingapp.adapter.OrderAdapter;
import com.example.ratingapp.item.Order;
import java.util.ArrayList;
import java.util.List;

/** Use this fragment to
 *  manage order page
 */
public class OrderFragment extends Fragment {
    private RecyclerView orderRecyclerView;
    private OrderAdapter orderAdapter;
    private final ArrayList<Order> orderList = new ArrayList<>();

    public OrderFragment() {
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
        return inflater.inflate(R.layout.fragment_order, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Check is order exist
        Order order = new Order(getActivity());
        if(order.getOrderID("id") != 0) {
            orderList.add(order);
            getOrderData(orderList);
        }

    }

    private void getOrderData(List<Order> orderList){

        orderRecyclerView = getView().findViewById(R.id.order_recycler);
        orderAdapter = new OrderAdapter(getActivity(), orderList, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        orderRecyclerView.setLayoutManager(layoutManager);
        orderRecyclerView.setAdapter(orderAdapter);

    }

    public void showRatingDialog(){
        RatingDialogFragment dialogFragment = new RatingDialogFragment();
        dialogFragment.show(getActivity().getSupportFragmentManager(), "");
    }
}