package com.example.chairproject;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class ChairAPI extends Application {
    public static List<Chair> listItem;
    private static ChairAPI instance =null;
    public List<Chair> getListItem(){
            return listItem;
    }
    public void setListItem(List<Chair> listItem) {
        this.listItem = listItem;
    }

    public ChairAPI() {
        listItem = new ArrayList<>();
    }
    public static ChairAPI getInstance(){
        if(instance == null){
            instance = new ChairAPI();
        }
        return instance;
    }
    public void addItem(Chair item){
        this.listItem.add(item);
    }
}
