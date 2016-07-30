package com.example.nayan.mygame;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by JEWEL on 7/30/2016.
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewAdapter> {
    int count = 0, lastType = 0, id;
    Context context;
    LayoutInflater inflater;
    ArrayList<Model> arrayList;
    Model model;

    public MyRecyclerAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        model = new Model();
    }

    public void setData(ArrayList<Model> arrayList) {
        this.arrayList = arrayList;
        notifyDataSetChanged();
    }

    @Override
    public MyViewAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_list, parent, false);
        MyViewAdapter hAdapter = new MyViewAdapter(view);
        return hAdapter;
    }

    @Override
    public void onBindViewHolder(MyViewAdapter holder, int position) {
        Model model = arrayList.get(position);
        //holder.img.setImageResource(model.getImage());

    }

    @Override
    public int getItemCount() {
        Log.e("fd", "hj" + arrayList.size());
        return arrayList.size();

    }

    class MyViewAdapter extends RecyclerView.ViewHolder {
        ImageView img;

        public MyViewAdapter(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.imageOn);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    model = arrayList.get(getAdapterPosition());
                    Toast.makeText(context, "" + model.getType(), Toast.LENGTH_SHORT).show();

                    matchClick(model);
                }
            });
        }

        //count=1,id=same,lastType=same after first time on image click & also Second time click on same image
        public void matchClick(Model model) {

            if (id == model.getId()) {
                Toast.makeText(context, "same click", Toast.LENGTH_SHORT).show();
                return;
            }
            count++;
            if (count == 2) {
                if (lastType == model.getType()) {
                    Toast.makeText(context, "succes" + model.getType(), Toast.LENGTH_SHORT).show();
                    id = 0;
                    lastType = 0;
                } else {
                    Toast.makeText(context, "lost" + model.getType(), Toast.LENGTH_SHORT).show();
                }

                count = 0;


            }


            id = model.getId();
            lastType = model.getType();


        }
    }
}
