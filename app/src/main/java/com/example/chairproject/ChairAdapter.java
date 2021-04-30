package com.example.chairproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChairAdapter extends
        RecyclerView.Adapter<ChairAdapter.ChairViewHolder> {
    private Context context;
    private List<Chair> chairs ;

    public ChairAdapter(Context context) {
        this.context = context;
    }
    public void setData(List<Chair> chairs ){
        this.chairs = chairs;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ChairAdapter.ChairViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chair,parent,false);
        return new ChairViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChairAdapter.ChairViewHolder holder, int position) {
        Chair chair = chairs.get(position);
        if(chair == null){
            return;
        }
        holder.tvName.setText(chair.getName());
        holder.tvPrice.setText(chair.getPrice());
        holder.imgChair.setImageResource(chair.getImg());
        holder.imgChair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DetailChair.class);
                /*intent.putExtra("img",chairs.get(position).getImg());
                intent.putExtra("name",chairs.get(position).getName());
                intent.putExtra("price",chairs.get(position).getPrice());*/
                intent.putExtra("id", chairs.get(position).getId());
                context.startActivity(intent);

            }
        });


    }
    @Override
    public int getItemCount() {
        if(chairs !=null){
            return chairs.size();
        }
        return 0;
    }

    public class ChairViewHolder extends RecyclerView.ViewHolder {
        ImageView imgChair;
        TextView tvName,tvPrice;
        public ChairViewHolder(@NonNull View itemView) {
            super(itemView);
            imgChair = itemView.findViewById(R.id.anhGhe);
            tvName = itemView.findViewById(R.id.tvName);
            tvPrice = itemView.findViewById(R.id.tvPrice);
        }
    }
}
