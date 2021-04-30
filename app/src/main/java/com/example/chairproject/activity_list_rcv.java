package com.example.chairproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class activity_list_rcv extends AppCompatActivity {
    private RecyclerView recyclerView ;
    private CardItemAdapter cardItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);
        addControl();
    }
    private void addControl(){

        cardItemAdapter = new CardItemAdapter(this);
        cardItemAdapter.setData(ChairAPI.listItem);
        recyclerView =findViewById(R.id.listrcv);
        recyclerView.setAdapter(cardItemAdapter );
//      xét chiều ngang  recyclerView.setLayoutManager(new GridLayoutManager(this,1,GridLayoutManager.HORIZONTAL,false));
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
    }
}