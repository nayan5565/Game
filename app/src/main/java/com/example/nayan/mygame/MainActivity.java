package com.example.nayan.mygame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Model> arrayList = new ArrayList<>();
    RecyclerView view;
    MyRecyclerAdapter adapter;
    Model model;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        addData();
    }

    public void init(){

        adapter=new MyRecyclerAdapter(this);
        view=(RecyclerView)findViewById(R.id.recAd);
        view.setLayoutManager(new GridLayoutManager(this,2));
        view.setAdapter(adapter);
    }

    public void addData(){
        model =new Model();
        model.setId(1);
        model.setType(2);

        arrayList.add(model);

        model=new Model();
        model.setId(2);
        model.setType(2);
        arrayList.add(model);

        model=new Model();
        model.setId(3);
        model.setType(3);
        arrayList.add(model);

        model=new Model();
        model.setId(4);
        model.setType(3);
        arrayList.add(model);

        adapter.setData(arrayList);


    }

}
