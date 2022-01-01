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
import com.example.ratingapp.R;
import com.example.ratingapp.item.Food;
import java.util.List;

/** Use this adapter to
 *  manage recommend item
 */
public class RecommendAdapter extends RecyclerView.Adapter<RecommendAdapter.RecommendViewHolder> {
    private final Activity activity;
    private final List<Food> recommendList;

    public RecommendAdapter(Activity activity, List<Food> recommendList) {
        this.activity = activity;
        this.recommendList = recommendList;
    }

    @NonNull
    @Override
    public RecommendViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Create a layout for recyclerview cell items
        View view = LayoutInflater.from(activity).inflate(R.layout.recommend_recycler_items, parent, false);

        return new RecommendViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecommendViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        holder.recommendName.setText(recommendList.get(position).getName());
        holder.recommendPrice.setText("$ "+ recommendList.get(position).getPrice());
        holder.recommendDeliveryTime.setText(recommendList.get(position).getDeliveryTime());
        holder.recommendRating.setText(recommendList.get(position).getRating());
        if(recommendList.get(position).getDeliveryCharges() == 0){
            holder.recommendCharges.setText("Free Delivery");
        }else {
            holder.recommendCharges.setText("$ " + recommendList.get(position).getDeliveryCharges());
        }
        holder.recommendImage.setImageResource(recommendList.get(position).getImageUrl());
        holder.recommendNote.setText(recommendList.get(position).getNote());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Send data to food page
                Intent i = new Intent(activity, FoodActivity.class);
                i.putExtra("name", recommendList.get(position).getName());
                i.putExtra("price", recommendList.get(position).getPrice());
                i.putExtra("rating", recommendList.get(position).getRating());
                i.putExtra("image", recommendList.get(position).getImageUrl());

                // Share element animation
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        activity, holder.recommendImage, ViewCompat.getTransitionName(holder.recommendImage));

                activity.startActivity(i, options.toBundle());
            }
        });

    }

    @Override
    public int getItemCount() {
        return recommendList.size();
    }

    public static class RecommendViewHolder extends RecyclerView.ViewHolder{
        private final TextView recommendName, recommendNote, recommendRating, recommendDeliveryTime, recommendCharges, recommendPrice;
        private final ImageView recommendImage;

        public RecommendViewHolder(@NonNull View itemView) {
            super(itemView);

            recommendName = itemView.findViewById(R.id.recommend_name);
            recommendNote = itemView.findViewById(R.id.recommend_note);
            recommendCharges = itemView.findViewById(R.id.recommend_delivery_charge);
            recommendRating = itemView.findViewById(R.id.recommend_rating);
            recommendDeliveryTime = itemView.findViewById(R.id.recommend_delivery_time);
            recommendPrice = itemView.findViewById(R.id.recommend_price);
            recommendImage = itemView.findViewById(R.id.recommend_image);
        }
    }

}
