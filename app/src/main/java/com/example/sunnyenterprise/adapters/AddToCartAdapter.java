package com.example.sunnyenterprise.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sunnyenterprise.R;
import com.example.sunnyenterprise.model.cartListModel.CartList;
import com.example.sunnyenterprise.model.categoryModel.Category;
import com.example.sunnyenterprise.model.productDetailModel.Size;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AddToCartAdapter extends RecyclerView.Adapter<AddToCartAdapter.ViewHolder> {
    LayoutInflater inflater;
    List<CartList> cartLists;

    public AddToCartAdapter(Context mContext, List<CartList> cartLists) {
        this.cartLists = cartLists;
        this.inflater = LayoutInflater.from(mContext);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.add_to_cart_grid_layout, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.ctitle.setText(cartLists.get(position).getName());
        holder.ccolor.setText(cartLists.get(position).getColorName());
        holder.cQuantity.setText("Item: " + cartLists.get(position).getQuantity());
        holder.cSizeCode.setText(cartLists.get(position).getSizeCode());

        Picasso.get()
                .load(cartLists.get(position).getImageUrl())
                .fit()
                .into(holder.cgridIcon);

    }

    @Override
    public int getItemCount() {
        return cartLists.size();
    }

    public void setData(List<CartList> cartLists) {
        this.cartLists = cartLists;
        notifyDataSetChanged();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView ctitle, ccolor, cQuantity, cSizeCode;
        ImageView cgridIcon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ctitle = itemView.findViewById(R.id.textViewAddToCart);
            cgridIcon = itemView.findViewById(R.id.imageViewAddToCart);
            ccolor = itemView.findViewById(R.id.colorText);
            cQuantity = itemView.findViewById(R.id.tvQuantity);
            cSizeCode = itemView.findViewById(R.id.tvSizeCode);

        }

    }
}
