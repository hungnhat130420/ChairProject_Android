package com.example.chairproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ChairAdapter chairAdapter;
    public static List<Chair> chairs ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
    }
    private void addControls(){
        chairs = loadData();
        chairAdapter = new ChairAdapter(this);
        chairAdapter.setData(chairs);
        recyclerView =findViewById(R.id.rcv);
        recyclerView.setAdapter(chairAdapter);
//      xét chiều ngang  recyclerView.setLayoutManager(new GridLayoutManager(this,1,GridLayoutManager.HORIZONTAL,false));
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
    }
    private List<Chair> loadData(){
        List<Chair> chairList = new ArrayList<>();
        chairList.add(new Chair(1,R.drawable.orange_chair,"Matteo Armchair","$550"));
        chairList.add(new Chair(2,R.drawable.yellow_chair,"Morden Armchair","$350"));
        chairList.add(new Chair(3,R.drawable.purple_chair,"Nice Armchair","$250"));
        chairList.add(new Chair(4,R.drawable.brown_chair,"Circle Armchair","$350"));
        return chairList;
    }

}