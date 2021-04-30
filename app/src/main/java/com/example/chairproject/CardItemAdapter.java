package com.example.chairproject;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CardItemAdapter
        extends RecyclerView.Adapter<CardItemAdapter.CardItemViewHolder> {
    private Context context;
    private List<Chair> itemList;

    public CardItemAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<Chair> itemList){
        this.itemList = itemList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CardItemAdapter.CardItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_card,parent,false);
        return new CardItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardItemAdapter.CardItemViewHolder holder, int position) {
            Chair chair = itemList.get(position);
            if(chair == null){
                return;
            }
            holder.imgChair.setImageResource(chair.getImg());
            holder.txtName.setText(chair.getName());
            holder.txtPrice.setText("$"+chair.getPrice());
            holder.txtCount.setText(chair.getQuantity()+"");

    }

    @Override
    public int getItemCount() {
        if(itemList !=null){
            return itemList.size();
        }
        return 0;
    }

    public class CardItemViewHolder extends RecyclerView.ViewHolder {
        TextView txtName,txtPrice,txtCount;
        ImageView imgChair,btnAdd,btnSub;


        public CardItemViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtcardName);
            txtPrice = itemView.findViewById(R.id.txtcardPrice);
            txtCount = itemView.findViewById(R.id.txt_card_count);
            imgChair = itemView.findViewById(R.id.imgCardChair);
        }
    }
}
