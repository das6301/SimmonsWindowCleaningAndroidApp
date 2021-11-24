package com.das6301.simmonswindowcleaning;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class myAdapter extends RecyclerView.Adapter<myAdapter.MyViewHolder>{

    String data1[], data2[];
    Context context;

    public myAdapter(Context ct, String services[], String servicesDesc[]){
        context = ct;
        data1 = services;
        data2 = servicesDesc;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.mytext1.setText(data1[position]);
        holder.mytext2.setText(data2[position]);

    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView mytext1, mytext2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            mytext1 = itemView.findViewById(R.id.my_row_services_requestedTV);
            mytext2 = itemView.findViewById(R.id.my_row_services_requested_descriptionTV);


        }


    }
    /* END OF MyViewHolder CLASS!!! */



}
