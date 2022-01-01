package com.example.ratingapp.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.ratingapp.item.Cart;
import com.example.ratingapp.CartActivity;
import com.example.ratingapp.R;
import com.example.ratingapp.item.Food;
import java.util.List;

/** Use this adapter to
 *  manage cart item
 */
public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    private final List<Food> cartList;
    private final Cart cart;
    private final CartActivity cartActivity;

    public CartAdapter(CartActivity cartActivity, List<Food> cartList) {
        this.cartActivity = cartActivity;
        this.cartList = cartList;
        this.cart = new Cart(cartActivity);

    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Create a layout for recyclerview cell items
        View view = LayoutInflater.from(cartActivity).inflate(R.layout.cart_recycler_items, parent, false);

        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        holder.cartImage.setImageResource(cartList.get(position).getImageUrl());
        holder.cartName.setText(cartList.get(position).getName());
        holder.cartAmount.setText(String.valueOf(holder.amount));
        holder.cartPrice.setText("$ "+ cartList.get(position).getPrice());

        // Button to add food amount
        holder.cartAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // add amount
                holder.amount ++;
                holder.cartAmount.setText(String.valueOf(holder.amount));

                // data
                cart.setFoodAmount(cartList.get(position).getName(), holder.amount);

                // text
                cartActivity.calculateFee();
            }
        });

        // Button to reduce food amount
        holder.cartReduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(holder.amount > 1){

                    // reduce amount
                    holder.amount --;
                    holder.cartAmount.setText(String.valueOf(holder.amount));

                    // data
                    cart.setFoodAmount(cartList.get(position).getName(), holder.amount);

                    // text
                    cartActivity.calculateFee();
                }
            }
        });

        // Long click to delete food
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                // Delete date
                cart.deleteFood(cartList.get(position).getName());

                // Remove view
                cartList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, cartList.size());

                // Calculate fee
                cartActivity.calculateFee();

                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    public static class CartViewHolder extends RecyclerView.ViewHolder{
        private final ImageView cartImage;
        private final TextView cartName, cartAmount, cartPrice, cartAdd, cartReduce;
        private int amount = 1; // Food amount

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);

            cartImage = itemView.findViewById(R.id.order_image);
            cartName = itemView.findViewById(R.id.cart_name);
            cartAmount = itemView.findViewById(R.id.cart_amount);
            cartPrice = itemView.findViewById(R.id.cart_price);
            cartAdd = itemView.findViewById(R.id.cart_add);
            cartReduce = itemView.findViewById(R.id.cart_reduce);

        }
    }
}

