package com.example.ratingapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.ratingapp.R;
import com.example.ratingapp.fragment.OrderFragment;
import com.example.ratingapp.item.Order;
import java.util.List;

/** Use this adapter to
 *  manage order item
 */
public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {
    private final List<Order> orderList;
    private final Context context;
    private final OrderFragment orderFragment;

    public OrderAdapter(Context context, List<Order> orderList, OrderFragment orderFragment) {
        this.context = context;
        this.orderList = orderList;
        this.orderFragment = orderFragment;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Create a layout for recyclerview cell items
        View view = LayoutInflater.from(context).inflate(R.layout.order_recycler_items, parent, false);

        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        holder.orderID.setText("Order ID: " + orderList.get(position).getOrderID("id"));
        holder.orderPrice.setText("$ " + orderList.get(position).getOrderPrice("price"));

        holder.orderComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // clear order
                orderList.get(position).clearOrder();

                //remove view
                orderList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, orderList.size());

                // go to rating dialog
                orderFragment.showRatingDialog();

            }
        });

    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public static class OrderViewHolder extends RecyclerView.ViewHolder{
        private final TextView orderID, orderPrice, orderState;
        private final Button orderComplete;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);

            orderID = itemView.findViewById(R.id.order_id);
            orderPrice = itemView.findViewById(R.id.order_price);
            orderState = itemView.findViewById(R.id.order_state);
            orderComplete = itemView.findViewById(R.id.order_complete);

        }
    }
}
