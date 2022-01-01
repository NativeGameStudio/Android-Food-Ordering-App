package com.example.ratingapp.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.example.ratingapp.FoodActivity;
import com.example.ratingapp.item.Food;
import com.example.ratingapp.R;
import java.util.List;

/** Use this adapter to
 *  manage popular item
 */
public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.PopularViewHolder> {
    private final Activity activity;
    private final List<Food> popularList;

    public PopularAdapter(Activity activity, List<Food> popularList) {
        this.activity = activity;
        this.popularList = popularList;
    }

    @NonNull
    @Override
    public PopularViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Create a layout for recyclerview cell items
        View view = LayoutInflater.from(activity).inflate(R.layout.popular_recycler_items, parent, false);

        return new PopularViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        holder.popularName.setText(popularList.get(position).getName());
        holder.popularPrice.setText("$ "+ String.valueOf(popularList.get(position).getPrice()));
        holder.popularDeliveryTime.setText(popularList.get(position).getDeliveryTime());
        holder.popularRating.setText(popularList.get(position).getRating());
        if(popularList.get(position).getDeliveryCharges() == 0){
            holder.popularCharges.setText("Free Delivery");
        }else {
            holder.popularCharges.setText("$ " + popularList.get(position).getDeliveryCharges());
        }
        holder.popularImage.setImageResource(popularList.get(position).getImageUrl());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Send data to food page
                Intent i = new Intent(activity, FoodActivity.class);
                i.putExtra("name", popularList.get(position).getName());
                i.putExtra("price", popularList.get(position).getPrice());
                i.putExtra("rating", popularList.get(position).getRating());
                i.putExtra("image", popularList.get(position).getImageUrl());

                // Share element animation
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        activity, holder.popularImage, ViewCompat.getTransitionName(holder.popularImage));

                activity.startActivity(i, options.toBundle());

            }
        });

    }

    @Override
    public int getItemCount() {
        return popularList.size();
    }

    public static class PopularViewHolder extends RecyclerView.ViewHolder{
        private final TextView popularName, popularRating, popularDeliveryTime, popularCharges, popularPrice;
        private final ImageView popularImage;

        public PopularViewHolder(@NonNull View itemView) {
            super(itemView);

            popularName = itemView.findViewById(R.id.popular_name);
            popularRating = itemView.findViewById(R.id.popular_rating);
            popularDeliveryTime = itemView.findViewById(R.id.popular_delivery_time);
            popularCharges = itemView.findViewById(R.id.popular_delivery_type);
            popularPrice = itemView.findViewById(R.id.popular_price);
            popularImage = itemView.findViewById(R.id.popular_image);

        }
    }


}
